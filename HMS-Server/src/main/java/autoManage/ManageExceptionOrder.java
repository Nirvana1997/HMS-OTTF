package autoManage;

import data.userdata.UserDataImpl;
import database.DataBaseHelper;
import dataservice.userdataservice.UserDataService;
import po.CreditChangePO;

import javax.xml.crypto.Data;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by mac on 2016/12/15.
 */
public class ManageExceptionOrder {

    public static void init(){
        showTimer();
    }

    //java定时器
    private static void showTimer(){
        TimerTask task = new TimerTask() {
            @Override
            public void run()  {
                //执行的动作
                String todayDate = getNowDate();
                UserDataService userDataService = null;
                try {
                    userDataService = new UserDataImpl();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                //将该执行未执行的订单，置为异常
                DataBaseHelper.in("update OrderInfo set orderState = 'exception' where orderState = 'executing' and checkInDate ='" + todayDate + "'");
                ArrayList<String> userIDList = DataBaseHelper.out("select userID from OrderInfo where orderState = 'exception'","userID");
                ArrayList<String> orderIDList = DataBaseHelper.out("select orderID from OrderInfo where orderState = 'exception'","orderID");
                ArrayList<String> priceList = DataBaseHelper.out("select price from OrderInfo where orderState = 'exception'","price");
                for(int i=0;i<userIDList.size();i++){
                    try {
                        //扣除信用值
                        userDataService.subCredit(new CreditChangePO(userIDList.get(i),orderIDList.get(i),todayDate,"没有按时执行",(int)Double.parseDouble(priceList.get(i))));
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        //设置执行时间
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);//每天
        //定制每天的20:00:00执行，
        calendar.set(year, month, day, 20, 00, 00);
        Date date = calendar.getTime();
        Timer timer = new Timer();

        //每天的date时刻执行task, 仅执行一次
        timer.schedule(task, date);
    }

    private static String getNowDate(){
        String result = "";
        //设置日期格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy-M-d");
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        result = df.format(date).toString();
        //转化成需要的日期格式
        result = result.replace("-","_");
        return result;
    }

    public static void main(String[] args) {
        showTimer();
    }
}

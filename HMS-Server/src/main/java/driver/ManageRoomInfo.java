package driver;

import data.hotelsalerdata.HotelroomDataImpl;
import database.DataBaseHelper;
import dataservice.hotelsalerdataservice.HotelroomDataService;
import po.RoomNumPO;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by mac on 2016/12/12.
 */
public class ManageRoomInfo {
    public static void main(String[] args) {
        ManageRoomInfo.init();
    }

    public static void init(){
    }

    public static void update(){

    }

    private static ArrayList<String> getDateList(int day){
        ArrayList<String> dateList = new ArrayList<String>();
        for(int i=0;i<=day;i++) {
            try {
                Date now = new Date();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");//可以方便地修改日期格式
                String date = dateFormat.format(now);
                //通过日历获取下一天日期
                Calendar cal = Calendar.getInstance();
                cal.setTime(dateFormat.parse(date));
                cal.add(Calendar.DAY_OF_YEAR, +i);
                String next = dateFormat.format(cal.getTime());
                next = next.replace("/","_");
                dateList.add(next);
            } catch (Exception e) {
            }
        }
        return dateList;
    }

    private static ArrayList<String> getHotelID(){
        return DataBaseHelper.outSelect("HotelInfo","hotelID");
    }
}

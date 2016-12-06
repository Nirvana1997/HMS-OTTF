package utility;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期操作工具
 * 负责返回两个日期中间的所有日期等操作
 * Created by user on 2016/12/4.
 */
public class DateOperation {
    /**
     * 返回起始日期中间的所有日期
     * @param startDate   起始日期
     * @param endDate     结束日期
     * @return
     */
    public static ArrayList<Date> getDates(Date startDate, Date endDate) {
        ArrayList<Date> result = new ArrayList<Date>();
        //起始日期
        Calendar start = Calendar.getInstance();
        start.setTime(startDate);
        //结束日期
        Calendar end = Calendar.getInstance();
        end.setTime(endDate);

        //加上中间的日期
        while (start.before(end)) {
            result.add(start.getTime());
            start.add(Calendar.DAY_OF_YEAR, 1);
        }
        //补上最后一天
        result.add(endDate);

        return result;
    }

    /**
     * 判断一个日期是否在一段时间内（包含头尾）
     * @param date 被判断日期
     * @param start 开始日期
     * @param end 结束日期
     * @return 是否在期间内
     */
    public static boolean isDuring(Date date,Date start,Date end){
        //在头尾
        if(date.equals(start)||date.equals(end)){
            return true;
        }
        //在期间
        if(date.after(start)&&date.before(end)){
            return true;
        }
        return false;
    }

    /**
     * 把Date对象转化为String
     * 格式为yyyy_MM_dd
     * @param date date对象
     * @return 对应字符串
     */
    public static String dateToString(Date date){
        return new String(date.getYear()+"_"+date.getMonth()+"_"+date.getDate());
    }

    /**
     * 把String转化为date对象
     * 格式为yyyy_MM_dd
     * @param string 字符串
     * @return date对象
     */
    public static Date stringToDate(String string){
        String[] date = string.split("_");
        return new Date(Integer.valueOf(date[0]),Integer.valueOf(date[1]),Integer.valueOf(date[2]));
    }
}

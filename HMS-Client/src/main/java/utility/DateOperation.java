package utility;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
     * 返回起始日期中间的所有日期（不包括结束日期）
     *
     * @param startDate 起始日期
     * @param endDate   结束日期
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

        return result;
    }

    /**
     * 判断一个日期是否在一段时间内（包含头尾）
     *
     * @param date  被判断日期
     * @param start 开始日期
     * @param end   结束日期
     * @return 是否在期间内
     */
    public static boolean isDuring(Date date, Date start, Date end) {
        //在头尾
        if (date.equals(start) || date.equals(end)) {
            return true;
        }
        //在期间
        if (date.after(start) && date.before(end)) {
            return true;
        }
        return false;
    }

    /**
     * 把Date对象转化为String
     * 格式为yyyy_M_d
     *
     * @param date date对象
     * @return 对应字符串
     */
    public static String dateToString(Date date) {
        DateFormat df = new SimpleDateFormat("yyyy_M_d");
        return df.format(date);
    }

    /**
     * 把String转化为date对象
     * 格式为yyyy_M_d
     *
     * @param string 字符串
     * @return date对象
     */
    public static Date stringToDate(String string) {
        DateFormat df = new SimpleDateFormat("yyyy_M_d");
        try {
            return df.parse(string);
        }catch (ParseException e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 在一个时间上加上若干小时
     *
     * @param date  时间
     * @param hours 小时数
     * @return 结果时间
     */
    public static Date addHours(Date date, int hours) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR_OF_DAY, hours);
        return calendar.getTime();
    }

    /**
     * 在一个时间上加上若干小时
     *
     * @param date 时间
     * @param days 小时数
     * @return 结果时间
     */
    public static Date addDays(Date date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, days);
        return calendar.getTime();
    }
}

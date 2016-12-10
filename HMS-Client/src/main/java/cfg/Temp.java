package cfg;

import enumData.SortWay;

/**
 * TODO
 * Created by user on 2016/12/3.
 */
public class Temp {
    /**
     * 会员最大等级
     */
    public static final int MAX_LEVEL = 7;

    /**
     * 最晚执行时间
     */
    public static final int HOUR = 20;

    /**
     * 距离最晚执行订单时间不足time时间撤销，扣除信用值
     */
    public static final int H = 6;

    /**
     * 三间以上特惠
     */
    public static final int DISCOUNT_NUM = 3;

    /**
     * 超过规定时间减少的信用值比例
     */
    public static final double CREDIT_CUT = 0.5;

    public static final String WEB_MANAGER = "00";

    public static final String USER = "01";

    public static final String HOTELSALER = "02";

    public static final String WEB_SALER = "03";

    public static final int ID_NUMBER_LENGTH = 10;

    public static final SortWay sortway = SortWay.Grade_Descending;
}

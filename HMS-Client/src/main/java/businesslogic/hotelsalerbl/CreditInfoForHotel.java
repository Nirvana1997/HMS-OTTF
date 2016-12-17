package businesslogic.hotelsalerbl;

/**
 * 信用值增加接口
 * Created by user on 2016/12/17.
 */
public interface CreditInfoForHotel {
    /**
     * 增加用户信用
     *
     * @param userID 用户编号
     * @param value  增加值
     */
    public void addCredit(String userID, int value);

}

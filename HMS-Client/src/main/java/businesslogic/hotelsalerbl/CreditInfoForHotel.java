package businesslogic.hotelsalerbl;

import enumData.ResultMessage;

import java.rmi.RemoteException;

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
     * @return 是否成功
     */
    public ResultMessage addCredit(String userID, int value)throws RemoteException;

}

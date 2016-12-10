package businesslogic.websalerbl;

import enumData.ResultMessage;

import java.rmi.RemoteException;

/**
 * 信用值接口
 *
 * @author qzh
 *         Created by user on 2016/12/8.
 */
public interface CreditInfo {
    /**
     * 为用户增加信用值
     *
     * @param userID 用户ID
     * @param value  增加的值
     * @return 是否成功
     */
    public ResultMessage addCredit(String userID, int value) throws RemoteException;

    /**
     * 获得对应用户信用值
     *
     * @param userID 用户ID
     * @return 对应信用值
     */
    public int getCredit(String userID) throws RemoteException;
}

package businesslogic.websalerbl;

import businesslogic.userbl.impl.UserDataImpl;
import enumData.ResultMessage;

import java.rmi.RemoteException;

/**
 * 信用值操作模块
 * 负责网站营销人员的添加信用
 *
 * @author qzh
 *         Created by user on 2016/12/8.
 */
public class CreditOperation {
    /**
     * 信用值操作接口
     */
    CreditInfo creditInfo;

    public CreditOperation() {
        this.creditInfo = new UserDataImpl();
    }

    /**
     * 为用户增加信用值
     *
     * @param userID 用户ID
     * @param value  增加的值
     * @return 是否成功
     */
    public ResultMessage addCredit(String userID,int value) throws RemoteException {
        return creditInfo.addCredit(userID,value);
    }

    /**
     * 获得对应用户信用值
     *
     * @param userID 用户ID
     * @return 对应信用值
     */
    public int getCredit(String userID) throws RemoteException {
        return creditInfo.getCredit(userID);
    }
}
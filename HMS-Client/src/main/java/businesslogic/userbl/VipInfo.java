package businesslogic.userbl;

import java.rmi.RemoteException;

/**
 * 会员等级信息接口
 * Created by user on 2016/12/3.
 */
public interface VipInfo {
    /**
     * 计算会员等级
     * @param transaction 交易总额
     * @return 会员等级
     * @throws RemoteException
     */
    public int calcLevel(Double transaction)throws RemoteException;
}

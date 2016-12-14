package utility;

import java.rmi.RemoteException;

/**
 * 会员等级信息接口
 * Created by user on 2016/12/3.
 */
public interface VipInfo {
    /**
     * 计算会员等级
     * @param credit 信用值
     * @return 会员等级
     * @throws RemoteException
     */
    int calcLevel(int credit)throws RemoteException;
}

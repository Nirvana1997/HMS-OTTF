package businesslogic.logbl.interfaces;

import vo.UserInfoVO;

import java.rmi.RemoteException;

/**
 * 用户信息添加接口
 * @author qzh
 * Created by user on 2016/12/11.
 */
public interface UserInfoAdder {
    /**
     * 添加用户信息
     * @param vo 用户个人信息
     * @throws RemoteException
     */
    void addUserInfo(UserInfoVO vo) throws RemoteException;
}

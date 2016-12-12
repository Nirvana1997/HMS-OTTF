package businesslogic.webmanagerbl;

import businesslogic.userbl.UserInfo;
import po.UserInfoPO;
import vo.UserInfoVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * 客户信息管理接口
 *
 * @author qzh
 *         Created by user on 2016/11/22.
 */
public interface UserInfoForManagement {
    /**
     * 获得所有用户信息
     *
     * @return 用户信息列表
     * @throws RemoteException
     */
    public ArrayList<UserInfoPO> getUserList() throws RemoteException;

    /**
     * 获得某个用户的信息
     *
     * @param userID
     * @return 用户信息
     */
    public UserInfoPO getUserInfo(String userID) throws RemoteException;

    /**
     * 设置个人信息
     *
     * @param po 个人信息po
     * @throws RemoteException
     */
    public void setUserInfo(UserInfoPO po) throws RemoteException;
}

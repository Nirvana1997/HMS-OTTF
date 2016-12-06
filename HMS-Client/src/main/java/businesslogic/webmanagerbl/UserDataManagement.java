package businesslogic.webmanagerbl;

import businesslogic.userbl.UserInfo;
import po.UserInfoPO;
import vo.UserInfoVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * 客户信息管理接口
 * @author qzh
 * Created by user on 2016/11/22.
 */
public interface UserDataManagement {
    /**
     * 获得某个用户的信息
     * @param userID
     * @return 用户信息
     */
    public UserInfoPO getUserInfo(String userID) throws RemoteException;

    /**
     * 设置个人信息
     * @param po 个人信息po
     * @throws RemoteException
     */
    public void setUserInfo(UserInfoPO po) throws RemoteException;

    /**
     * 获取用户列表
     * @return 用户列表
     */
    public ArrayList<UserInfoPO> getUserList(ArrayList<String> userIDs)throws RemoteException;
}

package businesslogic.webmanagerbl;

import businesslogic.userbl.impl.UserDataImpl;
import businesslogic.userbl.UserPVChanger;
import vo.UserInfoVO;

import java.rmi.RemoteException;

/**
 * 用户管理模块
 * @author qzh
 */
public class URmanagement{
    /**
     * 用户数据管理模块
     */
    UserDataManagement userDataManagement = new UserDataImpl();

    /**
     * 获取用户信息
     * @param userID 用户ID
     * @return 对应用户信息
     * @throws RemoteException
     */
	public UserInfoVO getUserInfo(String userID) throws RemoteException{
		return UserPVChanger.getInstance().userInfoP2V(userDataManagement.getUserInfo(userID));
	}

    /**
     * 修改用户信息
     * @param vo 用户个人信息vo
     */
	public void setUserInfo(UserInfoVO vo) throws RemoteException {
	    userDataManagement.setUserInfo(UserPVChanger.getInstance().userInfoV2P(vo));
	}

}

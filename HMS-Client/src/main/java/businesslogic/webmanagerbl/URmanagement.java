package businesslogic.webmanagerbl;

import businesslogic.userbl.interfaces.VipInfo;
import businesslogic.userbl.impl.UserDataImpl;
import utility.UserPVChanger;
import businesslogic.websalerbl.impl.VipDataImpl;
import po.UserInfoPO;
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
    UserDataManagement userDataManagement;

    /**
     * 用户等级模块
     */
    VipInfo vipInfo;

    public URmanagement() {
        userDataManagement = new UserDataImpl();
        vipInfo = new VipDataImpl();
    }

    /**
     * 获取用户信息
     * @param userID 用户ID
     * @return 对应用户信息
     * @throws RemoteException
     */
	public UserInfoVO getUserInfo(String userID) throws RemoteException{
        UserInfoPO po = userDataManagement.getUserInfo(userID);
        int vipLevel = vipInfo.calcLevel(po.getCredit());
		return UserPVChanger.userInfoP2V(po,vipLevel);
	}

    /**
     * 修改用户信息
     * @param vo 用户个人信息vo
     */
	public void setUserInfo(UserInfoVO vo) throws RemoteException {
	    userDataManagement.setUserInfo(UserPVChanger.userInfoV2P(vo));
	}

}

package businesslogic.userbl;



import businesslogic.userbl.interfaces.VipInfo;
import businesslogic.websalerbl.impl.VipDataImpl;
import data_stub.userdata.UserDataImpl_stub;
import dataservice.userdataservice.UserDataService;
import enumData.ResultMessage;
import po.UserInfoPO;
import utility.UserPVChanger;
import vo.UserInfoVO;

import java.rmi.RemoteException;

/**
 * 用户信息操作模块
 * 负责更改用户信息和查看个人信息
 * @author xzh
 */
public  class UserInfo{
	/**
	 * 用户数据模块
	 */
	UserDataService userDataService;

	/**
	 * 会员等级模块
	 */
	VipInfo vipInfo;

	public UserInfo() {
		userDataService = new UserDataImpl_stub();
		vipInfo = new VipDataImpl();
	}

	/**
	 * 修改个人信息
	 * @param vo
	 * @return
     */
	public ResultMessage modifyUserInfo(UserInfoVO vo) throws RemoteException{
		UserInfoPO userInfoPO = UserPVChanger.userInfoV2P(vo);
		userDataService.setUserInfo(userInfoPO);
		return ResultMessage.Correct;
	}

	/**
	 * 展示用户个人信息
	 * @param userID
	 * @return
	 */
	public UserInfoVO showUserInfo(String userID)throws RemoteException{
		UserInfoPO po = userDataService.getUserInfo(userID);

		int vipLevel = vipInfo.calcLevel(po.getCredit());

		return UserPVChanger.userInfoP2V(po,vipLevel);

	}
}

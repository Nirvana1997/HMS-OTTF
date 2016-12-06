package businesslogic.userbl;



import businesslogicservice.userblservice.InfoBlService;
import com.sun.jmx.remote.internal.RMIExporter;
import data_stub.userdata.UserDataImpl_stub;
import dataservice.userdataservice.UserDataService;
import enumData.ResultMessage;
import po.UserInfoPO;
import vo.UserInfoVO;

import java.rmi.RemoteException;

/**
 * 用户信息操作模块
 * 负责更改用户信息和查看个人信息
 * @author xzh
 */
public  class UserInfo{
	UserDataService userDataService;

	public UserInfo() {
		userDataService = new UserDataImpl_stub();
	}

	/**
	 * 修改个人信息
	 * @param vo
	 * @return
     */
	public ResultMessage modifyUserInfo(UserInfoVO vo) throws RemoteException{
		UserInfoPO userInfoPO = UserPVChanger.getInstance().userInfoV2P(vo);
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
		//TODO
		return UserPVChanger.getInstance().userInfoP2V(po,0);
	}
}

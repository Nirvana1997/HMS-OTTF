package businesslogic.userbl;



import businesslogicservice.userblservice.InfoBlService;
import data_stub.userdata.UserDataImpl_stub;
import dataservice.userdataservice.UserDataService;
import enumData.ResultMessage;
import po.UserInfoPO;
import vo.UserInfoVO;

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
	public ResultMessage modifyUserInfo(UserInfoVO vo) {
		UserInfoPO userInfoPO = new UserInfoPO(vo.getUserID(),vo.getName(),vo.getIdentity(),vo.getContactNumber(),vo.getCredit(),vo.getTransaction());
		userDataService.setUserInfo(userInfoPO);
		return ResultMessage.Correct;
	}

	/**
	 * 展示用户个人信息
	 * @param userID
	 * @return
	 */
	public UserInfoVO showUserInfo(String userID){
		UserInfoPO po = userDataService.getUserInfo(userID);
		return new UserInfoVO(po.getUserID(),po.getName(),po.getIdentity(),po.getContactNumber(),po.getCredit(),po.getTransaction());
	}
}

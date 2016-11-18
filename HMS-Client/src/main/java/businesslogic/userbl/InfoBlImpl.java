package businesslogic.userbl;



import businesslogicservice.userblservice.InfoBlService;
import data_stub.userdata.UserDataImpl_stub;
import dataservice.userdataservice.UserDataService;
import enumData.ResultMessage;
import po.UserInfoPO;
import vo.UserInfoVO;

/**
 * 用户信息的实现
 * @author xzh
 */
public  class InfoBlImpl implements InfoBlService{
	/**
	 * 修改个人信息
	 * @param vo
	 * @return
     */
	public ResultMessage modifyUserInfo(UserInfoVO vo) {
		UserDataService userDataService = new UserDataImpl_stub();
		UserInfoPO userInfoPO = new UserInfoPO(vo.getUserID(),vo.getName(),vo.getIdentity(),vo.getContactNumber(),vo.getCredit(),vo.getVipLevel());
		userDataService.setUserInfo(userInfoPO);
		System.out.println("修改成功！");
		return ResultMessage.Correct;
	}

}

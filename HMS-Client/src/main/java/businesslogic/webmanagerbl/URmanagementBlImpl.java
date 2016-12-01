package businesslogic.webmanagerbl;

import businesslogicservice.webmanagerlogicservice.URmanagementBlService;
import data_stub.userdata.UserDataImpl_stub;
import dataservice.logdataservice.LogDataService;
import dataservice.userdataservice.UserDataService;
import enumData.ResultMessage;
import po.UserInfoPO;
import vo.UserInfoVO;

import java.rmi.RemoteException;

public class URmanagementBlImpl implements URmanagementBlService{

	UserDataService userDataService = new UserDataImpl_stub();

	public UserInfoVO getUserInfo(String userID) throws RemoteException{
		UserInfoPO po = userDataService.getUserInfo(userID);
		UserInfoVO vo = new UserInfoVO(po.getUserID(),po.getName(),po.getIdentity(),po.getContactNumber(),po.getCredit(),po.getTransaction());
		return vo;
	}

	public ResultMessage setUserInfo(UserInfoVO vo) {
		return ResultMessage.HasExist;
	}

}

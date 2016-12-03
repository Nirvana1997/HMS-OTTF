package businesslogic.webmanagerbl;

import businesslogic.userbl.impl.UserDataImpl;
import enumData.ResultMessage;
import po.UserInfoPO;
import vo.UserInfoVO;

import java.rmi.RemoteException;

/**
 *
 */
public class URmanagement{

    UserDataManagement userDataManagement = new UserDataImpl();

	public UserInfoVO getUserInfo(String userID) throws RemoteException{
		UserInfoPO po = userDataManagement.getUserInfo(userID);
		UserInfoVO vo = new UserInfoVO(po.getUserID(),po.getName(),po.getIdentity(),po.getContactNumber(),po.getCredit(),po.getTransaction());
		return vo;
	}

	public ResultMessage setUserInfo(UserInfoVO vo) {
		return ResultMessage.HasExist;
	}

}

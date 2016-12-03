package businesslogicservice.webmanagerlogicservice;

import enumData.ResultMessage;
import vo.UserInfoVO;

import java.rmi.RemoteException;

public interface URmanagementBlService {
	
	public UserInfoVO getUserInfo(String userID) throws RemoteException;
	
	public ResultMessage setUserInfo (UserInfoVO vo);
	
}

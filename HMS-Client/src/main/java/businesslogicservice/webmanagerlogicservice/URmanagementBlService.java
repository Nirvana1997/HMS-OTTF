package businesslogicservice.webmanagerlogicservice;

import enumData.ResultMessage;
import vo.UserInfoVO;

public interface URmanagementBlService {
	
	public UserInfoVO getUserInfo(String userID);
	
	public ResultMessage setUserInfo (UserInfoVO vo);
	
}

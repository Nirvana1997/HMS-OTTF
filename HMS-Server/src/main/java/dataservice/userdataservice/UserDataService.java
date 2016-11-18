package dataservice.userdataservice;

import enumData.ResultMessage;
import po.*;

public interface UserDataService {
	public UserInfoPO getUserInfo(String userID);
	public ResultMessage setUserInfo(UserInfoPO po);
	public ResultMessage addUserInfo(UserInfoPO po);
	public ResultMessage deleteUserInfo(String userID);
	public ResultMessage addCredit(String userID, int value);
	public ResultMessage subCredit(String userID, int value);
}

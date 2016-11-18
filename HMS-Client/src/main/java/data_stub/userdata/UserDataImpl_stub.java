package data_stub.userdata;

import dataservice.userdataservice.UserDataService;
import enumData.ResultMessage;
import po.UserInfoPO;

public class UserDataImpl_stub implements UserDataService {

	@Override
	public UserInfoPO getUserInfo(String userID) {
		// TODO Auto-generated method stub
		return new UserInfoPO(null, null, null, null, 0, 0);
	}

	@Override
	public ResultMessage setUserInfo(UserInfoPO po) {
		// TODO Auto-generated method stub
		return ResultMessage.Correct;
	}

	@Override
	public ResultMessage addUserInfo(UserInfoPO po) {
		// TODO Auto-generated method stub
		return ResultMessage.Correct;
	}

	@Override
	public ResultMessage deleteUserInfo(String userID) {
		// TODO Auto-generated method stub
		return ResultMessage.Correct;
	}

	@Override
	public ResultMessage addCredit(String userID, int value) {
		// TODO Auto-generated method stub
		return ResultMessage.Correct;
	}

	@Override
	public ResultMessage subCredit(String userID, int value) {
		// TODO Auto-generated method stub
		return ResultMessage.Correct;
	}
	
}

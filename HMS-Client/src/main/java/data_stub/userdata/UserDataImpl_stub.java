package data_stub.userdata;

import dataservice.userdataservice.UserDataService;
import enumData.ResultMessage;
import enumData.UserType;
import po.CreditChangePO;
import po.CreditRecordPO;
import po.UserInfoPO;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class UserDataImpl_stub implements UserDataService {
	ArrayList<UserInfoPO> userInfoPOs= new ArrayList<UserInfoPO>();
	UserInfoPO userInfoPO1 = new UserInfoPO("0100001","xzh","220283199611210319","13596297777",0,"1996_11_21",null, UserType.Person);
	UserInfoPO userInfoPO2 = new UserInfoPO("0100002","qzh","220283199611210310","13596291111",2200,"1996_10_01",null, UserType.Person);
	UserInfoPO userInfoPO3 = new UserInfoPO("0100003","hyx","220283199611210311","13596292222",3200,"1996_01_21","01", UserType.Company);
	UserInfoPO userInfoPO4 = new UserInfoPO("0100004","gmd","220283199611210312","13596293333",2000,"1996_02_20","02", UserType.Company);
	ArrayList<CreditRecordPO> creditRecordPOs = new ArrayList<CreditRecordPO>();

	public UserDataImpl_stub() {
		userInfoPOs.add(userInfoPO1);
		userInfoPOs.add(userInfoPO2);
		userInfoPOs.add(userInfoPO3);
		userInfoPOs.add(userInfoPO4);
	}

	@Override
	public UserInfoPO getUserInfo(String userID) {
		// TODO Auto-generated method stub
		for(int i=0;i<userInfoPOs.size();i++){
			if(userInfoPOs.get(i).getUserID().equals(userID)) {
				return userInfoPOs.get(i);
			}
		}
		return null;
	}

	@Override
	public ResultMessage setUserInfo(UserInfoPO po) {
		// TODO Auto-generated method stub
		deleteUserInfo(po.getUserID());
		addUserInfo(po);
		return ResultMessage.Correct;
	}

	@Override
	public ResultMessage addUserInfo(UserInfoPO po) {
		// TODO Auto-generated method stub
		userInfoPOs.add(po);
		return ResultMessage.Correct;
	}

	@Override
	public ResultMessage deleteUserInfo(String userID) {
		// TODO Auto-generated method stub
		for(int i=0;i<userInfoPOs.size();i++){
			if(userInfoPOs.get(i).getUserID().equals(userID))
				userInfoPOs.remove(i);
		}
		return ResultMessage.Correct;
	}

	@Override
	public ArrayList<UserInfoPO> getUserInfoList() throws RemoteException {
		return userInfoPOs;
	}

	@Override
	public ResultMessage addCredit(CreditChangePO po) throws RemoteException {
		for(int i=0;i<userInfoPOs.size();i++){
			if(userInfoPOs.get(i).getUserID().equals(po.getUserID())) {
				userInfoPOs.get(i).setCredit(userInfoPOs.get(i).getCredit() + po.getValue());
				creditRecordPOs.add(new CreditRecordPO(po.getDate(),po.getValue(),userInfoPOs.get(i).getCredit(),"",""));
			}
		}
		return ResultMessage.Correct;
	}

	@Override
	public ResultMessage subCredit(CreditChangePO po) throws RemoteException {
		po.setValue(-po.getValue());
		addCredit(po);
		return ResultMessage.Correct;
	}

	@Override
	public ArrayList<CreditRecordPO> checkCreditRecord(String userID) throws RemoteException {
		return creditRecordPOs;
	}

	@Override
	public int getCurrentUserID() throws RemoteException {
		return 0;
	}


}

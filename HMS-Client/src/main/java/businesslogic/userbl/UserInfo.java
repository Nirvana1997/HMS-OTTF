package businesslogic.userbl;



import businesslogic.companybl.CompanyDataImpl;
import businesslogic.logbl.Login;
import businesslogic.userbl.interfaces.UserCompanyInfo;
import cfg.CfgReader;
import po.CreditRecordPO;
import po.UserInfoPO;
import rmi.RemoteHelper;
import utility.CreditRecordPVChanger;
import dataservice.userdataservice.UserDataService;
import enumData.ResultMessage;
import utility.UserPVChanger;
import vo.CreditRecordVO;
import vo.UserInfoVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * 用户信息操作模块
 * 负责更改用户信息和查看个人信息
 * @author xzh
 */
public  class UserInfo{
	/**
	 * 用户数据模块
	 */
	UserDataService userDataService;

	/**
	 * 用户企业数据接口
	 */
	UserCompanyInfo userCompanyInfo;

	public UserInfo() {
		//TODO
//		userDataService = new UserDataImpl_stub();
		userDataService = RemoteHelper.getInstance().getUserDataService();
		userCompanyInfo = new CompanyDataImpl();
	}

	/**
	 * 修改个人信息
	 * @param vo
	 * @return
     */
	public ResultMessage modifyUserInfo(UserInfoVO vo) throws RemoteException{
		UserInfoPO userInfoPO = UserPVChanger.userInfoV2P(vo);
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
		return UserPVChanger.userInfoP2V(po);

	}

	/**
	 * 是否有足够的信用值
	 *
	 * @return 是否足够
	 * @throws RemoteException
	 */
	public boolean hasEnoughCredit() throws RemoteException {
		if(userDataService.getUserInfo(Login.getNowUserID()).getCredit()>= Integer.valueOf(CfgReader.getInstance().getProperty("minCredit"))){
			return true;
		}
		else{
			return false;
		}
	}

	/**
	 * 显示用户信用记录
	 *
	 * @return 用户信用记录列表
	 * @throws RemoteException
	 */
	public ArrayList<CreditRecordVO> showCreditRecords() throws RemoteException{
		ArrayList<CreditRecordVO> res = new ArrayList<>();
		for(CreditRecordPO po:userDataService.checkCreditRecord(Login.getNowUserID())){
			res.add(CreditRecordPVChanger.creditRecordP2V(po));
		}
		return res;
	}

	/**
	 * 获得所有企业
	 *
	 * @return 所有企业名称
	 * @throws RemoteException
	 */
	public ArrayList<String> showAllCompanys() throws RemoteException{
		return userCompanyInfo.showAllCompanys();
	}

	/**
	 * 判断企业ID与企业名称是否对应
	 *
	 * @param companyID   企业ID
	 * @param companyName 企业名称
	 * @return 是否对应
	 * @throws RemoteException
	 */
	public boolean isCompanyIDCorrect(String companyID, String companyName) throws RemoteException{
		return userCompanyInfo.isCompanyIDCorrect(companyID,companyName);
	}
}

package businesslogic.logbl;

import data_stub.logdata.LogDataImpl_stub;
import dataservice.logdataservice.LogDataService;
import enumData.AccountType;
import enumData.ResultMessage;
import po.AccountPO;
import vo.AccountVO;

import java.rmi.RemoteException;

/**
 * 登录模块
 * @author qzh
 */
public class Login {
	/**
	 * 登录模块数据接口
	 */
	LogDataService logDataService;

	/**
	 * 当前登录用户
	 */
	AccountPO nowUser;

	public Login() throws RemoteException {
//		logDataService = RemoteHelper.getInstance().getLogDataService();
		logDataService = new LogDataImpl_stub();
	}

    /**
     * 密码是否正确,若正确则登录
     * @param vo 帐号信息
     * @return
     * @throws RemoteException
     */
	public ResultMessage isCorrectAndLogin(AccountVO vo)throws RemoteException {
		String password = logDataService.getPassword(vo.getAccountID());
		if(vo.getPassword() == password){
		    nowUser = new AccountPO(vo.getAccountID(),vo.getPassword(),vo.getType());
		    return ResultMessage.Correct;
        }
        else{
            return ResultMessage.InCorrect;
        }
	}

    /**
     * 返回当前用户，若不存在，则返回null
     * @param account
     * @return
     * @throws RemoteException
     */
	public AccountType accoutType(String account)throws RemoteException{
	    if(logDataService.hasExisted(account).equals(ResultMessage.HasExist))
            return logDataService.getAccountType(account);
	    else{
	        return null;
        }
	}

	/**
	 * 返回当前登录用户信息
	 * @return
	 */
	public AccountVO getNowUser(){
	    AccountVO vo = new AccountVO(nowUser.getAccountID(),nowUser.getPassword(),nowUser.getType());
		return vo;
	}
}

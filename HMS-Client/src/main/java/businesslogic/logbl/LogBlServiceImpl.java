package businesslogic.logbl;

import businesslogicservice.logblservice.LogBlService;
import data_stub.logdata.LogDataImpl_stub;
import dataservice.logdataservice.LogDataService;
import enumData.AccountType;
import enumData.ResultMessage;
import vo.AccountVO;

import java.rmi.RemoteException;

/**
 * 登录逻辑实现
 */
public class LogBlServiceImpl implements LogBlService{

	LogDataService logDataService;

	public LogBlServiceImpl() throws RemoteException {
//		logDataService = RemoteHelper.getInstance().getLogDataService();
		logDataService = new LogDataImpl_stub();
	}

    /**
     * 密码是否正确
     * @param vo 帐号信息
     * @return
     * @throws RemoteException
     */
	public ResultMessage isCorrect(AccountVO vo)throws RemoteException {
		String password = logDataService.getPassword(vo.getAccountID());
		if(vo.getPassword() == password){
		    return ResultMessage.Correct;
        }
        else{
            return ResultMessage.InCorrect;
        }
	}

    /**
     * 返回用户类型
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
     * 添加用户
     * @param vo 用户信息
     * @return
     * @throws RemoteException
     */
	public ResultMessage addAccount(AccountVO vo)throws RemoteException {
		if(logDataService.hasExisted(vo.getAccountID()).equals(ResultMessage.NotExist))
		    //TODO
            return ResultMessage.Correct;
        return ResultMessage.HasExist;
	}
	
	
}

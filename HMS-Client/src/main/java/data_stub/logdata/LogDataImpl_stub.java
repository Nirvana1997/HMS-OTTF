package data_stub.logdata;

import dataservice.logdataservice.LogDataService;
import enumData.AccountType;
import enumData.ResultMessage;
import po.AccountPO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 负责帐号密码信息的管理
 * @author qzh
 */
public class LogDataImpl_stub extends UnicastRemoteObject implements LogDataService {
    //TODO
    Map<String,AccountPO> accountMap = new HashMap<String,AccountPO>();
    AccountPO account1 = new AccountPO("151250001","111111",AccountType.user);
    AccountPO account2 = new AccountPO("151250002","111111",AccountType.hotelsaler);
	AccountPO account3 = new AccountPO("151250003","111111",AccountType.websaler);
	AccountPO account4 = new AccountPO("151250004","111111",AccountType.webmanager);

	public LogDataImpl_stub() throws RemoteException{
		super();
		accountMap.put("151250001",account1);
		accountMap.put("151250002",account2);
		accountMap.put("151250003",account3);
		accountMap.put("151250004",account4);
	}


    /**
     * 返回对应帐号的密码
     * @param account 帐号
     * @return
     * @throws RemoteException
     */
	@Override
	public String getPassword(String account)throws RemoteException {
        AccountPO po = accountMap.get(account);
        if(po==null){
            return null;
        }
        return po.getPassword();
	}

	/**
     * 设置对应帐号的密码
     * @param account 帐号
     * @return
     * @throws RemoteException
     */
	@Override
	public ResultMessage setPassword(String account,String password) throws RemoteException{
		if(account.equals("001")){
			return ResultMessage.Correct;
		}else
		return ResultMessage.NotExist;
	}

	@Override
	public ArrayList<AccountPO> getAccountList(AccountType accountType) throws RemoteException{
		ArrayList<AccountPO> AccountList = new ArrayList<AccountPO>();
		//TODO
		AccountPO po = new AccountPO("OTTF", "1234", accountType);
		AccountList.add(po);
		return AccountList;
	}

	@Override
	public ResultMessage addAccount(AccountPO po)throws RemoteException {
		if(po.getAccountID().equals("001")){
			return ResultMessage.HasExist;
		}else
		return ResultMessage.Correct;
	}

	@Override
	public ResultMessage deleteAccount(String account) throws RemoteException{
		if(account.equals("001")){
			return ResultMessage.Correct;
		}else
		return ResultMessage.NotExist;
	}

    @Override
    public AccountType getAccountType(String account) throws RemoteException {
        return accountMap.get(account).getType();
    }

	/**
	 * 检验用户名是否重复
	 * @param account 帐号
	 * @return
	 */
	@Override
	public boolean hasExisted(String account) throws RemoteException {
		if(accountMap.get(account)==null)
			return false;
		else
			return true;
	}

}

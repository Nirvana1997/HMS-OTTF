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
    ArrayList<AccountPO> accountList = new ArrayList<AccountPO>();
    AccountPO account1 = new AccountPO("0101","151250001","111111",AccountType.user);
    AccountPO account2 = new AccountPO("0201","151250002","111111",AccountType.hotelsaler);
	AccountPO account3 = new AccountPO("0301","151250003","111111",AccountType.websaler);
	AccountPO account4 = new AccountPO("0001","151250004","111111",AccountType.webmanager);

	public LogDataImpl_stub() throws RemoteException{
		super();
		accountMap.put("151250001",account1);
		accountMap.put("151250002",account2);
		accountMap.put("151250003",account3);
		accountMap.put("151250004",account4);
		accountList.add(account1);
		accountList.add(account2);
		accountList.add(account3);
		accountList.add(account4);
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

	@Override
	public String getID(String account) throws RemoteException {
		return accountMap.get(account).getID();
	}

	/**
     * 设置对应帐号的密码
     * @param account 帐号
     * @return
     * @throws RemoteException
     */
	@Override
	public ResultMessage setPassword(String account,String password) throws RemoteException{
		AccountPO po = accountMap.get(account);
		po.setPassword(password);
		accountMap.put(account,po);
		return ResultMessage.Correct;
	}

	@Override
	public ArrayList<AccountPO> getAccountList(AccountType accountType) throws RemoteException{
		return accountList;
	}

	@Override
	public ResultMessage addAccount(AccountPO po)throws RemoteException {
		if(po.getAccount().equals("001")){
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

	@Override
	public int getTypeNum(AccountType type) throws RemoteException {
		return accountMap.size();
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

package data_stub.logdata;

import dataservice.logdataservice.LogDataService;
import enumData.AccountType;
import enumData.ResultMessage;
import po.AccountPO;
import po.PromotionPO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

/**
 * 负责帐号密码信息的管理
 * @author qzh
 */
public class LogDataImpl_stub extends UnicastRemoteObject implements LogDataService {
    //TODO
    static Map<String,AccountPO> accountMap = new HashMap<String,AccountPO>();
    static ArrayList<AccountPO> accountList = new ArrayList<AccountPO>();
    AccountPO account1 = new AccountPO("0100001","151250001","111111",AccountType.user);
    AccountPO account2 = new AccountPO("0200001","151250002","111111",AccountType.hotelsaler);
	AccountPO account3 = new AccountPO("0300001","151250003","111111",AccountType.websaler);
	AccountPO account4 = new AccountPO("0000001","151250004","111111",AccountType.webmanager);

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
        accountList.add(po);
		accountMap.put(po.getAccount(),po);
        return ResultMessage.Correct;
	}

	@Override
	public ResultMessage deleteAccount(String id) throws RemoteException{
		String account = "";
		int index = 0;
		for(int i=0;i<accountList.size();i++){
		    if(id.equals(accountList.get(i).getID())) {
		    	account = accountList.get(i).getAccount();
				index = i;
			};
        }
        accountList.remove(index);
		accountMap.remove(account);
        return ResultMessage.Correct;
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

	@Override
	public String getAccount(String id) throws RemoteException {
		for(AccountPO po:accountList){
			if(po.getID().equals(id))
				return po.getAccount();
		}
		return null;
	}

}

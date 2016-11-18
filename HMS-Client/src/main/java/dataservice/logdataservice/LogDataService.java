package dataservice.logdataservice;

import enumData.AccountType;
import enumData.ResultMessage;
import po.AccountPO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * 负责帐号密码信息的管理
 * @author qzh
 */
public interface LogDataService {
    /**
     * 返回对应帐号的密码
     * @param account 帐号
     * @return
     * @throws RemoteException
     */
	public String getPassword(String account) throws RemoteException;

    /**
     * 设置对应帐号的密码
     * @param account 帐号
     * @return
     * @throws RemoteException
     */
	public ResultMessage setPassword(String account) throws RemoteException;
	
	public ArrayList<AccountPO> getAccountList(AccountType accountType) throws RemoteException;
	
	public ResultMessage addAccount(AccountPO po) throws RemoteException;
	
	public ResultMessage deleteAccount(String account) throws RemoteException;

	public AccountType getAccountType(String account)throws RemoteException;

	public ResultMessage hasExisted(String account)throws RemoteException;
}

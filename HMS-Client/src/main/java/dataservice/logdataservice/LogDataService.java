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
	 * 根据账户ID得到相应密码
	 * @param account 帐号
	 * @return
	 * @throws RemoteException
	 */
	public String getPassword(String account) throws RemoteException;

	/**
	 * 根据账户ID修改相应密码
	 * @param account 帐号
	 * @param password
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessage setPassword(String account,String password) throws RemoteException;

	/**
	 * 根据账户类型，返回账户PO的LIST
	 * @param accountType
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<AccountPO> getAccountList(AccountType accountType) throws RemoteException;

	/**
	 * 在数据库中增加一个账户
	 * @param po
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessage addAccount(AccountPO po) throws RemoteException;

	/**
	 * 在数据库中删除一个账户
	 * @param account
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessage deleteAccount(String account) throws RemoteException;

	/**
	 * 根据账户ID得到相应账户类型
	 * @param account
	 * @return
	 * @throws RemoteException
	 */
	public AccountType getAccountType(String account)throws RemoteException;

	/**
	 * 判断该账户在数据库中是否存在
	 * @param account
	 * @return
	 * @throws RemoteException
	 */
	public boolean hasExisted(String account)throws RemoteException;
}
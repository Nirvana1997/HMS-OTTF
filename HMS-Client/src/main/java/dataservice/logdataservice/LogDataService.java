package dataservice.logdataservice;

import enumData.AccountType;
import enumData.ResultMessage;
import po.AccountPO;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface LogDataService extends Remote{
	/**
	 * 根据账户ID得到相应密码
	 * @param account 帐号
	 * @return 密码
	 * @throws RemoteException
	 */
	public String getPassword(String account) throws RemoteException;

	/**
	 * 根据账户ID修改相应密码
	 * @param account 帐号
	 * @param password 密码
	 * @return 结果信息
	 * @throws RemoteException
	 */
	public ResultMessage setPassword(String account, String password) throws RemoteException;

	/**
	 * 根据账户类型，返回账户PO的LIST
	 * @param accountType 账户类型
	 * @return 账户PO的列表
	 * @throws RemoteException
	 */
	public ArrayList<AccountPO> getAccountList(AccountType accountType) throws RemoteException;

	/**
	 * 在数据库中增加一个账户
	 * @param po 账户PO
	 * @return 结果信息
	 * @throws RemoteException
	 */
	public ResultMessage addAccount(AccountPO po) throws RemoteException;

	/**
	 * 在数据库中删除一个账户
	 * @param account 账户ID
	 * @return 结果信息
	 * @throws RemoteException
	 */
	public ResultMessage deleteAccount(String account) throws RemoteException;

	/**
	 * 根据账户ID得到相应账户类型
	 * @param account 账户ID
	 * @return 账户类型
	 * @throws RemoteException
	 */
	public AccountType getAccountType(String account)throws RemoteException;

	/**
	 * 判断该账户在数据库中是否存在
	 * @param account 账户ID
	 * @return 是否存在（布尔值）
	 * @throws RemoteException
	 */
	public boolean hasExisted(String account)throws RemoteException;
}

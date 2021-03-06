package dataservice.logdataservice;

import enumData.AccountType;
import enumData.LogState;
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
	 * 根据帐号得到相应的ID
	 * @param account 帐号
	 * @return ID
	 * @throws RemoteException
     */
	public String getID(String account) throws RemoteException;

	/**
	 * 根据ID得到相应帐号
	 * @param ID ID
	 * @return 帐号
	 * @throws RemoteException
     */
	public String getAccount(String ID) throws RemoteException;

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
	 * @param  ID ID
	 * @return 结果信息
	 * @throws RemoteException
	 */
	public ResultMessage deleteAccount(String ID) throws RemoteException;

	/**
	 * 根据账户ID得到相应账户类型
	 * @param account 账户ID
	 * @return 账户类型
	 * @throws RemoteException
	 */
	public AccountType getAccountType(String account)throws RemoteException;

	/**
	 * 根据用户类型，返回该类型对应已有账号数量
	 * @param type 帐号类型
	 * @return 该类型已有帐号数量
	 * @throws RemoteException
     */
	public int getTypeNum(AccountType type)throws RemoteException;

	/**
	 * 将相应帐号的状态置为登陆
	 * @param account 账号
	 * @return 结果信息
	 * @throws RemoteException
     */
	public ResultMessage setLogin(String account)throws RemoteException;

	/**
	 * 将相应帐号的状态置为离线
	 * @param account 帐号
	 * @return 结果信息
	 * @throws RemoteException
     */
	public ResultMessage setLogout(String account)throws RemoteException;

	/**
	 * 根据帐号,返回登陆状态
	 * @param account
	 * @return 登陆状态
	 * @throws RemoteException
     */
	public LogState getLogState(String account)throws RemoteException;

}

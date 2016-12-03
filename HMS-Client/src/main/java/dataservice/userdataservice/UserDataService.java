package dataservice.userdataservice;

import enumData.ResultMessage;
import po.UserInfoPO;

import java.rmi.RemoteException;

public interface UserDataService {
	/**
	 * 根据用户ID，返回用户信息
	 * @param userID
	 * @return
	 * @throws RemoteException
     */
	public UserInfoPO getUserInfo(String userID) throws RemoteException;

	/**
	 * 修改用户信息
	 * @param po
	 * @return
	 * @throws RemoteException
     */
	public ResultMessage setUserInfo(UserInfoPO po) throws RemoteException;

	/**
	 * 新增用户信息
	 * @param po
	 * @return
	 * @throws RemoteException
     */
	public ResultMessage addUserInfo(UserInfoPO po) throws RemoteException;

	/**
	 * 删除用户信息
	 * @param userID
	 * @return
	 * @throws RemoteException
     */
	public ResultMessage deleteUserInfo(String userID) throws RemoteException;

	/**
	 * 增加用户信用值
	 * @param userID
	 * @param value
	 * @return
	 * @throws RemoteException
     */
	public ResultMessage addCredit(String userID, int value) throws RemoteException;

	/**
	 * 减少用户信用值
	 * @param userID
	 * @param value
	 * @return
	 * @throws RemoteException
     */
	public ResultMessage subCredit(String userID, int value) throws RemoteException;
}

package dataservice.userdataservice;

import enumData.ResultMessage;
import po.*;

import java.rmi.RemoteException;
import java.util.ArrayList;

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
	 * @param date
	 * @return
	 * @throws RemoteException
     */
	public ResultMessage addCredit(String userID, int value, String date) throws RemoteException;

	/**
	 * 减少用户信用值
	 * @param userID
	 * @param value
	 * @param date
	 * @return
	 * @throws RemoteException
     */
	public ResultMessage subCredit(String userID, int value, String date) throws RemoteException;

	/**
	 * 查看信用记录
	 * @param userID
	 * @return
	 * @throws RemoteException
     */
	public ArrayList<CreditRecordPO> checkCreditRecord(String userID) throws RemoteException;

}

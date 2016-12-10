package dataservice.userdataservice;

import enumData.ResultMessage;
import po.CreditRecordPO;
import po.UserInfoPO;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface UserDataService extends Remote{
	/**
	 * 根据用户ID，返回用户信息
	 * @param userID 用户ID
	 * @return 用户信息PO
	 * @throws RemoteException
     */
	public UserInfoPO getUserInfo(String userID) throws RemoteException;

	/**
	 * 修改用户信息
	 * @param po 用户信息PO
	 * @return 结果信息
	 * @throws RemoteException
     */
	public ResultMessage setUserInfo(UserInfoPO po) throws RemoteException;

	/**
	 * 新增用户信息
	 * @param po 用户信息PO
	 * @return	结果信息
	 * @throws RemoteException
     */
	public ResultMessage addUserInfo(UserInfoPO po) throws RemoteException;

	/**
	 * 删除用户信息
	 * @param userID 用户ID
	 * @return 结果信息
	 * @throws RemoteException
     */
	public ResultMessage deleteUserInfo(String userID) throws RemoteException;

	/**
	 * 得到用户信息列表（所有用户）
	 * @return 用户信息列表
	 * @throws RemoteException
     */
	public ArrayList<UserInfoPO> getUserInfoList() throws RemoteException;

	/**
	 * 增加用户信用值
	 * @param userID 用户ID
	 * @param value 增加的信息值
	 * @param date 变更的日期
	 * @return 结果信息
	 * @throws RemoteException
     */
	public ResultMessage addCredit(String userID, int value, String date) throws RemoteException;

	/**
	 * 减少用户信用值
	 * @param userID 用户ID
	 * @param value 减少的信用值
	 * @param date 变更的日期
	 * @return 结果信息
	 * @throws RemoteException
     */
	public ResultMessage subCredit(String userID, int value, String date) throws RemoteException;

	/**
	 * 查看信用记录
	 * @param userID 用户ID
	 * @return 信用记录的PO的列表
	 * @throws RemoteException
     */
	public ArrayList<CreditRecordPO> checkCreditRecord(String userID) throws RemoteException;

	/**
	 * 得到当前用户ID的总数+1
	 * @return 当前用户ID总数+1
	 * @throws RemoteException
     */
	public int getCurrentUserID() throws RemoteException;

}

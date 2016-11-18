package businesslogicservice.logblservice;

import vo.AccountVO;
import enumData.AccountType;
import enumData.ResultMessage;

import java.rmi.RemoteException;

public interface LogBlService {
	/**
	 * 密码是否正确
	 * @param vo 帐号信息
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessage isCorrect(AccountVO vo) throws RemoteException;

	/**
	 * 返回用户类型
	 * @param account
	 * @return
	 * @throws RemoteException
	 */
	public AccountType accoutType(String account) throws RemoteException;


	/**
	 * 添加用户
	 * @param vo 用户信息
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessage addAccount(AccountVO vo) throws RemoteException;
}

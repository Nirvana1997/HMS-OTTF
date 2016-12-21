package businesslogicservice.logblservice;

import vo.AccountVO;
import enumData.AccountType;
import enumData.ResultMessage;
import vo.PasswordComfirmVO;
import vo.UserInfoVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * 负责登录及注册
 */
public interface LogBlService {
    /**
     * 密码是否正确
     *
     * @param vo 帐号信息
     * @return
     * @throws RemoteException
     */
    public ResultMessage isCorrectAndLogin(AccountVO vo) throws RemoteException;

    /**
     * 登出
     *
     * @throws RemoteException
     */
    public void logOut() throws RemoteException;

    /**
     * 返回用户类型，若不存在，则返回null
     *
     * @param account
     * @return
     * @throws RemoteException
     */
    public AccountType accoutType(String account) throws RemoteException;


    /**
     * 添加用户
     *
     * @param vo 帐号信息
     * @return
     * @throws RemoteException
     */
    public ResultMessage register(AccountVO vo) throws RemoteException;

    /**
     * 添加用户信息
     *
     * @param vo 用户个人信息
     * @throws RemoteException
     */
    public void addUserInfo(UserInfoVO vo) throws RemoteException;

    /**
     * 判断两次密码是否一致以及是否已存在帐号
     *
     * @param vo 帐号密码确认信息
     * @return
     */
    public ResultMessage isValid(PasswordComfirmVO vo) throws RemoteException;

    /**
     * 修改密码
     *
     * @param oldpswd 旧密码
     * @param newpswd 新密码
     * @return 旧密码是否正确
     */
    public ResultMessage modifyPassword(String oldpswd, String newpswd) throws RemoteException;

    /**
     * 获得所有企业
     *
     * @return 所有企业名称
     * @throws RemoteException
     */
    public ArrayList<String> showAllCompanys() throws RemoteException;

    /**
     * 判断企业ID与企业名称是否对应
     *
     * @param companyID   企业ID
     * @param companyName 企业名称
     * @return 是否对应
     * @throws RemoteException
     */
    public boolean isCompanyIDCorrect(String companyID, String companyName) throws RemoteException;
}

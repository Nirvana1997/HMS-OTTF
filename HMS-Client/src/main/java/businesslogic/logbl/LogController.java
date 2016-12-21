package businesslogic.logbl;

import businesslogicservice.logblservice.LogBlService;
import enumData.AccountType;
import enumData.ResultMessage;
import vo.AccountVO;
import vo.PasswordComfirmVO;
import vo.UserInfoVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * 登录逻辑控制器
 *
 * @author qzh
 *         Created by user on 2016/11/25.
 */
public class LogController implements LogBlService {
    /**
     * 登录模块
     */
    Login login;

    /**
     * 注册模块
     */
    Register register;

    public LogController() throws RemoteException {
        login = new Login();
        register = new Register();
    }

    /**
     * 密码是否正确,若正确则登录
     *
     * @param vo 帐号信息
     * @return
     * @throws RemoteException
     */
    @Override
    public ResultMessage isCorrectAndLogin(AccountVO vo) throws RemoteException {
        return login.isCorrectAndLogin(vo);
    }

    @Override
    public void logOut() throws RemoteException {
        login.logOut();
    }

    /**
     * 返回用户类型，若不存在，则返回null
     *
     * @param account
     * @return
     * @throws RemoteException
     */
    @Override
    public AccountType accoutType(String account) throws RemoteException {
        return login.accoutType(account);
    }

    /**
     * 添加用户
     *
     * @param vo 用户信息
     * @return
     * @throws RemoteException
     */
    @Override
    public ResultMessage register(AccountVO vo) throws RemoteException {
        ResultMessage resultMessage = register.register(vo);
        return resultMessage;
    }

    /**
     * 添加用户信息
     *
     * @param vo 用户个人信息
     * @throws RemoteException
     */
    @Override
    public void addUserInfo(UserInfoVO vo) throws RemoteException {
        register.addUserInfo(vo);
        login.loginAfterRegister(vo.getUserID());
    }

    /**
     * 判断两次密码是否一致以及是否已存在帐号
     *
     * @param vo 帐号密码确认信息
     * @return
     */
    @Override
    public ResultMessage isValid(PasswordComfirmVO vo) throws RemoteException {
        return register.isValid(vo);
    }

    /**
     * 修改密码
     *
     * @param oldpswd 旧密码
     * @param newpswd 新密码
     * @return 旧密码是否正确
     */
    @Override
    public ResultMessage modifyPassword(String oldpswd, String newpswd) throws RemoteException {
        return login.modifyPassword(oldpswd, newpswd);
    }

    @Override
    public ArrayList<String> showAllCompanys() throws RemoteException {
        return register.showAllCompanys();
    }

    @Override
    public boolean isCompanyIDCorrect(String companyID, String companyName) throws RemoteException {
        return register.isCompanyIDCorrect(companyID,companyName);
    }

}

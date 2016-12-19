package businesslogic.logbl;

import businesslogicservice.logblservice.LogBlService;
import enumData.AccountType;
import enumData.ResultMessage;
import vo.AccountVO;
import vo.PasswordComfirmVO;
import vo.UserInfoVO;

import java.rmi.RemoteException;

/**
 * 登录逻辑控制器
 * @author qzh
 * Created by user on 2016/11/25.
 */
public class LogController implements LogBlService{
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
     * @param vo 用户信息
     * @return
     * @throws RemoteException
     */
    @Override
    public ResultMessage register(AccountVO vo) throws RemoteException {
        ResultMessage resultMessage = register.register(vo);
        login.loginAfterRegister(vo.getAccount());
        return resultMessage;
    }

    /**
     * 添加用户信息
     * @param vo 用户个人信息
     * @throws RemoteException
     */
    @Override
    public void addUserInfo(UserInfoVO vo) throws RemoteException {
        register.addUserInfo(vo);
    }

    /**
     * 判断两次密码是否一致以及是否已存在帐号
     * @param vo 帐号密码确认信息
     * @return
     */
    public ResultMessage isValid(PasswordComfirmVO vo) throws RemoteException{
        return register.isValid(vo);
    }

    /**
     * 修改密码
     *
     * @param password 新密码
     */
    public void modifyPassword(String password) throws RemoteException{
        login.modifyPassword(password);
    }

}

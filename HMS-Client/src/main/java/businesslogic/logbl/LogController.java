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
     * 密码是否正确
     * @param vo 帐号信息
     * @return
     * @throws RemoteException
     */
    @Override
    public ResultMessage isCorrect(AccountVO vo) throws RemoteException {
        return login.isCorrectAndLogin(vo);
    }

    /**
     * 返回用户类型
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
        return register.register(vo);
    }

    /**
     * 添加用户信息
     * @param vo 用户个人信息
     * @throws RemoteException
     */
    @Override
    public void addUserInfo(UserInfoVO vo) throws RemoteException {

    }

    /**
     * 判断两次密码是否一致以及是否已存在帐号
     * @param vo 帐号密码确认信息
     * @return
     */
    public ResultMessage isValid(PasswordComfirmVO vo) throws RemoteException{
        return register.isValid(vo);
    }
}

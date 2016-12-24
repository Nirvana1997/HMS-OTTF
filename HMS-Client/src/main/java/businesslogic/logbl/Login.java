package businesslogic.logbl;

import dataservice.logdataservice.LogDataService;
import enumData.AccountType;
import enumData.LogState;
import enumData.ResultMessage;
import rmi.RemoteHelper;
import vo.AccountVO;

import java.rmi.RemoteException;

/**
 * 登录模块
 * 负责登录相关逻辑,包括判断密码是否正确、修改密码、返回当前登录用户
 *
 * @author qzh
 */
public class Login {
    /**
     * 登录模块数据接口
     */
    private LogDataService logDataService;

    /**
     * 当前用户
     */
    private static String nowUserID;

    public Login() throws RemoteException {
        logDataService = RemoteHelper.getInstance().getLogDataService();
//        logDataService = new LogDataImpl_stub();
    }

    /**
     * 密码是否正确,若正确则登录
     *
     * @param vo 帐号信息
     * @return 是否正确
     * @throws RemoteException
     */
    public ResultMessage isCorrectAndLogin(AccountVO vo) throws RemoteException {
        String password = logDataService.getPassword(vo.getAccount());
        String userID = logDataService.getID(vo.getAccount());
        //判断密码是否正确
        if (vo.getPassword().equals(password)) {
            //判断是否已经登录
            if (logDataService.getLogState(userID).equals(LogState.out)) {
                nowUserID = logDataService.getID(vo.getAccount());
                logDataService.setLogin(userID);
                return ResultMessage.Correct;
            } else {
                return ResultMessage.hasLogined;
            }
        } else {
            return ResultMessage.InCorrect;
        }
    }

    /**
     * 登录（注册完成之后自动根据帐号登录）
     */
    public void loginAfterRegister(String account) throws RemoteException {
        nowUserID = account;
        logDataService.setLogin(account);
    }

    /**
     * 登出
     *
     * @throws RemoteException
     */
    public void logOut() throws RemoteException {
        logDataService.setLogout(nowUserID);
        nowUserID = null;
    }

    /**
     * 返回对应用户帐号类型，若不存在，则返回null
     *
     * @param account 帐号
     * @return 帐号类型
     * @throws RemoteException
     */
    public AccountType accoutType(String account) throws RemoteException {
        return logDataService.getAccountType(account);
    }

    /**
     * 修改密码
     *
     * @param oldpswd 旧密码
     * @param newpswd 新密码
     */
    public ResultMessage modifyPassword(String oldpswd, String newpswd) throws RemoteException {
        //判断旧密码是否正确
        if (!oldpswd.equals(logDataService.getPassword(logDataService.getAccount(Login.nowUserID)))) {
            return ResultMessage.InCorrect;
        } else {
            logDataService.setPassword(logDataService.getAccount(Login.nowUserID), newpswd);
            return ResultMessage.Correct;
        }
    }

    /**
     * 获取当前登录用户ID
     *
     * @return 当前登录用户ID
     */
    public static String getNowUserID() {
        return nowUserID;
    }

}

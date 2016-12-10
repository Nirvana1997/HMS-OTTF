package businesslogic.logbl;

import data_stub.logdata.LogDataImpl_stub;
import dataservice.logdataservice.LogDataService;
import enumData.AccountType;
import enumData.ResultMessage;
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
    LogDataService logDataService;

    /**
     * 当前用户
     */
    private static String nowUserID;

    public Login() throws RemoteException {
//		logDataService = RemoteHelper.getInstance().getLogDataService();
        logDataService = new LogDataImpl_stub();
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
        if (vo.getPassword().equals(password)) {
            nowUserID = vo.getID();
            return ResultMessage.Correct;
        } else {
            return ResultMessage.InCorrect;
        }
    }

    /**
     * 返回对应用户帐号类型，若不存在，则返回null
     *
     * @param account 帐号
     * @return 帐号类型
     * @throws RemoteException
     */
    public AccountType accoutType(String account) throws RemoteException {
        if (logDataService.hasExisted(account))
            return logDataService.getAccountType(account);
        else {
            return null;
        }
    }

    /**
     * 修改密码
     *
     * @param password 新密码
     */
    public void modifyPassword(String password) throws RemoteException {
        logDataService.setPassword(nowUserID, password);
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

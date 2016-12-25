package businesslogic.logbl;

import businesslogic.companybl.CompanyInfoImpl;
import businesslogic.userbl.impl.UserDataImpl;
import cfg.CfgReader;
import dataservice.logdataservice.LogDataService;
import enumData.AccountType;
import enumData.ResultMessage;
import po.AccountPO;
import rmi.RemoteHelper;
import vo.AccountVO;
import vo.PasswordComfirmVO;
import vo.UserInfoVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * 负责接收客户注册的信息并添加至数据层
 *
 * @author qzh
 *         Created by user on 2016/11/25.
 */
public class Register {
    /**
     * 登录模块
     */
    LogDataService logDataService;

    /**
     * 用户信息添加接口
     */
    UserInfoAdder userInfoAdder;

    /**
     * 用户企业信息接口
     */
    UserCompanyInfo userCompanyInfo;

    public Register() throws RemoteException {
        //TODO
//        this.logDataService = new LogDataImpl_stub();
        logDataService = RemoteHelper.getInstance().getLogDataService();
        this.userInfoAdder = new UserDataImpl();
        userCompanyInfo = new CompanyInfoImpl();
//        this.logDataService = RemoteHelper.getInstance().getLogDataService();
    }

    /**
     * 注册帐号
     *
     * @param vo 用户信息
     * @return
     * @throws RemoteException
     */
    public ResultMessage register(AccountVO vo) throws RemoteException {
        addAccount(vo);
        return ResultMessage.Correct;
    }

    /**
     * 判断两次密码是否一致以及是否已存在帐号
     *
     * @param vo 帐号密码确认信息
     * @return
     */
    public ResultMessage isValid(PasswordComfirmVO vo) throws RemoteException {
        if (!vo.getPassword().equals(vo.getConfirm()))
            return ResultMessage.NotSame;
        //判断是否存在
        else if (logDataService.getAccountType(vo.getAcccountID())!=null)
            return ResultMessage.HasExist;
        return ResultMessage.Correct;
    }

    /**
     * 添加用户信息
     *
     * @param vo 用户个人信息
     * @throws RemoteException
     */
    public void addUserInfo(UserInfoVO vo) throws RemoteException {
        //将帐号转化为对应ID
        String id = logDataService.getID(vo.getUserID());
        vo.setUserID(id);

        userInfoAdder.addUserInfo(vo);
    }

    /**
     * 获得所有企业
     *
     * @return 所有企业名称
     * @throws RemoteException
     */
    public ArrayList<String> showAllCompanys() throws RemoteException{
        return userCompanyInfo.showAllCompanys();
    }


    /**
     * 判断企业ID与企业名称是否对应
     *
     * @param companyID   企业ID
     * @param companyName 企业名称
     * @return 是否对应
     * @throws RemoteException
     */
    public boolean isCompanyIDCorrect(String companyID, String companyName) throws RemoteException{
        return userCompanyInfo.isCompanyIDCorrect(companyID,companyName);
    }


    /**
     * 添加帐号至数据层并返回用户ID
     *
     * @param vo 帐号信息
     * @return 用户ID
     * @throws RemoteException
     */
    private String addAccount(AccountVO vo) throws RemoteException {
        //获得某个类型数目，以便编成ID
        int num = logDataService.getTypeNum(vo.getType());
        String id = String.valueOf(num + 1);
        while (id.length() < Integer.valueOf(CfgReader.getInstance().getProperty("idLength"))) {
            id = "0" + id;
        }
        //前两位加上人员标识
        if (vo.getType().equals(AccountType.user))
            id = CfgReader.getInstance().getProperty("userSignal") + id;
        else if (vo.getType().equals(AccountType.hotelsaler))
            id = CfgReader.getInstance().getProperty("hotelsalerSignal") + id;
        else if (vo.getType().equals(AccountType.webmanager))
            id = CfgReader.getInstance().getProperty("webmanagerSignal") + id;
        else if (vo.getType().equals(AccountType.websaler))
            id = CfgReader.getInstance().getProperty("websalerSignal") + id;
        logDataService.addAccount(new AccountPO(id, vo.getAccount(), vo.getPassword(), vo.getType()));
        return id;
    }
}

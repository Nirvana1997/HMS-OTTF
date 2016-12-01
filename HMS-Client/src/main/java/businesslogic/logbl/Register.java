package businesslogic.logbl;

import data_stub.hotelsalerdata.HotelinfoDataImpl_stub;
import data_stub.logdata.LogDataImpl_stub;
import data_stub.userdata.UserDataImpl_stub;
import data_stub.websalerdata.WebsalerDataImpl_stub;
import dataservice.hotelsalerdataservice.HotelinfoDataService;
import dataservice.logdataservice.LogDataService;
import dataservice.userdataservice.UserDataService;
import dataservice.websalerdataservice.WebsalerDataService;
import enumData.ResultMessage;
import po.AccountPO;
import po.UserInfoPO;
import rmi.RemoteHelper;
import vo.*;

import java.rmi.RemoteException;

/**
 * 负责接收注册的信息并添加至数据层
 *
 * @author qzh
 *         Created by user on 2016/11/25.
 */
public class Register {
    LogDataService logDataService;
    UserDataService userDataService;
    HotelinfoDataService hotelinfoDataService;
    WebsalerDataService websalerDataService;

    public Register() throws RemoteException {
        //TODO
//        this.logDataService = new LogDataImpl_stub();
        this.userDataService = new UserDataImpl_stub();
//        this.hotelinfoDataService = new HotelinfoDataImpl_stub();
//        this.websalerDataService = new WebsalerDataImpl_stub();
        this.logDataService = RemoteHelper.getInstance().getLogDataService();
    }

    /**
     * 注册帐号
     * @param vo 用户信息
     * @return
     * @throws RemoteException
     */
    public ResultMessage register(AccountVO vo)throws RemoteException {
        addAccount(vo);
        return ResultMessage.Correct;
    }

    /**
     * 判断两次密码是否一致以及是否已存在帐号
     * @param vo 帐号密码确认信息
     * @return
     */
    public ResultMessage isValid(PasswordComfirmVO vo) throws RemoteException {
        if(!vo.getPassword().equals(vo.getConfirm()))
            return ResultMessage.NotSame;
        else if(logDataService.hasExisted(vo.getAcccountID()))
            return ResultMessage.HasExist;
        return ResultMessage.Correct;
    }

    /**
     * 添加帐号至数据层
     * @param vo
     * @throws RemoteException
     */
    private void addAccount(AccountVO vo) throws RemoteException {
        logDataService.addAccount(new AccountPO(vo.getAccountID(), vo.getPassword(), vo.getType()));
    }

    /**
     * 添加用户信息
     * @param vo 用户个人信息
     * @throws RemoteException
     */
    public void addUserInfo(UserInfoVO vo) throws RemoteException {
        UserInfoPO po = new UserInfoPO(vo.getUserID(),vo.getName(),vo.getIdentity(),vo.getContactNumber(),vo.getCredit(),vo.getTransaction());
        userDataService.addUserInfo(po);
    }
}

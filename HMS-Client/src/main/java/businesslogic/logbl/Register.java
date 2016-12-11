package businesslogic.logbl;

import businesslogic.hotelsalerbl.impl.HotelDataImpl;
import businesslogic.userbl.impl.UserDataImpl;
import cfg.Temp;
import data_stub.logdata.LogDataImpl_stub;
import data_stub.websalerdata.WebsalerDataImpl_stub;
import dataservice.logdataservice.LogDataService;
import dataservice.websalerdataservice.WebsalerDataService;
import enumData.AccountType;
import enumData.ResultMessage;
import po.AccountPO;
import vo.AccountVO;
import vo.HotelinfoVO;
import vo.PasswordComfirmVO;
import vo.UserInfoVO;

import java.rmi.RemoteException;

/**
 * 负责接收客户注册的信息并添加至数据层
 *
 * @author qzh
 *         Created by user on 2016/11/25.
 */
public class Register {
    LogDataService logDataService;
    UserInfoAdder userInfoAdder;

    public Register() throws RemoteException {
        //TODO
        this.logDataService = new LogDataImpl_stub();
        this.userInfoAdder = new UserDataImpl();
//        this.logDataService = RemoteHelper.getInstance().getLogDataService();
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
     * @param vo 帐号信息
     * @throws RemoteException
     */
    private void addAccount(AccountVO vo) throws RemoteException {
        //获得某个类型数目，以便编成ID
        int num = logDataService.getTypeNum(vo.getType());
        String id = String.valueOf(num);
        while (id.length()< Temp.ID_NUMBER_LENGTH) {
            id = "0" + id;
        }
        //前两位加上人员标识
        if(vo.getType().equals(AccountType.user))
            id = Temp.USER+id;
        else if(vo.getType().equals(AccountType.hotelsaler))
            id = Temp.HOTELSALER+id;
        else if(vo.getType().equals(AccountType.webmanager))
            id = Temp.WEB_MANAGER+id;
        else if(vo.getType().equals(AccountType.websaler))
            id = Temp.WEB_SALER+id;
        logDataService.addAccount(new AccountPO(vo.getAccount(),id, vo.getPassword(), vo.getType()));
    }

    /**
     * 添加用户信息
     * @param vo 用户个人信息
     * @throws RemoteException
     */
    public void addUserInfo(UserInfoVO vo) throws RemoteException {
        userInfoAdder.addUserInfo(vo);
    }


}

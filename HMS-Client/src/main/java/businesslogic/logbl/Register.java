package businesslogic.logbl;

import businesslogic.promotionbl.strategies.Strategy;
import cfg.Temp;
import enumData.AccountType;
import utility.UserPVChanger;
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
        this.logDataService = new LogDataImpl_stub();
        this.userDataService = new UserDataImpl_stub();
        this.hotelinfoDataService = new HotelinfoDataImpl_stub();
        this.websalerDataService = new WebsalerDataImpl_stub();
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
     * @param vo
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
        UserInfoPO po = UserPVChanger.userInfoV2P(vo);
        userDataService.addUserInfo(po);
    }

    /**
     * TODO
     * 添加用户信息
     * @param vo 用户个人信息
     * @throws RemoteException
     */
    public void addHotelInfo(UserInfoVO vo) throws RemoteException {
        UserInfoPO po = UserPVChanger.userInfoV2P(vo);
        userDataService.addUserInfo(po);
    }
}

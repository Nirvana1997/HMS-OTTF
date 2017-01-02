package businesslogic.userbl.impl;

import businesslogic.hotelsalerbl.interfaces.CreditInfoForHotel;
import businesslogic.logbl.interfaces.UserInfoAdder;
import businesslogic.webmanagerbl.interfaces.UserInfoForManagement;
import businesslogic.websalerbl.interfaces.CreditInfo;
import dataservice.userdataservice.UserDataService;
import enumData.ResultMessage;
import po.CreditChangePO;
import po.UserInfoPO;
import rmi.RemoteHelper;
import utility.UserPVChanger;
import vo.UserInfoVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * 用户数据实现
 * 给其他模块提供数据
 * @author qzh
 * Created by user on 2016/12/3.
 */
public class UserDataImpl implements UserInfoForManagement,CreditInfo,UserInfoAdder,CreditInfoForHotel {
    /**
     * 用户数据模块
     */
    UserDataService userDataService;

    public UserDataImpl() {
        //TODO
//        userDataService = new UserDataImpl_stub();
        userDataService = RemoteHelper.getInstance().getUserDataService();
    }

    /**
     * 获得某个用户的信息
     * @param userID
     * @return 用户信息
     */
    @Override
    public UserInfoPO getUserInfo(String userID) throws RemoteException {
        return userDataService.getUserInfo(userID);
    }

    /**
     * 设置个人信息
     * @param po 个人信息po
     * @throws RemoteException
     */
    @Override
    public void setUserInfo(UserInfoPO po) throws RemoteException{
        userDataService.setUserInfo(po);
    }

    /**
     * 获取用户列表
     * @return 用户列表
     */
    @Override
    public ArrayList<UserInfoPO> getUserList() throws RemoteException{
        return userDataService.getUserInfoList();
    }

    /**
     * 为用户增加信用值
     *
     * @param po 信用值变化情况
     * @return 是否成功
     */
    public ResultMessage addCredit(CreditChangePO po) throws RemoteException {
        //判断用户是否存在
        if(userDataService.getUserInfo(po.getUserID())!=null) {
            userDataService.addCredit(po);
            return ResultMessage.Correct;
        }
        else{
            return ResultMessage.NotExist;
        }
    }

    /**
     * 获得对应用户信用值
     *
     * @param userID 用户ID
     * @return 对应信用值
     */
    @Override
    public int getCredit(String userID) throws RemoteException {
        return userDataService.getUserInfo(userID).getCredit();
    }

    /**
     * 添加用户信息
     * @param vo 用户个人信息
     * @throws RemoteException
     */
    @Override
    public void addUserInfo(UserInfoVO vo) throws RemoteException {
        userDataService.addUserInfo(UserPVChanger.userInfoV2P(vo));
    }
}

package businesslogic.userbl.impl;

import businesslogic.hotelsalerbl.CreditInfoForHotel;
import businesslogic.logbl.UserInfoAdder;
import businesslogic.webmanagerbl.UserInfoForManagement;
import businesslogic.websalerbl.CreditInfo;
import data_stub.userdata.UserDataImpl_stub;
import dataservice.userdataservice.UserDataService;
import enumData.ResultMessage;
import po.UserInfoPO;
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
        userDataService = new UserDataImpl_stub();
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
     * @param userID 用户ID
     * @param value  增加的值
     * @return 是否成功
     */
    @Override
    public ResultMessage addCredit(String userID, int value) throws RemoteException {
        UserInfoPO po = userDataService.getUserInfo(userID);
        po.setCredit(po.getCredit()+value);
        userDataService.setUserInfo(po);
        return ResultMessage.Correct;
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

package businesslogic.userbl.impl;

import businesslogic.webmanagerbl.UserDataManagement;
import data_stub.userdata.UserDataImpl_stub;
import dataservice.userdataservice.UserDataService;
import po.UserInfoPO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * 用户数据实现
 * 给其他模块提供数据
 * @author qzh
 * Created by user on 2016/12/3.
 */
public class UserDataImpl implements UserDataManagement {
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
    public ArrayList<UserInfoPO> getUserList(ArrayList<String> userIDs) throws RemoteException{
        ArrayList<UserInfoPO> res = new ArrayList<UserInfoPO>();
        for(String userID:userIDs){
            res.add(userDataService.getUserInfo(userID));
        }
        return res;
    }
}

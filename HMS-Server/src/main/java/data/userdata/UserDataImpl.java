package data.userdata;

import dataservice.userdataservice.UserDataService;
import enumData.ResultMessage;
import po.UserInfoPO;

/**
 * Created by mac on 2016/11/23.
 */
public class UserDataImpl implements UserDataService {
    @Override
    public UserInfoPO getUserInfo(String userID) {
        return null;
    }

    @Override
    public ResultMessage setUserInfo(UserInfoPO po) {
        return null;
    }

    @Override
    public ResultMessage addUserInfo(UserInfoPO po) {
        return null;
    }

    @Override
    public ResultMessage deleteUserInfo(String userID) {
        return null;
    }

    @Override
    public ResultMessage addCredit(String userID, int value) {
        return null;
    }

    @Override
    public ResultMessage subCredit(String userID, int value) {
        return null;
    }
}

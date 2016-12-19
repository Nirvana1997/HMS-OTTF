package businesslogic.webmanagerbl;

import po.UserInfoPO;
import utility.VipInfo;
import businesslogic.userbl.impl.UserDataImpl;
import utility.UserPVChanger;
import businesslogic.websalerbl.impl.VipDataImpl;
import vo.UserInfoVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * 用户管理模块
 *
 * @author qzh
 */
public class URmanagement {
    /**
     * 用户数据管理模块
     */
    UserInfoForManagement userInfoForManagement;

    /**
     * 用户等级模块
     */
    VipInfo vipInfo;

    public URmanagement() {
        userInfoForManagement = new UserDataImpl();
        vipInfo = new VipDataImpl();
    }

    /**
     * 获取用户信息
     *
     * @param userID 用户ID
     * @return 对应用户信息
     * @throws RemoteException
     */
    public UserInfoVO getUserInfo(String userID) throws RemoteException {
        UserInfoPO po = userInfoForManagement.getUserInfo(userID);
        return UserPVChanger.userInfoP2V(po);
    }

    /**
     * 修改用户信息
     *
     * @param vo 用户个人信息vo
     */
    public void setUserInfo(UserInfoVO vo) throws RemoteException {
        userInfoForManagement.setUserInfo(UserPVChanger.userInfoV2P(vo));
    }

    /**
     * 获得所有用户信息列表
     *
     * @return 所有用户信息列表
     */
    public ArrayList<UserInfoVO> getUserList() throws RemoteException {
        ArrayList<UserInfoVO> res = new ArrayList<UserInfoVO>();
        for(UserInfoPO po:userInfoForManagement.getUserList()){
            res.add(UserPVChanger.userInfoP2V(po));
        }
        return res;
    }

}

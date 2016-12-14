package businesslogicservice.webmanagerlogicservice;

import enumData.ResultMessage;
import vo.UserInfoVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * 用户管理接口
 * @author qzh
 */
public interface URmanagementBlService {
    /**
     * 获取用户信息
     * @param userID 用户ID
     * @return 对应用户信息
     * @throws RemoteException
     */
    UserInfoVO getUserInfo(String userID) throws RemoteException;

    /**
     * 修改用户信息
     * @param vo 用户个人信息vo
     */
    void setUserInfo(UserInfoVO vo) throws RemoteException;

	ArrayList<UserInfoVO> getUserList() throws RemoteException;
}

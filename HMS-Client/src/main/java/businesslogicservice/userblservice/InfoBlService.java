package businesslogicservice.userblservice;

import businesslogic.userbl.UserInfo;
import enumData.ResultMessage;
import vo.UserInfoVO;

import java.rmi.RemoteException;

/**
 * 个人信息接口
 * @author qzh
 */
public interface InfoBlService {
    /**
     * 修改个人信息
     * @param vo 个人信息
     * @return
     * @throws RemoteException
     */
	public ResultMessage modifyUserInfo (UserInfoVO vo)throws RemoteException;

    /**
     * 显示个人信息
     * @param userID 用户ID
     * @return
     * @throws RemoteException
     */
	public UserInfoVO showUserInfo(String userID)throws RemoteException;
}

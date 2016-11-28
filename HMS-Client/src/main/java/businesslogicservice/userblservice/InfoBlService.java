package businesslogicservice.userblservice;

import businesslogic.userbl.UserInfo;
import enumData.ResultMessage;
import vo.UserInfoVO;

/**
 * 个人信息接口
 * @author qzh
 */
public interface InfoBlService {
    /**
     * 修改个人信息
     * @param vo 个人信息
     * @return
     */
	public ResultMessage modifyUserInfo (UserInfoVO vo);

    /**
     * 显示个人信息
     * @param userID
     */
	public void showUserInfo(String userID);
}

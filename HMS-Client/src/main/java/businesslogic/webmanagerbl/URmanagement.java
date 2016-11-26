package businesslogic.webmanagerbl;

import vo.UserInfoVO;

/**
 * 负责对客户的管理
 * @author qzh
 * Created by user on 2016/11/22.
 */
public interface URmanagement {
    public UserInfoVO getUserInfo(String userID);

    public void setUserInfo(UserInfoVO vo);
}

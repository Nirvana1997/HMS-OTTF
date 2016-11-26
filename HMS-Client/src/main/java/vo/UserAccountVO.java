package vo;

import enumData.AccountType;

/**
 * Created by user on 2016/11/24.
 */
public class UserAccountVO extends AccountVO{
    UserInfoVO vo;
    public UserAccountVO(String accountID, String password, AccountType type,UserInfoVO vo) {
        super(accountID, password, type);
        this.vo = vo;
    }

    public UserInfoVO getVo() {
        return vo;
    }

    public void setVo(UserInfoVO vo) {
        this.vo = vo;
    }
}

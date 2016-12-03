package vo;

/**
 * 帐号及密码确认信息
 * Created by user on 2016/11/25.
 */
public class PasswordComfirmVO {
    String acccountID;
    String password;
    String confirm;

    public PasswordComfirmVO(String acccountID, String password, String confirm) {
        this.acccountID = acccountID;
        this.password = password;
        this.confirm = confirm;
    }

    public String getAcccountID() {
        return acccountID;
    }

    public void setAcccountID(String acccountID) {
        this.acccountID = acccountID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }
}

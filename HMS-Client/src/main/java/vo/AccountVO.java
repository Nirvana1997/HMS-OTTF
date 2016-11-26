package vo;

import enumData.AccountType;

/**
 * 帐号信息VO
 * @author qzh
 */
public class AccountVO {
    /**
     * 帐号ID
     */
	String accountID;
    /**
     * 密码
     */
	String password;
    /**
     * 帐号类型
     */
	AccountType type;
	
	public AccountVO(String accountID, String password, AccountType type) {
		this.accountID = accountID;
		this.password = password;
		this.type = type;
	}

	public String getAccountID() {
		return accountID;
	}
	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public AccountType getType() {
		return type;
	}
	public void setType(AccountType type) {
		this.type = type;
	}
	
}

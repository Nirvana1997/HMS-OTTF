package vo;

import enumData.AccountType;

/**
 * 帐号信息VO
 * @author qzh
 */
public class AccountVO {
	/**
	 * 用户
	 */
	String ID;

    /**
     * 帐号
     */
	String account;

    /**
     * 密码
     */
	String password;

    /**
     * 帐号类型
     */
	AccountType type;

	public AccountVO(String ID, String account, String password, AccountType type) {
		this.ID = ID;
		this.account = account;
		this.password = password;
		this.type = type;
	}

	//ID由逻辑层生成
	public AccountVO(String account, String password, AccountType type) {
		this.account = account;
		this.password = password;
		this.type = type;
	}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
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

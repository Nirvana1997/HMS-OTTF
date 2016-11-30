package po;

import enumData.AccountType;

import java.io.Serializable;

public class AccountPO implements Serializable {
	String accountID;
	String password;
	AccountType type;

	public AccountPO(String accountID, String password, AccountType type) {
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

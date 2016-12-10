package po;

import enumData.AccountType;

import java.io.Serializable;

public class AccountPO implements Serializable {
	String ID;
	String accountID;
	String password;
	AccountType type;

	public AccountPO(String ID, String accountID, String password, AccountType type) {
		this.ID = ID;
		this.accountID = accountID;
		this.password = password;
		this.type = type;
	}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
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

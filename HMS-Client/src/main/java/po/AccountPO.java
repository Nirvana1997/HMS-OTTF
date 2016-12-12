package po;

import enumData.AccountType;

import java.io.Serializable;

public class AccountPO implements Serializable {
	String ID;
	String account;
	String password;
	AccountType type;

	public AccountPO(String ID, String account, String password, AccountType type) {
		this.ID = ID;
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

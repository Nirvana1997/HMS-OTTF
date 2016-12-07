package po;

import enumData.UserType;

public class UserInfoPO {
	String userID;
	String name;
	String identity;
	String contactNumber;
	int credit;
	String birthday;
	String companyID;
	UserType type;

	public UserInfoPO(String userID, String name, String identity, String contactNumber,
					  int credit, String birthday, String companyID, UserType type) {
		this.userID = userID;
		this.name = name;
		this.identity = identity;
		this.contactNumber = contactNumber;
		this.credit = credit;
		this.birthday = birthday;
		this.companyID = companyID;
		this.type = type;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getCompanyID() {
		return companyID;
	}

	public void setCompanyID(String companyID) {
		this.companyID = companyID;
	}

	public UserType getType() {
		return type;
	}

	public void setType(UserType type) {
		this.type = type;
	}
}

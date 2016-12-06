package vo;

import enumData.UserType;

public class UserInfoVO {
	String userID;
	String name;
	String identity;
	String contactNumber;
	double credit;
    String birthday;
    String companyID;
	UserType userType;
	int vipLevel;

    public UserInfoVO(String userID, String name, String identity, String contactNumber, double credit, String birthday, String companyID, UserType userType, int vipLevel) {
        this.userID = userID;
        this.name = name;
        this.identity = identity;
        this.contactNumber = contactNumber;
        this.credit = credit;
        this.birthday = birthday;
        this.companyID = companyID;
        this.userType = userType;
        this.vipLevel = vipLevel;
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

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
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

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public int getVipLevel() {
        return vipLevel;
    }

    public void setVipLevel(int vipLevel) {
        this.vipLevel = vipLevel;
    }
}

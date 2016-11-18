package vo;

public class UserInfoVO {
	String userID;
	String name;
	String identity;
	String contactNumber;
	int credit;
	int memLevel;
	
	public UserInfoVO(String userID, String name, String identity,
			String contactNumber, int credit, int vipLevel) {
		this.userID = userID;
		this.name = name;
		this.identity = identity;
		this.contactNumber = contactNumber;
		this.credit = credit;
		this.memLevel = vipLevel;
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
	public int getVipLevel() {
		return memLevel;
	}
	public void setVipLevel(int vipLevel) {
		this.memLevel = vipLevel;
	}
	
	
}

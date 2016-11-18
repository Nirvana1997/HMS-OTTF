package vo;

public class WebsalerInfoVO {
	String websalerID;
	String contactNumber;
	
	public WebsalerInfoVO(String websalerID, String contactNumber) {
		super();
		this.websalerID = websalerID;
		this.contactNumber = contactNumber;
	}
	
	public String getWebsalerID() {
		return websalerID;
	}
	public void setWebsalerID(String websalerID) {
		this.websalerID = websalerID;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	
}

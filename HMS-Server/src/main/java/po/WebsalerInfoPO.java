package po;

import java.io.Serializable;

public class WebsalerInfoPO implements Serializable{
	String websalerID;
	String contactNumber;
	
	public WebsalerInfoPO(String websalerID, String contactNumber) {
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

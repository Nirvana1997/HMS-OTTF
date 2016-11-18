package po;

public class HotelsalerInfoPO {
	String hotelID;
	String hotelname;
	String contactNumber;
	
	public HotelsalerInfoPO(String hotelID, String hotelname, String contactNumber) {
		this.hotelID = hotelID;
		this.hotelname = hotelname;
		this.contactNumber = contactNumber;
	}
	
	public String getHotelID() {
		return hotelID;
	}
	public void setHotelID(String hotelID) {
		this.hotelID = hotelID;
	}
	public String getHotelname() {
		return hotelname;
	}
	public void setHotelname(String hotelname) {
		this.hotelname = hotelname;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
}

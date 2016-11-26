package vo;

public class HotelsalerInfoVO {
	String hotelID;
	String hotelname;

	public HotelsalerInfoVO(String hotelID, String hotelname) {
		this.hotelID = hotelID;
		this.hotelname = hotelname;
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
}

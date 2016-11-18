package vo;

public class CommentVO {
	String hotelID;
	String userID;
	String comment;
	
	public CommentVO(String hotelID, String userID, String comment) {
		super();
		this.hotelID = hotelID;
		this.userID = userID;
		this.comment = comment;
	}
	
	public String getHotelID() {
		return hotelID;
	}
	public void setHotelID(String hotelID) {
		this.hotelID = hotelID;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
}

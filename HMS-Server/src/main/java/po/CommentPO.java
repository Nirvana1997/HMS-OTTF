package po;

public class CommentPO {
	String hotelID;
	String userID;
	String comment;
	int grade;
	
	public CommentPO(String hotelID, String userID, String comment, int grade) {
		super();
		this.hotelID = hotelID;
		this.userID = userID;
		this.comment = comment;
		this.grade = grade;
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
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
}
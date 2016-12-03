package po;

import java.util.Date;

import enumData.OrderState;
import enumData.RoomType;

public class OrderPO {
	String orderID;
	String hotelID;
	String userID;
	String roomID;
	int roomNumber;
	int peopleNumber;
	OrderState orderState;
	String checkInDate;
	String checkOutDate;
	String ddl;
	RoomType roomType;
	double price;
	boolean haveChild;

	public OrderPO(String orderID, String hotelID, String userID, String roomID, int roomNumber,
				   int peopleNumber, OrderState orderState, String checkInDate,
				   String checkOutDate, String ddl, RoomType roomType, double price, boolean haveChild) {
		this.orderID = orderID;
		this.hotelID = hotelID;
		this.userID = userID;
		this.roomID = roomID;
		this.roomNumber = roomNumber;
		this.peopleNumber = peopleNumber;
		this.orderState = orderState;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.ddl = ddl;
		this.roomType = roomType;
		this.price = price;
		this.haveChild = haveChild;
	}

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
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

	public String getRoomID() {
		return roomID;
	}

	public void setRoomID(String roomID) {
		this.roomID = roomID;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public int getPeopleNumber() {
		return peopleNumber;
	}

	public void setPeopleNumber(int peopleNumber) {
		this.peopleNumber = peopleNumber;
	}

	public OrderState getOrderState() {
		return orderState;
	}

	public void setOrderState(OrderState orderState) {
		this.orderState = orderState;
	}

	public String getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(String checkInDate) {
		this.checkInDate = checkInDate;
	}

	public String getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(String checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public String getDdl() {
		return ddl;
	}

	public void setDdl(String ddl) {
		this.ddl = ddl;
	}

	public RoomType getRoomType() {
		return roomType;
	}

	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isHaveChild() {
		return haveChild;
	}

	public void setHaveChild(boolean haveChild) {
		this.haveChild = haveChild;
	}
}

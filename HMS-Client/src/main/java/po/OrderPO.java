package po;

import enumData.OrderState;
import enumData.RoomType;

import java.util.Date;

public class OrderPO {
	String orderID;
	OrderState orderState;
	String hotelID;
	String userID;
	Date date;
	RoomType roomType;

	public OrderPO(String orderID, OrderState orderState, String hotelID, String userID, Date date, RoomType roomType) {
		this.orderID = orderID;
		this.orderState = orderState;
		this.hotelID = hotelID;
		this.userID = userID;
		this.date = date;
		this.roomType = roomType;
	}

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public OrderState getOrderState() {
		return orderState;
	}

	public void setOrderState(OrderState orderState) {
		this.orderState = orderState;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public RoomType getRoomType() {
		return roomType;
	}

	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}
}

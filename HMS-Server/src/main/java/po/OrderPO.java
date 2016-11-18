package po;

import java.util.Date;

import enumData.OrderState;

public class OrderPO {
	String orderID;
	OrderState orderState;
	String hotelID;
	String userID;
	Date date;
	String roomID;
	
	public OrderPO(String orderID, OrderState orderState, String hotelID,
			String userID, Date date, String roomID) {
		super();
		this.orderID = orderID;
		this.orderState = orderState;
		this.hotelID = hotelID;
		this.userID = userID;
		this.date = date;
		this.roomID = roomID;
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
	public String getRoomID() {
		return roomID;
	}
	public void setRoomID(String roomID) {
		this.roomID = roomID;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
}

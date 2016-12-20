package po;

import java.io.Serializable;
import java.util.Date;

import enumData.Address;
import enumData.OrderState;
import enumData.RoomType;
import enumData.TradeArea;

public class OrderPO implements Serializable{
	String orderID;
	String hotelID;
	String userID;
	String roomID;
	int roomNumber;
	int peopleNumber;
	OrderState orderState;
	String checkInDate;
	String checkOutDate;
	RoomType roomType;
	double price;
	boolean haveChild;
	String hotelName;
	String promotionName;
	TradeArea tradeArea;
	Address address;
	String detailAddress;

	public OrderPO(String orderID, String hotelID, String userID, String roomID, int roomNumber, int peopleNumber,
				   OrderState orderState, String checkInDate, String checkOutDate, RoomType roomType, double price,
				   boolean haveChild, String hotelName, String promotionName, TradeArea tradeArea, Address address, String detailAddress) {
		this.orderID = orderID;
		this.hotelID = hotelID;
		this.userID = userID;
		this.roomID = roomID;
		this.roomNumber = roomNumber;
		this.peopleNumber = peopleNumber;
		this.orderState = orderState;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.roomType = roomType;
		this.price = price;
		this.haveChild = haveChild;
		this.hotelName = hotelName;
		this.promotionName = promotionName;
		this.tradeArea = tradeArea;
		this.address = address;
		this.detailAddress = detailAddress;
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

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getPromotionName() {
		return promotionName;
	}

	public void setPromotionName(String promotionName) {
		this.promotionName = promotionName;
	}

	public TradeArea getTradeArea() {
		return tradeArea;
	}

	public void setTradeArea(TradeArea tradeArea) {
		this.tradeArea = tradeArea;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getDetailAddress() {
		return detailAddress;
	}

	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}
}

package po;

import enumData.Address;
import enumData.OrderState;
import enumData.RoomType;
import enumData.TradeArea;

import java.util.Date;

public class OrderPO {
	String hotelID;
	String hotelname;
	TradeArea tradeArea;
	Address address;
	String detailAddress;
	int roomNumber;
	int peopleNumber;
	String checkInDate;
	String checkOutDate;
	RoomType roomType;
	boolean haveChild;
	String orderID;
	String userID;
	OrderState orderState;
	Date ddl;
	double price;
	String promotionName;
	String roomID;

	public OrderPO(String hotelID, String hotelname, TradeArea tradeArea, Address address, String detailAddress, int roomNumber, int peopleNumber, String checkInDate, String checkOutDate, RoomType roomType, boolean haveChild, String orderID, String userID, OrderState orderState, Date ddl, double price, String promotionName, String roomID) {
		this.hotelID = hotelID;
		this.hotelname = hotelname;
		this.tradeArea = tradeArea;
		this.address = address;
		this.detailAddress = detailAddress;
		this.roomNumber = roomNumber;
		this.peopleNumber = peopleNumber;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.roomType = roomType;
		this.haveChild = haveChild;
		this.orderID = orderID;
		this.userID = userID;
		this.orderState = orderState;
		this.ddl = ddl;
		this.price = price;
		this.promotionName = promotionName;
		this.roomID = roomID;
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

	public boolean isHaveChild() {
		return haveChild;
	}

	public void setHaveChild(boolean haveChild) {
		this.haveChild = haveChild;
	}

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public OrderState getOrderState() {
		return orderState;
	}

	public void setOrderState(OrderState orderState) {
		this.orderState = orderState;
	}

	public Date getDdl() {
		return ddl;
	}

	public void setDdl(Date ddl) {
		this.ddl = ddl;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getPromotionName() {
		return promotionName;
	}

	public void setPromotionName(String promotionName) {
		this.promotionName = promotionName;
	}

	public String getRoomID() {
		return roomID;
	}

	public void setRoomID(String roomID) {
		this.roomID = roomID;
	}
}

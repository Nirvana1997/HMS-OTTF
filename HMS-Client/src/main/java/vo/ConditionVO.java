package vo;

import java.util.Date;

import enumData.Address;
import enumData.RoomType;
import enumData.SortWay;
import enumData.TradeArea;

public class ConditionVO {
	String keyWord;
	String userID;
	Address address;
	TradeArea tradeArea;
	SortWay sortWay;
	RoomType roomType;
	int minPrice;
	int maxPrice;
	boolean hasOrdered;
	Date date;
	boolean hasEmptyRoom;
	int star;
	int grade;

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public TradeArea getTradeArea() {
		return tradeArea;
	}

	public void setTradeArea(TradeArea tradeArea) {
		this.tradeArea = tradeArea;
	}

	public SortWay getSortWay() {
		return sortWay;
	}

	public void setSortWay(SortWay sortWay) {
		this.sortWay = sortWay;
	}

	public RoomType getRoomType() {
		return roomType;
	}

	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}

	public int getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(int minPrice) {
		this.minPrice = minPrice;
	}

	public int getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(int maxPrice) {
		this.maxPrice = maxPrice;
	}

	public boolean isHasOrdered() {
		return hasOrdered;
	}

	public void setHasOrdered(boolean hasOrdered) {
		this.hasOrdered = hasOrdered;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public boolean isHasEmptyRoom() {
		return hasEmptyRoom;
	}

	public void setHasEmptyRoom(boolean hasEmptyRoom) {
		this.hasEmptyRoom = hasEmptyRoom;
	}

	public int getStar() {
		return star;
	}

	public void setStar(int star) {
		this.star = star;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public ConditionVO(String keyWord, String userID, Address address, TradeArea tradeArea, SortWay sortWay, RoomType roomType, int minPrice, int maxPrice, boolean hasOrdered, Date date, boolean hasEmptyRoom, int star, int grade) {
		this.keyWord = keyWord;
		this.userID = userID;
		this.address = address;
		this.tradeArea = tradeArea;
		this.sortWay = sortWay;
		this.roomType = roomType;
		this.minPrice = minPrice;
		this.maxPrice = maxPrice;
		this.hasOrdered = hasOrdered;
		this.date = date;
		this.hasEmptyRoom = hasEmptyRoom;
		this.star = star;
		this.grade = grade;

	}
}
package po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import enumData.PromotionType;
import enumData.TradeArea;

public class PromotionPO implements Serializable{
	String name;
	PromotionType promotionType;
	String startDate;
	String endDate;
	TradeArea tradeArea;
	int roomNumber;
	int vipLevel;
	double discount;
	String hotelID;
	String description;

	public PromotionPO(String name, PromotionType promotionType, String startDate, String endDate, TradeArea tradeArea,
					   int roomNumber, int vipLevel, double discount, String hotelID, String description) {
		this.name = name;
		this.promotionType = promotionType;
		this.startDate = startDate;
		this.endDate = endDate;
		this.tradeArea = tradeArea;
		this.roomNumber = roomNumber;
		this.vipLevel = vipLevel;
		this.discount = discount;
		this.hotelID = hotelID;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PromotionType getPromotionType() {
		return promotionType;
	}

	public void setPromotionType(PromotionType promotionType) {
		this.promotionType = promotionType;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public TradeArea getTradeArea() {
		return tradeArea;
	}

	public void setTradeArea(TradeArea tradeArea) {
		this.tradeArea = tradeArea;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public int getVipLevel() {
		return vipLevel;
	}

	public void setVipLevel(int vipLevel) {
		this.vipLevel = vipLevel;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public String getHotelID() {
		return hotelID;
	}

	public void setHotelID(String hotelID) {
		this.hotelID = hotelID;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}


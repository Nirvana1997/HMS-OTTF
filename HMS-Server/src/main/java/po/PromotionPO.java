package po;

import java.util.ArrayList;
import java.util.Date;

import enumData.PromotionType;
import enumData.TradeArea;

public class PromotionPO {
	String promotionID;
	PromotionType promotionType;
	String startDate;
	String endDate;
	TradeArea tradeArea;
	int roomNumber;
	int vipLevel;
	double discount;

	public PromotionPO(String promotionID, PromotionType promotionType, String startDate, String endDate,
					   TradeArea tradeArea, int roomNumber, int vipLevel, double discount) {
		this.promotionID = promotionID;
		this.promotionType = promotionType;
		this.startDate = startDate;
		this.endDate = endDate;
		this.tradeArea = tradeArea;
		this.roomNumber = roomNumber;
		this.vipLevel = vipLevel;
		this.discount = discount;
	}

	public String getPromotionID() {
		return promotionID;
	}

	public void setPromotionID(String promotionID) {
		this.promotionID = promotionID;
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
}


package po;

import cfg.Temp;
import enumData.PromotionType;
import enumData.TradeArea;

public class PromotionPO {
	String promotionName;
	String description;
	PromotionType promotionType;
	String hotelID;
	String startDate;
	String endDate;
	TradeArea tradeArea;
	int roomNumber = Temp.DISCOUNT_NUM;
	int vipLevel;
	double discount;

    public PromotionPO(String promotionName, String description, PromotionType promotionType, String hotelID, String startDate, String endDate, TradeArea tradeArea, int roomNumber, int vipLevel, double discount) {
        this.promotionName = promotionName;
        this.description = description;
        this.promotionType = promotionType;
        this.hotelID = hotelID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.tradeArea = tradeArea;
        this.roomNumber = roomNumber;
        this.vipLevel = vipLevel;
        this.discount = discount;
    }

    public String getPromotionName() {
        return promotionName;
    }

    public void setPromotionName(String promotionName) {
        this.promotionName = promotionName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PromotionType getPromotionType() {
        return promotionType;
    }

    public void setPromotionType(PromotionType promotionType) {
        this.promotionType = promotionType;
    }

    public String getHotelID() {
        return hotelID;
    }

    public void setHotelID(String hotelID) {
        this.hotelID = hotelID;
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


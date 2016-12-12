package vo;

import java.util.ArrayList;
import java.util.Date;

import cfg.Temp;
import enumData.PromotionType;
import enumData.TradeArea;

public class PromotionVO {
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
	String companyID;

	public PromotionVO(String promotionName, String description, PromotionType promotionType, String hotelID, String startDate, String endDate, TradeArea tradeArea, int roomNumber, int vipLevel, double discount,String companyID) {
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
		this.companyID = companyID;
	}

	/**
	 * 双十一优惠活动构造器
	 * @param name
	 * @param description
	 * @param web_period
	 * @param beginTime
	 * @param endTime
	 * @param discount
	 */
	public PromotionVO(String name, String description, PromotionType web_period, String beginTime, String endTime, double discount) {
        this.promotionName = name;
        this.description = description;
        this.promotionType = web_period;
        this.startDate = beginTime;
        this.endDate = endTime;
        this.discount = discount;
    }

    /**
     * 特定商圈优惠活动构造器
     * @param name
     * @param description
     * @param web_tradeArea
     * @param beginTime
     * @param endTime
     * @param tradeArea
     * @param discount
     */
    public PromotionVO(String name, String description, PromotionType web_tradeArea, String beginTime, String endTime, TradeArea tradeArea, double discount) {
        this.promotionName = name;
        this.description = description;
        this.promotionType = web_tradeArea;
        this.startDate = beginTime;
        this.endDate = endTime;
        this.tradeArea = tradeArea;
        this.discount = discount;
    }

    /**
     * 会员等级策略构造器
     * @param name
     * @param description
     * @param web_vip
     * @param beginTime
     * @param endTime
     * @param vipLevel
     * @param discount
     */
    public PromotionVO(String name, String description, PromotionType web_vip, String beginTime, String endTime, int vipLevel, double discount) {
        this.promotionName = name;
        this.description = description;
        this.promotionType = web_vip;
        this.startDate = beginTime;
        this.endDate = endTime;
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

	public String getCompanyID() {
		return companyID;
	}

	public void setCompanyID(String companyID) {
		this.companyID = companyID;
	}
}
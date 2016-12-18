package vo;

import java.util.Date;

import cfg.CfgReader;
import enumData.PromotionType;
import enumData.TradeArea;

public class PromotionVO {
	String promotionName;
	String description;
	PromotionType promotionType;
	String hotelID;
	Date startDate;
	Date endDate;
	TradeArea tradeArea;
	int roomNumber = Integer.valueOf(CfgReader.getInstance().getProperty("discountNum"));
	int vipLevel;
	double discount;
	String companyID;

	public PromotionVO(String promotionName, String description, PromotionType promotionType, String hotelID, Date startDate, Date endDate, TradeArea tradeArea, int roomNumber, int vipLevel, double discount,String companyID) {
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
	 * 酒店生日特惠
	 * @param promotionName
	 * @param description
	 * @param promotionType
	 * @param discount
	 */
	public PromotionVO(String promotionName, String description, PromotionType promotionType, double discount) {
		this.promotionName = promotionName;
		this.description = description;
		this.promotionType = promotionType;
		this.discount = discount;
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
	public PromotionVO(String name, String description, PromotionType web_period, Date beginTime, Date endTime, double discount) {
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
    public PromotionVO(String name, String description, PromotionType web_tradeArea, Date beginTime, Date endTime, TradeArea tradeArea, double discount) {
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
    public PromotionVO(String name, String description, PromotionType web_vip, Date beginTime, Date endTime, int vipLevel, double discount) {
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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
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
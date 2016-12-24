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
	double discountTenRate;
	String companyID;

	public PromotionVO(String promotionName, String description, PromotionType promotionType, String hotelID, Date startDate, Date endDate, TradeArea tradeArea, int roomNumber, int vipLevel, double discountTenRate, String companyID) {
		this.promotionName = promotionName;
		this.description = description;
		this.promotionType = promotionType;
		this.hotelID = hotelID;
		this.startDate = startDate;
		this.endDate = endDate;
		this.tradeArea = tradeArea;
		this.roomNumber = roomNumber;
		this.vipLevel = vipLevel;
		this.discountTenRate = discountTenRate;
		this.companyID = companyID;
	}

	/**
	 * 酒店生日特惠
	 * @param promotionName
	 * @param description
	 * @param promotionType
	 * @param discountTenRate
	 */
	public PromotionVO(String hotelID,String promotionName, String description, PromotionType promotionType, double discountTenRate) {
		this.promotionName = promotionName;
		this.description = description;
		this.promotionType = promotionType;
		this.discountTenRate = discountTenRate;
		this.hotelID = hotelID;
	}

	/**
	 * 双十一优惠活动构造器
	 * @param name
	 * @param description
	 * @param web_period
	 * @param beginTime
	 * @param endTime
	 * @param discountTenRate
	 */
	public PromotionVO(String name, String description, PromotionType web_period, Date beginTime, Date endTime, double discountTenRate) {
        this.promotionName = name;
        this.description = description;
        this.promotionType = web_period;
        this.startDate = beginTime;
        this.endDate = endTime;
        this.discountTenRate = discountTenRate;
    }

    /**
     * 特定商圈优惠活动构造器
     * @param name
     * @param description
     * @param web_tradeArea
     * @param beginTime
     * @param endTime
     * @param tradeArea
     * @param discountTenRate
     */
    public PromotionVO(String name, String description, PromotionType web_tradeArea, Date beginTime, Date endTime, TradeArea tradeArea, double discountTenRate) {
        this.promotionName = name;
        this.description = description;
        this.promotionType = web_tradeArea;
        this.startDate = beginTime;
        this.endDate = endTime;
        this.tradeArea = tradeArea;
        this.discountTenRate = discountTenRate;
    }

    /**
     * 会员等级策略构造器
     * @param name
     * @param description
     * @param web_vip
     * @param beginTime
     * @param endTime
     * @param vipLevel
     * @param discountTenRate
     */
    public PromotionVO(String name, String description, PromotionType web_vip, Date beginTime, Date endTime, int vipLevel, double discountTenRate) {
        this.promotionName = name;
        this.description = description;
        this.promotionType = web_vip;
        this.startDate = beginTime;
        this.endDate = endTime;
        this.vipLevel = vipLevel;
        this.discountTenRate = discountTenRate;
    }

	/**
	 * 合作企业策略构造器
	 * @param name
	 * @param description
	 * @param hotel_company
	 * @param beginTime
	 * @param endTime
	 * @param discount
	 * @param companyId
	 */
	public PromotionVO(String name, String description, PromotionType hotel_company, Date beginTime, Date endTime, double discount, String companyId) {
		this.promotionName = name;
		this.description = description;
		this.promotionType = hotel_company;
		this.startDate = beginTime;
		this.endDate = endTime;
		this.discountTenRate = discount;
		this.companyID = companyId;
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

	public double getDiscountTenRate() {
		return discountTenRate;
	}

	public void setDiscountTenRate(double discountTenRate) {
		this.discountTenRate = discountTenRate;
	}

	public String getCompanyID() {
		return companyID;
	}

	public void setCompanyID(String companyID) {
		this.companyID = companyID;
	}
}
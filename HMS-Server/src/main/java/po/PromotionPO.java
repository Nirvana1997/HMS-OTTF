package po;

import java.util.ArrayList;
import java.util.Date;

import enumData.PromotionType;
import enumData.TradeArea;

public class PromotionPO {
	String promotionID;
	PromotionType promotionType;
	Date startDate;
	Date endDate;
	TradeArea[] validRange;
	ArrayList<Double> memberDiscount;
	double normalDiscount;
	
	public PromotionPO(String promotionID, PromotionType promotionType,
			Date startDate, Date endDate, TradeArea[] validRange,
			ArrayList<Double> memberDiscount, double normalDiscount) {
		super();
		this.promotionID = promotionID;
		this.promotionType = promotionType;
		this.startDate = startDate;
		this.endDate = endDate;
		this.validRange = validRange;
		this.memberDiscount = memberDiscount;
		this.normalDiscount = normalDiscount;
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
	public ArrayList<Double> getMemberDiscount() {
		return memberDiscount;
	}
	public void setMemberDiscount(ArrayList<Double> memberDiscount) {
		this.memberDiscount = memberDiscount;
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
	public TradeArea[] getValidRange() {
		return validRange;
	}
	public void setValidRange(TradeArea[] validRange) {
		this.validRange = validRange;
	}
	public double getNormalDiscount() {
		return normalDiscount;
	}
	public void setNormalDiscount(double normalDiscount) {
		this.normalDiscount = normalDiscount;
	}
}


package vo;

import enumData.OrderState;

/**
 * 酒店列表项目
 * @author qzh
 * Created on 2016/11/29.
 */
public class HotelListItemVO {
    private String hotelID;
    private String hotelname;
    private String detailAddress;
    private int star;
    private double grade;
    private double minPrice;
    private boolean hasNormalOrder;
    private boolean hasAbnormalOrder;
    private boolean hasCanceledOrder;

    public HotelListItemVO(String hotelID, String hotelname, String detailAddress, int star, double grade, double minPrice, boolean hasNormalOrder, boolean hasAbnormalOrder, boolean hasCanceledOrder) {
        this.hotelID = hotelID;
        this.hotelname = hotelname;
        this.detailAddress = detailAddress;
        this.star = star;
        this.grade = grade;
        this.minPrice = minPrice;
        this.hasNormalOrder = hasNormalOrder;
        this.hasAbnormalOrder = hasAbnormalOrder;
        this.hasCanceledOrder = hasCanceledOrder;
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

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(double minPrice) {
        this.minPrice = minPrice;
    }

    public boolean isHasNormalOrder() {
        return hasNormalOrder;
    }

    public void setHasNormalOrder(boolean hasNormalOrder) {
        this.hasNormalOrder = hasNormalOrder;
    }

    public boolean isHasAbnormalOrder() {
        return hasAbnormalOrder;
    }

    public void setHasAbnormalOrder(boolean hasAbnormalOrder) {
        this.hasAbnormalOrder = hasAbnormalOrder;
    }

    public boolean isHasCanceledOrder() {
        return hasCanceledOrder;
    }

    public void setHasCanceledOrder(boolean hasCanceledOrder) {
        this.hasCanceledOrder = hasCanceledOrder;
    }
}

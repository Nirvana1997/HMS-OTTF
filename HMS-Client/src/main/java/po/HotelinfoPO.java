package po;

import enumData.Address;
import enumData.TradeArea;

import java.io.Serializable;

public class HotelinfoPO implements Serializable {
    String hotelID;
    String hotelName;
    TradeArea tradeArea;
    Address address;
    String detailAddress;
    String introduction;
    String service;
    String contactNumber;
    int star;
    double grade;
    double minPrice;

    public HotelinfoPO(String hotelID, String hotelName, TradeArea tradeArea, Address address, String detailAddress,
                       String introduction, String service, String contactNumber, int star, double grade, double minPrice) {
        this.hotelID = hotelID;
        this.hotelName = hotelName;
        this.tradeArea = tradeArea;
        this.address = address;
        this.detailAddress = detailAddress;
        this.introduction = introduction;
        this.service = service;
        this.contactNumber = contactNumber;
        this.star = star;
        this.grade = grade;
        this.minPrice = minPrice;
    }

    public String getHotelID() {
        return hotelID;
    }

    public void setHotelID(String hotelID) {
        this.hotelID = hotelID;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
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

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
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
}
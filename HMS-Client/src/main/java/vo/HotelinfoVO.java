package vo;

import enumData.Address;
import enumData.TradeArea;

public class HotelinfoVO {
    private String hotelID;
    private String hotelname;
    private TradeArea tradeArea;
    private Address address;
    private String detailAddress;
    private String contactNumber;
    private String introduction;
    private String service;
    private int star;
    private double grade;

    public HotelinfoVO(String hotelID, String hotelname, TradeArea tradeArea,
                       Address address, String detailAddress, String contactNumber,
                       String introduction, String service, int star, double grade) {
        super();
        this.hotelID = hotelID;
        this.hotelname = hotelname;
        this.tradeArea = tradeArea;
        this.address = address;
        this.detailAddress = detailAddress;
        this.contactNumber = contactNumber;
        this.introduction = introduction;
        this.service = service;
        this.star = star;
        this.grade = grade;
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

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
}
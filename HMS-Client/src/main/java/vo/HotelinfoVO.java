package vo;

import java.util.ArrayList;

import enumData.Address;
import enumData.RoomType;
import enumData.TradeArea;

public class HotelinfoVO {
    String hotelID;
    String hotelname;
    TradeArea tradeArea;
    Address address;
    String detailAddress;
    String contactNumber;
    ArrayList<RoomType> roomTypes;
    ArrayList<Integer> prices;
    String introduction;
    String service;
    int star;
    int grade;
    ArrayList<String> userIDs;
    ArrayList<String> comments;

    public HotelinfoVO(String hotelID, String hotelname, TradeArea tradeArea,
                       Address address, String detailAddress, String contactNumber,
                       ArrayList<RoomType> roomTypes, ArrayList<Integer> prices,
                       String introduction, String service, int star, int grade,
                       ArrayList<String> userIDs, ArrayList<String> comments) {
        super();
        this.hotelID = hotelID;
        this.hotelname = hotelname;
        this.tradeArea = tradeArea;
        this.address = address;
        this.detailAddress = detailAddress;
        this.contactNumber = contactNumber;
        this.roomTypes = roomTypes;
        this.prices = prices;
        this.introduction = introduction;
        this.service = service;
        this.star = star;
        this.grade = grade;
        this.userIDs = userIDs;
        this.comments = comments;
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

    public ArrayList<RoomType> getRoomTypes() {
        return roomTypes;
    }

    public void setRoomTypes(ArrayList<RoomType> roomTypes) {
        this.roomTypes = roomTypes;
    }

    public ArrayList<Integer> getPrices() {
        return prices;
    }

    public void setPrices(ArrayList<Integer> prices) {
        this.prices = prices;
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

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public ArrayList<String> getUserIDs() {
        return userIDs;
    }

    public void setUserIDs(ArrayList<String> userIDs) {
        this.userIDs = userIDs;
    }

    public ArrayList<String> getComments() {
        return comments;
    }

    public void setComments(ArrayList<String> comments) {
        this.comments = comments;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
}
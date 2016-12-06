package vo;

import java.util.Date;

import businesslogic.promotionbl.Promotion;
import enumData.Address;
import enumData.OrderState;
import enumData.RoomType;
import enumData.TradeArea;

/**
 * 预定时的信息
 * 与PO相比多了酒店名称、酒店地址
 * @author qzh
 */
public class OrderVO {
    String hotelID;
    String hotelname;
    TradeArea tradeArea;
    Address address;
    String detailAddress;
    int roomNumber;
    int peopleNumber;
    Date checkInDate;
    Date checkOutDate;
    RoomType roomType;
    boolean haveChild;

    //通过时间在逻辑层生成
    String orderID;
    //获取当前登录用户
    String userID;
    //TODO 逻辑层生成
    OrderState orderState;
    //TODO 逻辑层
    Date ddl;
    //TODO 逻辑层计算
    double price;
    //逻辑层获得
    PromotionVO Promotion;

    //生成时为null
    String roomID;

    //预定时
    public OrderVO(String hotelID, String hotelname, TradeArea tradeArea,Address address,String detailAddress, int roomNumber, int peopleNumber, Date checkInDate, Date checkOutDate, RoomType roomType, boolean haveChild) {
        this.hotelID = hotelID;
        this.hotelname = hotelname;
        this.tradeArea = tradeArea;
        this.address = address;
        this.detailAddress = detailAddress;
        this.roomNumber = roomNumber;
        this.peopleNumber = peopleNumber;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.roomType = roomType;
        this.haveChild = haveChild;
    }

    //查看时
    public OrderVO(String hotelID, String hotelname, TradeArea tradeArea, Address address, String detailAddress, int roomNumber, int peopleNumber, Date checkInDate, Date checkOutDate, RoomType roomType, boolean haveChild, String orderID, String userID, OrderState orderState, Date ddl, double price, PromotionVO promotion, String roomID) {
        this.hotelID = hotelID;
        this.hotelname = hotelname;
        this.tradeArea = tradeArea;
        this.address = address;
        this.detailAddress = detailAddress;
        this.roomNumber = roomNumber;
        this.peopleNumber = peopleNumber;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.roomType = roomType;
        this.haveChild = haveChild;
        this.orderID = orderID;
        this.userID = userID;
        this.orderState = orderState;
        this.ddl = ddl;
        this.price = price;
        Promotion = promotion;
        this.roomID = roomID;
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

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getPeopleNumber() {
        return peopleNumber;
    }

    public void setPeopleNumber(int peopleNumber) {
        this.peopleNumber = peopleNumber;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public boolean isHaveChild() {
        return haveChild;
    }

    public void setHaveChild(boolean haveChild) {
        this.haveChild = haveChild;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public OrderState getOrderState() {
        return orderState;
    }

    public void setOrderState(OrderState orderState) {
        this.orderState = orderState;
    }

    public Date getDdl() {
        return ddl;
    }

    public void setDdl(Date ddl) {
        this.ddl = ddl;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public PromotionVO getPromotion() {
        return Promotion;
    }

    public void setPromotion(PromotionVO promotion) {
        Promotion = promotion;
    }

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }
}

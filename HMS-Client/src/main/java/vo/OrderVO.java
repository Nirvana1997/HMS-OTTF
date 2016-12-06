package vo;

import java.util.Date;

import businesslogic.promotionbl.Promotion;
import enumData.OrderState;
import enumData.RoomType;

/**
 * 预定时的信息
 */
public class OrderVO {
    String hotelID;
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
    public OrderVO(String hotelID, int roomNumber, int peopleNumber, Date checkInDate, Date checkOutDate, RoomType roomType, boolean haveChild) {
        this.hotelID = hotelID;
        this.roomNumber = roomNumber;
        this.peopleNumber = peopleNumber;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.roomType = roomType;
        this.haveChild = haveChild;
    }

    //查看时
    public OrderVO(String orderID, String hotelID, String userID, String roomID, int roomNumber, int peopleNumber, OrderState orderState, Date checkInDate, Date checkOutDate, Date ddl, RoomType roomType, double price, boolean haveChild, PromotionVO Promotion) {
        this.orderID = orderID;
        this.hotelID = hotelID;
        this.userID = userID;
        this.roomID = roomID;
        this.roomNumber = roomNumber;
        this.peopleNumber = peopleNumber;
        this.orderState = orderState;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.ddl = ddl;
        this.roomType = roomType;
        this.price = price;
        this.haveChild = haveChild;
        this.Promotion = Promotion;
    }

    public String getHotelID() {
        return hotelID;
    }

    public void setHotelID(String hotelID) {
        this.hotelID = hotelID;
    }

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
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

    public OrderState getOrderState() {
        return orderState;
    }

    public void setOrderState(OrderState orderState) {
        this.orderState = orderState;
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

    public Date getDdl() {
        return ddl;
    }

    public void setDdl(Date ddl) {
        this.ddl = ddl;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public PromotionVO getPromotion() {
        return Promotion;
    }

    public void setPromotion(PromotionVO Promotion) {
        this.Promotion = Promotion;
    }
}

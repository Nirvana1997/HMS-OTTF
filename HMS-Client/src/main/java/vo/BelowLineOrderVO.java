package vo;

import enumData.RoomType;

import java.util.Date;

/**
 * 线下订单信息VO
 * @author qzh
 * Created by user on 2016/12/9.
 */
public class BelowLineOrderVO {
    String hotelID;
    Date checkInDate;
    Date checkOutDate;
    RoomType roomType;
    int roomNumber;

    public BelowLineOrderVO(String hotelID, Date checkInDate, Date checkOutDate, RoomType roomType, int roomNumber) {
        this.hotelID = hotelID;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.roomType = roomType;
        this.roomNumber = roomNumber;
    }

    public String getHotelID() {
        return hotelID;
    }

    public void setHotelID(String hotelID) {
        this.hotelID = hotelID;
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

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }
}

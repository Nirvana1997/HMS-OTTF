package vo;

import enumData.RoomType;

import java.util.Date;

/**
 * 用于记录每一次订单导致的房间数量变化
 * @author qzh
 * Created by personalUser on 2016/11/22.
 */
public class RoomOrderVO {
    String hotelID;
    Date startDate;
    Date endDate;
    RoomType roomType;

    public RoomOrderVO(String hotelID, Date startDate, Date endDate, RoomType roomType) {
        this.hotelID = hotelID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.roomType = roomType;
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

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }
}

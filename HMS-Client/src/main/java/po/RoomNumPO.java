package po;

import enumData.RoomType;

/**
 * Created by mac on 2016/11/30.
 */
public class RoomNumPO {
    String hotelID;
    String date;
    int emptyNum;
    RoomType roomType;

    public RoomNumPO(String hotelID, String date, int emptyNum, RoomType roomType) {
        this.hotelID = hotelID;
        this.date = date;
        this.emptyNum = emptyNum;
        this.roomType = roomType;
    }

    public String getHotelID() {
        return hotelID;
    }

    public void setHotelID(String hotelID) {
        this.hotelID = hotelID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getEmptyNum() {
        return emptyNum;
    }

    public void setEmptyNum(int emptyNum) {
        this.emptyNum = emptyNum;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }
}

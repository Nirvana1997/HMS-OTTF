package po;

import enumData.RoomType;

import java.io.Serializable;

public class HotelroomPO implements Serializable{
	String hotelID;
	RoomType roomType;
	double price;

	public HotelroomPO(String hotelID, RoomType roomType, double price) {
		this.hotelID = hotelID;
		this.roomType = roomType;
		this.price = price;
	}

	public String getHotelID() {
		return hotelID;
	}

	public void setHotelID(String hotelID) {
		this.hotelID = hotelID;
	}

	public RoomType getRoomType() {
		return roomType;
	}

	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}


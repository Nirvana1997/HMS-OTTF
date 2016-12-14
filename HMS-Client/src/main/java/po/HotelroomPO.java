package po;

import enumData.RoomType;

public class HotelroomPO {
	String hotelID;
	RoomType roomType;
	double price;
	int roomNumber;

	public HotelroomPO(String hotelID, RoomType roomType, double price,int roomNumber) {
		this.hotelID = hotelID;
		this.roomType = roomType;
		this.price = price;
		this.roomNumber = roomNumber;
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

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
}


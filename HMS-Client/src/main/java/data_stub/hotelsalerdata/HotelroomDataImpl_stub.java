package data_stub.hotelsalerdata;

import dataservice.hotelsalerdataservice.HotelroomDataService;
import enumData.ResultMessage;
import enumData.RoomType;
import po.HotelroomPO;
import po.OrderPO;
import po.RoomNumPO;

import java.util.ArrayList;

public class HotelroomDataImpl_stub implements HotelroomDataService {
	ArrayList<HotelroomPO> hotelroomPOs = new ArrayList<HotelroomPO>();
	ArrayList<RoomNumPO> roomNumPOs = new ArrayList<RoomNumPO>();
	HotelroomPO hotelroomPO1 = new HotelroomPO("01", RoomType.StandardRoom,200);
	HotelroomPO hotelroomPO2 = new HotelroomPO("01", RoomType.DoubleRoom,300);
	HotelroomPO hotelroomPO3 = new HotelroomPO("01", RoomType.SingleRoom,100);
	RoomNumPO roomNumPO1 = new RoomNumPO("01","2016_11_12",20,19,RoomType.SingleRoom);
	RoomNumPO roomNumPO2 = new RoomNumPO("01","2016_11_12",10,9,RoomType.StandardRoom);
	RoomNumPO roomNumPO3 = new RoomNumPO("01","2016_11_12",5,2,RoomType.SingleRoom);

	public HotelroomDataImpl_stub() {
		hotelroomPOs.add(hotelroomPO1);
		hotelroomPOs.add(hotelroomPO2);
		hotelroomPOs.add(hotelroomPO3);
		roomNumPOs.add(roomNumPO1);
		roomNumPOs.add(roomNumPO2);
		roomNumPOs.add(roomNumPO3);
	}

	@Override
	public ResultMessage setOccupied(OrderPO po) {
		for(int i=0;i<roomNumPOs.size();i++){
			if(roomNumPOs.get(i).getHotelID().equals(po.getHotelID())&&
					roomNumPOs.get(i).getDate().equals(po.getCheckInDate())){
				roomNumPOs.get(i).setEmptyNum(roomNumPOs.get(i).getEmptyNum()-1);
			}
		}
		return ResultMessage.Correct;
	}

	@Override
	public ResultMessage setEmpty(OrderPO po) {
		for(int i=0;i<roomNumPOs.size();i++){
			if(roomNumPOs.get(i).getHotelID().equals(po.getHotelID())&&
					roomNumPOs.get(i).getDate().equals(po.getCheckInDate())){
				roomNumPOs.get(i).setEmptyNum(roomNumPOs.get(i).getEmptyNum()+1);
			}
		}
		return ResultMessage.Correct;
	}

	@Override
	public ArrayList<RoomNumPO> getEmptyrooms(String hotelID, String date) {
		ArrayList<RoomNumPO> list = new ArrayList<RoomNumPO>();
		for(int i=0;i<roomNumPOs.size();i++){
			if(roomNumPOs.get(i).getHotelID().equals(hotelID)&&roomNumPOs.get(i).getDate().equals(date)){
				list.add(roomNumPOs.get(i));
			}
		}
		return list;
	}

	@Override
	public ResultMessage addHotelroom(HotelroomPO po) {
		hotelroomPOs.add(po);
		return ResultMessage.Correct;
	}

	@Override
	public ArrayList<HotelroomPO> getRoomList(String hotelID) {
		ArrayList<HotelroomPO> list = new ArrayList<HotelroomPO>();
		for(int i=0;i<hotelroomPOs.size();i++){
			if(hotelroomPOs.get(i).getHotelID().equals(hotelID))
				list.add(hotelroomPOs.get(i));
		}
		return list;
	}

	@Override
	public ResultMessage initializeRoomInfo(RoomNumPO po) {
		roomNumPOs.add(po);
		return ResultMessage.Correct;
	}

}

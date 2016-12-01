package data_stub.hotelsalerdata;

import dataservice.hotelsalerdataservice.HotelroomDataService;
import enumData.ResultMessage;
import po.HotelroomPO;
import po.OrderPO;
import po.RoomNumPO;

import java.util.ArrayList;

public class HotelroomDataImpl_stub implements HotelroomDataService {

	@Override
	public ResultMessage setOccupied(OrderPO po) {
		if(po.getHotelID().equals("0001")){
			return ResultMessage.Correct;
		}else
		return ResultMessage.NotExist;
	}

	@Override
	public ResultMessage setEmpty(OrderPO po) {
		if(po.getHotelID().equals("0001")){
			return ResultMessage.Correct;
		}else
		return ResultMessage.NotExist;
	}

	@Override
	public ArrayList<RoomNumPO> getEmptyrooms(String hotelID, String date) {
		return null;
	}

	@Override
	public ResultMessage addHotelroom(HotelroomPO po) {
		if(po.getHotelID().equals("0001")){
			return ResultMessage.Correct;
		}else
		return ResultMessage.NotExist;
	}

	@Override
	public ArrayList<HotelroomPO> getRoomList(String hotelID) {
		return null;
	}

	@Override
	public ResultMessage initializeRoomInfo(RoomNumPO po) {
		return null;
	}

}

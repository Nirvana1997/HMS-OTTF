package data_stub.hotelsalerdata;

import dataservice.hotelsalerdataservice.HotelroomDataService;
import enumData.ResultMessage;
import po.HotelroomPO;
import po.OrderPO;

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
	public HotelroomPO getEmptyrooms(String hotelID) {
		HotelroomPO hotelroom = new HotelroomPO(hotelID,null,0);
		return hotelroom;
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

}

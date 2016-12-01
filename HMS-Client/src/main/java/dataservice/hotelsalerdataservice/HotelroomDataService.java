package dataservice.hotelsalerdataservice;

import enumData.ResultMessage;
import po.HotelroomPO;
import po.OrderPO;

import java.util.ArrayList;

public interface HotelroomDataService {
	public ResultMessage setOccupied(OrderPO po);
	
	public ResultMessage setEmpty(OrderPO po);
	
	public HotelroomPO getEmptyrooms(String hotelID);
	
	public ResultMessage addHotelroom(HotelroomPO po);

	public ArrayList<HotelroomPO> getRoomList(String hotelID);
}

package dataservice.hotelroomdataservice;

import enumData.ResultMessage;
import po.HotelroomPO;
import po.OrderPO;

public interface HotelroomDataService {
	public ResultMessage setOccupied(OrderPO po);
	
	public ResultMessage setEmpty(OrderPO po);
	
	public HotelroomPO getEmptyrooms(String hotelID);
	
	public ResultMessage addHotelroom(HotelroomPO po);
}

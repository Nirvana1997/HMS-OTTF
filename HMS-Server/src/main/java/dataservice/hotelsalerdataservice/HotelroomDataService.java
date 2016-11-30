package dataservice.hotelsalerdataservice;

import enumData.ResultMessage;
import po.HotelroomPO;
import po.OrderPO;

import java.util.ArrayList;

public interface HotelroomDataService {
	/**
	 *
	 * @param po
	 * @return
     */
	public ResultMessage setOccupied(OrderPO po);

	/**
	 *
	 * @param po
	 * @return
     */
	public ResultMessage setEmpty(OrderPO po);

	/**
	 *
	 * @param hotelID
	 * @return
     */
	public HotelroomPO getEmptyrooms(String hotelID);

	/**
	 *
	 * @param po
	 * @return
     */
	public ResultMessage addHotelroom(HotelroomPO po);

	/**
	 *
	 * @param hotelID
	 * @return
     */
	public ArrayList<HotelroomPO> getRoomList(String hotelID);
}

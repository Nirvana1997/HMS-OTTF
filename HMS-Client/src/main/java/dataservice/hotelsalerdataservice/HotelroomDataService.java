package dataservice.hotelsalerdataservice;

import enumData.ResultMessage;
import po.HotelroomPO;
import po.OrderPO;
import po.RoomNumPO;

import java.util.ArrayList;

public interface HotelroomDataService {
	/**
	 *根据订单信息将相应空房间数-1
	 * @param po
	 * @return
     */
	public ResultMessage setOccupied(OrderPO po);

	/**
	 *根据订单信息将相应空房间数+1
	 * @param po
	 * @return
     */
	public ResultMessage setEmpty(OrderPO po);

	/**
	 *根据酒店ID和日期，查询对应日期空房间状况
	 * @param hotelID
	 * @param date
     * @return
     */
	public ArrayList<RoomNumPO> getEmptyrooms(String hotelID, String date);

	/**
	 *添加酒店信息
	 * @param po
	 * @return
     */
	public ResultMessage addHotelroom(HotelroomPO po);

	/**
	 *得到房间列表（类型，价格）
	 * @param hotelID
	 * @return
     */
	public ArrayList<HotelroomPO> getRoomList(String hotelID);

	/**
	 * 酒店工作人员初始化房间信息（房间类型，对应的总房间数，空房间数）
	 * @param po
	 * @return
     */
	public ResultMessage initializeRoomInfo(RoomNumPO po);

}

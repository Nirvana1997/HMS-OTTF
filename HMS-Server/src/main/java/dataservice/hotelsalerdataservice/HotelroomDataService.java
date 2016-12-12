package dataservice.hotelsalerdataservice;

import enumData.ResultMessage;
import po.HotelroomPO;
import po.OrderPO;
import po.RoomNumPO;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface HotelroomDataService extends Remote{
	/**
	 *根据订单信息将相应空房间数-1
	 * @param po 订单PO
	 * @return 结果信息
     */
	public ResultMessage setOccupied(OrderPO po)throws RemoteException;

	/**
	 *根据订单信息将相应空房间数+1
	 * @param po 订单PO
	 * @return 结果信息
     */
	public ResultMessage setEmpty(OrderPO po)throws RemoteException;

	/**
	 *根据酒店ID和日期，查询对应日期空房间状况
	 * @param hotelID 酒店ID
	 * @param date 日期
     * @return 空房间数量PO的列表
     */
	public ArrayList<RoomNumPO> getEmptyrooms(String hotelID,String date)throws RemoteException;

	/**
	 *添加酒店信息
	 * @param po 酒店房间信息PO
	 * @return 结果信息
     */
	public ResultMessage addHotelroom(HotelroomPO po)throws RemoteException;

	/**
	 *得到房间列表（类型，价格）
	 * @param hotelID 酒店ID
	 * @return 酒店房间PO的列表
     */
	public ArrayList<HotelroomPO> getRoomList(String hotelID)throws RemoteException;

	/**
	 * 酒店工作人员初始化房间信息（房间类型，对应的总房间数，空房间数）
	 * @param list 空房间数量POlist
	 * @return 结果信息
     */
	public ResultMessage initializeRoomInfo(ArrayList<RoomNumPO> list)throws RemoteException;

}

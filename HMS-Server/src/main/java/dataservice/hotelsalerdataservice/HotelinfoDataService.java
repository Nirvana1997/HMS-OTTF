package dataservice.hotelsalerdataservice;


import enumData.Address;
import enumData.ResultMessage;
import enumData.SortWay;
import enumData.TradeArea;
import po.CommentPO;
import po.HotelinfoPO;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface HotelinfoDataService extends Remote{
	/**
	 * 根据酒店ID获取酒店信息
	 * @param hotelID 酒店ID
	 * @return 酒店信息PO
	 * @throws RemoteException
     */
	public HotelinfoPO getHotelinfo(String hotelID) throws RemoteException;

	/**
	 * 修改酒店信息
	 * @param po 酒店信息PO
	 * @return 结果信息
	 * @throws RemoteException
     */
	public ResultMessage setHotelinfo(HotelinfoPO po) throws RemoteException;

	/**
	 * 根据搜索条件，返回酒店列表
	 * @param tradeArea 商圈（枚举类型）
	 * @param address 地址（枚举类型）
	 * @param sortWay 排序方式（枚举类型）
	 * @return 酒店信息PO的列表
	 * @throws RemoteException
     */
	public ArrayList<HotelinfoPO> getHotelList(TradeArea tradeArea, Address address , SortWay sortWay) throws RemoteException;

	/**
	 * 直接返回所有酒店信息
	 * @return 所有酒店信息PO的列表
	 * @throws RemoteException
     */
	public ArrayList<HotelinfoPO> getHotelList() throws RemoteException;

	/**
	 * 评价
	 * @param po 评价信息PO
	 * @return 结果信息
	 * @throws RemoteException
     */
	public ResultMessage addComments(CommentPO po) throws RemoteException;

	/**
	 * 根据酒店ID获取相应的评价信息
	 * @param hotelID 酒店ID
	 * @return 评价PO列表
	 * @throws RemoteException
     */
	public ArrayList<CommentPO> getComments(String hotelID) throws RemoteException;

	/**
	 * 增加酒店信息
	 * @param po 酒店信息PO
	 * @return 结果信息
	 * @throws RemoteException
     */
	public ResultMessage addHotelinfo(HotelinfoPO po) throws RemoteException;

	/**
	 * 删除酒店信息
	 * @param hotelID 酒店ID
	 * @return 结果信息
	 * @throws RemoteException
     */
	public ResultMessage deleteHotelinfo(String hotelID) throws RemoteException;
}

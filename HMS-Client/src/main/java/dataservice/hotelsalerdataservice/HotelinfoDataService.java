package dataservice.hotelsalerdataservice;


import enumData.Address;
import enumData.ResultMessage;
import enumData.SortWay;
import enumData.TradeArea;
import po.CommentPO;
import po.ConditionPO;
import po.HotelinfoPO;

import java.rmi.RemoteException;
import java.util.ArrayList;

public interface HotelinfoDataService{
	/**
	 * 根据酒店ID获取酒店信息
	 * @param hotelID
	 * @return
	 * @throws RemoteException
     */
	public HotelinfoPO getHotelinfo(String hotelID) throws RemoteException;

	/**
	 * 修改酒店信息
	 * @param po
	 * @return
	 * @throws RemoteException
     */
	public ResultMessage setHotelinfo(HotelinfoPO po) throws RemoteException;

	/**
	 * 根据搜索条件，返回酒店列表
	 * @param tradeArea
	 * @param address
	 * @param sortWay
	 * @return
	 * @throws RemoteException
     */
	public ArrayList<HotelinfoPO> getHotelList(TradeArea tradeArea, Address address, SortWay sortWay) throws RemoteException;

	/**
	 * 评价
	 * @param po
	 * @return
	 * @throws RemoteException
     */
	public ResultMessage addComments(CommentPO po) throws RemoteException;

	/**
	 * 增加酒店信息
	 * @param po
	 * @return
	 * @throws RemoteException
     */
	public ResultMessage addHotelinfo(HotelinfoPO po) throws RemoteException;
}

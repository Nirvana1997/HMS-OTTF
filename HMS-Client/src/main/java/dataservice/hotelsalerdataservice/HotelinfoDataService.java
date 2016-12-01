package dataservice.hotelsalerdataservice;


import enumData.Address;
import enumData.ResultMessage;
import enumData.SortWay;
import enumData.TradeArea;
import po.CommentPO;
import po.ConditionPO;
import po.HotelinfoPO;
import vo.HotelinfoVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

public interface HotelinfoDataService {
	public ResultMessage addHotelInfo(HotelinfoPO po)throws RemoteException;

	public HotelinfoPO getHotelinfo(String hotelID)throws RemoteException;
	
	public ResultMessage setHotelinfo(HotelinfoPO po)throws RemoteException;

	/**
	 * 根据条件按顺序返回酒店列表
	 * @param tradeArea 商圈
	 * @param address 地址
	 * @param sortWay 排序方式
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<HotelinfoPO> getHotelList(TradeArea tradeArea, Address address, SortWay sortWay)throws RemoteException;
	
	public ResultMessage addComments(CommentPO po)throws RemoteException;
}

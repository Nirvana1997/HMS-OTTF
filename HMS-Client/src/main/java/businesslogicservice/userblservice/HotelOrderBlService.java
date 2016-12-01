package businesslogicservice.userblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.userbl.HotelList;
import enumData.Address;
import enumData.ResultMessage;
import enumData.SortWay;
import enumData.TradeArea;
import vo.*;

/**
 * 酒店预定模块接口
 * @author qzh
 */
public interface HotelOrderBlService {
    /**
     * 返回固定商圈、地址中的所有酒店并生成列表项
     * @param tradeArea 商圈
     * @param address 地址
     * @param sortWay 排序方式
     * @return
     * @throws RemoteException
     */
	public ArrayList<HotelListItemVO> searchHotel(TradeArea tradeArea, Address address, SortWay sortWay)throws RemoteException;

	/**
	 * 返回固定商圈、地址中符合限制条件的酒店并生成列表项
	 * @param tradeArea 商圈
	 * @param address 地址
	 * @param sortWay 排序方式
	 * @param limits 限制条件数组
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<HotelListItemVO> searchHotel(TradeArea tradeArea, Address address, SortWay sortWay,ArrayList<LimitVO> limits)throws RemoteException;

	public ArrayList<HotelinfoVO> readHotel(String hotelID)throws RemoteException;

	public boolean orderHotel(OrderVO vo, String userID)throws RemoteException;
	
	public ArrayList<OrderVO> readOrder(String userID)throws RemoteException;
	
	public ResultMessage cancelOrder(String OrderID)throws RemoteException;
	
	public void comment(CommentVO vo)throws RemoteException;
}

package businesslogicservice.userblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import businesslogic.userbl.HotelList;
import enumData.*;
import vo.*;

/**
 * 酒店预定模块接口
 * 负责搜索酒店和预定酒店
 * @author qzh
 */
public interface HotelOrderBlService {
    /**
     * 返回固定商圈、地址中的所有酒店并生成列表项
     * @param tradeArea 商圈
     * @param address 地址
     * @param sortWay 排序方式
     * @return 该地址内所有酒店列表项
     * @throws RemoteException
     */
	public ArrayList<HotelListItemVO> searchHotel(TradeArea tradeArea, Address address, SortWay sortWay)throws RemoteException;

	/**
	 * 返回固定商圈、地址中符合限制条件的酒店并生成列表项
	 * @param tradeArea 商圈
	 * @param address 地址
	 * @param sortWay 排序方式
	 * @param limits 限制条件数组
	 * @return 符合条件的酒店列表项
	 * @throws RemoteException
	 */
	public ArrayList<HotelListItemVO> searchHotel(TradeArea tradeArea, Address address, SortWay sortWay,ArrayList<LimitVO> limits)throws RemoteException;

	/**
	 * 查看酒店详细信息
	 * @param hotelID
	 * @return 酒店详细信息
	 * @throws RemoteException
	 */
	public HotelinfoVO readHotel(String hotelID)throws RemoteException;

    /**
     * 返回是否房间数目是否足够
     * @param hotelID 酒店编号
     * @param startDate 入住时间
     * @param endDate 退房时间
     * @param roomType 房间类型
     * @param num 房间数目
     * @return
     */
	public boolean haveEnoughRoom(String hotelID, Date startDate, Date endDate, RoomType roomType,int num) throws RemoteException;

    /**
     * 计算订单价格并生成订单信息
     * @param roomType 房间类型
     * @param hotelID 酒店编号
     * @param startDate 入住时间
     * @param endDate 退房时间
     * @param num 房间数目
     * @return 订单信息
     * @throws RemoteException
     */
	public OrderVO makeOrder(RoomType roomType, String hotelID, Date startDate, Date endDate, int num)throws RemoteException;

    /**
     * 预定酒店，生成订单
     * TODO 在界面层限制输入，使房间数目小于剩余数目
     * @param vo 订单信息
     * @return 是否成功
     * @throws RemoteException
     */
	public boolean orderHotel(OrderVO vo)throws RemoteException;
	
	public ArrayList<OrderVO> readOrder(String userID)throws RemoteException;
	
	public ResultMessage cancelOrder(String OrderID)throws RemoteException;
	
	public void comment(CommentVO vo)throws RemoteException;
}

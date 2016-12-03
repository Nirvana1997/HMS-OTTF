package businesslogic.userbl;

import businesslogic.hotelsalerbl.HotelDataImpl;
import enumData.*;
import vo.*;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

/**
 * 酒店预定模块
 * 负责预定酒店、浏览订单和评价
 * @author qzh
 */
public class HotelOrder{
	/**
	 * 酒店列表
	 */
	HotelInfo hotelInfo;

	/**
	 * 判断房间数目
	 */
	RoomNumJudger roomNumJudger;

    public HotelOrder() throws RemoteException{
        hotelInfo = new HotelDataImpl();
        roomNumJudger = new RoomNumJudger();
    }

	/**
	 * 返回是否房间数目是否足够
	 * @param hotelID 酒店编号
	 * @param startDate 入住时间
	 * @param endDate 退房时间
	 * @param roomType 房间类型
	 * @param num 房间数目
	 * @return
	 */
	public boolean haveEnoughRoom(String hotelID, Date startDate, Date endDate, RoomType roomType, int num) {
		return roomNumJudger.haveEnoughRoom(hotelID,startDate,endDate,roomType,num);
	}

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
    public OrderVO makeOrder(RoomType roomType, String hotelID, Date startDate, Date endDate, int num) throws RemoteException {
        return null;
    }

	/**
	 * 预订酒店
	 * @param vo
     * @return
     */
	public boolean orderHotel(OrderVO vo){
		return true;
	}

	/**
	 * 根据用户id得到该用户的订单列表
	 * @param userID
	 * @return
     */
	public ArrayList<OrderVO> readOrder(String userID){
		return null;
	}

	/**
	 * 根据订单ID删除该订单
	 * @param OrderID
	 * @return
     */
	public ResultMessage cancelOrder(String OrderID){
		return ResultMessage.Correct;
	}

	/**
	 * 评价订单
	 * @param vo
     */
	public void comment(CommentVO vo){
		System.out.println("评价成功！");
	}
		
}

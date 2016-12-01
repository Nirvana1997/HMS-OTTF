package businesslogic.userbl;

import businesslogic.hotelsalerbl.HotelInfoImpl;
import businesslogicservice.userblservice.HotelOrderBlService;
import enumData.*;
import vo.*;

import java.rmi.Remote;
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

    public HotelOrder() throws RemoteException{
        hotelInfo = new HotelInfoImpl();
    }

	/**
	 * 预订酒店
	 * @param vo
	 * @param userID
     * @return
     */
	public boolean orderHotel(OrderVO vo, String userID){
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

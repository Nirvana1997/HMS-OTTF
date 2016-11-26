package businesslogic.userbl;

import businesslogicservice.userblservice.HotelOrderBlService;
import enumData.*;
import vo.CommentVO;
import vo.ConditionVO;
import vo.HotelinfoVO;
import vo.OrderVO;

import java.util.ArrayList;
import java.util.Date;

/**
 * 用户:预订酒店类
 * @author xzh
 */
public class HotelOrderBlImpl implements HotelOrderBlService{
	
	String orderID;
	OrderState orderState;
	String hotelID;
	String user;
	//TODO 时间
	String roomID;
	ArrayList<HotelinfoVO> hotelInfoList = new ArrayList<HotelinfoVO>();
	ArrayList<OrderVO> orderList = new ArrayList<OrderVO>();

	/**
	 * 根据限制条件搜索酒店
	 * @param address
	 * @param vo
     * @return
     */
	public ArrayList<HotelinfoVO> searchHotel(Address address,ConditionVO vo){
		hotelInfoList.add(new HotelinfoVO("0001", "仙林大酒店", null, null, null,null, null, null, null, null, 0, 0, null, null));
		return hotelInfoList;
	}

	/**
	 * 根据限制条件浏览酒店
	 * @param address
	 * @param vo
     * @return
     */
	public ArrayList<HotelinfoVO> readHotel(Address address,ConditionVO vo){
		hotelInfoList.add(new HotelinfoVO("001","喋喋大酒店", TradeArea.Xianlin,Address.DieDie, "仙林大道",null,new ArrayList<RoomType>(),
				new ArrayList<Integer>(),"贼好","贼棒",3,3,new ArrayList<String>(),new ArrayList<String>()));
		return hotelInfoList;

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
		if(userID=="01") {
			orderList.add(new OrderVO("11",OrderState.executing,"123","1",new Date(2016,11,11),"1"));
			return orderList;
		}
		return null;
	}

	/**
	 * 根据订单ID删除该订单
	 * @param OrderID
	 * @return
     */
	public ResultMessage cancelOrder(String OrderID){
		if(OrderID == orderID){
			return ResultMessage.Correct;
		}
		else{
			return ResultMessage.NotExist;
		}
	}

	/**
	 * 评价订单
	 * @param vo
     */
	public void comment(CommentVO vo){
		System.out.println("评价成功！");
		
	}
		
}

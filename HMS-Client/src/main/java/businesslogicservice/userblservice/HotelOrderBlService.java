package businesslogicservice.userblservice;

import java.util.ArrayList;

import enumData.Address;
import enumData.ResultMessage;
import vo.CommentVO;
import vo.ConditionVO;
import vo.HotelinfoVO;
import vo.OrderVO;

public interface HotelOrderBlService {

	public ArrayList<HotelinfoVO> searchHotel(Address address,ConditionVO vo);
	
	public ArrayList<HotelinfoVO> readHotel(Address address,ConditionVO vo);
	
	public boolean orderHotel(OrderVO vo, String userID);
	
	public ArrayList<OrderVO> readOrder(String userID);
	
	public ResultMessage cancelOrder(String OrderID);
	
	public void comment(CommentVO vo);
}

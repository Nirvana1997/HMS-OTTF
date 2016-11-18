package businesslogicservice.orderblservice;

import java.util.ArrayList;

import vo.OrderVO;

public interface OrderBlService {
	
	public OrderVO getOrderInfo(String orderID);
	
	public ArrayList<OrderVO> getOrderList(String account);
	
}

package businesslogicservice.orderblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import vo.OrderVO;

public interface OrderBlService {
	
	public OrderVO getOrderInfo(String orderID) throws RemoteException;
	
	public ArrayList<OrderVO> getOrderList(String account) throws RemoteException;
	
}

package dataservice.orderdataservice;

import enumData.ResultMessage;
import po.OrderPO;

import java.util.ArrayList;

public interface OrderDataService {
	public OrderPO getOrderInfo(String orderID);
	public ResultMessage setOrderInfo(OrderPO po);
	public ArrayList<OrderPO> getOrderList(String account);
	public ResultMessage addOrder(OrderPO po);
	public ResultMessage deleteOrder(String orderID);
}

package dataservice.orderdataservice;

import enumData.ResultMessage;
import po.*;

import java.util.ArrayList;

public interface OrderDataService {
	/**
	 * 根据订单ID获取订单信息
	 * @param orderID
	 * @return
     */
	public OrderPO getOrderInfo(String orderID);

	/**
	 * 修改订单信息
	 * @param po
	 * @return
     */
	public ResultMessage setOrderInfo(OrderPO po);

	/**
	 * 根据账户，返回相应订单列表
	 * @param account
	 * @return
     */
	public ArrayList<OrderPO> getOrderList(String account);

	/**
	 * 向数据库添加订单信息
	 * @param po
	 * @return
     */
	public ResultMessage addOrder(OrderPO po);

	/**
	 * 删除订单
	 * @param orderID
	 * @return
     */
	public ResultMessage deleteOrder(String orderID);
}

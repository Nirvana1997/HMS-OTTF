package dataservice.orderdataservice;

import enumData.ResultMessage;
import po.*;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface OrderDataService extends Remote{
	/**
	 * 根据订单ID获取订单信息
	 * @param orderID 订单ID
	 * @return 订单PO
     */
	public OrderPO getOrderInfo(String orderID) throws RemoteException;

	/**
	 * 修改订单信息
	 * @param po 订单PO
	 * @return 结果信息
     */
	public ResultMessage setOrderInfo(OrderPO po)throws RemoteException;

	/**
	 * 根据账户，返回相应订单列表
	 * @param account 用户ID
	 * @return 订单PO的列表
     */
	public ArrayList<OrderPO> getOrderList(String account)throws RemoteException;

	/**
	 * 向数据库添加订单信息
	 * @param po 订单PO
	 * @return 结果信息
     */
	public ResultMessage addOrder(OrderPO po)throws RemoteException;

	/**
	 * 删除订单
	 * @param orderID 订单ID
	 * @return 结果信息
     */
	public ResultMessage deleteOrder(String orderID)throws RemoteException;
}

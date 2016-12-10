package dataservice.orderdataservice;

import enumData.IDType;
import enumData.ResultMessage;
import po.OrderPO;

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
	 * 根据ID类型和ID，去搜索相应的订单
	 * @param ID 具体ID
	 * @param type ID类型
	 * @return 订单信息的列表
	 * @throws RemoteException
     */
	public ArrayList<OrderPO> getOrderList(String ID, IDType type)throws RemoteException;

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

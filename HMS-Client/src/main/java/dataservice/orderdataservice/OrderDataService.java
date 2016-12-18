package dataservice.orderdataservice;

import enumData.IDType;
import enumData.ResultMessage;
import po.CanceledExceptionOrderPO;
import po.OrderPO;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface OrderDataService extends Remote {
    /**
     * 根据订单ID获取订单信息
     *
     * @param orderID 订单ID
     * @return 订单PO
     */
    public OrderPO getOrderInfo(String orderID) throws RemoteException;

    /**
     * 修改订单信息
     *
     * @param po 订单PO
     * @return 结果信息
     */
    public ResultMessage setOrderInfo(OrderPO po) throws RemoteException;

    /**
     * 根据ID类型和ID，去搜索相应的订单
     *
     * @param ID   具体ID
     * @param type ID类型
     * @return 订单信息的列表
     * @throws RemoteException
     */
    public ArrayList<OrderPO> getOrderList(String ID, IDType type) throws RemoteException;

    /**
     * 向数据库添加订单信息
     *
     * @param po 订单PO
     * @return 结果信息
     */
    public ResultMessage addOrder(OrderPO po) throws RemoteException;

    /**
     * 删除订单
     *
     * @param orderID 订单ID
     * @return 结果信息
     */
    public ResultMessage deleteOrder(String orderID) throws RemoteException;

    /**
     * 添加订单异常信息
     *
     * @param po 订单异常PO
     * @return 结果信息
     * @throws RemoteException
     */
    public ResultMessage addOrderExceptionInfo(CanceledExceptionOrderPO po) throws RemoteException;

    /**
     * 获取订单异常信息（根据订单ID，获取单个）
     *
     * @param orderID 订单ID
     * @return 订单异常信息PO
     * @throws RemoteException
     */
    public CanceledExceptionOrderPO getOrderExceptionInfo(String orderID) throws RemoteException;

    /**
     * 获取订单异常信息（所有）
     *
     * @return 订单异常信息POList
     * @throws RemoteException
     */
    public ArrayList<CanceledExceptionOrderPO> getOrderExceptionInfo() throws RemoteException;
}

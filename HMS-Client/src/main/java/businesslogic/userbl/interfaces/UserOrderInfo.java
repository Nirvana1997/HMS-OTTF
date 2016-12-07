package businesslogic.userbl.interfaces;

import po.OrderPO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * 用户订单数据接口
 * Created by user on 2016/12/2.
 */
public interface UserOrderInfo {
    /**
     * 添加订单信息
     * @param po 订单信息
     * @throws RemoteException
     */
    public void addOrder(OrderPO po)throws RemoteException;

    /**
     * 根据账户，返回相应订单列表
     * @param account
     * @return 对应用户的订单列表
     */
    public ArrayList<OrderPO> getOrderList(String account)throws RemoteException;

    /**
     * 修改订单信息
     * @param po
     */
    public void setOrderInfo(OrderPO po)throws RemoteException;

    /**
     * 根据订单ID获取订单信息
     * @param orderID
     * @return
     */
    public OrderPO getOrderInfo(String orderID)throws RemoteException;
}

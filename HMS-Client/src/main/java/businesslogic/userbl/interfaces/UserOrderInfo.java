package businesslogic.userbl.interfaces;

import enumData.OrderState;
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
     *
     * @param po 订单信息
     * @throws RemoteException
     */
    void addOrder(OrderPO po) throws RemoteException;

    /**
     * 根据账户，返回相应订单列表
     *
     * @param orderState 订单状态
     * @return 对应用户的订单列表
     */
    ArrayList<OrderPO> getOrderList(OrderState orderState) throws RemoteException;

    /**
     * 修改订单信息
     *
     * @param po
     */
    void setOrderInfo(OrderPO po) throws RemoteException;

    /**
     * 根据订单ID获取订单信息
     *
     * @param orderID
     * @return
     */
    OrderPO getOrderInfo(String orderID) throws RemoteException;
}

package businesslogic.orderbl.impl;

import businesslogic.logbl.Login;
import businesslogic.userbl.interfaces.UserOrderInfo;
import data_stub.orderdata.OrderDataImpl_stub;
import dataservice.orderdataservice.OrderDataService;
import po.OrderPO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * 酒店订单数据接口实现
 * @author qzh
 * Created by user on 2016/12/2.
 */
public class OrderDataImpl implements UserOrderInfo{
    /**
     * 订单数据模块
     */
    OrderDataService orderDataService;

    public OrderDataImpl() {
        orderDataService = new OrderDataImpl_stub();
    }

    /**
     * 生成订单
     * @param po 订单信息
     */
    @Override
    public void addOrder(OrderPO po) throws RemoteException {
        orderDataService.addOrder(po);
    }

    /**
     * 获得用户订单列表
     * @return 登录用户订单列表
     */
    @Override
    public ArrayList<OrderPO> getOrderList() throws RemoteException {
        return orderDataService.getOrderList(Login.getNowUser());
    }

    /**
     * 修改订单信息
     * @param po
     */
    @Override
    public void setOrderInfo(OrderPO po) throws RemoteException {
        orderDataService.setOrderInfo(po);
    }

    /**
     * 根据订单ID获取订单信息
     * @param orderID
     * @return
     */
    @Override
    public OrderPO getOrderInfo(String orderID) throws RemoteException {
        return orderDataService.getOrderInfo(orderID);
    }
}

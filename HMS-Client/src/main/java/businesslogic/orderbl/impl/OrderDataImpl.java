package businesslogic.orderbl.impl;

import businesslogic.hotelsalerbl.HotelOrderInfo;
import businesslogic.logbl.Login;
import businesslogic.userbl.interfaces.UserOrderInfo;
import com.sun.org.apache.xpath.internal.operations.Or;
import data_stub.orderdata.OrderDataImpl_stub;
import dataservice.orderdataservice.OrderDataService;
import enumData.IDType;
import enumData.ResultMessage;
import po.OrderPO;
import utility.OrderPVChanger;
import vo.OrderVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * 酒店订单数据接口实现
 * @author qzh
 * Created by user on 2016/12/2.
 */
public class OrderDataImpl implements UserOrderInfo,HotelOrderInfo{
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
        return orderDataService.getOrderList(Login.getNowUserID(),IDType.userID);
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

    /**
     * 获得一个酒店的所有订单列表
     *
     * @param hotelID 酒店ID
     * @return 酒店订单列表
     */
    @Override
    public ArrayList<OrderVO> getHotelOrders(String hotelID) throws RemoteException{
        ArrayList<OrderVO> res = new ArrayList<OrderVO>();
        for(OrderPO po:orderDataService.getOrderList(hotelID, IDType.hotelID)){
            res.add(OrderPVChanger.orderP2V(po));
        }
        return res;
    }

    /**
     * 更新订单信息
     * @param po 订单信息
     * @return 是否成功
     */
    @Override
    public ResultMessage setOrder(OrderPO po) throws RemoteException {
        return orderDataService.setOrderInfo(po);
    }
}

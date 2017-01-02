package businesslogic.orderbl;

import businesslogic.logbl.Login;
import dataservice.orderdataservice.OrderDataService;
import enumData.IDType;
import enumData.OrderState;
import enumData.ResultMessage;
import po.CanceledExceptionOrderPO;
import po.OrderPO;
import rmi.RemoteHelper;
import utility.OrderPVChanger;
import vo.CanceledExceptionOrderVO;
import vo.OrderVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * 酒店订单数据接口实现
 *
 * @author qzh
 *         Created by user on 2016/12/2.
 */
public class Order{
    /**
     * 订单数据模块
     */
    OrderDataService orderDataService;

    public Order() {
        //TODO
//    orderDataService = new OrderDataImpl_stub();
        orderDataService = RemoteHelper.getInstance().getOrderDataService();
    }

    /**
     * 生成订单
     *
     * @param po 订单信息
     */
    public void addOrder(OrderPO po) throws RemoteException {
        orderDataService.addOrder(po);
    }

    /**
     * 获得用户订单列表
     *
     * @param orderState 订单状态
     * @return 登录用户订单列表
     */
    public ArrayList<OrderPO> getOrderListByState(OrderState orderState) throws RemoteException {
        ArrayList<OrderPO> res = new ArrayList<>();
        for(OrderPO po:orderDataService.getOrderList(Login.getNowUserID(), IDType.userID)){
            if(po.getOrderState().equals(orderState))
                res.add(po);
        }
        return res;
    }

    /**
     * 获得用户订单列表
     *
     * @return 登录用户订单列表
     */
    public ArrayList<OrderPO> getOrderList() throws RemoteException {
        return orderDataService.getOrderList(Login.getNowUserID(), IDType.userID);
    }

    /**
     * 修改订单信息
     *
     * @param po
     */
    public void setOrderInfo(OrderPO po) throws RemoteException {
        orderDataService.setOrderInfo(po);
    }

    /**
     * 根据订单ID获取订单信息
     *
     * @param orderID
     * @return
     */
    public OrderPO getOrderInfo(String orderID) throws RemoteException {
        return orderDataService.getOrderInfo(orderID);
    }

    /**
     * 获得一个酒店的对应类型的订单列表
     *
     * @param hotelID    酒店ID
     * @param orderState 订单状态
     * @return 酒店订单列表
     */
    public ArrayList<OrderVO> getHotelOrdersByState(String hotelID, OrderState orderState) throws RemoteException {
        ArrayList<OrderVO> res = new ArrayList<OrderVO>();
        for (OrderPO po : orderDataService.getOrderList(hotelID, IDType.hotelID)) {
            if(po.getOrderState().equals(orderState))
                res.add(OrderPVChanger.orderP2V(po));
        }
        return res;
    }

    public ArrayList<OrderVO> getHotelOrders(String hotelID) throws RemoteException {
        ArrayList<OrderVO> res = new ArrayList<>();
        for(OrderPO po:orderDataService.getOrderList(hotelID,IDType.hotelID)){
            res.add(OrderPVChanger.orderP2V(po));
        }
        return res;
    }

    /**
     * 更新订单信息
     *
     * @param po 订单信息
     * @return 是否成功
     */
    public ResultMessage setOrder(OrderPO po) throws RemoteException {
        return orderDataService.setOrderInfo(po);
    }

    public ArrayList<OrderVO> getOrderByState(OrderState orderState) throws RemoteException {
        ArrayList<OrderVO> res = new ArrayList<>();
        for(OrderPO po:orderDataService.getOrderList(orderState)){
            res.add(OrderPVChanger.orderP2V(po));
        }
        return res;
    }

    public OrderVO getOrder(String orderID) throws RemoteException {
        return OrderPVChanger.orderP2V(orderDataService.getOrderInfo(orderID));
    }

    public void setOrder(OrderVO vo) throws RemoteException {
        orderDataService.setOrderInfo(OrderPVChanger.orderV2P(vo));
    }

    public ArrayList<CanceledExceptionOrderVO> getCanceledExceptionOrders() throws RemoteException {
        ArrayList<CanceledExceptionOrderVO> res = new ArrayList<>();
        for(CanceledExceptionOrderPO po:orderDataService.getOrderExceptionInfo()){
            res.add(OrderPVChanger.canceledExceptionOrderP2V(po));
        }
        return res;
    }

    public CanceledExceptionOrderVO getCanceledExceptionOrder(String orderID) throws RemoteException {
        return OrderPVChanger.canceledExceptionOrderP2V(orderDataService.getOrderExceptionInfo(orderID));
    }

    public void addExceptionOrder(CanceledExceptionOrderVO vo) throws RemoteException {
        orderDataService.addOrderExceptionInfo(OrderPVChanger.canceledExceptionOrderV2P(vo));
    }
}

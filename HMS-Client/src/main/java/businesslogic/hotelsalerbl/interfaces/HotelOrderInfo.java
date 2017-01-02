package businesslogic.hotelsalerbl.interfaces;

import enumData.OrderState;
import enumData.ResultMessage;
import po.OrderPO;
import vo.OrderVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * 酒店订单信息接口
 *
 * @author qzh
 *         Created by user on 2016/12/9.
 */
public interface HotelOrderInfo {
    /**
     * 获得一个酒店的对应类型的订单列表
     *
     * @param hotelID    酒店ID
     * @param orderState 订单状态
     * @return 酒店订单列表
     */
    public ArrayList<OrderVO> getHotelOrdersByState(String hotelID, OrderState orderState) throws RemoteException;

    /**
     * 获得一个酒店的对应类型的订单列表
     *
     * @param hotelID    酒店ID
     * @return 酒店订单列表
     */
    public ArrayList<OrderVO> getHotelOrders(String hotelID) throws RemoteException;

    /**
     * 更新订单信息
     *
     * @param po 订单信息
     * @return 是否成功
     */
    public ResultMessage setOrder(OrderPO po) throws RemoteException;

    /**
     * 根据订单ID返回对应订单
     *
     * @param orderID
     * @return
     * @throws RemoteException
     */
    public OrderPO getOrderInfo(String orderID) throws RemoteException;
}

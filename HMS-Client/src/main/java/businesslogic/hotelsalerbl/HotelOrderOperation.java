package businesslogic.hotelsalerbl;

import businesslogic.logbl.Login;
import businesslogic.orderbl.impl.OrderDataImpl;
import enumData.OrderState;
import enumData.ResultMessage;
import utility.OrderPVChanger;
import vo.OrderVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * 酒店订单操作
 * 负责更新订单信息、查看订单
 *
 * @author qzh
 *         Created by user on 2016/12/9.
 */
public class HotelOrderOperation {
    HotelOrderInfo hotelOrderInfo;

    public HotelOrderOperation() {
        hotelOrderInfo = new OrderDataImpl();
    }

    /**
     * 浏览登录帐号对应酒店订单
     *
     * @param orderState 订单状态
     * @return 对应酒店订单信息
     */
    public ArrayList<OrderVO> readOrder(OrderState orderState) throws RemoteException {
        return hotelOrderInfo.getHotelOrders(Login.getNowUserID(),orderState);
    }

    /**
     * 更新订单信息
     *
     * @param vo 订单信息
     * @return 是否成功
     */
    public ResultMessage updateOrder(OrderVO vo) throws RemoteException {
        return hotelOrderInfo.setOrder(OrderPVChanger.orderV2P(vo));
    }
}

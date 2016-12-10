package businesslogic.hotelsalerbl;

import businesslogic.orderbl.impl.OrderDataImpl;
import enumData.ResultMessage;
import utility.OrderPVChanger;
import vo.OrderVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * 酒店订单操作
 * 负责更新订单信息、查看订单
 * @author qzh
 * Created by user on 2016/12/9.
 */
public class HotelOrderOperation {
    HotelOrderInfo hotelOrderInfo;

    public HotelOrderOperation() {
        hotelOrderInfo = new OrderDataImpl();
    }

    /**
     * 浏览酒店订单
     * @param hotelID 酒店编号
     * @return 对应酒店订单信息
     */
    public ArrayList<OrderVO> readOrder(String hotelID)throws RemoteException {
        return hotelOrderInfo.getHotelOrders(hotelID);
    }

    /**
     * 更新订单信息
     * @param vo 订单信息
     * @return 是否成功
     */
    public ResultMessage updateOrder(OrderVO vo) throws RemoteException{
        return hotelOrderInfo.setOrder(OrderPVChanger.orderV2P(vo));
    }
}

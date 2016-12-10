package businesslogic.hotelsalerbl;

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
     * 获得一个酒店的所有订单列表
     *
     * @param hotelID 酒店ID
     * @return 酒店订单列表
     */
    public ArrayList<OrderVO> getHotelOrders(String hotelID)throws RemoteException;

    /**
     * 更新订单信息
     * @param po 订单信息
     * @return 是否成功
     */
    public ResultMessage setOrder(OrderPO po)throws RemoteException;
}

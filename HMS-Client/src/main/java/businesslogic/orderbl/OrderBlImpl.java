package businesslogic.orderbl;

import java.util.ArrayList;
import businesslogicservice.orderblservice.OrderBlService;
import data_stub.orderdata.OrderDataImpl_stub;
import dataservice.orderdataservice.OrderDataService;
import po.OrderPO;
import vo.OrderVO;

public class OrderBlImpl implements OrderBlService {

    ArrayList<OrderVO> orderList;
    OrderDataService orderDataService;

    public OrderBlImpl() {
        orderDataService = new OrderDataImpl_stub();
        orderList = new ArrayList<OrderVO>();
    }

    /**
     *根据orderID查看订单信息
     * @param orderID 订单编号
     * @return
     */
    public OrderVO getOrderInfo(String orderID) {
        OrderPO po = orderDataService.getOrderInfo(orderID);
        if (po != null) {
            OrderVO vo = new OrderVO(po.getOrderID(), po.getOrderState(), po.getHotelID(), po.getUserID(), po.getDate(), po.getRoomID());
            return vo;
        } else {
            return null;
        }
    }

    /**
     * 根据accout返回对应订单列表
     * @param account 账户编号
     * @return
     */
    public ArrayList<OrderVO> getOrderList(String account) {
        ArrayList<OrderPO> temp = orderDataService.getOrderList(account);
        for (int i = 0; i < temp.size(); i++) {
            OrderPO po = temp.get(i);
            if (po != null){
                OrderVO vo = new OrderVO(po.getOrderID(), po.getOrderState(), po.getHotelID(), po.getUserID(), po.getDate(), po.getRoomID());
                orderList.add(vo);
            }
        }
        return orderList;
    }
}

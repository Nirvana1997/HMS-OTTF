package businesslogic.orderbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import businesslogicservice.orderblservice.OrderBlService;
import data_stub.orderdata.OrderDataImpl_stub;
import dataservice.orderdataservice.OrderDataService;
import po.OrderPO;
import utility.OrderPVChanger;
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
    public OrderVO getOrderInfo(String orderID) throws RemoteException {
        OrderPO po = orderDataService.getOrderInfo(orderID);
        if (po != null) {
            OrderVO vo = OrderPVChanger.orderP2V(po);
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
    public ArrayList<OrderVO> getOrderList(String account) throws RemoteException {
        ArrayList<OrderPO> temp = orderDataService.getOrderList(account);
        for (int i = 0; i < temp.size(); i++) {
            OrderPO po = temp.get(i);
            if (po != null){
                OrderVO vo = OrderPVChanger.orderP2V(po);
                orderList.add(vo);
            }
        }
        return orderList;
    }
}

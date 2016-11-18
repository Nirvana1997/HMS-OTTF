package data_stub.orderdata;

import dataservice.orderdataservice.OrderDataService;
import enumData.OrderState;
import enumData.ResultMessage;
import po.OrderPO;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class OrderDataImpl_stub implements OrderDataService {
    ArrayList<OrderPO> orderList = new ArrayList<OrderPO>();
    Date date1 = new Date(2016, 7, 18);
    OrderPO order1 = new OrderPO("0001", OrderState.executing, "0001", "0001", date1, "007");
    Date date2 = new Date(2016, 11, 12);
    OrderPO order2 = new OrderPO("0002", OrderState.executed, "0002", "0001", date2, "008");
    Date date3 = new Date(2016, 11, 14);
    OrderPO order3 = new OrderPO("0003", OrderState.canceled, "0003", "0001", date3, "009");

    public OrderDataImpl_stub() {
        orderList.add(order1);
        orderList.add(order2);
        orderList.add(order3);
    }

    @Override
    public OrderPO getOrderInfo(String orderID) {
        Iterator orderItr = orderList.iterator();
        while (orderItr.hasNext()) {
            OrderPO po = (OrderPO) orderItr.next();
			if(po.getOrderID().equals(orderID)){
                return po;
            }
        }
        return null;
    }

    @Override
    public ResultMessage setOrderInfo(OrderPO po) {
        // TODO Auto-generated method stub
        return ResultMessage.Correct;
    }

    @Override
    public ResultMessage addOrder(OrderPO po) {
        // TODO Auto-generated method stub
        return ResultMessage.Correct;
    }

    @Override
    public ResultMessage deleteOrder(String orderID) {
        // TODO Auto-generated method stub
        return ResultMessage.Correct;
    }

    @Override
    public ArrayList<OrderPO> getOrderList(String account) {
        // TODO Auto-generated method stub
        ArrayList<OrderPO> temp = new ArrayList<OrderPO>();
        for (int i = 0; i < orderList.size(); i++) {
            if (orderList.get(i).getUserID() == account){
                temp.add(orderList.get(i));
            }
        }
        return temp;
    }

}

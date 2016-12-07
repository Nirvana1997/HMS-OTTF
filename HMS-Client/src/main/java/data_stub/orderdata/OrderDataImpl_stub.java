package data_stub.orderdata;

import dataservice.orderdataservice.OrderDataService;
import enumData.*;
import po.OrderPO;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class OrderDataImpl_stub implements OrderDataService {
    ArrayList<OrderPO> orderList = new ArrayList<OrderPO>();
    OrderPO order1 = new OrderPO("01","ZHotel", TradeArea.Xianlin, Address.NJU,"In Xianlin",1,1,"2016_5_8","2016_5_9",RoomType.SingleRoom,false,"001","151520175",OrderState.executing,"7:00",300,"Web period","001");
    OrderPO order2 = new OrderPO("02","XHotel", TradeArea.XuanQuan, Address.NJU,"In XuanQuan",1,2,"2016_9_10","2016_9_12",RoomType.StandardRoom,false,"002","151520119",OrderState.abnormal,"8:00",200,"Web Vip","001");
    OrderPO order3 = new OrderPO("02","DHotel", TradeArea.XuanQuan, Address.NJU,"In XuanQuan",2,2,"2016_12_1","2016_12_2",RoomType.DoubleRoom,true,"003","151520125",OrderState.canceled,"9:00",270,"Web vip","001");
    OrderPO order4 = new OrderPO("03","BHotel", TradeArea.Xianlin, Address.NJU,"In Xianlin",3,2,"2016_1_1","2016_1_2",RoomType.DoubleRoom,false,"004","151520135",OrderState.executing,"5:00",130,"Trade discount","001");
    OrderPO order5 = new OrderPO("03","AHotel", TradeArea.Xianlin, Address.NJU,"In Xianlin",3,2,"2016_10_11","2016_10_12",RoomType.SingleRoom,false,"005","151520145",OrderState.executing,"4:00",390,"Company discount","001");
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
        deleteOrder(po.getOrderID());
        addOrder(po);
        return ResultMessage.Correct;
    }

    @Override
    public ResultMessage addOrder(OrderPO po) {
        orderList.add(po);
        return ResultMessage.Correct;
    }

    @Override
    public ResultMessage deleteOrder(String orderID) {
        for(int i=0;i<orderList.size();i++){
            if(orderList.get(i).getOrderID().equals(orderID))
                orderList.remove(i);
        }
        return ResultMessage.Correct;
    }

    @Override
    public ArrayList<OrderPO> getOrderList(String account) {
        // TODO Auto-generated method stub
        ArrayList<OrderPO> temp = new ArrayList<OrderPO>();
        for (int i = 0; i < orderList.size(); i++) {
            if (orderList.get(i).getUserID().equals(account)){
                temp.add(orderList.get(i));
            }
        }
        return temp;
    }

}

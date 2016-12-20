package data_stub.orderdata;

import dataservice.orderdataservice.OrderDataService;
import enumData.*;
import po.CanceledExceptionOrderPO;
import po.OrderPO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

public class OrderDataImpl_stub implements OrderDataService {
    @Override
    public OrderPO getOrderInfo(String orderID) throws RemoteException {
        return null;
    }

    @Override
    public ResultMessage setOrderInfo(OrderPO po) throws RemoteException {
        return null;
    }

    @Override
    public ArrayList<OrderPO> getOrderList(OrderState orderState) throws RemoteException {
        return null;
    }

    @Override
    public ArrayList<OrderPO> getOrderList(String ID, IDType type) throws RemoteException {
        return null;
    }

    @Override
    public ResultMessage addOrder(OrderPO po) throws RemoteException {
        return null;
    }

    @Override
    public ResultMessage deleteOrder(String orderID) throws RemoteException {
        return null;
    }

    @Override
    public ResultMessage addOrderExceptionInfo(CanceledExceptionOrderPO po) throws RemoteException {
        return null;
    }

    @Override
    public CanceledExceptionOrderPO getOrderExceptionInfo(String orderID) throws RemoteException {
        return null;
    }

    @Override
    public ArrayList<CanceledExceptionOrderPO> getOrderExceptionInfo() throws RemoteException {
        return null;
    }
//    ArrayList<OrderPO> orderList = new ArrayList<OrderPO>();
//    OrderPO order1 = new OrderPO("0200001", "ZHotel", TradeArea.Changjiang, Address.Shanghai, "In Xianlin", 1, 1, "2016_5_8", "2016_5_9", RoomType.SingleRoom, false, "001", "0100001", OrderState.executing, 300, "Web period", "001");
//    OrderPO order2 = new OrderPO("0200002", "XHotel", TradeArea.Huanghe, Address.Tianjing, "In XuanQuan", 1, 2, "2016_9_10", "2016_9_12", RoomType.DisabledRoom, false, "002", "0100001", OrderState.abnormal, 200, "Web Vip", "001");
//    OrderPO order3 = new OrderPO("0200002", "DHotel", TradeArea.Huanghe, Address.Tianjing, "In XuanQuan", 2, 2, "2016_12_1", "2016_12_2", RoomType.DoubleRoom, true, "003", "0100001", OrderState.canceled, 270, "Web vip", "001");
//    OrderPO order4 = new OrderPO("0200001", "BHotel", TradeArea.Nanhai, Address.Aomen, "In Xianlin", 3, 2, "2016_1_1", "2016_1_2", RoomType.DoubleRoom, false, "004", "0100001", OrderState.executing, 130, "Trade discount", "001");
//    OrderPO order5 = new OrderPO("0200003", "AHotel", TradeArea.Changjiang, Address.Nanjing, "In Xianlin", 3, 2, "2016_10_11", "2016_10_12", RoomType.SingleRoom, false, "005", "0100001", OrderState.executing, 390, "Company discount", "001");
//
//    public OrderDataImpl_stub() {
//        orderList.add(order1);
//        orderList.add(order2);
//        orderList.add(order3);
//        orderList.add(order4);
//        orderList.add(order5);
//    }
//
//    @Override
//    public OrderPO getOrderInfo(String orderID) {
//        Iterator orderItr = orderList.iterator();
//        while (orderItr.hasNext()) {
//            OrderPO po = (OrderPO) orderItr.next();
//            if (po.getOrderID().equals(orderID)) {
//                return po;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public ResultMessage setOrderInfo(OrderPO po) {
//        for(int i=0;i<orderList.size();i++){
//            if(orderList.get(i).getOrderID().equals(po.getOrderID())){
//                orderList.set(i,po);
//            }
//        }
//        return ResultMessage.Correct;
//    }
//
//    @Override
//    public ArrayList<OrderPO> getOrderList(OrderState orderState) throws RemoteException {
//        return null;
//    }
//
//    @Override
//    public ResultMessage addOrder(OrderPO po) {
//        orderList.add(po);
//        return ResultMessage.Correct;
//    }
//
//    @Override
//    public ResultMessage deleteOrder(String orderID) {
//        for (int i = 0; i < orderList.size(); i++) {
//            if (orderList.get(i).getOrderID().equals(orderID))
//                orderList.remove(i);
//        }
//        return ResultMessage.Correct;
//    }
//
//    @Override
//    public ResultMessage addOrderExceptionInfo(CanceledExceptionOrderPO po) throws RemoteException {
//        return null;
//    }
//
//    @Override
//    public CanceledExceptionOrderPO getOrderExceptionInfo(String orderID) throws RemoteException {
//        return null;
//    }
//
//    @Override
//    public ArrayList<CanceledExceptionOrderPO> getOrderExceptionInfo() throws RemoteException {
//        return null;
//    }
//
//    @Override
//    public ArrayList<OrderPO> getOrderList(String account, IDType idType) throws RemoteException {
//        ArrayList<OrderPO> temp = new ArrayList<OrderPO>();
//        if (idType.equals(IDType.userID))
//            for (int i = 0; i < orderList.size(); i++) {
//                if (orderList.get(i).getUserID().equals(account)) {
//                    temp.add(orderList.get(i));
//                }
//            }
//        else {
//            for (int i = 0; i < orderList.size(); i++) {
//                if (orderList.get(i).getHotelID().equals(account)) {
//                    temp.add(orderList.get(i));
//                }
//            }
//        }
//        return temp;
//    }

}

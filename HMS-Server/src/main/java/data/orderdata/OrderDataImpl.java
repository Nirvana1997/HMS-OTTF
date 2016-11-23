package data.orderdata;

import dataservice.orderdataservice.OrderDataService;
import enumData.ResultMessage;
import po.OrderPO;

import java.util.ArrayList;

/**
 * Created by mac on 2016/11/23.
 */
public class OrderDataImpl implements OrderDataService {
    @Override
    public OrderPO getOrderInfo(String orderID) {
        return null;
    }

    @Override
    public ResultMessage setOrderInfo(OrderPO po) {
        return null;
    }

    @Override
    public ArrayList<OrderPO> getOrderList(String account) {
        return null;
    }

    @Override
    public ResultMessage addOrder(OrderPO po) {
        return null;
    }

    @Override
    public ResultMessage deleteOrder(String orderID) {
        return null;
    }
}

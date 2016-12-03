package businesslogic.orderbl.impl;

import businesslogic.logbl.ClientUser;
import businesslogic.userbl.UserOrderInfo;
import data_stub.orderdata.OrderDataImpl_stub;
import dataservice.orderdataservice.OrderDataService;
import dataservice.userdataservice.UserDataService;
import driver.ClientRunner;
import po.OrderPO;

import java.util.ArrayList;

/**
 * 酒店订单数据接口实现
 * @author qzh
 * Created by personalUser on 2016/12/2.
 */
public class OrderDataImpl implements UserOrderInfo{
    OrderDataService orderDataService;

    public OrderDataImpl() {
        orderDataService = new OrderDataImpl_stub();
    }

    /**
     * 生成订单
     * @param po 订单信息
     */
    @Override
    public void addOrder(OrderPO po) {
        orderDataService.addOrder(po);
    }

    /**
     * 获得用户订单列表
     * @return 登录用户订单列表
     */
    @Override
    public ArrayList<OrderPO> getOrderList() {
        return orderDataService.getOrderList(ClientUser.getInstance().getNowUser());
    }
}

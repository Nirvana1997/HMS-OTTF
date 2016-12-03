package businesslogic.userbl;

import po.OrderPO;

import java.util.ArrayList;

/**
 * 用户订单数据接口
 * Created by personalUser on 2016/12/2.
 */
public interface UserOrderInfo {
    /**
     * 在数据层生成订单信息
     * @param po 订单信息
     */
    public void addOrder(OrderPO po);

    /**
     * 获得用户订单列表
     * @return 登录用户订单列表
     */
    public ArrayList<OrderPO> getOrderList();
}

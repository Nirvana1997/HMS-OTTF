package businesslogic.userbl.interfaces;

import po.OrderPO;

import java.rmi.RemoteException;

/**
 * 订单信息接口
 * @author qzh
 * Created by user on 2016/12/4.
 */
public interface OrderInfo {
    /**
     * 添加订单信息
     * @param po 订单信息
     * @throws RemoteException
     */
    public void addOrder(OrderPO po)throws RemoteException;
}

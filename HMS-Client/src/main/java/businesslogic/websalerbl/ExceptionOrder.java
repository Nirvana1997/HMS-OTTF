package businesslogic.websalerbl;

import po.OrderExceptionPO;
import po.OrderPO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * 异常订单处理接口
 *
 * @author qzh
 *         Created by user on 2016/12/16.
 */
public interface ExceptionOrder {
    /**
     * 获得所有异常订单
     *
     * @return 异常订单列表
     * @throws RemoteException
     */
    public ArrayList<OrderExceptionPO> getExceptionOrders(boolean hasCanceled) throws RemoteException;

    /**
     * 撤销异常订单
     *
     * @param po 异常订单信息
     * @throws RemoteException
     */
    public void cancelOrder(OrderExceptionPO po) throws RemoteException;
}

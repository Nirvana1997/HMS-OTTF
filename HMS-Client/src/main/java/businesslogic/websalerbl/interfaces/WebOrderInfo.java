package businesslogic.websalerbl.interfaces;

import enumData.CreditRecoverWay;
import enumData.OrderState;
import vo.CanceledExceptionOrderVO;
import vo.OrderVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * 网站营销人员的订单操作
 * Created by user on 2016/12/18.
 */
public interface WebOrderInfo {
    /**
     * 根据状态返回对应订单
     *
     * @param orderState 订单状态
     * @return 所有对应状态订单
     * @throws RemoteException
     */
    public ArrayList<OrderVO> getOrderByState(OrderState orderState) throws RemoteException;

    /**
     * 根据订单ID返回订单信息
     *
     * @param orderID 订单ID
     * @return 订单信息
     * @throws RemoteException
     */
    public OrderVO getOrder(String orderID) throws RemoteException;

    /**
     * 修改订单信息
     *
     * @param vo 订单信息
     * @throws RemoteException
     */
    public void setOrder(OrderVO vo) throws RemoteException;

    /**
     * 返回所有撤销的异常订单
     *
     * @return 撤销的异常订单列表
     */
    public ArrayList<CanceledExceptionOrderVO> getCanceledExceptionOrders() throws RemoteException;

    /**
     * 根据ID返回撤销的异常订单
     *
     * @return 撤销的异常订单
     */
    public CanceledExceptionOrderVO getCanceledExceptionOrder(String orderID) throws RemoteException;

    /**
     * 撤销异常订单、更新撤销信息并恢复信用值
     *
     * @param vo 撤销的异常订单信息
     * @throws RemoteException
     */
    public void addExceptionOrder(CanceledExceptionOrderVO vo) throws RemoteException;
}

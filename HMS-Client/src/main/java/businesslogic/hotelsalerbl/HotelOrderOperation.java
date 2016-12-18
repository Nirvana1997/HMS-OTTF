package businesslogic.hotelsalerbl;

import businesslogic.logbl.Login;
import businesslogic.orderbl.impl.OrderDataImpl;
import businesslogic.userbl.impl.UserDataImpl;
import cfg.Temp;
import enumData.OrderState;
import enumData.ResultMessage;
import po.CreditChangePO;
import utility.DateOperation;
import utility.OrderPVChanger;
import vo.OrderVO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

/**
 * 酒店订单操作
 * 负责更新订单信息、查看订单
 *
 * @author qzh
 *         Created by user on 2016/12/9.
 */
public class HotelOrderOperation {
    /**
     * 酒店订单模块
     */
    HotelOrderInfo hotelOrderInfo;

    CreditInfoForHotel creditInfoForHotel;

    public HotelOrderOperation() {
        hotelOrderInfo = new OrderDataImpl();
        creditInfoForHotel = new UserDataImpl();
    }

    /**
     * 浏览登录帐号对应状态的酒店订单
     *
     * @param orderState 订单状态
     * @return 对应酒店订单信息
     */
    public ArrayList<OrderVO> readOrder(OrderState orderState) throws RemoteException {
        return hotelOrderInfo.getHotelOrdersByState(Login.getNowUserID(), orderState);
    }

    /**
     * 浏览登录帐号对应酒店订单
     *
     * @return 对应酒店订单信息
     */
    public ArrayList<OrderVO> readOrder() throws RemoteException {
        return hotelOrderInfo.getHotelOrders(Login.getNowUserID());
    }

    /**
     * 根据订单ID返回对应订单
     *
     * @param orderID
     * @return
     * @throws RemoteException
     */
    public OrderVO readOrderByID(String orderID) throws RemoteException{
        return OrderPVChanger.orderP2V(hotelOrderInfo.getOrderInfo(orderID));
    }

    /**
     * 更新订单信息
     *
     * @param vo 订单信息
     * @return 是否成功
     */
    public ResultMessage updateOrder(OrderVO vo) throws RemoteException {
        return hotelOrderInfo.setOrder(OrderPVChanger.orderV2P(vo));
    }

    /**
     * 执行订单并增加对应用户信用
     *
     * @param vo 订单信息
     * @throws RemoteException
     */
    public void executeOrder(OrderVO vo) throws RemoteException {
        vo.setOrderState(OrderState.executed);
        hotelOrderInfo.setOrder(OrderPVChanger.orderV2P(vo));
        //为对应用户添加信用值
        creditInfoForHotel.addCredit(new CreditChangePO(vo.getUserID(),vo.getOrderID(), DateOperation.dateToString(new Date()), Temp.reasonOfExecuting,(int)vo.getPrice()));
    }

    /**
     * 更新订单的入住和退房时间、置为未执行订单
     *
     * @param vo
     * @throws RemoteException
     */
    public void delayOrder(OrderVO vo) throws RemoteException {
        vo.setOrderState(OrderState.executing);
        hotelOrderInfo.setOrder(OrderPVChanger.orderV2P(vo));
        //恢复用户信用值
        creditInfoForHotel.addCredit(new CreditChangePO(vo.getUserID(),vo.getOrderID(), DateOperation.dateToString(new Date()), Temp.reasonOfDelaying,(int)vo.getPrice()));
    }
}

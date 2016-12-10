package businesslogic.userbl;

import businesslogic.hotelsalerbl.impl.HotelDataImpl;
import businesslogic.hotelsalerbl.impl.CommentDataImpl;
import businesslogic.logbl.Login;
import businesslogic.orderbl.impl.OrderDataImpl;
import businesslogic.userbl.interfaces.CommentInfo;
import businesslogic.userbl.interfaces.HotelInfo;
import businesslogic.userbl.interfaces.UserOrderInfo;
import cfg.Temp;
import data_stub.userdata.UserDataImpl_stub;
import dataservice.userdataservice.UserDataService;
import enumData.*;
import po.OrderPO;
import utility.DateOperation;
import utility.OrderPVChanger;
import vo.*;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

/**
 * 酒店预定模块
 * 负责预定酒店、浏览订单和评价
 *
 * @author qzh
 */
public class HotelOrder {
    /**
     * 酒店列表
     */
    HotelInfo hotelInfo;

    /**
     * 判断房间数目
     */
    RoomNumJudger roomNumJudger;

    /**
     * 订单数据接口
     */
    UserOrderInfo userOrderInfo;

    /**
     * 评价数据接口
     */
    CommentInfo commentInfo;

    /**
     * 用户信息接口
     */
    UserDataService userDataService;

    public HotelOrder() throws RemoteException {
        hotelInfo = new HotelDataImpl();
        roomNumJudger = new RoomNumJudger();
        userOrderInfo = new OrderDataImpl();
        commentInfo = new CommentDataImpl();
        //TODO
        userDataService = new UserDataImpl_stub();
    }

    /**
     * 返回是否房间数目是否足够
     *
     * @param vo 订单信息
     * @return 房间数目是否足够
     */
    public boolean haveEnoughRoom(OrderVO vo) throws RemoteException {
        return roomNumJudger.haveEnoughRoom(vo.getHotelID(),vo.getCheckInDate(),vo.getCheckOutDate(),vo.getRoomType(),vo.getRoomNumber());
    }

    /**
     * 计算订单价格并生成订单信息
     *
     * @param vo 订单输入信息
     * @return 经过计算补充的订单信息
     * @throws RemoteException
     */
    public OrderVO makeOrder(OrderVO vo) throws RemoteException {
        OrderFiller orderFiller = new OrderFiller(vo);
        return orderFiller.fillOrder();
    }

    /**
     * 确认订单
     *
     * @param vo 订单信息
     * @return 是否成功
     */
    public boolean orderHotel(OrderVO vo) throws RemoteException{
        userOrderInfo.addOrder(OrderPVChanger.orderV2P(vo));
        return true;
    }

    /**
     * 根据用户id得到该用户的订单列表
     *
     * @param userID
     * @return 订单列表
     */
    public ArrayList<OrderVO> readOrder(String userID) throws RemoteException {
        //结果数组
        ArrayList<OrderVO> res = new ArrayList<OrderVO>();
        for(OrderPO po:userOrderInfo.getOrderList()){
            res.add(OrderPVChanger.orderP2V(po));
        }
        return res;
    }

    /**
     * 根据订单ID取消该订单
     * 若超出规定时间，会扣除一定信用
     *
     * @param orderID 订单ID
     * @return 若成功则返回Correct，若发生错误则返回Incorrect
     */
    public ResultMessage cancelOrder(String orderID) throws RemoteException{
        OrderPO po = userOrderInfo.getOrderInfo(orderID);
        //判断是否为未执行的订单
        if (po.getOrderState().equals(OrderState.executing)) {
            po.setOrderState(OrderState.canceled);
            userOrderInfo.setOrderInfo(po);

            //计算规定时间
            Date ddl = DateOperation.subHours(DateOperation.stringToDate(po.getDdl()), Temp.H);
            //判断是否在规定时间前取消，若超过规定时间，则减少一定的信用值
            if(new Date().after(ddl)){
                userDataService.subCredit(Login.getNowUserID(),(int)(po.getPrice()*Temp.CREDIT_CUT),DateOperation.dateToString(new Date()));
            }
            return ResultMessage.Correct;
        }else{
            return ResultMessage.InCorrect;
        }
    }

    /**
     * 评价订单
     *
     * @param vo
     */
    public void comment(CommentVO vo) throws RemoteException {
        commentInfo.makeComment(vo);
    }

}

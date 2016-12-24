package businesslogic.userbl;

import businesslogic.hotelsalerbl.impl.HotelDataImpl;
import businesslogic.hotelsalerbl.impl.CommentDataImpl;
import businesslogic.orderbl.impl.OrderDataImpl;
import businesslogic.userbl.interfaces.CommentInfo;
import businesslogic.userbl.interfaces.HotelInfo;
import businesslogic.userbl.interfaces.UserOrderInfo;
import cfg.CfgReader;
import dataservice.userdataservice.UserDataService;
import enumData.*;
import po.CreditChangePO;
import po.HotelroomPO;
import po.OrderPO;
import po.RoomNumPO;
import rmi.RemoteHelper;
import utility.DateOperation;
import utility.HotelPVChanger;
import utility.OrderPVChanger;
import vo.*;

import java.awt.*;
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
//        userDataService = new UserDataImpl_stub();
        userDataService = RemoteHelper.getInstance().getUserDataService();
    }

    /**
     * 返回是否房间数目是否足够
     *
     * @param vo 订单信息
     * @return 房间数目是否足够
     */
    public boolean haveEnoughRoom(OrderVO vo) throws RemoteException {
        return roomNumJudger.haveEnoughRoom(vo.getHotelID(), vo.getCheckInDate(), vo.getCheckOutDate(), vo.getRoomType(), vo.getRoomNumber());
    }

    /**
     * 获得当天酒店房间信息
     *
     * @param hotelID 酒店id
     * @return 酒店房间信息
     * @throws RemoteException
     */
    public ArrayList<RoomNumVO> getRooms(String hotelID) throws RemoteException{
        ArrayList<RoomNumVO> res = new ArrayList<>();
        for(RoomNumPO po:hotelInfo.getRooms(hotelID,new Date())){
            res.add(HotelPVChanger.emptyRoomP2V(po));
        }
        for(RoomNumVO vo:res){
            vo.setDate(String.valueOf(hotelInfo.getRoomPrice(hotelID,vo.getRoomType())));
        }
        return res;
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
     * 确认订单并更新房间数目
     *
     * @param vo 订单信息
     * @return 是否成功
     */
    public boolean orderHotel(OrderVO vo) throws RemoteException {
        userOrderInfo.addOrder(OrderPVChanger.orderV2P(vo));
        hotelInfo.subRoom(vo.getHotelID(),vo.getCheckInDate(),vo.getCheckOutDate(),vo.getRoomType(),vo.getRoomNumber());
        return true;
    }

    /**
     * 返回订单信息
     *
     * @param orderID 订单编号
     * @return 订单
     * @throws RemoteException
     */
    public OrderVO getOrderInfo(String orderID) throws RemoteException {
        return OrderPVChanger.orderP2V(userOrderInfo.getOrderInfo(orderID));
    }

    /**
     * 根据用户id得到该用户的订单列表
     *
     * @param orderState 订单状态
     * @return 订单列表
     */
    public ArrayList<OrderVO> readOrder(OrderState orderState) throws RemoteException {
        //结果数组
        ArrayList<OrderVO> res = new ArrayList<OrderVO>();
        for (OrderPO po : userOrderInfo.getOrderListByState(orderState)) {
            res.add(OrderPVChanger.orderP2V(po));
        }
        return res;
    }

    /**
     * 根据酒店ID和登录用户ID返回用户在该酒店的订单信息
     *
     * @param hotelID 酒店id
     * @return 对应订单list
     * @throws RemoteException
     */
    public ArrayList<OrderVO> getHotelOrderByUser(String hotelID) throws RemoteException {
        //结果数组
        ArrayList<OrderVO> res = new ArrayList<OrderVO>();
        for (OrderPO po : userOrderInfo.getOrderList()) {
            if (po.getHotelID().equals(hotelID))
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
    public ResultMessage cancelOrder(String orderID) throws RemoteException {
        OrderPO po = userOrderInfo.getOrderInfo(orderID);
        //判断是否为未执行的订单
        if (po.getOrderState().equals(OrderState.executing)) {
            po.setOrderState(OrderState.canceled);
            userOrderInfo.setOrderInfo(po);

            //计算扣除信用的规定时间
            Date subCreditDdl = DateOperation.addHours(DateOperation.stringToDate(po.getCheckInDate()), Integer.valueOf(CfgReader.getInstance().getProperty("deadline")) - Integer.valueOf(CfgReader.getInstance().getProperty("time")));
            //判断是否在规定时间前取消，若超过规定时间，则减少一定的信用值
            if (new Date().after(subCreditDdl)) {
                //计算要被扣除的信用值
                int toSub = (int)(po.getPrice()*Double.valueOf(CfgReader.getInstance().getProperty("creditSubRate")));
                userDataService.subCredit(new CreditChangePO(po.getUserID(),po.getOrderID(),DateOperation.dateToString(new Date()),CfgReader.getInstance().getProperty("late"),toSub));
            }
            //添加酒店房间数目
            hotelInfo.addRoom(po.getHotelID(),DateOperation.stringToDate(po.getCheckInDate()),DateOperation.stringToDate(po.getCheckOutDate()),po.getRoomType(),po.getRoomNumber());
            return ResultMessage.Correct;
        } else {
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
        hotelInfo.updateGrade(vo.getHotelID(),vo.getGrade());
    }

    /**
     * 获得对应酒店评价信息
     *
     * @param hotelID 酒店id
     * @return 酒店评价信息
     * @throws RemoteException
     */
    public ArrayList<CommentVO> getComments(String hotelID) throws RemoteException {
        return commentInfo.getComments(hotelID);
    }
}

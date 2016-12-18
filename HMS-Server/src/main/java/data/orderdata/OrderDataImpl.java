package data.orderdata;

import database.DataBaseHelper;
import dataservice.orderdataservice.OrderDataService;
import enumData.*;
import po.CanceledExceptionOrderPO;
import po.OrderPO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.AbstractList;
import java.util.ArrayList;

/**
 * Created by mac on 2016/11/23.
 */
public class OrderDataImpl extends UnicastRemoteObject implements OrderDataService {

    public OrderDataImpl() throws RemoteException {
    }

    /**
     * 根据订单ID获取订单信息
     * @param orderID
     * @return
     */
    @Override
    public OrderPO getOrderInfo(String orderID) {
        ArrayList<String> info = DataBaseHelper.outRow("OrderInfo","orderID" ,orderID);
        OrderState orderState = null;
        RoomType roomType = null;
        TradeArea tradeArea = null;
        Address address = null;
        try {
            orderState = Enum.valueOf(OrderState.class,info.get(6).trim());
            roomType = Enum.valueOf(RoomType.class,info.get(9).trim());
            tradeArea = Enum.valueOf(TradeArea.class,info.get(14).trim());
            address = Enum.valueOf(Address.class,info.get(15).trim());
        }catch (IllegalArgumentException ex){
            ex.printStackTrace();
        }
        return new OrderPO(info.get(0),info.get(1),info.get(2),info.get(3),Integer.parseInt(info.get(4)),Integer.parseInt(info.get(5)),
                orderState,info.get(7),info.get(8),roomType,Double.parseDouble(info.get(10)),Boolean.getBoolean(info.get(11)),
                info.get(12),info.get(13),tradeArea,address,info.get(16));
    }

    /**
     * 修改订单信息
     * @param po
     * @return
     */
    @Override
    public ResultMessage setOrderInfo(OrderPO po) {
        DataBaseHelper.in("update OrderInfo set hotelID = '" + po.getHotelID() + "' where orderID = '" + po.getOrderID() +"'");
        DataBaseHelper.in("update OrderInfo set userID = '" + po.getUserID() + "' where orderID = '" + po.getOrderID() +"'");
        DataBaseHelper.in("update OrderInfo set roomID = '" + po.getRoomID() + "' where orderID = '" + po.getOrderID() +"'");
        DataBaseHelper.in("update OrderInfo set roomNumber = '" + po.getRoomNumber() + "' where orderID = '" + po.getOrderID() +"'");
        DataBaseHelper.in("update OrderInfo set peopleNumber = '" + po.getPeopleNumber() + "' where orderID = '" + po.getOrderID() +"'");
        DataBaseHelper.in("update OrderInfo set orderState = '" + po.getOrderState() + "' where orderID = '" + po.getOrderID() +"'");
        DataBaseHelper.in("update OrderInfo set checkInDate = '" + po.getCheckInDate() + "' where orderID = '" + po.getOrderID() +"'");
        DataBaseHelper.in("update OrderInfo set checkOutDate = '" + po.getCheckOutDate() + "' where orderID = '" + po.getOrderID() +"'");
        DataBaseHelper.in("update OrderInfo set roomType = '" + po.getRoomType() + "' where orderID = '" + po.getOrderID() +"'");
        DataBaseHelper.in("update OrderInfo set price = '" + po.getPrice() + "' where orderID = '" + po.getOrderID() +"'");
        DataBaseHelper.in("update OrderInfo set haveChild = '" + po.isHaveChild() + "' where orderID = '" + po.getOrderID() +"'");
        DataBaseHelper.in("update OrderInfo set hotelName = '" + po.getHotelName() + "' where orderID = '" + po.getOrderID() +"'");
        DataBaseHelper.in("update OrderInfo set promotionName = '" + po.getPromotionName() + "' where orderID = '" + po.getOrderID() +"'");
        DataBaseHelper.in("update OrderInfo set tradeArea = '" + po.getTradeArea() + "' where orderID = '" + po.getOrderID() +"'");
        DataBaseHelper.in("update OrderInfo set address = '" + po.getAddress() + "' where orderID = '" + po.getOrderID() +"'");
        DataBaseHelper.in("update OrderInfo set detailAddress = '" + po.getDetailAddress() + "' where orderID = '" + po.getOrderID() +"'");
        return ResultMessage.Correct;
    }

    /**
     * 根据订单状态，去搜索相应的订单
     * @param orderState 订单状态
     * @return
     * @throws RemoteException
     */
    @Override
    public ArrayList<OrderPO> getOrderList(OrderState orderState) throws RemoteException {
        ArrayList<OrderPO> orderPOs = new ArrayList<OrderPO>();
        ArrayList<String> orderIDList = DataBaseHelper.out("select orderID from OrderInfo where orderState ='" + orderState + "'","orderID");
        ArrayList<String> hotelIDList = DataBaseHelper.out("select hotelID from OrderInfo where orderState ='" + orderState + "'","hotelID");
        ArrayList<String> userIDList = DataBaseHelper.out("select userID from OrderInfo where orderState ='" + orderState + "'","userID");
        ArrayList<String> roomIDList = DataBaseHelper.out("select roomID from OrderInfo where orderState ='" + orderState + "'","roomID");
        ArrayList<String> roomNumberList = DataBaseHelper.out("select roomNumber from OrderInfo where orderState ='" + orderState + "'","roomNumber");
        ArrayList<String> peopleNumberList = DataBaseHelper.out("select peopleNumber from OrderInfo where orderState ='" + orderState + "'","peopleNumber");
        ArrayList<String> checkInDateList = DataBaseHelper.out("select checkInDate from OrderInfo where orderState ='" + orderState + "'","checkInDate");
        ArrayList<String> checkOutDateList = DataBaseHelper.out("select checkOutDate from OrderInfo where orderState ='" + orderState + "'","checkOutDate");
        ArrayList<String> roomTypeList = DataBaseHelper.out("select roomType from OrderInfo where orderState ='" + orderState + "'","roomType");
        ArrayList<String> priceList = DataBaseHelper.out("select price from OrderInfo where orderState ='" + orderState + "'","price");
        ArrayList<String> haveChildList = DataBaseHelper.out("select haveChild from OrderInfo where orderState ='" + orderState + "'","haveChild");
        ArrayList<String> hotelNameList = DataBaseHelper.out("select hotelName from OrderInfo where orderState ='" + orderState + "'","hotelName");
        ArrayList<String> promotionNameList = DataBaseHelper.out("select promotionName from OrderInfo where orderState ='" + orderState + "'","promotionName");
        ArrayList<String> tradeAreaList = DataBaseHelper.out("select tradeArea from OrderInfo where orderState ='" + orderState + "'","tradeArea");
        ArrayList<String> addressList = DataBaseHelper.out("select address from OrderInfo where orderState ='" + orderState + "'","address");
        ArrayList<String> detailAddressList = DataBaseHelper.out("select detailAddress from OrderInfo where orderState ='" + orderState + "'","detailAddress");
        for(int i=0;i<orderIDList.size();i++){
            RoomType roomType = null;
            TradeArea tradeArea = null;
            Address address = null;
            try {
                roomType = Enum.valueOf(RoomType.class,roomTypeList.get(i).trim());
                tradeArea = Enum.valueOf(TradeArea.class,tradeAreaList.get(i).trim());
                address = Enum.valueOf(Address.class,addressList.get(i).trim());
            }catch (IllegalArgumentException ex){
                ex.printStackTrace();
            }
            orderPOs.add(new OrderPO(orderIDList.get(i),hotelIDList.get(i),userIDList.get(i),roomIDList.get(i),Integer.parseInt(roomNumberList.get(i)),Integer.parseInt(peopleNumberList.get(i)),
                    orderState,checkInDateList.get(i),checkOutDateList.get(i),roomType,Double.parseDouble(priceList.get(i)),Boolean.getBoolean(haveChildList.get(i)),
                    hotelNameList.get(i),promotionNameList.get(i),tradeArea,address,detailAddressList.get(i)));
        }
        return orderPOs;
    }

    /**
     * 根据ID类型和ID，去搜索相应的订单
     * @param ID 具体ID
     * @param type ID类型
     * @return
     */
    @Override
    public ArrayList<OrderPO> getOrderList(String ID,IDType type) {
        ArrayList<OrderPO> orderPOs = new ArrayList<OrderPO>();
        ArrayList<String> orderIDList = DataBaseHelper.out("select orderID from OrderInfo where " + type + " ='" + ID + "'","orderID");
        ArrayList<String> hotelIDList = DataBaseHelper.out("select hotelID from OrderInfo where " + type + " ='" + ID + "'","hotelID");
        ArrayList<String> userIDList = DataBaseHelper.out("select userID from OrderInfo where " + type + " ='" + ID + "'","userID");
        ArrayList<String> roomIDList = DataBaseHelper.out("select roomID from OrderInfo where " + type + " ='" + ID + "'","roomID");
        ArrayList<String> roomNumberList = DataBaseHelper.out("select roomNumber from OrderInfo where "+ type + " ='" + ID + "'","roomNumber");
        ArrayList<String> peopleNumberList = DataBaseHelper.out("select peopleNumber from OrderInfo where " + type + " ='" + ID + "'","peopleNumber");
        ArrayList<String> orderStateList = DataBaseHelper.out("select orderState from OrderInfo where "+ type + " ='" + ID + "'","orderState");
        ArrayList<String> checkInDateList = DataBaseHelper.out("select checkInDate from OrderInfo where "+ type + " ='" + ID + "'","checkInDate");
        ArrayList<String> checkOutDateList = DataBaseHelper.out("select checkOutDate from OrderInfo where " + type + " ='" + ID + "'","checkOutDate");
        ArrayList<String> roomTypeList = DataBaseHelper.out("select roomType from OrderInfo where "+ type + " ='" + ID + "'","roomType");
        ArrayList<String> priceList = DataBaseHelper.out("select price from OrderInfo where "+ type +" ='" + ID + "'","price");
        ArrayList<String> haveChildList = DataBaseHelper.out("select haveChild from OrderInfo where "+ type +" ='" + ID + "'","haveChild");
        ArrayList<String> hotelNameList = DataBaseHelper.out("select hotelName from OrderInfo where "+ type +" ='" + ID + "'","hotelName");
        ArrayList<String> promotionNameList = DataBaseHelper.out("select promotionName from OrderInfo where "+ type +" ='" + ID + "'","promotionName");
        ArrayList<String> tradeAreaList = DataBaseHelper.out("select tradeArea from OrderInfo where "+ type +" ='" + ID + "'","tradeArea");
        ArrayList<String> addressList = DataBaseHelper.out("select address from OrderInfo where "+ type +" ='" + ID + "'","address");
        ArrayList<String> detailAddressList = DataBaseHelper.out("select detailAddress from OrderInfo where "+ type +" ='" + ID + "'","detailAddress");
        for(int i=0;i<orderIDList.size();i++){
            OrderState orderState = null;
            RoomType roomType = null;
            TradeArea tradeArea = null;
            Address address = null;
            try {
                orderState = Enum.valueOf(OrderState.class,orderStateList.get(i).trim());
                roomType = Enum.valueOf(RoomType.class,roomTypeList.get(i).trim());
                tradeArea = Enum.valueOf(TradeArea.class,tradeAreaList.get(i).trim());
                address = Enum.valueOf(Address.class,addressList.get(i).trim());
            }catch (IllegalArgumentException ex){
                ex.printStackTrace();
            }
            orderPOs.add(new OrderPO(orderIDList.get(i),hotelIDList.get(i),userIDList.get(i),roomIDList.get(i),Integer.parseInt(roomNumberList.get(i)),Integer.parseInt(peopleNumberList.get(i)),
                    orderState,checkInDateList.get(i),checkOutDateList.get(i),roomType,Double.parseDouble(priceList.get(i)),Boolean.getBoolean(haveChildList.get(i)),
                    hotelNameList.get(i),promotionNameList.get(i),tradeArea,address,detailAddressList.get(i)));
        }
        return orderPOs;
    }

    /**
     * 向数据库添加订单信息
     * @param po
     * @return
     */
    @Override
    public ResultMessage addOrder(OrderPO po) {
        if(!hasExisted(po.getOrderID())) {
            DataBaseHelper.in("insert into OrderInfo (orderID,hotelID,userID,roomID,roomNumber,peopleNumber,orderState,checkInDate,checkOutDate,roomType,price,haveChild,hotelName,promotionName,tradeArea,address,detailAddress) " +
                    "values ('" + po.getOrderID() + "','" + po.getHotelID() + "','" + po.getUserID() + "','" + po.getRoomID() + "','" + po.getRoomNumber() + "','" + po.getPeopleNumber()+ "','" + po.getOrderState().toString() + "','" +
                    po.getCheckInDate() + "','" + po.getCheckOutDate() +  "','" + po.getRoomType().toString() + "','" + po.getPrice() + "','" + po.isHaveChild() + "','" + po.getHotelName() + "','" +
                    po.getPromotionName() + "','" + po.getTradeArea() + "','" + po.getAddress() + "','" + po.getDetailAddress() + "')");
            return ResultMessage.Correct;
        }else
            return ResultMessage.HasExist;
    }

    /**
     * 删除订单
     * @param orderID
     * @return
     */
    @Override
    public ResultMessage deleteOrder(String orderID) {
        DataBaseHelper.in("delete from OrderInfo where orderID = '" + orderID + "'");
        return ResultMessage.Correct;
    }

    /**
     * 添加订单异常信息
     * @param po 订单异常PO
     * @return
     * @throws RemoteException
     */
    @Override
    public ResultMessage addOrderExceptionInfo(CanceledExceptionOrderPO po) throws RemoteException {
        DataBaseHelper.in("insert into CanceledExceptionOrder (orderID,cancelDate,cancelTime,cancelReason) values ('" + po.getOrderID() +
                "','" + po.getCancelDate() + "','" + po.getCancelTime() + "','" + po.getCancelReason() +  "')");
        return ResultMessage.Correct;
    }

    /**
     * 获取订单异常信息（根据订单ID，获取单个）
     * @param orderID 订单ID
     * @return
     * @throws RemoteException
     */
    @Override
    public CanceledExceptionOrderPO getOrderExceptionInfo(String orderID) throws RemoteException {
        String cancelDate = DataBaseHelper.outSingle("OrderExceptionInfo","cancelDate","orderID",orderID);
        String cancelTime = DataBaseHelper.outSingle("OrderExceptionInfo","cancelTime","orderID",orderID);
        String cancelReason = DataBaseHelper.outSingle("OrderExceptionInfo","cancelReason","orderID",orderID);
        return new CanceledExceptionOrderPO(orderID,cancelDate,cancelTime,cancelReason);
    }

    /**
     * 获取订单异常信息（所有）
     * @return
     * @throws RemoteException
     */
    @Override
    public ArrayList<CanceledExceptionOrderPO> getOrderExceptionInfo() throws RemoteException {
        ArrayList<CanceledExceptionOrderPO> orderExceptionPOs = new ArrayList<CanceledExceptionOrderPO>();
        ArrayList<String> orderIDList = DataBaseHelper.out("select orderID from OrderException","orderID");
        ArrayList<String> cancelDateList = DataBaseHelper.out("select cancelDate from OrderException","cancelDate");
        ArrayList<String> cancelTimeList = DataBaseHelper.out("select cancelTime from OrderException","cancelTime");
        ArrayList<String> cancelReasonList = DataBaseHelper.out("select cancelReason from OrderException","cancelReason");
        for(int i=0;i<orderIDList.size();i++){
            orderExceptionPOs.add(new CanceledExceptionOrderPO(orderIDList.get(i),cancelDateList.get(i),cancelTimeList.get(i),cancelReasonList.get(i)));
        }
        return null;
    }

    /**
     * 判断订单是否已存在
     * @param orderID
     * @return
     */
    private boolean hasExisted (String orderID){
        ArrayList<String> orderIDList =  DataBaseHelper.out("select orderID from OrderInfo", "orderID");
        for(int i=0;i<orderIDList.size();i++)
            if(orderIDList.get(i).equals(orderID))
                return true;
        return  false;
    }
}

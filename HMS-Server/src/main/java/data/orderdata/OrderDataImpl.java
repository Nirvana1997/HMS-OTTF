package data.orderdata;

import database.DataBaseHelper;
import dataservice.orderdataservice.OrderDataService;
import enumData.OrderState;
import enumData.ResultMessage;
import enumData.RoomType;
import po.OrderPO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
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
        try {
            orderState = Enum.valueOf(OrderState.class,info.get(6).trim());
            roomType = Enum.valueOf(RoomType.class,info.get(10).trim());
        }catch (IllegalArgumentException ex){
            ex.printStackTrace();
        }
        return new OrderPO(info.get(0),info.get(1),info.get(2),info.get(3),Integer.parseInt(info.get(4)),Integer.parseInt(info.get(5)),
                orderState,info.get(7),info.get(8),info.get(9),roomType,Double.parseDouble(info.get(11)),Boolean.getBoolean(info.get(12)));
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
        DataBaseHelper.in("update OrderInfo set ddl = '" + po.getDdl() + "' where orderID = '" + po.getOrderID() +"'");
        DataBaseHelper.in("update OrderInfo set roomType = '" + po.getRoomType() + "' where orderID = '" + po.getOrderID() +"'");
        DataBaseHelper.in("update OrderInfo set price = '" + po.getPrice() + "' where orderID = '" + po.getOrderID() +"'");
        DataBaseHelper.in("update OrderInfo set haveChild = '" + po.isHaveChild() + "' where orderID = '" + po.getOrderID() +"'");
        return ResultMessage.Correct;
    }

    /**
     * 根据账户，返回相应订单列表
     * @param account
     * @return
     */
    @Override
    public ArrayList<OrderPO> getOrderList(String account) {
        ArrayList<OrderPO> orderPOs = new ArrayList<OrderPO>();
        ArrayList<String> orderIDList = DataBaseHelper.out("select orderID from OrderInfo where userID ='" + account + "'","orderID");
        ArrayList<String> hotelIDList = DataBaseHelper.out("select hotelID from OrderInfo where userID ='" + account + "'","hotelID");
        ArrayList<String> roomIDList = DataBaseHelper.out("select roomID from OrderInfo where userID ='" + account + "'","roomID");
        ArrayList<String> roomNumberList = DataBaseHelper.out("select roomNumber from OrderInfo where userID ='" + account + "'","roomNumber");
        ArrayList<String> peopleNumberList = DataBaseHelper.out("select peopleNumber from OrderInfo where userID ='" + account + "'","peopleNumber");
        ArrayList<String> orderStateList = DataBaseHelper.out("select orderState from OrderInfo where userID ='" + account + "'","orderState");
        ArrayList<String> checkInDateList = DataBaseHelper.out("select checkInDate from OrderInfo where userID ='" + account + "'","checkInDate");
        ArrayList<String> checkOutDateList = DataBaseHelper.out("select checkOutDate from OrderInfo where userID ='" + account + "'","checkOutDate");
        ArrayList<String> ddlList = DataBaseHelper.out("select ddl from OrderInfo where userID ='" + account + "'","ddl");
        ArrayList<String> roomTypeList = DataBaseHelper.out("select roomType from OrderInfo where userID ='" + account + "'","roomType");
        ArrayList<String> priceList = DataBaseHelper.out("select price from OrderInfo where userID ='" + account + "'","price");
        ArrayList<String> haveChildList = DataBaseHelper.out("select haveChild from OrderInfo where userID ='" + account + "'","haveChild");
        for(int i=0;i<orderIDList.size();i++){
            OrderState orderState = null;
            RoomType roomType = null;
            try {
                orderState = Enum.valueOf(OrderState.class,orderStateList.get(i).trim());
                roomType = Enum.valueOf(RoomType.class,roomTypeList.get(i).trim());
            }catch (IllegalArgumentException ex){
                ex.printStackTrace();
            }
            orderPOs.add(new OrderPO(orderIDList.get(i),hotelIDList.get(i),account,roomIDList.get(i),Integer.parseInt(roomNumberList.get(i)),Integer.parseInt(peopleNumberList.get(i)),
                    orderState,checkInDateList.get(i),checkOutDateList.get(i),ddlList.get(i),roomType,Double.parseDouble(priceList.get(i)),Boolean.getBoolean(haveChildList.get(i))));
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
            DataBaseHelper.in("insert into OrderInfo (orderID,hotelID,userID,roomID,roomNumber,peopleNumber,orderState,checkInDate,checkOutDate,ddl,roomType,price,haveChild) " +
                    "values ('" + po.getOrderID() + "','" + po.getHotelID() + "','" + po.getUserID() + "','" + po.getRoomID() + "','" + po.getRoomNumber() + "','" + po.getPeopleNumber()+
                    "','" + po.getOrderState().toString() + "','" + po.getCheckInDate() + "','" + po.getCheckOutDate() + "','" + po.getDdl() + "','" + po.getRoomType().toString() + "','"
                    + po.getPrice() + "','" + po.isHaveChild() + "')");
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

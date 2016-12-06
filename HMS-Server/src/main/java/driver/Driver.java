package driver;

import data.hotelsalerdata.HotelinfoDataImpl;
import data.hotelsalerdata.HotelroomDataImpl;
import data.orderdata.OrderDataImpl;
import data.websalerdata.WebsalerDataImpl;
import database.DataBaseHelper;
import dataservice.hotelsalerdataservice.HotelinfoDataService;
import dataservice.hotelsalerdataservice.HotelroomDataService;
import dataservice.orderdataservice.OrderDataService;
import dataservice.websalerdataservice.WebsalerDataService;
import enumData.Address;
import enumData.OrderState;
import enumData.RoomType;
import enumData.TradeArea;
import po.*;

import java.rmi.RemoteException;

public class Driver {

	public static void main(String[] args) throws RemoteException {
//        OrderDataService orderDataService = new OrderDataImpl();
//        System.out.println(orderDataService.addOrder(new OrderPO("01","01","a123","01", OrderState.executing,"2016_11_11",RoomType.SingleRoom)));
//        System.out.println(orderDataService.addOrder(new OrderPO("02","02","a123","02", OrderState.executing,"2016_12_01",RoomType.StandardRoom)));
//        System.out.println(orderDataService.getOrderList("a123").size());
//        System.out.println(orderDataService.deleteOrder("01"));
//        System.out.println(orderDataService.getOrderInfo("02").getDate());
//        System.out.println(orderDataService.setOrderInfo(new OrderPO("02","02","a123","02", OrderState.executing,"2017_01_01",RoomType.StandardRoom)));
//        WebsalerDataService websalerDataService = new WebsalerDataImpl();
//        System.out.println(websalerDataService.addWebsalerInfo(new WebsalerInfoPO("01","13596297777")));
//        System.out.println(websalerDataService.addWebsalerInfo(new WebsalerInfoPO("02","13236539018")));
//        System.out.println(websalerDataService.getWebsalerInfo("02").getContactNumber());
//        System.out.println(websalerDataService.setWebsalerInfo(new WebsalerInfoPO("01","14596297777")));
//        System.out.println(websalerDataService.deleteWebsalerInfo("02"));
    }
}
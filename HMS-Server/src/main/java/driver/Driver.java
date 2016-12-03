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
//		HotelinfoDataService hotelinfoDataService = new HotelinfoDataImpl();
//        System.out.println(hotelinfoDataService.addHotelinfo(new HotelinfoPO("01","梓航大酒店", TradeArea.Xianlin, Address.Xianlin,
//                "仙林大道","很好","服务周到","13596297777",5,9.9,200.0)));
//        System.out.println(hotelinfoDataService.getHotelinfo("01").getDetailAddress());
//        System.out.println(DataBaseHelper.outSingle("HotelInfo","service","hotelID","01");
//        HotelroomDataService hotelroomDataService = new HotelroomDataImpl();
//        System.out.println(hotelroomDataService.initializeRoomInfo(new RoomNumPO("01","2016_11_11",20,10, RoomType.DoubleRoom)));
//        System.out.println(hotelroomDataService.addHotelroom(new HotelroomPO("01",RoomType.DoubleRoom,200.0)));
//        System.out.println(hotelroomDataService.addHotelroom(new HotelroomPO("01",RoomType.SingleRoom,150.0)));
//        System.out.println(hotelroomDataService.addHotelroom(new HotelroomPO("01",RoomType.StandardRoom,300.0)));
//        System.out.println(hotelroomDataService.getRoomList("01").get(0).getPrice());
//        System.out.println(hotelroomDataService.getRoomList("01").get(1).getPrice());
//        System.out.println(hotelroomDataService.getRoomList("01").get(2).getPrice());
//        System.out.println(hotelroomDataService.getEmptyrooms("01","2016_11_11").get(0).getTotalNum());
//        System.out.println(DataBaseHelper.outRow("HotelInfo","hotelID","01").get(1));
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
package driver;

import data.hotelsalerdata.HotelinfoDataImpl;
import data.logdata.LogDataImpl;
import data.userdata.UserDataImpl;
import database.DataBaseHelper;
import dataservice.hotelsalerdataservice.HotelinfoDataService;
import dataservice.logdataservice.LogDataService;
import dataservice.userdataservice.UserDataService;
import enumData.AccountType;
import enumData.Address;
import enumData.TradeArea;
import po.AccountPO;
import po.HotelinfoPO;
import po.UserInfoPO;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class Driver {
	
	public static void main(String[] args) throws RemoteException {
//		HotelinfoDataService hotelinfoDataService = new HotelinfoDataImpl();
//        System.out.println(hotelinfoDataService.addHotelinfo(new HotelinfoPO("01","梓航大酒店",TradeArea.Xianlin,Address.Xianlin,
//                "仙林大道","很好","服务周到","13596297777",5,9.9)));
//        System.out.println(hotelinfoDataService.getHotelinfo("01").getDetailAddress());
//        System.out.println(DataBaseHelper.outSingle("HotelInfo","service","hotelID","01"));
    }
}
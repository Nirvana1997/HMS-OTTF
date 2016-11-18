package driver;

import po.AccountPO;
import po.HotelinfoPO;
import po.HotelroomPO;
import po.HotelsalerInfoPO;
import po.PromotionPO;
import po.UserInfoPO;
import po.WebsalerInfoPO;
import data.hotelinfodata.HotelinfoDataImpl_stub;
import data.hotelroomdata.HotelroomDataImpl_stub;
import data.hotelsalerdata.HotelsalerDataImpl_stub;
import data.logdata.LogDataImpl_stub;
import data.orderdata.OrderDataImpl_stub;
import data.promotiondata.PromotionDataImpl_stub;
import data.userdata.UserDataImpl_stub;
import data.websalerdata.WebsalerDataImpl_stub;
import dataservice.hotelinfodataservice.HotelinfoDataService;
import dataservice.hotelroomdataservice.HotelroomDataService;
import dataservice.hotelsalerdataservice.HotelsalerDataService;
import dataservice.logdataservice.LogDataService;
import dataservice.orderdataservice.OrderDataService;
import dataservice.promotiondataservice.PromotionDataService;
import dataservice.userdataservice.UserDataService;
import dataservice.websalerdataservice.WebsalerDataService;
import enumData.AccountType;
import enumData.PromotionType;
import enumData.ResultMessage;
import enumData.TradeArea;

import java.rmi.RemoteException;

public class Driver {
	
	
	public static void main(String[] args) throws RemoteException{
		Driver driver = new Driver();
		
		driver.getHotelinfo("01");
		driver.addHotelroom(new HotelroomPO("01"));
		driver.setHotelsalerInfo(new HotelsalerInfoPO("01", "新华酒店", "13122223333"));
		driver.addAccount(new AccountPO("01", "123321", AccountType.user));
		driver.deleteOrder("01");
		driver.addPromotion(new PromotionPO("01", PromotionType.fesPromotion, null, null, new TradeArea[]{TradeArea.Xianlin}, null, 0.8));
		driver.setUserInfo(new UserInfoPO("01", "王华", "123", "13122223333", 30, 2));
		driver.getWebsalerInfo("123");
	}
	
	HotelinfoDataService hotelinfo;
	HotelinfoPO hotelinfoPo;
	
	public void getHotelinfo(String hotelID) {
		hotelinfo = new HotelinfoDataImpl_stub();
		hotelinfoPo = hotelinfo.getHotelinfo(hotelID);
		System.out.println("----------酒店信息----------");
		System.out.println(hotelinfoPo.getAddress() + " " + hotelinfoPo.getIntroduction() + " " + hotelinfoPo.getService());
	}
	
	HotelroomDataService hotelroom;
	ResultMessage message;
	
	public void addHotelroom(HotelroomPO po){
		hotelroom = new HotelroomDataImpl_stub();
		HotelroomPO roomPo = new HotelroomPO("新华酒店");
		message = hotelroom.addHotelroom(roomPo);
		System.out.println("----------增加房间----------");
		System.out.println(message);
	}
	
	HotelsalerDataService hotelsaler;
	
	public void setHotelsalerInfo(HotelsalerInfoPO po){
		hotelsaler = new HotelsalerDataImpl_stub();
		message = hotelsaler.setHotelsalerInfo(po);
		System.out.println("----------修改酒店工作人员信息----------");
		System.out.println(message);
	}
	
	LogDataService log;
	
	public void addAccount(AccountPO po) throws RemoteException {
		log = new LogDataImpl_stub();
		log.addAccount(po);
		System.out.println("----------添加账号----------");
		System.out.println(message);
	}
	
	OrderDataService order;
	
	public void deleteOrder(String orderID){
		order = new OrderDataImpl_stub();
		message = order.deleteOrder(orderID);
		System.out.println("----------删除订单----------");
		System.out.println(message);
	}
	
	PromotionDataService promotion;
	
	public void addPromotion(PromotionPO po){
		promotion = new PromotionDataImpl_stub();
		message = promotion.addPromotion(po);
		System.out.println("----------删除订单----------");
		System.out.println(message);
	}
	
	UserDataService user;
	
	public void setUserInfo(UserInfoPO po) {
		user = new UserDataImpl_stub();
		message = user.setUserInfo(po);
		System.out.println("----------设置客户信息----------");
		System.out.println(message);
	}
	
	WebsalerDataService websaler;
	WebsalerInfoPO websalerInfoPO;
	
	public void getWebsalerInfo(String websalerID){
		websaler = new WebsalerDataImpl_stub();
		websalerInfoPO =websaler.getWebsalerInfo(websalerID);
		System.out.println("----------得到网站营销人员信息----------");
		System.out.println(websalerInfoPO.getContactNumber());
	}
}
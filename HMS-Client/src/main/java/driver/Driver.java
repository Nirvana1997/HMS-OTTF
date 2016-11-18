//package driver;
//
//import java.util.ArrayList;
//
//import vo.AccountVO;
//import vo.ConditionVO;
//import vo.HotelinfoVO;
//import vo.OrderVO;
//import vo.PromotionVO;
//import businesslogic.hotelinfobl.HotelinfoblImpl;
//import businesslogic.hotelroombl.Hotelroombl_stub;
//import businesslogic.hotelsalerbl.HotelsalerblImpl;
//import businesslogic.logbl.LogBlServiceImpl;
//import businesslogic.orderbl.OrderBl_stub;
//import businesslogic.promotionbl.PromotionBl_stub;
//import businesslogic.userbl.HotelOrderBl_stub;
//import businesslogic.webmanagerbl.HSmanagementBlImpl;
//import businesslogic.webmanagerbl.URmanagementBlImpl;
//import businesslogic.webmanagerbl.WSmanagementBlImpl;
//import businesslogic.websalerbl.WebsalerblImpl;
//import businesslogicservice.hotelinfoblservice.HotelinfoblService;
//import businesslogicservice.hotelroomblservice.HotelroomblService;
//import businesslogicservice.hotelsalerblservice.HotelsalerblService;
//import businesslogicservice.logblservice.LogBlService;
//import businesslogicservice.orderblservice.OrderBlService;
//import businesslogicservice.promotionblservice.PromotionBlService;
//import businesslogicservice.userblservice.HotelOrderBlService;
//import businesslogicservice.webmanagerlogicservice.HSmanagementBlService;
//import businesslogicservice.webmanagerlogicservice.URmanagementBlService;
//import businesslogicservice.webmanagerlogicservice.WSmanagementBlService;
//import businesslogicservice.websalerblservice.WebsalerblService;
//import enumData.AccountType;
//import enumData.TradeArea;
//
//public class Driver {
//	HotelinfoblService hotelinfo;
//	HotelinfoVO hotelinfovo;
//
//	public void getHotelinfo(String HotelID) {
//		hotelinfo = new HotelinfoblImpl();
//		hotelinfovo = hotelinfo.getHotelinfo(HotelID);
//		System.out.println("----------获得酒店信息----------");
//		System.out.println(hotelinfovo.getHotelID()+" "+hotelinfovo.getHotelname());
//	}
//
//	HotelroomblService hotelroom;
//
//	public  void setOrdered(OrderVO vo) {
//		hotelroom = new Hotelroombl_stub();
//		System.out.println("----------房间减少----------");
//		System.out.println(hotelroom.setOrdered(vo));
//	}
//
//	HotelsalerblService hotelsaler;
//
//	public  void modifyHotelInfo(HotelinfoVO vo){
//		hotelsaler = new HotelsalerblImpl();
//		System.out.println("----------修改酒店信息----------");
//		System.out.println(hotelsaler.modifyHotelInfo(vo));
//	}
//
//	LogBlService log;
//
//	public void isCorrect(AccountVO vo){
//		log = new LogBlServiceImpl();
//		System.out.println("----------修改酒店信息----------");
//		System.out.println(log.isCorrect(vo));
//	}
//
//	OrderBlService order;
//
//	public void getOrderInfo(String orderID) {
//		order = new OrderBl_stub();
//		System.out.println("----------获得订单信息----------");
//		OrderVO vo = order.getOrderInfo(orderID);
//		System.out.println(vo.getOrderID());
//	}
//
//	PromotionBlService promotion;
//
//	public void getPromotionList(ArrayList<String> promotionIds) {
//		promotion = new PromotionBl_stub();
//		System.out.println("----------获得营销策略列表----------");
//		ArrayList<PromotionVO> vos = promotion.getPromotionList(promotionIds);
//		System.out.println(vos.get(0).getPromotionID());
//	}
//
//	HotelOrderBlService hotelOrder;
//
//	public void searchHotel(ConditionVO vo){
//		hotelOrder = new HotelOrderBl_stub();
//		System.out.println("----------搜索酒店----------");
//		System.out.println(((HotelinfoVO) hotelOrder.searchHotel(vo).get(0)).getHotelname());
//	}
//
//	HSmanagementBlService hsmanagement;
//
//	public void getHotelsalerInfo(String hotelsalerID){
//		hsmanagement = new HSmanagementBlImpl();
//		System.out.println("----------获得酒店信息----------");
//		System.out.println(hsmanagement.getHotelsalerInfo("0001").getHotelname());
//	}
//
//	URmanagementBlService urmanagement;
//
//	public void getUserInfo(String userID){
//		urmanagement = new URmanagementBlImpl();
//		System.out.println("----------获得用户个人信息----------");
//		System.out.println(urmanagement.getUserInfo(userID).getName());
//	}
//
//	WSmanagementBlService wSmanagement;
//
//	public void getWebsaleInfo(String websalerID){
//		wSmanagement = new WSmanagementBlImpl();
//		System.out.println("----------获得网络营销人员信息----------");
//		System.out.println(wSmanagement.getWebsaleInfo("0001"));
//	}
//
//	WebsalerblService websaler;
//
//	public void makeFestivalPromotion(PromotionVO vo){
//		websaler = new WebsalerblImpl();
//		System.out.println("----------制定节日促销活动----------");
//		System.out.println(websaler.makeFestivalPromotion(vo));
//	}
//
//
//	public static void main(String[] args) {
//		Driver driver = new Driver();
//		ArrayList<String> promotionIds = new ArrayList<String>();
//		ConditionVO conditionVO = new ConditionVO("0001", null, null, null, null, 0, 0, false, null, false, 0, 0);
//		PromotionVO promotionVO = new PromotionVO("0002", null, null, null, null, null, 0);
//		promotionIds.add("0001");
//		promotionIds.add("0001");
//
//		driver.getHotelinfo("0001");
//		driver.setOrdered(new OrderVO("0001", null, null, null, null, null));
//		driver.modifyHotelInfo(new HotelinfoVO("0001", "仙林大酒店", TradeArea.Xianlin, null, null, null, null, "VergGood", "GreatService", 5, 5, null, null));
//		driver.isCorrect(new AccountVO("OTTF", "1234", AccountType.user));
//		driver.getOrderInfo("0001");
//		driver.getPromotionList(promotionIds);
//		driver.searchHotel(conditionVO);
//		driver.getHotelsalerInfo("0001");
//		driver.getUserInfo("0001");
//		driver.makeFestivalPromotion(promotionVO);
//	}
//}

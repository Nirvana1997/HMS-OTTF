//package driver;
//
//import java.util.ArrayList;
//
//import vo.AccountVO;
//import vo.LimitVO;
//import vo.HotelinfoVO;
//import vo.OrderVO;
//import vo.PromotionVO;
//import businesslogic.hotelinfobl.HotelinfoDataImpl;
//import businesslogic.hotelroombl.Hotelroombl_stub;
//import businesslogic.hotelsalerbl.HotelInfoOperation;
//import businesslogic.logbl.Login;
//import businesslogic.orderbl.OrderBl_stub;
//import businesslogic.promotionbl.PromotionBl_stub;
//import businesslogic.userbl.HotelOrderBl_stub;
//import businesslogic.webmanagerbl.HSmanagement;
//import businesslogic.webmanagerbl.URmanagement;
//import businesslogic.webmanagerbl.WSmanagement;
//import businesslogic.websalerbl.WebsalerblImpl;
//import businesslogicservice.hotelsalerblservice.HotelinfoblService;
//import businesslogicservice.hotelsalerblservice.HotelroomblService;
//import businesslogicservice.hotelsalerblservice.HotelsalerblService;
//import businesslogicservice.logblservice.LogBlService;
//import businesslogicservice.orderblservice.OrderBlService;
//import businesslogicservice.promotionblservice.PromotionBlService;
//import businesslogicservice.userblservice.HotelOrderBlService;
//import businesslogicservice.webmanagerblservice.HSmanagementBlService;
//import businesslogicservice.webmanagerblservice.URmanagementBlService;
//import businesslogicservice.webmanagerblservice.WSmanagementBlService;
//import businesslogicservice.websalerblservice.WebsalerblService;
//import enumData.AccountType;
//import enumData.TradeArea;
//
//public class Driver {
//	HotelinfoblService hotelinfo;
//	HotelinfoVO hotelinfovo;
//
//	public void getHotelinfo(String HotelID) {
//		hotelinfo = new HotelinfoDataImpl();
//		hotelinfovo = hotelinfo.getHotelinfo(HotelID);
//		System.out.println("----------获得酒店信息----------");
//		System.out.println(hotelinfovo.getHotelID()+" "+hotelinfovo.getHotelName());
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
//		hotelsaler = new HotelInfoOperation();
//		System.out.println("----------修改酒店信息----------");
//		System.out.println(hotelsaler.modifyHotelInfo(vo));
//	}
//
//	LogBlService log;
//
//	public void isCorrectAndLogin(AccountVO vo){
//		log = new Login();
//		System.out.println("----------修改酒店信息----------");
//		System.out.println(log.isCorrectAndLogin(vo));
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
//		System.out.println(vos.get(0).getPromotionName());
//	}
//
//	HotelOrderBlService hotelOrder;
//
//	public void searchHotelInArea(LimitVO vo){
//		hotelOrder = new HotelOrderBl_stub();
//		System.out.println("----------搜索酒店----------");
//		System.out.println(((HotelinfoVO) hotelOrder.searchHotelInArea(vo).get(0)).getHotelName());
//	}
//
//	HSmanagementBlService hsmanagement;
//
//	public void getHotelInfo(String hotelsalerID){
//		hsmanagement = new HSmanagement();
//		System.out.println("----------获得酒店信息----------");
//		System.out.println(hsmanagement.getHotelInfo("0001").getHotelName());
//	}
//
//	URmanagementBlService urmanagement;
//
//	public void getUserInfo(String userID){
//		urmanagement = new URmanagement();
//		System.out.println("----------获得用户个人信息----------");
//		System.out.println(urmanagement.getUserInfo(userID).getName());
//	}
//
//	WSmanagementBlService wSmanagement;
//
//	public void getWebsalerInfo(String websalerID){
//		wSmanagement = new WSmanagement();
//		System.out.println("----------获得网络营销人员信息----------");
//		System.out.println(wSmanagement.getWebsalerInfo("0001"));
//	}
//
//	WebsalerblService websaler;
//
//	public void makePeriodPromotion(PromotionVO vo){
//		websaler = new WebsalerblImpl();
//		System.out.println("----------制定节日促销活动----------");
//		System.out.println(websaler.makePeriodPromotion(vo));
//	}
//
//
//	public static void main(String[] args) {
//		Driver driver = new Driver();
//		ArrayList<String> promotionIds = new ArrayList<String>();
//		LimitVO conditionVO = new LimitVO("0001", null, null, null, null, 0, 0, false, null, false, 0, 0);
//		PromotionVO promotionVO = new PromotionVO("0002", null, null, null, null, null, 0);
//		promotionIds.add("0001");
//		promotionIds.add("0001");
//
//		driver.getHotelinfo("0001");
//		driver.setOrdered(new OrderVO("0001", null, null, null, null, null));
//		driver.modifyHotelInfo(new HotelinfoVO("0001", "仙林大酒店", TradeArea.Xianlin, null, null, null, null, "VergGood", "GreatService", 5, 5, null, null));
//		driver.isCorrectAndLogin(new AccountVO("OTTF", "1234", AccountType.user));
//		driver.getOrderInfo("0001");
//		driver.getPromotionList(promotionIds);
//		driver.searchHotelInArea(conditionVO);
//		driver.getHotelInfo("0001");
//		driver.getUserInfo("0001");
//		driver.makePeriodPromotion(promotionVO);
//	}
//}

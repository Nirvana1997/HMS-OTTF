import businesslogic.logbl.LogController;
import businesslogic.userbl.UserController;
import businesslogicservice.userblservice.HotelOrderBlService;
import enumData.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import vo.AccountVO;
import vo.HotelListItemVO;
import vo.LimitVO;
import vo.OrderVO;

import java.util.ArrayList;
import java.util.Date;

/** 
* HotelOrder Tester.
* 
* @author <Authors name>  qzh
* @since <pre>十一月 12, 2016</pre> 
* @version 1.0 
*/ 
public class HotelOrderTest {
    HotelOrderBlService hotelOrderBlService;

    LogController logController;

@Before
public void before() throws Exception {
    hotelOrderBlService = new UserController();
    logController = new LogController();
    logController.isCorrectAndLogin(new AccountVO("151250001","111111",null));
}

@After
public void after() throws Exception { 
}

/**
*
* Method: searchHotel(TradeArea tradeArea,Address address, ArrayList<LimitVO> limits)
*
*/
@Test
public void testSearchHotel() throws Exception {
    HotelOrderBlService hotelOrderBlService = new UserController();
    LimitVO limitVO = new LimitVO(LimitCriterion.GradeCriterion,4,5);
    ArrayList<LimitVO> limits = new ArrayList<LimitVO>();
    limits.add(limitVO);
    //结果是否在限制条件内
    boolean inArea = true;

    //评分区间测试
    ArrayList<HotelListItemVO> hotels = hotelOrderBlService.searchHotel(TradeArea.Huanghe,Address.Beijing, limits);
    for(HotelListItemVO hotel:hotels){
        if(!(hotel.getGrade()>=4&&hotel.getGrade()<=5))
            inArea = false;
    }
    Assert.assertEquals(true,inArea);

    //星级区间测试
    limits.clear();
    limits.add(new LimitVO(LimitCriterion.StarCriterion,4,5));
    hotels = hotelOrderBlService.searchHotel(TradeArea.Changjiang,Address.Beijing, limits);
    inArea = true;
    for(HotelListItemVO hotel:hotels){
        if(!(hotel.getStar()>=4&&hotel.getStar()<=5))
            inArea = false;
    }
    Assert.assertEquals(true,inArea);

    //关键字测试
    limits.clear();
    limits.add(new LimitVO(LimitCriterion.KeywordCriterion,"仙林"));
    hotels = hotelOrderBlService.searchHotel(TradeArea.Nanhai,Address.Nanjing, limits);
    Assert.assertEquals("仙林大酒店",hotels.get(0).getHotelname());
} 

/** 
* 
* Method: readHotel(Address address, ConditionVO vo) 
* 
*/ 
@Test
public void testReadHotel() throws Exception {
    Assert.assertEquals("仙林大酒店",hotelOrderBlService.readHotel("0001").getHotelname());
}

/** 
* 
* Method: orderHotel(OrderVO vo, String userID) 
* 
*/ 
@Test
public void testOrderHotel() throws Exception {
    OrderVO orderVO = null;
    Assert.assertEquals(true,hotelOrderBlService.orderHotel(orderVO));
} 

/** 
* 
* Method: readOrder(String userID) 
* 
*/ 
@Test
public void testReadOrder() throws Exception {
    Assert.assertEquals("0200001",hotelOrderBlService.readOrder(OrderState.executing).get(0).getHotelID());
    Assert.assertEquals(3,hotelOrderBlService.readOrder(OrderState.executing).size());
} 

/** 
* 
* Method: cancelOrder(String OrderID) 
* 
*/ 
@Test
public void testCancelOrder() throws Exception {
    Assert.assertEquals(ResultMessage.Correct,hotelOrderBlService.cancelOrder(null));
} 

/** 
* 
* Method: comment(CommentVO vo) 
* 
*/ 
@Test
public void testComment() throws Exception { 
//不需要测试
} 


} 

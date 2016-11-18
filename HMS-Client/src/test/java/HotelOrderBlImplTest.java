import businesslogic.userbl.HotelOrderBlImpl;
import businesslogicservice.hotelroomblservice.HotelroomblService;
import businesslogicservice.userblservice.HotelOrderBlService;
import enumData.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import vo.ConditionVO;
import vo.OrderVO;

import java.time.Instant;
import java.util.Date;

/** 
* HotelOrderBlImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>十一月 12, 2016</pre> 
* @version 1.0 
*/ 
public class HotelOrderBlImplTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: searchHotel(Address address, ConditionVO vo) 
* 
*/ 
@Test
public void testSearchHotel() throws Exception {
    HotelOrderBlService hotelOrderBlService = new HotelOrderBlImpl();
    ConditionVO conditionVO = new ConditionVO("001",Address.DieDie, TradeArea.Xianlin, SortWay.CommentAscending, RoomType.big
            ,200,300,false,new Date(2016,11,11),true,3,3);
    Assert.assertEquals("0001",hotelOrderBlService.searchHotel(Address.DieDie,conditionVO).get(0).getHotelID());
} 

/** 
* 
* Method: readHotel(Address address, ConditionVO vo) 
* 
*/ 
@Test
public void testReadHotel() throws Exception {
    HotelOrderBlService hotelOrderBlService = new HotelOrderBlImpl();
    ConditionVO conditionVO = new ConditionVO("001",Address.DieDie, TradeArea.Xianlin, SortWay.CommentAscending, RoomType.big
            ,200,300,false,new Date(2016,11,11),true,3,3);
    Assert.assertEquals("仙林大酒店",hotelOrderBlService.readHotel(Address.DieDie,conditionVO).get(0).getHotelname());
} 

/** 
* 
* Method: orderHotel(OrderVO vo, String userID) 
* 
*/ 
@Test
public void testOrderHotel() throws Exception {
    HotelOrderBlService hotelOrderBlService = new HotelOrderBlImpl();
    OrderVO orderVO = new OrderVO("1", OrderState.executing,"0001","01",new Date(2016,11,11),"01");
    Assert.assertEquals(true,hotelOrderBlService.orderHotel(orderVO,"01"));
} 

/** 
* 
* Method: readOrder(String userID) 
* 
*/ 
@Test
public void testReadOrder() throws Exception {
    HotelOrderBlService hotelOrderBlService = new HotelOrderBlImpl();
    Assert.assertEquals("123",hotelOrderBlService.readOrder("01").get(0).getHotelID());
} 

/** 
* 
* Method: cancelOrder(String OrderID) 
* 
*/ 
@Test
public void testCancelOrder() throws Exception {
    HotelOrderBlService hotelOrderBlService = new HotelOrderBlImpl();
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

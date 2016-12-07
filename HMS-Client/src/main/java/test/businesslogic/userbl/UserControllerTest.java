package test.businesslogic.userbl; 

import businesslogic.userbl.UserController;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import vo.UserInfoVO;

/** 
* UserController Tester. 
* 
* @author <Authors name> 
* @since <pre>十一月 6, 2016</pre>
* @version 1.0 
*/ 
public class UserControllerTest {
    UserController userController;

@Before
public void before() throws Exception {
    userController = new UserController();
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: modifyUserInfo(UserInfoVO vo) 
* 
*/ 
@Test
public void testModifyUserInfo() throws Exception {
}

/** 
* 
* Method: showUserInfo() 
* 
*/ 
@Test
public void testShowUserInfo() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: searchHotel(TradeArea tradeArea, Address address, SortWay sortWay) 
* 
*/ 
@Test
public void testSearchHotelForTradeAreaAddressSortWay() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: searchHotel(TradeArea tradeArea, Address address, SortWay sortWay, ArrayList<LimitVO> limits) 
* 
*/ 
@Test
public void testSearchHotelForTradeAreaAddressSortWayLimits() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: readHotel(String hotelID) 
* 
*/ 
@Test
public void testReadHotel() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: haveEnoughRoom(String hotelID, Date startDate, Date endDate, RoomType roomType, int num) 
* 
*/ 
@Test
public void testHaveEnoughRoom() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: makeOrder(RoomType roomType, String hotelID, Date startDate, Date endDate, int num) 
* 
*/ 
@Test
public void testMakeOrder() throws Exception {

}

/** 
* 
* Method: orderHotel(OrderVO vo) 
* 
*/ 
@Test
public void testOrderHotel() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: readOrder(String userID) 
* 
*/ 
@Test
public void testReadOrder() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: cancelOrder(String OrderID) 
* 
*/ 
@Test
public void testCancelOrder() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: comment(CommentVO vo) 
* 
*/ 
@Test
public void testComment() throws Exception { 
//TODO: Test goes here... 
} 


} 

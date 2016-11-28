import businesslogic.hotelsalerbl.HotelroomblImpl;
import businesslogicservice.hotelsalerblservice.HotelroomblService;
import enumData.OrderState;
import enumData.ResultMessage;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import vo.OrderVO;

import java.util.Date;

/** 
* HotelroomblImpl Tester.
* 
* @author <Authors xzh>
* @since <pre>十一月 9, 2016</pre> 
* @version 1.0 
*/ 
public class HotelroomblImplTest {

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: setOrdered(OrderVO vo) 
* 
*/ 
@Test
public void testSetOrdered() throws Exception {
    HotelroomblService hotelroomblService  = new HotelroomblImpl();
    OrderVO orderVO = new OrderVO("0001", OrderState.canceled,"01","01", new Date(2016,11,11),"11");
    Assert.assertEquals(ResultMessage.Correct,hotelroomblService.setOrdered(orderVO));
}

/** 
* 
* Method: setEmpty(OrderVO vo) 
* 
*/ 
@Test
public void testSetEmpty() throws Exception {
    HotelroomblService hotelroomblService  = new HotelroomblImpl();
    OrderVO orderVO = new OrderVO("0001", OrderState.canceled,"01","01", new Date(2016,11,11),"11");
    Assert.assertEquals(ResultMessage.Correct,hotelroomblService.setOrdered(orderVO));
}


}

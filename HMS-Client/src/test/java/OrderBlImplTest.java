import businesslogic.orderbl.OrderBlImpl;
import businesslogicservice.orderblservice.OrderBlService;
import enumData.OrderState;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* OrderBlImpl Tester. 
* 
* @author <Authors name> hyx
* @since <pre>11, 12, 2016</pre>
* @version 1.0 
*/ 
public class OrderBlImplTest {

    OrderBlService orderBlService;

@Before
public void before() throws Exception {
    orderBlService = new OrderBlImpl();
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: getOrderInfo(String orderID) 
* 
*/ 
@Test
public void testGetOrderInfo() throws Exception {
    Assert.assertEquals(OrderState.executing, orderBlService.getOrderInfo("0001").getOrderState());
    Assert.assertEquals(OrderState.executed, orderBlService.getOrderInfo("0002").getOrderState());
    Assert.assertEquals(OrderState.canceled, orderBlService.getOrderInfo("0003").getOrderState());
} 

/** 
* 
* Method: getOrderList(String account) 
* 
*/ 
@Test
public void testGetOrderList() throws Exception {
    Assert.assertEquals(OrderState.executing, orderBlService.getOrderList("0001").get(0).getOrderState());
    Assert.assertEquals(OrderState.executed, orderBlService.getOrderList("0001").get(1).getOrderState());
    Assert.assertEquals(OrderState.canceled, orderBlService.getOrderList("0001").get(2).getOrderState());
}


} 

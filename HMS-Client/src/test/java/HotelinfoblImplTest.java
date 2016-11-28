import businesslogic.hotelsalerbl.HotelinfoblImpl;
import businesslogicservice.hotelsalerblservice.HotelinfoblService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* HotelinfoblImpl Tester. 
* 
* @author <Authors name> qzh
* @since <pre>十一月 9, 2016</pre>
* @version 1.0 
*/ 
public class HotelinfoblImplTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: getHotelinfo(String hotelID) 
* 
*/ 
@Test
public void testGetHotelinfo() throws Exception {
    HotelinfoblService hotelinfoblService = new HotelinfoblImpl();
    Assert.assertEquals("仙林大酒店",hotelinfoblService.getHotelinfo("0001").getHotelname());
    Assert.assertEquals("喋喋大酒店",hotelinfoblService.getHotelinfo("0002").getHotelname());
    Assert.assertEquals("萱萱大酒店",hotelinfoblService.getHotelinfo("0003").getHotelname());

}


}
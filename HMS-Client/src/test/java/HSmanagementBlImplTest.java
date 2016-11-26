import businesslogic.webmanagerbl.HSmanagementBlImpl;
import businesslogicservice.webmanagerlogicservice.HSmanagementBlService;
import enumData.ResultMessage;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import po.HotelsalerInfoPO;
import vo.HotelsalerInfoVO;

/** 
* HSmanagementBlImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>十一月 13, 2016</pre>
* @version 1.0 
*/ 
public class HSmanagementBlImplTest {
    HSmanagementBlService hSmanagementBlService;

@Before
public void before() throws Exception {
    hSmanagementBlService = new HSmanagementBlImpl();
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: getHotelsalerInfo(String hotelsalerID) 
* 
*/ 
@Test
public void testGetHotelsalerInfo() throws Exception {
    Assert.assertEquals("梓航大酒店",hSmanagementBlService.getHotelsalerInfo("151250175").getHotelname());
}

/** 
* 
* Method: setHotelsalerInfo(HotelsalerInfoVO vo) 
* 
*/ 
@Test
public void testSetHotelsalerInfo() throws Exception {
    HotelsalerInfoVO vo = new HotelsalerInfoVO("151250175","梓航小酒店");
    Assert.assertEquals(ResultMessage.Correct, hSmanagementBlService.setHotelsalerInfo(vo));
}

/** 
* 
* Method: addHotelsalerInfo(HotelsalerInfoVO vo, String password) 
* 
*/ 
@Test
public void testAddHotelsalerInfo() throws Exception {
    HotelsalerInfoVO vo = new HotelsalerInfoVO("151250063","萱萱大酒店");
    Assert.assertEquals(true,hSmanagementBlService.addHotelsalerInfo(vo,"1234"));
}

/** 
* 
* Method: deleteHotelsalerVO(String hotelsalerID) 
* 
*/ 
@Test
public void testDeleteHotelsalerVO() throws Exception {
    Assert.assertEquals(ResultMessage.Correct,hSmanagementBlService.deleteHotelsalerVO("151250175"));
}


} 

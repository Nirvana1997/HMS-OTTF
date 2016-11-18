import businesslogic.webmanagerbl.WSmanagementBlImpl;
import businesslogic.websalerbl.WebsalerblImpl;
import businesslogicservice.webmanagerlogicservice.WSmanagementBlService;
import businesslogicservice.websalerblservice.WebsalerblService;
import enumData.ResultMessage;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import vo.WebsalerInfoVO;

/** 
* WSmanagementBlImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>十一月 13, 2016</pre>
* @version 1.0 
*/ 
public class WSmanagementBlImplTest {
    WSmanagementBlService wSmanagementBlService = new WSmanagementBlImpl();

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: getWebsaleInfo(String websalerID) 
* 
*/ 
@Test
public void testGetWebsaleInfo() throws Exception {
    Assert.assertEquals("44444",wSmanagementBlService.getWebsaleInfo("151250045").getContactNumber());
} 

/** 
* 
* Method: setWebsalerInfo(WebsalerInfoVO vo) 
* 
*/ 
@Test
public void testSetWebsalerInfo() throws Exception {
    WebsalerInfoVO vo1 = new WebsalerInfoVO("151250045","44444");
    WebsalerInfoVO vo2 = new WebsalerInfoVO("151250000","44444");
    Assert.assertEquals(ResultMessage.Correct,wSmanagementBlService.setWebsalerInfo(vo1));
    Assert.assertEquals(ResultMessage.NotExist,wSmanagementBlService.setWebsalerInfo(vo2));
}

/** 
* 
* Method: addWebsalerInfo(WebsalerInfoVO vo, String password) 
* 
*/ 
@Test
public void testAddWebsalerInfo() throws Exception {
    WebsalerInfoVO vo1 = new WebsalerInfoVO("151250046","44444");
    WebsalerInfoVO vo2 = new WebsalerInfoVO("151250045","44444");
    Assert.assertEquals(ResultMessage.Correct,wSmanagementBlService.addWebsalerInfo(vo1,"1234"));
    Assert.assertEquals(ResultMessage.HasExist,wSmanagementBlService.addWebsalerInfo(vo2,"1234"));
}

/** 
* 
* Method: deleteWebsalerInfo(String websalerID) 
* 
*/ 
@Test
public void testDeleteWebsalerInfo() throws Exception {
    Assert.assertEquals(ResultMessage.Correct,wSmanagementBlService.deleteWebsalerInfo("151250045"));
    Assert.assertEquals(ResultMessage.NotExist,wSmanagementBlService.deleteWebsalerInfo("151250046"));
}


} 

import businesslogic.webmanagerbl.URmanagement;
import businesslogic.webmanagerbl.WebmanagerController;
import businesslogicservice.webmanagerlogicservice.URmanagementBlService;
import enumData.ResultMessage;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import vo.UserInfoVO;

/** 
* URmanagement Tester.
* 
* @author <Authors name> 
* @since <pre>十一月 13, 2016</pre>
* @version 1.0 
*/ 
public class UserDataImplManagementBlImplTest {
    URmanagementBlService uRmanagementBlService = new WebmanagerController();

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: getUserInfo(String userID) 
* 
*/ 
@Test
public void testGetUserInfo() throws Exception { 
    Assert.assertEquals("钱志豪",uRmanagementBlService.getUserInfo("151250119").getName());
} 

/** 
* 
* Method: setUserInfo(UserInfoVO vo) 
* 
*/ 
@Test
public void testSetUserInfo() throws Exception {
    UserInfoVO vo = new UserInfoVO("151250119","钱志豪","320581199703260417","13913632715",5,5);
    Assert.assertEquals(ResultMessage.Correct,uRmanagementBlService.setUserInfo(vo));
} 


} 

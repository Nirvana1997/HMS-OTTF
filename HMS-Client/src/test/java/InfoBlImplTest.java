import businesslogic.userbl.InfoBlImpl;
import businesslogicservice.userblservice.InfoBlService;
import enumData.ResultMessage;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import vo.UserInfoVO;

/** 
* InfoBlImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>十一月 13, 2016</pre> 
* @version 1.0 
*/ 
public class InfoBlImplTest { 

@Before
public void before() throws Exception { 
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
    InfoBlService infoBlService = new InfoBlImpl();
    UserInfoVO userInfoVO = new UserInfoVO("01","Snow","客人","1323232323",200,3);
    Assert.assertEquals(ResultMessage.Correct,infoBlService.modifyUserInfo(userInfoVO));
} 


} 

import businesslogic.logbl.LogController;
import businesslogicservice.logblservice.LogBlService;
import enumData.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import vo.*;

import java.util.ArrayList;

/** 
* Login Tester.
* 
* @author <Authors name> qzh
* @since <pre>十一月 9, 2016</pre>
* @version 1.0 
*/ 
public class LogControllerTest {
    LogBlService logBlService;

@Before
public void before() throws Exception {
    logBlService = new LogController();
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: isCorrectAndLogin(AccountVO vo)
* 
*/ 
@Test
public void testIsCorrect() throws Exception {
    AccountVO vo1 = new AccountVO("151250119","150809", AccountType.hotelsaler);
    AccountVO vo2 = new AccountVO("151250175","150809", AccountType.user);
    Assert.assertEquals(ResultMessage.Correct,logBlService.isCorrectAndLogin(vo1));
    Assert.assertEquals(ResultMessage.InCorrect,logBlService.isCorrectAndLogin(vo2));
} 

/** 
* 
* Method: accoutType(String account) 
* 
*/ 
@Test
public void testAccoutType() throws Exception {
    Assert.assertEquals(AccountType.user,logBlService.accoutType("151250119"));
    Assert.assertEquals(AccountType.hotelsaler,logBlService.accoutType("151250175"));
}

/** 
* 
* Method: register(AccountVO vo)
* 
*/ 
@Test
public void testRegister() throws Exception {
    ArrayList<RoomType> roomTypes = new ArrayList<RoomType>();
    roomTypes.add(RoomType.SingleRoom);
    ArrayList<Integer> prices = new ArrayList<Integer>();
    prices.add(666);
    ArrayList<String> userIDs = new ArrayList<String>();
    userIDs.add("0001");
    ArrayList<String> comments = new ArrayList<String>();
    comments.add("good");
    HotelinfoVO hvo = new HotelinfoVO("0001", "仙林大酒店", TradeArea.Xianlin, Address.NJU, "仙林","1111 ", "VergGood", "GreatService", 5, 5);
    HotelsalerAccountVO vo1 = new HotelsalerAccountVO("151250119","150809", AccountType.hotelsaler,hvo);
    UserInfoVO uvo = new UserInfoVO("01", "钱志豪", "320581", "139136", 0, "1997_03_26","",UserType.Person,0);
    AccountVO vo2 = new UserAccountVO("151250189","150809", AccountType.user,uvo);
//    Assert.assertEquals(ResultMessage.HasExist,logBlService.register(vo1));
    Assert.assertEquals(ResultMessage.Correct,logBlService.register(vo2));
}


} 

import businesslogic.logbl.LogBlServiceImpl;
import businesslogicservice.logblservice.LogBlService;
import enumData.AccountType;
import enumData.ResultMessage;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import vo.AccountVO;

/** 
* LogBlServiceImpl Tester. 
* 
* @author <Authors name> qzh
* @since <pre>十一月 9, 2016</pre>
* @version 1.0 
*/ 
public class LogBlServiceImplTest {
    LogBlService logBlService;

@Before
public void before() throws Exception {
    logBlService = new LogBlServiceImpl();
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: isCorrect(AccountVO vo) 
* 
*/ 
@Test
public void testIsCorrect() throws Exception {
    AccountVO vo1 = new AccountVO("151250119","150809", AccountType.hotelsaler);
    AccountVO vo2 = new AccountVO("151250175","150809", AccountType.user);
    Assert.assertEquals(ResultMessage.Correct,logBlService.isCorrect(vo1));
    Assert.assertEquals(ResultMessage.InCorrect,logBlService.isCorrect(vo2));
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
* Method: addAccount(AccountVO vo) 
* 
*/ 
@Test
public void testAddAccount() throws Exception {
    AccountVO vo1 = new AccountVO("151250119","150809", AccountType.hotelsaler);
    AccountVO vo2 = new AccountVO("151250189","150809", AccountType.user);
    Assert.assertEquals(ResultMessage.HasExist,logBlService.addAccount(vo1));
    Assert.assertEquals(ResultMessage.Correct,logBlService.addAccount(vo2));
} 


} 

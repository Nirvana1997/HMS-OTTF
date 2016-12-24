import businesslogic.logbl.LogController;
import businesslogicservice.logblservice.LogBlService;
import enumData.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import rmi.RemoteHelper;
import vo.*;

import java.util.ArrayList;

/**
 * Login Tester.
 *
 * @author <Authors name> qzh
 * @version 1.0
 * @since <pre>十一月 9, 2016</pre>
 */
public class LogTest {
    LogBlService logBlService;

    @Before
    public void before() throws Exception {
        //TODO
        RemoteHelper.getInstance().linkToServer("114.212.43.173");
        logBlService = new LogController();
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: isCorrectAndLogin(AccountVO vo)
     */
    @Test
    public void testIsCorrect() throws Exception {
        AccountVO vo1 = new AccountVO("hs151250119", "123456", AccountType.hotelsaler);
        AccountVO vo2 = new AccountVO("ur151250119", "123456", AccountType.user);
        AccountVO vo3 = new AccountVO("ur151250119", "111111", AccountType.user);
        Assert.assertEquals(ResultMessage.Correct, logBlService.isCorrectAndLogin(vo1));
        Assert.assertEquals(ResultMessage.Correct, logBlService.isCorrectAndLogin(vo2));
        Assert.assertEquals(ResultMessage.InCorrect, logBlService.isCorrectAndLogin(vo3));
    }

    /**
     * Method: accoutType(String account)
     */
    @Test
    public void testAccoutType() throws Exception {
        Assert.assertEquals(AccountType.user, logBlService.accoutType("151250001"));
        Assert.assertEquals(AccountType.hotelsaler, logBlService.accoutType("151250002"));
        Assert.assertEquals(null, logBlService.accoutType("151250111"));
    }

    /**
     * Method: register(AccountVO vo)
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
        HotelinfoVO hvo = new HotelinfoVO("0001", "仙林大酒店", TradeArea.Changjiang, Address.Shanghai, "仙林", "1111 ", "VergGood", "GreatService", 5, 5, 93.6);
        HotelsalerAccountVO vo1 = new HotelsalerAccountVO("151250119", "150809", AccountType.hotelsaler, hvo);
        UserInfoVO uvo = new UserInfoVO("01", "钱志豪", "320581", "139136", 0, "1997_03_26", "", UserType.Person, 0);
        AccountVO vo2 = new UserAccountVO("151250189", "150809", AccountType.user, uvo);
//    Assert.assertEquals(ResultMessage.HasExist,logBlService.register(vo1));
        Assert.assertEquals(ResultMessage.Correct, logBlService.register(vo2));
    }


} 

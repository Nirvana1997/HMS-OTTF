import businesslogic.logbl.LogController;
import businesslogicservice.logblservice.LogBlService;
import dataservice.logdataservice.LogDataService;
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
        RemoteHelper.getInstance().linkToServer(IP.ip);
        logBlService = new LogController();
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: isCorrectAndLogin(AccountVO vo)
     */
    @Test
    public void testIsCorrectAndLogin() throws Exception {
        AccountVO vo1 = new AccountVO("151250001", "123456", null);
        AccountVO vo2 = new AccountVO("151250001", "111111", null);
        Assert.assertEquals(ResultMessage.InCorrect, logBlService.isCorrectAndLogin(vo1));
        Assert.assertEquals(ResultMessage.Correct, logBlService.isCorrectAndLogin(vo2));
    }

    /**
     * Method: isCorrectAndLogin(AccountVO vo)
     */
    @Test
    public void testIsValid() throws Exception {
        PasswordComfirmVO vo1 = new PasswordComfirmVO("151250001","111111","1111111");
        PasswordComfirmVO vo2 = new PasswordComfirmVO("151250011","111111","1111111");
        PasswordComfirmVO vo3 = new PasswordComfirmVO("151250012","111111","123456");
        Assert.assertEquals(ResultMessage.HasExist, logBlService.isValid(vo1));
        Assert.assertEquals(ResultMessage.Correct, logBlService.isValid(vo2));
        Assert.assertEquals(ResultMessage.InCorrect, logBlService.isValid(vo3));
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
        AccountVO vo = new AccountVO("151250001", "150809", AccountType.hotelsaler);
        Assert.assertEquals(ResultMessage.Correct, logBlService.register(vo));
    }


} 

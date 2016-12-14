import businesslogic.logbl.LogController;
import businesslogic.userbl.UserInfo;
import businesslogic.webmanagerbl.WebmanagerController;
import enumData.ResultMessage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import vo.AccountVO;
import vo.UserInfoVO;
import vo.WebsalerInfoVO;

import java.util.ArrayList;

/**
 * WebmanagerController Tester.
 *
 * @author <Authors name> qzh
 * @version 1.0
 * @since <pre>十二月 13, 2016</pre>
 */
public class WebmanagerControllerTest {
    WebmanagerController webmanagerController;

    LogController logController;

    @Before
    public void before() throws Exception {
        webmanagerController = new WebmanagerController();
        logController = new LogController();
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: getWebsalerInfo(String websalerID)
     */
    @Test
    public void testGetWebsaleInfo() throws Exception {
        Assert.assertEquals("13596297777",webmanagerController.getWebsalerInfo("0300001").getContactNumber());
    }

    /**
     * Method: setWebsalerInfo(WebsalerInfoVO vo)
     */
    @Test
    public void testSetWebsalerInfo() throws Exception {
        WebsalerInfoVO vo = webmanagerController.getWebsalerInfo("0300001");
        vo.setContactNumber("12345678910");
        webmanagerController.setWebsalerInfo(vo);
        Assert.assertEquals("12345678910",webmanagerController.getWebsalerInfo("0300001").getContactNumber());
    }

    /**
     * Method: addWebsalerInfoAndAccount(WebsalerInfoVO vo, String password)
     */
    @Test
    public void testAddWebsalerInfo() throws Exception {
        webmanagerController.addWebsalerInfoAndAccount(new WebsalerInfoVO(null,"12345678910"),"testWebSaler","websaler");
        Assert.assertEquals(ResultMessage.Correct,logController.isCorrectAndLogin(new AccountVO("testWebSaler","websaler",null)));
        Assert.assertEquals("12345678910",webmanagerController.getWebsalerInfo("0300005").getContactNumber());
    }

    /**
     * Method: deleteWebsalerInfoAndAccount(String websalerID)
     */
    @Test
    public void testDeleteWebsalerInfo() throws Exception {
        webmanagerController.deleteWebsalerInfoAndAccount("0300001");
        Assert.assertEquals(null,logController.accoutType("151250003"));
    }

    /**
     * Method: getUserInfo(String userID)
     */
    @Test
    public void testGetUserInfo() throws Exception {
        Assert.assertEquals("xzh",webmanagerController.getUserInfo("0100001").getName());
    }

    /**
     * Method: setUserInfo(UserInfoVO vo)
     */
    @Test
    public void testSetUserInfo() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: getUserList()
     */
    @Test
    public void testGetUserList() throws Exception {
        ArrayList<UserInfoVO> userInfos = webmanagerController.getUserList();
        Assert.assertEquals(4,userInfos.size());
    }

    /**
     * Method: getHotellist()
     */
    @Test
    public void testGetHotellist() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: getHotelinfo(String hotelsalerID)
     */
    @Test
    public void testGetHotelinfo() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: setHotelinfo(HotelinfoVO vo)
     */
    @Test
    public void testSetHotelinfo() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: addHotelinfo(HotelinfoVO vo)
     */
    @Test
    public void testAddHotelinfo() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: deleteHotelinfo(String hotelsalerID)
     */
    @Test
    public void testDeleteHotelinfo() throws Exception {
//TODO: Test goes here... 
    }


} 

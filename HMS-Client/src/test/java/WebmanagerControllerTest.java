import businesslogic.logbl.LogController;
import businesslogic.webmanagerbl.WebmanagerController;
import enumData.AccountType;
import enumData.Address;
import enumData.ResultMessage;
import enumData.TradeArea;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rmi.RemoteHelper;
import vo.AccountVO;
import vo.HotelinfoVO;
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
        RemoteHelper.getInstance().linkToServer(IP.ip);
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
        Assert.assertEquals(4,webmanagerController.getWebsalerInfoList().size());
    }

    /**
     * Method: deleteWebsalerInfoAndAccount(String websalerID)
     */
    @Test
    public void testDeleteWebsalerInfo() throws Exception {
        Assert.assertEquals(AccountType.websaler,logController.accoutType("151250003"));
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
        UserInfoVO vo = webmanagerController.getUserInfo("0100001");
        vo.setIdentity("6666");
        webmanagerController.setUserInfo(vo);
        Assert.assertEquals("6666",webmanagerController.getUserInfo("0100001").getIdentity());
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
        ArrayList<HotelinfoVO> hotelinfos = webmanagerController.getHotellist();
        Assert.assertEquals(4,hotelinfos.size());
    }

    /**
     * Method: getHotelinfo(String hotelsalerID)
     */
    @Test
    public void testGetHotelinfo() throws Exception {
        Assert.assertEquals("XianlinHotel",webmanagerController.getHotelinfo("0200001").getHotelname());
    }

    /**
     * Method: setHotelinfo(HotelinfoVO vo)
     */
    @Test
    public void testSetHotelinfo() throws Exception {
        HotelinfoVO vo = webmanagerController.getHotelinfo("0200001");
        vo.setHotelname("XianlinlinHotel");
        webmanagerController.setHotelinfo(vo);
        Assert.assertEquals("XianlinlinHotel",webmanagerController.getHotelinfo("0200001").getHotelname());
    }

    /**
     * Method: addHotelinfo(HotelinfoVO vo)
     */
    @Test
    public void testAddHotelinfoAndAccount() throws Exception {
        webmanagerController.addHotelinfoAndAccount(new HotelinfoVO(null, "HahaHotel",TradeArea.Nanhai, Address.Guangdong,"Near the NJU","Excellent","VeryGood","1288888",5,9.9,300),"Haha","233333");
        Assert.assertEquals("HahaHotel",webmanagerController.getHotelinfo("0200005").getHotelname());
    }


    /**
     * Method: getAccount(String id)
     */
    @Test
    public void testGetAccount()throws Exception{
        Assert.assertEquals("151250001",webmanagerController.getAccount("0100001"));
    }

} 

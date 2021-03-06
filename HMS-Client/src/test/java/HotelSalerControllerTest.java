import businesslogic.hotelsalerbl.HotelSalerController;
import businesslogic.logbl.LogController;
import enumData.OrderState;
import enumData.PromotionType;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import rmi.RemoteHelper;
import utility.DateOperation;
import vo.AccountVO;
import vo.HotelinfoVO;
import vo.OrderVO;
import vo.PromotionVO;

import java.util.ArrayList;

/**
 * HotelSalerController Tester.
 *
 * @author <Authors name> qzh
 * @version 1.0
 * @since <pre>十二月 12, 2016</pre>
 */
public class HotelSalerControllerTest {
    HotelSalerController hotelSalerController;

    LogController logController;

    @Before
    public void before() throws Exception {
        RemoteHelper.getInstance().linkToServer(IP.ip);
        hotelSalerController = new HotelSalerController();
        logController = new LogController();
        //登录
        logController.isCorrectAndLogin(new AccountVO("151250002","111111",null));
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: modifyHotelInfo(HotelinfoVO vo)
     */
    @Test
    public void testModifyHotelInfo() throws Exception {
        HotelinfoVO vo = hotelSalerController.getHotelinfo();
        vo.setHotelname("haha");
        hotelSalerController.modifyHotelInfo(vo);
        Assert.assertEquals("haha",hotelSalerController.getHotelinfo().getHotelname());
    }

    /**
     * Method: getHotelInfo()
     */
    @Test
    public void testGetHotelInfo() throws Exception {
        Assert.assertEquals("XianlinHotel",hotelSalerController.getHotelinfo().getHotelname());
    }

    /**
     * Method: readOrderByState(String hotelID)
     */
    @Test
    public void testReadOrder() throws Exception {
        ArrayList<OrderVO> orders = hotelSalerController.readOrderByState(OrderState.executing);
        Assert.assertEquals(1,orders.size());
        orders = hotelSalerController.readOrderByState(OrderState.executed);
        Assert.assertEquals(1,orders.size());
    }

    /**
     * Method: updateOrder(OrderVO vo)
     */
    @Test
    public void testUpdateOrder() throws Exception {
        OrderVO vo = hotelSalerController.readOrderByState(OrderState.executing).get(0);
        vo.setCheckOutDate(DateOperation.stringToDate("2016_01_01"));
        hotelSalerController.updateOrder(vo);
        Assert.assertEquals("2016_1_1", DateOperation.dateToString(hotelSalerController.readOrderByState(OrderState.executing).get(0).getCheckOutDate()));
    }

    /**
     *
     * Method: getRoomInfo()
     *
     */
    @Test
    public void testGetRoomInfo() throws Exception {
        Assert.assertEquals(200,hotelSalerController.getRoomInfo().get(0).getPrice(),0.1);
    }

    @Test
    public void testGetPromotion() throws Exception {
        Assert.assertEquals("Birthday discount",hotelSalerController.getPromotion(PromotionType.Hotel_Birth).get(0).getPromotionName());
    }


    @Test
    public void testDeletePromotion() throws Exception {
        hotelSalerController.deletePromotion("Birthday discount");
        Assert.assertEquals(0,hotelSalerController.getPromotion(PromotionType.Hotel_Birth).size());
    }

} 

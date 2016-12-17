import businesslogic.hotelsalerbl.HotelSalerController;
import businesslogic.logbl.LogController;
import businesslogic.logbl.Login;
import com.sun.org.apache.xpath.internal.operations.Or;
import enumData.AccountType;
import enumData.PromotionType;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import utility.DateOperation;
import vo.AccountVO;
import vo.HotelinfoVO;
import vo.OrderVO;
import vo.PromotionVO;

import java.util.ArrayList;
import java.util.Date;

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
     * Method: readOrder(String hotelID)
     */
    @Test
    public void testReadOrder() throws Exception {
        ArrayList<OrderVO> orders = hotelSalerController.readOrder();
        Assert.assertEquals(2,orders.size());
    }

    /**
     * Method: updateOrder(OrderVO vo)
     */
    @Test
    public void testUpdateOrder() throws Exception {
        OrderVO vo = hotelSalerController.readOrder().get(0);
        vo.setCheckOutDate(DateOperation.stringToDate("2016_01_01"));
        hotelSalerController.updateOrder(vo);
        Assert.assertEquals("2016_01_01", DateOperation.dateToString(hotelSalerController.readOrder().get(0).getCheckOutDate()));
    }

    /**
     *
     * Method: setOrdered(BelowLineOrderVO vo)
     *
     */
    @Test
    public void testSetOrdered() throws Exception {
//TODO: Test goes here...
    }

    /**
     *
     * Method: setEmpty(BelowLineOrderVO vo)
     *
     */
    @Test
    public void testSetEmpty() throws Exception {
//TODO: Test goes here...
    }

    /**
     *
     * Method: setRoomInfo(ArrayList<HotelroomVO> hotelrooms)
     *
     */
    @Test
    public void testSetRoomInfo() throws Exception {
//TODO: Test goes here...
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
    public void deletePromotion() throws Exception {
        hotelSalerController.deletePromotion("Birthday discount");
        Assert.assertEquals(0,hotelSalerController.getPromotion(PromotionType.Hotel_Birth).size());
    }

    @Test
    public void addPromotion() throws Exception {
        hotelSalerController.addPromotion(new PromotionVO("haha","heihei",PromotionType.Hotel_Birth,"0200001",0.8));
        Assert.assertEquals(2,hotelSalerController.getPromotion(PromotionType.Hotel_Birth).size());
    }

    @Test
    public void setPromotion() throws Exception {
        PromotionVO vo = hotelSalerController.getPromotion(PromotionType.Hotel_Birth).get(0);
        vo.setDescription("haha");
        hotelSalerController.setPromotion(vo);
        Assert.assertEquals("haha",hotelSalerController.getPromotion(PromotionType.Hotel_Birth).get(0).getDescription());
    }
} 

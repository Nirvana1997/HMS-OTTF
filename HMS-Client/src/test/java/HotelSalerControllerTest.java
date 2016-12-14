import businesslogic.hotelsalerbl.HotelSalerController;
import businesslogic.logbl.LogController;
import businesslogic.logbl.Login;
import com.sun.org.apache.xpath.internal.operations.Or;
import enumData.AccountType;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import utility.DateOperation;
import vo.AccountVO;
import vo.HotelinfoVO;
import vo.OrderVO;

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
        vo.setCheckOutDate(new Date(2016,1,1));
        hotelSalerController.updateOrder(vo);
        Assert.assertEquals("2016_1_1", DateOperation.dateToString(hotelSalerController.readOrder().get(0).getCheckOutDate()));
    }


} 

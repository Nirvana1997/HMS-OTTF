import businesslogic.logbl.LogController;
import businesslogic.userbl.UserController;
import businesslogicservice.userblservice.HotelOrderBlService;
import enumData.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import utility.DateOperation;
import vo.AccountVO;
import vo.HotelListItemVO;
import vo.LimitVO;
import vo.OrderVO;

import java.util.ArrayList;

/**
 * UserController Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>十二月 15, 2016</pre>
 */
public class UserControllerTest {
    UserController userController;

    LogController logController;

    @Before
    public void before() throws Exception {
        userController = new UserController();
        logController = new LogController();
        logController.isCorrectAndLogin(new AccountVO("151250001", "111111", null));
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: searchHotel(TradeArea tradeArea,Address address, ArrayList<LimitVO> limits)
     */
    @Test
    public void testSearchHotel() throws Exception {
        HotelOrderBlService hotelOrderBlService = new UserController();
        LimitVO limitVO = new LimitVO(LimitCriterion.GradeCriterion, 4, 5);
        ArrayList<LimitVO> limits = new ArrayList<LimitVO>();
        limits.add(limitVO);
        //结果是否在限制条件内
        boolean inArea = true;

        //评分区间测试
        ArrayList<HotelListItemVO> hotels = hotelOrderBlService.searchHotel(TradeArea.Huanghe, Address.Beijing, limits);
        for (HotelListItemVO hotel : hotels) {
            if (!(hotel.getGrade() >= 4 && hotel.getGrade() <= 5))
                inArea = false;
        }
        Assert.assertEquals(true, inArea);

        //星级区间测试
        limits.clear();
        limits.add(new LimitVO(LimitCriterion.StarCriterion, 4, 5));
        hotels = hotelOrderBlService.searchHotel(TradeArea.Changjiang, Address.Beijing, limits);
        inArea = true;
        for (HotelListItemVO hotel : hotels) {
            if (!(hotel.getStar() >= 4 && hotel.getStar() <= 5))
                inArea = false;
        }
        Assert.assertEquals(true, inArea);

        //关键字测试
        limits.clear();
        limits.add(new LimitVO(LimitCriterion.KeywordCriterion, "仙林"));
        hotels = hotelOrderBlService.searchHotel(TradeArea.Nanhai, Address.Nanjing, limits);
        Assert.assertEquals("仙林大酒店", hotels.get(0).getHotelname());

        //房间测试 TODO
        limits.clear();
        limits.add(new LimitVO(LimitCriterion.RoomCriterion,RoomType.SingleRoom,50,150,1, DateOperation.stringToDate("2016_11_12"),DateOperation.stringToDate("2016_11_12")));
        hotels = hotelOrderBlService.searchHotel(TradeArea.Changjiang,Address.Shanghai,limits);
        Assert.assertEquals("",hotels.get(0).getHotelname());
    }

    /**
     * Method: readHotel(Address address, ConditionVO vo)
     */
    @Test
    public void testReadHotel() throws Exception {
        Assert.assertEquals("仙林大酒店", userController.readHotel("0001").getHotelname());
    }

    /**
     * Method: orderHotel(OrderVO vo, String userID)
     */
    @Test
    public void testOrderHotel() throws Exception {
        OrderVO orderVO = null;
        Assert.assertEquals(true, userController.orderHotel(orderVO));
    }

    /**
     * Method: readOrderByState(String userID)
     */
    @Test
    public void testReadOrder() throws Exception {
        Assert.assertEquals("0200001", userController.readOrder(OrderState.executing).get(0).getHotelID());
        Assert.assertEquals(3, userController.readOrder(OrderState.executing).size());
    }

    /**
     * Method: cancelOrder(String OrderID)
     */
    @Test
    public void testCancelOrder() throws Exception {
        Assert.assertEquals(ResultMessage.Correct, userController.cancelOrder(null));
    }

    /**
     * Method: comment(CommentVO vo)
     */
    @Test
    public void testComment() throws Exception {
//不需要测试
    }


    /**
     * Method: modifyUserInfo(UserInfoVO vo)
     */
    @Test
    public void testModifyUserInfo() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: showUserInfo()
     */
    @Test
    public void testShowUserInfo() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: searchHotel(TradeArea tradeArea, Address address)
     */
    @Test
    public void testSearchHotelForTradeAreaAddress() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: searchHotel(TradeArea tradeArea, Address address, ArrayList<LimitVO> limits)
     */
    @Test
    public void testSearchHotelForTradeAreaAddressLimits() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: hasEnoughCredit()
     */
    @Test
    public void testHasEnoughCredit() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: haveEnoughRoom(OrderVO vo)
     */
    @Test
    public void testHaveEnoughRoom() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: makeOrder(OrderVO vo)
     */
    @Test
    public void testMakeOrder() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: getOrderInfo(String orderID)
     */
    @Test
    public void testGetOrderInfo() throws Exception {
        //TODO
        Assert.assertEquals("ZHotel",userController.getOrderInfo("001").getHotelname());
    }


} 

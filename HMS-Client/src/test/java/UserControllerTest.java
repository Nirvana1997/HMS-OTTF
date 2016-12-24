import businesslogic.logbl.LogController;
import businesslogic.logbl.UserCompanyInfo;
import businesslogic.userbl.UserController;
import businesslogicservice.userblservice.HotelOrderBlService;
import enumData.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import rmi.RemoteHelper;
import utility.DateOperation;
import vo.*;

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
        RemoteHelper.getInstance().linkToServer(IP.ip);
        userController = new UserController();
        logController = new LogController();
        logController.isCorrectAndLogin(new AccountVO("151250001", "111111", null));
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: readHotel(Address address, ConditionVO vo)
     */
    @Test
    public void testReadHotel() throws Exception {
        Assert.assertEquals("XianlinHotel", userController.readHotel("0200001").getHotelname());
    }

    /**
     * Method: orderHotel(OrderVO vo, String userID)
     */
    @Test
    public void testOrderHotel() throws Exception {
        OrderVO vo = new OrderVO("0200001","喋喋大酒店",TradeArea.Changjiang,Address.Nanjing,"南京大学旁",1,1,DateOperation.stringToDate("2016_12_23"),DateOperation.stringToDate("2016_12_24"),RoomType.DoubleRoom,true,"0200001","0100002",OrderState.canceled,null,1888,"",null);
        Assert.assertEquals(true, userController.orderHotel(vo));
    }

    /**
     * Method: readOrderByState(String userID)
     */
    @Test
    public void testReadOrder() throws Exception {
        Assert.assertEquals("0200001", userController.readOrder(OrderState.executing).get(0).getHotelID());
        Assert.assertEquals(1, userController.readOrder(OrderState.executing).size());
    }

    /**
     * Method: cancelOrder(String OrderID)
     */
    @Test
    public void testCancelOrder() throws Exception {
        Assert.assertEquals(ResultMessage.Correct, userController.cancelOrder("01000021223123035"));
    }

    /**
     * Method: comment(CommentVO vo)
     */
    @Test
    public void testComment() throws Exception {
        userController.comment(new CommentVO("0200001","0100001","Great",5));
        Assert.assertEquals("Great",userController.getComments("0200001").get(0).getComment());
        Assert.assertEquals(5,userController.readHotel("0200001").getGrade(),0.1);
    }


    /**
     * Method: modifyUserInfo(UserInfoVO vo)
     */
    @Test
    public void testModifyUserInfo() throws Exception {
        UserInfoVO vo = userController.showUserInfo();
        vo.setIdentity("666");
        userController.modifyUserInfo(vo);
        Assert.assertEquals("666",userController.showUserInfo().getIdentity());
    }

    /**
     * Method: showUserInfo()
     */
    @Test
    public void testShowUserInfo() throws Exception {
        Assert.assertEquals("xzh",userController.showUserInfo().getName());
    }

    /**
     * Method: searchHotel(TradeArea tradeArea, Address address, ArrayList<LimitVO> limits)
     */
    @Test
    public void testSearchHotelForTradeAreaAddressLimits() throws Exception {
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
        limits.add(new LimitVO(LimitCriterion.KeywordCriterion, "Xianlin"));
        hotels = hotelOrderBlService.searchHotel(TradeArea.Changjiang, Address.Nanjing, limits);
        Assert.assertEquals("XianlinHotel", hotels.get(0).getHotelname());
    }

    /**
     * Method: hasEnoughCredit()
     */
    @Test
    public void testHasEnoughCredit() throws Exception {
        Assert.assertEquals(true,userController.hasEnoughCredit());
    }

    /**
     * Method: haveEnoughRoom(OrderVO vo)
     */
    @Test
    public void testHaveEnoughRoom() throws Exception {
        OrderVO vo = new OrderVO("0200001","喋喋大酒店",TradeArea.Changjiang,Address.Nanjing,"南京大学旁",1,1,DateOperation.stringToDate("2016_12_23"),DateOperation.stringToDate("2016_12_24"),RoomType.DoubleRoom,true,"0200001","0100002",OrderState.canceled,null,1888,"",null);
        Assert.assertEquals(true,userController.haveEnoughRoom(vo));
        OrderVO vo2 = new OrderVO("0200001","喋喋大酒店",TradeArea.Changjiang,Address.Nanjing,"南京大学旁",100,1,DateOperation.stringToDate("2016_12_23"),DateOperation.stringToDate("2016_12_24"),RoomType.DoubleRoom,true,"0200001","0100002",OrderState.canceled,null,1888,"",null);
        Assert.assertEquals(false,userController.haveEnoughRoom(vo2));
    }

    /**
     * Method: makeOrder(OrderVO vo)
     */
    @Test
    public void testMakeOrder() throws Exception {
        OrderVO vo = new OrderVO("0200001","喋喋大酒店",TradeArea.Changjiang,Address.Nanjing,"南京大学旁",1,1,DateOperation.stringToDate("2016_12_23"),DateOperation.stringToDate("2016_12_24"),RoomType.DoubleRoom,true,"0200001","0100002",OrderState.canceled,null,1888,"",null);
        Assert.assertEquals(150,userController.makeOrder(vo).getPrice(),0.1);
    }

    /**
     * Method: getOrderInfo(String orderID)
     */
    @Test
    public void testGetOrderInfo() throws Exception {
        Assert.assertEquals("0200001",userController.getOrderInfo("01000021223123035").getHotelID());
    }


} 

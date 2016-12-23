package businesslogic.userbl;

import businesslogic.logbl.Login;
import businesslogicservice.userblservice.HotelOrderBlService;
import businesslogicservice.userblservice.InfoBlService;
import cfg.CfgReader;
import enumData.*;
import po.RoomNumPO;
import vo.*;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * 用户操作控制器
 *
 * @author qzh
 *         Created by user on 2016/11/27.
 */
public class UserController implements InfoBlService, HotelOrderBlService {
    /**
     * 用户信息操作模块
     */
    UserInfo userInfo;

    /**
     * 酒店预定操作模块
     */
    HotelOrder hotelOrder;

    /**
     * 酒店搜索模块
     */
    HotelList hotelList;

    public UserController() throws RemoteException {
        userInfo = new UserInfo();
        hotelOrder = new HotelOrder();
        hotelList = new HotelList();
    }

    /**
     * 修改个人信息
     *
     * @param vo 用户个人信息
     * @return
     * @throws RemoteException
     */
    @Override
    public ResultMessage modifyUserInfo(UserInfoVO vo) throws RemoteException {
        userInfo.modifyUserInfo(vo);
        return ResultMessage.Correct;
    }

    /**
     * 显示个人信息
     *
     * @return 个人信息
     * @throws RemoteException
     */
    @Override
    public UserInfoVO showUserInfo() throws RemoteException {
        return userInfo.showUserInfo(Login.getNowUserID());
    }

    @Override
    public ArrayList<CreditRecordVO> showCreditRecords() throws RemoteException {
        return userInfo.showCreditRecords();
    }

    /**
     * 返回固定商圈、地址中的所有酒店并生成列表项
     * 默认以评分降序排列
     *
     * @param tradeArea 商圈
     * @param address   地址
     * @return
     * @throws RemoteException
     */
    @Override
    public ArrayList<HotelListItemVO> searchHotel(TradeArea tradeArea, Address address) throws RemoteException {
        return hotelList.searchHotelInArea(tradeArea, address, SortWay.valueOf(CfgReader.getInstance().getProperty("defaultSortway")));
    }

    /**
     * 返回固定商圈、地址中符合限制条件的酒店并生成列表项
     *
     * @param tradeArea 商圈
     * @param address   地址
     * @param limits    限制条件数组
     * @return
     * @throws RemoteException
     */
    @Override
    public ArrayList<HotelListItemVO> searchHotel(TradeArea tradeArea, Address address, ArrayList<LimitVO> limits) throws RemoteException {
        return hotelList.hotelFilter(hotelList.searchHotelInArea(tradeArea, address,  SortWay.valueOf(CfgReader.getInstance().getProperty("defaultSortway"))), limits);
    }

    /**
     * 查看酒店详细信息
     *
     * @param hotelID
     * @return 酒店详细信息
     * @throws RemoteException
     */
    @Override
    public HotelinfoVO readHotel(String hotelID) throws RemoteException {
        return hotelList.getHotelInfo(hotelID);
    }

    /**
     * 是否有足够的信用值
     *
     * @return 是否足够
     * @throws RemoteException
     */
    @Override
    public boolean hasEnoughCredit() throws RemoteException {
        return userInfo.hasEnoughCredit();
    }

    /**
     * 返回是否房间数目是否足够
     *
     * @param vo 订单信息
     * @return
     */
    @Override
    public boolean haveEnoughRoom(OrderVO vo) throws RemoteException {
        return hotelOrder.haveEnoughRoom(vo);
    }

    /**
     * 计算订单价格并生成订单信息
     *
     * @param vo 订单信息
     * @throws RemoteException
     */
    @Override
    public OrderVO makeOrder(OrderVO vo) throws RemoteException {
        return hotelOrder.makeOrder(vo);
    }

    /**
     * 预定酒店，生成订单
     *
     * @param vo 订单信息
     * @return 是否成功
     * @throws RemoteException
     */
    @Override
    public boolean orderHotel(OrderVO vo) throws RemoteException {
        return hotelOrder.orderHotel(vo);
    }

    /**
     * 根据用户id得到该用户的订单列表
     *
     * @param orderState 订单状态
     * @return 订单列表
     */
    @Override
    public ArrayList<OrderVO> readOrder(OrderState orderState) throws RemoteException {
        return hotelOrder.readOrder(orderState);
    }

    @Override
    public OrderVO getOrderInfo(String orderID) throws RemoteException {
        return hotelOrder.getOrderInfo(orderID);
    }

    @Override
    public ArrayList<OrderVO> getHotelOrderByUserID( String hotelID) throws RemoteException {
        return hotelOrder.getHotelOrderByUser(hotelID);
    }

    /**
     * 根据订单ID取消该订单
     * 若超出规定时间，会扣除一定信用
     *
     * @param orderID 订单ID
     * @return 若成功则返回Correct，若发生错误则返回Incorrect
     */
    @Override
    public ResultMessage cancelOrder(String orderID) throws RemoteException {
        return hotelOrder.cancelOrder(orderID);
    }

    /**
     * 评价订单
     *
     * @param vo 评价信息
     */
    @Override
    public void comment(CommentVO vo) throws RemoteException {
        hotelOrder.comment(vo);
    }

    /**
     * 获得对应酒店评价信息
     * @param hotelID 酒店id
     * @return 酒店评价信息
     * @throws RemoteException
     */
    @Override
    public ArrayList<CommentVO> getComments(String hotelID) throws RemoteException{
        return hotelOrder.getComments(hotelID);
    }

    /**
     * 获得当天酒店房间信息
     *
     * @param hotelID 酒店id
     * @return 酒店房间信息
     * @throws RemoteException
     */
    @Override
    public ArrayList<RoomNumVO> getNowRooms(String hotelID) throws RemoteException{
        return hotelOrder.getRooms(hotelID);
    }
}

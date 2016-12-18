package businesslogicservice.userblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import businesslogic.userbl.HotelList;
import businesslogic.userbl.OrderFiller;
import com.sun.org.apache.xpath.internal.operations.Or;
import enumData.*;
import vo.*;

/**
 * 酒店预定模块接口
 * 负责搜索酒店和预定酒店
 *
 * @author qzh
 */
public interface HotelOrderBlService {
    /**
     * 返回固定商圈、地址中的所有酒店并生成列表项
     *
     * @param tradeArea 商圈
     * @param address   地址
     * @return 该地址内所有酒店列表项
     * @throws RemoteException
     */
    public ArrayList<HotelListItemVO> searchHotel(TradeArea tradeArea, Address address) throws RemoteException;

    /**
     * 返回固定商圈、地址中符合限制条件的酒店并生成列表项
     *
     * @param tradeArea 商圈
     * @param address   地址
     * @param limits    限制条件数组
     * @return 符合条件的酒店列表项
     * @throws RemoteException
     */
    public ArrayList<HotelListItemVO> searchHotel(TradeArea tradeArea, Address address, ArrayList<LimitVO> limits) throws RemoteException;

    /**
     * 查看酒店详细信息
     *
     * @param hotelID
     * @return 酒店详细信息
     * @throws RemoteException
     */
    public HotelinfoVO readHotel(String hotelID) throws RemoteException;

    /**
     * 是否有足够的信用值
     *
     * @return 是否足够
     * @throws RemoteException
     */
    public boolean hasEnoughCredit() throws RemoteException;

    /**
     * 返回是否房间数目是否足够
     *
     * @param vo 订单信息
     * @return
     */
    public boolean haveEnoughRoom(OrderVO vo) throws RemoteException;

    /**
     * 计算订单价格并生成订单信息
     *
     * @param vo 订单信息
     * @throws RemoteException
     */
    public OrderVO makeOrder(OrderVO vo) throws RemoteException;

    /**
     * 预定酒店，生成订单
     *
     * @param vo 订单信息
     * @return 是否成功
     * @throws RemoteException
     */
    public boolean orderHotel(OrderVO vo) throws RemoteException;

    /**
     * 根据用户id得到该用户的订单列表
     *
     * @param orderState 订单状态
     * @return 订单列表
     */
    public ArrayList<OrderVO> readOrder(OrderState orderState) throws RemoteException;

    /**
     * 返回订单信息
     *
     * @param orderID 订单编号
     * @return 订单
     * @throws RemoteException
     */
    public OrderVO getOrderInfo(String orderID) throws RemoteException;

    /**
     * 根据酒店ID和当前登录用户ID返回用户在该酒店的订单信息
     *
     * @param hotelID 酒店id
     * @return 对应订单list
     * @throws RemoteException
     */
    public ArrayList<OrderVO> getHotelOrderByUserID(String hotelID) throws RemoteException;

    /**
     * 根据订单ID取消该订单
     * 若超出规定时间，会扣除一定信用
     *
     * @param orderID 订单ID
     * @return 若成功则返回Correct，若发生错误则返回Incorrect
     */
    public ResultMessage cancelOrder(String orderID) throws RemoteException;

    /**
     * 评价订单
     *
     * @param vo 评价信息
     */
    public void comment(CommentVO vo) throws RemoteException;

    /**
     * 获得对应酒店评价信息
     *
     * @param hotelID 酒店id
     * @return 酒店评价信息
     * @throws RemoteException
     */
    public ArrayList<CommentVO> getComments(String hotelID) throws RemoteException;

    /**
     * 获得酒店房间信息
     *
     * @param hotelID 酒店id
     * @return 酒店房间信息
     * @throws RemoteException
     */
    public ArrayList<HotelroomVO> getRooms(String hotelID) throws RemoteException;
}

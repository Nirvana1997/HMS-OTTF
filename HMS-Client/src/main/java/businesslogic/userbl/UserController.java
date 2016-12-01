package businesslogic.userbl;

import businesslogicservice.userblservice.HotelOrderBlService;
import businesslogicservice.userblservice.InfoBlService;
import enumData.Address;
import enumData.ResultMessage;
import enumData.SortWay;
import enumData.TradeArea;
import vo.*;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * 用户操作控制器
 * @author qzh
 * Created by user on 2016/11/27.
 */
public class UserController implements InfoBlService,HotelOrderBlService{
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

    public UserController() throws RemoteException{
        userInfo = new UserInfo();
        hotelOrder = new HotelOrder();
        hotelList = new HotelList();
    }

    /**
     * 修改个人信息
     * @param vo 用户个人信息
     * @return
     * @throws RemoteException
     */
    @Override
    public ResultMessage modifyUserInfo(UserInfoVO vo)throws RemoteException {
        userInfo.modifyUserInfo(vo);
        return ResultMessage.Correct;
    }

    /**
     * 显示个人信息
     * @param userID 用户ID
     * @throws RemoteException
     */
    @Override
    public UserInfoVO showUserInfo(String userID) throws RemoteException{
        return userInfo.showUserInfo(userID);
    }

    /**
     * 返回固定商圈、地址中的所有酒店并生成列表项
     * @param tradeArea 商圈
     * @param address 地址
     * @param sortWay 排序方式
     * @return
     * @throws RemoteException
     */
    @Override
    public ArrayList<HotelListItemVO> searchHotel(TradeArea tradeArea, Address address, SortWay sortWay)throws RemoteException {
        return hotelList.searchHotelInArea(tradeArea,address,sortWay);
    }

    /**
     * 返回固定商圈、地址中符合限制条件的酒店并生成列表项
     * @param tradeArea 商圈
     * @param address 地址
     * @param sortWay 排序方式
     * @param limits 限制条件数组
     * @return
     * @throws RemoteException
     */
    @Override
    public ArrayList<HotelListItemVO> searchHotel(TradeArea tradeArea, Address address, SortWay sortWay,ArrayList<LimitVO> limits)throws RemoteException {
        return hotelList.hotelFilter(hotelList.searchHotelInArea(tradeArea,address,sortWay),limits);
    }

    /**
     * 查看酒店详细信息
     * @param hotelID
     * @return
     * @throws RemoteException
     */
    @Override
    public ArrayList<HotelinfoVO> readHotel(String hotelID) throws RemoteException{
        return null;
    }

    @Override
    public boolean orderHotel(OrderVO vo, String userID)throws RemoteException {
        return false;
    }

    @Override
    public ArrayList<OrderVO> readOrder(String userID)throws RemoteException {
        return null;
    }

    @Override
    public ResultMessage cancelOrder(String OrderID)throws RemoteException {
        return null;
    }

    @Override
    public void comment(CommentVO vo)throws RemoteException {

    }
}

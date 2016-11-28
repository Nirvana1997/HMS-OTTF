package businesslogic.userbl;

import businesslogicservice.userblservice.HotelOrderBlService;
import businesslogicservice.userblservice.InfoBlService;
import enumData.Address;
import enumData.ResultMessage;
import vo.*;

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

    public UserController() {
        userInfo = new UserInfo();
        hotelOrder = new HotelOrder();
    }

    /**
     * 修改个人信息
     * @param vo 用户个人信息
     * @return
     */
    @Override
    public ResultMessage modifyUserInfo(UserInfoVO vo) {
        userInfo.modifyUserInfo(vo);
        return ResultMessage.Correct;
    }

    /**
     * 显示个人信息
     * @param userID
     */
    @Override
    public void showUserInfo(String userID) {
        userInfo.showUserInfo(userID);
    }

    @Override
    public ArrayList<HotelinfoVO> searchHotel(Address address, ConditionVO vo) {
        return null;
    }

    @Override
    public ArrayList<HotelinfoVO> readHotel(Address address, ConditionVO vo) {
        return null;
    }

    @Override
    public boolean orderHotel(OrderVO vo, String userID) {
        return false;
    }

    @Override
    public ArrayList<OrderVO> readOrder(String userID) {
        return null;
    }

    @Override
    public ResultMessage cancelOrder(String OrderID) {
        return null;
    }

    @Override
    public void comment(CommentVO vo) {

    }
}

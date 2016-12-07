package businesslogic.userbl;

import businesslogic.hotelsalerbl.HotelDataImpl;
import businesslogic.logbl.Login;
import businesslogic.promotionbl.impl.PromotionDataImpl;
import businesslogic.userbl.interfaces.HotelRoom;
import businesslogic.userbl.interfaces.PromotionInfo;
import businesslogic.userbl.interfaces.VipInfo;
import businesslogic.websalerbl.impl.VipDataImpl;
import cfg.Temp;
import data_stub.userdata.UserDataImpl_stub;
import dataservice.userdataservice.UserDataService;
import enumData.OrderState;
import po.HotelroomPO;
import po.UserInfoPO;
import utility.UserPVChanger;
import vo.OrderVO;
import vo.UserInfoVO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * 填充订单信息类
 * 负责计算最晚执行时间、选择最优惠方案和填充一些编号信息
 * @author qzh
 * Created by user on 2016/12/3.
 */
public class OrderFiller {
    /**
     * 订单VO
     */
    private OrderVO orderVO;

    /**
     * 营销策略接口
     */
    PromotionInfo promotionInfo;

    /**
     * 酒店房间接口
     */
    HotelRoom hotelRoom;

    /**
     * 会员等级接口
     */
    VipInfo vipInfo;

    /**TODO
     * 用户数据接口
     */
    UserDataService userDataService;

    public OrderFiller(OrderVO orderVO) throws RemoteException {
        this.orderVO = orderVO;
        promotionInfo = new PromotionDataImpl();
        hotelRoom = new HotelDataImpl();
        vipInfo = new VipDataImpl();
        userDataService = new UserDataImpl_stub();
    }

    /**
     * 填充订单信息并返回
     * @return 填充完成的订单信息
     * @throws RemoteException
     */
    public OrderVO fillOrder()throws RemoteException{
        fillOrderID();
        fillDDL();
        fillOrderState();
        fillUserID();
        fillPrice();
        return orderVO;
    }

    /**
     * 填充订单编号
     * 格式为userID+getTime
     */
    private void fillOrderID(){
        Date date = new Date();
        orderVO.setOrderID(Login.getNowUser()+date.getTime());
    }

    /**
     * 填充用户ID
     */
    private void fillUserID(){
        orderVO.setUserID(Login.getNowUser());
    }

    /**
     * 填充订单状态
     */
    private void fillOrderState(){
        orderVO.setOrderState(OrderState.executing);
    }

    /**
     * 计算最晚入住时间
     */
    private void fillDDL(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(orderVO.getCheckInDate());
        calendar.add(Calendar.HOUR,Temp.HOUR);
        orderVO.setDdl(calendar.getTime());
    }

    /**
     * 填充价格和促销策略
     * 需要先填入酒店原价
     */
    private void fillPrice()throws RemoteException{
        //初始价格
        double price = 0;
        //酒店房间列表
        ArrayList<HotelroomPO> rooms = hotelRoom.getRoomList(orderVO.getHotelID());
        //找到对应房间价格
        for(HotelroomPO room:rooms){
            if(room.getRoomType().equals(orderVO.getRoomType())){
                price = room.getPrice();
                break;
            }
        }
        //设定初始价格
        orderVO.setPrice(price);
        //获得用户信息
        UserInfoPO userInfoPO = userDataService.getUserInfo(orderVO.getUserID());
        int vipLevel = vipInfo.calcLevel(userInfoPO.getCredit());
        UserInfoVO userInfoVO = UserPVChanger.userInfoP2V(userInfoPO,vipLevel);
        promotionInfo.choosePromotion(userInfoVO, orderVO);
    }
}
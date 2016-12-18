package businesslogic.hotelsalerbl;

import businesslogic.logbl.Login;
import businesslogic.userbl.HotelOrder;
import businesslogicservice.hotelsalerblservice.HotelinfoblService;
import businesslogicservice.hotelsalerblservice.HotelroomblService;
import businesslogicservice.hotelsalerblservice.HotelsalerblService;
import com.sun.org.apache.xpath.internal.operations.Or;
import data_stub.hotelsalerdata.HotelroomDataImpl_stub;
import dataservice.hotelsalerdataservice.HotelroomDataService;
import enumData.*;
import po.HotelinfoPO;
import po.HotelroomPO;
import po.OrderExceptionPO;
import vo.*;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * 酒店工作人员业务逻辑控制器
 *
 * @author qzh
 *         Created by user on 2016/12/7.
 */
public class HotelSalerController implements HotelsalerblService,HotelinfoblService,HotelroomblService {
    /**
     * 酒店信息操作
     */
    HotelInfoOperation hotelInfoOperation;

    /**
     * 酒店房间信息操作
     */
    HotelroomOperation hotelroomOperation;

    /**
     * 酒店订单操作
     */
    HotelOrderOperation hotelOrderOperation;

    /**
     * 酒店营销策略操作
     */
    PromotionOperation promotionOperation;

    public HotelSalerController() {
        hotelInfoOperation = new HotelInfoOperation();
        hotelroomOperation = new HotelroomOperation();
        hotelOrderOperation = new HotelOrderOperation();
        promotionOperation = new PromotionOperation();
    }

    /**
     * 修改酒店信息
     * @param vo 酒店信息
     * @return 是否成功
     * @throws RemoteException
     */
    @Override
    public ResultMessage modifyHotelInfo(HotelinfoVO vo) throws RemoteException {
        return hotelInfoOperation.modifyHotelInfo(vo);
    }

    /**
     * 获得当前登录帐号对应酒店信息
     * @return 对应酒店信息
     * @throws RemoteException
     */
    @Override
    public HotelinfoVO getHotelinfo() throws RemoteException {
        return hotelInfoOperation.getHotelInfo();
    }

    /**
     * 浏览登录帐号对应酒店订单
     *
     * @param orderState 订单状态
     * @return 对应酒店订单信息
     */
    @Override
    public ArrayList<OrderVO> readOrder(OrderState orderState) throws RemoteException{
        return hotelOrderOperation.readOrder(orderState);
    }

    /**
     * 更新订单信息
     * @param vo 订单信息
     * @return 是否成功
     * @throws RemoteException
     */
    @Override
    public ResultMessage updateOrder(OrderVO vo) throws RemoteException {
        return hotelOrderOperation.updateOrder(vo);
    }

    @Override
    public void executeOrder(OrderVO vo) throws RemoteException {
        hotelOrderOperation.executeOrder(vo);
    }

    @Override
    public void delayOrder(OrderVO vo) throws RemoteException {
        hotelOrderOperation.delayOrder(vo);
    }

    @Override
    public void executeOrder(String orderID) throws RemoteException {
//        kk
    }

    @Override
    public ArrayList<PromotionVO> getPromotion(PromotionType promotionType) throws RemoteException {
        return promotionOperation.getPromotions(promotionType);
    }

    @Override
    public void deletePromotion(String promotionName) throws RemoteException {
        promotionOperation.deletePromotion(promotionName);
    }

    @Override
    public void addPromotion(PromotionVO vo) throws RemoteException {
        promotionOperation.addPromotion(vo);
    }

    @Override
    public void setPromotion(PromotionVO vo) throws RemoteException {
        promotionOperation.setPromotion(vo);
    }

    /**
     * 线下订单生成时，
     * 将一个订单上的对应日期中的房间减少
     *
     * @param vo 线下订单信息
     * @return 是否成功
     */
    @Override
    public ResultMessage setOrdered(BelowLineOrderVO vo) throws RemoteException {
        return hotelroomOperation.setOrdered(vo);
    }

    @Override
    public ResultMessage setEmpty(BelowLineOrderVO vo) throws RemoteException {
        return hotelroomOperation.setEmpty(vo);
    }

    @Override
    public void setRoomInfo(ArrayList<HotelroomVO> hotelrooms) throws RemoteException {
        hotelroomOperation.setRoomInfo(hotelrooms);
    }

    /**
     * 获得房间信息
     *
     * @return 酒店房间信息
     * @throws RemoteException
     */
    @Override
    public ArrayList<HotelroomVO> getRoomInfo() throws RemoteException{
        return hotelroomOperation.getRoomInfo();
    }

}

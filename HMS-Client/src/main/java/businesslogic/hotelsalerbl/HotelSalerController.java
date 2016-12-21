package businesslogic.hotelsalerbl;

import businesslogicservice.hotelsalerblservice.HotelinfoblService;
import businesslogicservice.hotelsalerblservice.HotelroomblService;
import businesslogicservice.hotelsalerblservice.HotelsalerblService;
import enumData.*;
import vo.*;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

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
    public ArrayList<OrderVO> readOrderByState(OrderState orderState) throws RemoteException{
        return hotelOrderOperation.readOrder(orderState);
    }

    @Override
    public OrderVO readOrderByID(String orderID) throws RemoteException {
        return hotelOrderOperation.readOrderByID(orderID);
    }

    @Override
    public ArrayList<OrderVO> readOrder() throws RemoteException {
        return hotelOrderOperation.readOrder();
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

    /**
     * 根据日期返回房间信息
     *
     * @param date 日期
     * @return 房间信息
     * @throws RemoteException
     */
    @Override
    public ArrayList<RoomNumVO> getEmptyRoomByDate(Date date) throws RemoteException {
        return hotelroomOperation.getEmptyRoomByDate(date);
    }

    /**
     * 获得所有企业
     *
     * @return 所有企业名称
     * @throws RemoteException
     */
    public ArrayList<String> showAllCompanys() throws RemoteException{
        return promotionOperation.showAllCompanys();
    }

    /**
     * 判断企业ID与企业名称是否对应
     *
     * @param companyID   企业ID
     * @param companyName 企业名称
     * @return 是否对应
     * @throws RemoteException
     */
    public boolean isCompanyIDCorrect(String companyID, String companyName) throws RemoteException{
        return promotionOperation.isCompanyIDCorrect(companyID,companyName);
    }

}

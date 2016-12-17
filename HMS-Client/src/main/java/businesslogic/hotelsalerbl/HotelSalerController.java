package businesslogic.hotelsalerbl;

import businesslogic.logbl.Login;
import businesslogic.userbl.HotelOrder;
import businesslogicservice.hotelsalerblservice.HotelinfoblService;
import businesslogicservice.hotelsalerblservice.HotelroomblService;
import businesslogicservice.hotelsalerblservice.HotelsalerblService;
import data_stub.hotelsalerdata.HotelroomDataImpl_stub;
import dataservice.hotelsalerdataservice.HotelroomDataService;
import enumData.*;
import po.HotelinfoPO;
import po.HotelroomPO;
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

    public HotelSalerController() {
        hotelInfoOperation = new HotelInfoOperation();
        hotelroomOperation = new HotelroomOperation();
        hotelOrderOperation = new HotelOrderOperation();
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
     * @return 对应酒店订单信息
     */
    @Override
    public ArrayList<OrderVO> readOrder() throws RemoteException{
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
    public ArrayList<PromotionVO> getPromotion(PromotionType promotionType) throws RemoteException {
        return null;
    }

    @Override
    public void deletePromotion(String promotionName) throws RemoteException {

    }

    @Override
    public void addPromotion(PromotionVO vo) throws RemoteException {

    }

    @Override
    public void setPromotion(PromotionVO vo) throws RemoteException {

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

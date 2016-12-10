package businesslogic.hotelsalerbl;

import businesslogic.userbl.HotelOrder;
import businesslogicservice.hotelsalerblservice.HotelsalerblService;
import data_stub.hotelsalerdata.HotelroomDataImpl_stub;
import dataservice.hotelsalerdataservice.HotelroomDataService;
import enumData.ResultMessage;
import vo.HotelinfoVO;
import vo.OrderVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * 酒店工作人员业务逻辑控制器
 *
 * @author qzh
 *         Created by user on 2016/12/7.
 */
public class HotelSalerController implements HotelsalerblService {
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
    }

    @Override
    public ResultMessage modifyHotelInfo(HotelinfoVO vo) throws RemoteException {
        return hotelInfoOperation.modifyHotelInfo(vo);
    }

    @Override
    public ArrayList<OrderVO> readOrder(String hotelID) throws RemoteException{
        return hotelOrderOperation.readOrder(hotelID);
    }

    @Override
    public ResultMessage updateOrder(OrderVO vo) throws RemoteException {
        return hotelOrderOperation.updateOrder(vo);
    }
}

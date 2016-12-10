package businesslogic.hotelsalerbl;

import businesslogicservice.hotelsalerblservice.HotelroomblService;
import data_stub.hotelsalerdata.HotelroomDataImpl_stub;
import dataservice.hotelsalerdataservice.HotelroomDataService;
import enumData.ResultMessage;
import po.OrderPO;
import utility.OrderPVChanger;
import vo.BelowLineOrderVO;
import vo.OrderVO;

import java.rmi.RemoteException;

/**
 * 酒店房间相关操作
 *
 * @author qzh
 */
public class HotelroomOperation {
    HotelroomDataService hotelroomDataService;

    public HotelroomOperation() {
        //TODO
        hotelroomDataService = new HotelroomDataImpl_stub();
    }

    /**
     * 线下订单生成时，
     * 将一个订单上的对应日期中的房间减少
     *
     * @param vo 线下订单信息
     * @return 是否成功
     */
    public ResultMessage setOrdered(BelowLineOrderVO vo) throws RemoteException {
        //根据线下订单生成订单信息，方便统一操作
        OrderPO po = OrderPVChanger.belowLineOrderV2P(vo);
        return hotelroomDataService.setOccupied(po);
    }

    /**
     * 线下订单取消时，
     * 将一个订单上的对应日期中的房间增加
     *
     * @param vo 线下订单信息
     * @return 是否成功
     */
    public ResultMessage setEmpty(BelowLineOrderVO vo) throws RemoteException {
        //根据线下订单生成订单信息，方便统一操作
        OrderPO po = OrderPVChanger.belowLineOrderV2P(vo);
        return hotelroomDataService.setEmpty(po);
    }
}

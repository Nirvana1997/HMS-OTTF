package businesslogic.hotelsalerbl;

import businesslogic.logbl.Login;
import cfg.CfgReader;
import data_stub.hotelsalerdata.HotelroomDataImpl_stub;
import dataservice.hotelsalerdataservice.HotelroomDataService;
import enumData.ResultMessage;
import po.HotelroomPO;
import po.OrderPO;
import po.RoomNumPO;
import rmi.RemoteHelper;
import utility.DateOperation;
import utility.HotelPVChanger;
import utility.OrderPVChanger;
import vo.BelowLineOrderVO;
import vo.HotelroomVO;
import vo.RoomNumVO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

/**
 * 酒店房间相关操作
 *
 * @author qzh
 */
public class HotelroomOperation {
    HotelroomDataService hotelroomDataService;

    public HotelroomOperation() {
        //TODO
//        hotelroomDataService = new HotelroomDataImpl_stub();
        hotelroomDataService = RemoteHelper.getInstance().getHotelroomDataService();
    }

    /**
     * 线下订单生成时，
     * 将一个订单上的对应日期中的房间减少
     *
     * @param vo 线下订单信息
     * @return 是否成功
     */
    public ResultMessage setOrdered(BelowLineOrderVO vo) throws RemoteException {
        subEmptyRoom(vo);
        return ResultMessage.Correct;
    }

    /**
     * 线下订单取消时，
     * 将一个订单上的对应日期中的房间增加
     *
     * @param vo 线下订单信息
     * @return 是否成功
     */
    public ResultMessage setEmpty(BelowLineOrderVO vo) throws RemoteException {
        //设置为负的，取消预定，来增加空房间数量
        vo.setRoomNumber(-vo.getRoomNumber());
        subEmptyRoom(vo);
        return ResultMessage.Correct;
    }

    /**
     * 设置酒店房间数目
     *
     * @param hotelrooms 各类型酒店房间情况
     */
    public void setRoomInfo(ArrayList<HotelroomVO> hotelrooms) throws RemoteException {
        ArrayList<HotelroomPO> pos = new ArrayList<HotelroomPO>();
        for (HotelroomVO vo : hotelrooms) {
            pos.add(HotelPVChanger.hotelroomV2P(vo));
        }
        hotelroomDataService.setRoomInfo(pos);
        //构成房间数目PO
        ArrayList<RoomNumPO> roomNums = new ArrayList<RoomNumPO>();
        //获得从当前时间向后特定天数的日期
        ArrayList<Date> dates = DateOperation.getDates(new Date(), DateOperation.addDays(new Date(), Integer.valueOf(CfgReader.getInstance().getProperty("days"))));
        for (Date date : dates) {
            for (HotelroomPO po : pos) {
                roomNums.add(new RoomNumPO(Login.getNowUserID(), DateOperation.dateToString(date), po.getRoomNumber(), po.getRoomType()));
            }
            hotelroomDataService.setRoomNum(roomNums);
            //清空以添加下一天信息
            roomNums.clear();
        }
    }

    /**
     * 获得房间信息
     *
     * @return 酒店房间信息
     * @throws RemoteException
     */
    public ArrayList<HotelroomVO> getRoomInfo() throws RemoteException {
        ArrayList<HotelroomVO> res = new ArrayList<HotelroomVO>();
        for (HotelroomPO po : hotelroomDataService.getRoomList(Login.getNowUserID())) {
            res.add(HotelPVChanger.hotelroomP2V(po));
        }
        return res;
    }

    /**
     * 根据日期返回房间信息
     *
     * @param date 日期
     * @return 房间信息
     * @throws RemoteException
     */
    public ArrayList<RoomNumVO> getEmptyRoomByDate(Date date) throws RemoteException {
        ArrayList<RoomNumVO> res = new ArrayList<>();
        for (RoomNumPO po : hotelroomDataService.getEmptyrooms(Login.getNowUserID(), DateOperation.dateToString(date))) {
            res.add(HotelPVChanger.emptyRoomP2V(po));
        }
        return res;
    }

    /**
     * 根据线下订单减少房间数目
     *
     * @param vo 线下订单信息
     * @throws RemoteException
     */
    private void subEmptyRoom(BelowLineOrderVO vo) throws RemoteException {
        //根据线下订单生成订单信息，方便统一操作
        OrderPO po = OrderPVChanger.belowLineOrderV2P(vo);
        //对每天的房间数目进行操作
        for (Date date : DateOperation.getDates(vo.getCheckInDate(), vo.getCheckOutDate())) {
            ArrayList<RoomNumPO> roomNums = hotelroomDataService.getEmptyrooms(Login.getNowUserID(), DateOperation.dateToString(date));
            for (RoomNumPO roomNum : roomNums) {
                if (roomNum.getRoomType().equals(roomNum.getRoomType())) {
                    roomNum.setEmptyNum(roomNum.getEmptyNum() - vo.getRoomNumber());
                    break;
                }
            }
            hotelroomDataService.setRoomNum(roomNums);
        }
    }
}

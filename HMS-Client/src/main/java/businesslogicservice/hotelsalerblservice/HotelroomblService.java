package businesslogicservice.hotelsalerblservice;

import enumData.ResultMessage;
import enumData.RoomType;
import po.HotelroomPO;
import po.RoomNumPO;
import vo.BelowLineOrderVO;
import vo.HotelroomVO;
import vo.OrderVO;
import vo.RoomNumVO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

/**
 * 负责对酒店的房间状况进行计算和统计
 */
public interface HotelroomblService {
    /**
     * 线下订单生成时，
     * 将一个订单上的对应日期中的房间减少
     *
     * @param vo 线下订单信息
     * @return 是否成功
     */
    public ResultMessage setOrdered(BelowLineOrderVO vo) throws RemoteException;

    /**
     * 线下订单取消时，
     * 将一个订单上的对应日期中的房间增加
     *
     * @param vo 线下订单信息
     * @return 是否成功
     */
    public ResultMessage setEmpty(BelowLineOrderVO vo) throws RemoteException;

    /**
     * 设置酒店房间数目
     *
     * @param hotelrooms 各类型酒店房间情况
     */
    public void setRoomInfo(ArrayList<HotelroomVO> hotelrooms) throws RemoteException;

    /**
     * 获得房间信息
     *
     * @return 酒店房间信息
     * @throws RemoteException
     */
    public ArrayList<HotelroomVO> getRoomInfo() throws RemoteException;

    /**
     * 根据日期返回房间信息
     *
     * @param date 日期
     * @return 房间信息
     * @throws RemoteException
     */
    public ArrayList<RoomNumVO> getEmptyRoomByDate(Date date) throws RemoteException;
}

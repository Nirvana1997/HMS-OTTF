package businesslogic.userbl.interfaces;

import enumData.Address;
import enumData.SortWay;
import enumData.TradeArea;
import po.HotelinfoPO;
import po.HotelroomPO;
import po.RoomNumPO;
import vo.HotelListItemVO;
import vo.HotelinfoVO;
import vo.HotelroomVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * 获取酒店信息的接口
 * 负责给user模块提供hotel模块的数据
 *
 * @author qzh
 *         Created by user on 2016/11/27.
 */
public interface HotelInfo {
    /**
     * 根据条件按顺序返回酒店列表
     *
     * @param tradeArea 商圈
     * @param address   地址
     * @param sortWay   排序方式
     * @return
     * @throws RemoteException
     */
    public ArrayList<HotelinfoPO> getHotelList(TradeArea tradeArea, Address address, SortWay sortWay) throws RemoteException;

    /**
     * 返回一个酒店的详细信息
     *
     * @param hotelID 酒店编号
     * @return 酒店信息
     */
    public HotelinfoPO getHotelInfo(String hotelID) throws RemoteException;

    /**
     * 获得酒店房间信息
     *
     * @param hotelID 酒店id
     * @return 酒店房间信息
     * @throws RemoteException
     */
    public ArrayList<HotelroomPO> getRooms(String hotelID) throws RemoteException;

    /**
     * 传入一个用户的评分并更新酒店评分
     *
     * @param hotelID 酒店编号
     * @param grade   用户评分
     * @throws RemoteException
     */
    public void updateGrade(String hotelID, double grade) throws RemoteException;
}

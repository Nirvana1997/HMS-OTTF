package businesslogic.hotelsalerbl.impl;

import businesslogic.userbl.interfaces.HotelInfo;
import businesslogic.userbl.interfaces.HotelRoom;
import businesslogic.webmanagerbl.HotelInfoForManagement;
import data_stub.hotelsalerdata.HotelinfoDataImpl_stub;
import data_stub.hotelsalerdata.HotelroomDataImpl_stub;
import dataservice.hotelsalerdataservice.HotelinfoDataService;
import dataservice.hotelsalerdataservice.HotelroomDataService;
import enumData.Address;
import enumData.SortWay;
import enumData.TradeArea;
import po.HotelinfoPO;
import po.HotelroomPO;
import po.RoomNumPO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * 酒店信息接口实现
 *
 * @author qzh
 *         Created by personalUser on 2016/11/29.
 */
public class HotelDataImpl implements HotelInfo, HotelRoom,HotelInfoForManagement {
    /**
     * 酒店信息数据接口
     */
    HotelinfoDataService hotelinfoDataService;

    /**
     * 酒店房间信息接口
     */
    HotelroomDataService hotelroomDataService;

    public HotelDataImpl() throws RemoteException {
        hotelinfoDataService = new HotelinfoDataImpl_stub();
        hotelroomDataService = new HotelroomDataImpl_stub();
    }

    /**
     * 根据条件按顺序返回酒店列表
     *
     * @param tradeArea 商圈
     * @param address   地址
     * @param sortWay   排序方式
     * @return
     * @throws RemoteException
     */
    @Override
    public ArrayList<HotelinfoPO> getHotelList(TradeArea tradeArea, Address address, SortWay sortWay) throws RemoteException {
        return hotelinfoDataService.getHotelList(tradeArea, address, sortWay);
    }

    /**
     * 返回酒店信息
     *
     * @param hotelID 酒店编号
     * @return 酒店信息
     * @throws RemoteException
     */
    @Override
    public HotelinfoPO getHotelInfo(String hotelID) throws RemoteException {
        return hotelinfoDataService.getHotelinfo(hotelID);
    }

    /**
     * 设置酒店信息
     * @param po 酒店信息po
     * @throws RemoteException
     */
    @Override
    public void setHotelInfo(HotelinfoPO po) throws RemoteException {
        hotelinfoDataService.setHotelinfo(po);
    }

    /**
     * 获得所有酒店信息
     * @return 酒店信息列表
     * @throws RemoteException
     */
    @Override
    public ArrayList<HotelinfoPO> getHotelList() throws RemoteException {
        return hotelinfoDataService.getHotelList();
    }

    /**
     * 添加酒店信息
     * @param po 酒店信息
     * @throws RemoteException
     */
    @Override
    public void addHotelInfo(HotelinfoPO po) throws RemoteException {
        hotelinfoDataService.addHotelinfo(po);
    }

    @Override
    public void deleteHotelInfo(String hotelID) throws RemoteException {
        hotelinfoDataService.deleteHotelinfo(hotelID);
    }

    /**
     * 根据酒店ID和日期，查询对应日期空房间状况
     *
     * @param hotelID
     * @param date
     * @return
     */
    @Override
    public ArrayList<RoomNumPO> getEmptyrooms(String hotelID, String date) throws RemoteException {
        return hotelroomDataService.getEmptyrooms(hotelID, date);
    }

    /**
     * 得到房间列表（类型，价格）
     *
     * @param hotelID 酒店编号
     * @return 酒店房间列表
     */
    @Override
    public ArrayList<HotelroomPO> getRoomList(String hotelID) throws RemoteException {
        return hotelroomDataService.getRoomList(hotelID);
    }


}

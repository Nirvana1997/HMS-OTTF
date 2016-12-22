package businesslogic.hotelsalerbl.impl;

import businesslogic.userbl.interfaces.HotelInfo;
import businesslogic.userbl.interfaces.HotelRoom;
import businesslogic.webmanagerbl.HotelInfoForManagement;
import cfg.CfgReader;
import dataservice.hotelsalerdataservice.HotelinfoDataService;
import dataservice.hotelsalerdataservice.HotelroomDataService;
import enumData.Address;
import enumData.RoomType;
import enumData.SortWay;
import enumData.TradeArea;
import po.CommentPO;
import po.HotelinfoPO;
import po.HotelroomPO;
import po.RoomNumPO;
import rmi.RemoteHelper;
import utility.DateOperation;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

/**
 * 酒店信息接口实现
 *
 * @author qzh
 *         Created by personalUser on 2016/11/29.
 */
public class HotelDataImpl implements HotelInfo, HotelRoom, HotelInfoForManagement {
    /**
     * 酒店信息数据接口
     */
    HotelinfoDataService hotelinfoDataService;

    /**
     * 酒店房间信息接口
     */
    HotelroomDataService hotelroomDataService;

    public HotelDataImpl() throws RemoteException {
        //TODO
//        hotelinfoDataService = new HotelinfoDataImpl_stub();
//        hotelroomDataService = new HotelroomDataImpl_stub();
        hotelinfoDataService = RemoteHelper.getInstance().getHotelinfoDataService();
        hotelroomDataService = RemoteHelper.getInstance().getHotelroomDataService();
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
     *
     * @param po 酒店信息po
     * @throws RemoteException
     */
    @Override
    public void setHotelInfo(HotelinfoPO po) throws RemoteException {
        hotelinfoDataService.setHotelinfo(po);
    }

    /**
     * 获得所有酒店信息
     *
     * @return 酒店信息列表
     * @throws RemoteException
     */
    @Override
    public ArrayList<HotelinfoPO> getHotelList() throws RemoteException {
        return hotelinfoDataService.getHotelList();
    }

    /**
     * 添加酒店信息
     *
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

    @Override
    public void initRoomNum(String hotelID) throws RemoteException {
        ArrayList<HotelroomPO> pos = new ArrayList<HotelroomPO>();
        //初始化列表
        for (RoomType roomType : RoomType.values()) {
            pos.add(new HotelroomPO(hotelID, roomType, 0, 0));
        }
        hotelroomDataService.initializeRoomInfo(pos);
        //构成房间数目PO
        ArrayList<RoomNumPO> roomNums = new ArrayList<RoomNumPO>();
        //获得从当前时间向后特定天数的日期
        ArrayList<Date> dates = DateOperation.getDates(new Date(), DateOperation.addDays(new Date(), Integer.valueOf(CfgReader.getInstance().getProperty("days"))));
        for (Date date : dates) {
            for (HotelroomPO po : pos) {
                roomNums.add(new RoomNumPO(hotelID, DateOperation.dateToString(date), po.getRoomNumber(), po.getRoomType()));
            }
            hotelroomDataService.initializeRoomNum(roomNums);
            //清空以添加下一天信息
            roomNums.clear();
        }
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

    /**
     * 获得酒店房间信息
     *
     * @param hotelID 酒店id
     * @return 酒店房间信息
     * @throws RemoteException
     */
    @Override
    public ArrayList<HotelroomPO> getRooms(String hotelID) throws RemoteException {
        return hotelroomDataService.getRoomList(hotelID);
    }

    /**
     * 传入一个用户的评分并更新酒店评分
     *
     * @param hotelID 酒店编号
     * @param grade   评分
     * @throws RemoteException
     */
    @Override
    public void updateGrade(String hotelID, double grade) throws RemoteException {
        //所有评价信息
        ArrayList<CommentPO> comments = hotelinfoDataService.getComments(hotelID);
        //最终评分
        double res = 0;
        //计算总和
        for (CommentPO po : comments) {
            res += po.getGrade();
        }
        res = (res + grade) / (comments.size() + 1);
        HotelinfoPO hotelinfoPO = hotelinfoDataService.getHotelinfo(hotelID);
        hotelinfoPO.setGrade(res);
        hotelinfoDataService.setHotelinfo(hotelinfoPO);
    }

    @Override
    public void subRoom(String hotelID, Date start, Date end, RoomType roomType, int num) throws RemoteException {
        changeRoom(hotelID,start,end,roomType,-num);
    }

    @Override
    public void addRoom(String hotelID, Date start, Date end, RoomType roomType, int num) throws RemoteException {
        changeRoom(hotelID,start,end,roomType,-num);
    }

    private void changeRoom(String hotelID, Date start, Date end, RoomType roomType, int num) throws RemoteException {
        ArrayList<RoomNumPO> res = null;
        //获得所有日期
        ArrayList<Date> dates = DateOperation.getDates(start, end);
        for (Date date : dates) {
            res = hotelroomDataService.getEmptyrooms(hotelID, DateOperation.dateToString(date));
            for (RoomNumPO po : res) {
                if (po.getRoomType().equals(roomType)) {
                    int emptyRoom = po.getEmptyNum() - num;
                    po.setEmptyNum(emptyRoom);
                }
            }
            hotelroomDataService.setRoomNum(res);
        }
    }
}

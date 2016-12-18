package businesslogic.userbl.criteria;

import businesslogic.hotelsalerbl.impl.HotelDataImpl;
import businesslogic.userbl.interfaces.HotelRoom;
import businesslogic.userbl.RoomNumJudger;
import enumData.RoomType;
import po.HotelroomPO;
import vo.HotelListItemVO;
import vo.LimitVO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

/**
 * 根据对房间的需要进行过滤筛选
 *
 * @author qzh
 *         Created by user on 2016/11/30.
 */
public class RoomCriterion implements Criterion {
    /**
     * 房间类型
     */
    private RoomType roomType;

    /**
     * 最低价格
     */
    private double minPrice;

    /**
     * 最高价格
     */
    private double maxPrice;

    /**
     * 房间数目
     */
    private int num;

    /**
     * 入住日期
     */
    private Date startDate;

    /**
     * 退房日期
     */
    private Date endDate;

    /**
     * 酒店房间数据接口
     */
    private HotelRoom hotelRoom;

    public RoomCriterion(LimitVO limit) throws RemoteException {
        this.roomType = limit.getRoomType();
        this.minPrice = limit.getMin();
        this.maxPrice = limit.getMax();
        this.num = limit.getNum();
        this.startDate = limit.getStartDate();
        this.endDate = limit.getEndDate();
        hotelRoom = new HotelDataImpl();
    }

    /**
     * 返回在价格区间内的所有酒店
     *
     * @param hotelList 酒店列表
     * @return
     */
    @Override
    public ArrayList<HotelListItemVO> meetCriterion(ArrayList<HotelListItemVO> hotelList) throws RemoteException {
        //结果列表
        ArrayList<HotelListItemVO> res = new ArrayList<HotelListItemVO>();
        //筛选
        for (HotelListItemVO vo : hotelList) {
            if (meet(vo.getHotelID())) {
                res.add(vo);
            }
        }
        return res;
    }

    /**
     * 返回是否符合要求
     *
     * @param hotelID 酒店编号
     * @return
     */
    private boolean meet(String hotelID) throws RemoteException {
        //判断价格是否符合条件
        HotelroomPO roomPO = null;
        for (HotelroomPO room : hotelRoom.getRoomList(hotelID)) {
            if (room.getRoomType().equals(roomType)) {
                roomPO = room;
                break;
            }
        }
        //若不存在对应房间类型或价格不符合要求，直接返回false
        if (roomPO == null && (roomPO.getPrice() > maxPrice || roomPO.getPrice() < minPrice)) {
            return false;
        }

        //判断数目是否符合条件
        RoomNumJudger roomNumJudger = new RoomNumJudger();
        return roomNumJudger.haveEnoughRoom(hotelID, startDate, endDate, roomType, num);
    }
}

package businesslogic.userbl.criteria;

import businesslogic.hotelsalerbl.HotelDataImpl;
import businesslogic.userbl.HotelInfo;
import businesslogic.userbl.HotelRoom;
import enumData.RoomType;
import po.HotelroomPO;
import po.RoomNumPO;
import vo.HotelListItemVO;
import vo.LimitVO;

import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * 根据对房间的需要进行过滤筛选
 * @author qzh
 * Created by user on 2016/11/30.
 */
public class RoomCriterion implements Criterion{
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

    public RoomCriterion(LimitVO limit) throws RemoteException{
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
     * @param hotelList 酒店列表
     * @return
     */
    @Override
    public ArrayList<HotelListItemVO> meetCriterion(ArrayList<HotelListItemVO> hotelList) {
        //结果列表
        ArrayList<HotelListItemVO> res = new ArrayList<HotelListItemVO>();
        //筛选
        for(HotelListItemVO vo:hotelList){
            if(meet(vo.getHotelID())){
                res.add(vo);
            }
        }
        return res;
    }

    /**
     * 返回是否符合要求
     * @param hotelID 酒店编号
     * @return
     */
    private boolean meet(String hotelID){
        //判断价格是否符合条件
        HotelroomPO roomPO = null;
        for(HotelroomPO room:hotelRoom.getRoomList(hotelID)){
            if(room.getRoomType().equals(roomType)){
                roomPO = room;
                break;
            }
        }
        //若不存在对应房间类型或价格不符合要求，直接返回false
        if(roomPO==null&&(roomPO.getPrice()>maxPrice||roomPO.getPrice()<minPrice)){
            return false;
        }

        //判断数目是否符合条件
        //获取期间所有日期
        ArrayList<Date> dates = getDates(startDate,endDate);
        DateFormat df = new SimpleDateFormat("yyyy_MM_dd");
        for (Date date:dates) {
            for(RoomNumPO roomNum:hotelRoom.getEmptyrooms(hotelID,df.format(date))){
                if(roomNum.getRoomType().equals(roomType)&&roomNum.getEmptyNum()<num){
                   return false;
                }
            }
        }
        return true;
    }

    /**
     * 返回起始日期中间的所有日期
     * @param startDate   起始日期
     * @param endDate     结束日期
     * @return
     */
    public static ArrayList<Date> getDates(Date startDate, Date endDate) {
        ArrayList<Date> result = new ArrayList<Date>();
        Calendar start = Calendar.getInstance();
        start.setTime(startDate);
        Calendar end = Calendar.getInstance();
        end.setTime(endDate);

        while (start.before(end)) {
            result.add(start.getTime());
            start.add(Calendar.DAY_OF_YEAR, 1);
        }
        result.add(endDate);
        return result;
    }
}

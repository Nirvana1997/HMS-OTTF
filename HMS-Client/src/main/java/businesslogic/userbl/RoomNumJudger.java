package businesslogic.userbl;

import businesslogic.hotelsalerbl.impl.HotelDataImpl;
import businesslogic.userbl.interfaces.HotelRoom;
import enumData.RoomType;
import po.RoomNumPO;
import utility.DateOperation;

import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * 判断是否有足够房间数量
 * @author qzh
 * Created by user on 2016/12/2.
 */
public class RoomNumJudger {
    private HotelRoom hotelRoom;

    public RoomNumJudger() throws RemoteException {
        hotelRoom = new HotelDataImpl();
    }

    /**
     * 返回是否房间数目是否足够
     * @param hotelID 酒店编号
     * @param startDate 入住时间
     * @param endDate 退房时间
     * @param roomType 房间类型
     * @param num 房间数目
     * @return
     */
    public boolean haveEnoughRoom(String hotelID, Date startDate, Date endDate, RoomType roomType,int num) throws RemoteException {
        //获取期间所有日期
        ArrayList<Date> dates = DateOperation.getDates(startDate,endDate);
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
}

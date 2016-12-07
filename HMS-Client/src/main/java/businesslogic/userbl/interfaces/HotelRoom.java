package businesslogic.userbl.interfaces;

import po.HotelroomPO;
import po.RoomNumPO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by user on 2016/12/1.
 */
public interface HotelRoom {
    /**
     *根据酒店ID和日期，查询对应日期空房间状况
     * @param hotelID
     * @param date
     * @return
     */
    public ArrayList<RoomNumPO> getEmptyrooms(String hotelID, String date) throws RemoteException;

    /**
     *得到房间列表（类型，价格）
     * @param hotelID
     * @return
     */
    public ArrayList<HotelroomPO> getRoomList(String hotelID) throws RemoteException;
}

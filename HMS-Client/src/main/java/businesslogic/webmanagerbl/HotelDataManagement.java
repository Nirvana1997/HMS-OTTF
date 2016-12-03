package businesslogic.webmanagerbl;

import po.HotelinfoPO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * 酒店数据接口
 * Created by user on 2016/12/3.
 */
public interface HotelDataManagement {
    /**
     * 获得某个酒店的信息
     * @param hotelID 酒店ID
     * @return 酒店信息
     */
    public HotelinfoPO getHotelInfo(String hotelID) throws RemoteException;

    /**
     * 设置酒店信息
     * @param po 酒店信息po
     * @throws RemoteException
     */
    public void setHotelInfo(HotelinfoPO po) throws RemoteException;

    /**
     * 获取用户列表
     * @return 用户列表
     */
    public ArrayList<HotelinfoPO> getHotelList(ArrayList<String> hotelIDs)throws RemoteException;
}

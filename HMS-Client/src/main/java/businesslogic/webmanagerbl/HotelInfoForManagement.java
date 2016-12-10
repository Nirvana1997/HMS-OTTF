package businesslogic.webmanagerbl;

import po.HotelinfoPO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * 酒店数据接口
 * Created by user on 2016/12/3.
 */
public interface HotelInfoForManagement {
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
     * 获取酒店列表
     * @return 酒店列表
     */
    public ArrayList<HotelinfoPO> getHotelList()throws RemoteException;

    /**
     * 添加酒店信息
     * @param po 酒店信息
     * @throws RemoteException
     */
    public void addHotelInfo(HotelinfoPO po) throws RemoteException;

    /**
     * 删除酒店信息
     * @param hotelID 酒店编号
     * @throws RemoteException
     */
    public void deleteHotelInfo(String hotelID) throws RemoteException;
}

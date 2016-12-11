package businesslogic.webmanagerbl;

import businesslogic.hotelsalerbl.impl.HotelDataImpl;
import po.HotelinfoPO;
import utility.HotelPVChanger;
import vo.HotelinfoVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * 酒店人员管理模块
 * @author qzh
 */
public class HSmanagement{
    /**
     * 酒店数据模块
     */
    HotelInfoForManagement hotelInfoForManagement;

    public HSmanagement() throws RemoteException{
        hotelInfoForManagement = new HotelDataImpl();
    }


    public ArrayList<HotelinfoVO> getHotellist() throws RemoteException {
        ArrayList<HotelinfoVO> res = new ArrayList<HotelinfoVO>();
        for(HotelinfoPO po: hotelInfoForManagement.getHotelList()){
            res.add(HotelPVChanger.hotelP2V(po));
        }
        return res;
    }

    public HotelinfoVO getHotelinfo(String hotelID) throws RemoteException {
        return HotelPVChanger.hotelP2V(hotelInfoForManagement.getHotelInfo(hotelID));
    }

    public void setHotelinfo(HotelinfoVO vo) throws RemoteException {
        hotelInfoForManagement.setHotelInfo(HotelPVChanger.hotelV2P(vo));
    }

    public void addHotelinfoAndRoom(HotelinfoVO vo) throws RemoteException {
        hotelInfoForManagement.addHotelInfoAndRoom(HotelPVChanger.hotelV2P(vo));
    }

    public void deleteHotel(String hotelID) throws RemoteException {
        hotelInfoForManagement.deleteHotelInfo(hotelID);
    }
}

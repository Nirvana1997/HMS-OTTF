package businesslogic.webmanagerbl;

import businesslogic.hotelsalerbl.impl.HotelDataImpl;
import businesslogic.logbl.impl.AccountInfoImpl;
import businesslogic.webmanagerbl.interfaces.AccountInfo;
import businesslogic.webmanagerbl.interfaces.HotelInfoForManagement;
import enumData.AccountType;
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

    /**
     * 帐号数据模块
     */
    AccountInfo accountInfo;

    public HSmanagement() throws RemoteException{
        hotelInfoForManagement = new HotelDataImpl();
        accountInfo = new AccountInfoImpl();
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

    public void addHotelinfoAndAccount(HotelinfoVO vo,String account, String password) throws RemoteException {
        accountInfo.addAccount(account,password, AccountType.hotelsaler);
        vo.setHotelID(accountInfo.getID(account));
        hotelInfoForManagement.addHotelInfo(HotelPVChanger.hotelV2P(vo));
        //初始化房间信息
        hotelInfoForManagement.initRoomNum(vo.getHotelID());
    }

    public void deleteHotelAndAccount(String hotelID) throws RemoteException {
        hotelInfoForManagement.deleteHotelInfo(hotelID);
        accountInfo.deleteAccount(hotelID);
    }
}

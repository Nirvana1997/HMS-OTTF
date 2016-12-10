package businesslogic.hotelsalerbl.impl;

import businesslogic.webmanagerbl.HotelInfoForManagement;
import businesslogicservice.hotelsalerblservice.HotelinfoblService;
import dataservice.hotelsalerdataservice.HotelinfoDataService;
import enumData.Address;
import enumData.SortWay;
import enumData.TradeArea;
import po.HotelinfoPO;
import utility.HotelPVChanger;
import vo.HotelinfoVO;
import data_stub.hotelsalerdata.HotelinfoDataImpl_stub;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class HotelinfoDataImpl implements HotelinfoblService,HotelInfoForManagement {
    HotelinfoDataService hotelinfoDataService;

    public HotelinfoDataImpl() {
        hotelinfoDataService = new HotelinfoDataImpl_stub();
    }

    /**
     * 返回酒店信息
     * @param hotelID 酒店ID
     * @return 酒店信息
     */
    @Override
    public HotelinfoVO getHotelinfo(String hotelID) throws RemoteException{
        HotelinfoPO po = hotelinfoDataService.getHotelinfo(hotelID);
        return HotelPVChanger.hotelP2V(po);
    }

    @Override
    public ArrayList<HotelinfoPO> searchHotel(TradeArea tradeArea, Address address, SortWay sortWay)throws RemoteException {
        return hotelinfoDataService.getHotelList(tradeArea,address,sortWay);
    }

    @Override
    public HotelinfoPO getHotelInfo(String hotelID) throws RemoteException {
        return hotelinfoDataService.getHotelinfo(hotelID);
    }

    @Override
    public void setHotelInfo(HotelinfoPO po) throws RemoteException {
        hotelinfoDataService.setHotelinfo(po);
    }

    @Override
    public ArrayList<HotelinfoPO> getHotelList() throws RemoteException {
        return hotelinfoDataService.getHotelList();
    }

    @Override
    public void addHotelInfo(HotelinfoPO po) throws RemoteException {
        hotelinfoDataService.addHotelinfo(po);
    }

    @Override
    public void deleteHotelInfo(String hotelID) throws RemoteException {
        hotelinfoDataService.deleteHotelinfo(hotelID);
    }
}

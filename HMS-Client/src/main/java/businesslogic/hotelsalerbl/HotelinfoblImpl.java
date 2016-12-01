package businesslogic.hotelsalerbl;

import businesslogicservice.hotelsalerblservice.HotelinfoblService;
import dataservice.hotelsalerdataservice.HotelinfoDataService;
import enumData.Address;
import enumData.SortWay;
import enumData.TradeArea;
import po.HotelinfoPO;
import vo.HotelinfoVO;
import data_stub.hotelsalerdata.HotelinfoDataImpl_stub;
import vo.LimitVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class HotelinfoblImpl implements HotelinfoblService {
    HotelinfoDataService hotelinfoDataService;

    /**
     * 返回酒店信息
     * @param hotelID 酒店ID
     * @return
     */
    @Override
    public HotelinfoVO getHotelinfo(String hotelID) throws RemoteException{
        hotelinfoDataService = new HotelinfoDataImpl_stub();
        HotelinfoPO po = hotelinfoDataService.getHotelinfo(hotelID);
        if (po != null) {
            HotelinfoVO vo = new HotelinfoVO(po.getHotelID(), po.getHotelname(), po.getTradeArea(), po.getAddress(), po.getDetailAddress(),null, po.getIntroduction(), po.getService(), po.getStar(), po.getGrade());
            return vo;
        } else
            return null;
    }

    @Override
    public ArrayList<HotelinfoPO> searchHotel(TradeArea tradeArea, Address address, SortWay sortWay)throws RemoteException {
        return hotelinfoDataService.getHotelList(tradeArea,address,sortWay);
    }

}

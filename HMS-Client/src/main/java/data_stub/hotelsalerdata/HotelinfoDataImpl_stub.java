package data_stub.hotelsalerdata;

import dataservice.hotelsalerdataservice.HotelinfoDataService;
import enumData.Address;
import enumData.ResultMessage;
import enumData.SortWay;
import enumData.TradeArea;
import po.CommentPO;
import po.ConditionPO;
import po.HotelinfoPO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

public class HotelinfoDataImpl_stub implements HotelinfoDataService {
    ArrayList<HotelinfoPO> hotelList = new ArrayList<HotelinfoPO>();
    HotelinfoPO hotel1 = new HotelinfoPO("0001", "仙林大酒店", TradeArea.Xianlin, Address.NJU,  null, null, "VergGood", "GreatService", 3, 3,99);
    HotelinfoPO hotel2 = new HotelinfoPO("0002", "喋喋大酒店", TradeArea.Xianlin, Address.NJU, null, null, "VergGood", "GreatService", 4, 5,80);
    HotelinfoPO hotel3 = new HotelinfoPO("0003", "萱萱大酒店", TradeArea.XuanQuan, Address.XuanXuan, null, null, "VergGood", "GreatService", 5, 5,200);

    public HotelinfoDataImpl_stub() {
        hotelList.add(hotel1);
        hotelList.add(hotel2);
        hotelList.add(hotel3);
    }

    @Override
    public HotelinfoPO getHotelinfo(String hotelID) {
        Iterator hotelItr = hotelList.iterator();
        while (hotelItr.hasNext()) {
            HotelinfoPO po = (HotelinfoPO) hotelItr.next();
            if (po.getHotelID().equals(hotelID)) {
                return po;
            }
        }
        return null;
    }

    @Override
    public ResultMessage setHotelinfo(HotelinfoPO po) {
        if (po.getHotelID().equals("0001")) {
            return ResultMessage.Correct;
        } else
            return ResultMessage.NotExist;
    }

    @Override
    public ArrayList<HotelinfoPO> getHotelList(TradeArea tradeArea, Address address, SortWay sortWay){
        ArrayList<HotelinfoPO> HIList = new ArrayList<HotelinfoPO>();
        for(HotelinfoPO po:hotelList){
            if(po.getTradeArea().equals(tradeArea)&&po.getAddress().equals(address)){
                HIList.add(po);
            }
        }
        return HIList;
    }

    @Override
    public ResultMessage addComments(CommentPO po) {
        if (po.getHotelID().equals("0001")) {
            return ResultMessage.HasExist;
        } else
            return ResultMessage.Correct;
    }

    @Override
    public ResultMessage addHotelinfo(HotelinfoPO po) throws RemoteException {
        return null;
    }

}

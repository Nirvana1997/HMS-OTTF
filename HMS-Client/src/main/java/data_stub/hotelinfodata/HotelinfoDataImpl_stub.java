package data_stub.hotelinfodata;

import dataservice.hotelinfodataservice.HotelinfoDataService;
import enumData.Address;
import enumData.ResultMessage;
import enumData.TradeArea;
import po.CommentPO;
import po.ConditionPO;
import po.HotelinfoPO;
import vo.HotelinfoVO;

import java.util.ArrayList;
import java.util.Iterator;

public class HotelinfoDataImpl_stub implements HotelinfoDataService {
    ArrayList<HotelinfoPO> hotelList = new ArrayList<HotelinfoPO>();
    HotelinfoPO hotel1 = new HotelinfoPO("0001", "仙林大酒店", TradeArea.Xianlin, Address.NJU, null,null, null, null, "VergGood", "GreatService", 5, 5, null, null);
    HotelinfoPO hotel2 = new HotelinfoPO("0002", "喋喋大酒店", TradeArea.Xianlin, Address.DieDie, null,null, null, null, "VergGood", "GreatService", 5, 5, null, null);
    HotelinfoPO hotel3 = new HotelinfoPO("0003", "萱萱大酒店", TradeArea.XuanQuan, Address.XuanXuan, null,null, null, null, "VergGood", "GreatService", 5, 5, null, null);

    public HotelinfoDataImpl_stub() {
        hotelList.add(hotel1);
        hotelList.add(hotel2);
        hotelList.add(hotel3);
    }

    @Override
    public ResultMessage addHotelInfo(HotelinfoPO po) {
        return null;//TODO
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
    public ArrayList<HotelinfoPO> getHotelList(ConditionPO po) {
        ArrayList<HotelinfoPO> HIList = new ArrayList<HotelinfoPO>();
        HIList.add(new HotelinfoPO("0001", "仙林大酒店", TradeArea.Xianlin, null, null,null, null, null, "VergGood", "GreatService", 5, 5, null, null));
        return HIList;
    }

    @Override
    public ResultMessage addComments(CommentPO po) {
        if (po.getHotelID().equals("0001")) {
            return ResultMessage.HasExist;
        } else
            return ResultMessage.Correct;
    }

}

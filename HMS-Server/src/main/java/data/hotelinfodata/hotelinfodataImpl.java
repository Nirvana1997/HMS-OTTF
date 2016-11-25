package data.hotelinfodata;

import dataservice.hotelinfodataservice.HotelinfoDataService;
import enumData.ResultMessage;
import po.CommentPO;
import po.ConditionPO;
import po.HotelinfoPO;

import java.util.ArrayList;

/**
 * Created by mac on 2016/11/23.
 */
public class HotelinfoDataImpl implements HotelinfoDataService {
    @Override
    public HotelinfoPO getHotelinfo(String hotelID) {
        return null;
    }

    @Override
    public ResultMessage setHotelinfo(HotelinfoPO po) {
        return null;
    }

    @Override
    public ArrayList<HotelinfoPO> getHotelList(ConditionPO po) {
        return null;
    }

    @Override
    public ResultMessage addComments(CommentPO po) {
        return null;
    }
}

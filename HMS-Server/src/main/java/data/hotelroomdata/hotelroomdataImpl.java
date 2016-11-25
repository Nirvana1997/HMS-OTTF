package data.hotelroomdata;

import dataservice.hotelroomdataservice.HotelroomDataService;
import enumData.ResultMessage;
import po.HotelroomPO;
import po.OrderPO;

/**
 * Created by mac on 2016/11/23.
 */
public class HotelroomDataImpl implements HotelroomDataService {
    @Override
    public ResultMessage setOccupied(OrderPO po) {
        return null;
    }

    @Override
    public ResultMessage setEmpty(OrderPO po) {
        return null;
    }

    @Override
    public HotelroomPO getEmptyrooms(String hotelID) {
        return null;
    }

    @Override
    public ResultMessage addHotelroom(HotelroomPO po) {
        return null;
    }
}

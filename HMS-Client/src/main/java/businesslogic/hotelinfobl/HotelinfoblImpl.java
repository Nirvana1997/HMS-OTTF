package businesslogic.hotelinfobl;

import businesslogicservice.hotelinfoblservice.HotelinfoblService;
import dataservice.hotelinfodataservice.HotelinfoDataService;
import po.HotelinfoPO;
import vo.HotelinfoVO;
import data_stub.hotelinfodata.HotelinfoDataImpl_stub;

public class HotelinfoblImpl implements HotelinfoblService {
    HotelinfoDataService hotelinfoDataService;

    /**
     * 返回酒店信息
     * @param hotelID 酒店ID
     * @return
     */
    @Override
    public HotelinfoVO getHotelinfo(String hotelID) {
        hotelinfoDataService = new HotelinfoDataImpl_stub();
        HotelinfoPO po = hotelinfoDataService.getHotelinfo(hotelID);
        if (po != null) {
            HotelinfoVO vo = new HotelinfoVO(po.getHotelID(), po.getHotelname(), po.getTradeArea(), po.getAddress(), po.getDetailAddress(), po.getRoomTypes(), po.getPrices(), po.getIntroduction(), po.getService(), po.getStar(), po.getGrade(), po.getUserIDs(), po.getComments());
            return vo;
        } else
            return null;
    }

}

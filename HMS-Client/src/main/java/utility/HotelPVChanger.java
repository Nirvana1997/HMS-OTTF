package utility;

import po.HotelinfoPO;
import vo.HotelinfoVO;

/**
 * 酒店基本信息PO、VO转换
 *
 * @author qzh
 *         Created by user on 2016/12/9.
 */
public class HotelPVChanger {
    /**
     * 酒店信息VO转PO
     * @param vo 酒店信息VO
     * @return 酒店信息PO
     */
    public static HotelinfoPO hotelV2P(HotelinfoVO vo){
        return new HotelinfoPO(vo.getHotelID(),vo.getHotelname(),vo.getTradeArea(),vo.getAddress(),vo.getDetailAddress(),vo.getIntroduction(),vo.getService(),vo.getContactNumber(),vo.getStar(),vo.getGrade(),vo.getMinPrice());
    }

    /**
     * 酒店信息PO转VO
     * @param po 酒店信息PO
     * @return 酒店信息VO
     */
    public static HotelinfoVO hotelP2V(HotelinfoPO po){
        return new HotelinfoVO(po.getHotelID(),po.getHotelname(),po.getTradeArea(),po.getAddress(),po.getDetailAddress(), po.getContactNumber(),po.getIntroduction(),po.getService(),po.getStar(),po.getGrade(),po.getMinPrice());
    }
}

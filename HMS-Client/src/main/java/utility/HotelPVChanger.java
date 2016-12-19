package utility;

import po.HotelinfoPO;
import po.HotelroomPO;
import vo.HotelinfoVO;
import vo.HotelroomVO;

/**
 * 酒店基本信息、房间信息PO、VO转换
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
        if(vo==null){
            return null;
        }
        return new HotelinfoPO(vo.getHotelID(),vo.getHotelname(),vo.getTradeArea(),vo.getAddress(),vo.getDetailAddress(),vo.getIntroduction(),vo.getService(),vo.getContactNumber(),vo.getStar(),vo.getGrade(),vo.getMinPrice());
    }

    /**
     * 酒店信息PO转VO
     * @param po 酒店信息PO
     * @return 酒店信息VO
     */
    public static HotelinfoVO hotelP2V(HotelinfoPO po){
        if(po==null){
            return null;
        }
        return new HotelinfoVO(po.getHotelID(),po.getHotelName(),po.getTradeArea(),po.getAddress(),po.getDetailAddress(), po.getContactNumber(),po.getIntroduction(),po.getService(),po.getStar(),po.getGrade(),po.getMinPrice());
    }

    /**
     * 酒店房间信息PO转VO
     * @param vo 房间信息VO
     * @return 房间信息PO
     */
    public static HotelroomPO hotelroomV2P(HotelroomVO vo){
        if(vo==null){
            return null;
        }
        return new HotelroomPO(vo.getHotelID(),vo.getRoomType(),vo.getPrice(),vo.getRoomNumber());
    }

    /**
     * 酒店房间信息VO转PO
     * @param po 房间信息PO
     * @return 房间信息VO
     */
    public static HotelroomVO hotelroomP2V(HotelroomPO po){
        if(po==null){
            return null;
        }
        return new HotelroomVO(po.getHotelID(),po.getRoomType(),po.getPrice(),po.getRoomNumber());
    }
}

package utility;

import cfg.Temp;
import po.OrderPO;
import vo.BelowLineOrderVO;
import vo.OrderVO;

import java.util.Date;

/**
 * 负责订单PO、VO转换
 * @author qzh
 * Created by user on 2016/12/6.
 */
public class OrderPVChanger {
    /**
     * 订单信息PO转VO
     * @param po 订单PO
     * @return 订单VO
     */
    public static OrderVO orderP2V(OrderPO po){
        Date ddl = DateOperation.stringToDate(po.getCheckInDate());
        ddl.setHours(Temp.HOUR);
        return new OrderVO(po.getHotelID(),po.getHotelName(),po.getTradeArea(),po.getAddress(),po.getDetailAddress(),po.getRoomNumber(),po.getPeopleNumber(), DateOperation.stringToDate(po.getCheckInDate()),DateOperation.stringToDate(po.getCheckOutDate()),po.getRoomType(),po.isHaveChild(),po.getOrderID(),po.getUserID(),po.getOrderState(),ddl,po.getPrice(),po.getPromotionName(),po.getRoomID());
    }

    /**
     * 订单信息VO转PO
     * @param vo 订单VO
     * @return 订单
     */
    public static OrderPO orderV2P(OrderVO vo){
        return new OrderPO(vo.getHotelID(),vo.getHotelname(),vo.getTradeArea(),vo.getAddress(),vo.getDetailAddress(),vo.getRoomNumber(),vo.getPeopleNumber(), DateOperation.dateToString(vo.getCheckInDate()),DateOperation.dateToString(vo.getCheckOutDate()),vo.getRoomType(),vo.isHaveChild(),vo.getOrderID(),vo.getUserID(),vo.getOrderState(),vo.getPrice(),vo.getPromotionName(),vo.getRoomID());
    }

    /**
     * 根据线下订单生成订单PO
     * @param vo 线下订单VO
     * @return 订单PO
     */
    public static OrderPO belowLineOrderV2P(BelowLineOrderVO vo){
        return new OrderPO(vo.getHotelID(),DateOperation.dateToString(vo.getCheckInDate()),DateOperation.dateToString(vo.getCheckOutDate()),vo.getRoomType(),vo.getRoomNumber());
    }
}

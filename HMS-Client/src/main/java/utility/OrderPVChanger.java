package utility;

import cfg.CfgReader;
import po.CanceledExceptionOrderPO;
import po.OrderPO;
import vo.BelowLineOrderVO;
import vo.CanceledExceptionOrderVO;
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
        if(po==null){
            return null;
        }
        Date ddl = DateOperation.stringToDate(po.getCheckInDate());
        ddl.setHours(Integer.valueOf(CfgReader.getInstance().getProperty("deadline")));
        return new OrderVO(po.getHotelID(),po.getHotelName(),po.getTradeArea(),po.getAddress(),po.getDetailAddress(),po.getRoomNumber(),po.getPeopleNumber(), DateOperation.stringToDate(po.getCheckInDate()),DateOperation.stringToDate(po.getCheckOutDate()),po.getRoomType(),po.isHaveChild(),po.getOrderID(),po.getUserID(),po.getOrderState(),ddl,po.getPrice(),po.getPromotionName(),po.getRoomID());
    }

    /**
     * 订单信息VO转PO
     * @param vo 订单VO
     * @return 订单
     */
    public static OrderPO orderV2P(OrderVO vo){
        if(vo==null){
            return null;
        }
        return new OrderPO(vo.getOrderID(),vo.getHotelID(),vo.getUserID(),vo.getRoomID(),vo.getRoomNumber(),vo.getPeopleNumber(),vo.getOrderState(),DateOperation.dateToString(vo.getCheckInDate()),DateOperation.dateToString(vo.getCheckOutDate()),vo.getRoomType(),vo.getPrice(),vo.isHaveChild(),vo.getHotelname(),vo.getPromotionName(),vo.getTradeArea(),vo.getAddress(),vo.getDetailAddress());
    }

    /**
     * 根据线下订单生成订单PO
     * @param vo 线下订单VO
     * @return 订单PO
     */
    public static OrderPO belowLineOrderV2P(BelowLineOrderVO vo){
        if(vo==null){
            return null;
        }
        return new OrderPO(null,vo.getHotelID(),null,null,vo.getRoomNumber(),0,null,DateOperation.dateToString(vo.getCheckInDate()),DateOperation.dateToString(vo.getCheckOutDate()),vo.getRoomType(),0,false,null,null,null,null,null);
    }

    /**
     * 撤销异常订单信息PO转VO
     * @param po 撤销异常订单信息PO
     * @return 撤销异常订单信息VO
     */
    public static CanceledExceptionOrderVO canceledExceptionOrderP2V(CanceledExceptionOrderPO po){
        if(po==null){
            return null;
        }
        return new CanceledExceptionOrderVO(po.getOrderID(),po.getCancelDate(),po.getCancelTime(),po.getCancelReason());
    }

    /**
     * 撤销异常订单信息VO转PO
     * @param vo 撤销异常订单信息VO
     * @return 撤销异常订单信息PO
     */
    public static CanceledExceptionOrderPO canceledExceptionOrderV2P(CanceledExceptionOrderVO vo){
        if(vo==null){
            return null;
        }
        return new CanceledExceptionOrderPO(vo.getOrderID(),vo.getCancelDate(),vo.getCancelTime(),vo.getCancelReason());
    }
}

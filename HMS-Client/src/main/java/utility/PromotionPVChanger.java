package utility;

import po.PromotionPO;
import vo.PromotionVO;

/**
 * 负责营销策略PO，VO互相转化
 * @author qzh
 * Created by user on 2016/12/5.
 */
public class PromotionPVChanger {
    /**
     * 促销策略PO转VO
     * @param po 促销策略PO
     * @return 促销策略VO
     */
    public static PromotionVO promotionP2V(PromotionPO po){
        return new PromotionVO(po.getName(),po.getDescription(),po.getPromotionType(),po.getHotelID(),po.getStartDate(),po.getEndDate(),po.getTradeArea(),po.getRoomNumber(),po.getVipLevel(),po.getDiscount(),po.getCompanyID());
    }

    /**
     * 用户信息VO转PO
     * @param vo 用户信息VO
     * @return 用户信息PO
     */
    public static PromotionPO promotionV2P(PromotionVO vo){
        return new PromotionPO(vo.getPromotionName(),vo.getDescription(),vo.getPromotionType(),vo.getHotelID(),vo.getStartDate(),vo.getEndDate(),vo.getTradeArea(),vo.getRoomNumber(),vo.getVipLevel(),vo.getDiscount(),vo.getCompanyID());
    }
}

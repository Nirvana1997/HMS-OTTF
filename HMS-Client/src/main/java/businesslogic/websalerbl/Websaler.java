package businesslogic.websalerbl;

import businesslogic.promotionbl.Promotion;
import enumData.ResultMessage;
import vo.PromotionVO;

import java.util.ArrayList;

/**
 * 酒店营销销策略模块
 * 负责制定、查看和取消酒店营销策略
 *
 * @author qzh
 */
public class Websaler {
    /**
     * 制定优惠策略
     *
     * @param vo 优惠策略信息
     * @return 是否成功
     */
    public ResultMessage makePromotion(PromotionVO vo) {
        return ResultMessage.Correct;
    }

    /**
     * 制定范围性优惠策略
     * 包括会员营销策略、特定商圈营销策略、合作商户营销策略
     *
     * @param promotions 营销策略列表
     * @return 是否成功
     */
    public ResultMessage makeListPromotion(ArrayList<PromotionVO> promotions) {
        return ResultMessage.Correct;
    }

    public ResultMessage cancelFestivalPromotion(PromotionVO vo) {
        return ResultMessage.Correct;
    }

    public ResultMessage addCredit(String userID, int value) {
        if (userID == "0001") {
            return ResultMessage.Correct;
        } else {
            return ResultMessage.NotExist;
        }
    }

}

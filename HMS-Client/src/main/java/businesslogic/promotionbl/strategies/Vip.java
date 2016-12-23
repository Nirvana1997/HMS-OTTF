package businesslogic.promotionbl.strategies;

import po.PromotionPO;
import utility.DateOperation;
import vo.OrderVO;
import vo.UserInfoVO;

/**
 * 会员折扣
 *
 * @author qzh
 *         Created by user on 2016/12/6.
 */
public class Vip implements Strategy {
    /**
     * 营销策略
     */
    PromotionPO promotion;

    public Vip(PromotionPO promotion) {
        this.promotion = promotion;
    }

    @Override
    public double calculateDiscountPrice(UserInfoVO userInfoVO, OrderVO orderVO) {
        //获取天数
        int days = DateOperation.getDates(orderVO.getCheckInDate(), orderVO.getCheckOutDate()).size();
        //计算原价
        double sum = orderVO.getPrice() * days * orderVO.getRoomNumber();
        if (userInfoVO.getVipLevel() == promotion.getVipLevel())
            sum *= promotion.getDiscount();
        return sum;
    }
}

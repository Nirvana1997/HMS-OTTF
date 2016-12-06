package businesslogic.promotionbl.strategies;

import po.PromotionPO;
import utility.DateOperation;
import vo.OrderVO;
import vo.UserInfoVO;

/**
 * 一次性预定达到一定数量打折的营销策略
 *
 * @author qzh
 *         Created by user on 2016/12/6.
 */
public class Num implements Strategy{
    /**
     * 营销策略
     */
    PromotionPO promotion;

    public Num(PromotionPO promotion) {
        this.promotion = promotion;
    }

    @Override
    public double calculateDiscountPrice(UserInfoVO userInfoVO, OrderVO orderVO) {
        //获得天数
        int days = DateOperation.getDates(orderVO.getCheckInDate(),orderVO.getCheckOutDate()).size();
        //计算原价
        double sum = orderVO.getPrice() * days;
        if(orderVO.getRoomNumber()>=promotion.getRoomNumber()){
            sum *= promotion.getDiscount();
        }
        return sum;
    }
}

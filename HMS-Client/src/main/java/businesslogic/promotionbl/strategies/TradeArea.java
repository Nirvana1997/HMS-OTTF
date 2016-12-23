package businesslogic.promotionbl.strategies;

import po.PromotionPO;
import utility.DateOperation;
import vo.OrderVO;
import vo.UserInfoVO;

/**
 * 特定商圈会员折扣
 * @author qzh
 * Created by user on 2016/12/6.
 */
public class TradeArea implements Strategy{
    /**
     * 营销策略
     */
    PromotionPO promotion;

    public TradeArea(PromotionPO promotion) {
        this.promotion = promotion;
    }

    @Override
    public double calculateDiscountPrice(UserInfoVO userInfoVO, OrderVO orderVO) {
        //获得天数
        int days = DateOperation.getDates(orderVO.getCheckInDate(),orderVO.getCheckOutDate()).size();
        //计算原始总价
        double sum = orderVO.getPrice() * days * orderVO.getRoomNumber();
        //判断商圈和会员等级是否对应
        if(orderVO.getTradeArea().equals(promotion.getTradeArea())&&userInfoVO.getVipLevel()==promotion.getVipLevel()){
            sum *= promotion.getDiscount();
        }
        return sum;
    }
}

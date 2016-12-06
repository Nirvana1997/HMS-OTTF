package businesslogic.userbl.interfaces;

import businesslogic.promotionbl.Promotion;
import enumData.PromotionType;
import po.PromotionPO;
import vo.OrderVO;
import vo.UserInfoVO;

/**
 * 促销策略信息接口
 * @author qzh
 * Created by user on 2016/12/4.
 */
public interface PromotionInfo {
    /**
     * 获得最优营销策略
     * @param userInfoVO 用户信息
     * @param orderVO 订单信息
     * @return 填充完网站营销策略和酒店营销策略的订单
     */
    public OrderVO choosePromotion(UserInfoVO userInfoVO,OrderVO orderVO);
}

package businesslogic.promotionbl.strategies;

import po.PromotionPO;
import vo.OrderVO;
import vo.UserInfoVO;

import java.util.ArrayList;

/**
 * 营销策略接口
 * @author qzh
 * Created by user on 2016/12/4.
 */
public interface Strategy {
    /**
     * 计算折后价格
     * @param userInfoVO 用户信息
     * @param orderVO 订单信息
     * @return 折后价
     */
    public double calculateDiscountPrice(UserInfoVO userInfoVO, OrderVO orderVO);
}

package businesslogic.promotionbl.strategies;

import vo.OrderVO;
import vo.UserInfoVO;

/**
 * 会员折扣
 * @author qzh
 * Created by user on 2016/12/6.
 */
public class Vip implements Strategy{

    @Override
    public double calculateDiscountPrice(UserInfoVO userInfoVO, OrderVO orderVO) {

        return 0;
    }
}

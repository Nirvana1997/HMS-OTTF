package businesslogic.promotionbl.strategies;

import po.PromotionPO;
import utility.DateOperation;
import vo.OrderVO;
import vo.UserInfoVO;

import java.util.ArrayList;
import java.util.Date;

/**
 * 生日营销策略
 *
 * @author qzh
 *         Created by user on 2016/12/5.
 */
public class Birth implements Strategy {
    /**
     * 营销策略
     */
    PromotionPO promotion;

    public Birth(PromotionPO promotion) {
        this.promotion = promotion;
    }

    @Override
    public double calculateDiscountPrice(UserInfoVO userInfoVO, OrderVO orderVO) {
        //获得原价
        double originPrice = orderVO.getPrice();
        //获得天数
        int days = DateOperation.getDates(orderVO.getCheckInDate(),orderVO.getCheckOutDate()).size();
        //总价
        double sum = orderVO.getPrice() * days * orderVO.getRoomNumber();
        ArrayList<Date> dates = DateOperation.getDates(orderVO.getCheckInDate(), orderVO.getCheckOutDate());
        for (Date date : dates) {
            //若用户生日在住房期间，当天价格打折
            if (date.equals(userInfoVO.getBirthday())) {
                sum += originPrice * promotion.getDiscount();
            }
            else{
                sum += originPrice;
            }
        }
        return sum;
    }
}

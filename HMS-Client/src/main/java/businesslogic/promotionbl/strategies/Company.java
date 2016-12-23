package businesslogic.promotionbl.strategies;

import enumData.UserType;
import po.PromotionPO;
import utility.DateOperation;
import vo.OrderVO;
import vo.UserInfoVO;

/**
 * 合作企业优惠策略
 * @author qzh
 * Created by user on 2016/12/6.
 */
public class Company implements Strategy{
    /**
     * 营销策略
     */
    PromotionPO promotion;

    public Company(PromotionPO promotion) {
        this.promotion = promotion;
    }

    @Override
    public double calculateDiscountPrice(UserInfoVO userInfoVO, OrderVO orderVO) {
        //获得天数
        int days = DateOperation.getDates(orderVO.getCheckInDate(),orderVO.getCheckOutDate()).size();
        //计算原价
        double sum = orderVO.getPrice() * days * orderVO.getRoomNumber();

        //判断用户是否为企业帐号
        if(userInfoVO.getUserType().equals(UserType.Company)){
            //判断是否为合作企业
            if(promotion.getCompanyID()==userInfoVO.getCompanyID()){
                sum *= promotion.getDiscount();
            }
        }
        return sum;
    }
}

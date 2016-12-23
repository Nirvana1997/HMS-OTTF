package businesslogic.promotionbl.strategies;

import businesslogic.promotionbl.strategies.Strategy;
import po.PromotionPO;
import utility.DateOperation;
import vo.OrderVO;
import vo.UserInfoVO;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * 网站特定期间的营销策略
 * @author qzh
 * Created by user on 2016/12/5.
 */
public class Period implements Strategy{
    /**
     * 营销策略
     */
    PromotionPO promotion;

    /**
     * 营销策略开始日期
     */
    Date start;

    /**
     * 营销策略结束日期
     */
    Date end;

    public Period(PromotionPO promotion) {
        this.promotion = promotion;
        DateFormat df = new SimpleDateFormat("yyyy_M_d");
        try {
            start = df.parse(promotion.getStartDate());
            end = df.parse(promotion.getEndDate());
        }catch (ParseException e){
            e.printStackTrace();
        }
    }

    /**
     * 计算折后价格
     * @param userInfoVO 用户信息
     * @param orderVO 订单信息
     * @return 折后价
     */
    @Override
    public double calculateDiscountPrice(UserInfoVO userInfoVO, OrderVO orderVO) {
        ArrayList<Date> dates = DateOperation.getDates(orderVO.getCheckInDate(),orderVO.getCheckOutDate());
        //获得天数
        int days = DateOperation.getDates(orderVO.getCheckInDate(),orderVO.getCheckOutDate()).size();
        //获得原价
        double originPrice = orderVO.getPrice() * days * orderVO.getRoomNumber();
        //总价
        double sum = 0;
        for(Date date:dates){
            double price = originPrice;
            //若在活动期间内，则当天价格要打折
            if(DateOperation.isDuring(date,start,end)){
                price = price * promotion.getDiscount();
            }
            sum+=price;
        }
        return sum;
    }

}

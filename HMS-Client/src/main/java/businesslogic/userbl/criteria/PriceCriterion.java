package businesslogic.userbl.criteria;

import businesslogic.userbl.HotelList;
import vo.HotelListItemVO;
import vo.LimitVO;

import java.util.ArrayList;

/**
 * 根据价格进行过滤筛选
 * @author qzh
 * Created by user on 2016/11/30.
 */
public class PriceCriterion implements Criterion{
    /**
     * 最低价格
     */
    private double minPrice;

    /**
     * 最高价格
     */
    private double maxPrice;

    public PriceCriterion(LimitVO limit) {
        this.minPrice = limit.getMin();
        this.maxPrice = limit.getMax();
    }

    /**
     * 返回在价格区间内的所有酒店
     * @param hotelList 酒店列表
     * @return
     */
    @Override
    public ArrayList<HotelListItemVO> meetCriterion(ArrayList<HotelListItemVO> hotelList) {
        //结果列表
        ArrayList<HotelListItemVO> res = new ArrayList<HotelListItemVO>();
        //筛选
        for(HotelListItemVO vo:hotelList){
            if(vo.getMinPrice()>=minPrice&&vo.getMinPrice()<=maxPrice){
                res.add(vo);
            }
        }
        return res;
    }
}

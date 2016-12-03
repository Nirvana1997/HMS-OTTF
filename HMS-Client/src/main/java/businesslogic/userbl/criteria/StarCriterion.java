package businesslogic.userbl.criteria;

import vo.HotelListItemVO;
import vo.LimitVO;

import java.util.ArrayList;

/**
 * 根据星级进行过滤筛选
 * @author qzh
 * Created by user on 2016/11/30.
 */
public class StarCriterion implements Criterion{
    /**
     * 最低星级
     */
    double minGrade;

    /**
     * 最高星级
     */
    double maxGrade;

    public StarCriterion(LimitVO limit) {
        this.maxGrade = limit.getMax();
        this.minGrade = limit.getMin();
    }

    /**
     * 返回在星级区间内的所有酒店
     * @param hotelList 酒店列表
     * @return
     */
    @Override
    public ArrayList<HotelListItemVO> meetCriterion(ArrayList<HotelListItemVO> hotelList) {
        //结果列表
        ArrayList<HotelListItemVO> res = new ArrayList<HotelListItemVO>();
        //筛选
        for(HotelListItemVO vo:hotelList){
            if(vo.getStar()>=minGrade&&vo.getStar()<=maxGrade){
                res.add(vo);
            }
        }
        return res;
    }
}

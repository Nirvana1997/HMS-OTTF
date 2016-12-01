package businesslogic.userbl.criteria;

import vo.HotelListItemVO;
import vo.LimitVO;

import java.util.ArrayList;

/**
 * 根据评分进行过滤筛选
 * @author qzh
 * Created by user on 2016/11/30.
 */
public class GradeCriterion implements Criterion{
    /**
     * 最低评分
     */
    double minGrade;

    /**
     * 最高评分
     */
    double maxGrade;

    public GradeCriterion(LimitVO limit) {
        minGrade = limit.getMin();
        maxGrade = limit.getMax();
    }

    /**
     * 返回在评分区间内的所有酒店
     * @param hotelList 酒店列表
     * @return
     */
    @Override
    public ArrayList<HotelListItemVO> meetCriterion(ArrayList<HotelListItemVO> hotelList) {
        //结果列表
        ArrayList<HotelListItemVO> res = new ArrayList<HotelListItemVO>();
        //筛选
        for(HotelListItemVO vo:hotelList){
            if(vo.getGrade()>=minGrade&&vo.getGrade()<=maxGrade){
                res.add(vo);
            }
        }
        return res;
    }
}

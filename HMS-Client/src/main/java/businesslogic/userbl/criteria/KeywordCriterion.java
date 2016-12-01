package businesslogic.userbl.criteria;

import vo.HotelListItemVO;
import vo.LimitVO;

import java.util.ArrayList;

/**
 * 根据关键字来过滤酒店
 * @author qzh
 * Created by user on 2016/11/30.
 */
public class KeywordCriterion implements Criterion{
    /**
     * 关键字
     */
    String keyword;

    public KeywordCriterion(LimitVO limit) {
        this.keyword = limit.getKeyword();
    }

    /**
     * 返回包含特定关键字的所有酒店
     * @param hotelList 酒店列表
     * @return
     */
    @Override
    public ArrayList<HotelListItemVO> meetCriterion(ArrayList<HotelListItemVO> hotelList) {
        //结果列表
        ArrayList<HotelListItemVO> res = new ArrayList<HotelListItemVO>();
        //筛选
        for(HotelListItemVO vo:hotelList){
            if(containKeyword(keyword,vo.getHotelname())){
                res.add(vo);
            }
        }
        return res;
    }

    /**
     * 返回该酒店是否包含关键字
     * @param keyword 关键字
     * @param hotelname 酒店名
     * @return
     */
    private boolean containKeyword(String keyword,String hotelname){
        //若有空格，则分裂为多个关键字来搜索
        String[] keywords = keyword.split(" ");
        for(String word:keywords){
            //若不包含某一关键字，则直接返回false
            if(hotelname.indexOf(word)==-1)
                return false;
        }
        //若包含所有关键字则返回true
        return true;
    }
}

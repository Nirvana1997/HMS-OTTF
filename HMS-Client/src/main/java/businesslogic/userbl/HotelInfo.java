package businesslogic.userbl;

import enumData.SortWay;
import vo.ConditionVO;
import vo.HotelinfoVO;

import java.util.ArrayList;
import java.util.SortedMap;

/**
 * Created by user on 2016/11/27.
 */
public interface HotelInfo {
    /**
     * 根据条件按顺序返回酒店列表
     * @param vo
     * @return
     */
    public ArrayList<HotelinfoVO> getHotelList(ConditionVO vo);

    /**
     * 返回一个酒店的详细信息
     * @param hotelID
     * @return
     */
    public HotelinfoVO getHotelInfo(String hotelID);
}

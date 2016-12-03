package businesslogic.userbl.criteria;

import vo.HotelListItemVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * 过滤规则接口
 * @author qzh
 * Created by user on 2016/11/30.
 */
public interface Criterion {
    /**
     * 根据规则进行过滤筛选
     * @param hotelList 酒店列表
     * @return
     */
    public ArrayList<HotelListItemVO> meetCriterion(ArrayList<HotelListItemVO> hotelList) throws RemoteException;
}

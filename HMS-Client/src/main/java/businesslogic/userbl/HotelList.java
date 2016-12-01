package businesslogic.userbl;

import businesslogic.hotelsalerbl.HotelDataImpl;
import businesslogic.userbl.criteria.Criterion;
import enumData.Address;
import enumData.SortWay;
import enumData.TradeArea;
import vo.HotelListItemVO;
import vo.HotelinfoVO;
import vo.LimitVO;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * 酒店列表
 * 负责对应搜索条件和排序方式生成酒店列表和一个酒店的详细信息
 * @author qzh
 * Created by user on 2016/11/27.
 */
public class HotelList {
    /**
     * 酒店信息接口
     */
    HotelInfo hotelInfo;

    public HotelList() throws RemoteException{
        hotelInfo = new HotelDataImpl();
    }

    /**
     * 获得酒店详细信息
     * @param hotelID 酒店编号
     * @return
     */
    public HotelinfoVO getHotelInfo(String hotelID)throws RemoteException{
        return null;
    }

    /**
     * 返回固定商圈、地址中的所有酒店并生成列表项
     * @param tradeArea 商圈
     * @param address 地址
     * @param sortWay 排序方式
     * @return
     * @throws RemoteException
     */
    public ArrayList<HotelListItemVO> searchHotelInArea(TradeArea tradeArea, Address address, SortWay sortWay)throws RemoteException{
        return hotelInfo.getHotelList(tradeArea,address,sortWay);
    }

    /**
     * 过滤并返回符合条件的酒店
     * @param hotelListItems 酒店列表
     * @param limits 限制条件
     * @return
     */
    public ArrayList<HotelListItemVO> hotelFilter(ArrayList<HotelListItemVO> hotelListItems,ArrayList<LimitVO> limits){
        ArrayList<HotelListItemVO> res = new ArrayList<HotelListItemVO>(hotelListItems);
        //过滤器接口
        Criterion criterion = null;
        for(LimitVO limit:limits){
            //利用反射创建过滤规则对象
            try {
                Constructor constructor = Class.forName("businesslogic.userbl.criteria."+limit.getLimitCriterion().toString()).getConstructor(new Class[]{LimitVO.class});
                criterion = (Criterion)constructor.newInstance(limit);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e){
                e.printStackTrace();
            } catch (InstantiationException e){
                e.printStackTrace();
            } catch (IllegalAccessException e){
                e.printStackTrace();
            } catch (InvocationTargetException e){
                e.printStackTrace();
            }
            //进行过滤
            res = criterion.meetCriterion(res);
        }
        return res;
    }
}

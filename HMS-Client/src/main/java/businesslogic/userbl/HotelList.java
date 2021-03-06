package businesslogic.userbl;

import businesslogic.hotelsalerbl.impl.HotelDataImpl;
import businesslogic.orderbl.impl.OrderDataImpl;
import businesslogic.userbl.criteria.Criterion;
import businesslogic.userbl.interfaces.HotelInfo;
import businesslogic.userbl.interfaces.UserOrderInfo;
import enumData.Address;
import enumData.OrderState;
import enumData.SortWay;
import enumData.TradeArea;
import po.HotelinfoPO;
import po.OrderPO;
import utility.HotelPVChanger;
import vo.HotelListItemVO;
import vo.HotelinfoVO;
import vo.LimitVO;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.rmi.RemoteException;
import java.text.DecimalFormat;
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
        HotelinfoPO po = hotelInfo.getHotelInfo(hotelID);
        return HotelPVChanger.hotelP2V(po);
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
        //获得登录用户订单列表
        UserOrderInfo userOrderInfo = new OrderDataImpl();
        ArrayList<OrderPO> orders = userOrderInfo.getOrderList();
        //酒店列表项列表，存放返回的结果
        ArrayList<HotelListItemVO> hotelListItemList = new ArrayList<HotelListItemVO>();
        //获取酒店详细信息列表
        ArrayList<HotelinfoPO> hotelinfoList = hotelInfo.getHotelList(tradeArea,address,sortWay);

        for(HotelinfoPO po:hotelinfoList){
            //判断是否预定过该酒店
            boolean[] hasOrdered = orderStates(po.getHotelID(),orders);
            //添加列表项
            DecimalFormat df =new DecimalFormat("#.0");
            hotelListItemList.add(new HotelListItemVO(po.getHotelID(),po.getHotelName(),po.getDetailAddress(),po.getStar(),Double.valueOf(df.format(po.getGrade())),po.getMinPrice(),hasOrdered[0],hasOrdered[1],hasOrdered[2]));
        }
        return hotelListItemList;
    }

    /**
     * 过滤并返回符合条件的酒店
     * @param hotelListItems 酒店列表
     * @param limits 限制条件
     * @return
     */
    public ArrayList<HotelListItemVO> hotelFilter(ArrayList<HotelListItemVO> hotelListItems,ArrayList<LimitVO> limits) throws RemoteException {
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

    /**
     * 判断该酒店是否被登录用户预定过
     * @param hotelID 酒店ID
     * @param orders 订单列表
     * @return 0-是否有过正常订单
     *          1-是否有过异常订单
     *          2-是否有过撤销订单
     */
    private boolean[] orderStates(String hotelID, ArrayList<OrderPO> orders){
        boolean[] res = new boolean[3];
        for(OrderPO order:orders){
            if(order.getHotelID().equals(hotelID)){
                if(order.getOrderState().equals(OrderState.executed)||order.getOrderState().equals(OrderState.executing))
                    res[0] = true;
                else if(order.getOrderState().equals(OrderState.exception))
                    res[1] = true;
                else
                    res[2] = true;
            }
        }
        return res;
    }
}

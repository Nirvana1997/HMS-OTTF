package businesslogic.hotelsalerbl;

import businesslogic.userbl.HotelInfo;
import data_stub.hotelsalerdata.HotelinfoDataImpl_stub;
import data_stub.hotelsalerdata.HotelroomDataImpl_stub;
import dataservice.hotelsalerdataservice.HotelinfoDataService;
import dataservice.hotelsalerdataservice.HotelroomDataService;
import enumData.Address;
import enumData.SortWay;
import enumData.TradeArea;
import po.HotelinfoPO;
import vo.HotelListItemVO;
import vo.HotelinfoVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * 酒店信息接口实现
 * @author qzh
 * Created by user on 2016/11/29.
 */
public class HotelInfoImpl implements HotelInfo{
    /**
     * 酒店信息数据接口
     */
    HotelinfoDataService hotelinfoDataService;

    /**
     * 酒店房间信息接口
     */
    HotelroomDataService hotelroomDataService;

    public HotelInfoImpl() throws RemoteException{
        hotelinfoDataService = new HotelinfoDataImpl_stub();
        hotelroomDataService = new HotelroomDataImpl_stub();
    }

    /**
     * 根据条件按顺序返回酒店列表
     * @param tradeArea 商圈
     * @param address 地址
     * @param sortWay 排序方式
     * @return
     * @throws RemoteException
     */
    @Override
    public ArrayList<HotelListItemVO> getHotelList(TradeArea tradeArea, Address address, SortWay sortWay) throws RemoteException{
        //酒店列表项列表，存放返回的结果
        ArrayList<HotelListItemVO> hotelListItemList = new ArrayList<HotelListItemVO>();
        //获取酒店详细信息列表
        ArrayList<HotelinfoPO> hotelinfoList = hotelinfoDataService.getHotelList(tradeArea,address,sortWay);

        for(HotelinfoPO po:hotelinfoList){
            //获得最低价格
            double minPrice = hotelroomDataService.getRoomList(po.getHotelID()).get(0).getPrice();
            //添加列表项
            hotelListItemList.add(new HotelListItemVO(po.getHotelname(),po.getDetailAddress(),po.getStar(),po.getGrade(),minPrice));
        }
        return hotelListItemList;
    }

    /**
     * 返回酒店信息
     * @param hotelID
     * @throws RemoteException
     * @return
     */
    @Override
    public HotelinfoPO getHotelInfo(String hotelID) throws RemoteException{
        return hotelinfoDataService.getHotelinfo(hotelID);
    }
}

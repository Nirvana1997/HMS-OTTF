package driver;

import data.hotelsalerdata.HotelinfoDataImpl;
import dataservice.hotelsalerdataservice.HotelinfoDataService;
import enumData.Address;
import enumData.SortWay;
import enumData.TradeArea;
import po.CommentPO;
import po.HotelinfoPO;

import java.rmi.RemoteException;

/**
 * Created by mac on 2016/12/4.
 */
public class HotelInfoTest {
    public static void main(String[] args) throws Exception {
        //酒店信息实现测试
        HotelinfoDataService hotelinfoDataService = new HotelinfoDataImpl();
        System.out.println(hotelinfoDataService.addHotelinfo(new HotelinfoPO("01","梓航大酒店", TradeArea.Xianlin, Address.Xianlin,
                "仙林大道","很好","服务周到","13596297777",5,9.9,200.0)));
        System.out.println(hotelinfoDataService.addHotelinfo(new HotelinfoPO("02","志豪大酒店", TradeArea.Xianlin, Address.Xianlin,
                "仙林小道","很好","服务周到","13236539018",4,8.0,150.0)));
        System.out.println(hotelinfoDataService.addHotelinfo(new HotelinfoPO("03","组长大酒店", TradeArea.Gulou, Address.Gulou,
                "鼓楼","很好","服务周到","13331411234",3,5.5,100.0)));
        System.out.println(hotelinfoDataService.addHotelinfo(new HotelinfoPO("04","喋喋大酒店", TradeArea.Gulou, Address.Gulou,
                "鼓楼","很好","服务周到","15991920001",2,7.2,175.0)));
        System.out.println(hotelinfoDataService.getHotelinfo("03").getHotelName());
        System.out.println(hotelinfoDataService.getHotelList(TradeArea.Xianlin,Address.Xianlin, SortWay.Price_Ascending).get(0).getMinPrice());
        System.out.println(hotelinfoDataService.getHotelList(TradeArea.Xianlin,Address.Xianlin, SortWay.Price_Descending).get(0).getMinPrice());
        System.out.println(hotelinfoDataService.setHotelinfo(new HotelinfoPO("01","梓航大酒店", TradeArea.Xianlin, Address.Xianlin,
                "仙林大道","很好","服务周到","13596296666",5,9.9,200.0)));
        System.out.println(hotelinfoDataService.getHotelinfo("01").getContactNumber());
        System.out.println(hotelinfoDataService.addComments(new CommentPO("01","511422713","很棒很舒适",10)));
        System.out.println(hotelinfoDataService.getComments("01").get(0).getComment());

    }
}

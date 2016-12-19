package dataservice.factory;
import dataservice.hotelsalerdataservice.HotelinfoDataService;
import dataservice.hotelsalerdataservice.HotelroomDataService;
import dataservice.logdataservice.LogDataService;
import dataservice.orderdataservice.OrderDataService;
import dataservice.promotiondataservice.PromotionDataService;
import dataservice.userdataservice.UserDataService;
import dataservice.websalerdataservice.WebsalerDataService;
import java.rmi.Remote;

/**
 * Created by mac on 2016/12/19.
 */
public interface DataFactory extends Remote{
    public HotelinfoDataService getHotelinfoDataImpl()throws Exception;
    public HotelroomDataService getHotelroomDataImpl()throws Exception;
    public LogDataService getLogDataImpl()throws Exception;
    public OrderDataService getOrderDataImpl()throws Exception;
    public PromotionDataService getPromotionDataImpl()throws Exception;
    public UserDataService getUserDataImpl()throws Exception;
    public WebsalerDataService getWebsalerDataImpl()throws Exception;
}

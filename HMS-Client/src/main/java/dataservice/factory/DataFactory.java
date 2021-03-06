package dataservice.factory;
import dataservice.companydataservice.CompanyDataService;
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
    /**
     * 得到实现
     * @return 接口（实现）
     * @throws Exception
     */
    public HotelinfoDataService getHotelinfoDataImpl()throws Exception;

    /**
     * 得到实现
     * @return 接口（实现）
     * @throws Exception
     */
    public HotelroomDataService getHotelroomDataImpl()throws Exception;

    /**
     * 得到实现
     * @return 接口（实现）
     * @throws Exception
     */
    public LogDataService getLogDataImpl()throws Exception;

    /**
     * 得到实现
     * @return 接口（实现）
     * @throws Exception
     */
    public OrderDataService getOrderDataImpl()throws Exception;

    /**
     * 得到实现
     * @return 接口（实现）
     * @throws Exception
     */
    public PromotionDataService getPromotionDataImpl()throws Exception;

    /**
     * 得到实现
     * @return 接口（实现）
     * @throws Exception
     */
    public UserDataService getUserDataImpl()throws Exception;

    /**
     * 得到实现
     * @return 接口（实现）
     * @throws Exception
     */
    public WebsalerDataService getWebsalerDataImpl()throws Exception;

    /**
     * 得到实现
     * @return 接口（实现）
     * @throws Exception
     */
    public CompanyDataService getCompanyDataImpl()throws Exception;
}

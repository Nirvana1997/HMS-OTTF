package rmi;

import dataservice.hotelsalerdataservice.HotelinfoDataService;
import dataservice.hotelsalerdataservice.HotelroomDataService;
import dataservice.logdataservice.LogDataService;
import dataservice.orderdataservice.OrderDataService;
import dataservice.promotiondataservice.PromotionDataService;
import dataservice.userdataservice.UserDataService;
import dataservice.websalerdataservice.WebsalerDataService;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * 连接服务器并提供服务
 * Created by personalUser on 2016/11/6.
 */
public class RemoteHelper {
    private static RemoteHelper remoteHelper;
    /**
     * 是否连接到服务器
     */
    private boolean connected = false;

    private LogDataService logDataService;
    private HotelinfoDataService hotelinfoDataService;
    private HotelroomDataService hotelroomDataService;
    private OrderDataService orderDataService;
    private PromotionDataService promotionDataService;
    private UserDataService userDataService;
    private WebsalerDataService websalerDataService;

    /**
     * 获得用例
     * @return remoteHelper
     */
    public static RemoteHelper getInstance() {
        if(remoteHelper==null)
            remoteHelper = new RemoteHelper();
        return remoteHelper;
    }

    private RemoteHelper() {
        linkToServer();
    }

    /**
     * 是否连接到服务器
     * @return connected
     */
    public boolean hasConnected(){
        return connected;
    }

    /**
     * 连接到服务器
     */
    private void linkToServer(){
        try {
            logDataService = (LogDataService)Naming.lookup("rmi://localhost:8888/LogDataService");
//            hotelinfoDataService = (HotelinfoDataService)Naming.lookup("rmi://localhost:8888/HotelinfoDataService");
//            hotelroomDataService = (HotelroomDataService)Naming.lookup("rmi://localhost:8888/HotelroomDataService");
//            hotelsalerDataService = (HotelsalerDataService)Naming.lookup("rmi://localhost:8888/HotelsalerDataService");
//            orderDataService = (OrderDataService)Naming.lookup("rmi://localhost:8888/OrderDataService");
//            promotionDataService = (PromotionDataService)Naming.lookup("rmi://localhost:8888/PromotionDataService");
//            userDataService = (UserDataService)Naming.lookup("rmi://localhost:8888/UserDataService");
//            websalerDataService = (WebsalerDataService)Naming.lookup("rmi://localhost:8888/WebsalerDataService");
              System.out.println("linked");
              connected = true;
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public LogDataService getLogDataService() {
        return logDataService;
    }

    public HotelinfoDataService getHotelinfoDataService() {
        return hotelinfoDataService;
    }

    public HotelroomDataService getHotelroomDataService() {
        return hotelroomDataService;
    }

    public OrderDataService getOrderDataService() {
        return orderDataService;
    }

    public PromotionDataService getPromotionDataService() {
        return promotionDataService;
    }

    public UserDataService getUserDataService() {
        return userDataService;
    }

    public WebsalerDataService getWebsalerDataService() {
        return websalerDataService;
    }
}

package driver;

import data.hotelsalerdata.HotelinfoDataImpl;
import data.hotelsalerdata.HotelroomDataImpl;
import data.logdata.LogDataImpl;
import data.orderdata.OrderDataImpl;
import data.promotiondata.PromotionDataImpl;
import data.userdata.UserDataImpl;
import data.websalerdata.WebsalerDataImpl;
import dataservice.logdataservice.LogDataService;
import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * Created by user on 2016/11/5.
 */
public class ServerRunner {

    public ServerRunner(){
        initServer();
    }

    public static void main(String[] args) {
        ServerRunner serverRunner = new ServerRunner();
    }

    /**
     * 初始化服务器
     */
    public void initServer(){
        try {
//            System.setProperty("java.rmi.server.hostname","");
            LocateRegistry.createRegistry(8888);
            Naming.bind("rmi://localhost:8888/HotelinfoDataService",  new HotelinfoDataImpl());
            Naming.bind("rmi://localhost:8888/HotelroomDataService",  new HotelroomDataImpl());
            Naming.bind("rmi://localhost:8888/LogDataService",  new LogDataImpl());
            Naming.bind("rmi://localhost:8888/OrderDataService",  new OrderDataImpl());
            Naming.bind("rmi://localhost:8888/PromotionDataService",  new PromotionDataImpl());
            Naming.bind("rmi://localhost:8888/UserDataService",  new UserDataImpl());
            Naming.bind("rmi://localhost:8888/WebsalerDataService",  new WebsalerDataImpl());

        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

package driver;

import dataservice.logdataservice.LogDataService;
import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * Created by user on 2016/11/5.
 */
public class ServerRunner {

//    public ServerRunner(){
//        initServer();
//    }
//
//    public static void main(String[] args) {
//        ServerRunner serverRunner = new ServerRunner();
//    }
//
//    /**
//     * 初始化服务器
//     */
//    public void initServer(){
//        LogDataService logDataService;
//        try {
//            LocateRegistry.createRegistry(8888);
//           // Naming.bind("rmi://localhost:8888/LogDataService", new LogDataImpl_stub());
//
//        } catch (RemoteException e) {
//            e.printStackTrace();
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (AlreadyBoundException e) {
//            e.printStackTrace();
//        }
//
//    }
}

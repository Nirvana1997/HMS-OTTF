package driver;

import data.factoryImpl.DataFactoryImpl;
import data.logdata.LogDataImpl;
import database.DataBaseHelper;
import dataservice.logdataservice.LogDataService;
import enumData.AccountType;
import po.AccountPO;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * Created by user on 2016/11/5.
 */
public class ServerRunner {

    public ServerRunner() throws UnknownHostException {
        initServer();
    }

    public static void main(String[] args) throws Exception {
        ServerRunner serverRunner = new ServerRunner();
    }

    /**
     * 初始化服务器
     */
    public void initServer() throws UnknownHostException {
        //自动获取本机IP地址
        InetAddress localhost = InetAddress.getLocalHost();
        System.out.println ("localhost: "+localhost.getHostAddress());
        System.out.println ("localhost: "+localhost.getHostName());
        String IP = localhost.getHostAddress();
        try {
            System.setProperty("java.rmi.server.hostname",IP);
            LocateRegistry.createRegistry(1099);
            Naming.bind("rmi://"+ IP +":1099/DataFactory", new DataFactoryImpl());

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

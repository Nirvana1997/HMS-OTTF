package driver;

import dataservice.logdataservice.LogDataService;
import rmi.RemoteHelper;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * @author <qzh></qzh>
 * Created by user on 2016/11/5.
 */
public class ClientRunner {
    /**
     * 连接服务器
     */
   RemoteHelper remoteHelper;

    /**
     * 是否连接到服务器
     */
    boolean connected = false;

    public static void main(String[] arg0){
        ClientRunner clientRunner = new ClientRunner();
    }

    public ClientRunner(){
        remoteHelper = RemoteHelper.getInstance();
    }

    /**
     * 是否连接到服务器
     * @return connected
     */
    public boolean hasConnected(){
        return connected;
    }

}

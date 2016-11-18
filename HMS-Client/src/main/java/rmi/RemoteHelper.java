package rmi;

import dataservice.logdataservice.LogDataService;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 连接服务器并提供服务
 * Created by user on 2016/11/6.
 */
public class RemoteHelper {
    private Remote remote;
    private static RemoteHelper remoteHelper = new RemoteHelper();
    /**
     * 是否连接到服务器
     */
    boolean connected = false;

    private LogDataService logDataService;

    /**
     * 获得用例
     * @return remoteHelper
     */
    public static RemoteHelper getInstance(){
        return remoteHelper;
    }

    private RemoteHelper() {
        linkToServer();
    }

    public void setRemote(Remote remote){
        this.remote = remote;
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
}

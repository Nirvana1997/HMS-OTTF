package data.factoryImpl;

import data.companydata.CompanyDataImpl;
import data.hotelsalerdata.HotelinfoDataImpl;
import data.hotelsalerdata.HotelroomDataImpl;
import data.logdata.LogDataImpl;
import data.orderdata.OrderDataImpl;
import data.promotiondata.PromotionDataImpl;
import data.userdata.UserDataImpl;
import data.websalerdata.WebsalerDataImpl;
import dataservice.companydataservice.CompanyDataService;
import dataservice.factory.DataFactory;
import dataservice.hotelsalerdataservice.HotelinfoDataService;
import dataservice.hotelsalerdataservice.HotelroomDataService;
import dataservice.logdataservice.LogDataService;
import dataservice.orderdataservice.OrderDataService;
import dataservice.promotiondataservice.PromotionDataService;
import dataservice.userdataservice.UserDataService;
import dataservice.websalerdataservice.WebsalerDataService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by mac on 2016/12/19.
 */
public class DataFactoryImpl extends UnicastRemoteObject implements DataFactory {
    public DataFactoryImpl() throws RemoteException {
    }

    @Override
    public HotelinfoDataService getHotelinfoDataImpl() throws Exception {
        return new HotelinfoDataImpl();
    }

    @Override
    public HotelroomDataService getHotelroomDataImpl() throws RemoteException {
        return new HotelroomDataImpl();
    }

    @Override
    public LogDataService getLogDataImpl() throws Exception {
        return new LogDataImpl();
    }

    @Override
    public OrderDataService getOrderDataImpl() throws RemoteException {
        return new OrderDataImpl();
    }

    @Override
    public PromotionDataService getPromotionDataImpl() throws RemoteException {
        return new PromotionDataImpl();
    }

    @Override
    public UserDataService getUserDataImpl() throws Exception {
        return new UserDataImpl();
    }

    @Override
    public WebsalerDataService getWebsalerDataImpl() throws Exception {
        return new WebsalerDataImpl();
    }

    @Override
    public CompanyDataService getCompanyDataImpl() throws Exception {
        return new CompanyDataImpl();
    }
}

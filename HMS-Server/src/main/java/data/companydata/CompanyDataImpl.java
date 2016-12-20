package data.companydata;

import database.DataBaseHelper;
import dataservice.companydataservice.CompanyDataService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 * Created by mac on 2016/12/20.
 */
public class CompanyDataImpl extends UnicastRemoteObject implements CompanyDataService {
    public CompanyDataImpl() throws RemoteException {
    }

    /**
     * 得到所有合作企业的名称
     * @return
     */
    @Override
    public ArrayList<String> getAllCompanyName() {
        ArrayList<String> nameList = DataBaseHelper.outSelect("CompanyInfo","name");
        return nameList;
    }

    /**
     * 根据企业ID，返回企业对应名称
     * @param companyID
     * @return
     */
    @Override
    public String getCompanyName(String companyID) {
        String name = DataBaseHelper.outSingle("CompanyInfo","name","ID",companyID);
        return name;
    }

    /**
     * 根据企业名称，返回企业对应ID
     * @param companyName
     * @return
     */
    @Override
    public String getCompanyID(String companyName) {
        String ID = DataBaseHelper.outSingle("CompanyInfo","ID","name",companyName);
        return ID;
    }
}

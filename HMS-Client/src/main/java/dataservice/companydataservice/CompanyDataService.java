package dataservice.companydataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by mac on 2016/12/20.
 */
public interface CompanyDataService extends Remote{
    /**
     * 得到所有合作企业的名称
     * @return 企业名称列表
     */
    public ArrayList<String> getAllCompanyName()throws RemoteException;

    /**
     * 根据企业ID，返回企业对应名称
     * @param companyID
     * @return 企业名称
     */
    public String getCompanyName(String companyID)throws RemoteException;

    /**
     * 根据企业名称，返回企业对应ID
     * @param companyName
     * @return
     */
    public String getCompanyID(String companyName)throws RemoteException;
}

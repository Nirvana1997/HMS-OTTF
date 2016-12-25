package businesslogic.companybl;

import businesslogic.hotelsalerbl.HotelsalerCompanyInfo;
import businesslogic.logbl.UserCompanyInfo;
import dataservice.companydataservice.CompanyDataService;
import rmi.RemoteHelper;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * 企业数据
 * 负责取得企业ID和企业名称
 *
 * @author qzh
 *         Created by user on 2016/12/21.
 */
public class CompanyInfoImpl implements UserCompanyInfo,HotelsalerCompanyInfo {
    /**
     * 企业数据接口
     */
    CompanyDataService companyDataService;

    public CompanyInfoImpl() {
        companyDataService = RemoteHelper.getInstance().getCompanyDataService();
    }

    @Override
    public ArrayList<String> showAllCompanys() throws RemoteException {
        return companyDataService.getAllCompanyName();
    }

    @Override
    public String getCompanyID(String companyName) throws RemoteException {
        return companyDataService.getCompanyID(companyName);
    }

    @Override
    public boolean isCompanyIDCorrect(String companyID, String companyName) throws RemoteException {
        //公司名不存在或者ID不对应
        if(companyDataService.getCompanyID(companyName)==null||(!companyDataService.getCompanyID(companyName).equals(companyID)))
            return false;
        else {
            return true;
        }
    }
}

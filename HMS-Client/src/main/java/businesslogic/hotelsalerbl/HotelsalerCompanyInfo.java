package businesslogic.hotelsalerbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * 酒店营销人员企业数据接口
 *
 * @author qzh
 *         Created by user on 2016/12/21.
 */
public interface HotelsalerCompanyInfo {
    /**
     * 获得所有企业
     *
     * @return 所有企业名称
     * @throws RemoteException
     */
    public ArrayList<String> showAllCompanys() throws RemoteException;

    /**
     * 判断企业ID与企业名称是否对应
     *
     * @param companyName 企业名称
     * @return 是否对应
     * @throws RemoteException
     */
    public boolean getCompanyID(String companyName) throws RemoteException;
}

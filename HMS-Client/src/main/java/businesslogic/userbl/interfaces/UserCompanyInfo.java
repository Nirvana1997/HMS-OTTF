package businesslogic.userbl.interfaces;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * 企业用户信息接口
 * @author qzh
 * Created by user on 2016/12/21.
 */
public interface UserCompanyInfo {
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
     * @param companyID   企业ID
     * @param companyName 企业名称
     * @return 是否对应
     * @throws RemoteException
     */
    public boolean isCompanyIDCorrect(String companyID, String companyName) throws RemoteException;
}

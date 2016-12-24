package businesslogicservice.webmanagerblservice;

import java.rmi.RemoteException;

/**
 * 根据ID获得对应帐号接口
 *
 * @author qzh
 *         Created by user on 2016/12/15.
 */
public interface AccountBlService {
    /**
     * 根据ID获得对应帐号
     *
     * @param id 编号
     * @return 帐号
     * @throws RemoteException
     */
    public String getAccount(String id) throws RemoteException;
}

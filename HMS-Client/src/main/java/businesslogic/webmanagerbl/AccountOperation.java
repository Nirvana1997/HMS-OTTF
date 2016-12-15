package businesslogic.webmanagerbl;

import businesslogic.logbl.impl.AccountDataImpl;
import businesslogicservice.webmanagerlogicservice.AccountBlService;

import java.rmi.RemoteException;

/**
 * 负责帐号相关操作
 * @author qzh
 * Created by user on 2016/12/15.
 */
public class AccountOperation {
    AccountInfo accountInfo;

    public AccountOperation() throws RemoteException {
        accountInfo = new AccountDataImpl();
    }

    public String getAccount(String id) throws RemoteException {
        return accountInfo.getAccount(id);
    }
}

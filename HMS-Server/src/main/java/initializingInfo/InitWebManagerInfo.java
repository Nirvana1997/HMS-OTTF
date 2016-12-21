package initializingInfo;

import data.logdata.LogDataImpl;
import database.DataBaseHelper;
import dataservice.logdataservice.LogDataService;
import enumData.AccountType;
import po.AccountPO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by mac on 2016/12/20.
 */
public class InitWebManagerInfo {
    public static void init() throws Exception {
        LogDataService logDataService = new LogDataImpl();
        ArrayList<String> num =DataBaseHelper.out("select account from Account where type = 'webmanager'","account");
        if(num.size()==0) {
            logDataService.addAccount(new AccountPO("0000001", "wm151250119", "123456", AccountType.webmanager));
            logDataService.addAccount(new AccountPO("0000002", "wm151250045", "123456", AccountType.webmanager));
            logDataService.addAccount(new AccountPO("0000003", "wm151250064", "123456", AccountType.webmanager));
            logDataService.addAccount(new AccountPO("0000004", "wm151250175", "123456", AccountType.webmanager));
        }
    }
}

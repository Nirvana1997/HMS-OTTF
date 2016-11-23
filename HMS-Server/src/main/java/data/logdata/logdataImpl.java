package data.logdata;

import dataservice.logdataservice.LogDataService;
import enumData.AccountType;
import enumData.ResultMessage;
import po.AccountPO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by mac on 2016/11/23.
 */
public class LogDataImpl implements LogDataService {
    @Override
    public String getPassword(String account) throws RemoteException {
        return null;
    }

    @Override
    public ResultMessage setPassword(String account) throws RemoteException {
        return null;
    }

    @Override
    public ArrayList<AccountPO> getAccountList(AccountType accountType) throws RemoteException {
        return null;
    }

    @Override
    public ResultMessage addAccount(AccountPO po) throws RemoteException {
        return null;
    }

    @Override
    public ResultMessage deleteAccount(String account) throws RemoteException {
        return null;
    }

    @Override
    public AccountType getAccountType(String account) throws RemoteException {
        return null;
    }

    @Override
    public ResultMessage hasExisted(String account) throws RemoteException {
        return null;
    }
}

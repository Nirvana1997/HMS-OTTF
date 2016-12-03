package businesslogic.logbl.impl;

import businesslogic.webmanagerbl.AccountList;
import data_stub.logdata.LogDataImpl_stub;
import dataservice.logdataservice.LogDataService;
import enumData.AccountType;
import po.AccountPO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * 获取账户列表
 * @author qzh
 * Created by user on 2016/12/3.
 */
public class AccountListImpl implements AccountList{
    /**
     * 帐号数据模块
     */
    private LogDataService logDataService;

    public AccountListImpl() throws RemoteException {
        //TODO
        this.logDataService = new LogDataImpl_stub();
    }

    /**
     * 返回对应类型的帐号列表
     * @param accountType 帐号类型
     * @return 帐号列表
     */
    @Override
    public ArrayList<String> getList(AccountType accountType)throws RemoteException{
        ArrayList<String> res = new ArrayList<String>();
        for(AccountPO po:logDataService.getAccountList(accountType)){
            res.add(po.getAccountID());
        }
        return res;
    }
}

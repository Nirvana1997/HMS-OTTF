package businesslogic.logbl.impl;

import businesslogic.logbl.Register;
import businesslogic.webmanagerbl.AccountInfo;
import data_stub.logdata.LogDataImpl_stub;
import dataservice.logdataservice.LogDataService;
import enumData.AccountType;
import po.AccountPO;
import utility.AccountPVChanger;
import vo.AccountVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * 帐号数据接口实现
 * @author qzh
 * Created by user on 2016/12/3.
 */
public class AccountDataImpl implements AccountInfo {
    /**
     * 帐号数据模块
     */
    private LogDataService logDataService;

    /**
     * 注册模块
     */
    private Register register;

    public AccountDataImpl() throws RemoteException {
        //TODO
        this.logDataService = new LogDataImpl_stub();
        register = new Register();
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
            res.add(po.getAccount());
        }
        return res;
    }

    /**
     * 添加帐号
     *
     * @param account 帐号
     * @param password 密码
     * @param accountType 帐号类型
     * @throws RemoteException
     */
    public void addAccount(String account,String password,AccountType accountType) throws RemoteException {
        register.register(new AccountVO(account,password,accountType));
    }

    @Override
    public void deleteAccount(String id) throws RemoteException {
        logDataService.deleteAccount(id);
    }

    @Override
    public String getID(String account) throws RemoteException {
        return logDataService.getID(account);
    }

    @Override
    public String getAccount(String id) throws RemoteException {
        return logDataService.getAccount(id);
    }

}

package businesslogic.logbl.impl;

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

    public AccountDataImpl() throws RemoteException {
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

    /**
     * 添加帐号
     * @param vo 帐号vo
     * @throws RemoteException
     */
    @Override
    public void addAccount(AccountVO vo) throws RemoteException {
        logDataService.addAccount(AccountPVChanger.accountV2P(vo));
    }

}

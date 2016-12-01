package data.logdata;

import database.DataBaseHelper;
import dataservice.logdataservice.LogDataService;
import enumData.AccountType;
import enumData.ResultMessage;
import po.AccountPO;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 * Created by mac on 2016/11/23.
 */
public class LogDataImpl extends UnicastRemoteObject implements LogDataService  {

    public LogDataImpl() throws RemoteException{
    }
    /**
     * 根据账户ID得到相应密码
     * @param account 帐号
     * @return
     * @throws RemoteException
     */
    @Override
    public String getPassword(String account) throws RemoteException {
        if(hasExisted(account)) {
            ArrayList<String> passwordList = DataBaseHelper.out("select password from Account where accountID = '" + account + "'", "password");
            return passwordList.get(0);
        }else {
            return null;
        }
    }

    /**
     * 根据账户ID修改相应密码
     * @param account 帐号
     * @param password
     * @return
     * @throws RemoteException
     */
    @Override
    public ResultMessage setPassword(String account,String password) throws RemoteException {
        if(hasExisted(account)){
            DataBaseHelper.in("update Account set password = '" + password + "' where accountID = '" + account +"'");
            return ResultMessage.Correct;
        }else {
            return ResultMessage.NotExist;
        }
    }

    /**
     * 根据账户类型，返回账户PO的LIST
     * @param accountType
     * @return
     * @throws RemoteException
     */
    @Override
    public ArrayList<AccountPO> getAccountList(AccountType accountType) throws RemoteException {
        String type = accountType.toString();
        ArrayList<String> accountIDList =  DataBaseHelper.out("select accountID from Account where type = '" + type +"'", "accountID");
        ArrayList<String> passwordList = DataBaseHelper.out("select password from Account where type = '" + type + "'", "password");
        ArrayList<AccountPO> accountPOArrayList = new ArrayList<AccountPO>();
        for(int i=0;i<accountIDList.size();i++)
            accountPOArrayList.add(new AccountPO(accountIDList.get(i),passwordList.get(i),accountType));
        return accountPOArrayList;
    }

    /**
     * 在数据库中增加一个账户
     * @param po
     * @return
     * @throws RemoteException
     */
    @Override
    public ResultMessage addAccount(AccountPO po) throws RemoteException {
        String accountID = po.getAccountID();
        String password = po.getPassword();
        String type = po.getType().toString();

        if(hasExisted(accountID))
            return ResultMessage.HasExist;

        DataBaseHelper.in("insert into Account (accountID,password,type) values (" +
                "'" + accountID + "','" + password + "','" + type + "')");
        return ResultMessage.Correct;
    }

    /**
     * 在数据库中删除一个账户
     * @param account
     * @return
     * @throws RemoteException
     */
    @Override
    public ResultMessage deleteAccount(String account) throws RemoteException {
        if(hasExisted(account)) {
            DataBaseHelper.in("delete from Account where accountID = '" + account + "'");
            return ResultMessage.Correct;
        }else
            return ResultMessage.NotExist;
    }

    /**
     * 根据账户ID得到相应账户类型
     * @param account
     * @return
     * @throws RemoteException
     */
    @Override
    public AccountType getAccountType(String account) throws RemoteException {
        if(hasExisted(account)) {
            ArrayList<String> typeList = DataBaseHelper.out("select type from Account where accountID = '" + account + "'", "type");
            try {
                return Enum.valueOf(AccountType.class,typeList.get(0).trim());
            }catch (IllegalArgumentException ex){
                ex.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 判断该账户在数据库中是否存在
     * @param account
     * @return
     * @throws RemoteException
     */
    @Override
    public boolean hasExisted(String account) throws RemoteException {
        ArrayList<String> accountIDList =  DataBaseHelper.out("select accountID from Account", "accountID");
        for(int i=0;i<accountIDList.size();i++)
            if(accountIDList.get(i).equals(account))
                return true;
        return  false;
    }
}

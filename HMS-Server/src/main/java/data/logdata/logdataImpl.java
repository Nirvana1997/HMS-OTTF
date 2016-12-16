package data.logdata;

import database.DataBaseHelper;
import dataservice.logdataservice.LogDataService;
import encryption.DesUtils;
import enumData.AccountType;
import enumData.ResultMessage;
import po.AccountPO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 * Created by mac on 2016/11/23.
 */
public class LogDataImpl extends UnicastRemoteObject implements LogDataService  {

    private DesUtils desUtils;

    public LogDataImpl() throws Exception{
        desUtils = new DesUtils();
    }
    /**
     * 根据账户ID得到相应密码
     * @param account 帐号
     * @return
     * @throws RemoteException
     */
    @Override
    public String getPassword(String account) throws RemoteException {
        account = desUtils.en(account);
        if(hasExisted(account)) {
            ArrayList<String> passwordList = DataBaseHelper.out("select password from Account where account = '" + account + "'", "password");
            String password = desUtils.de(passwordList.get(0));
            return password;
        }else {
            return null;
        }
    }

    /**
     * 根据帐号得到相应的ID
     * @param account 帐号
     * @return
     * @throws RemoteException
     */
    @Override
    public String getID(String account) throws RemoteException {
        String ID = DataBaseHelper.outSingle("Account","ID","account",account);
        return ID;
    }

    /**
     * 根据ID得到相应帐号
     * @param ID ID
     * @return
     * @throws RemoteException
     */
    @Override
    public String getAccount(String ID) throws RemoteException {
        String account = DataBaseHelper.outSingle("Account","account","ID",ID);
        return account;
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
        account = desUtils.en(account);
        password = desUtils.en(password);
        if(hasExisted(account)){
            DataBaseHelper.in("update Account set password = '" + password + "' where account = '" + account +"'");
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
        ArrayList<String> IDList = DataBaseHelper.out("select ID from Account where type = '" + type + "'","ID");
        ArrayList<String> accountList =  DataBaseHelper.out("select account from Account where type = '" + type +"'", "account");
        ArrayList<String> passwordList = DataBaseHelper.out("select password from Account where type = '" + type + "'", "password");
        ArrayList<AccountPO> accountPOArrayList = new ArrayList<AccountPO>();
        for(int i=0;i<IDList.size();i++) {
            String account = desUtils.de(accountList.get(i));
            String password = desUtils.de(passwordList.get(i));
            accountPOArrayList.add(new AccountPO(IDList.get(i), account, password, accountType));
        }
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
        String ID = po.getID();
        String account = desUtils.en(po.getAccount());
        String password = desUtils.en(po.getPassword());
        String type = po.getType().toString();

        if(hasExisted(account))
            return ResultMessage.HasExist;

        DataBaseHelper.in("insert into Account (ID,account,password,type) values ('" + ID + "','" +
                 account + "','" + password + "','" + type + "')");
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
        account = desUtils.en(account);
        if(hasExisted(account)) {
            DataBaseHelper.in("delete from Account where account = '" + account + "'");
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
        account = desUtils.en(account);
        if(hasExisted(account)) {
            ArrayList<String> typeList = DataBaseHelper.out("select type from Account where account = '" + account + "'", "type");
            try {
                return Enum.valueOf(AccountType.class,typeList.get(0).trim());
            }catch (IllegalArgumentException ex){
                ex.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 根据用户类型，返回该类型对应已有账号数量
     * @param type 帐号类型
     * @return
     * @throws RemoteException
     */
    @Override
    public int getTypeNum(AccountType type) throws RemoteException {
        ArrayList<String> num = DataBaseHelper.out("select account from Account where type = '" + type + "'","account");
        return num.size();
    }

    /**
     * 判断该账户在数据库中是否存在
     * @param account
     * @return
     * @throws RemoteException
     */
    @Override
    public boolean hasExisted(String account) throws RemoteException {
        ArrayList<String> accountList =  DataBaseHelper.out("select account from Account", "account");
        for(int i=0;i<accountList.size();i++)
            if(accountList.get(i).equals(account))
                return true;
        return  false;
    }
}

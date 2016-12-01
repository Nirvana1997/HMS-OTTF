package data.userdata;

import database.DataBaseHelper;
import dataservice.userdataservice.UserDataService;
import enumData.ResultMessage;
import po.UserInfoPO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by mac on 2016/11/23.
 */
public class UserDataImpl implements UserDataService {
    /**
     * 根据用户ID，返回用户信息
     * @param userID
     * @return
     * @throws RemoteException
     */
    @Override
    public UserInfoPO getUserInfo(String userID) throws RemoteException {
        if(hasExisted(userID)){
            ArrayList<String> name = DataBaseHelper.out("select name from UserInfo where userID = '" + userID + "'" ,"name");
            ArrayList<String> identity = DataBaseHelper.out("select identity from UserInfo where userID = '" + userID + "'" ,"identity");
            ArrayList<String> contactNumber = DataBaseHelper.out("select contactNumber from UserInfo where userID = '" + userID + "'" ,"contactNumber");
            ArrayList<String> credit = DataBaseHelper.out("select credit from UserInfo where userID = '" + userID + "'" ,"credit");
            ArrayList<String> transaction = DataBaseHelper.out("select transaction from UserInfo where userID = '" + userID + "'" ,"transaction");
            return new UserInfoPO(userID,name.get(0),identity.get(0),contactNumber.get(0),Integer.parseInt(credit.get(0)),Double.parseDouble(transaction.get(0)));
        }else
            return null;
    }

    /**
     * 修改用户信息
     * @param po
     * @return
     * @throws RemoteException
     */
    @Override
    public ResultMessage setUserInfo(UserInfoPO po) throws RemoteException {
        if(hasExisted(po.getUserID())){
            DataBaseHelper.in("update UserInfo set name = '" + po.getName() + "' where userID = '" + po.getUserID() +"'");
            DataBaseHelper.in("update UserInfo set identity = '" + po.getIdentity() + "' where userID = '" + po.getUserID() +"'");
            DataBaseHelper.in("update UserInfo set contactNumber = '" + po.getContactNumber() + "' where userID = '" + po.getUserID() +"'");
            DataBaseHelper.in("update UserInfo set credit = '" + po.getCredit() + "' where userID = '" + po.getUserID() +"'");
            DataBaseHelper.in("update UserInfo set transaction = '" + po.getTransaction() + "' where userID = '" + po.getUserID() +"'");
            return ResultMessage.Correct;
        }else
            return ResultMessage.NotExist;
    }

    /**
     * 新增用户信息
     * @param po
     * @return
     * @throws RemoteException
     */
    @Override
    public ResultMessage addUserInfo(UserInfoPO po) throws RemoteException {
        if(hasExisted(po.getUserID()))
            return ResultMessage.HasExist;
        DataBaseHelper.in("insert into UserInfo (userID,name,identity,contactNumber,credit,transaction) values (" +
                "'" + po.getUserID() + "','" + po.getName() + "','" + po.getIdentity() + "','" + po.getContactNumber()
                + "','" + po.getCredit() + "','" + po.getTransaction() + "')");
        return ResultMessage.Correct;
    }

    /**
     * 删除用户信息
     * @param userID
     * @return
     * @throws RemoteException
     */
    @Override
    public ResultMessage deleteUserInfo(String userID) throws RemoteException {
        if(hasExisted(userID)){
            DataBaseHelper.in("delete from UserInfo where userID = '" + userID + "'");
            return ResultMessage.Correct;
        }else
            return ResultMessage.NotExist;
    }

    /**
     * 增加用户信用值
     * @param userID
     * @param value
     * @return
     * @throws RemoteException
     */
    @Override
    public ResultMessage addCredit(String userID, int value) throws RemoteException {
        if(hasExisted(userID)) {
            ArrayList<String> credit = DataBaseHelper.out("select credit from UserInfo where userID ='" + userID + "'", "credit");
            int creditValue = Integer.parseInt(credit.get(0)) + value;
            DataBaseHelper.in("update UserInfo set credit = '" + creditValue + "' where userID = '" +userID + "'");
            return ResultMessage.Correct;
        }else
            return ResultMessage.NotExist;
    }

    /**
     * 减少用户信用值
     * @param userID
     * @param value
     * @return
     * @throws RemoteException
     */
    @Override
    public ResultMessage subCredit(String userID, int value) throws RemoteException {
        if(hasExisted(userID)) {
            ArrayList<String> credit = DataBaseHelper.out("select credit from UserInfo where userID ='" + userID + "'", "credit");
            int creditValue = Integer.parseInt(credit.get(0)) - value;
            DataBaseHelper.in("update UserInfo set credit = '" + creditValue + "' where userID = '" +userID + "'");
            return ResultMessage.Correct;
        }else
            return ResultMessage.NotExist;
    }

    /**
     * 判断存在
     * @param useID
     * @return
     * @throws RemoteException
     */
    private boolean hasExisted(String useID) throws RemoteException {
        ArrayList<String> userIDList =  DataBaseHelper.out("select userID from UserInfo", "userID");
        for(int i=0;i<userIDList.size();i++)
            if(userIDList.get(i).equals(useID))
                return true;
        return  false;
    }
}

package data.userdata;

import database.DataBaseHelper;
import dataservice.userdataservice.UserDataService;
import encryption.DesUtils;
import enumData.ResultMessage;
import enumData.UserType;
import po.CreditChangePO;
import po.CreditRecordPO;
import po.UserInfoPO;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 * Created by mac on 2016/11/23.
 */
public class UserDataImpl extends UnicastRemoteObject implements UserDataService {

    private DesUtils desUtils;

    public UserDataImpl() throws Exception {
        desUtils = new DesUtils();
    }

    /**
     * 根据用户ID，返回用户信息
     * @param userID
     * @return
     * @throws RemoteException
     */
    @Override
    public UserInfoPO getUserInfo(String userID) throws RemoteException {
        if(hasExisted(userID)){
            ArrayList<String> info = DataBaseHelper.outRow("UserInfo","userID",userID);
            UserType type = null;
            try {
                type = Enum.valueOf(UserType.class,info.get(7).trim());
            }catch (IllegalArgumentException ex){
                ex.printStackTrace();
            }
            String name = desUtils.de(info.get(1));
            String identity = desUtils.de(info.get(2));
            String contactNumber = desUtils.de(info.get(3));
            return new UserInfoPO(info.get(0),name,identity,contactNumber,Integer.parseInt(info.get(4)),
                    info.get(5),info.get(6),type);
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
            String name = desUtils.en(po.getName());
            String identity = desUtils.en(po.getIdentity());
            String contactNumber = desUtils.en(po.getContactNumber());
            DataBaseHelper.in("update UserInfo set name = '" + name + "' where userID = '" + po.getUserID() +"'");
            DataBaseHelper.in("update UserInfo set identity = '" + identity + "' where userID = '" + po.getUserID() +"'");
            DataBaseHelper.in("update UserInfo set contactNumber = '" + contactNumber + "' where userID = '" + po.getUserID() +"'");
            DataBaseHelper.in("update UserInfo set credit = '" + po.getCredit() + "' where userID = '" + po.getUserID() +"'");
            DataBaseHelper.in("update UserInfo set birthday = '" + po.getBirthday() + "' where userID = '" + po.getUserID() +"'");
            DataBaseHelper.in("update UserInfo set companyID = '" + po.getCompanyID() + "' where userID = '" + po.getUserID() +"'");
            DataBaseHelper.in("update UserInfo set type = '" + po.getType().toString() + "' where userID = '" + po.getUserID() +"'");
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
        //创建信用记录表
        DataBaseHelper.in("create table " + po.getUserID() + "_credit" + "( date varchar(50),changes varchar(50),finalCredit varchar(50)," +
                "reason varchar(50),orderID varchar(20) )");

        String name = desUtils.en(po.getName());
        String identity = desUtils.en(po.getIdentity());
        String contactNumber = desUtils.en(po.getContactNumber());

        DataBaseHelper.in("insert into UserInfo (userID,name,identity,contactNumber,credit,birthday,companyID,type) values (" +
                "'" + po.getUserID() + "','" + name + "','" + identity + "','" + contactNumber
                + "','" + po.getCredit() + "','" + po.getBirthday() + "','" + po.getCompanyID()
                + "','" + po.getType().toString()  + "')");
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
            DataBaseHelper.in("drop table " + userID + "_credit");
            return ResultMessage.Correct;
        }else
            return ResultMessage.NotExist;
    }

    /**
     * 得到用户信息列表（所有用户）
     * @return
     * @throws RemoteException
     */
    @Override
    public ArrayList<UserInfoPO> getUserInfoList() throws RemoteException {
        ArrayList<UserInfoPO> userInfoPOs = new ArrayList<UserInfoPO>();
        ArrayList<String> userIDList = DataBaseHelper.out("select userID from UserInfo","userID");
        ArrayList<String> nameList = DataBaseHelper.out("select name from UserInfo","name");
        ArrayList<String> identityList = DataBaseHelper.out("select identity from UserInfo","identity");
        ArrayList<String> contactNumberList = DataBaseHelper.out("select contactNumber from UserInfo","contactNumber");
        ArrayList<String> creditList = DataBaseHelper.out("select credit from UserInfo","credit");
        ArrayList<String> birthdayList = DataBaseHelper.out("select birthday from UserInfo","birthday");
        ArrayList<String> companyIDList = DataBaseHelper.out("select companyID from UserInfo","companyID");
        ArrayList<String> typeList = DataBaseHelper.out("select type from UserInfo","type");

        for(int i=0;i<userIDList.size();i++){
            UserType type = null;
            try {
                type = Enum.valueOf(UserType.class,typeList.get(i).trim());
            }catch (IllegalArgumentException ex){
                ex.printStackTrace();
            }
            String name = desUtils.de(nameList.get(i));
            String identity = desUtils.de(identityList.get(i));
            String contactNumber = desUtils.de(contactNumberList.get(i));

            userInfoPOs.add(new UserInfoPO(userIDList.get(i),name,identity,contactNumber,
                    Integer.parseInt(creditList.get(i)),birthdayList.get(i),companyIDList.get(i),type));
        }

        return userInfoPOs;
    }

    /**
     * 增加用户信用值
     * @param po
     * @return
     * @throws RemoteException
     */
    @Override
    public ResultMessage addCredit(CreditChangePO po) throws RemoteException {
        if(hasExisted(po.getUserID())) {
            String credit = DataBaseHelper.outSingle("UserInfo","credit","userID",po.getUserID());
            int finalCredit = Integer.parseInt(credit) + po.getValue();
            DataBaseHelper.in("insert into " + po.getUserID() + "_credit (date,changes,finalCredit,reason,orderID) values ('" + po.getDate() + "','" + po.getValue() + "','"
                    + finalCredit + "','" + po.getReason() + "','" + po.getOrderID() +  "')");
            DataBaseHelper.in("update UserInfo set credit = '" + finalCredit + "' where userID = '" + po.getUserID() + "'");
            return ResultMessage.Correct;
        }else
            return ResultMessage.NotExist;
    }

    /**
     * 减少用户信用值
     * @param po
     * @return
     * @throws RemoteException
     */
    @Override
    public ResultMessage subCredit(CreditChangePO po) throws RemoteException {
        CreditChangePO temp = po;
        temp.setValue(0 - temp.getValue());
        return addCredit(temp);
    }

    /**
     * 查看信用记录
     * @param userID
     * @return
     * @throws RemoteException
     */
    @Override
    public ArrayList<CreditRecordPO> checkCreditRecord(String userID) throws RemoteException {
        ArrayList<CreditRecordPO> creditRecordPOs = new ArrayList<CreditRecordPO>();
        ArrayList<String> dateList = DataBaseHelper.out("select date from " + userID + "_credit","date");
        ArrayList<String> changeList = DataBaseHelper.out("select changes from " + userID + "_credit","changes");
        ArrayList<String> finalCreditList = DataBaseHelper.out("select finalCredit from " + userID + "_credit","finalCredit");
        ArrayList<String> reasonList = DataBaseHelper.out("select reason from " + userID + "_credit","reason");
        ArrayList<String> orderIDList = DataBaseHelper.out("select orderID from " + userID + "_credit","orderID");
        for(int i=0;i<dateList.size();i++){
            creditRecordPOs.add(new CreditRecordPO(dateList.get(i),Integer.parseInt(changeList.get(i)),Integer.parseInt(finalCreditList.get(i)),reasonList.get(i),orderIDList.get(i)));
        }
        return creditRecordPOs;
    }

    /**
     * 得到当前用户ID的总数+1
     * @return
     * @throws RemoteException
     */
    @Override
    public int getCurrentUserID() throws RemoteException {
        ArrayList<String> num = DataBaseHelper.out("select userID from UserInfo","userID");
        return num.size() + 1;
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

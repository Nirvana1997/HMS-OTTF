package initializingInfo;

import database.DataBaseHelper;

/**
 * Created by mac on 2016/12/20.
 */
public class InitCompanyInfo {
    public static void init(){
        if(!DataBaseHelper.in("show tables like 'CompanyInfo'")) {
            DataBaseHelper.in("create table CompanyInfo (ID varchar(20),name varchar(50) )");
            DataBaseHelper.in("insert into CompanyInfo (ID,name) values ('1000001','zh酒吧')");
            DataBaseHelper.in("insert into CompanyInfo (ID,name) values ('1000002','志豪食品公司')");
            DataBaseHelper.in("insert into CompanyInfo (ID,name) values ('1000003','喋喋网络公司')");
            DataBaseHelper.in("insert into CompanyInfo (ID,name) values ('1000004','组长汽车公司')");
        }
    }
}

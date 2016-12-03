package data.websalerdata;

import database.DataBaseHelper;
import dataservice.websalerdataservice.WebsalerDataService;
import enumData.ResultMessage;
import po.WebsalerInfoPO;

import java.util.ArrayList;

/**
 * Created by mac on 2016/11/23.
 */
public class WebsalerDataImpl implements WebsalerDataService{
    /**
     * 根据网站营销人员ID，获取网站营销人员信息
     * @param websalerID
     * @return
     */
    @Override
    public WebsalerInfoPO getWebsalerInfo(String websalerID) {
        ArrayList<String> info = DataBaseHelper.outRow("WebsalerInfo","websalerID" ,websalerID);
        return new WebsalerInfoPO(websalerID,info.get(1));
    }

    /**
     * 修改网站营销人员信息
     * @param po
     * @return
     */
    @Override
    public ResultMessage setWebsalerInfo(WebsalerInfoPO po) {
        DataBaseHelper.in("update WebsalerInfo set contactNumber = '" + po.getContactNumber() + "' where websalerID = '" + po.getWebsalerID() +"'");
        return ResultMessage.Correct;
    }

    /**
     * 添加网站营销人员信息
     * @param po
     * @return
     */
    @Override
    public ResultMessage addWebsalerInfo(WebsalerInfoPO po) {
        if(!hasExisted(po.getWebsalerID())){
            DataBaseHelper.in("insert into WebsalerInfo (websalerID,contactNumber) values ('" + po.getWebsalerID() + "','" + po.getContactNumber() + "')");
            return ResultMessage.Correct;
        }else
            return ResultMessage.HasExist;
    }

    /**
     * 删除网站营销人员信息
     * @param websalerID
     * @return
     */
    @Override
    public ResultMessage deleteWebsalerInfo(String websalerID) {
       if(hasExisted(websalerID)){
           DataBaseHelper.in("delete from WebsalerInfo where websalerID = '" + websalerID + "'");
           return ResultMessage.Correct;
       }else
           return ResultMessage.NotExist;
    }

    /**
     * 判断存在
     * @param websalerID
     * @return
     */
    private boolean hasExisted (String websalerID){
        ArrayList<String> websalerIDList =  DataBaseHelper.out("select websalerID from WebsalerInfo", "websalerID");
        for(int i=0;i<websalerIDList.size();i++)
            if(websalerIDList.get(i).equals(websalerID))
                return true;
        return  false;
    }
}

package data.websalerdata;

import database.DataBaseHelper;
import dataservice.websalerdataservice.WebsalerDataService;
import encryption.DesUtils;
import enumData.ResultMessage;
import po.VipUpPO;
import po.WebsalerInfoPO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 * Created by mac on 2016/11/23.
 */
public class WebsalerDataImpl extends UnicastRemoteObject implements WebsalerDataService{

    private DesUtils desUtils;

    public WebsalerDataImpl() throws Exception {
        desUtils = new DesUtils();
    }

    /**
     * 根据网站营销人员ID，获取网站营销人员信息
     * @param websalerID
     * @return
     */
    @Override
    public WebsalerInfoPO getWebsalerInfo(String websalerID) {
        ArrayList<String> info = DataBaseHelper.outRow("WebsalerInfo","websalerID" ,websalerID);
        String contactNumber = desUtils.de(info.get(1));
        return new WebsalerInfoPO(websalerID,contactNumber);
    }

    /**
     * 修改网站营销人员信息
     * @param po
     * @return
     */
    @Override
    public ResultMessage setWebsalerInfo(WebsalerInfoPO po) {
        String contactNumber = desUtils.en(po.getContactNumber());
        DataBaseHelper.in("update WebsalerInfo set contactNumber = '" + contactNumber + "' where websalerID = '" + po.getWebsalerID() +"'");
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
            String contactNumber = desUtils.en(po.getContactNumber());
            DataBaseHelper.in("insert into WebsalerInfo (websalerID,contactNumber) values ('" + po.getWebsalerID() + "','" + contactNumber + "')");
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
     * 得到网站营销人员信息列表（所有营销人员）
     * @return
     * @throws RemoteException
     */
    @Override
    public ArrayList<WebsalerInfoPO> getWebsalerInfoList() throws RemoteException {
        ArrayList<WebsalerInfoPO> websalerInfoPOs = new ArrayList<WebsalerInfoPO>();
        ArrayList<String> websalerIDList  = DataBaseHelper.out("select websalerID from WebsalerInfo","websalerID");
        ArrayList<String> contactNumberList  = DataBaseHelper.out("select contactNumber from WebsalerInfo","contactNumber");
        for(int i=0;i<websalerIDList.size();i++){
            String contactNumber = desUtils.de(contactNumberList.get(i));
            websalerInfoPOs.add(new WebsalerInfoPO(websalerIDList.get(i),contactNumber));
        }
        return websalerInfoPOs;
    }

    /**
     * 修改会员升级列表
     * @param po
     * @return
     */
    @Override
    public ResultMessage setVipUpInfo(VipUpPO po) {
        DataBaseHelper.in("update VipUpInfo set credit = '" + po.getCredit() + "' where vipLevel = '" + po.getVipLevel() + "'");
        return ResultMessage.Correct;
    }

    /**
     * 查看会员升级列表
     * @return
     */
    @Override
    public ArrayList<VipUpPO> checkVipUpInfo() {
        ArrayList<VipUpPO> vipUpPOs = new ArrayList<VipUpPO>();
        ArrayList<String> vipLevelList = DataBaseHelper.out("select vipLevel from VipUpInfo","vipLevel");
        ArrayList<String> creditList = DataBaseHelper.out("select credit from VipUpInfo","credit");
        for(int i=0;i<vipLevelList.size();i++){
            vipUpPOs.add(new VipUpPO(Integer.parseInt(vipLevelList.get(i)),Integer.parseInt(creditList.get(i))));
        }
        return vipUpPOs;
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

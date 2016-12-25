package businesslogic.websalerbl.impl;

import businesslogic.webmanagerbl.WebsalerInfoForManagement;
import dataservice.websalerdataservice.WebsalerDataService;
import po.WebsalerInfoPO;
import rmi.RemoteHelper;
import utility.WebsalerPVChanger;
import vo.WebsalerInfoVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * 网站营销人员数据接口实现
 *
 * @author qzh
 *         Created by user on 2016/12/9.
 */
public class WebsalerInfoImpl implements WebsalerInfoForManagement{
    WebsalerDataService websalerDataService;

    public WebsalerInfoImpl() throws RemoteException{
        //TODO
//        this.websalerDataService = new WebsalerDataImpl_stub();
        websalerDataService = RemoteHelper.getInstance().getWebsalerDataService();
    }

    @Override
    public ArrayList<WebsalerInfoVO> getWebsalerInfoList() throws RemoteException {
        ArrayList<WebsalerInfoVO> res = new ArrayList<WebsalerInfoVO>();
        for(WebsalerInfoPO po:websalerDataService.getWebsalerInfoList()){
            res.add(WebsalerPVChanger.websalerInfoP2V(po));
        }
        return res;
    }

    @Override
    public WebsalerInfoVO getWebsalerInfo(String websalerID) throws RemoteException {
        return WebsalerPVChanger.websalerInfoP2V(websalerDataService.getWebsalerInfo(websalerID));
    }

    @Override
    public void setWebsalerInfo(WebsalerInfoVO vo) throws RemoteException {
        websalerDataService.setWebsalerInfo(WebsalerPVChanger.websalerInfoV2P(vo));
    }

    @Override
    public void addWebsalerInfo(WebsalerInfoVO vo) throws RemoteException {
        websalerDataService.addWebsalerInfo(WebsalerPVChanger.websalerInfoV2P(vo));
    }

    @Override
    public void deleteWebsalerInfo(String websalerID) throws RemoteException {
        websalerDataService.deleteWebsalerInfo(websalerID);
    }
}

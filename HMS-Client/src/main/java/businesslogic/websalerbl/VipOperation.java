package businesslogic.websalerbl;

import dataservice.websalerdataservice.WebsalerDataService;
import po.VipUpPO;
import rmi.RemoteHelper;
import utility.VipUpPVChanger;
import vo.VipUpVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * 会员等级规则制定模块
 * @author qzh
 * Created by user on 2016/12/22.
 */
public class VipOperation {
    WebsalerDataService websalerDataService;

    public VipOperation() {
        websalerDataService = RemoteHelper.getInstance().getWebsalerDataService();
    }

    /**
     * 获得每级会员所需要的信用值
     *
     * @return 获得信用值列表
     * @throws RemoteException
     */
    public ArrayList<VipUpVO> getVipInfos() throws RemoteException{
        ArrayList<VipUpVO> res = new ArrayList<>();
        for(VipUpPO po:websalerDataService.checkVipUpInfo()){
            res.add(VipUpPVChanger.vipUPP2V(po));
        }
        return res;
    }

    /**
     * 设置每级会员升级所需信用值
     *
     * @param vipInfos vip信用值列表
     * @throws RemoteException
     */
    public void setVipInfos(ArrayList<VipUpVO> vipInfos) throws RemoteException{
        for(VipUpVO vo:vipInfos){
            websalerDataService.setVipUpInfo(VipUpPVChanger.vipUPV2P(vo));
        }

    }
}

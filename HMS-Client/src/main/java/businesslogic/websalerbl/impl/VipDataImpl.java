package businesslogic.websalerbl.impl;

import rmi.RemoteHelper;
import utility.VipInfo;
import data_stub.websalerdata.WebsalerDataImpl_stub;
import dataservice.websalerdataservice.WebsalerDataService;
import po.VipUpPO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * 会员等级信息接口实现
 * @author qzh
 * Created by user on 2016/12/3.
 */
public class VipDataImpl implements VipInfo{
    /**
     * 网站营销人员数据接口
     */
    WebsalerDataService websalerDataService;

    public VipDataImpl() {
        websalerDataService = RemoteHelper.getInstance().getWebsalerDataService();
    }

    /**
     * 计算会员等级
     * @param credit 信用值
     * @return 会员等级
     * @throws RemoteException
     */
    @Override
    public int calcLevel(int credit) throws RemoteException {
        ArrayList<VipUpPO> vipLevels = websalerDataService.checkVipUpInfo();
        int res = 0;
        for(int i=vipLevels.size()-1;i>=0;i--){
            if(credit>vipLevels.get(i).getCredit()){
                res = i + 1;
                break;
            }
        }
        return res;
    }
}

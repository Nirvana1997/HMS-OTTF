package businesslogic.websalerbl.impl;

import businesslogic.userbl.interfaces.VipInfo;
import data_stub.websalerdata.WebsalerDataImpl_stub;
import dataservice.websalerdataservice.WebsalerDataService;
import po.CreditRecordPO;

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
    WebsalerDataService websalerDataService = new WebsalerDataImpl_stub();

    /**
     * 计算会员等级
     * @param credit 信用值
     * @return 会员等级
     * @throws RemoteException
     */
    @Override
    public int calcLevel(Double credit) throws RemoteException {
        ArrayList<CreditRecordPO> vipLevels = websalerDataService.getVipList();
        int res = 0;
        for(int i=vipLevels.size()-1;i>=0;i--){
            if(credit>vipLevels.get(i).getFinalCredit()){
                res = i + 1;
                break;
            }
        }
        return res;
    }
}

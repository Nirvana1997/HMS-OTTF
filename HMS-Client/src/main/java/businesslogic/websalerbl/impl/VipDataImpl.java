package businesslogic.websalerbl.impl;

import businesslogic.userbl.VipInfo;
import data_stub.websalerdata.WebsalerDataImpl_stub;
import dataservice.websalerdataservice.WebsalerDataService;

import java.rmi.RemoteException;

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
     * @param transaction 交易总额
     * @return 会员等级
     * @throws RemoteException
     */
    @Override
    public int calcLevel(Double transaction) throws RemoteException {
        return 0;
    }
}

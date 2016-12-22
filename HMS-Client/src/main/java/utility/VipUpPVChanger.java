package utility;

import po.VipUpPO;
import vo.VipUpVO;

/**
 * Created by user on 2016/12/22.
 */
public class VipUpPVChanger {
    public static VipUpPO vipUPV2P(VipUpVO vo){
        return new VipUpPO(vo.getVipLevel(),vo.getCredit());
    }

    public static VipUpVO vipUPP2V(VipUpPO po){
        return new VipUpVO(po.getVipLevel(),po.getCredit());
    }
}

package utility;

import po.UserInfoPO;
import vo.UserInfoVO;

/**
 * 实现PO和VO的互相转化
 * Created by user on 2016/12/3.
 */
public class PVChanger {
    private static PVChanger pvChanger;

    private PVChanger(){}

    public static PVChanger getInstance() {
        if(pvChanger==null)
            pvChanger = new PVChanger();
        return pvChanger;
    }

    /**
     * 用户信息VO转PO
     * @param vo 用户信息VO
     * @return 用户信息PO
     */
    public UserInfoPO userInfoV2P(UserInfoVO vo){
        return new UserInfoPO(vo.getUserID(),vo.getName(),vo.getIdentity(),vo.getContactNumber(),vo.getCredit(),vo.getTransaction());
    }
}

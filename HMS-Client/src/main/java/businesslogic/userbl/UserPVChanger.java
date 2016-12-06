package businesslogic.userbl;

import po.UserInfoPO;
import vo.UserInfoVO;

/**
 * 实现PO和VO的互相转化
 * @author qzh
 * Created by user on 2016/12/3.
 */
public class UserPVChanger {
    private static UserPVChanger pvChanger;

    private UserPVChanger(){}

    public static UserPVChanger getInstance() {
        if(pvChanger==null)
            pvChanger = new UserPVChanger();
        return pvChanger;
    }

    /**
     * 用户信息VO转PO
     * @param vo 用户信息VO
     * @return 用户信息PO
     */
    public UserInfoPO userInfoV2P(UserInfoVO vo){
        return new UserInfoPO(vo.getUserID(),vo.getName(),vo.getIdentity(),vo.getContactNumber(),vo.getCredit());
    }

    /**
     * 用户信息PO转VO
     * @param po 用户信息PO
     * @param vipLevel 会员等级
     * @return 用户信息VO
     */
    public UserInfoVO userInfoP2V(UserInfoPO po,int vipLevel){
        return new UserInfoVO(po.getUserID(),po.getName(),po.getIdentity(),po.getContactNumber(),po.getCredit(),vipLevel);
    }


}

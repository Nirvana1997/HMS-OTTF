package utility;

import businesslogic.websalerbl.impl.VipInfoImpl;
import po.UserInfoPO;
import vo.UserInfoVO;

import java.rmi.RemoteException;

/**
 * 实现PO和VO的互相转化
 *
 * @author qzh
 *         Created by user on 2016/12/3.
 */
public class UserPVChanger {
    static VipInfo vipInfo = new VipInfoImpl();

    public UserPVChanger() {
//        vipInfo = ;
    }

    /**
     * 用户信息VO转PO
     *
     * @param vo 用户信息VO
     * @return 用户信息PO
     */
    public static UserInfoPO userInfoV2P(UserInfoVO vo) {
        if(vo==null){
            return null;
        }
        return new UserInfoPO(vo.getUserID(), vo.getName(), vo.getIdentity(), vo.getContactNumber(), vo.getCredit(), vo.getBirthday(), vo.getCompanyID()!=null?vo.getCompanyID():null, vo.getUserType());
    }

    /**
     * 用户信息PO转VO
     *
     * @param po 用户信息PO
     * @return 用户信息VO
     */
    public static UserInfoVO userInfoP2V(UserInfoPO po) throws RemoteException {
        if(po==null){
            return null;
        }
        int vipLevel = vipInfo.calcLevel(po.getCredit());
        return new UserInfoVO(po.getUserID(), po.getName(), po.getIdentity(), po.getContactNumber(), po.getCredit(), po.getBirthday(), po.getCompanyID(), po.getType(), vipLevel);
    }


}

package utility;

import po.AccountPO;
import vo.AccountVO;

/**
 * 帐号PO、VO转化
 * Created by user on 2016/12/11.
 */
public class AccountPVChanger {
    public static AccountPO accountV2P(AccountVO vo){
        return new AccountPO(vo.getID(),vo.getID(),vo.getPassword(),vo.getType());
    }

    public static AccountVO accountP2V(AccountPO po){
        return new AccountVO(po.getID(),po.getID(),po.getPassword(),po.getType());
    }
}

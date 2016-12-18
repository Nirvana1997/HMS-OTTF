package utility;

import po.CreditRecordPO;
import vo.CreditRecordVO;

/**
 * 信用变化记录PO、VO转化
 * @author qzh
 * Created by user on 2016/12/18.
 */
public class CreditRecordPVChanger {
    public static CreditRecordPO creditRecordV2P(CreditRecordVO vo){
        if(vo==null){
            return null;
        }
        return new CreditRecordPO(vo.getDate(),vo.getChange(),vo.getFinalCredit(),vo.getReason(),vo.getOrderID());
    }

    public static CreditRecordVO creditRecordP2V(CreditRecordPO po){
        if(po==null){
            return null;
        }
        return new CreditRecordVO(po.getDate(),po.getChange(),po.getFinalCredit(),po.getReason(),po.getOrderID());
    }
}

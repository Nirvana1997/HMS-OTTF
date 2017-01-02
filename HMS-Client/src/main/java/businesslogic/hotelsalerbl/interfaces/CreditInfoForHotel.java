package businesslogic.hotelsalerbl.interfaces;

import enumData.ResultMessage;
import po.CreditChangePO;

import java.rmi.RemoteException;

/**
 * 信用值增加接口
 * Created by user on 2016/12/17.
 */
public interface CreditInfoForHotel {
    /**
     * 为用户增加信用值
     *
     * @param po 信用值变化情况
     * @return 是否成功
     */
    public ResultMessage addCredit(CreditChangePO po) throws RemoteException;

}

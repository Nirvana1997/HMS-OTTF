package businesslogic.webmanagerbl;

import businesslogicservice.webmanagerlogicservice.HSmanagementBlService;
import data_stub.logdata.LogDataImpl_stub;
import dataservice.logdataservice.LogDataService;
import enumData.AccountType;
import enumData.ResultMessage;
import po.AccountPO;
import vo.HotelsalerInfoVO;

import java.rmi.RemoteException;

/**
 * 酒店人员管理模块
 * @author qzh
 */
public class HSmanagement implements HSmanagementBlService{
    /**
     * 酒店数据模块
     */
    LogDataService logDataService;

    public HSmanagement() throws RemoteException{
        logDataService = new LogDataImpl_stub();
    }

    /**
     * 获取酒店工作人员信息
     * @param hotelsalerID 酒店工作人员ID
     * @return 酒店工作人员信息
     * @throws RemoteException
     */
    public HotelsalerInfoVO getHotelsalerInfo(String hotelsalerID) throws RemoteException{
        return null;
	}

	public ResultMessage setHotelsalerInfo(HotelsalerInfoVO vo) throws RemoteException{
        if(logDataService.getAccountType(vo.getHotelID()).equals(AccountType.hotelsaler)) {
            return ResultMessage.Correct;
        }else {
            return ResultMessage.NotExist;
        }
	}

	public boolean addHotelsalerInfo(HotelsalerInfoVO vo, String password) throws RemoteException{
        if(!logDataService.hasExisted(vo.getHotelID())) {
            AccountPO accountPO = new AccountPO(vo.getHotelID(),password,AccountType.hotelsaler);
            logDataService.addAccount(accountPO);
            return true;
        }else {
            return false;
        }
	}

	public ResultMessage deleteHotelsalerVO(String hotelsalerID) throws RemoteException{
        if(logDataService.getAccountType(hotelsalerID).equals(AccountType.hotelsaler)) {
            return ResultMessage.Correct;
        }else {
            return ResultMessage.NotExist;
        }
	}

	

}

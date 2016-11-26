package businesslogic.webmanagerbl;

import businesslogicservice.webmanagerlogicservice.HSmanagementBlService;
import data_stub.hotelsalerdata.HotelsalerDataImpl_stub;
import data_stub.logdata.LogDataImpl_stub;
import dataservice.hotelsalerdataservice.HotelsalerDataService;
import dataservice.logdataservice.LogDataService;
import enumData.AccountType;
import enumData.ResultMessage;
import po.AccountPO;
import po.HotelsalerInfoPO;
import vo.AccountVO;
import vo.HotelsalerInfoVO;

import java.rmi.RemoteException;

public class HSmanagementBlImpl implements HSmanagementBlService{
    HotelsalerDataService hotelsalerDataService;
    LogDataService logDataService;

    public HSmanagementBlImpl() throws RemoteException{
        hotelsalerDataService = new HotelsalerDataImpl_stub();
        logDataService = new LogDataImpl_stub();
    }


    public HotelsalerInfoVO getHotelsalerInfo(String hotelsalerID) throws RemoteException{
		if(logDataService.getAccountType(hotelsalerID).equals(AccountType.hotelsaler)) {
            HotelsalerInfoPO po = hotelsalerDataService.getHotelsalerInfo(hotelsalerID);
            HotelsalerInfoVO vo = new HotelsalerInfoVO(po.getHotelID(),po.getHotelname());
            return vo;
        }else {
            return null;
        }
	}

	public ResultMessage setHotelsalerInfo(HotelsalerInfoVO vo) throws RemoteException{
        if(logDataService.getAccountType(vo.getHotelID()).equals(AccountType.hotelsaler)) {
            HotelsalerInfoPO po = new HotelsalerInfoPO(vo.getHotelID(),vo.getHotelname(),null);
            return ResultMessage.Correct;
        }else {
            return ResultMessage.NotExist;
        }
	}

	public boolean addHotelsalerInfo(HotelsalerInfoVO vo, String password) throws RemoteException{
        if(logDataService.hasExisted(vo.getHotelID()).equals(ResultMessage.NotExist)) {
            HotelsalerInfoPO po = new HotelsalerInfoPO(vo.getHotelID(),vo.getHotelname(),null);
            AccountPO accountPO = new AccountPO(vo.getHotelID(),password,AccountType.hotelsaler);
            logDataService.addAccount(accountPO);
            hotelsalerDataService.addHotelsalerInfo(po);
            return true;
        }else {
            return false;
        }
	}

	public ResultMessage deleteHotelsalerVO(String hotelsalerID) throws RemoteException{
        if(logDataService.getAccountType(hotelsalerID).equals(AccountType.hotelsaler)) {
            hotelsalerDataService.deleteHotelsalerInfo(hotelsalerID);
            return ResultMessage.Correct;
        }else {
            return ResultMessage.NotExist;
        }
	}

	

}

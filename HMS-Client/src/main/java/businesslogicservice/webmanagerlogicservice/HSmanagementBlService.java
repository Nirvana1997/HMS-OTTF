package businesslogicservice.webmanagerlogicservice;

import enumData.ResultMessage;
import vo.HotelsalerInfoVO;

import java.rmi.RemoteException;

public interface HSmanagementBlService {

	public HotelsalerInfoVO getHotelsalerInfo(String hotelsalerID) throws RemoteException;
	
	public ResultMessage setHotelsalerInfo(HotelsalerInfoVO vo)throws RemoteException;
	
	public boolean addHotelsalerInfo(HotelsalerInfoVO vo, String password)throws RemoteException;
	
	public ResultMessage deleteHotelsalerVO(String hotelsalerID)throws RemoteException;
	
}

package businesslogicservice.webmanagerlogicservice;

import enumData.ResultMessage;
import vo.HotelinfoVO;
import vo.HotelsalerInfoVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

public interface HSmanagementBlService {
	public ArrayList<HotelinfoVO> getHotellist()throws RemoteException;

	public HotelinfoVO getHotelinfo(String hotelsalerID) throws RemoteException;
	
	public ResultMessage setHotelinfo(HotelinfoVO vo)throws RemoteException;
	
	public boolean addHotelinfo(HotelinfoVO vo)throws RemoteException;
	
	public ResultMessage deleteHotelinfo(String hotelsalerID)throws RemoteException;
	
}

package businesslogicservice.webmanagerlogicservice;

import enumData.ResultMessage;
import vo.HotelinfoVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

public interface HSmanagementBlService {
	public ArrayList<HotelinfoVO> getHotellist()throws RemoteException;

	public HotelinfoVO getHotelinfo(String hotelID) throws RemoteException;
	
	public ResultMessage setHotelinfo(HotelinfoVO vo)throws RemoteException;
	
	public boolean addHotelinfoAndAccount(HotelinfoVO vo,String account,String password)throws RemoteException;
	
	public ResultMessage deleteHotelinfoAndAccount(String hotelsalerID)throws RemoteException;
	
}

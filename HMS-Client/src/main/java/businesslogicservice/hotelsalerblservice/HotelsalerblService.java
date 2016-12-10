package businesslogicservice.hotelsalerblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import enumData.ResultMessage;
import vo.HotelinfoVO;
import vo.OrderVO;

public interface HotelsalerblService {
	public ResultMessage modifyHotelInfo(HotelinfoVO vo) throws RemoteException;

	public ArrayList<OrderVO> readOrder(String HotelID) throws RemoteException;

	public ResultMessage updateOrder(OrderVO orderVO) throws RemoteException;

}

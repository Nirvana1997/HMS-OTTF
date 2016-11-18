package businesslogicservice.hotelsalerblservice;

import java.util.ArrayList;

import enumData.ResultMessage;
import vo.HotelinfoVO;
import vo.OrderVO;

public interface HotelsalerblService {
	public ResultMessage modifyHotelInfo(HotelinfoVO vo);

	public ArrayList<OrderVO> readOrder(String HotelID);

	public ResultMessage updateOrder(OrderVO orderVO);

}

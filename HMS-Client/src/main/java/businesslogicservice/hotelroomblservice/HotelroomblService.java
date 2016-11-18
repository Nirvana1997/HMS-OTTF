package businesslogicservice.hotelroomblservice;

import enumData.ResultMessage;
import vo.OrderVO;

public interface HotelroomblService {
	public ResultMessage setOrdered (OrderVO vo);
	
	public ResultMessage setEmpty(OrderVO vo);
}

package businesslogicservice.hotelsalerblservice;

import enumData.ResultMessage;
import vo.OrderVO;

/**
 * 负责对酒店的房间状况进行计算和统计
 */
public interface HotelroomblService {
	/**
	 * TODO 这两个方法合并？
	 * @param vo
	 * @return
	 */
	public ResultMessage setOrdered (OrderVO vo);
	
	public ResultMessage setEmpty(OrderVO vo);
}

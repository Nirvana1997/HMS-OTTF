package businesslogic.hotelroombl;

import businesslogicservice.hotelroomblservice.HotelroomblService;
import enumData.ResultMessage;
import vo.OrderVO;

/**
 * 酒店房间逻辑实现
 * @author xzh
 */
public class HotelroomblImpl implements HotelroomblService {
	/**
	 * 将相应的房间设置为已预订(已预订数+1,空房间数-1)
	 * @param vo
	 * @return
     */
	@Override
	public ResultMessage setOrdered(OrderVO vo) {
		if (vo.getOrderID() == "0001") {
			return ResultMessage.Correct;
		} else {
			return ResultMessage.NotExist;
		}
	}

	/**
	 *将相应的房间设置为已空(已预订数-1,空房间数+1)
	 * @param vo
	 * @return
     */
	@Override
	public ResultMessage setEmpty(OrderVO vo) {
		if (vo.getOrderID() == "0001") {
			return ResultMessage.Correct;
		} else {
			return ResultMessage.NotExist;
		}
	}
}

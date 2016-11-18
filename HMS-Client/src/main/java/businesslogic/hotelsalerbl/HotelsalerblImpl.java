package businesslogic.hotelsalerbl;

import java.util.ArrayList;

import businesslogicservice.hotelsalerblservice.HotelsalerblService;

import enumData.ResultMessage;
import vo.HotelinfoVO;
import vo.OrderVO;

public class HotelsalerblImpl implements HotelsalerblService {

	@Override
	public ResultMessage modifyHotelInfo(HotelinfoVO vo) {
		if (vo.getHotelID() == "0001") {
			return ResultMessage.Correct;
		} else {
			return ResultMessage.NotExist;
		}
	}


	@Override
	public ArrayList<OrderVO> readOrder(String HotelID) {
		if (HotelID == "0001") {
			return new ArrayList<OrderVO>();
		} else {
			return null;
		}

	}

	@Override
	public ResultMessage updateOrder(OrderVO orderVO) {
		if (orderVO.getOrderID() == "0001") {
			return ResultMessage.Correct;
		} else {
			return ResultMessage.NotExist;
		}
	}

}

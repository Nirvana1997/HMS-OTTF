package businesslogic.websalerbl;

import businesslogicservice.websalerblservice.WebsalerblService;
import enumData.ResultMessage;
import vo.PromotionVO;

public class WebsalerblImpl implements WebsalerblService {

	@Override
	public ResultMessage makeFestivalPromotion(PromotionVO vo) {
		if (vo.getPromotionID() == "0001") {
			return ResultMessage.HasExist;
		} else {
			return ResultMessage.Correct;
		}
	}

	@Override
	public ResultMessage makeMemberPromotion(PromotionVO vo) {
		if (vo.getPromotionID() == "0001") {
			return ResultMessage.HasExist;
		} else {
			return ResultMessage.Correct;
		}
	}

	@Override
	public ResultMessage cancelFestivalPromotion(PromotionVO vo) {
		if (vo.getPromotionID() == "0001") {
			return ResultMessage.Correct;
		} else {
			return ResultMessage.NotExist;
		}
	}

	@Override
	public ResultMessage addCredit(String userID, int value) {
		if (userID == "0001") {
			return ResultMessage.Correct;
		} else {
			return ResultMessage.NotExist;
		}
	}

}

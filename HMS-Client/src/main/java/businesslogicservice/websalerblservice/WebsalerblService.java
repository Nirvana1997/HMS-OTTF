package businesslogicservice.websalerblservice;

import enumData.ResultMessage;
import vo.PromotionVO;

public interface WebsalerblService {

	public ResultMessage makeFestivalPromotion(PromotionVO vo);
	
	public ResultMessage makeMemberPromotion(PromotionVO vo);
	
	public ResultMessage cancelFestivalPromotion(PromotionVO vo);
	
	public ResultMessage addCredit(String userID, int value);
}

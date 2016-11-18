package businesslogicservice.promotionblservice;

import java.util.ArrayList;

import enumData.PromotionType;
import enumData.ResultMessage;
import vo.PromotionVO;

public interface PromotionBlService {
	
	public ArrayList<PromotionVO> getPromotionList(PromotionType promotionType,String account);
	
	public PromotionVO getPromotion(String promotionID);
	
	public ResultMessage setPromotion(PromotionVO vo);
	
	public ResultMessage addPromotion(PromotionVO vo);
	
	public ResultMessage deletePromotion(String promotionID);
}

package dataservice.promotiondataservice;

import enumData.PromotionType;
import enumData.ResultMessage;
import po.PromotionPO;

import java.util.ArrayList;

public interface PromotionDataService {
	public ResultMessage addPromotion(PromotionPO po);
	public ResultMessage deletePromotion(String promotionID);
	public ResultMessage changePromotion(PromotionPO po);
	public ArrayList<PromotionPO> getPromotionList(PromotionType type, String account);
}

package dataservice.promotiondataservice;

import enumData.PromotionType;
import enumData.ResultMessage;
import po.*;

import java.util.ArrayList;

public interface PromotionDataService {
	/**
	 * 增加营销策略
	 * @param po
	 * @return
     */
	public ResultMessage addPromotion(PromotionPO po);

	/**
	 * 删除营销策略
	 * @param promotionID
	 * @return
     */
	public ResultMessage deletePromotion(String promotionID);

	/**
	 * 修改营销策略
	 * @param po
	 * @return
     */
	public ResultMessage changePromotion(PromotionPO po);

	/**
	 * 根据策略类型，获取营销策略列表
	 * @param type
	 * @return
     */
	public ArrayList<PromotionPO> getPromotionList(PromotionType type);

	/**
	 * 根据策略类型和酒店编号，获取对应酒店策略列表
	 * @param type
	 * @return
	 */
	public ArrayList<PromotionPO> getPromotionList(PromotionType type,String hotelID);
}

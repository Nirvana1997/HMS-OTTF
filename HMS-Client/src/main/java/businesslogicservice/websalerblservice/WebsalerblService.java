package businesslogicservice.websalerblservice;

import businesslogic.promotionbl.Promotion;
import enumData.PromotionType;
import enumData.ResultMessage;
import vo.PromotionVO;

import java.util.ArrayList;

public interface WebsalerblService {
	/**
	 * 制定优惠策略
	 *
	 * @param vo 优惠策略信息
	 * @return 是否成功
	 */
	public ResultMessage makePromotion(PromotionVO vo);

	/**
	 * 制定范围性优惠策略
	 * 包括会员营销策略、特定商圈营销策略、合作商户营销策略
	 *
	 * @param promotions 营销策略列表
	 * @return 是否成功
	 */
	public ResultMessage makeListPromotion(ArrayList<PromotionVO> promotions);

	/**
	 * 返回一个类型的所有营销策略
	 * @param promotionType 营销策略类型
	 * @return 对应类型所有营销策略
	 */
	public ArrayList<PromotionVO> getPromotionList(PromotionType promotionType);

	/**
	 * 取消一个营销策略
	 * @param promotionName 营销策略名称
	 * @return 是否成功
	 */
	public ResultMessage cancelPromotion(String promotionName);

	/**
	 * 为用户增加信用值
	 * @param userID 用户ID
	 * @param value 增加的值
	 * @return 是否成功
	 */
	public ResultMessage addCredit(String userID, int value);
}

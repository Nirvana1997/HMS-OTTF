package businesslogic.websalerbl;

import businesslogicservice.websalerblservice.WebsalerblService;
import enumData.PromotionType;
import enumData.ResultMessage;
import vo.PromotionVO;

import java.util.ArrayList;

/**
 * 网站营销人员业务逻辑控制模块
 *
 * @author qzh
 *         Created by user on 2016/12/7.
 */
public class WebsalerController implements WebsalerblService {
    /**
     * 网站营销策略模块
     */
    WebPromotion webPromotion;

    public WebsalerController() {
        this.webPromotion = new WebPromotion();
    }

    /**
     * 制定优惠策略
     *
     * @param vo 优惠策略信息
     * @return 是否成功
     */
    @Override
    public ResultMessage makePromotion(PromotionVO vo) {
        return webPromotion.makePromotion(vo);
    }

    /**
     * 制定范围性优惠策略
     * 包括会员营销策略、特定商圈营销策略、合作商户营销策略
     *
     * @param promotions 营销策略列表
     * @return 是否成功
     */
    @Override
    public ResultMessage makeListPromotion(ArrayList<PromotionVO> promotions) {
        return webPromotion.makeListPromotion(promotions);
    }

    /**
     * 返回一个类型的所有营销策略
     *
     * @param promotionType 营销策略类型
     * @return 对应类型所有营销策略
     */
    @Override
    public ArrayList<PromotionVO> getPromotionList(PromotionType promotionType) {
        return null;
    }

    /**
     * 取消一个营销策略
     *
     * @param promotionName 营销策略名称
     * @return 是否成功
     */
    @Override
    public ResultMessage cancelPromotion(String promotionName) {
        return webPromotion.cancelFestivalPromotion(promotionName);
    }

    @Override
    public ResultMessage addCredit(String userID, int value) {
        return null;
    }
}

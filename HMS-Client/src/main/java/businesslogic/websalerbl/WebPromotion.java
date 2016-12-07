package businesslogic.websalerbl;

import businesslogic.promotionbl.Promotion;
import data_stub.websalerdata.WebsalerDataImpl_stub;
import dataservice.websalerdataservice.WebsalerDataService;
import enumData.ResultMessage;
import vo.PromotionVO;

import java.util.ArrayList;

/**
 * 酒店营销销策略模块
 * 负责制定、查看和取消酒店营销策略
 *
 * @author qzh
 */
public class WebPromotion {
    /**
     * 网站营销人员数据接口
     */
    WebsalerDataService websalerDataService;

    public WebPromotion() {
        //TODO
        this.websalerDataService = new WebsalerDataImpl_stub();
    }

    /**
     * 制定优惠策略
     *
     * @param vo 优惠策略信息
     * @return 是否成功
     */
    public ResultMessage makePromotion(PromotionVO vo) {
        return ResultMessage.Correct;
    }

    /**
     * 制定范围性优惠策略
     * 包括会员营销策略、特定商圈营销策略、合作商户营销策略
     *
     * @param promotions 营销策略列表
     * @return 是否成功
     */
    public ResultMessage makeListPromotion(ArrayList<PromotionVO> promotions) {
        return ResultMessage.Correct;
    }

    /**
     * 取消一个营销策略
     *
     * @param promotionName 营销策略名称
     * @return 是否成功
     */
    public ResultMessage cancelFestivalPromotion(String promotionName) {
        return ResultMessage.Correct;
    }

}

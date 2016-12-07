package businesslogic.promotionbl.impl;

import businesslogic.websalerbl.WebPromotion;
import businesslogic.websalerbl.WebPromotionInfo;
import enumData.PromotionType;
import po.PromotionPO;
import vo.PromotionVO;

import java.util.ArrayList;

/**
 * 网站营销策略数据实现
 * Created by user on 2016/12/7.
 */
public class WebPromotionDataImpl implements WebPromotionInfo{
    @Override
    public ArrayList<PromotionPO> getWebPromotions(PromotionType promotionType) {
        return null;
    }

    @Override
    public PromotionPO getPromotion(String promotionName) {
        return null;
    }

    @Override
    public void addPromotion(PromotionVO vo) {

    }

    @Override
    public void deletePromotion(String promotionName) {

    }
}

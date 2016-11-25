package data.promotiondata;

import dataservice.promotiondataservice.PromotionDataService;
import enumData.PromotionType;
import enumData.ResultMessage;
import po.PromotionPO;

import java.util.ArrayList;

/**
 * Created by mac on 2016/11/23.
 */
public class PromotionDataImpl implements PromotionDataService {
    @Override
    public ResultMessage addPromotion(PromotionPO po) {
        return null;
    }

    @Override
    public ResultMessage deletePromotion(String promotionID) {
        return null;
    }

    @Override
    public ResultMessage changePromotion(PromotionPO po) {
        return null;
    }

    @Override
    public ArrayList<PromotionPO> getPromotionList(PromotionType type, String account) {
        return null;
    }
}

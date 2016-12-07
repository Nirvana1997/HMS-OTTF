package businesslogic.websalerbl;

import businesslogicservice.websalerblservice.WebsalerblService;
import enumData.PromotionType;
import enumData.ResultMessage;
import vo.PromotionVO;

import java.util.ArrayList;

/**
 * 网站营销人员业务逻辑控制模块
 * @author qzh
 * Created by user on 2016/12/7.
 */
public class WebsalerController implements WebsalerblService{

    @Override
    public ResultMessage makePromotion(PromotionVO vo) {
        return null;
    }

    @Override
    public ResultMessage makeListPromotion(ArrayList<PromotionVO> promotions) {
        return null;
    }

    @Override
    public ArrayList<PromotionVO> getPromotionList(PromotionType promotionType) {
        return null;
    }

    @Override
    public ResultMessage cancelPromotion(String promotionName) {
        return null;
    }

    @Override
    public ResultMessage addCredit(String userID, int value) {
        return null;
    }
}

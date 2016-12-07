package businesslogic.promotionbl;

import data_stub.promotiondata.PromotionDataImpl_stub;
import dataservice.promotiondataservice.PromotionDataService;
import enumData.PromotionType;
import enumData.ResultMessage;
import po.PromotionPO;
import utility.PromotionPVChanger;
import vo.PromotionVO;

import java.util.ArrayList;

/**
 * 营销策略模块
 * @author qzh
 * Created by user on 2016/12/4.
 */
public class Promotion {
    /**
     * 促销策略数据接口
     */
    PromotionDataService promotionDataService;

    /**
     * 根据类型和账户查看促销列表
     * @param account 账户
     * @return 促销列表
     */
    public ArrayList<PromotionVO> getPromotionList(PromotionType type, String account) {
        promotionDataService = new PromotionDataImpl_stub();
        ArrayList<PromotionVO> volist = new ArrayList<PromotionVO>();
        ArrayList<PromotionPO> polist = new ArrayList<PromotionPO>();
        polist = promotionDataService.getPromotionList(type, account);
        for(int i = 0; i < polist.size(); i++){
            PromotionVO vo = PromotionPVChanger.promotionP2V(polist.get(i));
            volist.add(vo);
        }
        return volist;
    }


    /** 根据促销ID查看促销信息
     *
     * @param promotionID 促销ID
     * @return
     */
    public PromotionVO getPromotion(String promotionID) {
        //TODO
//		promotionDataService = new PromotionDataImpl_stub();
//		PromotionPO po = promotionDataService.getPromotion(promotionID);
//		if(po!=null) {
//			PromotionVO vo = new PromotionVO(po.getPromotionName(), po.getPromotionType(), po.getStartDate(), po.getEndDate(), po.getValidRange(), po.getMemberDiscount(), po.getNormalDiscount());
//			return vo;
//		}
        return null;
    }

    /** 更新促销信息
     *
     * @param vo 读入的促销信息
     * @return
     */
    public ResultMessage setPromotion(PromotionVO vo) {
        promotionDataService = new PromotionDataImpl_stub();
        PromotionPO po = PromotionPVChanger.promotionV2P(vo);
        ResultMessage result = promotionDataService.changePromotion(po);
        return result;
    }

    /** 增加促销信息
     *
     * @param vo 添加的促销信息
     * @return
     */
    public ResultMessage addPromotion(PromotionVO vo) {
        promotionDataService = new PromotionDataImpl_stub();
        PromotionPO po = PromotionPVChanger.promotionV2P(vo);
        ResultMessage result = promotionDataService.addPromotion(po);
        return result;
    }

    /** 删除促销信息
     *
     * @param promotionID 删除的ID
     * @return
     */
    public ResultMessage deletePromotion(String promotionID) {
        promotionDataService = new PromotionDataImpl_stub();
        ResultMessage result = promotionDataService.deletePromotion(promotionID);
        return result;
    }
}
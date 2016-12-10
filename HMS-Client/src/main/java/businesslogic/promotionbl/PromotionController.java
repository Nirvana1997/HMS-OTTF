package businesslogic.promotionbl;

import businesslogicservice.promotionblservice.PromotionBlService;
import data_stub.promotiondata.PromotionDataImpl_stub;
import dataservice.promotiondataservice.PromotionDataService;
import enumData.PromotionType;
import enumData.ResultMessage;
import po.PromotionPO;
import utility.PromotionPVChanger;
import vo.PromotionVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * 促销策略控制器
 * @author qzh
 */
public class PromotionController implements PromotionBlService {
    PromotionDataService promotionDataService = new PromotionDataImpl_stub();

    Promotion promotion = new Promotion();

    /**
     * 根据类型和账户查看促销列表
     * @param account 账户
     * @return
     */
    public ArrayList<PromotionVO> getPromotionList(PromotionType type, String account) throws RemoteException {
        return promotion.getPromotionList(type,account);
    }


    /** 根据促销ID查看促销信息
     *
     * @param promotionID 促销ID
     * @return
     */
    public PromotionVO getPromotion(String promotionID) throws RemoteException{
        //TODO
//		promotionDataService = new PromotionDataImpl_stub();
//		PromotionPO po = promotionDataService.getPromotion(promotionID);
//		if(po!=null) {
//			PromotionVO vo = new PromotionVO(po.getName(), po.getPromotionType(), po.getStartDate(), po.getEndDate(), po.getValidRange(), po.getMemberDiscount(), po.getNormalDiscount());
//			return vo;
//		}
        return null;
    }

    /**
     * 更新促销信息
     * @param vo 读入的促销信息
     * @return
     */
    public ResultMessage setPromotion(PromotionVO vo) throws RemoteException {
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
    public ResultMessage addPromotion(PromotionVO vo) throws RemoteException {
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
    public ResultMessage deletePromotion(String promotionID) throws RemoteException {
        promotionDataService = new PromotionDataImpl_stub();
        ResultMessage result = promotionDataService.deletePromotion(promotionID);
        return result;
    }

}

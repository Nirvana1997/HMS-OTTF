package businesslogic.websalerbl;

import businesslogic.promotionbl.Promotion;
import businesslogic.promotionbl.impl.PromotionDataImpl;
import data_stub.websalerdata.WebsalerDataImpl_stub;
import dataservice.websalerdataservice.WebsalerDataService;
import enumData.PromotionType;
import enumData.ResultMessage;
import po.PromotionPO;
import utility.PromotionPVChanger;
import vo.PromotionVO;

import java.rmi.RemoteException;
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

    /**
     * 网站营销策略接口
     */
    WebPromotionInfo webPromotionInfo;

    public WebPromotion() {
        //TODO
        this.websalerDataService = new WebsalerDataImpl_stub();
        webPromotionInfo = new PromotionDataImpl();
    }

    /**
     * 制定优惠策略
     *
     * @param vo 优惠策略信息
     * @return 是否成功
     */
    public ResultMessage makePromotion(PromotionVO vo) throws RemoteException {
        webPromotionInfo.addPromotion(vo);
        return ResultMessage.Correct;
    }

    /**
     * 制定范围性优惠策略
     * 包括会员营销策略、特定商圈营销策略、合作商户营销策略
     *
     * @param promotions 营销策略列表
     * @return 是否成功
     */
    public ResultMessage makeListPromotion(ArrayList<PromotionVO> promotions) throws RemoteException {
        for(PromotionVO vo:promotions){
            webPromotionInfo.addPromotion(vo);
        }
        return ResultMessage.Correct;
    }

    /**
     * 取消一个营销策略
     *
     * @param promotionName 营销策略名称
     * @return 是否成功
     */
    public ResultMessage cancelFestivalPromotion(String promotionName) throws RemoteException {
        webPromotionInfo.deletePromotion(promotionName);
        return ResultMessage.Correct;
    }

    /**
     * 获得对应类型网站营销策略
     *
     * @param promotionType 营销策略类型
     * @return 所有对应类型网站营销策略
     */
    public ArrayList<PromotionVO> getWebPromotions(PromotionType promotionType) throws RemoteException{
        ArrayList<PromotionVO> res = new ArrayList<PromotionVO>();
        for(PromotionPO po:webPromotionInfo.getWebPromotions()){
            if(po.getPromotionType().equals(promotionType))
                res.add(PromotionPVChanger.promotionP2V(po));
        }
        return res;
    }
}

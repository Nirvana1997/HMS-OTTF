package businesslogic.websalerbl;

import businesslogic.promotionbl.Promotion;
import enumData.PromotionType;
import po.PromotionPO;
import vo.PromotionVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * 网站营销策略接口
 *
 * @author qzh
 *         Created by user on 2016/12/7.
 */
public interface WebPromotionInfo {
    /**
     * 获得对应类型网站营销策略
     *
     * @return 所有对应类型网站营销策略
     */
    ArrayList<PromotionPO> getWebPromotions() throws RemoteException;


    /**
     * 添加营销策略
     *
     * @param vo 营销策略信息
     */
    void addPromotion(PromotionVO vo) throws RemoteException;

    /**
     * 删除营销策略
     *
     * @param promotionName 营销策略名称
     */
    void deletePromotion(String promotionName) throws RemoteException;
}

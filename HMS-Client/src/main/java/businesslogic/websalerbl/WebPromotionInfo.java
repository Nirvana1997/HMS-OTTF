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
    public ArrayList<PromotionPO> getWebPromotions() throws RemoteException;

    /**
     * 获得应对名称的促销策略
     *
     * @param promotionName 营销策略名称
     * @return 营销策略信息
     */
    public PromotionPO getPromotion(String promotionName);

    /**
     * 添加营销策略
     *
     * @param vo 营销策略信息
     */
    public void addPromotion(PromotionVO vo) throws RemoteException;

    /**
     * 删除营销策略
     *
     * @param promotionName 营销策略名称
     */
    public void deletePromotion(String promotionName) throws RemoteException;
}

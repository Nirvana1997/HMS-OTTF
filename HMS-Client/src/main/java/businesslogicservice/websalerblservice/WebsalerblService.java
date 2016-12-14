package businesslogicservice.websalerblservice;

import businesslogic.promotionbl.Promotion;
import enumData.PromotionType;
import enumData.ResultMessage;
import vo.PromotionVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

public interface WebsalerblService {
    /**
     * 制定优惠策略
     *
     * @param vo 优惠策略信息
     * @return 是否成功
     */
    ResultMessage makePromotion(PromotionVO vo) throws RemoteException;

    /**
     * 制定范围性优惠策略
     * 包括会员营销策略、特定商圈营销策略、合作商户营销策略
     *
     * @param promotions 营销策略列表
     * @return 是否成功
     */
    ResultMessage makeListPromotion(ArrayList<PromotionVO> promotions) throws RemoteException;

    /**
     * 返回一个类型的所有营销策略
     *
     * @param promotionType 营销策略类型
     * @return 对应类型所有营销策略
     */
    ArrayList<PromotionVO> getPromotionList(PromotionType promotionType) throws RemoteException;

    /**
     * 取消一个营销策略
     *
     * @param promotionName 营销策略名称
     * @return 是否成功
     */
    ResultMessage cancelPromotion(String promotionName) throws RemoteException;

    /**
     * 为用户增加信用值
     *
     * @param userID 用户ID
     * @param value  增加的值
     * @return 是否成功
     */
    ResultMessage addCredit(String userID, int value) throws RemoteException;

    /**
     * 获得对应用户信用值
     *
     * @param userID 用户ID
     * @return 对应信用值
     */
    int getCredit(String userID) throws RemoteException;
}

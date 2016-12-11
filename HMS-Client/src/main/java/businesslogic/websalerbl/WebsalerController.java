package businesslogic.websalerbl;

import businesslogic.userbl.impl.UserDataImpl;
import businesslogicservice.websalerblservice.WebsalerblService;
import enumData.PromotionType;
import enumData.ResultMessage;
import po.PromotionPO;
import utility.PromotionPVChanger;
import vo.PromotionVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * 网站营销人员业务逻辑控制模块
 *
 * @author qzh
 *         Created by user on 2016/12/7.
 */
public class WebsalerController implements WebsalerblService {
    /**
     * 网站营销策略模块
     */
    WebPromotion webPromotion;

    /**
     * 信用数据接口
     */
    CreditInfo creditInfo;

    public WebsalerController() {
        this.webPromotion = new WebPromotion();
        this.creditInfo = new UserDataImpl();
    }

    /**
     * 制定优惠策略
     *
     * @param vo 优惠策略信息
     * @return 是否成功
     */
    @Override
    public ResultMessage makePromotion(PromotionVO vo) throws RemoteException {
        return webPromotion.makePromotion(vo);
    }

    /**
     * 制定范围性优惠策略
     * 包括会员营销策略、特定商圈营销策略、合作商户营销策略
     *
     * @param promotions 营销策略列表
     * @return 是否成功
     */
    @Override
    public ResultMessage makeListPromotion(ArrayList<PromotionVO> promotions) throws RemoteException {
        return webPromotion.makeListPromotion(promotions);
    }

    /**
     * 返回一个类型的所有营销策略
     *
     * @param promotionType 营销策略类型
     * @return 对应类型所有营销策略
     */
    @Override
    public ArrayList<PromotionVO> getPromotionList(PromotionType promotionType) throws RemoteException {
        return webPromotion.getWebPromotions(promotionType);
    }

    /**
     * 取消一个营销策略
     *
     * @param promotionName 营销策略名称
     * @return 是否成功
     */
    @Override
    public ResultMessage cancelPromotion(String promotionName) throws RemoteException {
        return webPromotion.cancelFestivalPromotion(promotionName);
    }

    /**
     * 为用户增加信用值
     *
     * @param userID 用户ID
     * @param value  增加的值
     * @return 是否成功
     */
    @Override
    public ResultMessage addCredit(String userID, int value) throws RemoteException {
        return creditInfo.addCredit(userID,value);
    }

    /**
     * 获得对应用户信用值
     *
     * @param userID 用户ID
     * @return 对应信用值
     */
    @Override
    public int getCredit(String userID) throws RemoteException{
        return creditInfo.getCredit(userID);
    }
}

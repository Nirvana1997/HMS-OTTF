package businesslogic.websalerbl;

import businesslogic.userbl.impl.UserDataImpl;
import businesslogicservice.websalerblservice.WebsalerblService;
import cfg.CfgReader;
import enumData.CreditRecoverWay;
import enumData.OrderState;
import enumData.PromotionType;
import enumData.ResultMessage;
import po.CreditChangePO;
import utility.DateOperation;
import vo.CanceledExceptionOrderVO;
import vo.OrderVO;
import vo.PromotionVO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

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

    /**
     * 酒店工作人员订单模块
     */
    WebsalerOrderOperation websalerOrderOperation;

    public WebsalerController() {
        this.webPromotion = new WebPromotion();
        this.creditInfo = new UserDataImpl();
        this.websalerOrderOperation = new WebsalerOrderOperation();
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
     * @param money  冲的钱
     * @return 是否成功
     */
    @Override
    public ResultMessage addCredit(String userID, int money) throws RemoteException {
        return creditInfo.addCredit(new CreditChangePO(userID,null, DateOperation.dateToString(new Date()), CfgReader.getInstance().getProperty("recharge"),Integer.valueOf( CfgReader.getInstance().getProperty("rechargeRate"))*money));
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

    @Override
    public ArrayList<OrderVO> getOrderByState(OrderState orderState) throws RemoteException {
        return websalerOrderOperation.getOrderByState(orderState);
    }

    @Override
    public OrderVO getOrderByID(String orderID) throws RemoteException {
        return websalerOrderOperation.getOrderByID(orderID);
    }

    @Override
    public ArrayList<OrderVO> getCanceledExceptionOrderInfos() throws RemoteException {
        return websalerOrderOperation.getCanceledExceptionOrderInfos();
    }

    @Override
    public ArrayList<CanceledExceptionOrderVO> getCanceledExceptionOrders() throws RemoteException {
        return websalerOrderOperation.getCanceledExceptionOrders();
    }

    @Override
    public CanceledExceptionOrderVO getCanceledExceptionOrder(String orderID) throws RemoteException {
        return websalerOrderOperation.getCanceledExceptionOrder(orderID);
    }

    @Override
    public void cancelExceptionOrder(CanceledExceptionOrderVO vo, CreditRecoverWay creditRecoverWay) throws RemoteException {
        websalerOrderOperation.cancelExceptionOrder(vo,creditRecoverWay);
    }
}

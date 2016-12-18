package businesslogicservice.websalerblservice;

import enumData.OrderState;
import enumData.PromotionType;
import enumData.ResultMessage;
import vo.CanceledExceptionOrderVO;
import vo.OrderVO;
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
    public ResultMessage makePromotion(PromotionVO vo) throws RemoteException;

    /**
     * 制定范围性优惠策略
     * 包括会员营销策略、特定商圈营销策略、合作商户营销策略
     *
     * @param promotions 营销策略列表
     * @return 是否成功
     */
    public ResultMessage makeListPromotion(ArrayList<PromotionVO> promotions) throws RemoteException;

    /**
     * 返回一个类型的所有营销策略
     *
     * @param promotionType 营销策略类型
     * @return 对应类型所有营销策略
     */
    public ArrayList<PromotionVO> getPromotionList(PromotionType promotionType) throws RemoteException;

    /**
     * 取消一个营销策略
     *
     * @param promotionName 营销策略名称
     * @return 是否成功
     */
    public ResultMessage cancelPromotion(String promotionName) throws RemoteException;

    /**
     * 为用户增加信用值
     *
     * @param userID 用户ID
     * @param value  增加的值
     * @return 是否成功
     */
    public ResultMessage addCredit(String userID, int value) throws RemoteException;

    /**
     * 获得对应用户信用值
     *
     * @param userID 用户ID
     * @return 对应信用值
     */
    public int getCredit(String userID) throws RemoteException;

    /**
     * 根据状态返回对应订单
     *
     * @param orderState 订单状态
     * @return 所有对应状态订单
     * @throws RemoteException
     */
    public ArrayList<OrderVO> getOrderByState(OrderState orderState) throws RemoteException;

    /**
     * 返回所有撤销的异常订单
     *
     * @return 撤销的异常订单列表
     */
    public ArrayList<CanceledExceptionOrderVO> getCanceledExceptionOrders() throws RemoteException;

    /**
     * 根据ID返回撤销的异常订单
     *
     * @return 撤销的异常订单
     */
    public CanceledExceptionOrderVO getCanceledExceptionOrder(String orderID) throws RemoteException;

    /**
     * 撤销异常订单、更新撤销信息并恢复信用值
     *
     * @param vo
     * @throws RemoteException
     */
    public void cancelExceptionOrder(CanceledExceptionOrderVO vo) throws RemoteException;
}

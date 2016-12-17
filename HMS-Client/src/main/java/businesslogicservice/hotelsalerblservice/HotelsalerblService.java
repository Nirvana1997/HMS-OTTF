package businesslogicservice.hotelsalerblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import enumData.ResultMessage;
import vo.HotelinfoVO;
import vo.OrderVO;
import vo.PromotionVO;

public interface HotelsalerblService {
    /**
     * 修改酒店信息
     *
     * @param vo 酒店信息
     * @return 是否成功
     * @throws RemoteException
     */
    public ResultMessage modifyHotelInfo(HotelinfoVO vo) throws RemoteException;

    /**
     * 浏览登录帐号对应酒店订单
     *
     * @return 酒店订单列表
     * @throws RemoteException
     */
    public ArrayList<OrderVO> readOrder() throws RemoteException;

    /**
     * 更新订单信息
     *
     * @param orderVO 订单信息
     * @return 是否成功
     * @throws RemoteException
     */
    public ResultMessage updateOrder(OrderVO orderVO) throws RemoteException;

    /**
     * 获取当前酒店的营销策略
     *
     * @return 酒店营销策略列表
     * @throws RemoteException
     */
    public ArrayList<PromotionVO> getPromotion() throws RemoteException;

    /**
     * 删除酒店营销策略
     *
     * @param promotionName 酒店营销策略名称
     * @throws RemoteException
     */
    public void deletePromotion(String promotionName) throws RemoteException;

    /**
     * 增加酒店营销策略
     *
     * @param vo 酒店营销策略
     * @throws RemoteException
     */
    public void addPromotion(PromotionVO vo) throws RemoteException;

    /**
     * 修改酒店营销策略
     *
     * @param vo 酒店营销策略
     * @throws RemoteException
     */
    public void setPromotion(PromotionVO vo) throws RemoteException;

}

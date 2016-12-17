package businesslogic.hotelsalerbl;

import vo.PromotionVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * 营销策略信息接口
 * Created by user on 2016/12/17.
 */
public interface HotelPromotionInfo {
    /**
     * 获取当前酒店的营销策略
     *
     * @param hotelID 酒店编号
     * @return 酒店营销策略列表
     * @throws RemoteException
     */
    public ArrayList<PromotionVO> getPromotions(String hotelID) throws RemoteException;

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

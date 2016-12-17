package businesslogic.hotelsalerbl;

import businesslogic.logbl.Login;
import businesslogic.promotionbl.impl.PromotionDataImpl;
import enumData.PromotionType;
import vo.PromotionVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * 酒店营销策略管理
 * @author qzh
 * Created by user on 2016/12/17.
 */
public class PromotionOperation {
    HotelPromotionInfo hotelPromotionInfo;

    public PromotionOperation() {
        hotelPromotionInfo = new PromotionDataImpl();
    }

    /**
     * 获取当前酒店的营销策略
     *
     * @param promotionType 营销策略
     * @return 酒店营销策略列表
     * @throws RemoteException
     */
    public ArrayList<PromotionVO> getPromotions(PromotionType promotionType) throws RemoteException{
        return hotelPromotionInfo.getPromotions(Login.getNowUserID(),promotionType);
    }

    /**
     * 删除酒店营销策略
     *
     * @param promotionName 酒店营销策略名称
     * @throws RemoteException
     */
    public void deletePromotion(String promotionName) throws RemoteException{
        hotelPromotionInfo.deletePromotion(promotionName);
    }

    /**
     * 增加酒店营销策略
     *
     * @param vo 酒店营销策略
     * @throws RemoteException
     */
    public void addPromotion(PromotionVO vo) throws RemoteException{
        //填充hotelID
        vo.setHotelID(Login.getNowUserID());
        hotelPromotionInfo.addPromotion(vo);
    }

    /**
     * 修改酒店营销策略
     *
     * @param vo 酒店营销策略
     * @throws RemoteException
     */
    public void setPromotion(PromotionVO vo) throws RemoteException{
        //填充hotelID
        vo.setHotelID(Login.getNowUserID());
        hotelPromotionInfo.setPromotion(vo);
    }
}

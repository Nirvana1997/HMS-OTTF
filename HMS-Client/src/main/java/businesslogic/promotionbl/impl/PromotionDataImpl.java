package businesslogic.promotionbl.impl;

import businesslogic.promotionbl.strategies.Strategy;
import businesslogic.userbl.interfaces.PromotionInfo;
import data_stub.promotiondata.PromotionDataImpl_stub;
import dataservice.promotiondataservice.PromotionDataService;
import enumData.PromotionType;
import po.PromotionPO;
import utility.PromotionPVChanger;
import vo.OrderVO;
import vo.UserInfoVO;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * 促销策略数据接口实现
 * 负责计算用户可以享受的最大优惠方案
 *
 * @author qzh
 *         Created by user on 2016/12/4.
 */
public class PromotionDataImpl implements PromotionInfo {
    //TODO
    /**
     * 营销策略模块
     */
    PromotionDataService promotionDataService = new PromotionDataImpl_stub();

    /**
     * 获得最优营销策略
     *
     * @param userInfoVO 用户信息
     * @param orderVO    订单信息
     * @return 填充完网站营销策略和酒店营销策略的订单
     */
    @Override
    public OrderVO choosePromotion(UserInfoVO userInfoVO, OrderVO orderVO) throws RemoteException {
        //结果订单
        OrderVO res = orderVO;
        //营销策略列表
        ArrayList<PromotionPO> promotions;
        //最低价格，初始为正无穷
        double leastPrice = Double.POSITIVE_INFINITY;

        //寻找最佳营销策略使用方案
        PromotionPO bestPromotion = null;
        promotions = this.getUsablePromotions(orderVO.getHotelID());
        for (PromotionPO promotion : promotions) {
            //获得该营销策略的类型
            String type = promotion.getPromotionType().toString().split("_")[1];

            //利用反射创建营销策略对象
            Strategy strategy = null;
            try {
                Constructor constructor = Class.forName("businesslogic.promotionbl.strategies." + type).getConstructor(new Class[]{PromotionPO.class});
                strategy = (Strategy) constructor.newInstance(promotion);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

            //若比当前最低价格低，则替换
            double price = strategy.calculateDiscountPrice(userInfoVO, orderVO);
            if (price < leastPrice) {
                leastPrice = price;
                bestPromotion = promotion;
            }
        }

        //填充订单信息
        res.setPrice(leastPrice);
        res.setPromotionName(bestPromotion.getName());
        return res;
    }

    /**
     * 获得所有网站和该酒店的营销策略
     *
     * @param hotelID 酒店编号
     * @return 所有网站和预定酒店的营销策略
     */
    private ArrayList<PromotionPO> getUsablePromotions(String hotelID) throws RemoteException {
        ArrayList<PromotionPO> res = new ArrayList<PromotionPO>();
        //获得各种类型可使用的营销策略
        mergeList(res, promotionDataService.getPromotionList(PromotionType.Web_Period));
        mergeList(res, promotionDataService.getPromotionList(PromotionType.Web_TradeArea));
        mergeList(res, promotionDataService.getPromotionList(PromotionType.Web_Vip));
        mergeList(res,promotionDataService.getPromotionList(PromotionType.Hotel_Period,hotelID));
        mergeList(res,promotionDataService.getPromotionList(PromotionType.Hotel_Company,hotelID));
        mergeList(res,promotionDataService.getPromotionList(PromotionType.Hotel_Num,hotelID));
        mergeList(res,promotionDataService.getPromotionList(PromotionType.Hotel_Birth,hotelID));
        return res;
    }

    /**
     * 合并两个arraylist
     *
     * @param orgin 原始数组
     * @param add   待合并数组
     */
    private void mergeList(ArrayList<PromotionPO> orgin, ArrayList<PromotionPO> add) {
        for (PromotionPO promotion : add) {
            orgin.add(promotion);
        }
    }
}

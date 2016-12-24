package businesslogic.promotionbl.impl;

import businesslogic.hotelsalerbl.HotelPromotionInfo;
import businesslogic.promotionbl.strategies.Strategy;
import businesslogic.userbl.interfaces.PromotionInfo;
import businesslogic.websalerbl.WebPromotionInfo;
import dataservice.promotiondataservice.PromotionDataService;
import enumData.PromotionType;
import po.PromotionPO;
import rmi.RemoteHelper;
import utility.DateOperation;
import utility.PromotionPVChanger;
import vo.OrderVO;
import vo.PromotionVO;
import vo.UserInfoVO;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.rmi.RemoteException;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * 促销策略数据接口实现
 * 负责计算用户可以享受的最大优惠方案
 *
 * @author qzh
 *         Created by user on 2016/12/4.
 */
public class PromotionInfoImpl implements PromotionInfo, WebPromotionInfo, HotelPromotionInfo {

    /**
     * 营销策略模块
     */
    PromotionDataService promotionDataService;

    //TODO
    public PromotionInfoImpl() {
        promotionDataService = RemoteHelper.getInstance().getPromotionDataService();
    }

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
        //最低价格，初始为原价
        int days = DateOperation.getDates(orderVO.getCheckInDate(),orderVO.getCheckOutDate()).size();
        double leastPrice = orderVO.getPrice()*orderVO.getRoomNumber()*days;

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
        DecimalFormat df = new DecimalFormat("#.0");
        res.setPrice(Double.valueOf(df.format(leastPrice)));
        res.setPromotionName(bestPromotion==null?null:(bestPromotion.getName()+" "+(bestPromotion.getDiscount()*10)+"折"));
        return res;
    }

    /**
     * 根据酒店ID获得对应营销策略
     *
     * @param hotelID 酒店ID
     * @return 酒店营销策略
     * @throws RemoteException
     */
    @Override
    public ArrayList<PromotionPO> getHotelPromotion(String hotelID) throws RemoteException {
        ArrayList<PromotionPO> res = new ArrayList<>();

        for (PromotionType type : PromotionType.values()) {
            mergeList(res, promotionDataService.getPromotionList(type, hotelID));
        }

        return res;
    }

    /**
     * 获得对应类型网站营销策略
     *
     * @return 所有对应类型网站营销策略
     */
    @Override
    public ArrayList<PromotionPO> getWebPromotions() throws RemoteException {
        ArrayList<PromotionPO> res = new ArrayList<PromotionPO>();
        //获得网站的营销策略
        for (PromotionType type : PromotionType.values()) {
            //判断是否为网站营销策略
            if (type.toString().startsWith("Web")) {
                mergeList(res, promotionDataService.getPromotionList(type));
            }
        }
        return res;
    }


    /**
     * 添加营销策略
     *
     * @param vo 营销策略信息
     */
    @Override
    public void addPromotion(PromotionVO vo) throws RemoteException {
        PromotionPO po = PromotionPVChanger.promotionV2P(vo);
        promotionDataService.addPromotion(po);
    }

    @Override
    public void setPromotion(PromotionVO vo) throws RemoteException {
        promotionDataService.changePromotion(PromotionPVChanger.promotionV2P(vo));
    }

    @Override
    public ArrayList<PromotionVO> getPromotions(String hotelID, PromotionType promotionType) throws RemoteException {
        ArrayList<PromotionVO> res = new ArrayList<>();
        for (PromotionPO po : promotionDataService.getPromotionList(promotionType, hotelID)) {
            res.add(PromotionPVChanger.promotionP2V(po));
        }
        return res;
    }

    /**
     * 删除营销策略
     *
     * @param promotionName 营销策略名称
     */
    @Override
    public void deletePromotion(String promotionName) throws RemoteException {
        promotionDataService.deletePromotion(promotionName);
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
        for (PromotionType type : PromotionType.values()) {
            ArrayList<PromotionPO> promotions = promotionDataService.getPromotionList(type);
            //网站营销策略直接连接
            if(type.toString().startsWith("Web"))
                mergeList(res, promotions);
            else{
                for(PromotionPO po:promotions){
                    if(po.getHotelID().equals(hotelID))
                        res.add(po);
                }
            }
        }
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

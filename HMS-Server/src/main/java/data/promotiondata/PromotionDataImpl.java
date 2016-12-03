package data.promotiondata;

import database.DataBaseHelper;
import dataservice.promotiondataservice.PromotionDataService;
import enumData.PromotionType;
import enumData.ResultMessage;
import po.PromotionPO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by mac on 2016/11/23.
 */
public class PromotionDataImpl implements PromotionDataService {
    /**
     * 增加营销策略
     * @param po
     * @return
     */
    @Override
    public ResultMessage addPromotion(PromotionPO po) {
        if(!hasExisted(po.getPromotionID())){
            DataBaseHelper.in("insert into PromotionInfo (promotionID,type,startDate,endDate,tradeArea,roomNumber,vipLevel,discount) values ('"+
            po.getPromotionID() + "','" + po.getPromotionType().toString() + "','" + po.getStartDate() + "','" + po.getEndDate() + "','" +
            po.getTradeArea().toString() + "','" + po.getRoomNumber() + "','" + po.getVipLevel() + "','" + po.getDiscount() + "')");
            return ResultMessage.Correct;
        }else
            return ResultMessage.HasExist;
    }

    /**
     * 删除营销策略
     * @param promotionID
     * @return
     */
    @Override
    public ResultMessage deletePromotion(String promotionID) {
        if(hasExisted(promotionID)){
            DataBaseHelper.in("delete from PromotionInfo where promotionID = '" + promotionID + "'");
            return ResultMessage.Correct;
        }else
            return ResultMessage.NotExist;
    }

    /**
     * 修改营销策略
     * @param po
     * @return
     */
    @Override
    public ResultMessage changePromotion(PromotionPO po) {
        deletePromotion(po.getPromotionID());
        addPromotion(po);
        return ResultMessage.Correct;
    }

    /**
     * 根据策略类型，获取营销策略列表
     * @param type
     * @return
     */
    @Override
    public ArrayList<PromotionPO> getPromotionList(PromotionType type) {
        return null;
    }

    /**
     * 判断存在
     * @param promotionID
     * @return
     */
    private boolean hasExisted (String promotionID){
        ArrayList<String> promotionIDLit =  DataBaseHelper.out("select promotionID from PromotionInfo", "promotionID");
        for(int i=0;i<promotionIDLit.size();i++)
            if(promotionIDLit.get(i).equals(promotionID))
                return true;
        return  false;
    }
}

package data.promotiondata;

import database.DataBaseHelper;
import dataservice.promotiondataservice.PromotionDataService;
import enumData.PromotionType;
import enumData.ResultMessage;
import enumData.TradeArea;
import po.PromotionPO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 * Created by mac on 2016/11/23.
 */
public class PromotionDataImpl extends UnicastRemoteObject implements PromotionDataService {

    public PromotionDataImpl() throws RemoteException {
    }

    /**
     * 增加营销策略
     * @param po
     * @return
     */
    @Override
    public ResultMessage addPromotion(PromotionPO po) {
        if(!hasExisted(po.getName())){
            DataBaseHelper.in("insert into PromotionInfo (name,type,startDate,endDate,tradeArea,roomNumber,vipLevel,discount,hotelID,description) values ('"+
            po.getName() + "','" + po.getPromotionType().toString() + "','" + po.getStartDate() + "','" + po.getEndDate() + "','" +
            po.getTradeArea().toString() + "','" + po.getRoomNumber() + "','" + po.getVipLevel() + "','" + po.getDiscount() + "','" + po.getHotelID() + "','" + po.getDescription() +"')");
            return ResultMessage.Correct;
        }else
            return ResultMessage.HasExist;
    }

    /**
     * 删除营销策略
     * @param name
     * @return
     */
    @Override
    public ResultMessage deletePromotion(String name) {
        if(hasExisted(name)){
            DataBaseHelper.in("delete from PromotionInfo where promotionID = '" + name + "'");
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
        deletePromotion(po.getName());
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
        ArrayList<PromotionPO> promotionPOs = new ArrayList<PromotionPO>();
        ArrayList<String> nameList = DataBaseHelper.out("select name from PromotionInfo where type = '" + type.toString() + "'","name");
        ArrayList<String> startDateList = DataBaseHelper.out("select startDate from PromotionInfo where type = '" + type.toString() + "'","startDate");
        ArrayList<String> endDateList = DataBaseHelper.out("select endDate from PromotionInfo where type = '" + type.toString() + "'","endDate");
        ArrayList<String> tradeAreaList = DataBaseHelper.out("select tradeArea from PromotionInfo where type = '" + type.toString() + "'","tradeArea");
        ArrayList<String> roomNumberList = DataBaseHelper.out("select roomNumber from PromotionInfo where type = '" + type.toString() + "'","roomNumber");
        ArrayList<String> vipLevelList = DataBaseHelper.out("select vipLevel from PromotionInfo where type = '" + type.toString() + "'","vipLevel");
        ArrayList<String> discountList = DataBaseHelper.out("select discount from PromotionInfo where type = '" + type.toString() + "'","discount");
        ArrayList<String> hotelIDList = DataBaseHelper.out("select hotelID from PromotionInfo where type = '" + type.toString() + "'","hotelID");
        ArrayList<String> descriptionList = DataBaseHelper.out("select description from PromotionInfo where type = '" + type.toString() + "'","description");
        for(int i=0;i<nameList.size();i++){
            TradeArea tradeArea = null;
            try {
                tradeArea = Enum.valueOf(TradeArea.class,tradeAreaList.get(i).trim());
            }catch (IllegalArgumentException ex){
                ex.printStackTrace();
            }
            promotionPOs.add(new PromotionPO(nameList.get(i),type,startDateList.get(i),endDateList.get(i),tradeArea,
                    Integer.parseInt(roomNumberList.get(i)),Integer.parseInt(vipLevelList.get(i)),Double.parseDouble(discountList.get(i)),hotelIDList.get(i),descriptionList.get(i)));
        }
        return promotionPOs;
    }

    /**
     * 根据营销策略类型和酒店ID，获取营销策略列表
     * @param type
     * @param hotelID
     * @return
     */
    @Override
    public ArrayList<PromotionPO> getPromotionList(PromotionType type, String hotelID) {
        ArrayList<PromotionPO> temp = getPromotionList(type);
        ArrayList<PromotionPO> promotionPOs = new ArrayList<PromotionPO>();
        for(int i=0;i<temp.size();i++){
            if(temp.get(i).getHotelID().equals(hotelID))
                promotionPOs.add(temp.get(i));
        }
        return promotionPOs;
    }

    /**
     * 判断存在
     * @param name
     * @return
     */
    private boolean hasExisted (String name){
        ArrayList<String> nameList =  DataBaseHelper.out("select name from PromotionInfo", "name");
        for(int i=0;i<nameList.size();i++)
            if(nameList.get(i).equals(name))
                return true;
        return  false;
    }
}

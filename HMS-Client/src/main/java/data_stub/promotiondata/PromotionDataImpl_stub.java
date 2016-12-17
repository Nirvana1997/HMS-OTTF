package data_stub.promotiondata;

import businesslogic.promotionbl.Promotion;
import dataservice.promotiondataservice.PromotionDataService;
import enumData.PromotionType;
import enumData.ResultMessage;
import enumData.TradeArea;
import po.PromotionPO;


import java.util.ArrayList;
import java.util.Date;

public class PromotionDataImpl_stub implements PromotionDataService {
	ArrayList<PromotionPO> promotionPOs = new ArrayList<PromotionPO>();
	PromotionPO promotion1 = new PromotionPO("Birthday discount","When it is user's birthday,the user can have a discount",PromotionType.Hotel_Birth,"0200001",null,null,null,0,0,0.8,null);
	PromotionPO promotion2 = new PromotionPO("TradeArea discount","In the certain tradeArea,the users can have a discount",PromotionType.Web_TradeArea,null,null,null,TradeArea.Changjiang,0,1,0.9,null);
	PromotionPO promotion3 = new PromotionPO("RoomNumber discount","When the number of rooms is up to a standard,the users can have a discount",PromotionType.Hotel_Num,"0200001",null,null,null,3,0,0.8,null);
	PromotionPO promotion4 = new PromotionPO("Hotel Period discount","During some periods,discount",PromotionType.Hotel_Period,"0200001","2015_01_01","2016_12_12",null,0,0,0.6,null);
	PromotionPO promotion5 = new PromotionPO("Company discount","With the cooperation,someone may have a discount",PromotionType.Hotel_Company,"0200001",null,null,null,0,0,0.7,"007");
	PromotionPO promotion6 = new PromotionPO("Web Period","During some periods,discount",PromotionType.Web_Period,null,"2015_01_01","2020_11_12",null,0,0,0.5,null);
	PromotionPO promotion7 = new PromotionPO("Web Vip","Vip level is equivalent to discount",PromotionType.Web_Vip,null,null,null,null,0,3,0.7,null);

	public PromotionDataImpl_stub() {
		promotionPOs.add(promotion1);
		promotionPOs.add(promotion2);
		promotionPOs.add(promotion3);
		promotionPOs.add(promotion4);
		promotionPOs.add(promotion5);
		promotionPOs.add(promotion6);
		promotionPOs.add(promotion7);
	}

	@Override
	public ResultMessage addPromotion(PromotionPO po) {
		// TODO Auto-generated method stub
		promotionPOs.add(po);
		return ResultMessage.Correct;
	}

	@Override
	public ResultMessage deletePromotion(String name) {
		// TODO Auto-generated method stub
		for(int i=0;i<promotionPOs.size();i++)
			if(promotionPOs.get(i).getName().equals(name))
				promotionPOs.remove(i);
		return ResultMessage.Correct;
	}

	@Override
	public ResultMessage changePromotion(PromotionPO po) {
		// TODO Auto-generated method stub
		deletePromotion(po.getName());
		addPromotion(po);
		return ResultMessage.Correct;
	}

	@Override
	public ArrayList<PromotionPO> getPromotionList(PromotionType type) {
		ArrayList<PromotionPO> list = new ArrayList<PromotionPO>();
		for(int i=0;i<promotionPOs.size();i++){
			if(promotionPOs.get(i).getPromotionType().equals(type))
				list.add(promotionPOs.get(i));
		}
		return list;
	}

	@Override
	public ArrayList<PromotionPO> getPromotionList(PromotionType type, String hotelID) {
		ArrayList<PromotionPO> temp = getPromotionList(type);
		ArrayList<PromotionPO> list = new ArrayList<PromotionPO>();
		for(int i=0;i<temp.size();i++){
			if(temp.get(i).getHotelID().equals(hotelID))
				list.add(temp.get(i));
		}
		return list;
	}

}

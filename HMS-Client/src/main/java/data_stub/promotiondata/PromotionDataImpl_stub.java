package data_stub.promotiondata;

import dataservice.promotiondataservice.PromotionDataService;
import enumData.PromotionType;
import enumData.ResultMessage;
import enumData.TradeArea;
import po.PromotionPO;


import java.util.ArrayList;
import java.util.Date;

public class PromotionDataImpl_stub implements PromotionDataService {
	ArrayList<Double> discount;
	TradeArea[] area;
	PromotionPO promotion1 = new PromotionPO("0001", PromotionType.fesPromotion, new Date(2016,11,13), new Date(2016,11,15),area ,discount, 9.0 ,"0001");
	PromotionPO promotion2 = new PromotionPO("0002", PromotionType.memPromotion, new Date(2016,11,13), new Date(2016,11,15),area ,discount, 9.0 ,"0001");
	PromotionPO promotion3 = new PromotionPO("0002", PromotionType.hotelPromotion, new Date(2016,11,13), new Date(2016,11,15),area ,discount, 9.0 , "0002");

	public PromotionDataImpl_stub() {
		discount = new ArrayList<Double>();
		discount.add(0,9.0);
		discount.add(1,9.1);
		area = new TradeArea[2];
		area[0] = TradeArea.XuanQuan;
		area[1] = TradeArea.Xianlin;
	}

	@Override
	public ResultMessage addPromotion(PromotionPO po) {
		// TODO Auto-generated method stub
		return ResultMessage.Correct;
	}

	@Override
	public ResultMessage deletePromotion(String promotionID) {
		// TODO Auto-generated method stub
		return ResultMessage.Correct;
	}

	@Override
	public ResultMessage changePromotion(PromotionPO po) {
		// TODO Auto-generated method stub
		if(po!=null)
			return ResultMessage.Correct;
		else
			return ResultMessage.InCorrect;
	}

	@Override
	public ArrayList<PromotionPO> getPromotionList(PromotionType type, String account) {
		// TODO Auto-generated method stub
		ArrayList<PromotionPO> list = new ArrayList<PromotionPO>();
		if(type == PromotionType.fesPromotion)
			list.add(0,promotion1);
		else if(type == PromotionType.memPromotion)
			list.add(0,promotion2);
		else if(type == PromotionType.hotelPromotion)
			list.add(0,promotion3);
		return list;
	}

}

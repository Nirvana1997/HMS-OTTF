package dataservice.hotelinfodataservice;


import enumData.ResultMessage;
import po.CommentPO;
import po.ConditionPO;
import po.HotelinfoPO;
import vo.HotelinfoVO;

import java.util.ArrayList;

public interface HotelinfoDataService {
	public ResultMessage addHotelInfo(HotelinfoPO po);

	public HotelinfoPO getHotelinfo(String hotelID);
	
	public ResultMessage setHotelinfo(HotelinfoPO po);
	
	public ArrayList<HotelinfoPO> getHotelList(ConditionPO po);
	
	public ResultMessage addComments(CommentPO po);
}

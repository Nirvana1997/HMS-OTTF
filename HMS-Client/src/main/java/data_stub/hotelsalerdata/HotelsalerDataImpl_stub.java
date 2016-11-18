package data_stub.hotelsalerdata;

import dataservice.hotelsalerdataservice.HotelsalerDataService;
import enumData.ResultMessage;
import po.HotelsalerInfoPO;

import java.util.HashMap;
import java.util.Map;

public class HotelsalerDataImpl_stub implements HotelsalerDataService {
	HotelsalerInfoPO po = new HotelsalerInfoPO("151250175","梓航大酒店","12345678910");
	Map<String,HotelsalerInfoPO> hotelsalerMap = new HashMap<String ,HotelsalerInfoPO>();

	public HotelsalerDataImpl_stub() {
		hotelsalerMap.put("151250175",po);
	}

	@Override
	public HotelsalerInfoPO getHotelsalerInfo(String hotelsalerID) {
		return hotelsalerMap.get(hotelsalerID);
	}

	@Override
	public ResultMessage setHotelsalerInfo(HotelsalerInfoPO po) {
		hotelsalerMap.put(po.getHotelID(),po);
		return ResultMessage.Correct;
	}

	@Override
	public ResultMessage addHotelsalerInfo(HotelsalerInfoPO po) {
	    HotelsalerInfoPO temp = new HotelsalerInfoPO(po.getHotelID(),po.getHotelname(),po.getContactNumber());
        hotelsalerMap.put(temp.getHotelID(),temp);
		return ResultMessage.Correct;
	}

	@Override
	public ResultMessage deleteHotelsalerInfo(String hotelsalerID) {
	    hotelsalerMap.remove(hotelsalerID);
        return ResultMessage.Correct;
	}


}

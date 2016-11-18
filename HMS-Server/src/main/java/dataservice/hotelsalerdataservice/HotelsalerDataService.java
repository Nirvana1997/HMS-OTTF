package dataservice.hotelsalerdataservice;

import enumData.ResultMessage;
import po.HotelsalerInfoPO;

public interface HotelsalerDataService {
	public HotelsalerInfoPO getHotelsalerInfo(String hotelsalerID);
	
	public ResultMessage setHotelsalerInfo(HotelsalerInfoPO po);
	
	public ResultMessage addHotelsalerInfo(HotelsalerInfoPO po);
	
	public ResultMessage deleteHotelsalerInfo(String hotelsalerID);
}

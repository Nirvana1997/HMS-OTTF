package dataservice.websalerdataservice;

import enumData.ResultMessage;
import po.*;

public interface WebsalerDataService {
	public WebsalerInfoPO getWebsalerInfo(String websalerID);
	public ResultMessage setWebsalerInfo(WebsalerInfoPO po);
	public ResultMessage addWebsalerInfo(WebsalerInfoPO po);
	public ResultMessage deleteWebsalerInfo(String websalerID);
}

package data_stub.websalerdata;

import dataservice.websalerdataservice.WebsalerDataService;
import enumData.ResultMessage;
import po.WebsalerInfoPO;

public class WebsalerDataImpl_stub implements WebsalerDataService {

	@Override
	public WebsalerInfoPO getWebsalerInfo(String websalerID) {
		// TODO Auto-generated method stub
		return new WebsalerInfoPO(null, null);
	}

	@Override
	public ResultMessage setWebsalerInfo(WebsalerInfoPO po) {
		// TODO Auto-generated method stub
		return ResultMessage.Correct;
	}

	@Override
	public ResultMessage addWebsalerInfo(WebsalerInfoPO po) {
		// TODO Auto-generated method stub
		return ResultMessage.Correct;
	}

	@Override
	public ResultMessage deleteWebsalerInfo(String websalerID) {
		// TODO Auto-generated method stub
		return ResultMessage.Correct;
	}
	
}

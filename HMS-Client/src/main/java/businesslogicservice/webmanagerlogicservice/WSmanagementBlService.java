package businesslogicservice.webmanagerlogicservice;

import enumData.ResultMessage;
import vo.WebsalerInfoVO;

public interface WSmanagementBlService {

	public WebsalerInfoVO getWebsaleInfo(String websalerID);
	
	public ResultMessage setWebsalerInfo (WebsalerInfoVO vo);
	
	public boolean addWebsalerInfo(WebsalerInfoVO vo, String password);
	
	public ResultMessage deleteWebsalerInfo(String websalerID);
	
}

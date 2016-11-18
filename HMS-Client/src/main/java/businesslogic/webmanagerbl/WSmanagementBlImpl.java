package businesslogic.webmanagerbl;

import businesslogicservice.webmanagerlogicservice.WSmanagementBlService;
import enumData.ResultMessage;
import vo.WebsalerInfoVO;

public class WSmanagementBlImpl implements WSmanagementBlService{
	
	WebsalerInfoVO webSaler = new WebsalerInfoVO("0001", "1234");
	String pswd = "1234";
	
	//根据ID查看网站营销人员信息
	public WebsalerInfoVO getWebsaleInfo(String websalerID) {
		if(websalerID == webSaler.getWebsalerID())
			return webSaler;
		return null;
	}

	//更新网站营销人员信息
	public ResultMessage setWebsalerInfo(WebsalerInfoVO vo) {
		if(vo == webSaler){
			System.out.println("更新成功");
			return ResultMessage.Correct;
		}
		System.out.println("该用户不存在！");
		return ResultMessage.NotExist;
	}

	//增加网站营销人员
	public boolean addWebsalerInfo(WebsalerInfoVO vo, String password) {
		if(password == pswd){
			System.out.println("添加成功");
			return true;
		}
		System.out.println("密码不符合格式");
		return false;
	}

	//删除网站营销人员
	public ResultMessage deleteWebsalerInfo(String websalerID) {
		if(websalerID == webSaler.getWebsalerID()){
			System.out.println("删除成功");
			return ResultMessage.Correct;
		}
		System.out.println("该用户不存在！");
		return ResultMessage.NotExist;
	}

}

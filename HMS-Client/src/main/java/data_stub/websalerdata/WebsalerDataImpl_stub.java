package data_stub.websalerdata;

import dataservice.websalerdataservice.WebsalerDataService;
import enumData.ResultMessage;
import po.VipUpPO;
import po.WebsalerInfoPO;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class WebsalerDataImpl_stub implements WebsalerDataService {
	ArrayList<WebsalerInfoPO> websalerInfoPOs = new ArrayList<WebsalerInfoPO>();
	WebsalerInfoPO websalerInfoPO1 = new WebsalerInfoPO("0300001","13596297777");
	WebsalerInfoPO websalerInfoPO2 = new WebsalerInfoPO("0300002","15981281919");
	WebsalerInfoPO websalerInfoPO3 = new WebsalerInfoPO("0300003","13236539018");
	ArrayList<VipUpPO> vipUpPOs = new ArrayList<VipUpPO>();
	VipUpPO vipUpPO1 = new VipUpPO(1,100);
	VipUpPO vipUpPO2 = new VipUpPO(2,200);
	VipUpPO vipUpPO3 = new VipUpPO(3,400);
//	VipUpVO vipUpPO4 = new VipUpVO(4,800);
//	VipUpVO vipUpPO5 = new VipUpVO(5,1600);
//	VipUpVO vipUpPO6 = new VipUpVO(6,3200);
//	VipUpVO vipUpPO7 = new VipUpVO(7,6400);
//	VipUpVO vipUpPO8 = new VipUpVO(8,8000);
//	VipUpVO vipUpPO9 = new VipUpVO(9,10000);

	public WebsalerDataImpl_stub() {
		websalerInfoPOs.add(websalerInfoPO1);
		websalerInfoPOs.add(websalerInfoPO2);
		websalerInfoPOs.add(websalerInfoPO3);
		vipUpPOs.add(vipUpPO1);
		vipUpPOs.add(vipUpPO2);
		vipUpPOs.add(vipUpPO3);
//		vipUpPOs.add(vipUpPO4);
//		vipUpPOs.add(vipUpPO5);
//		vipUpPOs.add(vipUpPO6);
//		vipUpPOs.add(vipUpPO7);
//		vipUpPOs.add(vipUpPO8);
//		vipUpPOs.add(vipUpPO9);
	}

	@Override
	public WebsalerInfoPO getWebsalerInfo(String websalerID) {
		for(int i=0;i<websalerInfoPOs.size();i++){
			if(websalerInfoPOs.get(i).getWebsalerID().equals(websalerID))
				return websalerInfoPOs.get(i);
		}
		return null;
	}

	@Override
	public ResultMessage setWebsalerInfo(WebsalerInfoPO po) {
		// TODO Auto-generated method stub
		deleteWebsalerInfo(po.getWebsalerID());
		addWebsalerInfo(po);
		return ResultMessage.Correct;
	}

	@Override
	public ResultMessage addWebsalerInfo(WebsalerInfoPO po) {
		websalerInfoPOs.add(po);
		return ResultMessage.Correct;
	}

	@Override
	public ResultMessage deleteWebsalerInfo(String websalerID) {
		// TODO Auto-generated method stub
		for(int i=0;i<websalerInfoPOs.size();i++){
			if(websalerInfoPOs.get(i).getWebsalerID().equals(websalerID))
				websalerInfoPOs.remove(i);
		}
		return ResultMessage.Correct;
	}

	@Override
	public ArrayList<WebsalerInfoPO> getWebsalerInfoList() throws RemoteException {
		return websalerInfoPOs;
	}

	@Override
	public ResultMessage setVipUpInfo(VipUpPO po) throws RemoteException {
		for(int i=0;i<vipUpPOs.size();i++){
			if(vipUpPOs.get(i).getVipLevel() == po.getVipLevel())
				vipUpPOs.get(i).setCredit(po.getCredit());
		}
		return ResultMessage.Correct;
	}

	@Override
	public ArrayList<VipUpPO> checkVipUpInfo() throws RemoteException {
		return vipUpPOs;
	}

}

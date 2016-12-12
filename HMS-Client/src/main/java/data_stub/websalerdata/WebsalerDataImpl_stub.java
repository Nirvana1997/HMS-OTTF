package data_stub.websalerdata;

import dataservice.websalerdataservice.WebsalerDataService;
import enumData.ResultMessage;
import po.VipUpPO;
import po.WebsalerInfoPO;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class WebsalerDataImpl_stub implements WebsalerDataService {
	ArrayList<WebsalerInfoPO> websalerInfoPOs = new ArrayList<WebsalerInfoPO>();
	WebsalerInfoPO websalerInfoPO1 = new WebsalerInfoPO("001","13596297777");
	WebsalerInfoPO websalerInfoPO2 = new WebsalerInfoPO("002","15981281919");
	WebsalerInfoPO websalerInfoPO3 = new WebsalerInfoPO("003","13236539018");
	ArrayList<VipUpPO> vipUpPOs = new ArrayList<VipUpPO>();
	VipUpPO vipUpPO1 = new VipUpPO(1,100);
	VipUpPO vipUpPO2 = new VipUpPO(2,200);
	VipUpPO vipUpPO3 = new VipUpPO(3,400);
	VipUpPO vipUpPO4 = new VipUpPO(4,800);
	VipUpPO vipUpPO5 = new VipUpPO(5,1600);
	VipUpPO vipUpPO6 = new VipUpPO(6,3200);
	VipUpPO vipUpPO7 = new VipUpPO(7,6400);
	VipUpPO vipUpPO8 = new VipUpPO(8,8000);
	VipUpPO vipUpPO9 = new VipUpPO(9,10000);

	public WebsalerDataImpl_stub() {
		websalerInfoPOs.add(websalerInfoPO1);
		websalerInfoPOs.add(websalerInfoPO2);
		websalerInfoPOs.add(websalerInfoPO3);
		vipUpPOs.add(vipUpPO1);
		vipUpPOs.add(vipUpPO2);
		vipUpPOs.add(vipUpPO3);
		vipUpPOs.add(vipUpPO4);
		vipUpPOs.add(vipUpPO5);
		vipUpPOs.add(vipUpPO6);
		vipUpPOs.add(vipUpPO7);
		vipUpPOs.add(vipUpPO8);
		vipUpPOs.add(vipUpPO9);
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

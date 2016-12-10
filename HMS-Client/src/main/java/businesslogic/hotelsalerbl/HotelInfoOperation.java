package businesslogic.hotelsalerbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogicservice.hotelsalerblservice.HotelsalerblService;

import data_stub.hotelsalerdata.HotelinfoDataImpl_stub;
import dataservice.hotelsalerdataservice.HotelinfoDataService;
import enumData.ResultMessage;
import utility.HotelPVChanger;
import vo.HotelinfoVO;
import vo.OrderVO;

/**
 * 酒店信息相关操作
 * 负责修改酒店信息
 */
public class HotelInfoOperation {
	HotelinfoDataService hotelinfoDataService;

	public HotelInfoOperation() {
		//TODO
		hotelinfoDataService = new HotelinfoDataImpl_stub();
	}

	public ResultMessage modifyHotelInfo(HotelinfoVO vo) throws RemoteException {
		return hotelinfoDataService.setHotelinfo(HotelPVChanger.hotelV2P(vo));
	}

}

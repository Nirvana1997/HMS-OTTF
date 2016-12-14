package businesslogicservice.hotelsalerblservice;


import enumData.Address;
import enumData.SortWay;
import enumData.TradeArea;
import po.HotelinfoPO;
import vo.LimitVO;
import vo.HotelinfoVO;

import java.lang.ref.SoftReference;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * 获取酒店信息数据的接口
 * @author qzh
 */
public interface HotelinfoblService {
	/**
	 * 获得酒店信息
	 * @return
	 */
	public HotelinfoVO getHotelinfo()throws RemoteException;
}

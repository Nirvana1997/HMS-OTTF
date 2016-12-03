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
	 * @param HotelID 酒店编号
	 * @return
	 */
	public HotelinfoVO getHotelinfo(String HotelID)throws RemoteException;

	/**
	 * 根据条件获得酒店列表
	 * @param tradeArea 商圈
	 * @param address 地址
	 * @param sortWay 排序方式
	 * @return
	 */
	public ArrayList<HotelinfoPO> searchHotel(TradeArea tradeArea, Address address, SortWay sortWay) throws RemoteException;
}

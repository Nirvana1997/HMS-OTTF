package businesslogic.logbl;

import vo.HotelinfoVO;

import java.rmi.RemoteException;

/**
 * 酒店信息添加接口
 * @author qzh
 * Created by user on 2016/12/11.
 */
public interface HotelInfoAdder {
    /**
     * 添加酒店信息并添上初始均为0的房间信息
     * @param vo 酒店信息
     * @throws RemoteException
     */
    public void addHotelInfo(HotelinfoVO vo) throws RemoteException;
}

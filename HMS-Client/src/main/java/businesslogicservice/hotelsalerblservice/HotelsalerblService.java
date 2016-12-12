package businesslogicservice.hotelsalerblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import enumData.ResultMessage;
import vo.HotelinfoVO;
import vo.OrderVO;

public interface HotelsalerblService {
    /**
     * 修改酒店信息
     *
     * @param vo 酒店信息
     * @return 是否成功
     * @throws RemoteException
     */
    public ResultMessage modifyHotelInfo(HotelinfoVO vo) throws RemoteException;

    /**
     * 获得当前登录帐号对应酒店信息
     *
     * @return 对应酒店信息
     * @throws RemoteException
     */
    public HotelinfoVO getHotelInfo() throws RemoteException;

    /**
     * 浏览登录帐号对应酒店订单
     *
     * @return 酒店订单列表
     * @throws RemoteException
     */
    public ArrayList<OrderVO> readOrder() throws RemoteException;

    /**
     * 更新订单信息
     *
     * @param orderVO 订单信息
     * @return 是否成功
     * @throws RemoteException
     */
    public ResultMessage updateOrder(OrderVO orderVO) throws RemoteException;

}

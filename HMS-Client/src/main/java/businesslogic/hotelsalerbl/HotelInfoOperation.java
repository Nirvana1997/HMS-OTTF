package businesslogic.hotelsalerbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.logbl.Login;
import businesslogicservice.hotelsalerblservice.HotelsalerblService;

import data_stub.hotelsalerdata.HotelinfoDataImpl_stub;
import dataservice.factory.DataFactory;
import dataservice.hotelsalerdataservice.HotelinfoDataService;
import enumData.ResultMessage;
import rmi.RemoteHelper;
import utility.HotelPVChanger;
import vo.HotelinfoVO;
import vo.OrderVO;

/**
 * 酒店信息相关操作
 * 负责修改酒店信息
 *
 * @author qzh
 */
public class HotelInfoOperation {
    HotelinfoDataService hotelinfoDataService;

    public HotelInfoOperation() {
        //TODO
//        hotelinfoDataService = new HotelinfoDataImpl_stub();
        hotelinfoDataService = RemoteHelper.getInstance().getHotelinfoDataService();
    }

    /**
     * 修改酒店信息
     * @param vo 酒店信息
     * @return 是否成功
     * @throws RemoteException
     */
    public ResultMessage modifyHotelInfo(HotelinfoVO vo) throws RemoteException {
        return hotelinfoDataService.setHotelinfo(HotelPVChanger.hotelV2P(vo));
    }

    /**
     * 获得当前登录帐号对应酒店信息
     * @return 对应酒店信息
     * @throws RemoteException
     */
    public HotelinfoVO getHotelInfo() throws RemoteException {
        return HotelPVChanger.hotelP2V(hotelinfoDataService.getHotelinfo(Login.getNowUserID()));
    }
}

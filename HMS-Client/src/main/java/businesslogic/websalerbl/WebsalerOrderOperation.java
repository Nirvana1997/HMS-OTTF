package businesslogic.websalerbl;

import businesslogic.userbl.impl.UserDataImpl;
import cfg.Temp;
import enumData.CreditRecoverWay;
import enumData.OrderState;
import po.CreditChangePO;
import vo.CanceledExceptionOrderVO;
import vo.OrderVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * 酒店工作人员订单操作
 *
 * @author qzh
 *         Created by user on 2016/12/18.
 */
public class WebsalerOrderOperation {
    WebOrderInfo webOrderInfo;

    CreditInfo creditInfo;

    public WebsalerOrderOperation() {
//        this.webOrderInfo = webOrderInfo;
        creditInfo = new UserDataImpl();
    }

    public ArrayList<OrderVO> getOrderByState(OrderState orderState) throws RemoteException {
        return webOrderInfo.getOrderByState(orderState);
    }

    public ArrayList<CanceledExceptionOrderVO> getCanceledExceptionOrders() throws RemoteException {
        return webOrderInfo.getCanceledExceptionOrders();
    }

    public CanceledExceptionOrderVO getCanceledExceptionOrder(String orderID) throws RemoteException {
        return webOrderInfo.getCanceledExceptionOrder(orderID);
    }

    public void cancelExceptionOrder(CanceledExceptionOrderVO vo, CreditRecoverWay creditRecoverWay) throws RemoteException {
        webOrderInfo.updateExceptionOrder(vo);
        OrderVO orderVO = webOrderInfo.getOrder(vo.getOrderID());
        //恢复全部信用
        if(creditRecoverWay.equals(CreditRecoverWay.All))
            creditInfo.addCredit(new CreditChangePO(orderVO.getUserID(),vo.getOrderID(),vo.getCancelDate(), Temp.reasonOfCancelException,(int)orderVO.getPrice()));
        else if(creditRecoverWay.equals(CreditRecoverWay.Half))
            creditInfo.addCredit(new CreditChangePO(orderVO.getUserID(),vo.getOrderID(),vo.getCancelDate(), Temp.reasonOfCancelException,(int)orderVO.getPrice()/2));
    }
}

package po;

import java.io.Serializable;

/**
 * Created by mac on 2016/12/15.
 */
public class CanceledExceptionOrderPO implements Serializable {
    String orderID;
    String cancelDate;
    String cancelTime;
    String cancelReason;

    public CanceledExceptionOrderPO(String orderID, String cancelDate, String cancelTime, String cancelReason) {
        this.orderID = orderID;
        this.cancelDate = cancelDate;
        this.cancelTime = cancelTime;
        this.cancelReason = cancelReason;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getCancelDate() {
        return cancelDate;
    }

    public void setCancelDate(String cancelDate) {
        this.cancelDate = cancelDate;
    }

    public String getCancelTime() {
        return cancelTime;
    }

    public void setCancelTime(String cancelTime) {
        this.cancelTime = cancelTime;
    }

    public String getCancelReason() {
        return cancelReason;
    }

    public void setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason;
    }
}

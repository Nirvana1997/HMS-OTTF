package po;

/**
 * Created by mac on 2016/12/15.
 */
public class OrderExceptionPO {
    String orderID;
    String cancelDate;
    String cancelTime;
    String cancelReason;
    boolean haveCanceled;

    public OrderExceptionPO(String orderID, String cancelDate, String cancelTime, String cancelReason, boolean haveCanceled) {
        this.orderID = orderID;
        this.cancelDate = cancelDate;
        this.cancelTime = cancelTime;
        this.cancelReason = cancelReason;
        this.haveCanceled = haveCanceled;
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

    public boolean isHaveCanceled() {
        return haveCanceled;
    }

    public void setHaveCanceled(boolean haveCanceled) {
        this.haveCanceled = haveCanceled;
    }
}

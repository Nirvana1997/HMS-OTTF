package po;

import java.io.Serializable;

/**
 * Created by mac on 2016/12/3.
 */
public class CreditRecordPO implements Serializable{
    String date;
    int change;
    int finalCredit;
    String reason;
    String orderID;

    public CreditRecordPO(String date, int change, int finalCredit, String reason, String orderID) {
        this.date = date;
        this.change = change;
        this.finalCredit = finalCredit;
        this.reason = reason;
        this.orderID = orderID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getChange() {
        return change;
    }

    public void setChange(int change) {
        this.change = change;
    }

    public int getFinalCredit() {
        return finalCredit;
    }

    public void setFinalCredit(int finalCredit) {
        this.finalCredit = finalCredit;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }
}

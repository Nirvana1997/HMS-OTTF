package po;

import java.io.Serializable;

/**
 * Created by mac on 2016/12/14.
 */
public class CreditChangePO implements Serializable {
    String userID;
    String orderID;
    String date;
    String reason;
    int value;

    public CreditChangePO(String userID, String orderID, String date, String reason, int value) {
        this.userID = userID;
        this.orderID = orderID;
        this.date = date;
        this.reason = reason;
        this.value = value;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

package presentation.userui;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Created by Administrator on 2016/12/18.
 */
public class tableCredit {
    private final SimpleStringProperty Date = new SimpleStringProperty();
    private final SimpleStringProperty OrderID = new SimpleStringProperty();
    private final SimpleStringProperty Reason = new SimpleStringProperty();
    private final SimpleIntegerProperty Change = new SimpleIntegerProperty();
    private final SimpleIntegerProperty Result = new SimpleIntegerProperty();

    public tableCredit(String date, String orderid, String reason, int change, int result) {
        setDate(date);
        setOrderID(orderid);
        setReason(reason);
        setChange(change);
        setResult(result);
    }

    public String getDate() {
        return Date.get();
    }

    public SimpleStringProperty dateProperty() {
        return Date;
    }

    public void setDate(String date) {
        this.Date.set(date);
    }

    public String getOrderID() {
        return OrderID.get();
    }

    public SimpleStringProperty orderIDProperty() {
        return OrderID;
    }

    public void setOrderID(String orderID) {
        this.OrderID.set(orderID);
    }

    public String getReason() {
        return Reason.get();
    }

    public SimpleStringProperty reasonProperty() {
        return Reason;
    }

    public void setReason(String reason) {
        this.Reason.set(reason);
    }

    public int getChange() {
        return Change.get();
    }

    public SimpleIntegerProperty changeProperty() {
        return Change;
    }

    public void setChange(int change) {
        this.Change.set(change);
    }

    public int getResult() {
        return Result.get();
    }

    public SimpleIntegerProperty resultProperty() {
        return Result;
    }

    public void setResult(int result) {
        this.Result.set(result);
    }


}

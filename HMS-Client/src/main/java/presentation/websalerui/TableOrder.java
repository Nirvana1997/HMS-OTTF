package presentation.websalerui;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by thinkpad on 2016/12/11.
 */
public class TableOrder {
    private final SimpleStringProperty OrderID = new SimpleStringProperty();
    private final SimpleStringProperty UserID = new SimpleStringProperty();
    private final SimpleStringProperty HotelID = new SimpleStringProperty();
    private final SimpleStringProperty State = new SimpleStringProperty();
    private final SimpleStringProperty Reason = new SimpleStringProperty();

    public TableOrder(String orderid, String userid, String hotelid, String state, String reason) {
        setOrderID(orderid);
        setUserID(userid);
        setHotelID(hotelid);
        setState(state);
        setReason(reason);
    }

    /**
     *
     */
    public String getOrderID() {
        return OrderID.get();
    }
    public void setOrderID(String OrderID){
        this.OrderID.set(OrderID);
    }
    public StringProperty OrderIDProperty(){
        return OrderID;
    }

    /**
     *
     */
    public String getUserID() {
        return UserID.get();
    }
    public void setUserID(String UserID){
        this.UserID.set(UserID);
    }
    public StringProperty UserIDProperty(){
        return UserID;
    }

    /**
     *
     */
    public String getHotelID() {
        return HotelID.get();
    }
    public void setHotelID(String hotelID){
        this.HotelID.set(hotelID);
    }
    public StringProperty HotelIDProperty(){
        return HotelID;
    }

    /**
     *
     */
    public String getState(){
        return State.get();
    }
    public void setState(String State){
        this.State.set(State);
    }
    public StringProperty StateProperty(){
        return State;
    }

    /**
     *
     */
    public String getReason(){
        return Reason.get();
    }
    public void setReason(String Reason){
        this.Reason.set(Reason);
    }
    public StringProperty ReasonProperty(){
        return Reason;
    }
}

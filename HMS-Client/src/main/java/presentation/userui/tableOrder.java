package presentation.userui;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by Administrator on 2016/12/8.
 */
public class tableOrder {
    private final SimpleStringProperty OrderID = new SimpleStringProperty();
    private final SimpleStringProperty HotelID = new SimpleStringProperty();
    private final SimpleStringProperty OrderTime = new SimpleStringProperty();
    private final SimpleStringProperty State = new SimpleStringProperty();

    public tableOrder(String orderid, String hotelid, String ordertime, String state){
        setHotelID(hotelid);
        setOrderID(orderid);
        setOrderTime(ordertime);
        setState(state);
    }
    public String getOrderID(){ return OrderID.get();}
    public void setOrderID(String OrderID){ this.OrderID.set(OrderID); }
    public StringProperty OrderIDProperty(){ return OrderID;}

    public String getOrderTime(){ return OrderTime.get();}
    public void setOrderTime(String OrderTime){ this.OrderTime.set(OrderTime); }
    public StringProperty OrderTimeProperty(){ return OrderTime;}

    public String getHotelID(){ return HotelID.get();}
    public void setHotelID(String hotelID){ this.HotelID.set(hotelID); }
    public StringProperty HotelIDProperty(){ return HotelID;}

    public String getState(){ return State.get();}
    public void setState(String State){ this.State.set(State); }
    public StringProperty StateProperty(){ return State;}

}

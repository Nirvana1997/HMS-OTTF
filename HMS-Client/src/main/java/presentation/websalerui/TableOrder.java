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

    public TableOrder(String orderid, String userid, String hotelid, String state) {
        setOrderID(orderid);
        setUserID(userid);
        setHotelID(hotelid);
        setState(state);
    }

    /**
     * 获取/设置订单编号
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
     * 获取/设置用户编号
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
     * 获取/设置酒店编号
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
     * 获取/设置订单状态
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

}

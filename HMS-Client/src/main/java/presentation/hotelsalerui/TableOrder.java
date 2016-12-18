package presentation.hotelsalerui;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by thinkpad on 2016/12/18.
 */
public class TableOrder {
    private final SimpleStringProperty OrderID = new SimpleStringProperty();
    private final SimpleStringProperty UserID = new SimpleStringProperty();
    private final SimpleStringProperty RoomType = new SimpleStringProperty();
    private final SimpleStringProperty State = new SimpleStringProperty();
    private final SimpleStringProperty IntendTime = new SimpleStringProperty();
    private final SimpleStringProperty Price = new SimpleStringProperty();

    public TableOrder(String orderid, String userid, String roomtype, String state, String intendTime, String price) {
        setOrderID(orderid);
        setUserID(userid);
        setRoomType(roomtype);
        setState(state);
        setIntendTime(intendTime);
        setPrice(price);
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
     * 获取/设置房间类型
     */
    public String getRoomType() {
        return RoomType.get();
    }
    public void setRoomType(String roomtype){
        this.RoomType.set(roomtype);
    }
    public StringProperty RoomTypeProperty(){
        return RoomType;
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

    /**
     * 获取/设置预计入住时间
     */
    public String getIntendTime(){
        return IntendTime.get();
    }
    public void setIntendTime(String intendTime){
        this.IntendTime.set(intendTime);
    }
    public StringProperty IntendTimeProperty(){
        return IntendTime;
    }

    /**
     * 获取/设置价格
     */
    public String getPrice(){
        return Price.get();
    }
    public void setPrice(String price){
        this.IntendTime.set(price);
    }
    public StringProperty PriceProperty(){
        return Price;
    }
}

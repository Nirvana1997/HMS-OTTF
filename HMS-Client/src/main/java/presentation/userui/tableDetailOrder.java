package presentation.userui;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by Administrator on 2016/12/16.
 */
public class tableDetailOrder {
    private final SimpleStringProperty OrderID = new SimpleStringProperty();
    private final SimpleStringProperty OrderTime = new SimpleStringProperty();
    private final SimpleStringProperty State = new SimpleStringProperty();
    private final SimpleIntegerProperty PeopleNumber = new SimpleIntegerProperty();
    private final SimpleDoubleProperty Price = new SimpleDoubleProperty();
    private final SimpleStringProperty HaveChild = new SimpleStringProperty();
    private final SimpleStringProperty RoomType = new SimpleStringProperty();
    public tableDetailOrder(String orderid, String ordertime, String state, int peoplenumber, double price,
                                String havechild, String roomtype){
        setOrderID(orderid);
        setOrderTime(ordertime);
        setState(state);
        setPeopleNumber(peoplenumber);
        setPrice(price);
        setHaveChild(havechild);
        setRoomType(roomtype);
    }
    public String getOrderID(){ return OrderID.get();}
    public void setOrderID(String OrderID){ this.OrderID.set(OrderID); }
    public StringProperty OrderIDProperty(){ return OrderID;}

    public String getOrderTime(){ return OrderTime.get();}
    public void setOrderTime(String OrderTime){ this.OrderTime.set(OrderTime); }
    public StringProperty OrderTimeProperty(){ return OrderTime;}

    public String getState(){ return State.get();}
    public void setState(String State){ this.State.set(State); }
    public StringProperty StateProperty(){ return State;}

    public int getPeopleNumber() {return PeopleNumber.get();}
    public SimpleIntegerProperty peopleNumberProperty() {return PeopleNumber;}
    public void setPeopleNumber(int peopleNumber) {this.PeopleNumber.set(peopleNumber);}

    public double getPrice() {return Price.get();}
    public SimpleDoubleProperty priceProperty() {return Price;}
    public void setPrice(double price) {this.Price.set(price);}

    public String getHaveChild() {return HaveChild.get();}
    public SimpleStringProperty haveChildProperty() {return HaveChild;}
    public void setHaveChild(String haveChild) {this.HaveChild.set(haveChild);}

    public String getRoomType() {return RoomType.get();}
    public SimpleStringProperty roomTypeProperty() {return RoomType;}
    public void setRoomType(String roomType) {this.RoomType.set(roomType);}
}

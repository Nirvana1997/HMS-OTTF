package presentation.userui;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Created by Administrator on 2016/12/8.
 */
public class tableHotel {
    private final SimpleStringProperty HotelID = new SimpleStringProperty();
    private final SimpleStringProperty HotelName = new SimpleStringProperty();
    private final SimpleDoubleProperty Price = new SimpleDoubleProperty();
    private final SimpleIntegerProperty Star = new SimpleIntegerProperty();
    private final SimpleDoubleProperty Grade = new SimpleDoubleProperty();
    private final SimpleStringProperty HasNormal = new SimpleStringProperty();
    private final SimpleStringProperty HasAbnormal = new SimpleStringProperty();
    private final SimpleStringProperty HasCanceled= new SimpleStringProperty();

    public tableHotel(String HotelID,String HotelName,Double Price, Integer Star, Double Grade, String HasNormal, String HasAbnormal, String HasCanceled){
        setHotelID(HotelID);
        setHotelName(HotelName);
        setPrice(Price);
        setStar(Star);
        setGrade(Grade);
        setHasNormal(HasNormal);
        setHasAbnormal(HasAbnormal);
        setHasCanceled(HasCanceled);
    }


    public void setHotelID(String hotelID) {this.HotelID.set(hotelID);}
    public void setHotelName(String hotelName) {this.HotelName.set(hotelName);}
    public void setPrice(Double price) {this.Price.set(price);}
    public void setStar(Integer star) {this.Star.set(star);}
    public void setGrade(Double grade) {this.Grade.set(grade);}
    public void setHasNormal(String hasNormal) {this.HasNormal.set(hasNormal);}
    public void setHasAbnormal(String hasAbnormal) {this.HasAbnormal.set(hasAbnormal);}
    public void setHasCanceled(String hasCanceled) {this.HasCanceled.set(hasCanceled);}
    public String getHotelID() {return HotelID.get();}
    public SimpleStringProperty hotelIDProperty() {return HotelID;}
    public String getHotelName() { return HotelName.get();}
    public SimpleStringProperty hotelNameProperty() { return HotelName;}
    public Double getPrice() { return Price.get();}
    public SimpleDoubleProperty priceProperty() {return Price;}
    public Integer getStar() {return Star.get();}
    public SimpleIntegerProperty starProperty() {return Star;}
    public Double getGrade() {return Grade.get();}
    public SimpleDoubleProperty gradeProperty() {return Grade;}
    public String getHasNormal() {return HasNormal.get();}
    public SimpleStringProperty hasNormalProperty() {return HasNormal;}
    public String getHasAbnormal() {return HasAbnormal.get();}
    public SimpleStringProperty hasAbnormalProperty() {return HasAbnormal;}
    public String getHasCanceled() {return HasCanceled.get();}
    public SimpleStringProperty hasCanceledProperty() {return HasCanceled;}
}

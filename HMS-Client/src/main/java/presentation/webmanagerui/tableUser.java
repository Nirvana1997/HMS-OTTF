package presentation.webmanagerui;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by Administrator on 2016/12/8.
 */
public final class tableUser {
    private final SimpleStringProperty userID = new SimpleStringProperty();
    private final SimpleStringProperty userName = new SimpleStringProperty();
    private final SimpleStringProperty userNumber = new SimpleStringProperty();
    private String uuid;

    public tableUser(String userID, String userName, String userNumber){
        setuserID(userID);
        setuserName(userName);
        setuserNumber(userNumber);
    }

    public String getuserID(){ return userID.get();}
    public StringProperty userIDProperty(){ return userID;}
    public void setuserID(String userID) { this.userID.set(userID);}
    public String getuserName(){ return userName.get();}
    public StringProperty userNameProperty(){ return  userName;}
    public void setuserName(String userName) { this.userName.set(userName);}
    public String getuserNumber(){ return userNumber.get();}
    public StringProperty userNumberProperty(){ return  userNumber;}
    public void setuserNumber(String userNumber) { this.userNumber.set(userNumber);}
}

package presentation.webmanagerui;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by Administrator on 2016/12/8.
 */
public final class tableMember {
    private final SimpleStringProperty ID = new SimpleStringProperty();
    private final SimpleStringProperty Name = new SimpleStringProperty();
    private final SimpleStringProperty Number = new SimpleStringProperty();
    private String uuid;

    public tableMember(String ID, String Name, String Number){
        setID(ID);
        setName(Name);
        setNumber(Number);
    }

    public String getID(){ return ID.get();}
    public StringProperty IDProperty(){ return ID;}
    public void setID(String ID) { this.ID.set(ID);}
    public String getName(){ return Name.get();}
    public StringProperty NameProperty(){ return Name;}
    public void setName(String Name) { this.Name.set(Name);}
    public String getNumber(){ return Number.get();}
    public StringProperty NumberProperty(){ return  Number;}
    public void setNumber(String Number) { this.Number.set(Number);}
}

package presentation.logui;

import com.sun.javafx.robot.impl.FXRobotHelper;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.chrono.Chronology;

/**
 * Created by Administrator on 2016/11/25.
 */
public class uiRegister2Controller {
    public Button buttonFinish;
    public TextField textRealName;
    public TextField textIdentity;
    public TextField textPhoneNumber;
    public CheckBox checkPersonal;
    public CheckBox checkEnterprise;
    public DatePicker dateBirthday;
    public ComboBox comboEnterprise;
    public void gotoRegister3() throws IOException {
        String RealName = textRealName.getText();
        String Identity = textIdentity.getText();
        String PhoneNumber = textPhoneNumber.getText();
        boolean isPersonal = checkPersonal.isSelected();
        boolean isEnterprise = checkEnterprise.isSelected();
//        Chronology Birthday = dateBirthday.getChronology();
//        String Enterprise = comboEnterprise.getAccessibleText();

        System.out.print(Identity);
        ObservableList<Stage> stage = FXRobotHelper.getStages();
        Scene scene = new Scene((Parent) FXMLLoader.load(getClass().getResource("sceneRegister3.fxml")));
        stage.get(0).setScene(scene);
    }
}

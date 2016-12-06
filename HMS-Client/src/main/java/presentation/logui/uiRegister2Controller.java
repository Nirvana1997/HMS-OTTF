package presentation.logui;

import businesslogic.logbl.LogController;
import businesslogicservice.logblservice.LogBlService;
import com.sun.javafx.robot.impl.FXRobotHelper;
import com.sun.org.apache.regexp.internal.RE;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import vo.UserInfoVO;

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
    public ToggleGroup UserType;
    public RadioButton typePersonal;
    public RadioButton typeEnterprise;
    public DatePicker dateBirthday;
    public ComboBox comboEnterprise;

    /**
     * 将账号信息存储，并跳转到登录界面3
     * @throws IOException
     */
    public void gotoRegister3() throws IOException {
        String RealName = textRealName.getText();
        String Identity = textIdentity.getText();
        String PhoneNumber = textPhoneNumber.getText();
        boolean isPersonal = typePersonal.isSelected();
        boolean isEnterprise = typeEnterprise.isSelected();
//        uiRegister1Controller uiregister1Controller = new uiRegister1Controller();
//        Chronology Birthday = dateBirthday.getChronology();
//        String Company = comboEnterprise.getAccessibleText();
        LogBlService logBlService = new LogController();
        UserInfoVO userInfoVO = new UserInfoVO(uiRegister1Controller.getUserID(), RealName, Identity, PhoneNumber,0,0);
        logBlService.addUserInfo(userInfoVO);

        //控制台输出当前存入的Userid
        System.out.print(uiRegister1Controller.getUserID());

        ObservableList<Stage> stage = FXRobotHelper.getStages();
        Scene scene = new Scene((Parent) FXMLLoader.load(getClass().getResource("sceneRegister3.fxml")));
        stage.get(0).setScene(scene);
    }
}

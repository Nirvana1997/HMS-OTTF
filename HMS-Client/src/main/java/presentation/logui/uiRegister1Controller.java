package presentation.logui;

import com.sun.javafx.robot.impl.FXRobotHelper;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * Created by Administrator on 2016/11/20.
 */
public class uiRegister1Controller {
    /**
     * 从注册界面1返回到登录界面
     */
    public Button buttonReturn;
    ObservableList<Stage> stage = FXRobotHelper.getStages();
    public void returnToLog() throws IOException {

        Scene scene = new Scene((Parent) FXMLLoader.load(getClass().getResource("sceneLog.fxml")));
        stage.get(0).setScene(scene);
    }

    /**
     * 根据账号密码选择报错或者进行下一步
     */

    public Button buttonNext;
    public TextField textUserID;
    public TextField textPassword;
    public TextField textConfirm;

    public void goToRegister2() throws IOException {
        String UserID = textUserID.getText();
        String Password = textPassword.getText();
        String Confirm = textConfirm.getText();
        //TODO 判断条件需要修改
//        ObservableList<Stage> stage = FXRobotHelper.getStages();
        Scene scene = new Scene((Parent) FXMLLoader.load(getClass().getResource("sceneRegister2.fxml")));
        stage.get(0).setScene(scene);

    }
}

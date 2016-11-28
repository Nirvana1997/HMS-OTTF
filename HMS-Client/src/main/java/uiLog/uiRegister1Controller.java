package uiLog;

import com.sun.javafx.robot.impl.FXRobotHelper;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
    public void returnToLog() throws IOException {
        ObservableList<Stage> stage = FXRobotHelper.getStages();
        Scene scene = new Scene((Parent) FXMLLoader.load(getClass().getResource("sceneLog.fxml")));
        stage.get(0).setScene(scene);
    }
}

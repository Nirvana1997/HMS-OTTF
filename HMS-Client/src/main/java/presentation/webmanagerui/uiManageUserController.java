package presentation.webmanagerui;

import com.sun.javafx.robot.impl.FXRobotHelper;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Administrator on 2016/11/30.
 */
public class uiManageUserController {
    private Button buttonManageUser;
    private Button buttonManageHS;
    private Button buttonManageWS;


    public void gotoManageUser() throws IOException{

    }
    public void gotoManageHS() throws IOException{
        ObservableList<Stage> stage = FXRobotHelper.getStages();
        Scene scene = new Scene((Parent) FXMLLoader.load(getClass().getResource("sceneManageHS.fxml")));
        stage.get(0).setScene(scene);
    }
    public void gotoManageWS() throws IOException{
        ObservableList<Stage> stage = FXRobotHelper.getStages();
        Scene scene = new Scene((Parent) FXMLLoader.load(getClass().getResource("sceneManageWS.fxml")));
        stage.get(0).setScene(scene);
    }
}

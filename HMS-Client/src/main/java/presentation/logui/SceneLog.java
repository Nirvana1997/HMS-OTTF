package presentation.logui;

import com.sun.javafx.robot.impl.FXRobotHelper;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by thinkpad on 2016/11/16.
 */
public class SceneLog {

    private Scene sceneLog;

    public SceneLog() {
        initSceneLog();
    }

    private void initSceneLog(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("sceneLog.fxml"));
            sceneLog = new Scene(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void initUI() throws IOException {
        ObservableList<Stage> stage = FXRobotHelper.getStages();
        Scene scene = new Scene((Parent) FXMLLoader.load(getClass().getResource("sceneLog.fxml")));
        stage.get(0).setScene(scene);
    }

    public Scene getSceneLog() {
        return sceneLog;
    }
}

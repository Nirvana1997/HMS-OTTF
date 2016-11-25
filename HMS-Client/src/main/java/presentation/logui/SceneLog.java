package presentation.logui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

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

    public Scene getSceneLog() {
        return sceneLog;
    }
}

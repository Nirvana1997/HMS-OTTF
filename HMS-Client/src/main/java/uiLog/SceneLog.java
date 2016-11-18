package uiLog;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import uiController.UIController;

import java.io.IOException;

/**
 * Created by thinkpad on 2016/11/16.
 */
public class SceneLog {

    private Scene sceneLog;
    UIController uiController;

    public SceneLog(UIController uiController) {
        this.uiController = uiController;
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

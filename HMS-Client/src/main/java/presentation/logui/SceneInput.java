package presentation.logui;

import com.sun.javafx.robot.impl.FXRobotHelper;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Administrator on 2016/12/22.
 */
public class SceneInput {
    private Scene sceneInput;

    public SceneInput() {
        initSceneLog();
    }
    private void initSceneLog(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("sceneInputIP.fxml"));
            sceneInput = new Scene(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Scene getSceneInput() {
        return sceneInput;
    }
}

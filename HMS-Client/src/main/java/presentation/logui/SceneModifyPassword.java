package presentation.logui;

import com.sun.javafx.robot.impl.FXRobotHelper;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Administrator on 2016/12/3.
 */
public class SceneModifyPassword {

    private Scene sceneModifyPassword;

    public SceneModifyPassword() {
        initSceneModifyPassword();
    }

    private void initSceneModifyPassword(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("sceneModifyPassword.fxml"));
            sceneModifyPassword = new Scene(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Scene getSceneModifyPassword() {
        return sceneModifyPassword;
    }
}

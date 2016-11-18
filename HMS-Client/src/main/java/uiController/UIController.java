package uiController;

import javafx.stage.Stage;
import uiLog.SceneLog;

/**
 * Created by thinkpad on 2016/11/16.
 */
public class UIController {

    private Stage stage;
    private SceneLog sceneLog;

    public UIController(Stage stage) {
        this.stage = stage;
        sceneLog = new SceneLog(this);
        stage.setScene(sceneLog.getSceneLog());
    }

    public Stage getStage(){
        return this.stage;
    }
}

package main;

import javafx.application.Application;
import javafx.stage.Stage;
import presentation.logui.SceneLog;

/**
 * Created by thinkpad on 2016/11/16.
 */
public class Main extends Application{

    private SceneLog sceneLog;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        sceneLog = new SceneLog();
        primaryStage.setTitle("困了么");
        primaryStage.setWidth(1000);
        primaryStage.setHeight(618);
        primaryStage.setResizable(false);
        primaryStage.setScene(sceneLog.getSceneLog());
        primaryStage.show();
    }
}

package main;

import driver.ClientRunner;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import presentation.logui.SceneLog;
import presentation.logui.uiLogController;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by thinkpad on 2016/11/16.
 */
public class Main extends Application{

    private SceneLog sceneLog;

    public static void main(String[] args) throws UnknownHostException {
        ClientRunner clientRunner = new ClientRunner();
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        sceneLog = new SceneLog();

        primaryStage.setTitle("困了么");
        primaryStage.setWidth(1000);
        primaryStage.setHeight(645);
        primaryStage.setResizable(false);

        primaryStage.setScene(sceneLog.getSceneLog());
        primaryStage.show();
    }
}

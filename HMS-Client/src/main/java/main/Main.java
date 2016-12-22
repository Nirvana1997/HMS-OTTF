package main;

import driver.ClientRunner;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import presentation.logui.SceneInput;
import presentation.logui.SceneLog;
import presentation.logui.uiLogController;
import rmi.RemoteHelper;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by thinkpad on 2016/11/16.
 */
public class Main extends Application{

    private SceneInput sceneInput;

    public static void main(String[] args) throws UnknownHostException {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        sceneInput = new SceneInput();

        primaryStage.setWidth(500);
        primaryStage.setHeight(300);
        primaryStage.setResizable(false);
        primaryStage.setScene(sceneInput.getSceneInput());
        primaryStage.show();
    }
}

package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import uiController.UIController;

/**
 * Created by thinkpad on 2016/11/16.
 */
public class Main extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        UIController uiController = new UIController(primaryStage);
        primaryStage.setTitle("困了么");
        primaryStage.setWidth(1000);
        primaryStage.setHeight(618);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}

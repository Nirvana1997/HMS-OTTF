package presentation.webmanagerui;

import com.sun.javafx.robot.impl.FXRobotHelper;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Administrator on 2016/12/1.
 */
public class sceneJump {
    public void gotoManageUser() throws IOException {
        ObservableList<Stage> stage = FXRobotHelper.getStages();
        Scene scene = new Scene((Parent) FXMLLoader.load(getClass().getResource("sceneManageUser.fxml")));
        stage.get(0).setScene(scene);
    }
    public void gotoManageHS() throws IOException{
        ObservableList<Stage> stage = FXRobotHelper.getStages();
        Scene scene = new Scene((Parent) FXMLLoader.load(getClass().getResource("sceneManageHS.fxml")));
        stage.get(0).setScene(scene);
    }
    public void gotoManageWS() throws IOException{
        ObservableList<Stage> stage = FXRobotHelper.getStages();
        Scene scene = new Scene((Parent) FXMLLoader.load(getClass().getResource("sceneManageWS.fxml")));
        stage.get(0).setScene(scene);
    }
    public void gotoChangeUser() throws IOException{
        ObservableList<Stage> stage = FXRobotHelper.getStages();
        Scene scene = new Scene((Parent) FXMLLoader.load(getClass().getResource("sceneChangeUser.fxml")));
        stage.get(0).setScene(scene);
    }
    public void gotoChangeHS() throws IOException{
        ObservableList<Stage> stage = FXRobotHelper.getStages();
        Scene scene = new Scene((Parent) FXMLLoader.load(getClass().getResource("sceneChangeHS.fxml")));
        stage.get(0).setScene(scene);
    }
    public void gotoAddHotel() throws IOException{
        ObservableList<Stage> stage = FXRobotHelper.getStages();
        Scene scene = new Scene((Parent) FXMLLoader.load(getClass().getResource("sceneAddHotel.fxml")));
        stage.get(0).setScene(scene);
    }
    public void gotoAddWS() throws IOException{
        ObservableList<Stage> stage = FXRobotHelper.getStages();
        Scene scene = new Scene((Parent) FXMLLoader.load(getClass().getResource("sceneAddWS.fxml")));
        stage.get(0).setScene(scene);
    }
    public void gotoChangeWS() throws IOException{
        ObservableList<Stage> stage = FXRobotHelper.getStages();
        Scene scene = new Scene((Parent) FXMLLoader.load(getClass().getResource("sceneChangeWS.fxml")));
        stage.get(0).setScene(scene);
    }
}

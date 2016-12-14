package presentation.webmanagerui;

import com.sun.javafx.robot.impl.FXRobotHelper;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import presentation.logui.SceneLog;
import presentation.logui.SceneModifyPassword;
import presentation.userui.uiMyOrderController;
import presentation.userui.uiReadHotelController;
import presentation.userui.uiSearchHotelController;

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
    public void gotoLogin() throws IOException{
        SceneLog sceneLog = new SceneLog();
        sceneLog.initUI();
    }
    /**
     * 修改密码
     * @throws IOException
     */
    private SceneModifyPassword sceneModifyPassword;
    public void gotoModifyPassword() throws IOException{
        sceneModifyPassword = new SceneModifyPassword();
        Stage primaryStage = new Stage();
        primaryStage.setTitle("修改密码");
        primaryStage.setWidth(500);
        primaryStage.setHeight(320);
        primaryStage.setResizable(false);
        primaryStage.setScene(sceneModifyPassword.getSceneModifyPassword());
        primaryStage.show();
    }
    /**
     * 跳出警告窗口
     * @throws IOException
     */
    public void warning() throws IOException{
        Stage secondWindow=new Stage();
        Scene scene=new Scene((Parent) FXMLLoader.load(getClass().getResource("sceneWarning.fxml")));
        secondWindow.setTitle("Warning!");
        secondWindow.setScene(scene);
        secondWindow.show();
        uiManageHSController.choose = false;
        uiManageUserController.choose = false;
        uiManageWSController.choose = false;
    }
    public static String currentUserID;
    public static String currentHSID;
    public static String currentWSID;
    public void setCurrentUserID(String id){currentUserID = id;}
    public void setCurrentHSID(String id){currentHSID = id;}
    public void setCurrentWSID(String id){currentWSID = id;}

}

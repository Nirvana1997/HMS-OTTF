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
    /**
     * 查看用户
     * @throws IOException
     */
    public void gotoManageUser() throws IOException {
        ObservableList<Stage> stage = FXRobotHelper.getStages();
        Scene scene = new Scene((Parent) FXMLLoader.load(getClass().getResource("sceneManageUser.fxml")));
        stage.get(0).setScene(scene);
    }

    /**
     * 查看酒店工作人员
     * @throws IOException
     */
    public void gotoManageHS() throws IOException{
        ObservableList<Stage> stage = FXRobotHelper.getStages();
        Scene scene = new Scene((Parent) FXMLLoader.load(getClass().getResource("sceneManageHS.fxml")));
        stage.get(0).setScene(scene);
    }

    /**
     * 查看网站管理人员
     * @throws IOException
     */
    public void gotoManageWS() throws IOException{
        ObservableList<Stage> stage = FXRobotHelper.getStages();
        Scene scene = new Scene((Parent) FXMLLoader.load(getClass().getResource("sceneManageWS.fxml")));
        stage.get(0).setScene(scene);
    }

    /**
     * 修改用户信息
     * @throws IOException
     */
    public void gotoChangeUser() throws IOException{
        ObservableList<Stage> stage = FXRobotHelper.getStages();
        Scene scene = new Scene((Parent) FXMLLoader.load(getClass().getResource("sceneChangeUser.fxml")));
        stage.get(0).setScene(scene);
    }

    /**
     * 修改酒店工作人员信息
     * @throws IOException
     */
    public void gotoChangeHS() throws IOException{
        ObservableList<Stage> stage = FXRobotHelper.getStages();
        Scene scene = new Scene((Parent) FXMLLoader.load(getClass().getResource("sceneChangeHS.fxml")));
        stage.get(0).setScene(scene);
    }

    /**
     * 添加酒店工作人员
     * @throws IOException
     */
    public void gotoAddHotel() throws IOException{
        ObservableList<Stage> stage = FXRobotHelper.getStages();
        Scene scene = new Scene((Parent) FXMLLoader.load(getClass().getResource("sceneAddHotel.fxml")));
        stage.get(0).setScene(scene);
    }

    /**
     * 添加网站营销人员
     * @throws IOException
     */
    public void gotoAddWS() throws IOException{
        ObservableList<Stage> stage = FXRobotHelper.getStages();
        Scene scene = new Scene((Parent) FXMLLoader.load(getClass().getResource("sceneAddWS.fxml")));
        stage.get(0).setScene(scene);
    }

    /**
     * 修改网站营销人员信息
     * @throws IOException
     */
    public void gotoChangeWS() throws IOException{
        ObservableList<Stage> stage = FXRobotHelper.getStages();
        Scene scene = new Scene((Parent) FXMLLoader.load(getClass().getResource("sceneChangeWS.fxml")));
        stage.get(0).setScene(scene);
    }

    /**
     * 登录界面
     * @throws IOException
     */
    public void gotoLogin() throws IOException{
        SceneLog sceneLog = new SceneLog();
        sceneLog.initUI();
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

    /**
     * 删除成功
     * @throws IOException
     */
    public void deleteSuccess() throws  IOException{
        Stage secondWindow=new Stage();
        Scene scene=new Scene((Parent) FXMLLoader.load(getClass().getResource("sceneDeleteSuccess.fxml")));
        secondWindow.setTitle("Success!");
        secondWindow.setScene(scene);
        secondWindow.show();
    }

    /**
     * 添加成功
     * @throws IOException
     */
    public void addSuccess() throws  IOException{
        Stage secondWindow=new Stage();
        Scene scene=new Scene((Parent) FXMLLoader.load(getClass().getResource("sceneAddSuccess.fxml")));
        secondWindow.setTitle("Success!");
        secondWindow.setScene(scene);
        secondWindow.show();
    }

    /**
     * 修改成功
     * @throws IOException
     */
    public void changeSuccess() throws  IOException{
        Stage secondWindow=new Stage();
        Scene scene=new Scene((Parent) FXMLLoader.load(getClass().getResource("sceneChangeSuccess.fxml")));
        secondWindow.setTitle("Success!");
        secondWindow.setScene(scene);
        secondWindow.show();
    }
    public static String currentUserID;
    public static String currentHSID;
    public static String currentWSID;
    public void setCurrentUserID(String id){currentUserID = id;}
    public void setCurrentHSID(String id){currentHSID = id;}
    public void setCurrentWSID(String id){currentWSID = id;}

}

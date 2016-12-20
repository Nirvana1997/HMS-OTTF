package presentation.userui;

import com.sun.javafx.robot.impl.FXRobotHelper;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import presentation.logui.SceneLog;
import presentation.logui.SceneModifyPassword;
import java.io.IOException;

/**
 * 界面跳转
 * Created by Administrator on 2016/12/3.
 */
public class sceneJump {
    /**
     * 首页
     *
     * @throws IOException
     */
    public void gotoHomePage() throws IOException {
        ObservableList<Stage> stage = FXRobotHelper.getStages();
        Scene scene = new Scene((Parent) FXMLLoader.load(getClass().getResource("sceneHomePage.fxml")));
        stage.get(0).setScene(scene);
    }

    /**
     * 我的订单
     *
     * @throws IOException
     */
    public void gotoMyOrder() throws IOException {
        ObservableList<Stage> stage = FXRobotHelper.getStages();
        Scene scene = new Scene((Parent) FXMLLoader.load(getClass().getResource("sceneMyOrder.fxml")));
        stage.get(0).setScene(scene);
    }

    /**
     * 浏览酒店
     *
     * @throws IOException
     */
    public void gotoReadHotel() throws IOException {
        ObservableList<Stage> stage = FXRobotHelper.getStages();
        Scene scene = new Scene((Parent) FXMLLoader.load(getClass().getResource("sceneReadHotel.fxml")));
        stage.get(0).setScene(scene);
    }

    /**
     * 搜索酒店
     *
     * @throws IOException
     */
    public void gotoSearchHotel() throws IOException {
        ObservableList<Stage> stage = FXRobotHelper.getStages();
        Scene scene = new Scene((Parent) FXMLLoader.load(getClass().getResource("sceneSearchHotel.fxml")));
        stage.get(0).setScene(scene);
    }

    /**
     * 个人信息
     *
     * @throws IOException
     */
    public void gotoUserInfo() throws IOException {
        ObservableList<Stage> stage = FXRobotHelper.getStages();
        Scene scene = new Scene((Parent) FXMLLoader.load(getClass().getResource("sceneUserInfo.fxml")));
        stage.get(0).setScene(scene);
    }

    /**
     * 登录
     *
     * @throws IOException
     */
    public void gotoLogin() throws IOException {
        SceneLog sceneLog = new SceneLog();
        sceneLog.initUI();
    }

    /**
     * 修改密码
     *
     * @throws IOException
     */
    private SceneModifyPassword sceneModifyPassword;

    public void gotoModifyPassword() throws IOException {
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
     * 评价订单
     *
     * @throws IOException
     */
    public void gotoCommentOrder() throws IOException {
        ObservableList<Stage> stage = FXRobotHelper.getStages();
        Scene scene = new Scene((Parent) FXMLLoader.load(getClass().getResource("sceneCommentOrder.fxml")));
        stage.get(0).setScene(scene);
    }

    /**
     * 详细订单
     *
     * @throws IOException
     */
    public void gotoOrder() throws IOException {
        ObservableList<Stage> stage = FXRobotHelper.getStages();
        Scene scene = new Scene((Parent) FXMLLoader.load(getClass().getResource("sceneOrder.fxml")));
        stage.get(0).setScene(scene);
    }

    /**
     * 相应酒店
     *
     * @throws IOException
     */
    public void gotoHotel() throws IOException {
        ObservableList<Stage> stage = FXRobotHelper.getStages();
        Scene scene = new Scene((Parent) FXMLLoader.load(getClass().getResource("sceneHotel.fxml")));
        stage.get(0).setScene(scene);
    }

    /**
     * 预订酒店
     *
     * @throws IOException
     */
    public void gotoReserveHotel() throws IOException {
        ObservableList<Stage> stage = FXRobotHelper.getStages();
        Scene scene = new Scene((Parent) FXMLLoader.load(getClass().getResource("sceneReserveHotel.fxml")));
        stage.get(0).setScene(scene);
    }

    /**
     * 信用历史记录
     *
     * @throws IOException
     */
    public void gotoCreditHistory() throws IOException {
        ObservableList<Stage> stage = FXRobotHelper.getStages();
        Scene scene = new Scene((Parent) FXMLLoader.load(getClass().getResource("sceneCreditHistory.fxml")));
        stage.get(0).setScene(scene);
    }

    /**
     * 跳出警告窗口
     *
     * @throws IOException
     */
    public void warning() throws IOException {
        Stage secondWindow = new Stage();
        Scene scene = new Scene((Parent) FXMLLoader.load(getClass().getResource("sceneWarning.fxml")));
        secondWindow.setTitle("Warning!");
        secondWindow.setScene(scene);
        secondWindow.show();
        uiMyOrderController.chooseOrder = true;
        uiReadHotelController.chooseHotel = true;
        uiSearchHotelController.isFinish = true;
        uiSearchHotelController.isValid = true;
        uiSearchHotelController.chooseHotel = true;
    }

    /**
     * 预订成功
     *
     * @throws IOException
     */
    public void reserveSuccess() throws IOException {
        Stage secondWindow = new Stage();
        Scene scene = new Scene((Parent) FXMLLoader.load(getClass().getResource("sceneReserveSuccess.fxml")));
        secondWindow.initStyle(StageStyle.TRANSPARENT);
        secondWindow.setAlwaysOnTop(true);
        secondWindow.setScene(scene);
        secondWindow.show();

    }

    /**
     * 评价成功
     *
     * @throws IOException
     */
    public void CommentSuccess() throws IOException {
        Stage secondWindow = new Stage();
        Scene scene = new Scene((Parent) FXMLLoader.load(getClass().getResource("sceneCommentSuccess.fxml")));
        secondWindow.initStyle(StageStyle.TRANSPARENT);
        secondWindow.setAlwaysOnTop(true);
        secondWindow.setScene(scene);
        secondWindow.show();
    }

    /**
     * 修改成功
     *
     * @throws IOException
     */
    public void ModifySuccess() throws IOException {
        Stage secondWindow = new Stage();
        Scene scene = new Scene((Parent) FXMLLoader.load(getClass().getResource("sceneModifySuccess.fxml")));
        secondWindow.initStyle(StageStyle.TRANSPARENT);
        secondWindow.setAlwaysOnTop(true);
        secondWindow.setScene(scene);
        secondWindow.show();
    }

    /**
     * 撤回成功
     *
     * @throws IOException
     */
    public void RevokeSuccess() throws IOException {
        Stage secondWindow = new Stage();
        Scene scene = new Scene((Parent) FXMLLoader.load(getClass().getResource("sceneRevokeSuccess.fxml")));
        secondWindow.initStyle(StageStyle.TRANSPARENT);
        secondWindow.setAlwaysOnTop(true);
        secondWindow.setScene(scene);
        secondWindow.show();
    }

    /**
     * 确认预订
     *
     * @throws IOException
     */
    public void ConfirmOrder() throws IOException {
        Stage secondWindow = new Stage();
        Scene scene = new Scene((Parent) FXMLLoader.load(getClass().getResource("sceneConfirmOrder.fxml")));
        secondWindow.initStyle(StageStyle.TRANSPARENT);
        secondWindow.setAlwaysOnTop(true);
        secondWindow.setScene(scene);
        secondWindow.show();
    }

    /**
     * 当前选择酒店的ID
     */
    static String currentHotelid;

    public void setHotelID(String id) {
        currentHotelid = id;
    }

    public static String getHotelID() {
        return currentHotelid;
    }
}

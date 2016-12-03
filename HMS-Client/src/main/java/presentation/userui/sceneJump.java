package presentation.userui;

import com.sun.javafx.robot.impl.FXRobotHelper;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import presentation.logui.SceneLog;

import java.io.IOException;

/**
 * 界面跳转
 * Created by Administrator on 2016/12/3.
 */
public class sceneJump {
    /**
     * 首页
     * @throws IOException
     */
    public void gotoHomePage() throws IOException{
        ObservableList<Stage> stage = FXRobotHelper.getStages();
        Scene scene = new Scene((Parent) FXMLLoader.load(getClass().getResource("sceneHomePage.fxml")));
        stage.get(0).setScene(scene);
    }
    /**
     * 我的订单
     * @throws IOException
     */
    public void gotoMyOrder() throws IOException{
        ObservableList<Stage> stage = FXRobotHelper.getStages();
        Scene scene = new Scene((Parent) FXMLLoader.load(getClass().getResource("sceneMyOrder.fxml")));
        stage.get(0).setScene(scene);
    }
    /**
     * 浏览酒店
     * @throws IOException
     */
    public void gotoReadHotel() throws IOException{
        ObservableList<Stage> stage = FXRobotHelper.getStages();
        Scene scene = new Scene((Parent) FXMLLoader.load(getClass().getResource("sceneReadHotel.fxml")));
        stage.get(0).setScene(scene);
    }
    /**
     * 搜索酒店
     * @throws IOException
     */
    public void gotoSearchHotel() throws IOException{
        ObservableList<Stage> stage = FXRobotHelper.getStages();
        Scene scene = new Scene((Parent) FXMLLoader.load(getClass().getResource("sceneSearchHotel.fxml")));
        stage.get(0).setScene(scene);
    }
    /**
     * 个人信息
     * @throws IOException
     */
    public void gotoUserInfo() throws IOException{
        ObservableList<Stage> stage = FXRobotHelper.getStages();
        Scene scene = new Scene((Parent) FXMLLoader.load(getClass().getResource("sceneUserInfo.fxml")));
        stage.get(0).setScene(scene);
    }
    /**
     * 登录
     * @throws IOException
     */
    public void gotoLogin() throws IOException{
        SceneLog sceneLog = new SceneLog();
        sceneLog.initUI();
    }
}
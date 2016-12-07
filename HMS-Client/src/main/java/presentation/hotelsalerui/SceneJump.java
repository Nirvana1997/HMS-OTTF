package presentation.hotelsalerui;

import com.sun.javafx.robot.impl.FXRobotHelper;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import presentation.logui.SceneLog;

import java.io.IOException;
import java.util.Observable;

/**
 * Created by thinkpad on 2016/12/2.
 */
public class SceneJump {

    /**
     * 跳转到登陆界面
     */
    public void backToLogin() throws IOException {
        ObservableList<Stage> stage = FXRobotHelper.getStages();
        SceneLog sceneLog = new SceneLog();
        stage.get(0).setScene(sceneLog.getSceneLog());
    }

    /**
     * 跳转到酒店信息界面
     */
    public void jumpToSceneHotelInfo() throws IOException {
        ObservableList<Stage> stage = FXRobotHelper.getStages();
        Scene scene = new Scene((Parent) FXMLLoader.load(getClass().getResource("hotelSaler_hotelInfo.fxml")));
        stage.get(0).setScene(scene);
    }

    /**
     * 跳转到酒店客房界面
     */
    public void jumpToSceneHotelRoom() throws IOException{
        ObservableList<Stage> stage = FXRobotHelper.getStages();
        Scene scene = new Scene((Parent) FXMLLoader.load(getClass().getResource("hotelSaler_hotelRoom.fxml")));
        stage.get(0).setScene(scene);
    }

    /**
     * 跳转到酒店订单界面
     */
    public void jumpToSceneHotelOrder() throws IOException{
        ObservableList<Stage> stage = FXRobotHelper.getStages();
        Scene scene = new Scene((Parent) FXMLLoader.load(getClass().getResource("hotelSaler_hotelOrder.fxml")));
        stage.get(0).setScene(scene);
    }

    /**
     * 跳转到酒店促销界面
     */
    public void jumpToSceneHotelSaleStrategy() throws IOException{
        ObservableList<Stage> stage = FXRobotHelper.getStages();
        Scene scene = new Scene((Parent) FXMLLoader.load(getClass().getResource("hotelSaler_hotelSaleStrategy.fxml")));
        stage.get(0).setScene(scene);
    }

    /**
     * 跳转到编辑酒店信息界面
     */
    public void jumpToSceneEditInfo() throws IOException{
        ObservableList<Stage> stage = FXRobotHelper.getStages();
        Scene scene = new Scene((Parent) FXMLLoader.load(getClass().getResource("hotelSaler_EditInfo.fxml")));
        stage.get(0).setScene(scene);
    }
}

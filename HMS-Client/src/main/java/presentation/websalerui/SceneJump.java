package presentation.websalerui;

import com.sun.javafx.robot.impl.FXRobotHelper;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import presentation.logui.SceneLog;

import java.io.IOException;

/**
 * Created by thinkpad on 2016/12/5.
 */
public class SceneJump {
    /**
     * 是否删除promotion的标志
     */
    static boolean isDeletePromotion;

    /**
     * 跳转到销登陆界面
     */
    public void backToLogin() throws IOException {
        ObservableList<Stage> stage = FXRobotHelper.getStages();
        SceneLog sceneLog = new SceneLog();
        stage.get(0).setScene(sceneLog.getSceneLog());
    }

    /**
     * 跳转到销售策略界面
     */
    public void jumpToSceneSaleStrategy() throws IOException {
        ObservableList<Stage> stage = FXRobotHelper.getStages();
        Scene scene = new Scene((Parent) FXMLLoader.load(getClass().getResource("webSaler_saleStrategy.fxml")));
        stage.get(0).setScene(scene);
    }

    /**
     * 跳转到异常订单界面
     */
    public void jumpToSceneOrder() throws IOException {
        ObservableList<Stage> stage = FXRobotHelper.getStages();
        Scene scene = new Scene((Parent) FXMLLoader.load(getClass().getResource("webSaler_Order.fxml")));
        stage.get(0).setScene(scene);
    }

    /**
     * 跳转到信用充值界面
     */
    public void jumpToSceneCredit() throws IOException {
        ObservableList<Stage> stage = FXRobotHelper.getStages();
        Scene scene = new Scene((Parent) FXMLLoader.load(getClass().getResource("webSaler_Credit.fxml")));
        stage.get(0).setScene(scene);
    }

    /**
     * 删除界面
     */
    public void jumpToDeletePromotion() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("delete.fxml"));
        Scene sceneDelete = new Scene(root);
        Stage primaryStage = new Stage();
        primaryStage.setWidth(200);
        primaryStage.setHeight(150);
        primaryStage.setResizable(false);
        primaryStage.setScene(sceneDelete);
        primaryStage.show();
    }

    /**
     * 删除promotion界面传递给promotion界面是否删除promotion
     */
    public static void isDeletePromotion( boolean tag ){
        isDeletePromotion = tag;
    }

    /**
     * 提供是否删除promotion的tag
     */
    public boolean getIsDeletePromotion() {
        return isDeletePromotion;
    }
}

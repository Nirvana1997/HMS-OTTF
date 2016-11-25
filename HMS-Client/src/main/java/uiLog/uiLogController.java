package uiLog;

import com.sun.javafx.robot.impl.FXRobotHelper;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by thinkpad on 2016/11/16.
 */
public class uiLogController {

    @FXML
    private Label labelNextPic;
    @FXML
    private ImageView imgHotel01;
    @FXML
    private ImageView imgHotel02;

    @FXML
    public void setNextPic(){
        imgHotel01.setVisible(false);
        imgHotel02.setVisible(true);
    }
    public Button buttonRegister;
    public void gotoRegister1() throws IOException {
        ObservableList<Stage> stage = FXRobotHelper.getStages();
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("sceneRegister1.fxml")));
        stage.get(0).setScene(scene);
    }
}

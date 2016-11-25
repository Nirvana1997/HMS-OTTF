package presentation.logui;

import com.sun.javafx.robot.impl.FXRobotHelper;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by thinkpad on 2016/11/16.
 */
public class uiLogController {

    int count = 0;

    @FXML
    private ImageView imgHotel01;
    @FXML
    private ImageView imgHotel02;
    @FXML
    private ImageView imgHotel03;

    @FXML
    public void setNextPic(){
        count++;
        if(count % 3 == 0){
            imgHotel01.setVisible(true);
            imgHotel02.setVisible(false);
            imgHotel03.setVisible(false);
        }
        else if(count % 3 == 1){
            imgHotel01.setVisible(false);
            imgHotel02.setVisible(true);
            imgHotel03.setVisible(false);
        }
        else if(count % 3 == 2){
            imgHotel01.setVisible(false);
            imgHotel02.setVisible(false);
            imgHotel03.setVisible(true);
        }
    }
    public Button buttonRegister;
    public void gotoRegister1() throws IOException {
        ObservableList<Stage> stage = FXRobotHelper.getStages();
        Scene scene = new Scene((Parent) FXMLLoader.load(getClass().getResource("sceneRegister1.fxml")));
        stage.get(0).setScene(scene);
    }
}

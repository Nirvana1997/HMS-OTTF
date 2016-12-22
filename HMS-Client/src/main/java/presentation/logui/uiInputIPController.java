package presentation.logui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

/**
 * Created by Administrator on 2016/12/22.
 */
public class uiInputIPController {
    @FXML
    private TextField textIP;

    @FXML
    private Button buttonOK;
    public void Enter() throws IOException {
        String ip = textIP.getText();
        //// TODO: 2016/12/22  
        Stage secondWindow = new Stage();
        Scene scene = new Scene((Parent) FXMLLoader.load(getClass().getResource("sceneLog.fxml")));
        secondWindow.initStyle(StageStyle.TRANSPARENT);
        secondWindow.setScene(scene);
        secondWindow.setAlwaysOnTop(true);
        secondWindow.show();
        buttonOK.getScene().getWindow().hide();
    }
}

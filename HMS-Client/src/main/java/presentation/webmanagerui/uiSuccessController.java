package presentation.webmanagerui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * Created by Administrator on 2016/12/20.
 */
public class uiSuccessController {

    @FXML
    private Button buttonOK;
    public void OK(){
        buttonOK.getScene().getWindow().hide();
    }
}

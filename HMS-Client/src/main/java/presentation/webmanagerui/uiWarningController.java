package presentation.webmanagerui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Administrator on 2016/12/9.
 */
public class uiWarningController implements Initializable {
    /**
     * 未选择用户警告
     */
    @FXML
    private Text warningChooseUser;

    /**
     * 未选择酒店警告
     */
    @FXML
    private Text warningChooseHotel;

    /**
     * 未选择网站营销人员警告
     */
    @FXML
    private Text warningChooseWS;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (uiManageUserController.getChoose() == false) {
            warningChooseUser.setVisible(true);
        }
        if (uiManageHSController.getChoose() == false) {
            warningChooseHotel.setVisible(true);
        }
        if (uiManageWSController.getChoose() == false) {
            warningChooseWS.setVisible(true);
        }

    }
    @FXML
    private Button buttonOK;
    public void OK(){
        buttonOK.getScene().getWindow().hide();
    }
}

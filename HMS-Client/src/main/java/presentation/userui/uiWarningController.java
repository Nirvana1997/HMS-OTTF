package presentation.userui;

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
     * 未选择订单警告
     */
    @FXML
    private Text warningChooseOrder;

    /**
     * 未选择酒店警告
     */
    @FXML
    private Text warningChooseHotel;

    /**
     * 信息填写格式不规范警告
     */
    @FXML
    private Text warningValid;

    /**
     * 信息填写不完整警告
     */
    @FXML
    private Text warningFinish;

    /**
     * 根据情况初始化界面
     *
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (uiMyOrderController.getChooseOrder() == false) {
            warningChooseOrder.setVisible(true);
        }
        if (uiReadHotelController.getChooseHotel() == false) {
            warningChooseHotel.setVisible(true);
        }
        if (uiSearchHotelController.isValid == false) {
            warningValid.setVisible(true);
        }
        if (uiSearchHotelController.isFinish == false) {
            warningFinish.setVisible(true);
        }
        if (uiSearchHotelController.chooseHotel == false) {
            warningChooseHotel.setVisible(true);
        }
    }
    @FXML
    private Button buttonOK;
    public void OK(){
        buttonOK.getScene().getWindow().hide();
    }
}

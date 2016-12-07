package presentation.hotelsalerui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by thinkpad on 2016/12/4.
 */
public class uiEditInfoController implements Initializable{

    private SceneJump sceneJump = new SceneJump();

    /**
     * 登出按钮
     */
    @FXML
    private Label labelExit;

    @FXML
    private TextField textFieldHotelName;
    @FXML
    private TextField textFieldDetailAddress;
    @FXML
    private TextField textFieldTelNumber;
    @FXML
    private TextArea textAreaHotelIntroduction;
    @FXML
    private TextArea textAreaHotelFacility;

    /**
     * 酒店房间按钮点击监听
     */
    public void jumpToSceneHotelRoom() throws IOException {
        sceneJump.jumpToSceneHotelRoom();
    }

    /**
     * 酒店订单按钮点击监听
     */
    public void jumpToSceneHotelOrder() throws IOException {
        sceneJump.jumpToSceneHotelOrder();
    }

    /**
     * 酒店促销按钮点击监听
     */
    public void jumpToSceneHotelSaleStrategy() throws IOException {
        sceneJump.jumpToSceneHotelSaleStrategy();
    }

    /**
     * 鼠标移入登出按钮监听
     */
    public void enteredLabelExit(){
        labelExit.setUnderline(true);
    }

    /**
     * 鼠标移出登出按钮监听
     */
    public void exitedLabelExit(){
        labelExit.setUnderline(false);
    }

    /**
     * 点击登出按钮监听
     */
    public void onClickedLabelExit() throws IOException {
        sceneJump.backToLogin();
    }

    /**
     * 确认修改酒店信息监听
     */
    public void onClickedConfirmEditHotelInfo() throws IOException{
        String hotelName = textFieldHotelName.getText();
        String detailAddress = textFieldDetailAddress.getText();
        String telNumber = textFieldTelNumber.getText();
        String hotelIntroduction = textAreaHotelIntroduction.getText();
        String hotelFacility = textAreaHotelFacility.getText();

        //TODO

        sceneJump.jumpToSceneHotelInfo();
    }

    /**
     * 取消修改酒店信息监听
     */
    public void onClickedCancelEditHotelInfo() throws IOException{
        sceneJump.jumpToSceneHotelInfo();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}

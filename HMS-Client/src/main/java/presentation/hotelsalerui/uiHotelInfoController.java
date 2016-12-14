package presentation.hotelsalerui;

import businesslogic.hotelsalerbl.HotelSalerController;
import businesslogicservice.hotelsalerblservice.HotelinfoblService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by thinkpad on 2016/11/25.
 */
public class uiHotelInfoController implements Initializable{

    private SceneJump sceneJump = new SceneJump();


    /**
     * 登出按钮
     */
    @FXML
    private Label labelExit;

    /**
     * 标题label
     */
    @FXML
    private Label labelTitle;

    /**
     * 编辑酒店信息label
     */
    @FXML
    private Label labelEdit;

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
     * 鼠标移入编辑信息按钮监听
     */
    public void onEnteredLabelEdit(){
        labelEdit.setUnderline(true);
    }

    /**
     * 鼠标移出编辑信息按钮监听
     */
    public void onExitedLabelEdit(){
        labelEdit.setUnderline(false);
    }

    /**
     * 鼠标点击编辑信息按钮监听
     */
    public void onClickedLabelEdit() throws IOException{
        sceneJump.jumpToSceneEditInfo();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}

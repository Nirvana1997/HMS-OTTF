package presentation.hotelsalerui;

import com.sun.javafx.robot.impl.FXRobotHelper;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by thinkpad on 2016/12/3.
 */
public class uiHotelRoomController {

    private SceneJump sceneJump = new SceneJump();

    /**
     * 编辑房间的按钮
     */
    @FXML
    private Label labelEditSingleRoom;
    @FXML
    private Label labelEditDoubleRoom;
    @FXML
    private Label labelEditDisabledRoom;

    /**
     * 显示房间数量的label
     */
    @FXML
    private Label labelSingleRoomNum;
    @FXML
    private Label labelDoubleRoomNum;
    @FXML
    private Label labelDisabledRoomNum;

    /**
     * 显示房间价格的label
     */
    @FXML
    private Label labelSingleRoomPrice;
    @FXML
    private Label labelDoubleRoomPrice;
    @FXML
    private Label labelDisabledRoomPrice;

    /**
     * 输入房间价格的textField
     */
    @FXML
    private TextField textFieldSingleRoomPrice;
    @FXML
    private TextField textFieldDoubleRoomPrice;
    @FXML
    private TextField textFieldDisabledRoomPrice;

    /**
     * 确认取消按钮
     */
    @FXML
    private Button buttonConfirmSingleRoom;
    @FXML
    private Button buttonCancelSingleRoom;
    @FXML
    private Button buttonConfirmDoubleRoom;
    @FXML
    private Button buttonCancelDoubleRoom;
    @FXML
    private Button buttonConfirmDisabledRoom;
    @FXML
    private Button buttonCancelDisabledRoom;

    /**
     * 登出按钮
     */
    @FXML
    private Label labelExit;

    /**
     * 酒店信息按钮点击监听
     */
    public void jumpToSceneHotelInfo() throws IOException {
        sceneJump.jumpToSceneHotelInfo();
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
     * 鼠标进入编辑单人房按钮
     */
    public void onEnteredLabelEditSingleRoom(){
        labelEditSingleRoom.setUnderline(true);
    }

    /**
     * 鼠标移出编辑单人房按钮
     */
    public void onExitedLabelEditSingleRoom(){
        labelEditSingleRoom.setUnderline(false);
    }

    /**
     * 鼠标点击编辑单人房按钮
     */
    public void onClickedLabelEditSingleRoom(){
        labelSingleRoomNum.setVisible(false);
        labelSingleRoomPrice.setVisible(false);
        textFieldSingleRoomPrice.setVisible(true);
        labelEditSingleRoom.setVisible(false);
        buttonConfirmSingleRoom.setVisible(true);
        buttonCancelSingleRoom.setVisible(true);
    }

    /**
     * 鼠标进入编辑双人房按钮
     */
    public void onEnteredLabelEditDoubleRoom(){
        labelEditDoubleRoom.setUnderline(true);
    }

    /**
     * 鼠标移出编辑双人房按钮
     */
    public void onExitedLabelEditDoubleRoom(){
        labelEditDoubleRoom.setUnderline(false);
    }

    /**
     * 鼠标点击编辑双人房按钮
     */
    public void onClickedLabelEditDoubleRoom(){
        labelDoubleRoomNum.setVisible(false);
        labelDoubleRoomPrice.setVisible(false);
        textFieldDoubleRoomPrice.setVisible(true);
        labelEditDoubleRoom.setVisible(false);
        buttonConfirmDoubleRoom.setVisible(true);
        buttonCancelDoubleRoom.setVisible(true);
    }

    /**
     * 鼠标进入编辑残疾人房按钮
     */
    public void onEnteredLabelEditDisabledRoom(){
        labelEditDisabledRoom.setUnderline(true);
    }

    /**
     * 鼠标移出编辑残疾人房按钮
     */
    public void onExitedLabelEditDisabledRoom(){
        labelEditDisabledRoom.setUnderline(false);
    }

    /**
     * 鼠标点击编辑残疾人房按钮
     */
    public void onClickedLabelEditDisabledRoom(){
        labelDisabledRoomNum.setVisible(false);
        labelDisabledRoomPrice.setVisible(false);
        textFieldDisabledRoomPrice.setVisible(true);
        labelEditDisabledRoom.setVisible(false);
        buttonConfirmDisabledRoom.setVisible(true);
        buttonCancelDisabledRoom.setVisible(true);
    }

    /**
     * 确认修改单人房监听
     */
    public void confirmEditSingleRoom(){
        cancelEditSingleRoom();
        // TODO
    }

    /**
     * 取消修改单人房监听
     */
    public void cancelEditSingleRoom(){
        labelEditSingleRoom.setVisible(true);
        buttonConfirmSingleRoom.setVisible(false);
        buttonCancelSingleRoom.setVisible(false);
        textFieldSingleRoomPrice.setVisible(false);
        labelSingleRoomNum.setVisible(true);
        labelSingleRoomPrice.setVisible(true);
    }

    /**
     * 确认修改双人房监听
     */
    public void confirmEditDoubleRoom(){
        cancelEditDoubleRoom();
        // TODO
    }

    /**
     * 取消修改双人房监听
     */
    public void cancelEditDoubleRoom(){
        labelEditDoubleRoom.setVisible(true);
        buttonConfirmDoubleRoom.setVisible(false);
        buttonCancelDoubleRoom.setVisible(false);
        textFieldDoubleRoomPrice.setVisible(false);
        labelDoubleRoomNum.setVisible(true);
        labelDoubleRoomPrice.setVisible(true);
    }

    /**
     * 确认修改残疾人房监听
     */
    public void confirmEditDisabledRoom(){
        cancelEditDisabledRoom();
        // TODO
    }

    /**
     * 取消修改残疾人房监听
     */
    public void cancelEditDisabledRoom(){
        labelEditDisabledRoom.setVisible(true);
        buttonConfirmDisabledRoom.setVisible(false);
        buttonCancelDisabledRoom.setVisible(false);
        textFieldDisabledRoomPrice.setVisible(false);
        labelDisabledRoomNum.setVisible(true);
        labelDisabledRoomPrice.setVisible(true);
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
}

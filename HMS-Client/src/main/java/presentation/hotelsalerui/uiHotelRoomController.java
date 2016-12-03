package presentation.hotelsalerui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

/**
 * Created by thinkpad on 2016/12/3.
 */
public class uiHotelRoomController {

    private SceneJump sceneJump = new SceneJump();

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
     * 输入房间数量的textField
     */
    @FXML
    private TextField textFieldSingleRoomNum;
    @FXML
    private TextField textFieldDoubleRoomNum;
    @FXML
    private TextField textFieldDisabledRoomNum;

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
        textFieldSingleRoomNum.setVisible(true);
        textFieldSingleRoomPrice.setVisible(true);
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
        textFieldDoubleRoomNum.setVisible(true);
        textFieldDoubleRoomPrice.setVisible(true);
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
        textFieldDisabledRoomNum.setVisible(true);
        textFieldDisabledRoomPrice.setVisible(true);
    }
}

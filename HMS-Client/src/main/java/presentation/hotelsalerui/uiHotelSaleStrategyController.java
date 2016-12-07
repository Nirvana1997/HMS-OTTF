package presentation.hotelsalerui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

/**
 * Created by thinkpad on 2016/12/3.
 */
public class uiHotelSaleStrategyController {

    private SceneJump sceneJump = new SceneJump();

    /**
     * 登出按钮
     */
    @FXML
    private Label labelExit;

    /**
     * 生日特惠pane
     */
    @FXML
    private AnchorPane panePromotionBirthday;

    /**
     * 双11活动pane
     */
    @FXML
    private AnchorPane panePromotionDoubleOne;

    /**
     * 合作企业活动pane
     */
    @FXML
    private AnchorPane panePromotionCompany;

    /**
     * 三间及以上预定特惠pane
     */
    @FXML
    private AnchorPane panePromotionThreeRooms;

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
     * 酒店房间按钮点击监听
     */
    public void jumpToSceneHotelRoom() throws IOException {
        sceneJump.jumpToSceneHotelRoom();
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
     * 显示生日特惠界面
     */
    public void showPromotionBirthday() {
        panePromotionBirthday.setVisible(true);
        panePromotionDoubleOne.setVisible(false);
        panePromotionCompany.setVisible(false);
        panePromotionThreeRooms.setVisible(false);
    }

    /**
     * 显示双十一特惠界面
     */
    public void showPromotionDoubleOne() {
        panePromotionBirthday.setVisible(false);
        panePromotionDoubleOne.setVisible(true);
        panePromotionCompany.setVisible(false);
        panePromotionThreeRooms.setVisible(false);
    }

    /**
     * 显示合作企业特惠界面
     */
    public void showPromotionCompany() {
        panePromotionBirthday.setVisible(false);
        panePromotionDoubleOne.setVisible(false);
        panePromotionCompany.setVisible(true);
        panePromotionThreeRooms.setVisible(false);
    }

    /**
     * 显示三间及以上预定特惠界面
     */
    public void showPromotionThreeRooms() {
        panePromotionBirthday.setVisible(false);
        panePromotionDoubleOne.setVisible(false);
        panePromotionCompany.setVisible(false);
        panePromotionThreeRooms.setVisible(true);
    }
}

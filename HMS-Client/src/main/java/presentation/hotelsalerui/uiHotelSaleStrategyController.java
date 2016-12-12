package presentation.hotelsalerui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

/**
 * Created by thinkpad on 2016/12/3.
 */
public class uiHotelSaleStrategyController {

    private SceneJump sceneJump = new SceneJump();

    /**
     * 编辑按钮代号
     * 1-编辑生日promotion按钮
     * 2-编辑双十一promotion按钮
     * 3-编辑合作企业promotion按钮
     * 4-编辑三间及以上promotion按钮
     */
    private static int promptionType;

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
     * 生日特惠信息pane
     */
    @FXML
    private AnchorPane paneInfoPromotionBirthday;

    /**
     * 双11活动信息pane
     */
    @FXML
    private AnchorPane paneInfoPromotionDoubleOne;

    /**
     * 合作企业活动信息pane
     */
    @FXML
    private AnchorPane paneInfoPromotionCompany;

    /**
     * 三间及以上预定特惠信息pane
     */
    @FXML
    private AnchorPane paneInfoPromotionThreeRooms;

    /**
     * 编辑promotion界面
     */
    @FXML
    private AnchorPane paneEditPromotion;

    /**
     * 编辑promotion界面————选择修改活动类型menuButton
     */
    @FXML
    private MenuButton menuButtonEdit_ChoosePromotionType;

    /**
     * 新建promotion界面————活动名字textField
     */
    @FXML
    private TextField textFieldPromotionName;

    /**
     * promotion开始时间label和textField
     */
    @FXML
    private Label labelPromotionBeginTime;
    @FXML
    private TextField textFieldPromotionBeginTime;

    /**
     * promotion结束时间label和textField
     */
    @FXML
    private Label labelPromotionEndTime;
    @FXML
    private TextField textFieldPromotionEndTime;

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
        paneEditPromotion.setVisible(false);
    }

    /**
     * 显示双十一特惠界面
     */
    public void showPromotionDoubleOne() {
        panePromotionBirthday.setVisible(false);
        panePromotionDoubleOne.setVisible(true);
        panePromotionCompany.setVisible(false);
        panePromotionThreeRooms.setVisible(false);
        paneEditPromotion.setVisible(false);
    }

    /**
     * 显示合作企业特惠界面
     */
    public void showPromotionCompany() {
        panePromotionBirthday.setVisible(false);
        panePromotionDoubleOne.setVisible(false);
        panePromotionCompany.setVisible(true);
        panePromotionThreeRooms.setVisible(false);
        paneEditPromotion.setVisible(false);
    }

    /**
     * 显示三间及以上预定特惠界面
     */
    public void showPromotionThreeRooms() {
        panePromotionBirthday.setVisible(false);
        panePromotionDoubleOne.setVisible(false);
        panePromotionCompany.setVisible(false);
        panePromotionThreeRooms.setVisible(true);
        paneEditPromotion.setVisible(false);
    }

    public void onClickedEditPromotionBirthday() {
        promptionType = 1;
        paneInfoPromotionBirthday.setVisible(false);
        paneEditPromotion.setVisible(true);
    }

    public void onClickedEditPromotionDoubleOne() {
        promptionType = 2;
        paneInfoPromotionDoubleOne.setVisible(false);
        paneEditPromotion.setVisible(true);
    }

    public void onClickedEditPromotionCompany() {
        promptionType = 3;
        paneInfoPromotionCompany.setVisible(false);
        paneEditPromotion.setVisible(true);
    }

    public void onClickedEditPromotionThreeRooms() {
        promptionType = 4;
        paneInfoPromotionThreeRooms.setVisible(false);
        paneEditPromotion.setVisible(true);
    }

    /**
     * 新建promotion按钮监听
     */
    public void onClickedNewPromotion() {
        menuButtonEdit_ChoosePromotionType.setVisible(false);
        textFieldPromotionName.setVisible(true);
        labelPromotionBeginTime.setVisible(false);
        labelPromotionEndTime.setVisible(false);
        textFieldPromotionBeginTime.setVisible(true);
        textFieldPromotionEndTime.setVisible(true);
        //TODO
    }

    /**
     * 删除promotion按钮监听
     */
    public void onClickedDeletePromotion() throws IOException{
        sceneJump.jumpToDeletePromotion();
        boolean isDeletePromotion = sceneJump.getIsDeletePromotion();
        if(isDeletePromotion) {
            // TODO
        }
    }

    /**
     * 确认修改promotion按钮监听
     */
    public void onClickedConfirmEditPromotion() {
        // TODO
        if(promptionType == 1){

        }
        else if(promptionType == 2){

        }
        else if(promptionType == 3){

        }
        else if(promptionType == 4){

        }
        this.onClickedCancelEditPromotion();
    }

    /**
     * 取消修改promotion按钮监听
     */
    public void onClickedCancelEditPromotion() {
        menuButtonEdit_ChoosePromotionType.setVisible(true);
        textFieldPromotionName.setVisible(false);
        labelPromotionBeginTime.setVisible(true);
        labelPromotionEndTime.setVisible(true);
        textFieldPromotionBeginTime.setVisible(false);
        textFieldPromotionEndTime.setVisible(false);

        if(promptionType == 1){
            paneInfoPromotionBirthday.setVisible(true);
            paneEditPromotion.setVisible(false);
        }
        else if(promptionType == 2){
            paneInfoPromotionDoubleOne.setVisible(true);
            paneEditPromotion.setVisible(false);
        }
        else if(promptionType == 3){
            paneInfoPromotionCompany.setVisible(true);
            paneEditPromotion.setVisible(false);
        }
        else if(promptionType == 4){
            paneInfoPromotionThreeRooms.setVisible(true);
            paneEditPromotion.setVisible(false);
        }
    }


}

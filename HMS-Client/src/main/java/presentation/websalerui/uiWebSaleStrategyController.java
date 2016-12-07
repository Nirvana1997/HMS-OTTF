package presentation.websalerui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

/**
 * Created by hyx on 2016/11/25.
 */
public class uiWebSaleStrategyController {

    private SceneJump sceneJump = new SceneJump();

    /**
     * 优惠活动按钮
     */
    @FXML
    private ImageView imageSale111;
    @FXML
    private ImageView imageSale112;
    @FXML
    private ImageView imageVIP1;
    @FXML
    private ImageView imageVIP2;
    @FXML
    private ImageView imageMember1;
    @FXML
    private ImageView imageMember2;

    /**
     * 登出按钮
     */
    @FXML
    private Label labelExit;


    /**
     * 活动界面
     */
    @FXML
    private AnchorPane paneDoubleOne;
    @FXML
    private AnchorPane paneVIP;
    @FXML
    private AnchorPane paneMember;

    /**
     * 编辑促销策略界面
     */
    @FXML
    private AnchorPane paneEditPromotion;

    /**
     * 编辑按钮
     */
    @FXML
    private Label labelEditDoubleOne;
    @FXML
    private Label labelEditVIP;
    @FXML
    private Label labelEditMember;

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
     * 下一张图片的点击次数
     */
    private static int doubleOneCount = 0;
    private static int VIPCount = 0;
    private static int memberCount = 0;

    /**
     * 编辑按钮代号
     * 1-编辑双十一promotion按钮
     * 2-编辑特定商圈VIP promotion按钮
     * 3-编辑会员等级与折扣promotion按钮
     */
    private static int labelEditNumber = 0;

    /**
     * 跳转到异常订单界面
     */
    public void jumpToSceneOrder() throws IOException {
        sceneJump.jumpToSceneOrder();
    }

    /**
     * 跳转到信用充值界面
     */
    public void jumpToSceneCredit() throws IOException {
        sceneJump.jumpToSceneCredit();
    }

    /**
     * 双十一优惠活动按钮监听
     */
    @FXML
    public void work11(){
        paneDoubleOne.setVisible(true);
        paneVIP.setVisible(false);
        paneMember.setVisible(false);

        imageSale111.setVisible(false);
        imageSale112.setVisible(true);
        imageVIP1.setVisible(true);
        imageVIP2.setVisible(false);
        imageMember1.setVisible(true);
        imageMember2.setVisible(false);

        paneEditPromotion.setVisible(false);
    }

    /**
     * 特定地址商圈优惠活动按钮监听
     */
    @FXML
    public void workVIP(){
        paneDoubleOne.setVisible(false);
        paneVIP.setVisible(true);
        paneMember.setVisible(false);

        imageSale111.setVisible(true);
        imageSale112.setVisible(false);
        imageVIP1.setVisible(false);
        imageVIP2.setVisible(true);
        imageMember1.setVisible(true);
        imageMember2.setVisible(false);

        paneEditPromotion.setVisible(false);
    }

    /**
     * 会员等级与折扣按钮监听
     */
    @FXML
    public void workMember(){
        paneDoubleOne.setVisible(false);
        paneVIP.setVisible(false);
        paneMember.setVisible(true);

        imageSale111.setVisible(true);
        imageSale112.setVisible(false);
        imageVIP1.setVisible(true);
        imageVIP2.setVisible(false);
        imageMember1.setVisible(false);
        imageMember2.setVisible(true);

        paneEditPromotion.setVisible(false);
    }

    /**
     * 双11活动下一张监听
     */
    public void doubleOneNext(){
        doubleOneCount++;

    }

    /**
     * 双11活动上一张监听
     */
    public void doubleOneBefore(){
        doubleOneCount--;

    }

    /**
     * member活动下一张监听
     */
    public void memberNext(){
        memberCount++;

    }

    /**
     * member活动上一张监听
     */
    public void memberBefore(){
        memberCount--;

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
     * 显示编辑界面
     */
    private void showEditPane() {
        paneDoubleOne.setVisible(false);
        paneVIP.setVisible(false);
        paneMember.setVisible(false);
        paneEditPromotion.setVisible(true);
    }

    /**
     * 编辑双十一活动监听
     */
    public void onClickedEditDoubleOne() {
        this.showEditPane();
        labelEditNumber = 1;
        //TODO
    }

    /**
     * 编辑特定商圈VIP活动监听
     */
    public void onClickedEditVIP() {
        this.showEditPane();
        labelEditNumber = 2;
        //TODO
    }

    /**
     * 编辑会员等级活动监听
     */
    public void onClickedEditMember() {
        this.showEditPane();
        labelEditNumber = 3;
        //TODO
    }

    /**
     * 新建promotion按钮监听
     */
    public void onClickedNewPromotion() {
        menuButtonEdit_ChoosePromotionType.setVisible(false);
        textFieldPromotionName.setVisible(true);

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
        if(labelEditNumber == 1){

        }
        else if(labelEditNumber == 2){

        }
        else if(labelEditNumber == 3){

        }
        this.onClickedCancelEditPromotion();
    }

    /**
     * 取消修改promotion按钮监听
     */
    public void onClickedCancelEditPromotion() {
        if(labelEditNumber == 1){
            paneDoubleOne.setVisible(true);
            paneVIP.setVisible(false);
            paneMember.setVisible(false);
            paneEditPromotion.setVisible(false);
        }
        else if(labelEditNumber == 2){
            paneDoubleOne.setVisible(false);
            paneVIP.setVisible(true);
            paneMember.setVisible(false);
            paneEditPromotion.setVisible(false);
        }
        else if(labelEditNumber == 3){
            paneDoubleOne.setVisible(false);
            paneVIP.setVisible(false);
            paneMember.setVisible(true);
            paneEditPromotion.setVisible(false);
        }
    }
}

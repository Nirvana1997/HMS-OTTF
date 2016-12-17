package presentation.hotelsalerui;

import enumData.PromotionType;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
     * 活动点击次数
     */
    private static int birthdayCount = 0;
    private static int doubleOneCount = 0;
    private static int companyCount = 0;
    private static int threeRoomsCount = 0;

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
     * promotion开始时间datePicker
     */
    @FXML
    private DatePicker datePickerBeginTime;

    /**
     * promotion结束时间datePicker
     */
    @FXML
    private DatePicker datePickerEndTime;

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

    /**
     * 获取日期
     * @param ld 日期选取器
     * @return Date格式的日期
     */
    public static Date getDate(DatePicker ld) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.parse(ld.getValue().toString());
    }

    /**
     * 设置promotion面板内容
     * @param n
     * @param promotionType
     */
    private void initPromotionContent(int n, PromotionType promotionType) {
        if(promotionType == PromotionType.Hotel_Birth){
//            labelNamePromotionDoubleOne.setText(promotionDoubleOne.get(n).getPromotionName());
//            labelInfoPromotionDoubleOne.setText(promotionDoubleOne.get(n).getDescription());
//            labelDatePromotionDoubleOne.setText(promotionDoubleOne.get(n).getStartDate() + "~" + promotionDoubleOne.get(n).getEndDate());
        }
        else if(promotionType == PromotionType.Hotel_Period){
//            labelNamePromotionVIP.setText(promotionVIP.get(n).getPromotionName());
//            labelInfoPromotionVIP.setText(promotionVIP.get(n).getDescription());
//            labelDatePromotionVIP.setText(promotionVIP.get(n).getStartDate() + "~" + promotionVIP.get(n).getEndDate());
//            labelTradeArea.setText(String.valueOf(promotionVIP.get(n).getTradeArea()));
        }
        else if(promotionType == PromotionType.Hotel_Company){
//            labelNamePromotionMember.setText(promotionMember.get(n).getPromotionName());
//            labelInfoPromotionMember.setText(promotionMember.get(n).getDescription());
//            labelDatePromotionMember.setText(promotionMember.get(n).getStartDate() + "~" + promotionMember.get(n).getEndDate());
        }
        else if(promotionType == PromotionType.Hotel_Num){

        }
    }

    /**
     * 生日特惠活动下一张监听
     */
    public void birthdayNext() {
        birthdayCount++;

    }

    /**
     * 生日特惠活动上一张监听
     */
    public void birthdayBefore() {
        birthdayCount--;
    }


    /**
     * 双11活动下一张监听
     */
    public void doubleOneNext(){
        doubleOneCount++;
//        int n = Math.abs(doubleOneCount % lengthPromotionDoubleOne);
//        this.initPromotionContent(n, PromotionType.Web_Period);
    }

    /**
     * 双11活动上一张监听
     */
    public void doubleOneBefore() {
        doubleOneCount--;
//        int n = Math.abs(doubleOneCount % lengthPromotionDoubleOne);
//        this.initPromotionContent(n,PromotionType.Web_Period);
    }

    /**
     * 合作企业下一张监听
     */
    public void companyNext(){
        companyCount++;
    }

    /**
     * 合作企业上一张监听
     */
    public void companyBefore(){
        companyCount--;
    }

    /**
     * 三间及以上活动下一张监听
     */
    public void threeRoomsNext(){
        threeRoomsCount++;
    }

    /**
     * 三间及以上活动上一张监听
     */
    public void threeRoomsBefore(){
        threeRoomsCount--;
    }

    /**
     * 显示编辑生日特惠界面
     */
    public void onClickedEditPromotionBirthday() {
        promptionType = 1;
        paneInfoPromotionBirthday.setVisible(false);
        paneEditPromotion.setVisible(true);
    }

    /**
     * 显示编辑双十一活动界面
     */
    public void onClickedEditPromotionDoubleOne() {
        promptionType = 2;
        paneInfoPromotionDoubleOne.setVisible(false);
        paneEditPromotion.setVisible(true);
    }

    /**
     * 显示编辑合作企业界面
     */
    public void onClickedEditPromotionCompany() {
        promptionType = 3;
        paneInfoPromotionCompany.setVisible(false);
        paneEditPromotion.setVisible(true);
    }

    /**
     * 显示编辑三间及以上特惠活动界面
     */
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

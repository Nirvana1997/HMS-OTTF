package presentation.hotelsalerui;

import businesslogic.hotelsalerbl.HotelSalerController;
import businesslogic.logbl.LogController;
import businesslogicservice.hotelsalerblservice.HotelsalerblService;
import businesslogicservice.logblservice.LogBlService;
import enumData.PromotionType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import utility.UiFormatChanger;
import vo.PromotionVO;

import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

/**
 * Created by thinkpad on 2016/12/3.
 */
public class uiHotelSaleStrategyController implements Initializable{

    private SceneJump sceneJump = new SceneJump();
    private HotelsalerblService hotelsalerblService;
    LogBlService logBl = new LogController();

    /**
     * 促销策略arraylist和其长度
     */
    private ArrayList<PromotionVO> promotionBirthday;
    private int lengthPromotionBirthday;
    private ArrayList<PromotionVO> promotionDoubleOne;
    private int lengthPromotionDoubleOne;
    private ArrayList<PromotionVO> promotionCompany;
    private int lengthPromotionCompany;
    private ArrayList<PromotionVO> promotionThreeRooms;
    private int lengthPromotionThreeRooms;

    public uiHotelSaleStrategyController() throws RemoteException {
    }

    String companyId = "";

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        hotelsalerblService = new HotelSalerController();
        this.initPromotionList();

        // 如果初始化生日promotion时得到的list长度为0
        if(promotionBirthday.size() == 0){
            labelPromotionBirthdayName.setText("");
            labelPromotionBirthdayContent.setText("");
        }else{
            lengthPromotionBirthday = promotionBirthday.size();
            //初始化promotion面板
            this.initPromotionContent(0, PromotionType.Hotel_Birth);
        }

        // 如果初始化双十一promotion时得到的list长度为0
        if(promotionDoubleOne.size() == 0){
            labelPromotionDoubleOneName.setText("");
            labelPromotionDoubleOneTime.setText("");
            labelPromotionDoubleOneContent.setText("");
        }else{
            lengthPromotionDoubleOne = promotionDoubleOne.size();
            this.initPromotionContent(0, PromotionType.Hotel_Period);
        }

        // 如果初始化企业promotion时得到的list长度为0
        if(promotionCompany.size() == 0){
            labelPromotionCompanyName.setText("");
            labelPromotionCompanyTime.setText("");
            labelPromotionCompanyContent.setText("");
        }else{
            lengthPromotionCompany = promotionCompany.size();
            this.initPromotionContent(0, PromotionType.Hotel_Company);
        }

        // 如果初始化三间及以上promotion时得到的list长度为0
        if(promotionThreeRooms.size() == 0){
            labelPromotionThreeRoomsName.setText("");
            labelPromotionThreeRoomsTime.setText("");
            labelPromotionThreeRoomsContent.setText("");
        }else{
            lengthPromotionThreeRooms = promotionThreeRooms.size();
            this.initPromotionContent(0, PromotionType.Hotel_Num);
        }

        // 初始化合作企业menuButton
        try {
            ArrayList<String> companyArray = hotelsalerblService.showAllCompanys();
            for (int i = 0; i < companyArray.size(); i++) {
                MenuItem menuItem = new MenuItem(companyArray.get(i));
                menuButtonChooseCompany.getItems().add(menuItem);
                menuItem.setOnAction(event -> {
                    menuButtonChooseCompany.setText(menuItem.getText());
                    try {
                        this.companyId = hotelsalerblService.getCompanyID(menuItem.getText());
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                });
            }

        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    private void initPromotionList(){
        // 获取list对象
        try {
            promotionBirthday = hotelsalerblService.getPromotion(PromotionType.Hotel_Birth);
            promotionDoubleOne = hotelsalerblService.getPromotion(PromotionType.Hotel_Period);
            promotionCompany = hotelsalerblService.getPromotion(PromotionType.Hotel_Company);
            promotionThreeRooms = hotelsalerblService.getPromotion(PromotionType.Hotel_Num);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

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
     * 是否新建promotion
     */
    private boolean isNewPromotion;

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
     * 编辑活动名字textField
     */
    @FXML
    private TextField textFieldPromotionName;

    /**
     * 折扣textField
     */
    @FXML
    private TextField textFieldDiscount;

    /**
     * 编辑活动内容textArea
     */
    @FXML
    private TextArea textAreaPromotionContent;

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

    @FXML
    private Label labelPromotionBirthdayName;
    @FXML
    private Label labelPromotionBirthdayTime;
    @FXML
    private Label labelPromotionBirthdayContent;

    @FXML
    private Label labelPromotionDoubleOneName;
    @FXML
    private Label labelPromotionDoubleOneTime;
    @FXML
    private Label labelPromotionDoubleOneContent;

    @FXML
    private Label labelPromotionCompanyName;
    @FXML
    private Label labelPromotionCompanyTime;
    @FXML
    private Label labelPromotionCompanyContent;

    @FXML
    private Label labelPromotionThreeRoomsName;
    @FXML
    private Label labelPromotionThreeRoomsTime;
    @FXML
    private Label labelPromotionThreeRoomsContent;
    @FXML
    private Label labelPleaseNew;
    @FXML
    private MenuButton menuButtonChooseCompany;
    @FXML
    private Label labelCooperationCompany;

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
        logBl.logOut();
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
        paneInfoPromotionBirthday.setVisible(true);
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
        paneInfoPromotionDoubleOne.setVisible(true);
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
        paneInfoPromotionCompany.setVisible(true);
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
        paneInfoPromotionThreeRooms.setVisible(true);
    }

    /**
     * 设置promotion面板内容
     * @param n
     * @param promotionType
     */
    private void initPromotionContent(int n, PromotionType promotionType) {
        this.initPromotionList();
        if(promotionType == PromotionType.Hotel_Birth){
            labelPromotionBirthdayName.setText(promotionBirthday.get(n).getPromotionName());
            labelPromotionBirthdayContent.setText(promotionBirthday.get(n).getDescription());
        }
        else if(promotionType == PromotionType.Hotel_Period){
            labelPromotionDoubleOneName.setText(promotionDoubleOne.get(n).getPromotionName());
            labelPromotionDoubleOneTime.setText(UiFormatChanger.dateToString(promotionDoubleOne.get(n).getStartDate()) + "~" + UiFormatChanger.dateToString(promotionDoubleOne.get(n).getEndDate()));
            labelPromotionDoubleOneContent.setText(promotionDoubleOne.get(n).getDescription());
        }
        else if(promotionType == PromotionType.Hotel_Company){
            labelPromotionCompanyName.setText(promotionCompany.get(n).getPromotionName());
            labelPromotionCompanyTime.setText(UiFormatChanger.dateToString(promotionCompany.get(n).getStartDate()) + "~" + UiFormatChanger.dateToString(promotionCompany.get(n).getEndDate()));
            labelPromotionCompanyContent.setText(promotionCompany.get(n).getDescription());
            try {
                ArrayList<String> companyArrayList = hotelsalerblService.showAllCompanys();
                labelCooperationCompany.setText(companyArrayList.get(0));
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        else if(promotionType == PromotionType.Hotel_Num){
            labelPromotionThreeRoomsName.setText(promotionThreeRooms.get(n).getPromotionName());
            labelPromotionThreeRoomsTime.setText(UiFormatChanger.dateToString(promotionThreeRooms.get(n).getStartDate()) + "~" + UiFormatChanger.dateToString(promotionThreeRooms.get(n).getEndDate()));
            labelPromotionThreeRoomsContent.setText(promotionThreeRooms.get(n).getDescription());
        }
    }

    /**
     * 生日特惠活动下一张监听
     */
    public void birthdayNext() {
        if(lengthPromotionBirthday > 0){
            birthdayCount++;
            int n = Math.abs(birthdayCount % lengthPromotionBirthday);
            this.initPromotionContent(n, PromotionType.Hotel_Birth);
        }
    }

    /**
     * 生日特惠活动上一张监听
     */
    public void birthdayBefore() {
        if(lengthPromotionBirthday > 0){
            birthdayCount--;
            int n = Math.abs(birthdayCount % lengthPromotionBirthday);
            this.initPromotionContent(n, PromotionType.Hotel_Birth);
        }
    }


    /**
     * 双11活动下一张监听
     */
    public void doubleOneNext(){
        if(lengthPromotionDoubleOne > 0){
            doubleOneCount++;
            int n = Math.abs(doubleOneCount % lengthPromotionDoubleOne);
            this.initPromotionContent(n, PromotionType.Hotel_Period);
        }
    }

    /**
     * 双11活动上一张监听
     */
    public void doubleOneBefore() {
        if(lengthPromotionDoubleOne > 0){
            doubleOneCount--;
            int n = Math.abs(doubleOneCount % lengthPromotionDoubleOne);
            this.initPromotionContent(n, PromotionType.Hotel_Period);
        }
    }

    /**
     * 合作企业下一张监听
     */
    public void companyNext(){
        if(lengthPromotionCompany > 0){
            companyCount++;
            int n = Math.abs(companyCount % lengthPromotionCompany);
            this.initPromotionContent(n, PromotionType.Hotel_Company);
        }
    }

    /**
     * 合作企业上一张监听
     */
    public void companyBefore(){
        if(lengthPromotionCompany > 0){
            companyCount--;
            int n = Math.abs(companyCount % lengthPromotionCompany);
            this.initPromotionContent(n, PromotionType.Hotel_Company);
        }
    }

    /**
     * 三间及以上活动下一张监听
     */
    public void threeRoomsNext(){
        if(lengthPromotionThreeRooms > 0){
            threeRoomsCount++;
            int n = Math.abs(threeRoomsCount % lengthPromotionThreeRooms);
            this.initPromotionContent(n, PromotionType.Hotel_Num);
        }
    }

    /**
     * 三间及以上活动上一张监听
     */
    public void threeRoomsBefore(){
        if(lengthPromotionThreeRooms > 0){
            threeRoomsCount--;
            int n = Math.abs(threeRoomsCount % lengthPromotionThreeRooms);
            this.initPromotionContent(n, PromotionType.Hotel_Num);
        }
    }

    /**
     * 显示编辑生日特惠界面
     */
    public void onClickedEditPromotionBirthday() {
        promptionType = 1;
        menuButtonChooseCompany.setVisible(false);
        datePickerBeginTime.setVisible(false);
        datePickerEndTime.setVisible(false);
        textAreaPromotionContent.setText(labelPromotionBirthdayContent.getText());
        textFieldPromotionName.setText(labelPromotionBirthdayName.getText());
        for(int i = 0; i < lengthPromotionBirthday; i++){
            if(promotionBirthday.get(i).getPromotionName().equals(labelPromotionBirthdayName.getText()))
                textFieldDiscount.setText(String.valueOf(promotionBirthday.get(i).getDiscountTenRate()));
        }
        paneInfoPromotionBirthday.setVisible(false);
        paneEditPromotion.setVisible(true);
    }

    /**
     * 显示编辑双十一活动界面
     */
    public void onClickedEditPromotionDoubleOne() {
        promptionType = 2;
        menuButtonChooseCompany.setVisible(false);
        datePickerBeginTime.setVisible(true);
        datePickerEndTime.setVisible(true);
        datePickerBeginTime.setValue(null);
        datePickerEndTime.setValue(null);
        textAreaPromotionContent.setText(labelPromotionDoubleOneContent.getText());
        textFieldPromotionName.setText(labelPromotionDoubleOneName.getText());
        for(int i = 0; i < lengthPromotionDoubleOne; i++){
            if(promotionDoubleOne.get(i).getPromotionName().equals(labelPromotionDoubleOneName.getText()))
                textFieldDiscount.setText(String.valueOf(promotionDoubleOne.get(i).getDiscountTenRate()));
        }
        paneInfoPromotionDoubleOne.setVisible(false);
        paneEditPromotion.setVisible(true);
    }

    /**
     * 显示编辑合作企业界面
     */
    public void onClickedEditPromotionCompany() {
        promptionType = 3;
        menuButtonChooseCompany.setVisible(true);
        datePickerBeginTime.setVisible(true);
        datePickerEndTime.setVisible(true);
        datePickerBeginTime.setValue(null);
        datePickerEndTime.setValue(null);
        textAreaPromotionContent.setText(labelPromotionCompanyContent.getText());
        textFieldPromotionName.setText(labelPromotionCompanyName.getText());
        for(int i = 0; i < lengthPromotionCompany; i++){
            if(promotionCompany.get(i).getPromotionName().equals(labelPromotionCompanyName.getText()))
                textFieldDiscount.setText(String.valueOf(promotionCompany.get(i).getDiscountTenRate()));
        }
        paneInfoPromotionCompany.setVisible(false);
        paneEditPromotion.setVisible(true);
    }

    /**
     * 显示编辑三间及以上特惠活动界面
     */
    public void onClickedEditPromotionThreeRooms() {
        promptionType = 4;
        menuButtonChooseCompany.setVisible(false);
        datePickerBeginTime.setVisible(true);
        datePickerEndTime.setVisible(true);
        datePickerBeginTime.setValue(null);
        datePickerEndTime.setValue(null);
        textAreaPromotionContent.setText(labelPromotionThreeRoomsContent.getText());
        textFieldPromotionName.setText(labelPromotionThreeRoomsName.getText());
        for(int i = 0; i < lengthPromotionThreeRooms; i++){
            if(promotionThreeRooms.get(i).getPromotionName().equals(labelPromotionThreeRoomsName.getText()))
                textFieldDiscount.setText(String.valueOf(promotionThreeRooms.get(i).getDiscountTenRate()*10));
        }
        paneInfoPromotionThreeRooms.setVisible(false);
        paneEditPromotion.setVisible(true);
    }

    /**
     * 新建promotion按钮监听
     */
    public void onClickedNewPromotion() {
        isNewPromotion = true;
        datePickerBeginTime.setValue(null);
        datePickerEndTime.setValue(null);
        textAreaPromotionContent.setText("");
        textFieldPromotionName.setText("");
        textFieldDiscount.setText("");
    }

    /**
     * 删除promotion按钮监听
     */
    public void onClickedDeletePromotion() throws IOException{
        System.out.println("hh");
        sceneJump.jumpToDeletePromotion();
        boolean isDeletePromotion = sceneJump.getIsDeletePromotion();
        if(isDeletePromotion) {
            if(promptionType == 1){
                hotelsalerblService.deletePromotion(labelPromotionBirthdayName.getText());
                lengthPromotionBirthday--;
                if(lengthPromotionBirthday == 0){
                    labelPromotionBirthdayName.setText("");
                    labelPromotionBirthdayContent.setText("");
                }
                else {
                    int n = Math.abs(birthdayCount % lengthPromotionBirthday);
                    this.initPromotionContent(n, PromotionType.Hotel_Birth);
                }
            }
            else if(promptionType == 2){
                hotelsalerblService.deletePromotion(labelPromotionDoubleOneName.getText());
                lengthPromotionDoubleOne--;
                if(lengthPromotionDoubleOne == 0){
                    labelPromotionDoubleOneName.setText("");
                    labelPromotionDoubleOneContent.setText("");
                    labelPromotionDoubleOneTime.setText("");
                }
                else{
                    int n = Math.abs(doubleOneCount % lengthPromotionDoubleOne);
                    this.initPromotionContent(n, PromotionType.Hotel_Period);
                }
            }
            else if(promptionType == 3){
                hotelsalerblService.deletePromotion(labelPromotionCompanyName.getText());
                lengthPromotionCompany--;
                if(lengthPromotionCompany == 0){
                    labelPromotionCompanyName.setText("");
                    labelPromotionCompanyContent.setText("");
                    labelPromotionCompanyTime.setText("");
                }
                else{
                    int n = Math.abs(companyCount % lengthPromotionCompany);
                    this.initPromotionContent(n, PromotionType.Hotel_Company);
                }
            }
            else if(promptionType == 4){
                hotelsalerblService.deletePromotion(labelPromotionThreeRoomsName.getText());
                lengthPromotionThreeRooms--;
                if(lengthPromotionThreeRooms == 0){
                    labelPromotionThreeRoomsName.setText("");
                    labelPromotionThreeRoomsContent.setText("");
                    labelPromotionThreeRoomsTime.setText("");
                }
                else{
                    int n = Math.abs(threeRoomsCount % lengthPromotionThreeRooms);
                    this.initPromotionContent(n, PromotionType.Hotel_Num);
                }
            }
        }
    }

    /**
     * 确认修改promotion按钮监听
     */
    public void onClickedConfirmEditPromotion() {
        String name = textFieldPromotionName.getText();
        double discount = Double.parseDouble(textFieldDiscount.getText());
        Date beginTime = null;
        Date endTime = null;
        String description = textAreaPromotionContent.getText();

        if (isNewPromotion){
            if(promptionType == 1){
                PromotionVO vo = new PromotionVO(name, description, PromotionType.Hotel_Birth, null, null, discount);
                try {
                    hotelsalerblService.addPromotion(vo);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                this.initPromotionList();
                lengthPromotionBirthday = promotionBirthday.size();
                int n = Math.abs(birthdayCount % lengthPromotionBirthday);
                this.initPromotionContent(n, PromotionType.Hotel_Birth);
            }
            else if(promptionType == 2){
                try {
                    beginTime = UiFormatChanger.getDate(datePickerBeginTime);
                    endTime = UiFormatChanger.getDate(datePickerEndTime);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                PromotionVO vo = new PromotionVO(name, description, PromotionType.Hotel_Period, beginTime, endTime, discount);
                try {
                    hotelsalerblService.addPromotion(vo);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                this.initPromotionList();
                lengthPromotionDoubleOne = promotionDoubleOne.size();
                int n = Math.abs(doubleOneCount % lengthPromotionDoubleOne);
                this.initPromotionContent(n, PromotionType.Web_Period);
            }
            else if(promptionType == 3){
                try {
                    beginTime = UiFormatChanger.getDate(datePickerBeginTime);
                    endTime = UiFormatChanger.getDate(datePickerEndTime);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                PromotionVO vo = new PromotionVO(name, description, PromotionType.Hotel_Company, beginTime, endTime, discount, companyId);
                try {
                    hotelsalerblService.addPromotion(vo);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                this.initPromotionList();
                lengthPromotionCompany = promotionCompany.size();
                int n = Math.abs(companyCount % lengthPromotionCompany);
                this.initPromotionContent(n, PromotionType.Hotel_Company);
            }
            else if(promptionType == 4){
                try {
                    beginTime = UiFormatChanger.getDate(datePickerBeginTime);
                    endTime = UiFormatChanger.getDate(datePickerEndTime);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                PromotionVO vo = new PromotionVO(name, description, PromotionType.Hotel_Num, beginTime, endTime, discount);
                try {
                    hotelsalerblService.addPromotion(vo);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                this.initPromotionList();
                lengthPromotionThreeRooms = promotionThreeRooms.size();
                int n = Math.abs(threeRoomsCount % lengthPromotionThreeRooms);
                this.initPromotionContent(n, PromotionType.Hotel_Num);
            }
            this.onClickedCancelEditPromotion();
        }
        // 修改营销策略
        else {
            if(promptionType == 1 && promotionBirthday.size() > 0){
                PromotionVO vo = new PromotionVO(name, description, PromotionType.Hotel_Birth, null, null, discount);
                try {
                    hotelsalerblService.setPromotion(vo);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                this.initPromotionList();
                lengthPromotionBirthday = promotionBirthday.size();
                int n = Math.abs(birthdayCount % lengthPromotionBirthday);
                this.initPromotionContent(n, PromotionType.Hotel_Birth);
                this.onClickedCancelEditPromotion();
            }
            else if(promptionType == 2 && promotionDoubleOne.size() > 0){
                try {
                    beginTime = UiFormatChanger.getDate(datePickerBeginTime);
                    endTime = UiFormatChanger.getDate(datePickerEndTime);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                PromotionVO vo = new PromotionVO(name, description, PromotionType.Hotel_Period, beginTime, endTime, discount);
                try {
                    hotelsalerblService.setPromotion(vo);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                this.initPromotionList();
                lengthPromotionDoubleOne = promotionDoubleOne.size();
                int n = Math.abs(doubleOneCount % lengthPromotionDoubleOne);
                this.initPromotionContent(n, PromotionType.Web_Period);
                this.onClickedCancelEditPromotion();
            }
            else if(promptionType == 3 && promotionCompany.size() > 0){
                try {
                    beginTime = UiFormatChanger.getDate(datePickerBeginTime);
                    endTime = UiFormatChanger.getDate(datePickerEndTime);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                PromotionVO vo = new PromotionVO(name, description, PromotionType.Hotel_Company, beginTime, endTime, discount, companyId);
                try {
                    hotelsalerblService.setPromotion(vo);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                this.initPromotionList();
                lengthPromotionCompany = promotionCompany.size();
                int n = Math.abs(companyCount % lengthPromotionCompany);
                this.initPromotionContent(n, PromotionType.Hotel_Company);
                this.onClickedCancelEditPromotion();
            }
            else if(promptionType == 4 && promotionThreeRooms.size() > 0){
                try {
                    beginTime = UiFormatChanger.getDate(datePickerBeginTime);
                    endTime = UiFormatChanger.getDate(datePickerEndTime);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                PromotionVO vo = new PromotionVO(name, description, PromotionType.Hotel_Num, beginTime, endTime, discount);
                try {
                    hotelsalerblService.setPromotion(vo);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                this.initPromotionList();
                lengthPromotionThreeRooms = promotionThreeRooms.size();
                int n = Math.abs(threeRoomsCount % lengthPromotionThreeRooms);
                this.initPromotionContent(n, PromotionType.Hotel_Num);
                this.onClickedCancelEditPromotion();
            }
            else {
                labelPleaseNew.setVisible(true);
            }
        }
    }

    /**
     * 取消修改promotion按钮监听
     */
    public void onClickedCancelEditPromotion() {
        isNewPromotion = false;
        labelPleaseNew.setVisible(false);
        menuButtonChooseCompany.setVisible(false);

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

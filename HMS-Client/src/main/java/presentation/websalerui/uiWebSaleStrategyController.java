package presentation.websalerui;

import businesslogic.logbl.LogController;
import businesslogicservice.logblservice.LogBlService;
import enumData.TradeArea;
import businesslogic.websalerbl.WebsalerController;
import businesslogicservice.websalerblservice.WebsalerblService;
import enumData.PromotionType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
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
 * Created by hyx on 2016/11/25.
 */
public class uiWebSaleStrategyController implements Initializable{

    private SceneJump sceneJump = new SceneJump();

    private WebsalerblService websalerbl;
    LogBlService logBl = new LogController();

    private String tradeArea = "";

    /**
     * 促销策略arraylist和其长度
     */
    private ArrayList<PromotionVO> promotionDoubleOne;
    private int lengthPromotionDoubleOne;
    private ArrayList<PromotionVO> promotionVIP;
    private int lengthPromotionVIP;
    private ArrayList<PromotionVO> promotionMember;
    private int lengthPromotionMember;

    public uiWebSaleStrategyController() throws RemoteException {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        websalerbl = new WebsalerController();
        this.initPromotionList();

        // 如果初始化promotion时得到的list长度为0
        if(promotionDoubleOne.size() == 0){
            labelNamePromotionDoubleOne.setText("");
            labelInfoPromotionDoubleOne.setText("");
            labelDatePromotionDoubleOne.setText("");
        }else{
            lengthPromotionDoubleOne = promotionDoubleOne.size();
            //初始化promotion面板
            this.initPromotionContent(0, PromotionType.Web_Period);
        }

        if(promotionVIP.size() == 0){
            labelNamePromotionVIP.setText("");
            labelInfoPromotionVIP.setText("");
            labelDatePromotionVIP.setText("");
            labelTradeArea.setText("");
        }else{
            lengthPromotionVIP = promotionVIP.size();
            this.initPromotionContent(0, PromotionType.Web_TradeArea);
        }

        if(promotionMember.size() == 0){
            labelNamePromotionMember.setText("");
            labelInfoPromotionMember.setText("");
            labelDatePromotionMember.setText("");
            labelLevel1.setText("");
            labelLevel2.setText("");
            labelLevel3.setText("");
        }else{
            lengthPromotionDoubleOne = promotionDoubleOne.size();
            lengthPromotionVIP = promotionVIP.size();
            lengthPromotionMember = promotionMember.size();
            this.initPromotionContent(0, PromotionType.Web_Vip);
        }

        // 初始化编辑界面选择商圈menuButton
        for(TradeArea area:TradeArea.values()){
            String text = "";
            if(area == TradeArea.Changjiang){
                text = "长江";
            }
            else if(area == TradeArea.Huanghe){
                text = "黄河";
            }
            else if(area == TradeArea.Nanhai){
                text = "南海";
            }
            MenuItem menuItem = new MenuItem(text);
            menuButtonTradeArea.getItems().add(menuItem);
            menuItem.setOnAction(event -> {
                menuButtonTradeArea.setText(menuItem.getText());
                this.tradeArea = area.toString();
            });
        }
    }

    private void initPromotionList(){
        // 获取list对象
        try {
            promotionDoubleOne = websalerbl.getPromotionList(PromotionType.Web_Period);
            promotionVIP = websalerbl.getPromotionList(PromotionType.Web_TradeArea);
            promotionMember = websalerbl.getPromotionList(PromotionType.Web_Vip);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private Label labelPleaseTishi;

    /**
     * promotion面板内容
     */
    @FXML
    private Label labelNamePromotionDoubleOne;
    @FXML
    private Label labelNamePromotionVIP;
    @FXML
    private Label labelNamePromotionMember;

    @FXML
    private Label labelInfoPromotionDoubleOne;
    @FXML
    private Label labelInfoPromotionVIP;
    @FXML
    private Label labelInfoPromotionMember;

    @FXML
    private Label labelDatePromotionDoubleOne;
    @FXML
    private Label labelDatePromotionVIP;
    @FXML
    private Label labelDatePromotionMember;


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
     * 活动折扣textField
     */
    @FXML
    private TextField textFieldDiscount;

    /**
     * 新建promotion界面————活动名字textField
     */
    @FXML
    private TextField textFieldPromotionName;

    /**
     * promotion开始时间datePicker
     */

    @FXML
    private DatePicker datePickerPromotionBeginTime;

    /**
     * promotion结束时间datePicker
     */

    @FXML
    private DatePicker datePickerPromotionEndTime;

    /**
     * 编辑会员等级策略pane
     */
    @FXML
    private AnchorPane paneEditMember;

    /**
     * 选择商圈menuButton
     */
    @FXML
    private MenuButton menuButtonTradeArea;

    /**
     * 商圈label
     */
    @FXML
    private Label labelTradeArea;

    /**
     * 会员等级label
     */
    @FXML
    private Label labelLevel1;
    @FXML
    private Label labelLevel2;
    @FXML
    private Label labelLevel3;

    /**
     * 会员等级textField
     */
    @FXML
    private TextField textFieldLevel1;
    @FXML
    private TextField textFieldLevel2;
    @FXML
    private TextField textFieldLevel3;

    /**
     * 新建活动警告
     */
    @FXML
    private Label labelPleasePromotion;

    /**
     * 下一张图片的点击次数
     */
    private static int doubleOneCount = 0;
    private static int VIPCount = 0;
    private static int memberCount = 0;

    /**
     * 是否点击新建按钮
     */
    boolean isClickedButtonNew;

    /**
     * 编辑按钮代号
     * 1-编辑双十一promotion按钮
     * 2-编辑特定商圈VIP promotion按钮
     * 3-编辑会员等级与折扣promotion按钮
     */
    private static int labelEditNumber = 0;

    /**
     * 编辑promotion内容的textArea
     */
    @FXML
    private TextArea textAreaPromotonContent;

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
     * 跳转到制定等级策略
     */
    public void jumpToSceneMemberLevelUp() throws IOException {
        sceneJump.jumpToSceneMemberUp();
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
     * 设置promotion面板内容
     * @param n
     * @param promotionType
     */
    private void initPromotionContent(int n, PromotionType promotionType) {
        this.initPromotionList();
        if(promotionType == PromotionType.Web_Period){
            labelNamePromotionDoubleOne.setText(promotionDoubleOne.get(n).getPromotionName());
            labelInfoPromotionDoubleOne.setText(promotionDoubleOne.get(n).getDescription());
            labelDatePromotionDoubleOne.setText(UiFormatChanger.dateToString(promotionDoubleOne.get(n).getStartDate()) + "~" + UiFormatChanger.dateToString(promotionDoubleOne.get(n).getEndDate()));
        }
        else if(promotionType == PromotionType.Web_TradeArea){
            labelNamePromotionVIP.setText(promotionVIP.get(n).getPromotionName());
            labelInfoPromotionVIP.setText(promotionVIP.get(n).getDescription());
            labelDatePromotionVIP.setText(UiFormatChanger.dateToString(promotionVIP.get(n).getStartDate()) + "~" + UiFormatChanger.dateToString(promotionVIP.get(n).getEndDate()));
            labelTradeArea.setText(String.valueOf(promotionVIP.get(n).getTradeArea()));
        }
        else if(promotionType == PromotionType.Web_Vip){
            labelNamePromotionMember.setText(promotionMember.get(n).getPromotionName());
            labelInfoPromotionMember.setText(promotionMember.get(n).getDescription());

            for(int i = 0; i < promotionMember.size(); i++){
                int level = promotionMember.get(i).getVipLevel();
                if(level == 1){
                    labelLevel1.setText(String.valueOf(promotionMember.get(i).getDiscountTenRate()));
                }
                else if(level == 2){
                    labelLevel2.setText(String.valueOf(promotionMember.get(i).getDiscountTenRate()));
                }
                else if(level == 3){
                    labelLevel3.setText(String.valueOf(promotionMember.get(i).getDiscountTenRate()));
                }
            }
        }
    }

    /**
     * 双11活动下一张监听
     */
    public void doubleOneNext(){
        if(lengthPromotionDoubleOne > 0){
            doubleOneCount++;
            int n = Math.abs(doubleOneCount % lengthPromotionDoubleOne);
            this.initPromotionContent(n,PromotionType.Web_Period);
        }
    }

    /**
     * 双11活动上一张监听
     */
    public void doubleOneBefore() {
        if(lengthPromotionDoubleOne > 0){
            doubleOneCount--;
            int n = Math.abs(doubleOneCount % lengthPromotionDoubleOne);
            this.initPromotionContent(n,PromotionType.Web_Period);
        }
    }

    /**
     * 特定商圈活动下一张监听
     */
    public void vipNext() {
        if(lengthPromotionVIP > 0){
            VIPCount++;
            int n = Math.abs(VIPCount % lengthPromotionVIP);
            this.initPromotionContent(n, PromotionType.Web_TradeArea);
        }
    }

    /**
     * 特定商圈活动上一张监听
     */
    public void vipBefore() {
        if(lengthPromotionVIP > 0){
            VIPCount--;
            int n = Math.abs(VIPCount % lengthPromotionVIP);
            this.initPromotionContent(n, PromotionType.Web_TradeArea);
        }
    }

    /**
     * member活动下一张监听
     */
    public void memberNext(){
        if(lengthPromotionMember > 0){
            memberCount++;
            int n = Math.abs(memberCount % lengthPromotionMember);
            this.initPromotionContent(n, PromotionType.Web_Vip);
        }
    }

    /**
     * member活动上一张监听
     */
    public void memberBefore() {
        if(lengthPromotionMember > 0){
            memberCount--;
            int n = Math.abs(memberCount % lengthPromotionMember);
            this.initPromotionContent(n, PromotionType.Web_Vip);
        }
    }

    /**
     * 鼠标移入登出按钮监听
     */
    public void enteredLabelExit() {
        labelExit.setUnderline(true);
    }

    /**
     * 鼠标移出登出按钮监听
     */
    public void exitedLabelExit() {
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
     * 显示编辑界面
     */
    private void showEditPane() {
        paneDoubleOne.setVisible(false);
        paneVIP.setVisible(false);
        paneMember.setVisible(false);
        paneEditMember.setVisible(false);
        menuButtonTradeArea.setVisible(false);
        paneEditPromotion.setVisible(true);
    }

    /**
     * 编辑双十一活动监听
     */
    public void onClickedEditDoubleOne() {
        this.showEditPane();
        datePickerPromotionEndTime.setVisible(true);
        datePickerPromotionBeginTime.setVisible(true);
        textFieldPromotionName.setText(labelNamePromotionDoubleOne.getText());
        textAreaPromotonContent.setText(labelInfoPromotionDoubleOne.getText());
        labelEditNumber = 1;
    }

    /**
     * 编辑特定商圈VIP活动监听
     */
    public void onClickedEditVIP() {
        this.showEditPane();
        labelPleaseTishi.setVisible(true);
        menuButtonTradeArea.setVisible(true);
        datePickerPromotionEndTime.setVisible(true);
        datePickerPromotionBeginTime.setVisible(true);
        textFieldPromotionName.setText(labelNamePromotionVIP.getText());
        textAreaPromotonContent.setText(labelInfoPromotionVIP.getText());
        menuButtonTradeArea.setText(labelTradeArea.getText());
        labelEditNumber = 2;
    }

    /**
     * 编辑会员等级活动监听
     */
    public void onClickedEditMember() {
        this.showEditPane();
        paneEditMember.setVisible(true);
        datePickerPromotionEndTime.setVisible(false);
        datePickerPromotionBeginTime.setVisible(false);
        textFieldPromotionName.setText(labelNamePromotionMember.getText());
        textFieldLevel1.setText(labelLevel1.getText());
        textFieldLevel2.setText(labelLevel2.getText());
        textFieldLevel3.setText(labelLevel3.getText());
        textAreaPromotonContent.setText(labelInfoPromotionMember.getText());
        labelEditNumber = 3;
    }

    /**
     * 新建promotion按钮监听
     */
    public void onClickedNewPromotion() {
        textAreaPromotonContent.setText("");
        textFieldPromotionName.setText("");
        textFieldDiscount.setText("");
        datePickerPromotionBeginTime.setValue(null);
        datePickerPromotionEndTime.setValue(null);
        isClickedButtonNew = true;
        menuButtonTradeArea.setText("选择商圈");
    }

    /**
     * 删除promotion按钮监听
     */
    public void onClickedDeletePromotion() throws IOException{
        sceneJump.jumpToDeletePromotion();
        boolean isDeletePromotion = sceneJump.getIsDeletePromotion();
        if(isDeletePromotion) {
            if(labelEditNumber == 1){
                websalerbl.cancelPromotion(labelNamePromotionDoubleOne.getText());
                lengthPromotionDoubleOne--;
                if(lengthPromotionDoubleOne == 0){
                    labelNamePromotionDoubleOne.setText("");
                    labelInfoPromotionDoubleOne.setText("");
                    labelDatePromotionDoubleOne.setText("");
                }else{
                    int n = Math.abs(doubleOneCount % lengthPromotionDoubleOne);
                    this.initPromotionContent(n,PromotionType.Web_Period);
                }
            }
            else if(labelEditNumber == 2){
                websalerbl.cancelPromotion(labelNamePromotionVIP.getText());
                lengthPromotionVIP--;
                if(lengthPromotionVIP == 0){
                    labelNamePromotionVIP.setText("");
                    labelInfoPromotionVIP.setText("");
                    labelDatePromotionVIP.setText("");
                    labelTradeArea.setText("");
                }else{
                    int n = Math.abs(VIPCount % lengthPromotionVIP);
                    this.initPromotionContent(n,PromotionType.Web_TradeArea);
                }
            }
            else if(labelEditNumber == 3){
                websalerbl.cancelPromotion(labelNamePromotionMember.getText());
                lengthPromotionMember--;
                if(lengthPromotionMember == 0){
                    labelNamePromotionMember.setText("");
                    labelInfoPromotionMember.setText("");
                    labelDatePromotionMember.setText("");
                    labelLevel1.setText("");
                    labelLevel2.setText("");
                    labelLevel3.setText("");
                }else{
                    int n = Math.abs(memberCount % lengthPromotionMember);
                    this.initPromotionContent(n,PromotionType.Web_Vip);
                }
            }
        }
    }

    /**
     * 确认修改promotion按钮监听
     */
    public void onClickedConfirmEditPromotion() {
        String name = textFieldPromotionName.getText();
        double discount = 1;
        if(!textFieldDiscount.getText().equals("")){
            discount = Double.parseDouble(textFieldDiscount.getText());
        }
        Date beginTime = null;
        Date endTime = null;
        String description = textAreaPromotonContent.getText();

        // 新建营销策略
        if(isClickedButtonNew){
            if(labelEditNumber == 1){
                try {
                    beginTime = UiFormatChanger.getDate(datePickerPromotionBeginTime);
                    endTime = UiFormatChanger.getDate(datePickerPromotionEndTime);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                PromotionVO vo = new PromotionVO(name,description,PromotionType.Web_Period,beginTime,endTime,discount);
                try {
                    websalerbl.makePromotion(vo);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                int n = Math.abs(doubleOneCount % lengthPromotionDoubleOne);
                this.initPromotionContent(n,PromotionType.Web_Period);
            }
            else if(labelEditNumber == 2){
                try {
                    beginTime = UiFormatChanger.getDate(datePickerPromotionBeginTime);
                    endTime = UiFormatChanger.getDate(datePickerPromotionEndTime);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                PromotionVO vo = new PromotionVO(name,description,PromotionType.Web_TradeArea,beginTime,endTime,TradeArea.valueOf(tradeArea),discount);
                try {
                    websalerbl.makePromotion(vo);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                int n = Math.abs(VIPCount % lengthPromotionVIP);
                this.initPromotionContent(n,PromotionType.Web_TradeArea);
            }
            else if(labelEditNumber == 3){
                double discountLevel1 = Double.parseDouble(textFieldLevel1.getText());
                double discountLevel2 = Double.parseDouble(textFieldLevel2.getText());
                double discountLevel3 = Double.parseDouble(textFieldLevel3.getText());

                PromotionVO vo1 = new PromotionVO(name, description, PromotionType.Web_Vip,null,null,1, discountLevel1);
                PromotionVO vo2 = new PromotionVO(name, description, PromotionType.Web_Vip,null,null,2, discountLevel2);
                PromotionVO vo3 = new PromotionVO(name, description, PromotionType.Web_Vip,null,null,3, discountLevel3);
                try {
                    websalerbl.makePromotion(vo1);
                    websalerbl.makePromotion(vo2);
                    websalerbl.makePromotion(vo3);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                initPromotionList();
                lengthPromotionMember = promotionMember.size();
                int n = Math.abs(memberCount % lengthPromotionMember);
                this.initPromotionContent(n,PromotionType.Web_Vip);
            }
            this.onClickedCancelEditPromotion();
        }
        // 修改营销策略
        else{
            if(labelEditNumber == 1 && promotionDoubleOne.size() > 0){
                try {
                    beginTime = UiFormatChanger.getDate(datePickerPromotionBeginTime);
                    endTime = UiFormatChanger.getDate(datePickerPromotionEndTime);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                PromotionVO vo = new PromotionVO(name,description,PromotionType.Web_Period,beginTime,endTime,discount);
                try {
                    websalerbl.cancelPromotion(labelNamePromotionDoubleOne.getText());
                    websalerbl.makePromotion(vo);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                int n = Math.abs(doubleOneCount % lengthPromotionDoubleOne);
                this.initPromotionContent(n,PromotionType.Web_Period);
                this.onClickedCancelEditPromotion();
            }
            else if(labelEditNumber == 2 && promotionVIP.size() > 0){
                try {
                    beginTime = UiFormatChanger.getDate(datePickerPromotionBeginTime);
                    endTime = UiFormatChanger.getDate(datePickerPromotionEndTime);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                PromotionVO vo = new PromotionVO(name,description,PromotionType.Web_TradeArea,beginTime,endTime,TradeArea.valueOf(tradeArea),discount);
                try {
                    websalerbl.cancelPromotion(labelNamePromotionVIP.getText());
                    websalerbl.makePromotion(vo);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                int n = Math.abs(VIPCount % lengthPromotionVIP);
                this.initPromotionContent(n,PromotionType.Web_TradeArea);
                this.onClickedCancelEditPromotion();
            }
            else if(labelEditNumber == 3 && promotionMember.size() > 0){
                double discountLevel1 = Double.parseDouble(textFieldLevel1.getText());
                double discountLevel2 = Double.parseDouble(textFieldLevel2.getText());
                double discountLevel3 = Double.parseDouble(textFieldLevel3.getText());

                PromotionVO vo1 = new PromotionVO(name, description, PromotionType.Web_Vip,null,null,1, discountLevel1);
                PromotionVO vo2 = new PromotionVO(name, description, PromotionType.Web_Vip,null,null,2, discountLevel2);
                PromotionVO vo3 = new PromotionVO(name, description, PromotionType.Web_Vip,null,null,3, discountLevel3);
                try {
                    websalerbl.cancelPromotion(labelNamePromotionMember.getText());
                    websalerbl.makePromotion(vo1);
                    websalerbl.makePromotion(vo2);
                    websalerbl.makePromotion(vo3);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                int n = Math.abs(memberCount % lengthPromotionMember);
                this.initPromotionContent(n,PromotionType.Web_Vip);
                this.onClickedCancelEditPromotion();
            }else {
                labelPleasePromotion.setVisible(true);
            }
        }
    }

    /**
     * 取消修改promotion按钮监听
     */
    public void onClickedCancelEditPromotion() {
        isClickedButtonNew = false;
        paneEditMember.setVisible(false);
        menuButtonTradeArea.setVisible(false);
        labelPleaseTishi.setVisible(false);
        labelPleasePromotion.setVisible(false);

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

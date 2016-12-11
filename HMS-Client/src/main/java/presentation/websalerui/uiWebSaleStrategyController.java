package presentation.websalerui;

import enumData.TradeArea;
import businesslogic.websalerbl.WebsalerController;
import businesslogicservice.websalerblservice.WebsalerblService;
import enumData.PromotionType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import vo.PromotionVO;

import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by hyx on 2016/11/25.
 */
public class uiWebSaleStrategyController implements Initializable{

    private SceneJump sceneJump = new SceneJump();

    private WebsalerblService websalerbl;

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        websalerbl = new WebsalerController();
        // 获取list对象
        try {
            promotionDoubleOne = websalerbl.getPromotionList(PromotionType.Web_Period);
            promotionVIP = websalerbl.getPromotionList(PromotionType.Web_TradeArea);
            promotionMember = websalerbl.getPromotionList(PromotionType.Web_Vip);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        lengthPromotionDoubleOne = promotionDoubleOne.size();
        lengthPromotionVIP = promotionVIP.size();
        lengthPromotionMember = promotionMember.size();

        //初始化promotion面板
        this.initPromotionContent(0, PromotionType.Web_Period);
        this.initPromotionContent(0, PromotionType.Web_TradeArea);
        this.initPromotionContent(0, PromotionType.Web_Vip);

        // 初始化编辑界面选择商圈menuButton
        for(TradeArea area:TradeArea.values()){
            MenuItem menuItem = new MenuItem(area.toString());
            menuButtonTradeArea.getItems().add(menuItem);
            menuItem.setOnAction(event -> {
                menuButtonTradeArea.setText(area.toString());
                this.tradeArea = area.toString();
            });
        }
    }

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
     * promotion开始时间label和textField
     */

    @FXML
    private TextField textFieldPromotionBeginTime;

    /**
     * promotion结束时间label和textField
     */

    @FXML
    private TextField textFieldPromotionEndTime;

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
        if(promotionType == PromotionType.Web_Period){
            labelNamePromotionDoubleOne.setText(promotionDoubleOne.get(n).getPromotionName());
            labelInfoPromotionDoubleOne.setText(promotionDoubleOne.get(n).getDescription());
            labelDatePromotionDoubleOne.setText(promotionDoubleOne.get(n).getStartDate() + "~" + promotionDoubleOne.get(n).getEndDate());
        }
        else if(promotionType == PromotionType.Web_TradeArea){
            labelNamePromotionVIP.setText(promotionVIP.get(n).getPromotionName());
            labelInfoPromotionVIP.setText(promotionVIP.get(n).getDescription());
            labelDatePromotionVIP.setText(promotionVIP.get(n).getStartDate() + "~" + promotionVIP.get(n).getEndDate());
            labelTradeArea.setText(String.valueOf(promotionVIP.get(n).getTradeArea()));
        }
        else if(promotionType == PromotionType.Web_Vip){
            labelNamePromotionMember.setText(promotionMember.get(n).getPromotionName());
            labelInfoPromotionMember.setText(promotionMember.get(n).getDescription());
            labelDatePromotionMember.setText(promotionMember.get(n).getStartDate() + "~" + promotionMember.get(n).getEndDate());
            for(int i = 0; i < promotionMember.size(); i++){
                int level = promotionMember.get(i).getVipLevel();
                if(level == 1){
                    labelLevel1.setText(String.valueOf(promotionMember.get(i).getDiscount()));
                }
                else if(level == 2){
                    labelLevel2.setText(String.valueOf(promotionMember.get(i).getDiscount()));
                }
                else if(level == 3){
                    labelLevel3.setText(String.valueOf(promotionMember.get(i).getDiscount()));
                }
            }
        }
    }

    /**
     * 双11活动下一张监听
     */
    public void doubleOneNext(){
        doubleOneCount++;
        int n = Math.abs(doubleOneCount % lengthPromotionDoubleOne);
        this.initPromotionContent(n,PromotionType.Web_Period);
    }

    /**
     * 双11活动上一张监听
     */
    public void doubleOneBefore() {
        doubleOneCount--;
        int n = Math.abs(doubleOneCount % lengthPromotionDoubleOne);
        this.initPromotionContent(n,PromotionType.Web_Period);
    }

    /**
     * 特定商圈活动下一张监听
     */
    public void vipNext() {
        VIPCount++;
        int n = Math.abs(VIPCount % lengthPromotionVIP);
        this.initPromotionContent(n, PromotionType.Web_TradeArea);
    }

    /**
     * 特定商圈活动上一张监听
     */
    public void vipBefore() {
        VIPCount++;
        int n = Math.abs(VIPCount % lengthPromotionVIP);
        this.initPromotionContent(n, PromotionType.Web_TradeArea);
    }

    /**
     * member活动下一张监听
     */
    public void memberNext(){
        memberCount++;
        int n = Math.abs(memberCount % lengthPromotionMember);
        this.initPromotionContent(n, PromotionType.Web_Vip);
    }

    /**
     * member活动上一张监听
     */
    public void memberBefore() {
        memberCount--;
        int n = Math.abs(memberCount % lengthPromotionMember);
        this.initPromotionContent(n, PromotionType.Web_Vip);
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
    }

    /**
     * 编辑特定商圈VIP活动监听
     */
    public void onClickedEditVIP() {
        this.showEditPane();
        menuButtonTradeArea.setVisible(true);
        labelEditNumber = 2;
    }

    /**
     * 编辑会员等级活动监听
     */
    public void onClickedEditMember() {
        this.showEditPane();
        paneEditMember.setVisible(true);
        labelEditNumber = 3;
    }

    /**
     * 新建promotion按钮监听
     */
    public void onClickedNewPromotion() {
        textFieldPromotionName.setText("");
        textFieldDiscount.setText("");
        textFieldPromotionBeginTime.setText("");
        textFieldPromotionEndTime.setText("");
        isClickedButtonNew = true;
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
            }
            else if(labelEditNumber == 2){
                websalerbl.cancelPromotion(labelNamePromotionVIP.getText());
            }
            else if(labelEditNumber == 3){
                websalerbl.cancelPromotion(labelNamePromotionMember.getText());
            }
        }
    }

    /**
     * 确认修改promotion按钮监听
     */
    public void onClickedConfirmEditPromotion() {
        String name = textFieldPromotionName.getText();
        double discount = Double.parseDouble(textFieldDiscount.getText());
        String beginTime = textFieldPromotionBeginTime.getText();
        String endTime = textFieldPromotionEndTime.getText();
        String description = textAreaPromotonContent.getText();

        double discountLevel1 = Double.parseDouble(textFieldLevel1.getText());
        double discountLevel2 = Double.parseDouble(textFieldLevel2.getText());
        double discountLevel3 = Double.parseDouble(textFieldLevel3.getText());

        // 新建营销策略
        if(isClickedButtonNew){
            if(labelEditNumber == 1){
                PromotionVO vo = new PromotionVO(name,description,PromotionType.Web_Period,beginTime,endTime,discount);
                try {
                    websalerbl.makePromotion(vo);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
            else if(labelEditNumber == 2){
                PromotionVO vo = new PromotionVO(name,description,PromotionType.Web_TradeArea,beginTime,endTime,TradeArea.valueOf(tradeArea),discount);
                try {
                    websalerbl.makePromotion(vo);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
            else if(labelEditNumber == 3){
                PromotionVO vo1 = new PromotionVO(name, description, PromotionType.Web_Vip,beginTime,endTime,1, discountLevel1);
                PromotionVO vo2 = new PromotionVO(name, description, PromotionType.Web_Vip,beginTime,endTime,2, discountLevel1);
                PromotionVO vo3 = new PromotionVO(name, description, PromotionType.Web_Vip,beginTime,endTime,3, discountLevel1);
                try {
                    websalerbl.makePromotion(vo1);
                    websalerbl.makePromotion(vo2);
                    websalerbl.makePromotion(vo3);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
        // 修改营销策略
        // TODO
        else{
            if(labelEditNumber == 1){

            }
            else if(labelEditNumber == 2){

            }
            else if(labelEditNumber == 3){

            }
        }
        this.onClickedCancelEditPromotion();
    }

    /**
     * 取消修改promotion按钮监听
     */
    public void onClickedCancelEditPromotion() {
        isClickedButtonNew = false;
        paneEditMember.setVisible(false);
        menuButtonTradeArea.setVisible(false);

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

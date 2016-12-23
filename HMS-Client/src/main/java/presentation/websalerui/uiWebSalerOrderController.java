package presentation.websalerui;

import businesslogic.logbl.LogController;
import businesslogic.websalerbl.WebsalerController;
import businesslogicservice.logblservice.LogBlService;
import businesslogicservice.websalerblservice.WebsalerblService;
import enumData.CreditRecoverWay;
import enumData.OrderState;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import utility.UiFormatChanger;
import vo.CanceledExceptionOrderVO;
import vo.OrderVO;

import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by thinkpad on 2016/12/5.
 */
public class uiWebSalerOrderController implements Initializable {

    private SceneJump sceneJump = new SceneJump();
    WebsalerblService websalerbl = new WebsalerController();
    LogBlService logBl = new LogController();

    /**
     * 登出按钮
     */
    @FXML
    private Label labelExit;

    /**
     * 撤销订单和未撤销订单的munuItem
     */
    @FXML
    private MenuButton menuButtonChooseOrderState;

    /**
     * 订单表格pane
     */
    @FXML
    private AnchorPane paneOrderTable;

    /**
     * 详细订单pane
     */
    @FXML
    private AnchorPane paneDetailedOrder;

    /**
     * 恢复全部信用checkBox
     */
    @FXML
    private CheckBox checkBoxAllCredit;

    /**
     * 恢复一半信用checkBox
     */
    @FXML
    private CheckBox checkBoxHalfCredit;

    @FXML
    private TableView<TableOrder> orderList;
    @FXML
    private TableColumn<TableOrder,String> columnOrderID;
    @FXML
    private TableColumn<TableOrder,String> columnUserID;
    @FXML
    private TableColumn<TableOrder,String> columnHotelID;
    @FXML
    private TableColumn<TableOrder,String> columnState;

    private ObservableList<TableOrder> unCancledOrderData = FXCollections.observableArrayList();
    private ObservableList<TableOrder> cancledOrderData = FXCollections.observableArrayList();

    public uiWebSalerOrderController() throws RemoteException {
    }

    /**
     * 跳转到销售策略界面
     */
    public void jumpToSceneSaleStrategy() throws IOException {
        sceneJump.jumpToSceneSaleStrategy();
    }

    /**
     * 跳转到制定等级策略
     */
    public void jumpToSceneMemberLevelUp() throws IOException {
        sceneJump.jumpToSceneMemberUp();
    }

    /**
     * 将orderVO对象转化为TableOrder对象
     * @param vo
     * @return
     */
    private TableOrder transVoTOTableOrder(OrderVO vo){
        String orderid = vo.getOrderID();
        String userid = vo.getUserID();
        String hotelid = vo.getHotelID();
        String state = UiFormatChanger.stateTOstring(vo.getOrderState());
        TableOrder tableOrder = new TableOrder(orderid,userid,hotelid,state);
        return  tableOrder;
    }

    /**
     * 初始化：获取用户列表，并显示
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // 未撤销订单
        ArrayList<OrderVO> unRevokeList = null;
        // 已撤销订单
        ArrayList<OrderVO> revokeList = null;

        try {
            unRevokeList = websalerbl.getOrderByState(OrderState.exception);
            revokeList = websalerbl.getCanceledExceptionOrderInfos();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        // 未撤销订单
        for (int i = 0; i < unRevokeList.size(); i++) {
            TableOrder tempTableOrder = this.transVoTOTableOrder(unRevokeList.get(i));
            unCancledOrderData.add(tempTableOrder);
        }

        // 已撤销订单
        for (int i = 0; i < revokeList.size(); i++) {
            TableOrder tempTableOrder = this.transVoTOTableOrder(revokeList.get(i));
            cancledOrderData.add(tempTableOrder);
        }
        orderList.setItems(unCancledOrderData);
        columnOrderID.setCellValueFactory(cellData -> cellData.getValue().OrderIDProperty());
        columnUserID.setCellValueFactory(cellData -> cellData.getValue().UserIDProperty());
        columnHotelID.setCellValueFactory(cellData -> cellData.getValue().HotelIDProperty());
        columnState.setCellValueFactory(cellData -> cellData.getValue().StateProperty());
    }

    /**
     * 当前订单的ID
     */
    static String currentOrderID;
    public void setOrderID(String id){
        currentOrderID = id;
    }
    public static String getOrderID() {
        return currentOrderID;
    }

    /**
     * 跳转到信用充值界面
     */
    public void jumpToScneCredit() throws IOException {
        sceneJump.jumpToSceneCredit();
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
     * 选择查看撤销订单
     */
    public void checkRevokeOrder() {
        menuButtonChooseOrderState.setText("撤销订单");
        this.refreshTable("已撤销");
    }

    /**
     * 选择查看未撤销订单
     */
    public void checkNotRevokeOrder() {
        menuButtonChooseOrderState.setText("异常订单");
        this.refreshTable("异常");
    }

    /**
     * 刷新表单信息
     */
    private void refreshTable(String state) {
        if (state.equals("异常")){
            orderList.setItems(unCancledOrderData);
        }
        else if(state.equals("已撤销")){
            orderList.setItems(cancledOrderData);
        }
        columnOrderID.setCellValueFactory(cellData -> cellData.getValue().OrderIDProperty());
        columnUserID.setCellValueFactory(cellData -> cellData.getValue().UserIDProperty());
        columnHotelID.setCellValueFactory(cellData -> cellData.getValue().HotelIDProperty());
        columnState.setCellValueFactory(cellData -> cellData.getValue().StateProperty());
    }

    @FXML
    private Label labelOrderId;
    @FXML
    private Label lanelUserId;
    @FXML
    private Label labelOrderState;
    @FXML
    private Label labelHotelName;
    @FXML
    private Label labelRoomType;
    @FXML
    private Label labelRoomNum;
    @FXML
    private Label labelBookedTime;
    @FXML
    private Label labelTotalMoney;
    @FXML
    private TextArea textAreaReason;
    @FXML
    private Label labelRevokeTime;
    @FXML
    private AnchorPane paneChooseCredit;
    @FXML
    private AnchorPane paneRevokeTime;
    @FXML
    private Label labelCreditWarning;

    /**
     * 查看详细订单
     */
    public void checkDetailedOrder(){
        boolean isSelected = false;

        // 循环查找是否选中某一订单
        for (int i = 0; i < unCancledOrderData.size(); i++) {
            if (orderList.getSelectionModel().isSelected(i)) {
                isSelected = true;
                break;
            }
        }
        for (int i = 0; i < cancledOrderData.size(); i++) {
            if (orderList.getSelectionModel().isSelected(i)) {
                isSelected = true;
                break;
            }
        }

        if (isSelected){
            checkBoxAllCredit.setSelected(false);
            checkBoxHalfCredit.setSelected(false);

            String orderId = orderList.getSelectionModel().getSelectedItem().getOrderID();
            String state = orderList.getSelectionModel().getSelectedItem().getState();

            if(state.equals("异常")){
                paneChooseCredit.setVisible(true);
                paneRevokeTime.setVisible(false);
                this.initPaneDetailedOrder(orderId, "异常");
            }
            else if(state.equals("已撤销")){
                paneChooseCredit.setVisible(false);
                paneRevokeTime.setVisible(true);
                this.initPaneDetailedOrder(orderId, "已撤销");
            }
            paneOrderTable.setVisible(false);
            paneDetailedOrder.setVisible(true);
            labelCreditWarning.setVisible(false);
        }
    }

    /**
     * 初始化详细订单界面
     */
    public void initPaneDetailedOrder(String orderId, String state) {
        try {
            OrderVO vo = websalerbl.getOrderByID(orderId);
            labelOrderId.setText(vo.getOrderID());
            lanelUserId.setText(vo.getUserID());
            labelOrderState.setText(UiFormatChanger.stateTOstring(vo.getOrderState()));
            labelHotelName.setText(vo.getHotelname());
            labelRoomType.setText(UiFormatChanger.typeTOstring(vo.getRoomType()));
            labelRoomNum.setText(String.valueOf(vo.getRoomNumber()));
            labelBookedTime.setText(UiFormatChanger.dateToString(vo.getCheckInDate()));
            labelTotalMoney.setText(String.valueOf(vo.getPrice()));

            if (state.equals("已撤销")){
                CanceledExceptionOrderVO vo2 = websalerbl.getCanceledExceptionOrder(orderId);
                textAreaReason.setText(vo2.getCancelReason());
                labelRevokeTime.setText(vo2.getCancelDate() + vo2.getCancelTime());
            }
            else if (state.equals("异常")){
                textAreaReason.setText("");
                labelRevokeTime.setText("");
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /**
     * 详细订单界面返回订单table界面
     */
    public void backToPaneOrderTable(){
        paneOrderTable.setVisible(true);
        paneDetailedOrder.setVisible(false);
    }

    public void chooseAllCredit(){
        checkBoxAllCredit.setSelected(true);
        checkBoxHalfCredit.setSelected(false);
    }
    public void chooseHalfCredit(){
        checkBoxHalfCredit.setSelected(true);
        checkBoxAllCredit.setSelected(false);
    }

    /**
     * 撤销方法
     */
    public void revokeOrder(){
        if(checkBoxHalfCredit.isSelected()){
            CanceledExceptionOrderVO vo = new CanceledExceptionOrderVO(labelOrderId.getText(), textAreaReason.getText());
            try {
                websalerbl.cancelExceptionOrder(vo, CreditRecoverWay.Half);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        else if(checkBoxAllCredit.isSelected()){
            CanceledExceptionOrderVO vo = new CanceledExceptionOrderVO(labelOrderId.getText(), textAreaReason.getText());
            try {
                websalerbl.cancelExceptionOrder(vo, CreditRecoverWay.All);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        else{
            labelCreditWarning.setVisible(true);
        }
    }

}

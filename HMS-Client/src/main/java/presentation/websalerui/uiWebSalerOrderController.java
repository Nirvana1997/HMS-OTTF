package presentation.websalerui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import presentation.websalerui.TableOrder;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by thinkpad on 2016/12/5.
 */
public class uiWebSalerOrderController implements Initializable {

    private SceneJump sceneJump = new SceneJump();

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
     * 订单编号输入textField
     */
    @FXML
    private TextField textFieldOrderId;

    /**
     * 订单不存在warning
     */
    @FXML
    private Label labelWarning;

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

    @FXML
    private TableView<TableOrder> orderList;
    @FXML
    private TableColumn<TableOrder,String> columnOrderID;
    @FXML
    private TableColumn<TableOrder,String> columnUserID;
    @FXML
    private TableColumn<TableOrder,String> columnHotelID;
    @FXML
    private TableColumn<TableOrder,String> columnReason;
    @FXML
    private TableColumn<TableOrder,String> columnState;

    private ObservableList<TableOrder> orderData = FXCollections.observableArrayList();
    private ArrayList<TableOrder> orderArray = new ArrayList<>();

    /**
     * 跳转到销售策略界面
     */
    public void jumpToSceneSaleStrategy() throws IOException {
        sceneJump.jumpToSceneSaleStrategy();
    }

    /**
     * 初始化：获取用户列表，并显示
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        orderArray.add(new TableOrder("UR151250064","萱萱","萱萱大酒店","未撤销","酒店信息与实际有误"));
        orderArray.add(new TableOrder("UR151250045","蝶蝶","萱萱大酒店","已撤销","酒店信息与实际有误"));
        for (int i = 0; i < orderArray.size(); i++) {
            orderData.add(orderArray.get(i));
        }
        orderList.setItems(orderData);
        columnOrderID.setCellValueFactory(cellData -> cellData.getValue().OrderIDProperty());
        columnUserID.setCellValueFactory(cellData -> cellData.getValue().UserIDProperty());
        columnHotelID.setCellValueFactory(cellData -> cellData.getValue().HotelIDProperty());
        columnReason.setCellValueFactory(cellData -> cellData.getValue().ReasonProperty());
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
    }

    /**
     * 选择查看全部订单
     */
    public void checkAllOrder() {
        textFieldOrderId.setText("");
        menuButtonChooseOrderState.setText("全部订单");
        this.refreshTable("全部订单");
    }

    /**
     * 选择查看撤销订单
     */
    public void checkRevokeOrder() {
        textFieldOrderId.setText("");
        menuButtonChooseOrderState.setText("撤销订单");
        this.refreshTable("已撤销");
    }

    /**
     * 选择查看未撤销订单
     */
    public void checkNotRevokeOrder() {
        textFieldOrderId.setText("");
        menuButtonChooseOrderState.setText("未撤销订单");
        this.refreshTable("未撤销");
    }

    /**
     * 根据订单编号查询
     */
    public void searchByOrderId(){
        String id = textFieldOrderId.getText();
        orderData = FXCollections.observableArrayList();
        boolean isFound = false;
        for (int i = 0; i < orderArray.size(); i++) {
            if (orderArray.get(i).getOrderID().equals(id)) {
                orderData.add(orderArray.get(i));
                isFound = true;
                labelWarning.setVisible(false);
            }
        }
        if(isFound){
            orderList.setItems(orderData);
            columnOrderID.setCellValueFactory(cellData -> cellData.getValue().OrderIDProperty());
            columnUserID.setCellValueFactory(cellData -> cellData.getValue().UserIDProperty());
            columnHotelID.setCellValueFactory(cellData -> cellData.getValue().HotelIDProperty());
            columnReason.setCellValueFactory(cellData -> cellData.getValue().ReasonProperty());
            columnState.setCellValueFactory(cellData -> cellData.getValue().StateProperty());
        }else {
            labelWarning.setVisible(true);
        }
    }

    /**
     * 刷新表单信息
     */
    private void refreshTable(String state) {
        if(state.equals("全部订单")){
            orderList.setItems(orderData);
        }
        else{
            orderData = FXCollections.observableArrayList();
            for (int i = 0; i < orderArray.size(); i++) {
                if (orderArray.get(i).getState().equals(state))
                    orderData.add(orderArray.get(i));
            }
            orderList.setItems(orderData);
        }
        columnOrderID.setCellValueFactory(cellData -> cellData.getValue().OrderIDProperty());
        columnUserID.setCellValueFactory(cellData -> cellData.getValue().UserIDProperty());
        columnHotelID.setCellValueFactory(cellData -> cellData.getValue().HotelIDProperty());
        columnReason.setCellValueFactory(cellData -> cellData.getValue().ReasonProperty());
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

    /**
     * 查看详细订单
     */
    public void checkDetailedOrder(){
        for(int i = 0; i < orderData.size();i++){
            if(orderList.getSelectionModel().isSelected(i)){
                break;
            }
        }
        String orderId = orderList.getSelectionModel().getSelectedItem().getOrderID();
        String state = orderList.getSelectionModel().getSelectedItem().getState();

        if(state.equals("未撤销")){
            paneChooseCredit.setVisible(true);
            paneRevokeTime.setVisible(false);
        }
        else if(state.equals("已撤销")){
            paneChooseCredit.setVisible(false);
            paneRevokeTime.setVisible(true);
        }
        paneOrderTable.setVisible(false);
        paneDetailedOrder.setVisible(true);
        this.initPaneDetailedOrder(orderId);
    }

    /**
     * 初始化详细订单界面
     */
    public void initPaneDetailedOrder(String orderId) {
        for (int i = 0; i < orderArray.size(); i++) {
            if(orderArray.get(i).getOrderID().equals(orderId)){
                //
            }
        }
    }

    /**
     * 详细订单界面返回订单table界面
     */
    public void backToPaneOrderTable(){
        paneOrderTable.setVisible(true);
        paneDetailedOrder.setVisible(false);
    }
}

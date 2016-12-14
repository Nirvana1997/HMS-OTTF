package presentation.websalerui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import presentation.websalerui.TableOrder;

import java.io.IOException;
import java.net.URL;
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
        orderData.add(new TableOrder("UR151250064","萱萱","萱萱大酒店","未撤销","酒店信息与实际有误"));
        orderData.add(new TableOrder("UR151250045","蝶蝶","萱萱大酒店","已撤销","酒店信息与实际有误"));
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
     * 选择查看撤销订单
     */
    public void checkRevokeOrder() {
        menuButtonChooseOrderState.setText("撤销订单");
        //TODO
    }

    /**
     * 选择查看未撤销订单
     */
    public void checkNotRevokeOrder() {
        menuButtonChooseOrderState.setText("未撤销订单");
        //TODO
    }

    /**
     * 刷新表单信息
     */
    private void refreshTable() {
        //TODO
    }
}

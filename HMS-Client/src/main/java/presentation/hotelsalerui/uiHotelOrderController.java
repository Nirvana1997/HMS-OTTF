package presentation.hotelsalerui;

import businesslogic.hotelsalerbl.HotelSalerController;
import businesslogic.logbl.LogController;
import businesslogicservice.hotelsalerblservice.HotelsalerblService;
import businesslogicservice.logblservice.LogBlService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import presentation.hotelsalerui.TableOrder;
import utility.UiFormatChanger;
import vo.OrderVO;

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
public class uiHotelOrderController implements Initializable{

    private SceneJump sceneJump = new SceneJump();
    HotelsalerblService hotelsalerbl = new HotelSalerController();
    LogBlService logBl = new LogController();

    /**
     * 登出按钮
     */
    @FXML
    private Label labelExit;

    /**
     * 选择订单状态menuButton
     */
    @FXML
    private MenuButton menuButtonChooseOrder;

    @FXML
    private TableView<TableOrder> orderList;
    @FXML
    private TableColumn<TableOrder,String> columnOrderID;
    @FXML
    private TableColumn<TableOrder,String> columnUserID;
    @FXML
    private TableColumn<TableOrder,String> columnRoomType;
    @FXML
    private TableColumn<TableOrder,String> columnState;
    @FXML
    private TableColumn<TableOrder,String> columnIntendTime;
    @FXML
    private TableColumn<TableOrder,String> columnPrice;

    private ObservableList<TableOrder> orderData = FXCollections.observableArrayList();
    private ArrayList<TableOrder> orderArray = new ArrayList<>();

    public uiHotelOrderController() throws RemoteException {
    }

    /**
     * 将orderVO对象转化为TableOrder对象
     * @param vo
     * @return
     */
    private TableOrder transVoTOTableOrder(OrderVO vo){
        String orderid = vo.getOrderID();
        String userid = vo.getUserID();
        String roomtype = UiFormatChanger.typeTOstring(vo.getRoomType());
        String state = UiFormatChanger.stateTOstring(vo.getOrderState());
        String intendTime = UiFormatChanger.dateToString(vo.getCheckInDate());
        String price = String.valueOf(vo.getPrice());
        TableOrder tableOrder = new TableOrder(orderid,userid,roomtype,state,intendTime,price);
        return  tableOrder;
    }

    /**
     * 初始化：获取用户列表，并显示
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            ArrayList<OrderVO> tempList = hotelsalerbl.readOrder();
            for (int i = 0; i < tempList.size(); i++) {
                TableOrder tempTabelOrder = this.transVoTOTableOrder(tempList.get(i));
                orderArray.add(tempTabelOrder);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < orderArray.size(); i++) {
            orderData.add(orderArray.get(i));
        }
        orderList.setItems(orderData);
        columnOrderID.setCellValueFactory(cellData -> cellData.getValue().OrderIDProperty());
        columnUserID.setCellValueFactory(cellData -> cellData.getValue().UserIDProperty());
        columnRoomType.setCellValueFactory(cellData -> cellData.getValue().RoomTypeProperty());
        columnState.setCellValueFactory(cellData -> cellData.getValue().StateProperty());
        columnIntendTime.setCellValueFactory(cellData -> cellData.getValue().IntendTimeProperty());
        columnPrice.setCellValueFactory(cellData -> cellData.getValue().PriceProperty());
    }

    /**
     * 酒店信息按钮点击监听
     */
    public void jumpToSceneHotelInfo() throws IOException {
        sceneJump.jumpToSceneHotelInfo();
    }

    /**
     * 酒店房间按钮点击监听
     */
    public void jumpToSceneHotelRoom() throws IOException {
        sceneJump.jumpToSceneHotelRoom();
    }

    /**
     * 酒店促销按钮点击监听
     */
    public void jumpToSceneHotelSaleStrategy() throws IOException {
        sceneJump.jumpToSceneHotelSaleStrategy();
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
     * 选择查看全部订单
     */
    public void checkAllOrder() {
        menuButtonChooseOrder.setText("全部订单");
        this.refreshTable("全部");
    }

    /**
     * 选择查看未执行订单
     */
    public void checkExcutedOrder() {
        menuButtonChooseOrder.setText("未执行订单");
        this.refreshTable("未执行");
    }

    /**
     * 选择查看已执行订单
     */
    public void checkUnExcutedOrder() {
        menuButtonChooseOrder.setText("已执行订单");
        this.refreshTable("已执行");
    }

    /**
     * 选择查看异常订单
     */
    public void checkExceptionOrder() {
        menuButtonChooseOrder.setText("异常订单");
        this.refreshTable("异常");
    }

    /**
     * 选择查看已撤销订单
     */
    public void checkCancledOrder() {
        menuButtonChooseOrder.setText("已撤销订单");
        this.refreshTable("已撤销");
    }

    private void refreshTable(String state) {
        orderData = FXCollections.observableArrayList();
        if (state.equals("全部")){
            for (int i = 0; i < orderArray.size(); i++) {
                orderData.add(orderArray.get(i));
            }
        }
        else{
            for (int i = 0; i < orderArray.size(); i++) {
                if (orderArray.get(i).getState().equals(state))
                    orderData.add(orderArray.get(i));
            }
        }
        orderList.setItems(orderData);
        columnOrderID.setCellValueFactory(cellData -> cellData.getValue().OrderIDProperty());
        columnUserID.setCellValueFactory(cellData -> cellData.getValue().UserIDProperty());
        columnRoomType.setCellValueFactory(cellData -> cellData.getValue().RoomTypeProperty());
        columnState.setCellValueFactory(cellData -> cellData.getValue().StateProperty());
        columnIntendTime.setCellValueFactory(cellData -> cellData.getValue().IntendTimeProperty());
        columnPrice.setCellValueFactory(cellData -> cellData.getValue().PriceProperty());
    }

    @FXML
    private Label labelOrderId;
    @FXML
    private Label labelUserId;
    @FXML
    private Label labelRoomType;
    @FXML
    private Label labelOrderState;
    @FXML
    private Label labelInTime;
    @FXML
    private Label labelOutTime;
    @FXML
    private Label labelIsChildren;
    @FXML
    private Label labelPrice;
    @FXML
    private Label labelRoomId;
    @FXML
    private Label labelRoomNum;
    @FXML
    private Label labelPeopleNum;
    @FXML
    private DatePicker datePickerIntime;
    @FXML
    private DatePicker datePickerOutTime;
    @FXML
    private AnchorPane paneTable;
    @FXML
    private AnchorPane paneDetailedOrder;
    @FXML
    private AnchorPane paneDelayTime;
    @FXML
    private AnchorPane paneExcuteOrder;
    @FXML
    private TextField textFieldRoomID;
    @FXML
    private DatePicker datePickerCheckInTime;
    @FXML
    private Button buttonExecuteOrder;
    @FXML
    private Button buttonDelayCheckIn;

    String orderId = "";

    /**
     * 查看详细订单
     */
    public void checkDetailedOrder() {
        for (int i = 0; i < orderData.size(); i++) {
            if (orderList.getSelectionModel().isSelected(i)) {
                orderId = orderList.getSelectionModel().getSelectedItem().getOrderID();
                try {
                    OrderVO vo = hotelsalerbl.readOrderByID(orderId);
                    labelOrderId.setText(vo.getOrderID());
                    labelUserId.setText(vo.getUserID());
                    labelRoomType.setText(UiFormatChanger.typeTOstring(vo.getRoomType()));
                    labelOrderState.setText(UiFormatChanger.stateTOstring(vo.getOrderState()));
                    labelInTime.setText(UiFormatChanger.dateToString(vo.getCheckInDate()));
                    labelOutTime.setText(UiFormatChanger.dateToString(vo.getCheckOutDate()));
                    if(vo.isHaveChild())
                        labelIsChildren.setText("是");
                    else
                        labelIsChildren.setText("否");
                    labelPrice.setText(String.valueOf(vo.getPrice()));
                    labelRoomId.setText(vo.getRoomID());
                    labelRoomNum.setText(String.valueOf(vo.getRoomNumber()));
                    labelPeopleNum.setText(String.valueOf(vo.getPeopleNumber()));
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                paneTable.setVisible(false);
                paneDetailedOrder.setVisible(true);
                paneExcuteOrder.setVisible(false);
                paneDelayTime.setVisible(false);

                break;
            }
        }
    }

    /**
     * 返回列表界面
     */
    public void backToPaneTable(){
        paneTable.setVisible(true);
        paneDetailedOrder.setVisible(false);
        paneDelayTime.setVisible(false);
        buttonExecuteOrder.setVisible(true);
        buttonDelayCheckIn.setVisible(true);
    }

    /**
     * 显示录入延迟时间pane
     */
    public void showDelayPane(){
        paneDelayTime.setVisible(true);
        buttonExecuteOrder.setVisible(false);
        buttonDelayCheckIn.setVisible(false);
    }

    /**
     * 确认录入延迟时间
     */
    public void confirmDelay(){
        try {
            Date begin = UiFormatChanger.getDate(datePickerIntime);
            Date end = UiFormatChanger.getDate(datePickerOutTime);
            try {
                OrderVO vo = hotelsalerbl.readOrderByID(orderId);
                double price = vo.getPrice();
                String orderId = vo.getOrderID();
                OrderVO vo2 = new OrderVO(orderId, labelUserId.getText(), price, begin, end);
                hotelsalerbl.delayOrder(vo2);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.cancelDelay();
    }

    /**
     * 取消录入延迟时间
     */
    public void cancelDelay(){
        paneDelayTime.setVisible(false);
        buttonExecuteOrder.setVisible(true);
        buttonDelayCheckIn.setVisible(true);
    }

    /**
     * 显示执行订单界面
     */
    public void excuteOrder(){
        paneExcuteOrder.setVisible(true);
        buttonExecuteOrder.setVisible(false);
        buttonDelayCheckIn.setVisible(false);
    }

    /**
     * 取消执行订单
     */
    public void cancelExcuteOrder(){
        paneExcuteOrder.setVisible(false);
        buttonExecuteOrder.setVisible(true);
        buttonDelayCheckIn.setVisible(true);
    }

    /**
     * 确认执行订单
     */
    public void confirmExcuteOrder(){
        try {
            OrderVO vo = hotelsalerbl.readOrderByID(labelOrderId.getText());
            String roomId = textFieldRoomID.getText();
            Date date = UiFormatChanger.getDate(datePickerCheckInTime);
            vo.setCheckInDate(date);
            vo.setRoomID(roomId);
            hotelsalerbl.executeOrder(vo);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.cancelExcuteOrder();
    }

}

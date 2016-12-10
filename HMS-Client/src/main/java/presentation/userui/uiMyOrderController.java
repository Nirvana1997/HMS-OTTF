package presentation.userui;

import com.sun.org.apache.xpath.internal.operations.Or;
import enumData.OrderState;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import presentation.webmanagerui.tableMember;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by Administrator on 2016/12/3.
 */
public class uiMyOrderController implements Initializable{


    @FXML
    /**
     * 跳转到首页的按钮
     */
    private Button buttonHomePage;
    @FXML
    /**
     * 跳转到我的订单的按钮
     */
    private Button buttonMyOrder;
    @FXML
    /**
     * 跳转到浏览酒店的按钮
     */
    private Button buttonReadHotel;
    @FXML
    /**
     * 跳转到搜索酒店的按钮
     */
    private Button buttonSearchHotel;
    @FXML
    /**
     * 跳转到个人信息的按钮
     */
    private Button buttonUserInfo;
    @FXML
    /**
     * 登出按钮
     */
    private Label buttonLogOut;

    /**
     * 搜索按钮
     */
    @FXML
    private Button buttonSearch;

    /**
     * 跳转界面的类
     */
    sceneJump jump = new sceneJump();

    /**
     * 跳转到首页
     * @throws IOException
     */
    public void gotoHomePage() throws IOException {
        jump.gotoHomePage();
    }

    /**
     * 跳转到我的订单
     * @throws IOException
     */
    public void gotoMyOrder() throws IOException{
        jump.gotoMyOrder();
    }

    /**
     * 跳转到浏览酒店
     * @throws IOException
     */
    public void gotoReadHotel() throws IOException{
        jump.gotoReadHotel();
    }

    /**
     * 跳转到搜索酒店
     * @throws IOException
     */
    public void gotoSearchHotel() throws IOException{
        jump.gotoSearchHotel();
    }

    /**
     * 跳转到个人信息
     * @throws IOException
     */
    public void gotoUserInfo() throws IOException{
        jump.gotoUserInfo();
    }

    /**
     * 清空账号信息，并跳转回登录界面
     * @throws IOException
     */
    public void LogOut() throws IOException{
        //TODO 清空账号
        jump.gotoLogin();
    }

    /**
     * 当前选择的订单状态
     */
    static OrderState orderState;
    public void setOrderState(OrderState state){
        orderState = state;
    }
    public static OrderState getOrderState(){
        return orderState;
    }


    @FXML
    private Button buttonNormal;
    @FXML
    private Button buttonAbnormal;
    @FXML
    private Button buttonRevoke;


    /**
     * 选择正常订单，则显示已执行和未执行的订单
     * @throws IOException
     */
    public void chooseNormal() throws IOException{
        buttonNormal.setVisible(false);
        buttonAbnormal.setVisible(true);
        buttonRevoke.setVisible(true);
        setOrderState(OrderState.executed);
    }

    /**
     * 选择异常订单，则显示已执行和未执行的订单
     * @throws IOException
     */
    public void chooseAbnormal() throws IOException{
        buttonNormal.setVisible(true);
        buttonAbnormal.setVisible(false);
        buttonRevoke.setVisible(true);
        setOrderState(OrderState.abnormal);
    }
    /**
     * 选择异常订单，则显示已执行和未执行的订单
     * @throws IOException
     */

    public void chooseRevoke() throws IOException{
        buttonNormal.setVisible(true);
        buttonAbnormal.setVisible(true);
        buttonRevoke.setVisible(false);
        setOrderState(OrderState.canceled);
    }

    @FXML
    private Button buttongotoOrder;

    /**
     * 根据选择的订单跳转到订单界面
     * @throws IOException
     */
    public void gotoOrder() throws IOException{
        //检验是否选中一张订单
        for(int i = 0; i < orderData.size();i++){
            setChooseOrder(false);
            if(orderList.getSelectionModel().isSelected(i)){
                setChooseOrder(true);
                break;
            }
        }
        //如果有，则跳转
        if(chooseOrder) {
            setOrderID(orderList.getSelectionModel().getSelectedItem().getOrderID());
            jump.gotoOrder();
        }
        //如果没有，跳出提示框
        else{
            setChooseOrder(false);
            jump.warning();
        }
    }
    @FXML
    private ImageView searchOrder;
    @FXML
    private TextField textSearch;
    public void SearchOrder() throws IOException {
        if(textSearch.getText()!=null) {
            setOrderID(textSearch.getText());
            jump.gotoOrder();
        }
    }
    @FXML
    private TableView<tableOrder> orderList;
    @FXML
    private TableColumn<tableOrder,String> columnID;
    @FXML
    private TableColumn<tableOrder,String> columnHotel;
    @FXML
    private TableColumn<tableOrder,String> columnTime;
    @FXML
    private TableColumn<tableOrder,String> columnState;

    private ObservableList<tableOrder> orderData = FXCollections.observableArrayList();

    /**
     * 初始化：获取用户列表，并显示
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        URmanagementBlService uRmanagementBlService = new WebmanagerController();
//        ArrayList<UserInfoVO> list = uRmanagementBlService.getUserList();
//        for(int i = 0; i < list.size();i++){
//            personData.add(new tableMember(list.get(i).getUserID(), list.get(i).getName(), list.get(i).getContactNumber()));
//        }
        orderData.add(new tableOrder("UR151250045","喋喋","15105180105","saa"));
        orderData.add(new tableOrder("UR151250042","喋","15105180102","aaa"));
        orderList.setItems(orderData);
        columnID.setCellValueFactory(cellData -> cellData.getValue().OrderIDProperty());
        columnHotel.setCellValueFactory(cellData -> cellData.getValue().HotelIDProperty());
        columnTime.setCellValueFactory(cellData -> cellData.getValue().OrderTimeProperty());
        columnState.setCellValueFactory(cellData -> cellData.getValue().StateProperty());
//        userList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
//        userList.getSelectionModel().getSelectedItem().getuserID();
    }

    /**
     * 当前订单的ID
     */
    static String currentOrderID;
    public void setOrderID(String id){ currentOrderID = id;}
    public static String getOrderID(){ return currentOrderID;}

    /**
     * 是否选择订单
     */
    static Boolean chooseOrder = true;
    public void setChooseOrder(boolean is){ chooseOrder = is;}
    public static Boolean getChooseOrder(){ return chooseOrder;}

}

package presentation.userui;

import businesslogic.userbl.UserController;
import businesslogicservice.hotelsalerblservice.HotelinfoblService;
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
import vo.HotelinfoVO;
import vo.OrderVO;

import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import java.sql.Array;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

/**
 * Created by Administrator on 2016/12/3.
 */
public class uiMyOrderController implements Initializable{
    UserController userController = new UserController();
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

    public uiMyOrderController() throws RemoteException {
    }


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
        ArrayList<OrderVO> inglist = userController.readOrder(OrderState.executing);
        ArrayList<OrderVO> edlist = userController.readOrder(OrderState.executed);
        ArrayList<OrderVO> orderlist = new ArrayList<OrderVO>();
        for(int i = 0;i < inglist.size(); i++){
            orderlist.add(inglist.get(i));
        }
        for(int j = 0;j < edlist.size(); j++){
            orderlist.add(edlist.get(j));
        }
        initTable(orderlist);

    }

    /**
     * 选择异常订单，则显示已执行和未执行的订单
     * @throws IOException
     */
    public void chooseAbnormal() throws IOException{
        buttonNormal.setVisible(true);
        buttonAbnormal.setVisible(false);
        buttonRevoke.setVisible(true);
        ArrayList<OrderVO> orderlist = userController.readOrder(OrderState.abnormal);
        initTable(orderlist);
    }
    /**
     * 选择异常订单，则显示已执行和未执行的订单
     * @throws IOException
     */

    public void chooseRevoke() throws IOException{
        buttonNormal.setVisible(true);
        buttonAbnormal.setVisible(true);
        buttonRevoke.setVisible(false);
        ArrayList<OrderVO> orderlist = userController.readOrder(OrderState.canceled);
        initTable(orderlist);
    }

    @FXML
    private Button buttongotoOrder;

    /**
     * 根据选择的订单跳转到订单界面
     * @throws IOException
     */
    public void gotoOrder() throws IOException{
        //检验是否选中一张订单
        for(int i = 0; i < Data.size();i++){
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
           //TODO 如果输入的ID不存在怎么办
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

    private ObservableList<tableOrder> Data = FXCollections.observableArrayList();

    public void initTable(ArrayList<OrderVO> list) throws RemoteException {
        ObservableList<tableOrder> orderData = FXCollections.observableArrayList();
        for(int i = 0; i < list.size(); i++){
            HotelinfoVO hotel = userController.readHotel(list.get(i).getHotelID());
            String date = "";
            date = dateToString(list.get(i).getCheckInDate())+" 至 "+dateToString(list.get(i).getCheckOutDate());
            orderData.add(new tableOrder(list.get(i).getOrderID(),hotel.getHotelname() ,date,
                    stateTOstring(list.get(i).getOrderState())));
        }
        orderList.setItems(orderData);
        columnID.setCellValueFactory(cellData -> cellData.getValue().OrderIDProperty());
        columnHotel.setCellValueFactory(cellData -> cellData.getValue().HotelIDProperty());
        columnTime.setCellValueFactory(cellData -> cellData.getValue().OrderTimeProperty());
        columnState.setCellValueFactory(cellData -> cellData.getValue().StateProperty());
        Data = orderData;
    }

    /**
     * 日期转字符串
     * @param date 日期
     * @return yyyy_MM.dd格式的日期
     */
    public String dateToString(Date date){
        DateFormat df = new SimpleDateFormat("yyyy_MM_dd");
        return df.format(date);
    }
    /**
     * 根据订单状态返回字符串
     * @param state 订单状态
     * @return 中文字符串格式的订单状态
     */
    public String stateTOstring(OrderState state){
        if(state == OrderState.abnormal){ return "异常"; }
        if(state == OrderState.executed){ return "已执行";}
        if(state == OrderState.executing){ return "未执行";}
        if(state == OrderState.canceled){ return "已撤销";}
        if(state == OrderState.noOrder){ return "不存在";}
        else return null;
    }
    /**
     * 初始化：获取用户列表，并显示
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {

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

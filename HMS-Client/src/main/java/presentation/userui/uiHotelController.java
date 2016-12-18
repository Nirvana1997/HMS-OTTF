package presentation.userui;

import businesslogic.logbl.LogController;
import businesslogic.userbl.UserController;
import businesslogicservice.userblservice.HotelOrderBlService;
import enumData.Address;
import enumData.OrderState;
import enumData.RoomType;
import enumData.TradeArea;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import utility.UiFormatChanger;
import vo.*;

import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

/**
 * Created by Administrator on 2016/12/8.
 */
public class uiHotelController implements Initializable{
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

    public uiHotelController() throws RemoteException {
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
        LogController logController = new LogController();
        logController.logOut();
        jump.gotoLogin();
    }

    @FXML
    private Button buttonInfo;
    @FXML
    private Button buttonRoom;
    @FXML
    private Button buttonComment;
    @FXML
    private Button buttonHistoryOrder;
    @FXML
    private AnchorPane HotelInfoPane;
    @FXML
    private AnchorPane HotelRoomPane;
    @FXML
    private AnchorPane UserCommentPane;
    @FXML
    private AnchorPane HistoryOrderPane;
    public void showInfo() throws IOException{
        buttonInfo.setVisible(false);
        buttonRoom.setVisible(true);
        buttonComment.setVisible(true);
        buttonHistoryOrder.setVisible(true);
        HotelInfoPane.setVisible(true);
        HotelRoomPane.setVisible(false);
        UserCommentPane.setVisible(false);
        HistoryOrderPane.setVisible(false);
    }
    public void showRoom() throws IOException{
        buttonInfo.setVisible(true);
        buttonRoom.setVisible(false);
        buttonComment.setVisible(true);
        buttonHistoryOrder.setVisible(true);
        HotelInfoPane.setVisible(false);
        HotelRoomPane.setVisible(true);
        UserCommentPane.setVisible(false);
        HistoryOrderPane.setVisible(false);
    }
    public void showComment() throws IOException{
        buttonInfo.setVisible(true);
        buttonRoom.setVisible(true);
        buttonComment.setVisible(false);
        buttonHistoryOrder.setVisible(true);
        HotelInfoPane.setVisible(false);
        HotelRoomPane.setVisible(false);
        UserCommentPane.setVisible(true);
        HistoryOrderPane.setVisible(false);
    }
    public void showHistoryOrder() throws IOException{
        buttonInfo.setVisible(true);
        buttonRoom.setVisible(true);
        buttonComment.setVisible(true);
        buttonHistoryOrder.setVisible(false);
        HotelInfoPane.setVisible(false);
        HotelRoomPane.setVisible(false);
        UserCommentPane.setVisible(false);
        HistoryOrderPane.setVisible(true);
    }
    @FXML
    private Button buttonReserve;

    /**
     *跳转到预订酒店界面
     * @throws IOException
     */
    public void gotoReserveHotel() throws IOException{
        jump.gotoReserveHotel();
    }


    @FXML
    private TableView<tableDetailOrder> orderList;
    @FXML
    private TableColumn<tableDetailOrder,String> columnID;
    @FXML
    private TableColumn<tableDetailOrder,String> columnTime;
    @FXML
    private TableColumn<tableDetailOrder,String> columnState;
    @FXML
    private TableColumn<tableDetailOrder,String> columnRoomType;
    @FXML
    private TableColumn<tableDetailOrder,Number> columnPeopleNumber;
    @FXML
    private TableColumn<tableDetailOrder,Number> columnPrice;
    @FXML
    private TableColumn<tableDetailOrder,String> columnHaveChild;


    private ObservableList<tableDetailOrder> Data = FXCollections.observableArrayList();

    /**
     * 初始化订单信息
     * @param list 订单列表
     * @throws RemoteException
     */
    public void initTable(ArrayList<OrderVO> list) throws RemoteException {
        ObservableList<tableDetailOrder> orderData = FXCollections.observableArrayList();
        for(int i = 0; i < list.size(); i++){
            HotelinfoVO hotel = userController.readHotel(list.get(i).getHotelID());
            String date = "";
            date = UiFormatChanger.dateToString(list.get(i).getCheckInDate())+" 至 "+ UiFormatChanger.dateToString(list.get(i).getCheckOutDate());
            String havecd ;
            if(list.get(i).isHaveChild()){havecd = "是";}
            else havecd = "否";
            orderData.add(new tableDetailOrder(list.get(i).getOrderID(),date, UiFormatChanger.stateTOstring(list.get(i).getOrderState())
            ,list.get(i).getPeopleNumber(),list.get(i).getPrice(),havecd,UiFormatChanger.typeTOstring(list.get(i).getRoomType())));
        }
        orderList.setItems(orderData);
        columnID.setCellValueFactory(cellData -> cellData.getValue().OrderIDProperty());
        columnTime.setCellValueFactory(cellData -> cellData.getValue().OrderTimeProperty());
        columnState.setCellValueFactory(cellData -> cellData.getValue().StateProperty());
        columnPeopleNumber.setCellValueFactory(cellData -> cellData.getValue().peopleNumberProperty());
        columnHaveChild.setCellValueFactory(cellData -> cellData.getValue().haveChildProperty());
        columnPrice.setCellValueFactory(cellData -> cellData.getValue().priceProperty());
        columnRoomType.setCellValueFactory(cellData -> cellData.getValue().roomTypeProperty());
        Data = orderData;
    }


    @FXML
    private Label textHotelTitle;
    @FXML
    private Text textHotelName;
    @FXML
    private Text textDetailAddress;
    @FXML
    private Text textContactNumber;
    @FXML
    private Text textGrade;
    @FXML
    private Text textStar;
    @FXML
    private Text textIntroduction;

    /**
     * 初始化酒店基本信息
     * @param currentHotel 当前酒店
     */
    public void initHotelInfo(HotelinfoVO currentHotel){
        textHotelTitle.setText(currentHotel.getHotelname());
        textHotelName.setText(currentHotel.getHotelname());
        textDetailAddress.setText(currentHotel.getDetailAddress());
        textContactNumber.setText(currentHotel.getContactNumber());
        textGrade.setText(String.valueOf(currentHotel.getGrade()));
        textStar.setText(String.valueOf(currentHotel.getStar()));
        textIntroduction.setText(currentHotel.getIntroduction());
    }
    @FXML
    private Text singlePrice;
    @FXML
    private Text singleNum;
    @FXML
    private Text doublePrice;
    @FXML
    private Text doubleNum;
    @FXML
    private Text disabledPrice;
    @FXML
    private Text disabledNum;

    /**
     * 初始化房间信息
     * @param roomlist 房间信息列表
     */
    public void initRoomInfo(ArrayList<HotelroomVO> roomlist){
        for(int i = 0; i < roomlist.size(); i++){
            if(roomlist.get(i).getRoomType()==RoomType.SingleRoom){
                singlePrice.setText(String.valueOf(roomlist.get(i).getPrice()));
                singleNum.setText(String.valueOf(roomlist.get(i).getRoomNumber()));
            }if(roomlist.get(i).getRoomType()==RoomType.DoubleRoom){
                doublePrice.setText(String.valueOf(roomlist.get(i).getPrice()));
                doubleNum.setText(String.valueOf(roomlist.get(i).getRoomNumber()));
            }if(roomlist.get(i).getRoomType()==RoomType.DisabledRoom){
                disabledPrice.setText(String.valueOf(roomlist.get(i).getPrice()));
                disabledNum.setText(String.valueOf(roomlist.get(i).getRoomNumber()));
            }
        }
    }
    @FXML
    private AnchorPane comment1;
    @FXML
    private AnchorPane comment2;
    @FXML
    private AnchorPane comment3;
    @FXML
    private Text textComment1;
    @FXML
    private Text textComment2;
    @FXML
    private Text textComment3;

    public void initComment(ArrayList<CommentVO> list){

        if(list.size()==1){
            comment1.setVisible(true);
            textComment1.setText(list.get(0).getComment());
        }
        if(list.size()==2){
            comment1.setVisible(true);
            textComment1.setText(list.get(0).getComment());
            comment2.setVisible(true);
            textComment2.setText(list.get(1).getComment());
        }
        if(list.size()>=3){
            comment1.setVisible(true);
            textComment1.setText(list.get(0).getComment());
            comment2.setVisible(true);
            textComment2.setText(list.get(1).getComment());
            comment3.setVisible(true);
            textComment3.setText(list.get(3).getComment());
        }
    }

    @Override
    public void initialize (URL location, ResourceBundle resources) {

        try {
            HotelinfoVO currentHotel  = userController.readHotel(jump.getHotelID());
            ArrayList<OrderVO> orderlist = userController.getHotelOrderByUserID(jump.getHotelID());
            ArrayList<HotelroomVO> roomlist = userController.getRooms(jump.getHotelID());
            ArrayList<CommentVO> commentlist = userController.getComments(jump.getHotelID());
            initHotelInfo(currentHotel);
            initRoomInfo(roomlist);
            initTable(orderlist);
            initComment(commentlist);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        buttonInfo.setVisible(false);
    }
}

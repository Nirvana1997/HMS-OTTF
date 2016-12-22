package presentation.userui;

import businesslogic.logbl.LogController;
import businesslogic.userbl.UserController;
import enumData.RoomType;
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
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by Administrator on 2016/12/8.
 */
public class uiHotelController implements Initializable {
    /**
     * 用户界面控制器
     */
    UserController userController = new UserController();

    /**
     * 用户真实姓名
     */
    @FXML
    private Text UserName;

    /**
     * 酒店基本信息按钮
     */
    @FXML
    private Button buttonInfo;

    /**
     * 酒店房间类型按钮
     */
    @FXML
    private Button buttonRoom;

    /**
     * 酒店的用户评价按钮
     */
    @FXML
    private Button buttonComment;

    /**
     * 用户在酒店的历史订单按钮
     */
    @FXML
    private Button buttonHistoryOrder;

    /**
     * 酒店基本信息板块
     */
    @FXML
    private AnchorPane HotelInfoPane;

    /**
     * 酒店房间类型板块
     */
    @FXML
    private AnchorPane HotelRoomPane;

    /**
     * 酒店的用户评价板块
     */
    @FXML
    private AnchorPane UserCommentPane;

    /**
     * 用户在该酒店的历史订单板块
     */
    @FXML
    private AnchorPane HistoryOrderPane;

    /**
     * 历史订单列表
     */
    @FXML
    private TableView<tableDetailOrder> orderList;

    /**
     * 订单编号列
     */
    @FXML
    private TableColumn<tableDetailOrder, String> columnID;

    /**
     * 入住时间列
     */
    @FXML
    private TableColumn<tableDetailOrder, String> columnTime;

    /**
     * 订单状态列
     */
    @FXML
    private TableColumn<tableDetailOrder, String> columnState;

    /**
     * 房间类型列
     */
    @FXML
    private TableColumn<tableDetailOrder, String> columnRoomType;

    /**
     * 入住人数列
     */
    @FXML
    private TableColumn<tableDetailOrder, Number> columnPeopleNumber;

    /**
     * 价格列
     */
    @FXML
    private TableColumn<tableDetailOrder, Number> columnPrice;

    /**
     * 有无儿童列
     */
    @FXML
    private TableColumn<tableDetailOrder, String> columnHaveChild;

    /**
     * 历史订单列表填充数据
     */
    private ObservableList<tableDetailOrder> Data = FXCollections.observableArrayList();

    /**
     * 酒店名称（大标题）
     */
    @FXML
    private Label textHotelTitle;

    /**
     * 酒店信息——名称
     */
    @FXML
    private Text textHotelName;

    /**
     * 酒店信息——详细地址
     */
    @FXML
    private Text textDetailAddress;

    /**
     * 酒店信息——联系方式
     */
    @FXML
    private Text textContactNumber;

    /**
     * 酒店信息——评分
     */
    @FXML
    private Text textGrade;

    /**
     * 酒店信息——星级
     */
    @FXML
    private Text textStar;

    /**
     * 酒店信息——简介
     */
    @FXML
    private Text textIntroduction;

    /**
     * 酒店信息——设施
     */
    @FXML
    private Text textFacility;

    /**
     * 单人房价格
     */
    @FXML
    private Text singlePrice;

    /**
     * 单人房数量
     */
    @FXML
    private Text singleNum;

    /**
     * 双人房价格
     */
    @FXML
    private Text doublePrice;

    /**
     * 双人房数量
     */
    @FXML
    private Text doubleNum;

    /**
     * 无障碍客房价格
     */
    @FXML
    private Text disabledPrice;

    /**
     * 无障碍客房数量
     */
    @FXML
    private Text disabledNum;

    /**
     * 第一条评价模块
     */
    @FXML
    private AnchorPane comment1;

    /**
     * 第二条评价模块
     */
    @FXML
    private AnchorPane comment2;

    /**
     * 第三条评价模块
     */
    @FXML
    private AnchorPane comment3;

    /**
     * 第一条评价
     */
    @FXML
    private Text textComment1;

    /**
     * 第二条评价
     */
    @FXML
    private Text textComment2;

    /**
     * 第三条评价
     */
    @FXML
    private Text textComment3;

    /**
     * 跳转界面的类
     */
    sceneJump jump = new sceneJump();

    public uiHotelController() throws RemoteException {
    }

    /**
     * 跳转到首页
     *
     * @throws IOException
     */
    public void gotoHomePage() throws IOException {
        jump.gotoHomePage();
    }

    /**
     * 跳转到我的订单
     *
     * @throws IOException
     */
    public void gotoMyOrder() throws IOException {
        jump.gotoMyOrder();
    }

    /**
     * 跳转到浏览酒店
     *
     * @throws IOException
     */
    public void gotoReadHotel() throws IOException {
        jump.gotoReadHotel();
    }

    /**
     * 跳转到搜索酒店
     *
     * @throws IOException
     */
    public void gotoSearchHotel() throws IOException {
        jump.gotoSearchHotel();
    }

    /**
     * 跳转到个人信息
     *
     * @throws IOException
     */
    public void gotoUserInfo() throws IOException {
        jump.gotoUserInfo();
    }

    /**
     * 清空账号信息，并跳转回登录界面
     *
     * @throws IOException
     */
    public void LogOut() throws IOException {
        LogController logController = new LogController();
        logController.logOut();
        jump.gotoLogin();
    }

    /**
     * 显示酒店的基本信息
     *
     * @throws IOException
     */
    public void showInfo() throws IOException {
        buttonInfo.setVisible(false);
        buttonRoom.setVisible(true);
        buttonComment.setVisible(true);
        buttonHistoryOrder.setVisible(true);
        HotelInfoPane.setVisible(true);
        HotelRoomPane.setVisible(false);
        UserCommentPane.setVisible(false);
        HistoryOrderPane.setVisible(false);
    }

    /**
     * 显示酒店的房间信息
     *
     * @throws IOException
     */
    public void showRoom() throws IOException {
        buttonInfo.setVisible(true);
        buttonRoom.setVisible(false);
        buttonComment.setVisible(true);
        buttonHistoryOrder.setVisible(true);
        HotelInfoPane.setVisible(false);
        HotelRoomPane.setVisible(true);
        UserCommentPane.setVisible(false);
        HistoryOrderPane.setVisible(false);
    }

    /**
     * 显示酒店的用户评价
     *
     * @throws IOException
     */
    public void showComment() throws IOException {
        buttonInfo.setVisible(true);
        buttonRoom.setVisible(true);
        buttonComment.setVisible(false);
        buttonHistoryOrder.setVisible(true);
        HotelInfoPane.setVisible(false);
        HotelRoomPane.setVisible(false);
        UserCommentPane.setVisible(true);
        HistoryOrderPane.setVisible(false);
    }

    /**
     * 显示该用户在酒店的历史订单
     *
     * @throws IOException
     */
    public void showHistoryOrder() throws IOException {
        buttonInfo.setVisible(true);
        buttonRoom.setVisible(true);
        buttonComment.setVisible(true);
        buttonHistoryOrder.setVisible(false);
        HotelInfoPane.setVisible(false);
        HotelRoomPane.setVisible(false);
        UserCommentPane.setVisible(false);
        HistoryOrderPane.setVisible(true);
    }

    /**
     * 跳转到预订酒店界面
     *
     * @throws IOException
     */
    public void gotoReserveHotel() throws IOException {
        jump.gotoReserveHotel();
    }


    /**
     * 初始化订单信息
     *
     * @param list 订单列表
     * @throws RemoteException
     */
    public void initTable(ArrayList<OrderVO> list) throws RemoteException {
        ObservableList<tableDetailOrder> orderData = FXCollections.observableArrayList();
        for (int i = 0; i < list.size(); i++) {
            String date = "";
            date = UiFormatChanger.dateToString(list.get(i).getCheckInDate()) + " 至 " + UiFormatChanger.dateToString(list.get(i).getCheckOutDate());
            String havecd;
            if (list.get(i).isHaveChild()) {
                havecd = "是";
            } else havecd = "否";
            orderData.add(new tableDetailOrder(list.get(i).getOrderID(), date, UiFormatChanger.stateTOstring(list.get(i).getOrderState())
                    , list.get(i).getPeopleNumber(), list.get(i).getPrice(), havecd, UiFormatChanger.typeTOstring(list.get(i).getRoomType())));
            System.out.println(list.get(i).getPrice());
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

    /**
     * 初始化酒店基本信息
     *
     * @param currentHotel 当前酒店
     */
    public void initHotelInfo(HotelinfoVO currentHotel) {
        textHotelTitle.setText(currentHotel.getHotelname());
        textHotelName.setText(currentHotel.getHotelname());
        textDetailAddress.setText(currentHotel.getDetailAddress());
        textContactNumber.setText(currentHotel.getContactNumber());
        textGrade.setText(String.valueOf(currentHotel.getGrade()));
        textStar.setText(String.valueOf(currentHotel.getStar()));
        textIntroduction.setText(currentHotel.getIntroduction());
        textFacility.setText(currentHotel.getService());
    }

    /**
     * 初始化房间信息
     *
     * @param roomlist 房间信息列表
     */
    public void initRoomInfo(ArrayList<HotelroomVO> roomlist) {
        for (int i = 0; i < roomlist.size(); i++) {
            if (roomlist.get(i).getRoomType() == RoomType.SingleRoom) {
                singlePrice.setText(String.valueOf(roomlist.get(i).getPrice()));
                singleNum.setText(String.valueOf(roomlist.get(i).getRoomNumber()));
            }
            if (roomlist.get(i).getRoomType() == RoomType.DoubleRoom) {
                doublePrice.setText(String.valueOf(roomlist.get(i).getPrice()));
                doubleNum.setText(String.valueOf(roomlist.get(i).getRoomNumber()));
            }
            if (roomlist.get(i).getRoomType() == RoomType.DisabledRoom) {
                disabledPrice.setText(String.valueOf(roomlist.get(i).getPrice()));
                disabledNum.setText(String.valueOf(roomlist.get(i).getRoomNumber()));
            }
        }
    }

    /**
     * 初始化评价信息
     *
     * @param list 评价列表
     */
    public void initComment(ArrayList<CommentVO> list) {
        //如果该酒店只有一条评价，则只显示第一条评价模块
        if (list.size() == 1) {
            comment1.setVisible(true);
            textComment1.setText(list.get(0).getComment());
        }
        //如果该酒店只有两条评价，则只显示第一条、第二条评价模块
        if (list.size() == 2) {
            comment1.setVisible(true);
            textComment1.setText(list.get(0).getComment());
            comment2.setVisible(true);
            textComment2.setText(list.get(1).getComment());
        }
        //如果该酒店有三条及以上评价，显示最新三条评价
        if (list.size() >= 3) {
            comment1.setVisible(true);
            textComment1.setText(list.get(list.size()-1).getComment());
            comment2.setVisible(true);
            textComment2.setText(list.get(list.size()-2).getComment());
            comment3.setVisible(true);
            textComment3.setText(list.get(list.size()-3).getComment());
        }
    }

    /**
     * 初始化酒店信息
     *
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            HotelinfoVO currentHotel = userController.readHotel(jump.getHotelID());
            ArrayList<OrderVO> orderlist = userController.getHotelOrderByUserID(jump.getHotelID());
            ArrayList<HotelroomVO> roomlist = userController.getRooms(jump.getHotelID());
            ArrayList<CommentVO> commentlist = userController.getComments(jump.getHotelID());
            initHotelInfo(currentHotel);
            initRoomInfo(roomlist);
            initTable(orderlist);
            initComment(commentlist);
            UserName.setText(userController.showUserInfo().getName());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        //默认首页为酒店基本信息
        buttonInfo.setVisible(false);
    }
}

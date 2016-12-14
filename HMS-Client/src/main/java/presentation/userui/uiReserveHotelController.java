package presentation.userui;

import businesslogic.userbl.UserController;
import businesslogicservice.userblservice.HotelOrderBlService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.util.Callback;
import vo.HotelinfoVO;
import vo.OrderVO;

import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

import static javax.swing.UIManager.getString;

/**
 * Created by Administrator on 2016/12/9.
 */
public class uiReserveHotelController implements Initializable{
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
    @FXML
    private Text textHotelName;
    @FXML
    private ToggleGroup RoomType;
    @FXML
    private RadioButton singleRoom;
    @FXML
    private RadioButton doubleRoom;
    @FXML
    private RadioButton standardRoom;
    @FXML
    private TextField textRoomNumber;
    @FXML
    private TextField textPeopleNumber;
    @FXML
    private ToggleGroup HaveChild;
    @FXML
    private RadioButton haveChild;
    @FXML
    private RadioButton haveNoChild;
    @FXML
    private DatePicker checkinDate;
    @FXML
    private DatePicker checkoutDate;
    @FXML
    private Button buttonCommitOrder;
    @FXML
    private Button buttonCancel;

    /**
     * 提交订单
     * @throws IOException
     */
    public void CommitOrder() throws IOException, ParseException {
        if(textPeopleNumber==null||textRoomNumber==null||HaveChild.getSelectedToggle()==null||
                RoomType.getSelectedToggle()==null||checkinDate.getValue()==null||checkoutDate.getValue()==null){
            return;
        }
        else {
            //读取酒店信息
            HotelOrderBlService hotelOrderBlService = new UserController();
            HotelinfoVO currentHotel = hotelOrderBlService.readHotel(jump.getHotelID());
            //设置订单信息
            OrderVO reserveOrder = new OrderVO(currentHotel.getHotelID(), currentHotel.getHotelname(), currentHotel.getTradeArea(),
                    currentHotel.getAddress(), currentHotel.getDetailAddress(), Integer.parseInt(textRoomNumber.getText()), Integer.parseInt(textPeopleNumber.getText()),
                    getDate(checkinDate), getDate(checkoutDate), getRoomType(RoomType), (HaveChild.getSelectedToggle() == haveChild));
            OrderVO confirmOrder = hotelOrderBlService.makeOrder(reserveOrder);
            setCurrentOrder(confirmOrder);
            System.out.println(confirmOrder.getOrderID());
            System.out.println(confirmOrder.getDdl());


//            hotelOrderBlService.orderHotel(confirmOrder);
            //确认预订
            jump.ConfirmOrder();

        }
    }
    public void Cancel() throws IOException{
        jump.gotoHotel();
    }
    /**
     * 获取日期
     * @param ld 日期选取器
     * @return Date格式的日期
     */
    public static Date getDate(DatePicker ld) throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        return sdf.parse(ld.getValue().toString());
    }

    /**
     * 获取房间类型
     * @param bt 房间类型的单选组合
     * @return 预订房间类型
     */
    public enumData.RoomType getRoomType(ToggleGroup bt){
        if(bt.getSelectedToggle()==singleRoom){return enumData.RoomType.SingleRoom;}
        else if(bt.getSelectedToggle()==doubleRoom){return enumData.RoomType.DoubleRoom;}
        else if(bt.getSelectedToggle()==standardRoom){return enumData.RoomType.DisabledRoom;}
        else return null;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //读取酒店信息
        HotelOrderBlService hotelOrderBlService = null;
        try {
            hotelOrderBlService = new UserController();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        HotelinfoVO currentHotel = null;
        try {
            currentHotel = hotelOrderBlService.readHotel(sceneJump.getHotelID());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        textHotelName.setText(currentHotel.getHotelname());
        /**
         * 入住时间可选择范围晚于当前日期
         */
        final Callback<DatePicker, DateCell> dayCellFactoryin = new Callback<DatePicker, DateCell>() {
            @Override
            public DateCell call(final DatePicker datePicker) {
                return new DateCell() {
                            @Override
                            public void updateItem(LocalDate item, boolean empty) {
                                super.updateItem(item, empty);
                                if (item.isBefore(LocalDate.now())) {
                                    setDisable(true);
                                    setStyle("-fx-background-color: #ffc0cb;");
                                }
                            }
                        };
                    }
                };


        checkinDate.setDayCellFactory(dayCellFactoryin);

    }

    /**
     * 设定退房时间应该晚于入住时间
     * @throws IOException
     */
    public void initCheckOutDate() throws IOException{
        final Callback<DatePicker, DateCell> dayCellFactory = new Callback<DatePicker, DateCell>() {
            @Override
            public DateCell call(final DatePicker datePicker) {
                return new DateCell() {
                            @Override
                            public void updateItem(LocalDate item, boolean empty) {
                                super.updateItem(item, empty);
                                if (item.isBefore(checkinDate.getValue().plusDays(1))) {
                                    setDisable(true);
                                    setStyle("-fx-background-color: #ffc0cb;");
                                }
                            }
                        };
                    }
                };
        checkoutDate.setDayCellFactory(dayCellFactory);
    }
    static OrderVO currentOrder;
    public static void setCurrentOrder(OrderVO vo){ currentOrder = vo;}
    public static OrderVO getCurrentOrder(){ return currentOrder;}
}

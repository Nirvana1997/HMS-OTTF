package presentation.userui;

import businesslogic.logbl.LogController;
import businesslogic.userbl.UserController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.util.Callback;
import utility.UiFormatChanger;
import vo.HotelinfoVO;
import vo.OrderVO;
import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ResourceBundle;


/**
 * Created by Administrator on 2016/12/9.
 */
public class uiReserveHotelController implements Initializable {
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
     * 酒店名称文本
     */
    @FXML
    private Text textHotelName;

    /**
     * 房间类型组合
     */
    @FXML
    private ToggleGroup RoomType;

    /**
     * 单人房选择框
     */
    @FXML
    private RadioButton singleRoom;

    /**
     * 双人房选择框
     */
    @FXML
    private RadioButton doubleRoom;

    /**
     * 无障碍客房选择框
     */
    @FXML
    private RadioButton standardRoom;

    /**
     * 房间数量输入框
     */
    @FXML
    private TextField textRoomNumber;

    /**
     * 入住人数输入框
     */
    @FXML
    private TextField textPeopleNumber;

    /**
     * 有无儿童组合
     */
    @FXML
    private ToggleGroup HaveChild;

    /**
     * 有儿童选择框
     */
    @FXML
    private RadioButton haveChild;

    /**
     * 入住时间日期选择器
     */
    @FXML
    private DatePicker checkinDate;

    /**
     * 退房时间日期选择器
     */
    @FXML
    private DatePicker checkoutDate;

    /**
     * 房间数量不足的警告
     */
    @FXML
    private Text warningRoom;

    /**
     * 用户信用不足的警告
     */
    @FXML
    private Text warningCredit;

    /**
     * 跳转界面的类
     */
    sceneJump jump = new sceneJump();

    public uiReserveHotelController() throws RemoteException {
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
     * 提交订单
     *
     * @throws IOException
     */
    public void CommitOrder() throws IOException, ParseException {
        if (textPeopleNumber == null || textRoomNumber == null || HaveChild.getSelectedToggle() == null ||
                RoomType.getSelectedToggle() == null || checkinDate.getValue() == null || checkoutDate.getValue() == null) {
            return;
        } else {
            //读取酒店信息
            HotelinfoVO currentHotel = userController.readHotel(jump.getHotelID());
            //设置订单信息
            OrderVO reserveOrder = new OrderVO(currentHotel.getHotelID(), currentHotel.getHotelname(), currentHotel.getTradeArea(),
                    currentHotel.getAddress(), currentHotel.getDetailAddress(), Integer.parseInt(textRoomNumber.getText()), Integer.parseInt(textPeopleNumber.getText()),
                    UiFormatChanger.getDate(checkinDate), UiFormatChanger.getDate(checkoutDate), getRoomType(RoomType), haveChild.isSelected());
            if (userController.haveEnoughRoom(reserveOrder) && userController.hasEnoughCredit()) {
                OrderVO confirmOrder = userController.makeOrder(reserveOrder);
                setCurrentOrder(confirmOrder);
                //确认预订
                jump.ConfirmOrder();
            } else if (!userController.haveEnoughRoom(reserveOrder)) {
                warningRoom.setVisible(true);
            } else if (!userController.hasEnoughCredit()) {
                warningCredit.setVisible(true);
            }
        }
    }

    public void Cancel() throws IOException {
        jump.gotoHotel();
    }

    /**
     * 获取房间类型
     *
     * @param bt 房间类型的单选组合
     * @return 预订房间类型
     */
    public enumData.RoomType getRoomType(ToggleGroup bt) {
        if (bt.getSelectedToggle() == singleRoom) {
            return enumData.RoomType.SingleRoom;
        } else if (bt.getSelectedToggle() == doubleRoom) {
            return enumData.RoomType.DoubleRoom;
        } else if (bt.getSelectedToggle() == standardRoom) {
            return enumData.RoomType.DisabledRoom;
        } else return null;
    }

    /**
     * 点击房间数量，隐藏房间数量警告信息
     *
     * @throws IOException
     */
    public void notWarningRoom() throws IOException {
        warningRoom.setVisible(false);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //读取酒店信息
        HotelinfoVO currentHotel = null;
        try {
            currentHotel = userController.readHotel(sceneJump.getHotelID());
            UserName.setText(userController.showUserInfo().getName());
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
     *
     * @throws IOException
     */
    public void initCheckOutDate() throws IOException {
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

    /**
     * 当前订单信息
     */
    static OrderVO currentOrder;

    public static void setCurrentOrder(OrderVO vo) {
        currentOrder = vo;
    }

    public static OrderVO getCurrentOrder() {
        return currentOrder;
    }
}

package presentation.userui;

import businesslogic.logbl.LogController;
import businesslogic.userbl.UserController;
import enumData.OrderState;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import utility.UiFormatChanger;
import vo.OrderVO;
import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ResourceBundle;

/**
 * Created by Administrator on 2016/12/5.
 */
public class uiOrderController implements Initializable {
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
     * 撤回按钮
     */
    @FXML
    private Button buttonRevoke;

    /**
     * 评价按钮
     */
    @FXML
    private Button buttonComment;

    /**
     * 订单编号文本
     */
    @FXML
    private Text orderID;

    /**
     * 订单状态文本
     */
    @FXML
    private Text orderState;

    /**
     * 订单酒店名称文本
     */
    @FXML
    private Text orderHotel;

    /**
     * 订单房间类型文本
     */
    @FXML
    private Text orderRoom;

    /**
     * 订单房间数量文本
     */
    @FXML
    private Text orderRoomNumber;

    /**
     * 订单入住人数文本
     */
    @FXML
    private Text orderPeopleNumber;

    /**
     * 订单入住时间文本
     */
    @FXML
    private Text orderTime;

    /**
     * 订单价格文本
     */
    @FXML
    private Text orderPrice;

    /**
     * 订单有无儿童文本
     */
    @FXML
    private Text orderHaveChild;

    /**
     * 跳转界面的类
     */
    sceneJump jump = new sceneJump();

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
     * 撤回订单
     *
     * @throws IOException
     */
    public void RevokeOrder() throws IOException {
        userController.cancelOrder(uiMyOrderController.getOrderID());
        jump.gotoOrder();
        jump.RevokeSuccess();
    }

    /**
     * 跳转到评价订单
     *
     * @throws IOException
     */
    public void gotoCommentOrder() throws IOException {
        jump.gotoCommentOrder();
    }


    public uiOrderController() throws RemoteException {
    }

    /**
     * 初始化订单信息
     *
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        OrderVO vo = null;
        try {
            vo = userController.getOrderInfo(uiMyOrderController.getOrderID());
            UserName.setText(userController.showUserInfo().getName());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if (vo.getOrderState() == OrderState.executed) {
            buttonComment.setVisible(true);
        } else if (vo.getOrderState() == OrderState.executing) {
            buttonRevoke.setVisible(true);
        }
        orderID.setText(vo.getOrderID());
        orderState.setText(UiFormatChanger.stateTOstring(vo.getOrderState()));
        try {
            orderHotel.setText(userController.readHotel(vo.getHotelID()).getHotelname());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        orderRoom.setText(UiFormatChanger.typeTOstring(vo.getRoomType()));
        orderRoomNumber.setText(String.valueOf(vo.getRoomNumber()));
        orderPeopleNumber.setText(String.valueOf(vo.getPeopleNumber()));
        String date = "";
        date = UiFormatChanger.dateToString(vo.getCheckInDate()) + " 至 " + UiFormatChanger.dateToString(vo.getCheckOutDate());
        orderTime.setText(date);
        orderPrice.setText(String.valueOf(vo.getPrice()));
        if (vo.isHaveChild())
            orderHaveChild.setText("是");
        else
            orderHaveChild.setText("否");
    }


}

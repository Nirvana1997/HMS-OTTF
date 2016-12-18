package presentation.userui;

import businesslogic.userbl.UserController;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import enumData.OrderState;
import enumData.RoomType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import utility.UiFormatChanger;
import vo.OrderVO;

import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

/**
 * Created by Administrator on 2016/12/5.
 */
public class uiOrderController implements Initializable{
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
    private Label textMyOrder;
    @FXML
    private Button buttonRevoke;

    /**
     * 撤回订单
     * @throws IOException
     */
    public void RevokeOrder() throws IOException{
        userController.cancelOrder(uiMyOrderController.getOrderID());
        jump.gotoOrder();
        jump.RevokeSuccess();
    }
    @FXML
    private Button buttonComment;
    public void gotoCommentOrder() throws IOException{
        jump.gotoCommentOrder();
    }
    @FXML
    private Text orderID;
    @FXML
    private Text orderState;
    @FXML
    private Text orderHotel;
    @FXML
    private Text orderRoom;
    @FXML
    private Text orderRoomNumber;
    @FXML
    private Text orderPeopleNumber;
    @FXML
    private Text orderTime;
    @FXML
    private Text orderPrice;
    @FXML
    private Text orderHaveChild;

    public uiOrderController() throws RemoteException {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        OrderVO vo = null;
        try {
            vo = userController.getOrderInfo(uiMyOrderController.getOrderID());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if(vo.getOrderState()== OrderState.executed){
            buttonComment.setVisible(true);
        }
        else if(vo.getOrderState() == OrderState.executing){
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
        date = UiFormatChanger.dateToString(vo.getCheckInDate())+" 至 " + UiFormatChanger.dateToString(vo.getCheckOutDate());
        orderTime.setText(date);
        orderPrice.setText(String.valueOf(vo.getPrice()));
        if(vo.isHaveChild())
            orderHaveChild.setText("是");
        else
            orderHaveChild.setText("否");
    }


}

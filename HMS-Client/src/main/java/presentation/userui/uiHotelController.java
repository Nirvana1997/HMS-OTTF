package presentation.userui;

import businesslogic.userbl.UserController;
import businesslogicservice.userblservice.HotelOrderBlService;
import enumData.Address;
import enumData.TradeArea;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import vo.HotelListItemVO;
import vo.HotelinfoVO;

import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ResourceBundle;

/**
 * Created by Administrator on 2016/12/8.
 */
public class uiHotelController implements Initializable{

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
    @Override
    public void initialize (URL location, ResourceBundle resources) {
        HotelOrderBlService hotelOrderBlService = null;
        try {
            hotelOrderBlService = new UserController();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        HotelinfoVO currentHotel = null;
        try {
            currentHotel = hotelOrderBlService.readHotel(jump.getHotelID());
        } catch (RemoteException e) {
            e.printStackTrace();
        }

//        HotelinfoVO currentHotel =  new HotelinfoVO("0001","喋喋大酒店", TradeArea.Xianlin, Address.DieDie,"南大旁边","15105180105","一座由喋喋开的酒店","洗衣机",5, 3.0);
        textHotelTitle.setText(currentHotel.getHotelname());
        textHotelName.setText(currentHotel.getHotelname());
        textDetailAddress.setText(currentHotel.getDetailAddress());
        textContactNumber.setText(currentHotel.getContactNumber());
        textGrade.setText(String.valueOf(currentHotel.getGrade()));
        textStar.setText(String.valueOf(currentHotel.getStar()));
        textIntroduction.setText(currentHotel.getIntroduction());
        buttonInfo.setVisible(false);
    }
}

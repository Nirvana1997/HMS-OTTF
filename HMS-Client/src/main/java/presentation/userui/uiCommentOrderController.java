package presentation.userui;

import businesslogic.logbl.LogController;
import businesslogic.userbl.UserController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import vo.CommentVO;
import vo.HotelinfoVO;
import vo.OrderVO;

import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ResourceBundle;

/**
 * Created by Administrator on 2016/12/5.
 */
public class uiCommentOrderController implements Initializable{
    /**
     * 用户界面控制器
     */
    UserController userController = new UserController();

    /**
     * 跳转界面的类
     */
    sceneJump jump = new sceneJump();


    /**
     * 用户真实姓名
     */
    @FXML
    private Text UserName;


    /**
     * 评价文本输入框
     */
    @FXML
    private TextArea textComment;

    @FXML
    private Button star1;
    @FXML
    private Button star2;
    @FXML
    private Button star3;
    @FXML
    private Button star4;
    @FXML
    private Button star5;
    @FXML
    private Text star;
    @FXML
    private Text orderHotel;

    public uiCommentOrderController() throws RemoteException {
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
     * 跳转到详细订单界面
     *
     * @throws IOException
     */
    public void gotoOrder() throws IOException {
        jump.gotoOrder();
    }

    /**
     * 评价订单
     *
     * @throws IOException
     */
    public void CommentOrder() throws IOException {
        OrderVO ordervo = userController.getOrderInfo(uiMyOrderController.getOrderID());
        CommentVO commentvo = new CommentVO(ordervo.getHotelID(), userController.showUserInfo().getUserID(),
                textComment.getText(), grade);
        userController.comment(commentvo);
        jump.gotoOrder();
        jump.CommentSuccess();

    }

    public void commentStar1(){
        star1.setVisible(true);
        star2.setVisible(false);
        star3.setVisible(false);
        star4.setVisible(false);
        star5.setVisible(false);
        grade = 1;
        star.setText("（1分，太差啦！）");
    }
    public void commentStar2(){
        star1.setVisible(true);
        star2.setVisible(true);
        star3.setVisible(false);
        star4.setVisible(false);
        star5.setVisible(false);
        grade = 2;
        star.setText("（2分，一般般！）");
    }
    public void commentStar3(){
        star1.setVisible(true);
        star2.setVisible(true);
        star3.setVisible(true);
        star4.setVisible(false);
        star5.setVisible(false);
        grade = 3;
        star.setText("（3分，还行吧！）");
    }
    public void commentStar4(){
        star1.setVisible(true);
        star2.setVisible(true);
        star3.setVisible(true);
        star4.setVisible(true);
        star5.setVisible(false);
        grade = 4;
        star.setText("（4分，很不错！）");
    }
    public void commentStar5(){
        star1.setVisible(true);
        star2.setVisible(true);
        star3.setVisible(true);
        star4.setVisible(true);
        star5.setVisible(true);
        grade = 5;
        star.setText("（5分，那你很棒棒哦~）");
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            UserName.setText(userController.showUserInfo().getName());
            OrderVO orderVO = userController.getOrderInfo(uiMyOrderController.getOrderID());
            HotelinfoVO hotelvo = userController.readHotel(orderVO.getHotelID());
            orderHotel.setText(hotelvo.getHotelname());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
    int grade = 0;
}

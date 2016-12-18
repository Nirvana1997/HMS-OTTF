package presentation.userui;

import businesslogic.userbl.UserController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import vo.CommentVO;
import vo.OrderVO;

import java.io.IOException;
import java.rmi.RemoteException;

/**
 * Created by Administrator on 2016/12/5.
 */
public class uiCommentOrderController {
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

    public uiCommentOrderController() throws RemoteException {
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
    @FXML
    private Label buttonOrderText;
    @FXML
    private Label textMyOrder;
    /**
     * 跳转到详细订单界面
     * @throws IOException
     */
    public void gotoOrder() throws IOException{
        jump.gotoOrder();
    }
    @FXML
    private Button buttonComment;
    @FXML
    private Text orderHotel;
    @FXML
    private TextField textGrade;
    @FXML
    private TextArea textComment;
    /**
     * 评价订单
     * @throws IOException
     */
    public void CommentOrder() throws IOException{
        OrderVO ordervo = userController.getOrderInfo(uiMyOrderController.getOrderID());
        CommentVO commentvo = new CommentVO(ordervo.getHotelID(),userController.showUserInfo().getUserID(),
                textComment.getText(),Integer.parseInt(textGrade.getText()));
        userController.comment(commentvo);
        jump.gotoOrder();
        jump.CommentSuccess();
    }
}

package presentation.userui;

import com.sun.org.apache.xpath.internal.operations.Or;
import enumData.OrderState;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

/**
 * Created by Administrator on 2016/12/3.
 */
public class uiMyOrderController {
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
    }

    /**
     * 选择异常订单，则显示已执行和未执行的订单
     * @throws IOException
     */
    public void chooseAbnormal() throws IOException{
        buttonNormal.setVisible(true);
        buttonAbnormal.setVisible(false);
        buttonRevoke.setVisible(true);
        setOrderState(OrderState.abnormal);
    }
    /**
     * 选择异常订单，则显示已执行和未执行的订单
     * @throws IOException
     */
    public void chooseRevoke() throws IOException{
        buttonNormal.setVisible(true);
        buttonAbnormal.setVisible(true);
        buttonRevoke.setVisible(false);
        setOrderState(OrderState.canceled);
    }

}

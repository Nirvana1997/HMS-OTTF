package presentation.userui;

import businesslogic.userbl.UserController;
import businesslogicservice.userblservice.HotelOrderBlService;
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
 * Created by Administrator on 2016/12/10.
 */
public class uiConfirmOrderController implements Initializable {
    /**
     * 用户界面控制器
     */
    UserController userController = new UserController();


    /**
     * 确认的订单价格
     */
    @FXML
    private Text textPrice;

    /**
     * 确认的订单最终期限
     */
    @FXML
    private Text textDDL;

    /**
     * 确认的订单的营销策略
     */
    @FXML
    private Text textPromotion;

    /**
     * 取消按钮
     */
    @FXML
    private Button buttonCancel;

    /**
     * 类的声明
     */
    sceneJump jump = new sceneJump();

    /**
     * 当前订单
     */
    OrderVO orderVO;

    public uiConfirmOrderController() throws RemoteException {
    }

    /**
     * 确认生成订单
     *
     * @throws IOException
     */
    public void ConfirmOrder() throws IOException {
        userController.orderHotel(orderVO);
        //返回酒店界面
        jump.gotoHotel();
        //提示预订成功
        jump.reserveSuccess();
        //关闭当前窗口
        buttonCancel.getScene().getWindow().hide();
    }

    /**
     * 取消生成订单
     *
     * @throws IOException
     */
    public void Cancel() throws IOException {
        buttonCancel.getScene().getWindow().hide();
    }

    /**
     * 初始化显示订单数据
     *
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        orderVO = uiReserveHotelController.getCurrentOrder();
        textDDL.setText(UiFormatChanger.dateToString2(orderVO.getDdl()));
        textPrice.setText(String.valueOf(orderVO.getPrice()));
        if(orderVO.getPromotionName()!=null) {
            textPromotion.setText(orderVO.getPromotionName());
        }

    }
}

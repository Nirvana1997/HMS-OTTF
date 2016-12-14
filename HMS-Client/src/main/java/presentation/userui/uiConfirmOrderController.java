package presentation.userui;

import businesslogic.userbl.UserController;
import businesslogicservice.userblservice.HotelOrderBlService;
import com.sun.org.apache.bcel.internal.generic.IndexedInstruction;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import vo.OrderVO;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Administrator on 2016/12/10.
 */
public class uiConfirmOrderController implements Initializable{
    @FXML
    private Text textPrice;
    @FXML
    private Text textDDL;
    @FXML
    private Button buttonConfirm;
    @FXML
    private Button buttonCancel;
    sceneJump jump = new sceneJump();
    public void ConfirmOrder() throws IOException{
        HotelOrderBlService hotelOrderBlService = new UserController();
        hotelOrderBlService.orderHotel(orderVO);
        //返回酒店界面
        jump.gotoHotel();
        //提示预订成功
        jump.reserveSuccess();
        //关闭当前窗口
        buttonCancel.getScene().getWindow().hide();
    }
    public void Cancel() throws IOException{
        buttonCancel.getScene().getWindow().hide();
    }
    OrderVO orderVO;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        orderVO = uiReserveHotelController.getCurrentOrder();
        textDDL.setText(orderVO.getDdl().toString());
        textPrice.setText(String.valueOf(orderVO.getPrice()));
    }
}

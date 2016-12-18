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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    /**
     * 日期转字符串
     * @param date 日期
     * @return yyyy_MM.dd格式的日期
     */
    public String dateToString(Date date){
        DateFormat df = new SimpleDateFormat("yyyy_MM_dd");
        return df.format(date);
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        orderVO = uiReserveHotelController.getCurrentOrder();
        textDDL.setText(dateToString(orderVO.getDdl()));
        textPrice.setText(String.valueOf(orderVO.getPrice()));
    }
}

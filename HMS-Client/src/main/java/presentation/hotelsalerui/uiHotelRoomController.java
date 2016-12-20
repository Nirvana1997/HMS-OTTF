package presentation.hotelsalerui;

import businesslogic.hotelsalerbl.HotelSalerController;
import businesslogic.logbl.LogController;
import businesslogicservice.hotelsalerblservice.HotelroomblService;
import businesslogicservice.logblservice.LogBlService;
import com.sun.javafx.robot.impl.FXRobotHelper;
import enumData.RoomType;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import utility.UiFormatChanger;
import vo.BelowLineOrderVO;
import vo.HotelroomVO;

import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

/**
 * Created by thinkpad on 2016/12/3.
 */
public class uiHotelRoomController implements Initializable{

    private SceneJump sceneJump = new SceneJump();
    String hotelID = "";
    HotelSalerController hotelroombl = new HotelSalerController();
    LogBlService logBl = new LogController();
    ArrayList<HotelroomVO> roomArray;
    RoomType roomType;

    /**
     * 编辑房间的按钮
     */
    @FXML
    private Label labelEditSingleRoom;
    @FXML
    private Label labelEditDoubleRoom;
    @FXML
    private Label labelEditDisabledRoom;

    /**
     * 显示房间数量的label
     */
    @FXML
    private Label labelSingleRoomNum;
    @FXML
    private Label labelDoubleRoomNum;
    @FXML
    private Label labelDisabledRoomNum;

    /**
     * 显示房间价格的label
     */
    @FXML
    private Label labelSingleRoomPrice;
    @FXML
    private Label labelDoubleRoomPrice;
    @FXML
    private Label labelDisabledRoomPrice;

    /**
     * 输入房间价格的textField
     */
    @FXML
    private TextField textFieldSingleRoomPrice;
    @FXML
    private TextField textFieldDoubleRoomPrice;
    @FXML
    private TextField textFieldDisabledRoomPrice;

    /**
     * 确认取消按钮
     */
    @FXML
    private Button buttonConfirmSingleRoom;
    @FXML
    private Button buttonCancelSingleRoom;
    @FXML
    private Button buttonConfirmDoubleRoom;
    @FXML
    private Button buttonCancelDoubleRoom;
    @FXML
    private Button buttonConfirmDisabledRoom;
    @FXML
    private Button buttonCancelDisabledRoom;
    @FXML
    private CheckBox checkBoxCheckIn;
    @FXML
    private CheckBox checkBoxCheckOut;
    @FXML
    private CheckBox checkBoxSingleRoom;
    @FXML
    private CheckBox checkBoxDoubleRoom;
    @FXML
    private CheckBox checkBoxDisabledRoom;
    @FXML
    private TextField textFieldRoomNum;
    @FXML
    private DatePicker datePickerBeginTime;
    @FXML
    private DatePicker datePickerEndTime;

    public uiHotelRoomController() throws RemoteException {
    }

    /**
     * 登出按钮
     */
    @FXML
    private Label labelExit;

    /**
     * 酒店信息按钮点击监听
     */
    public void jumpToSceneHotelInfo() throws IOException {
        sceneJump.jumpToSceneHotelInfo();
    }

    /**
     * 酒店订单按钮点击监听
     */
    public void jumpToSceneHotelOrder() throws IOException {
        sceneJump.jumpToSceneHotelOrder();
    }

    /**
     * 酒店促销按钮点击监听
     */
    public void jumpToSceneHotelSaleStrategy() throws IOException {
        sceneJump.jumpToSceneHotelSaleStrategy();
    }

    /**
     * 鼠标进入编辑单人房按钮
     */
    public void onEnteredLabelEditSingleRoom(){
        labelEditSingleRoom.setUnderline(true);
    }

    /**
     * 鼠标移出编辑单人房按钮
     */
    public void onExitedLabelEditSingleRoom(){
        labelEditSingleRoom.setUnderline(false);
    }

    /**
     * 鼠标点击编辑单人房按钮
     */
    public void onClickedLabelEditSingleRoom(){
        labelSingleRoomNum.setVisible(false);
        labelSingleRoomPrice.setVisible(false);
        textFieldSingleRoomPrice.setVisible(true);
        labelEditSingleRoom.setVisible(false);
        buttonConfirmSingleRoom.setVisible(true);
        buttonCancelSingleRoom.setVisible(true);
    }

    /**
     * 鼠标进入编辑双人房按钮
     */
    public void onEnteredLabelEditDoubleRoom(){
        labelEditDoubleRoom.setUnderline(true);
    }

    /**
     * 鼠标移出编辑双人房按钮
     */
    public void onExitedLabelEditDoubleRoom(){
        labelEditDoubleRoom.setUnderline(false);
    }

    /**
     * 鼠标点击编辑双人房按钮
     */
    public void onClickedLabelEditDoubleRoom(){
        labelDoubleRoomNum.setVisible(false);
        labelDoubleRoomPrice.setVisible(false);
        textFieldDoubleRoomPrice.setVisible(true);
        labelEditDoubleRoom.setVisible(false);
        buttonConfirmDoubleRoom.setVisible(true);
        buttonCancelDoubleRoom.setVisible(true);
    }

    /**
     * 鼠标进入编辑残疾人房按钮
     */
    public void onEnteredLabelEditDisabledRoom(){
        labelEditDisabledRoom.setUnderline(true);
    }

    /**
     * 鼠标移出编辑残疾人房按钮
     */
    public void onExitedLabelEditDisabledRoom(){
        labelEditDisabledRoom.setUnderline(false);
    }

    /**
     * 鼠标点击编辑残疾人房按钮
     */
    public void onClickedLabelEditDisabledRoom(){
        labelDisabledRoomNum.setVisible(false);
        labelDisabledRoomPrice.setVisible(false);
        textFieldDisabledRoomPrice.setVisible(true);
        labelEditDisabledRoom.setVisible(false);
        buttonConfirmDisabledRoom.setVisible(true);
        buttonCancelDisabledRoom.setVisible(true);
    }

    /**
     * 确认修改单人房监听
     */
    public void confirmEditSingleRoom(){
        double price = Integer.parseInt(textFieldSingleRoomPrice.getText());
        HotelroomVO vo = new HotelroomVO(hotelID, RoomType.SingleRoom, price, roomArray.get(0).getRoomNumber());
        ArrayList<HotelroomVO> temp = new ArrayList<>();
        temp.add(vo);
        temp.add(roomArray.get(1));
        temp.add(roomArray.get(2));
        try {
            hotelroombl.setRoomInfo(temp);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        cancelEditSingleRoom();
    }

    /**
     * 取消修改单人房监听
     */
    public void cancelEditSingleRoom(){
        labelEditSingleRoom.setVisible(true);
        buttonConfirmSingleRoom.setVisible(false);
        buttonCancelSingleRoom.setVisible(false);
        textFieldSingleRoomPrice.setVisible(false);
        labelSingleRoomNum.setVisible(true);
        labelSingleRoomPrice.setVisible(true);
    }

    /**
     * 确认修改双人房监听
     */
    public void confirmEditDoubleRoom(){
        double price = Integer.parseInt(textFieldDoubleRoomPrice.getText());
        HotelroomVO vo = new HotelroomVO(hotelID, RoomType.DoubleRoom, price, roomArray.get(1).getRoomNumber());
        ArrayList<HotelroomVO> temp = new ArrayList<>();
        temp.add(roomArray.get(0));
        temp.add(vo);
        temp.add(roomArray.get(2));
        try {
            hotelroombl.setRoomInfo(temp);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        cancelEditDoubleRoom();
    }

    /**
     * 取消修改双人房监听
     */
    public void cancelEditDoubleRoom(){
        labelEditDoubleRoom.setVisible(true);
        buttonConfirmDoubleRoom.setVisible(false);
        buttonCancelDoubleRoom.setVisible(false);
        textFieldDoubleRoomPrice.setVisible(false);
        labelDoubleRoomNum.setVisible(true);
        labelDoubleRoomPrice.setVisible(true);
    }

    /**
     * 确认修改残疾人房监听
     */
    public void confirmEditDisabledRoom(){
        double price = Integer.parseInt(textFieldDisabledRoomPrice.getText());
        HotelroomVO vo = new HotelroomVO(hotelID, RoomType.DisabledRoom, price, roomArray.get(2).getRoomNumber());
        ArrayList<HotelroomVO> temp = new ArrayList<>();
        temp.add(roomArray.get(0));
        temp.add(roomArray.get(1));
        temp.add(vo);
        try {
            hotelroombl.setRoomInfo(temp);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        cancelEditDisabledRoom();
    }

    /**
     * 取消修改残疾人房监听
     */
    public void cancelEditDisabledRoom(){
        labelEditDisabledRoom.setVisible(true);
        buttonConfirmDisabledRoom.setVisible(false);
        buttonCancelDisabledRoom.setVisible(false);
        textFieldDisabledRoomPrice.setVisible(false);
        labelDisabledRoomNum.setVisible(true);
        labelDisabledRoomPrice.setVisible(true);
    }

    /**
     * 鼠标移入登出按钮监听
     */
    public void enteredLabelExit(){
        labelExit.setUnderline(true);
    }

    /**
     * 鼠标移出登出按钮监听
     */
    public void exitedLabelExit(){
        labelExit.setUnderline(false);
    }

    /**
     * 点击登出按钮监听
     */
    public void onClickedLabelExit() throws IOException {
        sceneJump.backToLogin();
        logBl.logOut();
    }

    /**
     * 点击入住监听
     */
    public void onClickedCheckIn() {
        checkBoxCheckOut.setSelected(false);
    }

    /**
     * 点击退房监听
     */
    public void onClickedCheckOut() {
        checkBoxCheckIn.setSelected(false);
    }

    public void onClickedBookSingleRoom(){
        checkBoxDoubleRoom.setSelected(false);
        checkBoxDisabledRoom.setSelected(false);
        roomType = RoomType.SingleRoom;
    }

    public void onClickedBookDoubleRoom(){
        checkBoxSingleRoom.setSelected(false);
        checkBoxDisabledRoom.setSelected(false);
        roomType = RoomType.DoubleRoom;
    }

    public void onClickedBookDisabledRoom(){
        checkBoxSingleRoom.setSelected(false);
        checkBoxDoubleRoom.setSelected(false);
        roomType = RoomType.DisabledRoom;
    }

    /**
     * 用户线下登记确认信息填写
     */
    public void confirmOffLine(){
        if(checkBoxCheckIn.isSelected()){
            try {
                Date dateBegin = UiFormatChanger.getDate(datePickerBeginTime);
                Date dateEnd = UiFormatChanger.getDate(datePickerEndTime);
                BelowLineOrderVO vo = new BelowLineOrderVO(hotelID, dateBegin, dateEnd, roomType, Integer.parseInt(textFieldRoomNum.getText()));
                try {
                    hotelroombl.setOrdered(vo);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        if(checkBoxCheckOut.isSelected()){
            try {
                Date dateBegin = UiFormatChanger.getDate(datePickerBeginTime);
                Date dateEnd = UiFormatChanger.getDate(datePickerEndTime);
                BelowLineOrderVO vo = new BelowLineOrderVO(hotelID, dateBegin, dateEnd, roomType, Integer.parseInt(textFieldRoomNum.getText()));
                try {
                    hotelroombl.setEmpty(vo);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 用户线下登记取消信息填写
     */
    public void cancelOffLine(){
        checkBoxCheckIn.setSelected(false);
        checkBoxCheckOut.setSelected(false);
        checkBoxSingleRoom.setSelected(false);
        checkBoxDoubleRoom.setSelected(false);
        checkBoxDisabledRoom.setSelected(false);
        textFieldRoomNum.setText("");
        // TODO
        datePickerBeginTime.setValue(null);
        datePickerEndTime.setValue(null);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            roomArray = hotelroombl.getRoomInfo();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if(roomArray.size() == 0){
            labelSingleRoomNum.setText("0");
            labelSingleRoomPrice.setText("0");
            labelDoubleRoomNum.setText("0");
            labelDoubleRoomPrice.setText("0");
            labelDisabledRoomNum.setText("0");
            labelDisabledRoomPrice.setText("0");
        }else {
            this.hotelID = roomArray.get(0).getHotelID();
            labelSingleRoomNum.setText(String.valueOf(roomArray.get(0).getRoomNumber()));
            labelSingleRoomPrice.setText(String.valueOf(roomArray.get(0).getPrice()));
            labelDoubleRoomNum.setText(String.valueOf(roomArray.get(1).getRoomNumber()));
            labelDoubleRoomPrice.setText(String.valueOf(roomArray.get(1).getPrice()));
            labelDisabledRoomNum.setText(String.valueOf(roomArray.get(2).getRoomNumber()));
            labelDisabledRoomPrice.setText(String.valueOf(roomArray.get(2).getPrice()));
        }
    }
}

package presentation.hotelsalerui;

import businesslogic.hotelsalerbl.HotelSalerController;
import businesslogic.logbl.LogController;
import businesslogicservice.hotelsalerblservice.HotelinfoblService;
import businesslogicservice.hotelsalerblservice.HotelsalerblService;
import businesslogicservice.logblservice.LogBlService;
import enumData.Address;
import enumData.TradeArea;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import vo.HotelinfoVO;

import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ResourceBundle;

/**
 * Created by thinkpad on 2016/12/4.
 */
public class uiEditInfoController implements Initializable{

    private String tradeArea = "";
    private String address = "";
    private String hotelID = "";
    private int star = 0;
    private double grade = 0;
    private double minPrice = 0;
    private SceneJump sceneJump = new SceneJump();
    HotelinfoblService hotelInfobl = new HotelSalerController();
    HotelsalerblService hotelsalerbl = new HotelSalerController();

    LogBlService logBl = new LogController();

    /**
     * 登出按钮
     */
    @FXML
    private Label labelExit;

    @FXML
    private TextField textFieldHotelName;
    @FXML
    private TextField textFieldDetailAddress;
    @FXML
    private TextField textFieldTelNumber;
    @FXML
    private TextArea textAreaHotelIntroduction;
    @FXML
    private TextArea textAreaHotelFacility;
    @FXML
    private MenuButton menuButtonChooseTradeArea;
    @FXML
    private MenuButton menuButtonAddresss;

    public uiEditInfoController() throws RemoteException {
    }

    /**
     * 酒店房间按钮点击监听
     */
    public void jumpToSceneHotelRoom() throws IOException {
        sceneJump.jumpToSceneHotelRoom();
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
     * 确认修改酒店信息监听
     */
    public void onClickedConfirmEditHotelInfo() throws IOException{
        String hotelName = textFieldHotelName.getText();
        String detailAddress = textFieldDetailAddress.getText();
        String telNumber = textFieldTelNumber.getText();
        String hotelIntroduction = textAreaHotelIntroduction.getText();
        String hotelFacility = textAreaHotelFacility.getText();
        HotelinfoVO vo = new HotelinfoVO(hotelID,hotelName,TradeArea.valueOf(tradeArea),Address.valueOf(address),detailAddress,telNumber,hotelIntroduction,hotelFacility,star,grade,minPrice);
        hotelsalerbl.modifyHotelInfo(vo);
        sceneJump.jumpToSceneHotelInfo();
    }

    /**
     * 取消修改酒店信息监听
     */
    public void onClickedCancelEditHotelInfo() throws IOException{
        sceneJump.jumpToSceneHotelInfo();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            HotelinfoVO vo = hotelInfobl.getHotelinfo();
            this.hotelID = vo.getHotelID();
            star = vo.getStar();
            textFieldHotelName.setText(vo.getHotelname());
            textFieldDetailAddress.setText(vo.getDetailAddress());
            textFieldTelNumber.setText(vo.getContactNumber());
            textAreaHotelIntroduction.setText(vo.getIntroduction());
            textAreaHotelFacility.setText(vo.getService());
            this.grade = vo.getGrade();
            this.minPrice = vo.getMinPrice();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        // 初始化选择商圈menuButton
        for(TradeArea area:TradeArea.values()){
            MenuItem menuItem = new MenuItem(area.toString());
            menuButtonChooseTradeArea.getItems().add(menuItem);
            menuItem.setOnAction(event -> {
                this.tradeArea = area.toString();
                menuButtonChooseTradeArea.setText(this.tradeArea);
            });
        }
        // 初始化选择地址menuButton
        for(Address temp:Address.values()){
            MenuItem menuItem = new MenuItem(temp.toString());
            menuButtonAddresss.getItems().add(menuItem);
            menuItem.setOnAction(event -> {
                this.address = temp.toString();
                menuButtonAddresss.setText(this.address);
            });
        }
    }
}

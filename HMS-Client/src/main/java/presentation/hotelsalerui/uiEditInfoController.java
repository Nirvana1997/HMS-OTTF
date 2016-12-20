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
public class uiEditInfoController implements Initializable {

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
    public void enteredLabelExit() {
        labelExit.setUnderline(true);
    }

    /**
     * 鼠标移出登出按钮监听
     */
    public void exitedLabelExit() {
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
    public void onClickedConfirmEditHotelInfo() throws IOException {
        String hotelName = textFieldHotelName.getText();
        String detailAddress = textFieldDetailAddress.getText();
        String telNumber = textFieldTelNumber.getText();
        String hotelIntroduction = textAreaHotelIntroduction.getText();
        String hotelFacility = textAreaHotelFacility.getText();
        HotelinfoVO vo = new HotelinfoVO(hotelID, hotelName, TradeArea.valueOf(tradeArea), Address.valueOf(address), detailAddress, telNumber, hotelIntroduction, hotelFacility, star, grade, minPrice);
        hotelsalerbl.modifyHotelInfo(vo);
        sceneJump.jumpToSceneHotelInfo();
    }

    /**
     * 取消修改酒店信息监听
     */
    public void onClickedCancelEditHotelInfo() throws IOException {
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
            tradeArea = vo.getTradeArea().toString();
            this.grade = vo.getGrade();
            this.minPrice = vo.getMinPrice();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        if(tradeArea.equals("Changjiang")){
            menuButtonChooseTradeArea.setText("长江");
            menuButtonAddresss.setText("上海");
            this.setAddress("Shanghai", "Nanjing", "上海", "南京");
        }
        else if(tradeArea.equals("Huanghe")){
            menuButtonChooseTradeArea.setText("黄河");
            menuButtonAddresss.setText("北京");
            this.setAddress("Beijing", "Tianjing", "北京", "天津");
        }
        else if(tradeArea.equals("Nanhai")){
            menuButtonChooseTradeArea.setText("南海");
            menuButtonAddresss.setText("广东");
            this.setAddress("Guangdong", "Aomen", "广东", "澳门");
        }

        // 初始化选择商圈menuButton
        for (TradeArea area : TradeArea.values()) {
            String text = "";
            if (area == TradeArea.Changjiang) {
                text = "长江";
            } else if (area == TradeArea.Huanghe) {
                text = "黄河";
            } else if (area == TradeArea.Nanhai) {
                text = "南海";
            }
            MenuItem menuItem = new MenuItem(text);
            menuButtonChooseTradeArea.getItems().add(menuItem);
            menuItem.setOnAction(event -> {
                this.tradeArea = area.toString();
                menuButtonChooseTradeArea.setText(menuItem.getText());
                menuButtonAddresss.getItems().clear();
                // 根据选择不同的商圈显示不同可选的地址
                if (menuItem.getText().equals("长江")) {
                    menuButtonAddresss.setText("上海");
                    this.setAddress("Shanghai", "Nanjing", "上海", "南京");
                } else if (menuItem.getText().equals("黄河")) {
                    menuButtonAddresss.setText("北京");
                    this.setAddress("Beijing", "Tianjing", "北京", "天津");
                } else if (menuItem.getText().equals("南海")) {
                    menuButtonAddresss.setText("广东");
                    this.setAddress("Guangdong", "Aomen", "广东", "澳门");
                }
            });
        }
    }

    private void setAddress(String tradeArea1, String tradeArea2, String tradeArea1Name, String tradeArea2Name) {
        MenuItem menuItem = new MenuItem(tradeArea1Name);
        menuButtonAddresss.getItems().add(menuItem);
        menuItem.setOnAction(event -> {
            this.address = tradeArea1;
            menuButtonAddresss.setText(tradeArea1Name);
        });
        MenuItem menuItem2 = new MenuItem(tradeArea2Name);
        menuButtonAddresss.getItems().add(menuItem2);
        menuItem2.setOnAction(event -> {
            this.address = tradeArea2;
            menuButtonAddresss.setText(tradeArea2Name);
        });
    }

}

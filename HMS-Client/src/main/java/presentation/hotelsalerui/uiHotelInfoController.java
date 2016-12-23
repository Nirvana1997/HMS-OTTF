package presentation.hotelsalerui;

import businesslogic.hotelsalerbl.HotelSalerController;
import businesslogic.logbl.LogController;
import businesslogicservice.hotelsalerblservice.HotelinfoblService;
import businesslogicservice.logblservice.LogBlService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import utility.UiFormatChanger;
import vo.HotelinfoVO;

import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ResourceBundle;

/**
 * Created by thinkpad on 2016/11/25.
 */
public class uiHotelInfoController implements Initializable{

    private SceneJump sceneJump = new SceneJump();
    HotelinfoblService hotelInfobl = new HotelSalerController();
    LogBlService logBl = new LogController();

    /**
     * 星级label
     */
    @FXML
    private Label labelStarLevel;

    /**
     * 商圈label
     */
    @FXML
    private Label labelTradeArea;

    /**
     * 地址label
     */
    @FXML
    private Label labelAddress;

    /**
     * 详细地址label
     */
    @FXML
    private Label labelDetailAddress;

    /**
     * 电话label
     */
    @FXML
    private Label labelTelephoneNum;

    /**
     * 介绍label
     */
    @FXML
    private Label labelIntroduction;

    /**
     * 设施label
     */
    @FXML
    private  Label labelService;

    /**
     * 登出按钮
     */
    @FXML
    private Label labelExit;

    /**
     * 标题label
     */
    @FXML
    private Label labelTitle;

    /**
     * 编辑酒店信息label
     */
    @FXML
    private Label labelEdit;

    public uiHotelInfoController() throws RemoteException {
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
     * 鼠标移入编辑信息按钮监听
     */
    public void onEnteredLabelEdit(){
        labelEdit.setUnderline(true);
    }

    /**
     * 鼠标移出编辑信息按钮监听
     */
    public void onExitedLabelEdit(){
        labelEdit.setUnderline(false);
    }

    /**
     * 鼠标点击编辑信息按钮监听
     */
    public void onClickedLabelEdit() throws IOException{
        sceneJump.jumpToSceneEditInfo();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            HotelinfoVO vo = hotelInfobl.getHotelinfo();
            labelTitle.setText(vo.getHotelname());
            labelStarLevel.setText(String.valueOf(vo.getStar()));
            labelTradeArea.setText(UiFormatChanger.tradeAreaTOString(vo.getTradeArea()));
            labelAddress.setText(UiFormatChanger.addressTOString(vo.getAddress()));
            labelDetailAddress.setText(vo.getDetailAddress());
            labelTelephoneNum.setText(vo.getContactNumber());
            labelIntroduction.setText(vo.getIntroduction());
            labelService.setText(vo.getService());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}

package presentation.webmanagerui;

import businesslogic.logbl.LogController;
import businesslogic.webmanagerbl.WebmanagerController;
import enumData.Address;
import enumData.TradeArea;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import utility.UiFormatChanger;
import vo.HotelinfoVO;
import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ResourceBundle;

/**
 * Created by Administrator on 2016/11/30.
 */
public class uiChangeHSController implements Initializable {
    /**
     * 网站管理员界面控制器
     */
    WebmanagerController webmanagerController = new WebmanagerController();

    /**
     * 界面跳转的类
     */
    sceneJump jump = new sceneJump();

    /**
     * 用户管理按钮
     */
    @FXML
    Button buttonManageUser;

    /**
     * 酒店管理按钮
     */
    @FXML
    Button buttonManageHS;

    /**
     * 网站管理按钮
     */
    @FXML
    Button buttonManageWS;

    /**
     * 酒店名称文本
     */
    @FXML
    private TextField textHotelName;

    /**
     * 详细地址文本
     */
    @FXML
    private TextField textDetailAddress;

    /**
     * 地址选择框
     */
    @FXML
    private ComboBox textAddress;

    /**
     * 商圈选择框
     */
    @FXML
    private ComboBox textCircle;

    /**
     * 酒店星级输入框
     */
    @FXML
    private TextField textStar;

    /**
     * 酒店工作人员账号
     */
    @FXML
    private Text textHSAccount;

    /**
     * 酒店工作人员联系方式输入框
     */
    @FXML
    private TextField textHSNumber;

    /**
     * 酒店工作人员编号
     */
    @FXML
    private Text textHSID;

    /**
     * 商圈填充数据
     */
    public final ObservableList<String> circle = FXCollections.observableArrayList("长江", "黄河", "南海");

    /**
     * 长江商圈对应的地址填充数据
     */
    public final ObservableList<String> cjAddress = FXCollections.observableArrayList("上海", "南京");

    /**
     * 黄河商圈对应的地址填充数据
     */
    public final ObservableList<String> hhAddress = FXCollections.observableArrayList("北京", "天津");

    /**
     * 南海商圈对应的地址填充数据
     */
    public final ObservableList<String> nhAddress = FXCollections.observableArrayList("广东", "澳门");


    public uiChangeHSController() throws RemoteException {
    }

    /**
     * 跳转到用户管理界面
     *
     * @throws IOException
     */
    public void gotoManageUser() throws IOException {
        jump.gotoManageUser();
    }

    /**
     * 跳转到酒店管理界面
     *
     * @throws IOException
     */
    public void gotoManageHS() throws IOException {
        jump.gotoManageHS();
    }

    /**
     * 跳转到网站管理界面
     *
     * @throws IOException
     */
    public void gotoManageWS() throws IOException {
        jump.gotoManageWS();
    }

    /**
     * 返回酒店管理界面
     */
    @FXML
    Text textManageHS;

    public void returntoManageHS() throws IOException {
        jump.gotoManageHS();
    }

    /**
     * 点击登出，返回到登录界面并清空账号
     *
     * @throws IOException
     */
    public void LogOut() throws IOException {
        LogController logController = new LogController();
        logController.logOut();
        jump.gotoLogin();
    }

    /**
     * 点击保存，修改酒店数据
     *
     * @throws IOException
     */
    public void Save() throws IOException {
        HotelinfoVO oldvo = webmanagerController.getHotelinfo(jump.currentHSID);
        HotelinfoVO newvo = new HotelinfoVO(oldvo.getHotelID(), textHotelName.getText(), UiFormatChanger.getArea(textCircle), UiFormatChanger.getAddress(textAddress),
                textDetailAddress.getText(), textHSNumber.getText(), oldvo.getIntroduction(), oldvo.getService(), Integer.parseInt(textStar.getText()), oldvo.getGrade(), oldvo.getMinPrice());
        webmanagerController.setHotelinfo(newvo);
        jump.changeSuccess();
    }

    /**
     * 点击删除，删除酒店数据
     *
     * @throws IOException
     */
    public void Delete() throws IOException {
        webmanagerController.deleteHotelinfoAndAccount(textHSID.getText());
        jump.gotoManageHS();
        jump.deleteSuccess();

    }

    /**
     * 点击取消，清空数据
     *
     * @throws IOException
     */
    public void Cancel() throws IOException {
        init();
    }


    /**
     * 根据选择的商圈初始化地址
     */
    public void initAddress() {
        textAddress.setPromptText("");
        if (textCircle.getSelectionModel().getSelectedItem() == "长江") {
            textAddress.getItems().setAll(cjAddress);
        } else if (textCircle.getSelectionModel().getSelectedItem() == "黄河") {
            textAddress.getItems().setAll(hhAddress);
        } else if (textCircle.getSelectionModel().getSelectedItem() == "南海") {
            textAddress.getItems().setAll(nhAddress);
        }
    }

    /**
     * 初始化内容
     *
     * @throws IOException
     */
    public void init() throws RemoteException {

        HotelinfoVO currentHotel = webmanagerController.getHotelinfo(jump.currentHSID);
        textHotelName.setText(currentHotel.getHotelname());
        textHSAccount.setText(webmanagerController.getAccount(jump.currentHSID));
        textDetailAddress.setText(currentHotel.getDetailAddress());
        textStar.setText(String.valueOf(currentHotel.getStar()));
        textHSID.setText(currentHotel.getHotelID());
        textHSNumber.setText(currentHotel.getContactNumber());
        textCircle.getItems().setAll(circle);
        textCircle.setPromptText(UiFormatChanger.tradeAreaTOString(currentHotel.getTradeArea()));
        textAddress.setPromptText(UiFormatChanger.addressTOString(currentHotel.getAddress()));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            init();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }


}

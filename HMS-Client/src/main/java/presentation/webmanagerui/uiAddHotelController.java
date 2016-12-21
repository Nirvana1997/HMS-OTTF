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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import vo.HotelinfoVO;

import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ResourceBundle;

/**
 * Created by Administrator on 2016/11/30.
 */
public class uiAddHotelController implements Initializable {
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
     * 超链接返回酒店
     */
    @FXML
    Text textManageHS;


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
     * 星级输入框
     */
    @FXML
    private TextField textStar;

    /**
     * 账号输入框
     */
    @FXML
    private TextField textHSAccount;

    /**
     * 密码输入框
     */
    @FXML
    private PasswordField textHSPassword;

    /**
     * 联系方式输入框
     */
    @FXML
    private TextField textHSNumber;

    /**
     * 账号已存在警告信息
     */
    @FXML
    private Text warningAccount;

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
     *
     * @throws IOException
     */
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
     * 添加酒店
     *
     * @throws RemoteException
     */
    public void Save() throws IOException {
        HotelinfoVO vo = new HotelinfoVO(null, textHotelName.getText(), getArea(textCircle), getAddress(textAddress),
                textDetailAddress.getText(), textHSNumber.getText(), "", "", Integer.parseInt(textStar.getText()), 0, 0);
        WebmanagerController webmanagerController = new WebmanagerController();
        if (!webmanagerController.addHotelinfoAndAccount(vo, textHSAccount.getText(), textHSPassword.getText())) {
            warningAccount.setVisible(true);
        }else{
            jump.gotoManageHS();
            jump.addSuccess();
        }
    }

    /**
     * 点击账户名，取消账户名存在的警告
     *
     * @throws IOException
     */
    public void notWarningAccount() throws IOException {
        warningAccount.setVisible(false);
    }

    /**
     * 根据选择框内容确定商圈
     *
     * @param cb 选择框
     * @return
     */
    public TradeArea getArea(ComboBox cb) {
        if (cb.getSelectionModel().getSelectedItem() == "长江")
            return TradeArea.Changjiang;
        if (cb.getSelectionModel().getSelectedItem() == "黄河")
            return TradeArea.Huanghe;
        if (cb.getSelectionModel().getSelectedItem() == "南海")
            return TradeArea.Nanhai;
        return null;
    }

    /**
     * 根据选择框内容确定地址
     *
     * @param cb 选择框
     * @return
     */
    public Address getAddress(ComboBox cb) {
        if (cb.getSelectionModel().getSelectedItem() == "南京")
            return Address.Nanjing;
        if (cb.getSelectionModel().getSelectedItem() == "上海")
            return Address.Shanghai;
        if (cb.getSelectionModel().getSelectedItem() == "北京")
            return Address.Beijing;
        if (cb.getSelectionModel().getSelectedItem() == "天津")
            return Address.Tianjing;
        if (cb.getSelectionModel().getSelectedItem() == "广东")
            return Address.Guangdong;
        if (cb.getSelectionModel().getSelectedItem() == "澳门")
            return Address.Aomen;
        return null;
    }

    public final ObservableList<String> circle = FXCollections.observableArrayList("长江", "黄河", "南海");
    public final ObservableList<String> cjAddress = FXCollections.observableArrayList("上海", "南京");
    public final ObservableList<String> hhAddress = FXCollections.observableArrayList("北京", "天津");
    public final ObservableList<String> nhAddress = FXCollections.observableArrayList("广东", "澳门");

    /**
     * 根据选择的商圈初始化地址
     */
    public void initAddress() {
        if (textCircle.getSelectionModel().getSelectedItem() == "长江") {
            textAddress.getItems().setAll(cjAddress);
        } else if (textCircle.getSelectionModel().getSelectedItem() == "黄河") {
            textAddress.getItems().setAll(hhAddress);
        } else if (textCircle.getSelectionModel().getSelectedItem() == "南海") {
            textAddress.getItems().setAll(nhAddress);
        }
    }

    /**
     * 初始化商圈
     *
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        textCircle.getItems().addAll(circle);
    }
}

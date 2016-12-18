package presentation.webmanagerui;

import businesslogic.webmanagerbl.WebmanagerController;
import enumData.AccountType;
import enumData.Address;
import enumData.TradeArea;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import vo.AccountVO;
import vo.HotelinfoVO;

import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ResourceBundle;

/**
 * Created by Administrator on 2016/11/30.
 */
public class uiChangeHSController implements Initializable{
    WebmanagerController webmanagerController = new WebmanagerController();
    /**
     * 界面跳转的类
     */
    sceneJump jump = new sceneJump();
    @FXML
    /**
     * 用户管理按钮
     */
            Button buttonManageUser;
    @FXML
    /**
     * 酒店管理按钮
     */
            Button buttonManageHS;
    @FXML
    /**
     * 网站管理按钮
     */
            Button buttonManageWS;

    public uiChangeHSController() throws RemoteException {
    }

    /**
     * 跳转到用户管理界面
     * @throws IOException
     */
    public void gotoManageUser() throws IOException {
        jump.gotoManageUser();
    }
    /**
     * 跳转到酒店管理界面
     * @throws IOException
     */
    public void gotoManageHS() throws IOException{
        jump.gotoManageHS();
    }
    /**
     * 跳转到网站管理界面
     * @throws IOException
     */
    public void gotoManageWS() throws IOException{
        jump.gotoManageWS();
    }

    /**
     * 返回酒店管理界面
     */
    @FXML
    Text textManageHS;
    public void returntoManageHS()throws IOException{
        jump.gotoManageHS();
    }
    @FXML
    private Text buttonLogOut;
    /**
     * 点击登出，返回到登录界面并清空账号
     * @throws IOException
     */
    public void LogOut() throws IOException{
        //TODO 登出账号
        jump.gotoLogin();
    }
    @FXML
    private Text buttonModifyPassword;
    /**
     * 点击修改密码，跳出修改密码窗口
     * @throws IOException
     */
    public void gotoModifyPassword() throws IOException{
        jump.gotoModifyPassword();
    }

    @FXML
    private Button buttonSave;
    /**
     * 点击保存，修改酒店数据
     * @throws IOException
     */
    public void Save() throws IOException{
        HotelinfoVO oldvo = webmanagerController.getHotelinfo(jump.currentHSID);
        HotelinfoVO newvo = new HotelinfoVO(oldvo.getHotelID(),textHotelName.getText(),getArea(textCircle),getAddress(textAddress),
                textDetailAddress.getText(),textHSNumber.getText(),oldvo.getIntroduction(),oldvo.getService(),Integer.parseInt(textStar.getText()),oldvo.getGrade(),oldvo.getMinPrice());
        webmanagerController.setHotelinfo(newvo);
    }
    @FXML
    private Button buttonDelete;

    /**
     * 点击删除，删除酒店数据
     * @throws IOException
     */
    public void Delete() throws IOException{
        webmanagerController.deleteHotelinfoAndAccount(textHSID.getText());
        jump.gotoManageHS();
        jump.deleteSuccess();

    }
    @FXML
    private Button buttonCancel;

    /**
     * 点击取消，清空数据
     * @throws IOException
     */
    public void Cancel() throws IOException{
        init();
    }

    @FXML
    private TextField textHotelName;
    @FXML
    private TextField textDetailAddress;
    @FXML
    private ComboBox textAddress;
    @FXML
    private ComboBox textCircle;
    @FXML
    private Text textHSID;
    @FXML
    private Text textHSAccount;
    @FXML
    private TextField textHSNumber;
    @FXML
    private TextField textStar;
    /**
     * 根据选择框内容确定商圈
     * @param cb 选择框
     * @return
     */
    public TradeArea getArea(ComboBox cb){
        if(cb.getSelectionModel().getSelectedItem()=="长江")
            return TradeArea.Changjiang;
        if(cb.getSelectionModel().getSelectedItem()=="黄河")
            return TradeArea.Huanghe;
        if(cb.getSelectionModel().getSelectedItem()=="南海")
            return TradeArea.Nanhai;
        return null;
    }
    /**
     * 根据选择框内容确定地址
     * @param cb 选择框
     * @return
     */
    public Address getAddress(ComboBox cb){
        if(cb.getSelectionModel().getSelectedItem()=="南京")
            return Address.Nanjing;
        if(cb.getSelectionModel().getSelectedItem()=="上海")
            return Address.Shanghai;
        if(cb.getSelectionModel().getSelectedItem()=="北京")
            return Address.Beijing;
        if(cb.getSelectionModel().getSelectedItem()=="天津")
            return Address.Tianjing;
        if(cb.getSelectionModel().getSelectedItem()=="广东")
            return Address.Guangdong;
        if(cb.getSelectionModel().getSelectedItem()=="澳门")
            return Address.Aomen;
        return null;
    }

    public final ObservableList<String> circle = FXCollections.observableArrayList("长江","黄河","南海");
    public final ObservableList<String> cjAddress = FXCollections.observableArrayList("上海","南京");
    public final ObservableList<String> hhAddress = FXCollections.observableArrayList("北京","天津");
    public final ObservableList<String> nhAddress = FXCollections.observableArrayList("广东","澳门");

    /**
     * 根据选择的商圈初始化地址
     */
    public void initAddress(){
        textAddress.setPromptText("");
        if(textCircle.getSelectionModel().getSelectedItem()=="长江"){
            textAddress.getItems().setAll(cjAddress);
        }
        else if(textCircle.getSelectionModel().getSelectedItem()=="黄河"){
            textAddress.getItems().setAll(hhAddress);
        }
        else if(textCircle.getSelectionModel().getSelectedItem()=="南海"){
            textAddress.getItems().setAll(nhAddress);
        }
    }
    /**
     * 初始化内容
     * @throws IOException
     */
    public void init() throws RemoteException {

        HotelinfoVO currentHotel = webmanagerController.getHotelinfo(jump.currentHSID);
        textHotelName.setText(currentHotel.getHotelname());
        textHSAccount.setText(webmanagerController.getAccount(jump.currentHSID));
        textDetailAddress.setText(currentHotel.getDetailAddress());
        textStar.setText(String.valueOf(currentHotel.getStar()));
        textHSID.setText(currentHotel.getHotelID());
        //TODO 账号
        textHSNumber.setText(currentHotel.getContactNumber());
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

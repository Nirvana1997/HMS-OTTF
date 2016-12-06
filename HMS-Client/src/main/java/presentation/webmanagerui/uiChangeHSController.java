package presentation.webmanagerui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Administrator on 2016/11/30.
 */
public class uiChangeHSController implements Initializable{
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
        //TODO
    }
    @FXML
    private Button buttonDelete;

    /**
     * 点击删除，删除酒店数据
     * @throws IOException
     */
    public void Delete() throws IOException{
        //TODO
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
    private TextField texttextHSNumber;
    /**
     * 初始化内容
     * @throws IOException
     */
    public void init() throws IOException{
        textHotelName.setText("刷新！duang！" );
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


}

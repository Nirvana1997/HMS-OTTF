package presentation.webmanagerui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import javax.naming.spi.InitialContextFactory;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Administrator on 2016/12/1.
 */
public class uiChangeWSController implements Initializable{
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
     * 返回网站管理界面
     */
    @FXML
    Text textManageWS;
    public void returntoManageWS()throws IOException{
        jump.gotoManageWS();
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
    private Text textWSID;
    @FXML
    private TextField textWSAccount;
    @FXML
    private TextField textWSNumber;
    /**
     * 初始化内容
     * @throws IOException
     */
    public void init(){

        textWSID.setText(uiManageHSController.getHotelID());
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        init();
    }
}

package presentation.webmanagerui;

import businesslogic.webmanagerbl.WebmanagerController;
import businesslogicservice.webmanagerlogicservice.WSmanagementBlService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import vo.WebsalerInfoVO;

import java.io.IOException;

/**
 * Created by Administrator on 2016/12/1.
 */
public class uiAddWSController {
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
    private TextField textWSAccount;
    @FXML
    private TextField textWSPassword;
    @FXML
    private TextField textWSNumber;
    @FXML
    private Button buttonSave;
    @FXML
    private Button buttonCancel;
    @FXML
    private Text warningAccount;

    /**
     * 注册网站管理人员账号
     * @throws IOException
     */
    public void Save() throws IOException{
        WebmanagerController webmanagerController = new WebmanagerController();
        WebsalerInfoVO addVo = new WebsalerInfoVO(textWSNumber.getText());
        if(!webmanagerController.addWebsalerInfoAndAccount(addVo,textWSAccount.getText(),textWSPassword.getText())){
            warningAccount.setVisible(true);
        }
    }

    /**
     * 点击账户名，取消账户名存在的警告
     * @throws IOException
     */
    public void notWarningAccount()throws IOException{
        warningAccount.setVisible(false);
    }

}

package presentation.webmanagerui;

import businesslogic.logbl.LogController;
import businesslogic.webmanagerbl.WebmanagerController;
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
     * 返回网站管理界面
     */
    @FXML
    Text textManageWS;

    /**
     * 账号输入框
     */
    @FXML
    private TextField textWSAccount;

    /**
     * 密码输入框
     */
    @FXML
    private TextField textWSPassword;

    /**
     * 联系方式输入框
     */
    @FXML
    private TextField textWSNumber;

    /**
     * 账号已存在的警告
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
     * 返回到网站管理界面
     *
     * @throws IOException
     */
    public void returntoManageWS() throws IOException {
        jump.gotoManageWS();
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
     * 注册网站管理人员账号
     *
     * @throws IOException
     */
    public void Save() throws IOException {
        WebmanagerController webmanagerController = new WebmanagerController();
        WebsalerInfoVO addVo = new WebsalerInfoVO(textWSNumber.getText());
        if (!webmanagerController.addWebsalerInfoAndAccount(addVo, textWSAccount.getText(), textWSPassword.getText())) {
            warningAccount.setVisible(true);
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

}

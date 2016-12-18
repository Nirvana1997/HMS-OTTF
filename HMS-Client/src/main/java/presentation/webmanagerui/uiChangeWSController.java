package presentation.webmanagerui;

import businesslogic.logbl.LogController;
import businesslogic.webmanagerbl.WebmanagerController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import vo.WebsalerInfoVO;
import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ResourceBundle;

/**
 * Created by Administrator on 2016/12/1.
 */
public class uiChangeWSController implements Initializable {
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
     * 网站营销人员编号
     */
    @FXML
    private Text textWSID;

    /**
     * 网站营销人员账号
     */
    @FXML
    private Text textWSAccount;

    /**
     * 网站营销人员联系方式
     */
    @FXML
    private TextField textWSNumber;

    /**
     * 返回网站管理界面
     */
    @FXML
    Text textManageWS;

    public uiChangeWSController() throws RemoteException {
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
     * 返回网站管理界面
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
     * 修改网站营销人员信息
     *
     * @throws RemoteException
     */
    public void Save() throws RemoteException {
        WebsalerInfoVO vo = webmanagerController.getWebsalerInfo(jump.currentWSID);
        vo.setContactNumber(textWSNumber.getText());
    }

    /**
     * 删除网站营销人员信息
     *
     * @throws IOException
     */
    public void Delete() throws IOException {
        webmanagerController.deleteWebsalerInfoAndAccount(jump.currentWSID);
        jump.gotoManageWS();
        jump.deleteSuccess();

    }


    /**
     * 初始化网站营销人员信息
     *
     * @throws IOException
     */
    public void init() throws RemoteException {
        WebsalerInfoVO vo = webmanagerController.getWebsalerInfo(jump.currentWSID);
        textWSID.setText(vo.getWebsalerID());
        textWSAccount.setText(webmanagerController.getAccount(vo.getWebsalerID()));
        textWSNumber.setText(vo.getContactNumber());
    }

    /**
     * 初始化
     *
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            init();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}

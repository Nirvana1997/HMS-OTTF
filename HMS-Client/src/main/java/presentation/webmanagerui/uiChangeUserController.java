package presentation.webmanagerui;

import businesslogic.logbl.LogController;
import businesslogic.webmanagerbl.WebmanagerController;
import enumData.UserType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import vo.UserInfoVO;
import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ResourceBundle;

/**
 * Created by Administrator on 2016/11/30.
 */
public class uiChangeUserController implements Initializable {
    /**
     * 用户编号
     */
    @FXML
    private Text textUserID;

    /**
     * 用户账号
     */
    @FXML
    private Text textUserAccount;

    /**
     * 用户信用
     */
    @FXML
    private Text textCredit;

    /**
     * 用户真实姓名
     */
    @FXML
    private TextField textRealName;

    /**
     * 用户联系方式
     */
    @FXML
    private TextField textPhoneNumber;

    /**
     * 用户类型组合
     */
    @FXML
    private ToggleGroup userType;

    /**
     * 个人用户选择框
     */
    @FXML
    private RadioButton typePersonal;

    /**
     * 企业用户选择框
     */
    @FXML
    private RadioButton typeEnterprise;

    /**
     * 生日日期选择器
     */
    @FXML
    private DatePicker dateBirthday;

    /**
     * 企业编号输入框
     */
    @FXML
    private TextField nameEnterprise;

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
     * 返回用户管理界面
     */
    @FXML
    Text textManageUser;
    public uiChangeUserController() throws RemoteException {
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
     * 前往用户管理界面
     * @throws IOException
     */
    public void returntoManageUser() throws IOException {
        jump.gotoManageUser();
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
     * 修改用户信息
     *
     * @throws IOException
     */
    public void SaveUser() throws IOException {
        UserInfoVO vo = webmanagerController.getUserInfo(jump.currentUserID);
        vo.setName(textRealName.getText());
        vo.setContactNumber(textPhoneNumber.getText());
        if (userType.getSelectedToggle() == typePersonal) {
            vo.setUserType(UserType.Person);
            vo.setBirthday(dateBirthday.getPromptText());
            vo.setCompanyID("");
        } else {
            vo.setUserType(UserType.Company);
            vo.setBirthday("");
            vo.setCompanyID(nameEnterprise.getText());
        }
        webmanagerController.setUserInfo(vo);
        jump.changeSuccess();
    }

    /**
     * 取消修改，显示原界面
     *
     * @throws RemoteException
     */
    public void Cancel() throws RemoteException {
        init();
    }

    /**
     * 初始化用户信息
     *
     * @throws IOException
     */

    public void init() throws RemoteException {
        UserInfoVO vo = webmanagerController.getUserInfo(jump.currentUserID);
        textUserID.setText(vo.getUserID());
        textUserAccount.setText(webmanagerController.getAccount(vo.getUserID()));
        textRealName.setText(vo.getName());
        textPhoneNumber.setText(vo.getContactNumber());
        textCredit.setText(String.valueOf(vo.getCredit()));
        if (vo.getUserType() == UserType.Person) {
            typePersonal.setSelected(true);
            dateBirthday.setPromptText(vo.getBirthday());
            nameEnterprise.setText("");
        } else {
            typeEnterprise.setSelected(true);
            nameEnterprise.setText(vo.getCompanyID());
            dateBirthday.setPromptText("");
        }
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

package presentation.webmanagerui;

import businesslogic.logbl.LogController;
import businesslogic.webmanagerbl.WebmanagerController;
import enumData.UserType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import sun.awt.TimedWindowEvent;
import vo.UserInfoVO;

import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ResourceBundle;

/**
 * Created by Administrator on 2016/11/30.
 */
public class uiChangeUserController implements Initializable{

    @FXML
    private Text textUserID;
    @FXML
    private Text textUserAccount;
    @FXML
    private Text textCredit;
    @FXML
    private TextField textRealName;
    @FXML
    private TextField textPhoneNumber;
    @FXML
    private ToggleGroup userType;
    @FXML
    private RadioButton typePersonal;
    @FXML
    private RadioButton typeEnterprise;
    @FXML
    private DatePicker dateBirthday;
    @FXML
    private TextField nameEnterprise;
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
     * 返回用户管理界面
     */
    @FXML
    Text textManageUser;
    public void returntoManageUser() throws IOException{
        jump.gotoManageUser();
    }


    @FXML
    private Text buttonLogOut;
    /**
     * 点击登出，返回到登录界面并清空账号
     * @throws IOException
     */
    public void LogOut() throws IOException{
        LogController logController = new LogController();
        logController.logOut();
        jump.gotoLogin();
    }

    @FXML
    private Button buttonSave;

    /**
     * 修改用户信息
     * @throws IOException
     */
    public void SaveUser() throws IOException{
        WebmanagerController webmanagerController = new WebmanagerController();
        UserInfoVO vo = webmanagerController.getUserInfo(jump.currentUserID);
        vo.setName(textRealName.getText());
        vo.setContactNumber(textPhoneNumber.getText());
        if(userType.getSelectedToggle()==typePersonal){
            vo.setUserType(UserType.Person);
            vo.setBirthday(dateBirthday.getPromptText());
            vo.setCompanyID("");
        }
        else{
            vo.setUserType(UserType.Company);
            vo.setBirthday("");
            vo.setCompanyID(nameEnterprise.getText());
        }
        webmanagerController.setUserInfo(vo);
    }

    public void Cancel() throws RemoteException {
        init();
    }

    /**
     * 初始化内容
     * @throws IOException
     */

    public void init() throws RemoteException {
        WebmanagerController webmanagerController = new WebmanagerController();
        UserInfoVO vo = webmanagerController.getUserInfo(jump.currentUserID);
        textUserID.setText(vo.getUserID());
        textUserAccount.setText(webmanagerController.getAccount(vo.getUserID()));
        textRealName.setText(vo.getName());
        textPhoneNumber.setText(vo.getContactNumber());
        textCredit.setText(String.valueOf(vo.getCredit()));
        if(vo.getUserType()== UserType.Person){
            typePersonal.setSelected(true);
            dateBirthday.setPromptText(vo.getBirthday());
            nameEnterprise.setText("");
        }
        else{
            typeEnterprise.setSelected(true);
            nameEnterprise.setText(vo.getCompanyID());
            dateBirthday.setPromptText("");
        }
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

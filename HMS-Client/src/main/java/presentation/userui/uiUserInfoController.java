package presentation.userui;

import businesslogic.logbl.LogController;
import businesslogic.userbl.UserController;
import businesslogicservice.logblservice.LogBlService;
import businesslogicservice.userblservice.InfoBlService;
import enumData.ResultMessage;
import enumData.UserType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import presentation.logui.uiRegister1Controller;
import vo.PasswordComfirmVO;
import vo.UserInfoVO;

import javax.naming.InitialContext;
import javax.sound.midi.MidiDevice;
import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ResourceBundle;

/**
 * Created by Administrator on 2016/12/3.
 */
public class uiUserInfoController implements Initializable {
    @FXML
    /**
     * 跳转到首页的按钮
     */
    private Button buttonHomePage;
    @FXML
    /**
     * 跳转到我的订单的按钮
     */
    private Button buttonMyOrder;
    @FXML
    /**
     * 跳转到浏览酒店的按钮
     */
    private Button buttonReadHotel;
    @FXML
    /**
     * 跳转到搜索酒店的按钮
     */
    private Button buttonSearchHotel;
    @FXML
    /**
     * 跳转到个人信息的按钮
     */
    private Button buttonUserInfo;
    @FXML
    /**
     * 登出按钮
     */
    private Label buttonLogOut;

    /**
     * 搜索按钮
     */
    @FXML
    private Button buttonSearch;

    /**
     * 跳转界面的类
     */
    sceneJump jump = new sceneJump();

    /**
     * 跳转到首页
     * @throws IOException
     */
    public void gotoHomePage() throws IOException {
        jump.gotoHomePage();
    }

    /**
     * 跳转到我的订单
     * @throws IOException
     */
    public void gotoMyOrder() throws IOException{
        jump.gotoMyOrder();
    }

    /**
     * 跳转到浏览酒店
     * @throws IOException
     */
    public void gotoReadHotel() throws IOException{
        jump.gotoReadHotel();
    }

    /**
     * 跳转到搜索酒店
     * @throws IOException
     */
    public void gotoSearchHotel() throws IOException{
        jump.gotoSearchHotel();
    }

    /**
     * 跳转到个人信息
     * @throws IOException
     */
    public void gotoUserInfo() throws IOException{
        jump.gotoUserInfo();
    }

    /**
     * 清空账号信息，并跳转回登录界面
     * @throws IOException
     */
    public void LogOut() throws IOException{
        LogController logController = new LogController();
        logController.logOut();
        jump.gotoLogin();
    }
    @FXML
    private Text textUserID;
    @FXML
    private TextField textRealName;
    @FXML
    private TextField textPhoneNumber;
    @FXML
    private Text textIdentity;
    @FXML
    private Text textCredit;
    @FXML
    private Text textVIPLevel;

    String Birthday;
    String CompanyID;
    UserType userType;

    @FXML
    private Button buttonSave;

    /**
     * 修改账号信息
     * @throws IOException
     */
    public void Save() throws IOException {
        String UserID = textUserID.getText();
        String RealName = textRealName.getText();
        String PhoneNumber = textPhoneNumber.getText();
        int VIPLevel = Integer.parseInt(textVIPLevel.getText());
        int Credit = Integer.parseInt(textCredit.getText());
        String Identity = textIdentity.getText();
        UserInfoVO vo = new UserInfoVO(UserID, RealName, Identity,PhoneNumber,Credit,Birthday,CompanyID,userType,VIPLevel);
        InfoBlService infoBlService = new UserController() ;
        infoBlService.modifyUserInfo(vo);
        jump.ModifySuccess();
    }

    /**
     * 初始化用户信息
     * @throws RemoteException
     */
    public void init() throws RemoteException {
        InfoBlService infoBlService = new UserController();
        UserInfoVO vo = infoBlService.showUserInfo();
        textUserID.setText(vo.getUserID());
        textCredit.setText(String.valueOf(vo.getCredit()));
        textIdentity.setText(vo.getIdentity());
        textPhoneNumber.setText(vo.getContactNumber());
        textRealName.setText(vo.getName());
        Birthday = vo.getBirthday();
        CompanyID = vo.getCompanyID();
        userType = vo.getUserType();

    }

    public void Cancel() throws  IOException{
        init();
    }
    public void gotoModifyPassword() throws IOException{
        jump.gotoModifyPassword();
    }
    @FXML
    private Text gotoCreditHistory;
    public void gotoCreditHistory() throws IOException{
        jump.gotoCreditHistory();
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

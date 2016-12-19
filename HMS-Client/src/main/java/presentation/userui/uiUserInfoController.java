package presentation.userui;

import businesslogic.logbl.LogController;
import businesslogic.userbl.UserController;
import businesslogicservice.userblservice.InfoBlService;
import enumData.UserType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import vo.UserInfoVO;
import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ResourceBundle;

/**
 * Created by Administrator on 2016/12/3.
 */
public class uiUserInfoController implements Initializable {
    /**
     * 用户ID
     */
    @FXML
    private Text textUserID;

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
     * 用户身份证
     */
    @FXML
    private Text textIdentity;

    /**
     * 用户信用
     */
    @FXML
    private Text textCredit;

    /**
     * 用户VIP等级
     */
    @FXML
    private Text textVIPLevel;

    /**
     * 当前用户的生日（暂存，不显示）
     */
    String Birthday;

    /**
     * 当前用户的企业ID（暂存，不显示）
     */
    String CompanyID;

    /**
     * 当前用户的用户类型（暂存，不显示）
     */
    UserType userType;


    /**
     * 跳转界面的类
     */
    sceneJump jump = new sceneJump();

    /**
     * 跳转到首页
     *
     * @throws IOException
     */
    public void gotoHomePage() throws IOException {
        jump.gotoHomePage();
    }

    /**
     * 跳转到我的订单
     *
     * @throws IOException
     */
    public void gotoMyOrder() throws IOException {
        jump.gotoMyOrder();
    }

    /**
     * 跳转到浏览酒店
     *
     * @throws IOException
     */
    public void gotoReadHotel() throws IOException {
        jump.gotoReadHotel();
    }

    /**
     * 跳转到搜索酒店
     *
     * @throws IOException
     */
    public void gotoSearchHotel() throws IOException {
        jump.gotoSearchHotel();
    }

    /**
     * 跳转到个人信息
     *
     * @throws IOException
     */
    public void gotoUserInfo() throws IOException {
        jump.gotoUserInfo();
    }

    /**
     * 清空账号信息，并跳转回登录界面
     *
     * @throws IOException
     */
    public void LogOut() throws IOException {
        LogController logController = new LogController();
        logController.logOut();
        jump.gotoLogin();
    }


    /**
     * 修改账号信息
     *
     * @throws IOException
     */
    public void Save() throws IOException {
        String UserID = textUserID.getText();
        String RealName = textRealName.getText();
        String PhoneNumber = textPhoneNumber.getText();
        int VIPLevel = Integer.parseInt(textVIPLevel.getText());
        int Credit = Integer.parseInt(textCredit.getText());
        String Identity = textIdentity.getText();
        UserInfoVO vo = new UserInfoVO(UserID, RealName, Identity, PhoneNumber, Credit, Birthday, CompanyID, userType, VIPLevel);
        InfoBlService infoBlService = new UserController();
        infoBlService.modifyUserInfo(vo);
        jump.ModifySuccess();
    }

    /**
     * 初始化用户信息
     *
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

    /**
     * 取消（回到最初界面）
     *
     * @throws IOException
     */
    public void Cancel() throws IOException {
        init();
    }

    /**
     * 跳转到修改密码界面
     *
     * @throws IOException
     */
    public void gotoModifyPassword() throws IOException {
        jump.gotoModifyPassword();
    }

    /**
     * 跳转到信用变化记录界面
     *
     * @throws IOException
     */
    public void gotoCreditHistory() throws IOException {
        jump.gotoCreditHistory();
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

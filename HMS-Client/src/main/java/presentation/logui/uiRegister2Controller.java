package presentation.logui;

import businesslogic.logbl.LogController;
import businesslogic.userbl.UserController;
import businesslogicservice.logblservice.LogBlService;
import com.sun.javafx.robot.impl.FXRobotHelper;
import com.sun.org.apache.regexp.internal.RE;
import enumData.UserType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import utility.UiFormatChanger;
import vo.UserInfoVO;

import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.time.chrono.Chronology;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by Administrator on 2016/11/25.
 */
public class uiRegister2Controller implements Initializable{
    LogBlService logBlService = new LogController();
    @FXML
    public Button buttonFinish;
    @FXML
    public TextField textRealName;
    @FXML
    public TextField textIdentity;
    @FXML
    public TextField textPhoneNumber;
    @FXML
    public ToggleGroup UserType;
    @FXML
    public RadioButton typePersonal;
    @FXML
    public RadioButton typeEnterprise;
    @FXML
    public DatePicker dateBirthday;
    @FXML
    public TextField textCompany;
    @FXML
    private ComboBox<String> comboCompany;
    @FXML
    private Text wrongCompany;
    public uiRegister2Controller() throws RemoteException {
    }

    /**
     * 将账号信息存储，并跳转到登录界面3
     * @throws IOException
     */
    public void gotoRegister3() throws IOException, ParseException {

        String RealName = textRealName.getText();
        String Identity = textIdentity.getText();
        String PhoneNumber = textPhoneNumber.getText();
        boolean isPersonal = typePersonal.isSelected();
        boolean isEnterprise = typeEnterprise.isSelected();
        enumData.UserType userType;
        String Birthday = "";
        String CompanyID = "";
        String Company = "";
        if(isPersonal){
            userType = enumData.UserType.Person;
            Birthday = UiFormatChanger.dateToString(UiFormatChanger.getDate(dateBirthday));
            UserInfoVO userInfoVO = new UserInfoVO(uiRegister1Controller.getUserID(), RealName, Identity, PhoneNumber, 0, Birthday, CompanyID, userType, 0);
            logBlService.addUserInfo(userInfoVO);
            ObservableList<Stage> stage = FXRobotHelper.getStages();
            Scene scene = new Scene((Parent) FXMLLoader.load(getClass().getResource("sceneRegister3.fxml")));
            stage.get(0).setScene(scene);
        }
        else if(isEnterprise){
            userType = enumData.UserType.Company;
            CompanyID = textCompany.getText();
            Company = comboCompany.getSelectionModel().getSelectedItem();
            //如果企业名称与ID匹配的话
            if(logBlService.isCompanyIDCorrect(CompanyID,Company)) {
                UserInfoVO userInfoVO = new UserInfoVO(uiRegister1Controller.getUserID(), RealName, Identity, PhoneNumber, 0, Birthday, CompanyID, userType, 0);
                logBlService.addUserInfo(userInfoVO);
                ObservableList<Stage> stage = FXRobotHelper.getStages();
                Scene scene = new Scene((Parent) FXMLLoader.load(getClass().getResource("sceneRegister3.fxml")));
                stage.get(0).setScene(scene);
            }
            //如果不匹配，显示警告
            else{
                wrongCompany.setVisible(true);
            }
        }
        else{
            userType = null;
        }

    }

    /**
     * 点击企业ID输入框，警告消失
     */
    public void notwrongCompany(){
        wrongCompany.setVisible(false);
    }
    /**
     * 企业选择框的填充数据
     */
    public final ObservableList<String> company = FXCollections.observableArrayList();

    /**
     * 初始化企业选择框
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ArrayList<String> companylist = null;
        try {
            companylist = logBlService.showAllCompanys();
        } catch (RemoteException e) {
            e.printStackTrace();
         }
        System.out.println(companylist.get(0));
        for(int i = 0; i< companylist.size();i++){
            company.add(companylist.get(i));
        }
        comboCompany.getItems().addAll(company);
    }
}

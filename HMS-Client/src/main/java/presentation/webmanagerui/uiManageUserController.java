package presentation.webmanagerui;

import businesslogic.webmanagerbl.URmanagement;
import businesslogic.webmanagerbl.UserDataManagement;
import businesslogic.webmanagerbl.WebmanagerController;
import businesslogicservice.webmanagerlogicservice.URmanagementBlService;
import com.sun.javafx.robot.impl.FXRobotHelper;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import vo.UserAccountVO;
import vo.UserInfoVO;

import javax.jws.soap.SOAPBinding;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by Administrator on 2016/11/30.
 */
public class uiManageUserController implements Initializable{
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
     * 点击按钮跳转到相应的修改用户信息界面
     */
    @FXML
    private Button buttonChange;
    public void gotoChangeUser() throws IOException {
        setUserID(userList.getSelectionModel().getSelectedItem().getuserID());
        jump.gotoChangeUser();
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
    private TableView<tableUser> userList;
    @FXML
    private TableColumn<tableUser,String> columnID;
    @FXML
    private TableColumn<tableUser,String> columnName;
    @FXML
    private TableColumn<tableUser,String> columnNumber;

    private ObservableList<tableUser> personData = FXCollections.observableArrayList();

    /**
     * 初始化：获取用户列表，并显示
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        URmanagementBlService uRmanagementBlService = new WebmanagerController();
//        ArrayList<UserInfoVO> list = uRmanagementBlService.getUserList();
//        for(int i = 0; i < list.size();i++){
//            personData.add(new tableUser(list.get(i).getUserID(), list.get(i).getName(), list.get(i).getContactNumber()));
//        }
        personData.add(new tableUser("151250045","gmd","15105180105"));
        personData.add(new tableUser("151250042","gmd2","15105180102"));
        userList.setItems(personData);
        columnID.setCellValueFactory(cellData -> cellData.getValue().userIDProperty());
        columnName.setCellValueFactory(cellData -> cellData.getValue().userNameProperty());
        columnNumber.setCellValueFactory(cellData -> cellData.getValue().userNumberProperty());
//        userList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
//        userList.getSelectionModel().getSelectedItem().getuserID();
    }
    static String currentUserID;
    public void setUserID(String uid){ currentUserID = uid;}
    public static String getUserID(){ return currentUserID;}
}

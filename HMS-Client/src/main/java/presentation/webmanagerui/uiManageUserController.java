package presentation.webmanagerui;

import businesslogic.logbl.LogController;
import businesslogic.webmanagerbl.WebmanagerController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import vo.UserInfoVO;
import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by Administrator on 2016/11/30.
 */
public class uiManageUserController implements Initializable {
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
     * 搜索输入框
     */
    @FXML
    private TextField textSearch;

    /**
     * 用户信息列表
     */
    @FXML
    private TableView<tableMember> userList;

    /**
     * 用户编号列
     */
    @FXML
    private TableColumn<tableMember, String> columnID;

    /**
     * 用户姓名列
     */
    @FXML
    private TableColumn<tableMember, String> columnName;

    /**
     * 联系方式列
     */
    @FXML
    private TableColumn<tableMember, String> columnNumber;

    /**
     * 用户列表填充数据
     */
    private ObservableList<tableMember> personData = FXCollections.observableArrayList();

    public uiManageUserController() throws RemoteException {
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
     * 点击按钮跳转到相应的修改用户信息界面
     *
     * @throws IOException
     */
    public void gotoChangeUser() throws IOException {
        //检验是否选中
        for (int i = 0; i < personData.size(); i++) {
            setChoose(false);
            if (userList.getSelectionModel().isSelected(i)) {
                setChoose(true);
                break;
            }
        }
        //如果有，则跳转
        if (choose) {
            jump.setCurrentUserID(userList.getSelectionModel().getSelectedItem().getID());
            jump.gotoChangeUser();
        }
        //如果没有，跳出提示框
        else {
            setChoose(false);
            jump.warning();
        }
    }


    /**
     * 根据ID搜索并跳转
     *
     * @throws IOException
     */
    public void SearchUR() throws IOException {

        jump.setCurrentUserID(textSearch.getText());
        jump.gotoChangeUser();
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
     * 初始化：获取用户列表，并显示
     *
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            ArrayList<UserInfoVO> list = webmanagerController.getUserList();
            for (int i = 0; i < list.size(); i++) {
                personData.add(new tableMember(list.get(i).getUserID(), list.get(i).getName(), list.get(i).getContactNumber()));
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        userList.setItems(personData);
        columnID.setCellValueFactory(cellData -> cellData.getValue().IDProperty());
        columnName.setCellValueFactory(cellData -> cellData.getValue().NameProperty());
        columnNumber.setCellValueFactory(cellData -> cellData.getValue().NumberProperty());
    }

    /**
     * 当前选择的用户ID
     */
    static String currentUserID;

    public void setUserID(String uid) {
        currentUserID = uid;
    }

    public static String getUserID() {
        return currentUserID;
    }

    /**
     * 是否选择用户
     */
    static boolean choose;

    public void setChoose(boolean is) {
        choose = is;
    }

    public static boolean getChoose() {
        return choose;
    }
}

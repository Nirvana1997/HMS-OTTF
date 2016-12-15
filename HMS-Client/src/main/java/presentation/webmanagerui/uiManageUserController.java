package presentation.webmanagerui;

import businesslogic.webmanagerbl.WebmanagerController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import vo.UserInfoVO;

import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
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
        //检验是否选中
        for(int i = 0; i < personData.size();i++){
            setChoose(false);
            if(userList.getSelectionModel().isSelected(i)){
                setChoose(true);
                break;
            }
        }
        //如果有，则跳转
        if(choose) {
            jump.setCurrentUserID(userList.getSelectionModel().getSelectedItem().getID());
            System.out.println(jump.currentUserID);
            jump.gotoChangeUser();
        }
        //如果没有，跳出提示框
        else{
            setChoose(false);
            jump.warning();
        }
    }
    @FXML
    private TextField textSearch;
    @FXML
    private ImageView searchUR;
    /**
     * 根据ID搜索并跳转
     * @throws IOException
     */
    public void SearchUR() throws IOException{
        //TODO 判断ID是否存在
        jump.setCurrentUserID(textSearch.getText());
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
    private TableView<tableMember> userList;
    @FXML
    private TableColumn<tableMember,String> columnID;
    @FXML
    private TableColumn<tableMember,String> columnName;
    @FXML
    private TableColumn<tableMember,String> columnNumber;

    private ObservableList<tableMember> personData = FXCollections.observableArrayList();

    /**
     * 初始化：获取用户列表，并显示
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            WebmanagerController webmanagerController = new WebmanagerController();
            ArrayList<UserInfoVO> list = webmanagerController.getUserList();
            for(int i = 0; i < list.size();i++){
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
    static String currentUserID;
    public void setUserID(String uid){ currentUserID = uid;}
    public static String getUserID(){ return currentUserID;}
    static boolean choose;
    public void setChoose(boolean is){ choose = is;}
    public static boolean getChoose(){ return choose;}
}

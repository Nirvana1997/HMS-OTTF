package presentation.webmanagerui;

import businesslogic.logbl.LogController;
import businesslogic.webmanagerbl.WebmanagerController;
import com.sun.javafx.robot.impl.FXRobotHelper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import vo.UserInfoVO;
import vo.WebsalerInfoVO;

import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by Administrator on 2016/11/30.
 */
public class uiManageWSController implements Initializable{
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
     * 添加网管按钮
     */
    @FXML
    Button buttonAddWS;

    /**
     * 点击ADD按钮跳转到增加网管界面
     * @throws IOException
     */
    public void gotoAddWS() throws IOException{
        jump.gotoAddWS();
    }
    /**
     * 点击按钮跳转到相应的修改网管信息界面
     */
    @FXML
    private Button buttonChange;
    public void gotoChangeWS() throws IOException{
        //检验是否选中
        for(int i = 0; i < personData.size();i++){
            setChoose(false);
            if(websalerList.getSelectionModel().isSelected(i)){
                setChoose(true);
                break;
            }
        }
        //如果有，则跳转
        if(choose) {
            jump.setCurrentWSID(websalerList.getSelectionModel().getSelectedItem().getID());
            jump.gotoChangeWS();
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
    private ImageView searchWS;
    /**
     * 根据ID搜索并跳转
     * @throws IOException
     */
    public void SearchWS() throws IOException{
        //TODO 判断ID是否存在
        setWebsalerID(textSearch.getText());
        jump.gotoChangeWS();
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
    private TableView<tableMember> websalerList;
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
        WebmanagerController webmanagerController = null;
        try {
            webmanagerController = new WebmanagerController();
            ArrayList<WebsalerInfoVO> list = webmanagerController.getWebsalerInfoList();

            for(int i = 0; i < list.size();i++){
                personData.add(new tableMember(list.get(i).getWebsalerID(), webmanagerController.getAccount(list.get(i).getWebsalerID()), list.get(i).getContactNumber()));
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        websalerList.setItems(personData);
        columnID.setCellValueFactory(cellData -> cellData.getValue().IDProperty());
        columnName.setCellValueFactory(cellData -> cellData.getValue().NameProperty());
        columnNumber.setCellValueFactory(cellData -> cellData.getValue().NumberProperty());
//        userList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
//        userList.getSelectionModel().getSelectedItem().getuserID();
    }
    static String currentWebsalerID;
    public void setWebsalerID(String uid){ currentWebsalerID = uid;}
    public static String getWebsalerID(){ return currentWebsalerID;}
    static boolean choose;
    public void setChoose(boolean is){ choose = is;}
    public static boolean getChoose(){ return choose;}
}

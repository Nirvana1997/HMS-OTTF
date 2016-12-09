package presentation.webmanagerui;

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

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Administrator on 2016/11/30.
 */
public class uiManageHSController implements Initializable{
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
     * 点击按钮跳转到相应的修改详细酒店信息界面
     */
    @FXML
    private Button buttonChange;
    public void gotoChangeHS() throws IOException{
        setHotelID(hotelList.getSelectionModel().getSelectedItem().getID());
        jump.gotoChangeHS();
    }

    /**
     * 添加酒店按钮
     */
    @FXML
    Button buttonAddHotel;

    /**
     * 点击ADD按钮跳转到增加酒店界面
     * @throws IOException
     */
    public void gotoAddHotel() throws IOException{
        jump.gotoAddHotel();
    }

    @FXML
    private TextField textSearch;
    @FXML
    private ImageView searchHS;
    /**
     * 根据ID搜索并跳转
     * @throws IOException
     */
    public void SearchHS() throws IOException{
        //TODO 判断ID是否存在
        setHotelID(textSearch.getText());
        jump.gotoChangeHS();
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
    private TableView<tableMember> hotelList;
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
//        URmanagementBlService uRmanagementBlService = new WebmanagerController();
//        ArrayList<UserInfoVO> list = uRmanagementBlService.getUserList();
//        for(int i = 0; i < list.size();i++){
//            personData.add(new tableMember(list.get(i).getUserID(), list.get(i).getName(), list.get(i).getContactNumber()));
//        }
        personData.add(new tableMember("HS151250045","喋喋大酒店","15105180105"));
        personData.add(new tableMember("HS151250042","喋喋巨大酒店","15105180102"));
        hotelList.setItems(personData);
        columnID.setCellValueFactory(cellData -> cellData.getValue().IDProperty());
        columnName.setCellValueFactory(cellData -> cellData.getValue().NameProperty());
        columnNumber.setCellValueFactory(cellData -> cellData.getValue().NumberProperty());
//        userList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
//        userList.getSelectionModel().getSelectedItem().getuserID();
    }
    static String currentHotelID;
    public void setHotelID(String hid){ currentHotelID = hid;}
    public static String getHotelID(){ return currentHotelID;}

}

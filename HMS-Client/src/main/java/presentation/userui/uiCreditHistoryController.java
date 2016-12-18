package presentation.userui;

import businesslogic.userbl.UserController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import utility.UiFormatChanger;
import vo.CreditRecordVO;
import vo.HotelinfoVO;
import vo.OrderVO;

import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by Administrator on 2016/12/14.
 */
public class uiCreditHistoryController implements Initializable{
    UserController userController = new UserController();
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

    public uiCreditHistoryController() throws RemoteException {
    }

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
        //TODO 清空账号
        jump.gotoLogin();
    }

    @FXML
    private TableView<tableCredit> creditList;
    @FXML
    private TableColumn<tableCredit,String> columnID;
    @FXML
    private TableColumn<tableCredit,String> columnDate;
    @FXML
    private TableColumn<tableCredit,String> columnReason;
    @FXML
    private TableColumn<tableCredit,Number> columnChange;
    @FXML
    private TableColumn<tableCredit,Number> columnResult;

    private ObservableList<tableCredit> Data = FXCollections.observableArrayList();

    /**
     * 初始化信用变化记录
     * @param list 信用变化
     * @throws RemoteException
     */
    public void initTable(ArrayList<CreditRecordVO> list) throws RemoteException {
        ObservableList<tableCredit> creditData = FXCollections.observableArrayList();
        for(int i = 0; i < list.size(); i++) {
            creditData.add(new tableCredit(list.get(i).getDate(), list.get(i).getOrderID(),list.get(i).getReason(),
                    list.get(i).getChange(),list.get(i).getFinalCredit()));
        }
        creditList.setItems(creditData);
        columnID.setCellValueFactory(cellData -> cellData.getValue().orderIDProperty());
        columnDate.setCellValueFactory(cellData -> cellData.getValue().dateProperty());
        columnReason.setCellValueFactory(cellData -> cellData.getValue().reasonProperty());
        columnChange.setCellValueFactory(cellData -> cellData.getValue().changeProperty());
        columnResult.setCellValueFactory(cellData -> cellData.getValue().resultProperty());
        Data = creditData;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //TODO 初始化信用变化记录
        ArrayList<CreditRecordVO> creditlist = null;
        try {
            creditlist = userController.showCreditRecords();
            initTable(creditlist);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }
}

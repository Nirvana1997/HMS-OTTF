package presentation.userui;

import businesslogic.logbl.LogController;
import businesslogic.userbl.UserController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import vo.CreditRecordVO;
import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by Administrator on 2016/12/14.
 */
public class uiCreditHistoryController implements Initializable {
    /**
     * 用户界面控制器
     */
    UserController userController = new UserController();

    /**
     * 跳转界面的类
     */
    sceneJump jump = new sceneJump();

    /**
     * 信用变化记录列表
     */
    @FXML
    private TableView<tableCredit> creditList;

    /**
     * 订单编号列
     */
    @FXML
    private TableColumn<tableCredit, String> columnID;

    /**
     * 日期列
     */
    @FXML
    private TableColumn<tableCredit, String> columnDate;

    /**
     * 变更原因列
     */
    @FXML
    private TableColumn<tableCredit, String> columnReason;

    /**
     * 信用变化列
     */
    @FXML
    private TableColumn<tableCredit, Number> columnChange;

    /**
     * 信用变化结果列
     */
    @FXML
    private TableColumn<tableCredit, Number> columnResult;

    /**
     * 信用变化记录填充数据
     */
    private ObservableList<tableCredit> Data = FXCollections.observableArrayList();

    public uiCreditHistoryController() throws RemoteException {
    }

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
     * 初始化信用变化记录列表
     *
     * @param list 信用变化
     * @throws RemoteException
     */
    public void initTable(ArrayList<CreditRecordVO> list) throws RemoteException {
        ObservableList<tableCredit> creditData = FXCollections.observableArrayList();
        for (int i = 0; i < list.size(); i++) {
            creditData.add(new tableCredit(list.get(i).getDate(), list.get(i).getOrderID(), list.get(i).getReason(),
                    list.get(i).getChange(), list.get(i).getFinalCredit()));
        }
        creditList.setItems(creditData);
        columnID.setCellValueFactory(cellData -> cellData.getValue().orderIDProperty());
        columnDate.setCellValueFactory(cellData -> cellData.getValue().dateProperty());
        columnReason.setCellValueFactory(cellData -> cellData.getValue().reasonProperty());
        columnChange.setCellValueFactory(cellData -> cellData.getValue().changeProperty());
        columnResult.setCellValueFactory(cellData -> cellData.getValue().resultProperty());
        Data = creditData;
    }

    /**
     * 初始化
     *
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ArrayList<CreditRecordVO> creditlist = null;
        try {
            creditlist = userController.showCreditRecords();
            initTable(creditlist);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }
}

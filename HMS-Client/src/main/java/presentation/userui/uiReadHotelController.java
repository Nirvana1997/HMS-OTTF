package presentation.userui;

import businesslogic.logbl.LogController;
import businesslogic.userbl.UserController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import utility.UiFormatChanger;
import vo.HotelListItemVO;
import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by Administrator on 2016/12/3.
 */
public class uiReadHotelController implements Initializable {
    /**
     * 用户界面的控制器
     */
    UserController userController = new UserController();

    /**
     * 用户真实姓名
     */
    @FXML
    private Text UserName;

    /**
     * 酒店列表
     */
    @FXML
    private TableView<tableHotel> hotelList;

    /**
     * 酒店名称列
     */
    @FXML
    private TableColumn<tableHotel, String> columnHotelName;

    /**
     * 酒店价格列
     */
    @FXML
    private TableColumn<tableHotel, Number> columnPrice;

    /**
     * 酒店星级列
     */
    @FXML
    private TableColumn<tableHotel, Number> columnStar;

    /**
     * 酒店评分列
     */
    @FXML
    private TableColumn<tableHotel, Number> columnGrade;

    /**
     * 是否有正常订单列
     */
    @FXML
    private TableColumn<tableHotel, String> columnHasNormal;

    /**
     * 是否有异常订单列
     */
    @FXML
    private TableColumn<tableHotel, String> columnHasAbnormal;

    /**
     * 是否有撤销订单列
     */
    @FXML
    private TableColumn<tableHotel, String> columnHasCanceled;

    /**
     * 酒店列表填充数据
     */
    private ObservableList<tableHotel> Data = FXCollections.observableArrayList();

    /**
     * 商圈选择框
     */
    @FXML
    private ComboBox textCircle;

    /**
     * 地址选择框
     */
    @FXML
    private ComboBox textAddress;

    /**
     * 商圈选择框的填充数据
     */
    public final ObservableList<String> circle = FXCollections.observableArrayList("长江", "黄河", "南海");

    /**
     * 长江商圈对应地址选择框的填充数据
     */
    public final ObservableList<String> cjAddress = FXCollections.observableArrayList("上海", "南京");

    /**
     * 黄河商圈对应地址选择框的填充数据
     */
    public final ObservableList<String> hhAddress = FXCollections.observableArrayList("北京", "天津");

    /**
     * 南海商圈对应地址选择框的填充数据
     */
    public final ObservableList<String> nhAddress = FXCollections.observableArrayList("广东", "澳门");

    /**
     * 跳转界面的类
     */
    sceneJump jump = new sceneJump();

    public uiReadHotelController() throws RemoteException {
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
     * 根据选择的酒店跳转到酒店界面
     *
     * @throws IOException
     */
    public void gotoHotel() throws IOException {
        //检验是否选中个酒店
        for (int i = 0; i < Data.size(); i++) {
            setChooseHotel(false);
            if (hotelList.getSelectionModel().isSelected(i)) {
                setChooseHotel(true);
                break;
            }
        }
        //如果有，则跳转
        if (chooseHotel) {
            jump.setHotelID(hotelList.getSelectionModel().getSelectedItem().getHotelID());
            jump.gotoHotel();
        }
        //如果没有，跳出提示框
        else {
            setChooseHotel(false);
            jump.warning();
        }
    }


    /**
     * 跳转到预订酒店界面
     *
     * @throws IOException
     */
    public void gotoReserveHotel() throws IOException {
        //检验是否选中个酒店
        for (int i = 0; i < Data.size(); i++) {
            setChooseHotel(false);
            if (hotelList.getSelectionModel().isSelected(i)) {
                setChooseHotel(true);
                break;
            }
        }
        //如果有，则跳转
        if (chooseHotel) {
            jump.setHotelID(hotelList.getSelectionModel().getSelectedItem().getHotelID());
            jump.gotoReserveHotel();
        }
        //如果没有，跳出提示框
        else {
            setChooseHotel(false);
            jump.warning();
        }
    }

    /**
     * 显示符合条件的酒店列表
     *
     * @throws IOException
     */
    public void showHotel() throws IOException {
        ArrayList<HotelListItemVO> list = userController.searchHotel(UiFormatChanger.getArea(textCircle), UiFormatChanger.getAddress(textAddress));
        initTable(list);
    }

    /**
     * 初始化酒店列表
     *
     * @param listItemVOs 酒店信息列表
     */
    public void initTable(ArrayList<HotelListItemVO> listItemVOs) {
        ObservableList<tableHotel> hotelData = FXCollections.observableArrayList();
        for (int i = 0; i < listItemVOs.size(); i++) {
            //表示是否的符号
            String signAb;
            String signNo;
            String signCa;
            if (listItemVOs.get(i).isHasAbnormalOrder()) {
                signAb = "√";
            } else {
                signAb = "×";
            }
            if (listItemVOs.get(i).isHasNormalOrder()) {
                signNo = "√";
            } else {
                signNo = "×";
            }
            if (listItemVOs.get(i).isHasCanceledOrder()) {
                signCa = "√";
            } else {
                signCa = "×";
            }

            hotelData.add(new tableHotel(listItemVOs.get(i).getHotelID(), listItemVOs.get(i).getHotelname(), listItemVOs.get(i).getMinPrice(), listItemVOs.get(i).getStar(),
                    listItemVOs.get(i).getGrade(), signNo, signAb, signCa));
            Data = hotelData;
        }
        hotelList.setItems(hotelData);
        columnHotelName.setCellValueFactory(cellData -> cellData.getValue().hotelNameProperty());
        columnPrice.setCellValueFactory(cellData -> cellData.getValue().priceProperty());
        columnStar.setCellValueFactory(cellData -> cellData.getValue().starProperty());
        columnGrade.setCellValueFactory(cellData -> cellData.getValue().gradeProperty());
        columnHasNormal.setCellValueFactory(cellData -> cellData.getValue().hasNormalProperty());
        columnHasAbnormal.setCellValueFactory(cellData -> cellData.getValue().hasAbnormalProperty());
        columnHasCanceled.setCellValueFactory(cellData -> cellData.getValue().hasCanceledProperty());
    }


    /**
     * 根据选择的商圈初始化地址
     */
    public void initAddress() {

        if (textCircle.getSelectionModel().getSelectedItem() == "长江") {
            textAddress.getItems().setAll(cjAddress);
        } else if (textCircle.getSelectionModel().getSelectedItem() == "黄河") {
            textAddress.getItems().setAll(hhAddress);
        } else if (textCircle.getSelectionModel().getSelectedItem() == "南海") {
            textAddress.getItems().setAll(nhAddress);
        }
    }

    /**
     * 是否选择酒店
     */
    static Boolean chooseHotel = true;

    public void setChooseHotel(boolean is) {
        chooseHotel = is;
    }

    public static Boolean getChooseHotel() {
        return chooseHotel;
    }

    /**
     * 初始化商圈选择框
     *
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        textCircle.setItems(circle);
        try {
            UserName.setText(userController.showUserInfo().getName());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}

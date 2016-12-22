package presentation.userui;

import businesslogic.logbl.LogController;
import businesslogic.userbl.UserController;
import businesslogicservice.userblservice.HotelOrderBlService;
import enumData.LimitCriterion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;
import utility.UiFormatChanger;
import vo.HotelListItemVO;
import vo.LimitVO;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by Administrator on 2016/12/3.
 */
public class uiSearchHotelController implements Initializable {


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
     * 搜索酒店模块
     */
    @FXML
    private AnchorPane searchHotelPane;

    /**
     * 最低星级
     */
    @FXML
    private TextField StarMin;

    /**
     * 最高星级
     */
    @FXML
    private TextField StarMax;

    /**
     * 最低评分
     */
    @FXML
    private TextField GradeMin;

    /**
     * 最高评分
     */
    @FXML
    private TextField GradeMax;

    /**
     * 最低价格
     */
    @FXML
    private TextField PriceMin;

    /**
     * 最高价格
     */
    @FXML
    private TextField PriceMax;

    /**
     * 房间数量
     */
    @FXML
    private TextField RoomNum;

    /**
     * 关键词
     */
    @FXML
    private TextField KeyWord;

    /**
     * 是否选择预订过的酒店
     */
    @FXML
    private CheckBox checkOrdered;

    /**
     * 房间类型组合
     */
    @FXML
    private ToggleGroup RoomType;

    /**
     * 单人房选择框
     */
    @FXML
    private RadioButton SingleRoom;

    /**
     * 双人房选择框
     */
    @FXML
    private RadioButton DoubleRoom;

    /**
     * 无障碍客房选择框
     */
    @FXML
    private RadioButton StandardRoom;

    /**
     * 入住时间日期选择器
     */
    @FXML
    private DatePicker checkinDate;

    /**
     * 退房时间日期选择器
     */
    @FXML
    private DatePicker checkoutDate;

    /**
     * 酒店列表模块
     */
    @FXML
    private AnchorPane hotelListPane;

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
    private ObservableList<tableHotel> hotelData = FXCollections.observableArrayList();


    /**
     * 搜索酒店
     *
     * @throws IOException
     */
    public void SearchHotel() throws IOException, ParseException {
        ArrayList<LimitVO> SearchList = new ArrayList<LimitVO>();

        try {
            LimitVO GradeLimit = new LimitVO(LimitCriterion.GradeCriterion, Double.parseDouble(GradeMin.getText()), Double.parseDouble(GradeMax.getText()));
            LimitVO StarLimit = new LimitVO(LimitCriterion.StarCriterion, Double.parseDouble(StarMin.getText()), Double.parseDouble(StarMax.getText()));
            SearchList.add(GradeLimit);
            SearchList.add(StarLimit);
        } catch (Exception e) {
            setIsValid(false);
            jump.warning();
            return;
        }
        //如果房间数据全部为空，不输入房间数据
        if (RoomType.getSelectedToggle() == null && PriceMin.getText().length() == 0 && PriceMax.getText().length() == 0 &&
                RoomNum.getText().length() == 0 && checkinDate.getValue() == null && checkoutDate.getValue() == null) {
        } else if (RoomType.getSelectedToggle() != null && PriceMin.getText().length() != 0 && PriceMax.getText().length() != 0 &&
                RoomNum.getText().length() != 0 && checkinDate.getValue() != null && checkoutDate.getValue() != null) {
            try {
                LimitVO RoomLimit = new LimitVO(LimitCriterion.RoomCriterion, getRoomType(RoomType), Double.parseDouble(PriceMin.getText()), Double.parseDouble(PriceMax.getText()),
                        Integer.parseInt(RoomNum.getText()), UiFormatChanger.getDate(checkinDate), UiFormatChanger.getDate(checkoutDate));
                SearchList.add(RoomLimit);
            } catch (Exception e) {
                setIsValid(false);
                jump.warning();
                return;
            }
        }
        //填了部分房间信息
        else {
            setIsFinish(false);
            jump.warning();
            return;
        }
        if (KeyWord.getText() != null) {
            LimitVO KeywordLimit = new LimitVO(LimitCriterion.KeywordCriterion, KeyWord.getText());
            SearchList.add(KeywordLimit);
        }
        HotelOrderBlService hotelOrderBlService = new UserController();
        ArrayList<HotelListItemVO> getHotelList = hotelOrderBlService.searchHotel(UiFormatChanger.getArea(textCircle), UiFormatChanger.getAddress(textAddress), SearchList);
        searchHotelPane.setVisible(false);
        //如果不需要显示预订过的酒店，则直接显示所有列表
        if (!checkOrdered.isSelected()){
            initTable(getHotelList);
        }
        //如果需要显示预订过的酒店，则进行过滤筛选
        else{
            ArrayList<HotelListItemVO> searchHotelList = new ArrayList<HotelListItemVO>();
            for(int i = 0; i < getHotelList.size();i++){
                if(getHotelList.get(i).isHasAbnormalOrder()||getHotelList.get(i).isHasCanceledOrder()||getHotelList.get(i).isHasNormalOrder()){
                    searchHotelList.add(getHotelList.get(i));
                }
            }
            initTable(searchHotelList);
        }
        hotelListPane.setVisible(true);
    }

    /**
     * 根据选择的酒店跳转到酒店界面
     *
     * @throws IOException
     */
    public void gotoHotel() throws IOException {
        //检验是否选中个酒店
        for (int i = 0; i < hotelData.size(); i++) {
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
        for (int i = 0; i < hotelData.size(); i++) {
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
     * 获取房间类型
     *
     * @param bt 房间类型的单选组合
     * @return 预订房间类型
     */
    public enumData.RoomType getRoomType(ToggleGroup bt) {
        if (bt.getSelectedToggle() == SingleRoom) {
            return enumData.RoomType.SingleRoom;
        } else if (bt.getSelectedToggle() == DoubleRoom) {
            return enumData.RoomType.DoubleRoom;
        } else if (bt.getSelectedToggle() == StandardRoom) {
            return enumData.RoomType.DisabledRoom;
        } else return null;
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
     * 初始化入住时间日期选择器
     * 初始化商圈选择框
     *
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /**
         * 入住时间可选择范围晚于当前日期
         */
        final Callback<DatePicker, DateCell> dayCellFactoryin = new Callback<DatePicker, DateCell>() {
            @Override
            public DateCell call(final DatePicker datePicker) {
                return new DateCell() {
                    @Override
                    public void updateItem(LocalDate item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item.isBefore(LocalDate.now())) {
                            setDisable(true);
                            setStyle("-fx-background-color: #ffc0cb;");
                        }
                    }
                };
            }
        };
        checkinDate.setDayCellFactory(dayCellFactoryin);
        textCircle.getItems().addAll(circle);
    }

    /**
     * 设定退房时间应该晚于入住时间
     *
     * @throws IOException
     */
    public void initCheckOutDate() throws IOException {
        final Callback<DatePicker, DateCell> dayCellFactory = new Callback<DatePicker, DateCell>() {
            @Override
            public DateCell call(final DatePicker datePicker) {
                return new DateCell() {
                    @Override
                    public void updateItem(LocalDate item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item.isBefore(checkinDate.getValue().plusDays(1))) {
                            setDisable(true);
                            setStyle("-fx-background-color: #ffc0cb;");
                        }
                    }
                };
            }
        };
        checkoutDate.setDayCellFactory(dayCellFactory);
    }

    /**
     * 输入格式是否正确
     */
    static Boolean isValid = true;

    public void setIsValid(boolean is) {
        isValid = is;
    }

    public static Boolean getIsValid() {
        return isValid;
    }

    /**
     * 是否全部输入酒店信息
     */
    static Boolean isFinish = true;

    public void setIsFinish(boolean is) {
        isFinish = is;
    }

    public static Boolean getIsFinish() {
        return isFinish;
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
     * 初始化搜索酒店的列表
     *
     * @param listItemVOs 返回的酒店列表
     * @throws IOException
     */
    public void initTable(ArrayList<HotelListItemVO> listItemVOs) throws IOException {
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
}

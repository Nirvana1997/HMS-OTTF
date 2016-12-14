package presentation.userui;

import businesslogic.userbl.UserController;
import businesslogicservice.userblservice.HotelOrderBlService;
import enumData.Address;
import enumData.LimitCriterion;
import enumData.TradeArea;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;
import vo.HotelListItemVO;
import vo.LimitVO;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

/**
 * Created by Administrator on 2016/12/3.
 */
public class uiSearchHotelController implements Initializable{
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
    private AnchorPane searchHotelPane;
    @FXML
    private TextField StarMin;
    @FXML
    private TextField StarMax;
    @FXML
    private TextField GradeMin;
    @FXML
    private TextField GradeMax;
    @FXML
    private TextField PriceMin;
    @FXML
    private TextField PriceMax;
    @FXML
    private TextField RoomNum;
    @FXML
    private TextField KeyWord;
    @FXML
    private ToggleGroup RoomType;
    @FXML
    private RadioButton SingleRoom;
    @FXML
    private RadioButton DoubleRoom;
    @FXML
    private RadioButton StandardRoom;
    @FXML
    private DatePicker checkinDate;
    @FXML
    private DatePicker checkoutDate;

    @FXML
    private AnchorPane hotelListPane;


    /**
     * 搜索酒店
     * @throws IOException
     */
    public void SearchHotel() throws IOException, ParseException {
        ArrayList<LimitVO> SearchList = new ArrayList<LimitVO>();
        try {
            LimitVO GradeLimit = new LimitVO(LimitCriterion.GradeCriterion, Double.parseDouble(GradeMin.getText()), Double.parseDouble(GradeMax.getText()));
            LimitVO StarLimit = new LimitVO(LimitCriterion.StarCriterion, Double.parseDouble(StarMin.getText()), Double.parseDouble(StarMax.getText()));
            SearchList.add(GradeLimit);
            SearchList.add(StarLimit);
        }catch (Exception e){
            setIsValid(false);
            jump.warning();
            return;
        }
        //如果房间数据全部为空，不输入房间数据
        if(RoomType.getSelectedToggle()==null && PriceMin.getText().length()==0 && PriceMax.getText().length()==0 &&
                RoomNum.getText().length()==0 && checkinDate.getValue()==null && checkoutDate.getValue()==null) {
            System.out.println("不存入房间信息");
        }
        else if(RoomType.getSelectedToggle()!=null && PriceMin.getText().length()!=0 && PriceMax.getText().length()!=0&&
                RoomNum.getText().length()!=0 && checkinDate.getValue()!=null && checkoutDate.getValue()!=null){
            try{
                LimitVO RoomLimit = new LimitVO(LimitCriterion.RoomCriterion, getRoomType(RoomType), Double.parseDouble(PriceMin.getText()), Double.parseDouble(PriceMax.getText()), Integer.parseInt(RoomNum.getText()), getDate(checkinDate), getDate(checkoutDate));
                SearchList.add(RoomLimit);
            }catch (Exception e){
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
        if(KeyWord.getText()!=null) {
            LimitVO KeywordLimit = new LimitVO(LimitCriterion.KeywordCriterion, KeyWord.getText());
            SearchList.add(KeywordLimit);
        }
        //TODO 将列表存入搜索酒店
        HotelOrderBlService hotelOrderBlService = new UserController();
        ArrayList<HotelListItemVO> searchHotelList = hotelOrderBlService.searchHotel(TradeArea.Xianlin, Address.NJU,SearchList);

//        ArrayList<HotelListItemVO> searchHotelList = new ArrayList<HotelListItemVO>();
//        HotelListItemVO vo1 = new HotelListItemVO("0001","喋喋大酒店","南大旁边",5, 3.0, 300.0,true,false,false);
//        HotelListItemVO vo2 = new HotelListItemVO("0002","喋喋中酒店","南大隔壁",4, 2.0, 1000.0,false,false,false);
//        HotelListItemVO vo3 = new HotelListItemVO("0003","喋喋小酒店","南大里面",3, 5.0, 200.0,true,true,false);
//        searchHotelList.add(vo1);
//        searchHotelList.add(vo2);
//        searchHotelList.add(vo3);
        searchHotelPane.setVisible(false);
        initTable(searchHotelList);
        hotelListPane.setVisible(true);
    }
    @FXML
    private Button buttonHotel;

    /**
     * 根据选择的酒店跳转到酒店界面
     * @throws IOException
     */
    public void gotoHotel() throws IOException{
        //检验是否选中个酒店
        for(int i = 0; i < hotelData.size();i++){
            setChooseHotel(false);
            if(hotelList.getSelectionModel().isSelected(i)){
                setChooseHotel(true);
                break;
            }
        }
        //如果有，则跳转
        if(chooseHotel) {
            jump.setHotelID(hotelList.getSelectionModel().getSelectedItem().getHotelID());
            jump.gotoHotel();
        }
        //如果没有，跳出提示框
        else{
            setChooseHotel(false);
            jump.warning();
        }
    }
    @FXML
    private Button buttonReserve;

    /**
     * 跳转到预订酒店界面
     * @throws IOException
     */
    public void gotoReserveHotel() throws IOException{
        //检验是否选中个酒店
        for(int i = 0; i < hotelData.size();i++){
            setChooseHotel(false);
            if(hotelList.getSelectionModel().isSelected(i)){
                setChooseHotel(true);
                break;
            }
        }
        //如果有，则跳转
        if(chooseHotel) {
            jump.setHotelID(hotelList.getSelectionModel().getSelectedItem().getHotelID());
            jump.gotoReserveHotel();
        }
        //如果没有，跳出提示框
        else{
            setChooseHotel(false);
            jump.warning();
        }
    }
    /**
     * 获取日期
     * @param ld 日期选取器
     * @return Date格式的日期
     */
    public static Date getDate(DatePicker ld) throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        return sdf.parse(ld.getValue().toString());
    }

    /**
     * 获取房间类型
     * @param bt 房间类型的单选组合
     * @return 预订房间类型
     */
    public enumData.RoomType getRoomType(ToggleGroup bt){
        if(bt.getSelectedToggle()==SingleRoom){return enumData.RoomType.SingleRoom;}
        else if(bt.getSelectedToggle()==DoubleRoom){return enumData.RoomType.DoubleRoom;}
        else if(bt.getSelectedToggle()==StandardRoom){return enumData.RoomType.DisabledRoom;}
        else return null;
    }

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
    }

    /**
     * 设定退房时间应该晚于入住时间
     * @throws IOException
     */
    public void initCheckOutDate() throws IOException{
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
    public void setIsValid(boolean is){isValid = is;}
    public static Boolean getIsValid(){ return isValid;}
    /**
     * 是否全部输入酒店信息
     */
    static Boolean isFinish = true;
    public void setIsFinish(boolean is){isFinish = is;}
    public static Boolean getIsFinish(){ return isFinish;}

    /**
     * 是否选择酒店
     */
    static Boolean chooseHotel = true;
    public void setChooseHotel(boolean is){ chooseHotel = is;}
    public static Boolean getChooseHotel(){ return chooseHotel;}


    @FXML
    private TableView<tableHotel> hotelList;
    @FXML
    private TableColumn<tableHotel,String> columnHotelName;
    @FXML
    private TableColumn<tableHotel,Number> columnPrice;
    @FXML
    private TableColumn<tableHotel,Number> columnStar;
    @FXML
    private TableColumn<tableHotel,Number> columnGrade;
    @FXML
    private TableColumn<tableHotel,String> columnHasNormal;
    @FXML
    private TableColumn<tableHotel,String> columnHasAbnormal;
    @FXML
    private TableColumn<tableHotel,String> columnHasCanceled;
    private ObservableList<tableHotel> hotelData = FXCollections.observableArrayList();

    /**
     * 初始化搜索酒店的列表
     * @param listItemVOs 返回的酒店列表
     * @throws IOException
     */
    public void initTable(ArrayList<HotelListItemVO> listItemVOs) throws IOException{
        for(int i = 0; i < listItemVOs.size();i++) {
            //表示是否的符号
            String signAb;
            String signNo;
            String signCa;
            if(listItemVOs.get(i).isHasAbnormalOrder()){signAb = "√";}
            else{signAb = "×";}
            if(listItemVOs.get(i).isHasNormalOrder()){signNo = "√";}
            else{signNo = "×";}
            if(listItemVOs.get(i).isHasCanceledOrder()){signCa = "√";}
            else{signCa = "×";}
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

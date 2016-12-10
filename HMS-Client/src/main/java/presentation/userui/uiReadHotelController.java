package presentation.userui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import vo.HotelListItemVO;
import vo.HotelVO;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by Administrator on 2016/12/3.
 */
public class uiReadHotelController implements Initializable {
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
    HotelListItemVO vo1 = new HotelListItemVO("0001","喋喋大酒店","南大旁边",5, 3.0, 300.0,true,false,false);
    HotelListItemVO vo2 = new HotelListItemVO("0002","喋喋中酒店","南大隔壁",4, 2.0, 1000.0,false,false,false);
    HotelListItemVO vo3 = new HotelListItemVO("0003","喋喋小酒店","南大里面",3, 5.0, 200.0,true,true,false);
    /**
     * 初始化酒店列表
     */
    public void initTable(){
        ArrayList<HotelListItemVO> listItemVOs = new ArrayList<HotelListItemVO>();
        listItemVOs.add(vo1);
        listItemVOs.add(vo2);
        listItemVOs.add(vo3);
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


    /**
     * 是否选择酒店
     */
    static Boolean chooseHotel = true;
    public void setChooseHotel(boolean is){ chooseHotel = is;}
    public static Boolean getChooseHotel(){ return chooseHotel;}

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initTable();
    }
}

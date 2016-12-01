package presentation.logui;

import com.sun.javafx.robot.impl.FXRobotHelper;
import enumData.AccountType;
import enumData.ResultMessage;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import presentation.hotelsalerui.SceneHotelSaler;
import presentation.webmanagerui.SceneWebManager;
import presentation.websalerui.SceneWebSaler;
import vo.AccountVO;

import java.io.IOException;

/**
 * Created by thinkpad on 2016/11/16.
 */
public class uiLogController {

    private int count = 0;

    @FXML
    private ImageView imgHotel01;
    @FXML
    private ImageView imgHotel02;
    @FXML
    private ImageView imgHotel03;
    @FXML
    private TextField textUserID;
    @FXML
    private PasswordField textPassword;

    @FXML
    public void setNextPic(){
        count++;
        if(count % 3 == 0){
            imgHotel01.setVisible(true);
            imgHotel02.setVisible(false);
            imgHotel03.setVisible(false);
        }
        else if(count % 3 == 1){
            imgHotel01.setVisible(false);
            imgHotel02.setVisible(true);
            imgHotel03.setVisible(false);
        }
        else if(count % 3 == 2){
            imgHotel01.setVisible(false);
            imgHotel02.setVisible(false);
            imgHotel03.setVisible(true);
        }
    }

    public void gotoRegister1() throws IOException {
        ObservableList<Stage> stage = FXRobotHelper.getStages();
        Scene scene = new Scene((Parent) FXMLLoader.load(getClass().getResource("sceneRegister1.fxml")));
        stage.get(0).setScene(scene);
    }

    public void login() throws IOException {

//        SceneWebSaler sceneWebSaler = new SceneWebSaler();
//        sceneWebSaler.initUI();
        SceneWebManager sceneWebManager = new SceneWebManager();
        sceneWebManager.initUI();
//        // 获取用户名
//        String userID = textUserID.getText();
//        // 获取密码
//        String password = textPassword.getText();

//        LogBlService logbl = new LogController();
//        AccountType accountType = logbl.accoutType(userID);
//        if(accountType == null){
//            // TODO
//        }
//
//        else if(accountType == AccountType.user){
//            // TODO
//        }
//
//        else if(accountType == AccountType.hotelsaler){
//            ResultMessage result = logbl.isCorrectAndLogin(this.createAccountVo(userID, password, accountType));
//            System.out.println(result);
//            if (result == ResultMessage.Correct){
//                SceneHotelSaler sceneHotelSaler = new SceneHotelSaler();
//                sceneHotelSaler.initUI();
//            }else{
//                // TODO
//            }
//        }
//
//        else if(accountType == AccountType.websaler){
//            ResultMessage result = logbl.isCorrectAndLogin(this.createAccountVo(userID, password, accountType));
//            if (result == ResultMessage.Correct){
//                SceneWebSaler sceneWebSaler = new SceneWebSaler();
//                sceneWebSaler.initUI();
//            }else{
//                // TODO
//            }
//        }
//
//        else if(accountType == AccountType.webmanager){
//            // TODO
//        }
    }

    private AccountVO createAccountVo(String accountID, String password, AccountType type){
        AccountVO accountVO = new AccountVO(accountID, password, type);
        return accountVO;
    }

}

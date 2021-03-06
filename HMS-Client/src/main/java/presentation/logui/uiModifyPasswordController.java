package presentation.logui;

import businesslogic.logbl.LogController;
import enumData.ResultMessage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.rmi.RemoteException;

/**
 * Created by Administrator on 2016/12/3.
 */
public class uiModifyPasswordController {
    LogController logController = new LogController();
    @FXML
    private PasswordField textNew;
    @FXML
    private PasswordField textOld;
    @FXML
    private PasswordField textConfirm;
    @FXML
    private Button buttonConfirm;
    @FXML
    private Text oldWrong;
    @FXML
    private Text newWrong;
    @FXML
    private Text cfmWrong;

    public uiModifyPasswordController() throws RemoteException {
    }

    /**
     * 点击原密码输入框，隐藏警告。
     * @throws IOException
     */
    public void oldnotWrong() throws IOException{
        oldWrong.setVisible(false);
    }
    /**
     * 点击新密码输入框，隐藏警告。
     * @throws IOException
     */
    public void newnotWrong() throws IOException{
        newWrong.setVisible(false);
    }
    /**
     * 点击确认密码输入框，隐藏警告。
     * @throws IOException
     */
    public void cfmnotWrong() throws IOException{
        cfmWrong.setVisible(false);
    }

    public void Confirm() throws IOException{
        String New = textNew.getText();
        String Old = textOld.getText();
        String Confirm = textConfirm.getText();
        int newSize = New.length();


        if(newSize > temp.MAX_LENGTH || newSize < temp.MIN_LENGTH){
            newWrong.setVisible(true);
        }
        else if(!New.equals(Confirm)){
            cfmWrong.setVisible(true);
        }
        else{
            if(logController.modifyPassword(Old,New)== ResultMessage.InCorrect){
                oldWrong.setVisible(true);
            }
            else {
                Stage secondWindow = new Stage();
                Scene scene = new Scene((Parent) FXMLLoader.load(getClass().getResource("sceneModifySuccess.fxml")));
                secondWindow.initStyle(StageStyle.TRANSPARENT);
                secondWindow.setScene(scene);
                secondWindow.setAlwaysOnTop(true);
                secondWindow.show();
                buttonConfirm.getScene().getWindow().hide();
            }
        }
    }

}

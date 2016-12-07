package presentation.logui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;

/**
 * Created by Administrator on 2016/12/3.
 */
public class uiModifyPasswordController {
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

        if(Old.equals("exist")){
            oldWrong.setVisible(true);
        }
        else if(newSize > temp.MAX_LENGTH || newSize < temp.MIN_LENGTH){
            newWrong.setVisible(true);
        }
        else if(!New.equals(Confirm)){
            cfmWrong.setVisible(true);
        }
        else{
            //TODO
            System.out.println("success");
            buttonConfirm.getScene().getWindow().hide();
        }
    }

}

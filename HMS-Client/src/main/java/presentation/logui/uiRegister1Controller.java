package presentation.logui;

import businesslogic.logbl.LogController;
import businesslogicservice.logblservice.LogBlService;
import com.sun.javafx.robot.impl.FXRobotHelper;
import enumData.AccountType;
import enumData.ResultMessage;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import vo.AccountVO;
import vo.PasswordComfirmVO;

import java.io.IOException;

/**
 * Created by Administrator on 2016/11/20.
 */
public class uiRegister1Controller {

    public Button buttonReturn;
    public Button buttonNext;
    public TextField textUserID;
    public TextField textPassword;
    public TextField textConfirm;
    static String uID;

    /**
     * 从注册界面1返回到登录界面
     */
    ObservableList<Stage> stage = FXRobotHelper.getStages();
    public void returnToLog() throws IOException {
        Scene scene = new Scene((Parent) FXMLLoader.load(getClass().getResource("sceneLog.fxml")));
        stage.get(0).setScene(scene);
    }
    /**
     * 设置当前账号
     * @param id 用户账号
     * @throws IOException
     */
    public void setUserID(String id) throws IOException {
        uID = id;
    }
    /**
     *
     * @return 当前账号
     * @throws IOException
     */
    public static String getUserID() throws IOException {
        return uID;
    }
    /**
     * 根据账号密码选择报错或者进行下一步
     */
    public void goToRegister2() throws IOException {
        String UserID = textUserID.getText();
        setUserID(UserID);

        //控制台输出当前读入的Userid
        System.out.println(uID);

        String Password = textPassword.getText();
        String Confirm = textConfirm.getText();
        LogBlService logBlService = new LogController();
        PasswordComfirmVO passwordComfirmVO = new PasswordComfirmVO(UserID, Password, Confirm);
        //如果可以注册，跳转到注册界面2，并注册一个vo账户
        if (logBlService.isValid(passwordComfirmVO) == ResultMessage.Correct) {
            Scene scene = new Scene((Parent) FXMLLoader.load(getClass().getResource("sceneRegister2.fxml")));
            stage.get(0).setScene(scene);
            AccountVO accountVO = new AccountVO(UserID, Password, AccountType.user);
            logBlService.register(accountVO);
        }
        //如果密码和确认密码输入不同，则提示错误
        else if (logBlService.isValid(passwordComfirmVO) == ResultMessage.NotSame) {
            Stage warning = new Stage();
            Scene scene = new Scene((Parent) FXMLLoader.load(getClass().getResource("dialogWarning.fxml")));
            warning.setTitle("secondWindow");
            warning.setScene(scene);
            warning.show();
            System.out.print("两次密码不相同");
        }
        //如果用户名已经存在，则提示已存在
        else if (logBlService.isValid(passwordComfirmVO) == ResultMessage.HasExist) {
            System.out.print("用户已存在");
        }
    }
}

package presentation.webmanagerui;

import com.sun.javafx.robot.impl.FXRobotHelper;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Administrator on 2016/11/30.
 */
public class uiManageUserController {
    /**
     * 三个方法分别实现左侧三个管理按钮的跳转实现
     */
    sceneJump jump = new sceneJump();
    Button buttonManageUser;
    Button buttonManageHS;
    Button buttonManageWS;
    public void gotoManageUser() throws IOException{
    }
    public void gotoManageHS() throws IOException{
        jump.gotoManageHS();
    }
    public void gotoManageWS() throws IOException{
        jump.gotoManageWS();
    }
    /**
     * 点击图片跳转到相应的修改用户信息界面
     */
    ImageView pic01;
    public void gotoChangeUser() throws IOException {
        jump.gotoChangeUser();
    }
}

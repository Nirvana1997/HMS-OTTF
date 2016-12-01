package presentation.webmanagerui;

import com.sun.javafx.robot.impl.FXRobotHelper;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Administrator on 2016/11/29.
 */
public class uiWebManagerController {
    /**
     * 三个方法分别实现左侧三个管理按钮的跳转实现
     */
    sceneJump jump = new sceneJump();
    Button buttonManageUser;
    Button buttonManageHS;
    Button buttonManageWS;
    public void gotoManageUser() throws IOException{
        jump.gotoManageUser();
    }
    public void gotoManageHS() throws IOException{
        jump.gotoManageHS();
    }
    public void gotoManageWS() throws IOException{
        jump.gotoManageWS();
    }
}

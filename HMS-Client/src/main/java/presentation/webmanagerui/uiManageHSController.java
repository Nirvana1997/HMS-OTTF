package presentation.webmanagerui;

import com.sun.javafx.robot.impl.FXRobotHelper;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Administrator on 2016/11/30.
 */
public class uiManageHSController {
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
//        jump.gotoManageHS();
    }
    public void gotoManageWS() throws IOException{
        jump.gotoManageWS();
    }

    /**
     * 点击图片跳转到相应的修改详细酒店信息界面
     */
    ImageView pic01;
    public void gotoChangeHotel() throws IOException{
        jump.gotoChangeHS();
    }

    /**
     * 点击ADD按钮跳转到增加酒店界面
     */
    Button buttonAddHotel;
    public void gotoAddHotel() throws IOException{
        jump.gotoAddHotel();
    }
}

package presentation.webmanagerui;

import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.io.IOException;

/**
 * Created by Administrator on 2016/11/30.
 */
public class uiAddHotelController {
    /**
     * 三个方法分别实现左侧三个管理按钮的跳转实现
     */
    sceneJump jump = new sceneJump();
    Button buttonManageUser;
    Button buttonManageHS;
    Button buttonManageWS;
    public void gotoManageUser() throws IOException {
        jump.gotoManageUser();
    }
    public void gotoManageHS() throws IOException{
//        jump.gotoManageHS();
    }
    public void gotoManageWS() throws IOException{
        jump.gotoManageWS();
    }

    /**
     * 返回酒店管理界面
     */
    Text textManageHS;
    public void returntoManageHS()throws IOException{
        jump.gotoManageHS();
    }
}
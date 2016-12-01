package presentation.webmanagerui;

import javafx.scene.control.Button;
import javafx.scene.text.Text;
import sun.awt.TimedWindowEvent;

import java.io.IOException;

/**
 * Created by Administrator on 2016/11/30.
 */
public class uiChangeUserController {
    /**
     * 三个方法分别实现左侧三个管理按钮的跳转实现
     */
    sceneJump jump = new sceneJump();
    Button buttonManageUser;
    Button buttonManageHS;
    Button buttonManageWS;
    public void gotoManageUser() throws IOException {
    }
    public void gotoManageHS() throws IOException{
        jump.gotoManageHS();
    }
    public void gotoManageWS() throws IOException{
        jump.gotoManageWS();
    }

    /**
     * 返回用户管理界面
     */
    Text textManageUser;
    public void returntoManageUser() throws IOException{
        jump.gotoManageUser();
    }

    /**
     * 进入信用变化记录界面
     */
    Text textCreditHistory;
    public void gotoCreditHistory() throws IOException{
    }
}

package presentation.webmanagerui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.io.IOException;

/**
 * Created by Administrator on 2016/11/30.
 */
public class uiChangeHSController {
    /**
     * 界面跳转的类
     */
    sceneJump jump = new sceneJump();
    @FXML
    /**
     * 用户管理按钮
     */
            Button buttonManageUser;
    @FXML
    /**
     * 酒店管理按钮
     */
            Button buttonManageHS;
    @FXML
    /**
     * 网站管理按钮
     */
            Button buttonManageWS;

    /**
     * 跳转到用户管理界面
     * @throws IOException
     */
    public void gotoManageUser() throws IOException {
        jump.gotoManageUser();
    }
    /**
     * 跳转到酒店管理界面
     * @throws IOException
     */
    public void gotoManageHS() throws IOException{
        jump.gotoManageHS();
    }
    /**
     * 跳转到网站管理界面
     * @throws IOException
     */
    public void gotoManageWS() throws IOException{
        jump.gotoManageWS();
    }

    /**
     * 返回酒店管理界面
     */
    @FXML
    Text textManageHS;
    public void returntoManageHS()throws IOException{
        jump.gotoManageHS();
    }
}

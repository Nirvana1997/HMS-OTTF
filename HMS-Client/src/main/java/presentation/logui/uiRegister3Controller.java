package presentation.logui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import presentation.userui.SceneUser;

import java.io.IOException;

/**
 * Created by Administrator on 2016/11/25.
 */
public class uiRegister3Controller {
    @FXML
    private Button buttonNext;

    /**
     * 跳转到注册后的用户首页
     * @throws IOException
     */
    public void gotoStart() throws IOException{
        SceneUser sceneUser = new SceneUser();
        sceneUser.initUI();
    }
}

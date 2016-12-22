package presentation.websalerui;

import businesslogic.logbl.LogController;
import businesslogic.websalerbl.WebsalerController;
import businesslogicservice.logblservice.LogBlService;
import businesslogicservice.websalerblservice.WebsalerblService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import vo.VipUpVO;

import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by thinkpad on 2016/12/22.
 */
public class uiWebSalerMemberLevelUpController implements Initializable{

    private SceneJump sceneJump = new SceneJump();
    private WebsalerblService websalerbl = new WebsalerController();
    LogBlService logBl = new LogController();

    /**
     * 登出按钮
     */
    @FXML
    private Label labelExit;

    @FXML
    private ImageView imageViewSetSuccess;
    @FXML
    private TextField textFieldLevel1;
    @FXML
    private TextField textFieldLevel2;
    @FXML
    private TextField textFieldLevel3;

    public uiWebSalerMemberLevelUpController() throws RemoteException {
    }

    /**
     * 跳转到销售策略界面
     */
    public void jumpToSceneSaleStrategy() throws IOException {
        sceneJump.jumpToSceneSaleStrategy();
    }

    /**
     * 跳转到异常订单界面
     */
    public void jumpToSceneOrder() throws IOException {
        sceneJump.jumpToSceneOrder();
    }

    /**
     * 跳转到信用充值界面
     */
    public void jumpToScneCredit() throws IOException {
        sceneJump.jumpToSceneCredit();
    }

    /**
     * 鼠标移入登出按钮监听
     */
    public void enteredLabelExit(){
        labelExit.setUnderline(true);
    }

    /**
     * 鼠标移出登出按钮监听
     */
    public void exitedLabelExit(){
        labelExit.setUnderline(false);
    }

    /**
     * 点击登出按钮监听
     */
    public void onClickedLabelExit() throws IOException {
        sceneJump.backToLogin();
        logBl.logOut();
    }

    /**
     * 确认修改升级策略
     */
    public void comfirmSetLevel() throws RemoteException {
        int credit1 = Integer.parseInt(textFieldLevel1.getText());
        int credit2 = Integer.parseInt(textFieldLevel2.getText());
        int credit3 = Integer.parseInt(textFieldLevel3.getText());

        ArrayList<VipUpVO> vip = new ArrayList<>();
        vip.add(new VipUpVO(1, credit1));
        vip.add(new VipUpVO(2, credit2));
        vip.add(new VipUpVO(3, credit3));

        websalerbl.setVipInfos(vip);
        imageViewSetSuccess.setVisible(true);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            ArrayList<VipUpVO> vip = websalerbl.getVipInfos();
            for (int i = 0; i < vip.size(); i++) {
                if (vip.get(i).getVipLevel() == 1){
                    textFieldLevel1.setText(String.valueOf(vip.get(i).getCredit()));
                }
                else if(vip.get(i).getVipLevel() == 2){
                    textFieldLevel2.setText(String.valueOf(vip.get(i).getCredit()));
                }
                else if(vip.get(i).getVipLevel() == 3){
                    textFieldLevel3.setText(String.valueOf(vip.get(i).getCredit()));
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}

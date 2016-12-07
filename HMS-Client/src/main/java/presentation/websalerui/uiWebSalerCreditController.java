package presentation.websalerui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by thinkpad on 2016/12/5.
 */
public class uiWebSalerCreditController implements Initializable {

    private SceneJump sceneJump = new SceneJump();

    /**
     * 登出按钮
     */
    @FXML
    private Label labelExit;

    /**
     * 信用充值界面确认返回按钮
     */
    @FXML
    private ImageView buttonConfirm1;
    @FXML
    private ImageView buttonConfirm2;
    @FXML
    private ImageView buttonReturn1;
    @FXML
    private ImageView buttonReturn2;

    /**
     * 用户名的textField
     */
    @FXML
    private TextField textFieldUserId;

    /**
     * 确认用户名的textField
     */
    @FXML
    private TextField textFieldConfirmUserId;

    /**
     * 充值金额的textField
     */
    @FXML
    private TextField textFieldMoney;

    /**
     * 两次用户名输入不一致警告
     */
    @FXML
    private Label labelWarning;

    /**
     * 信用充值界面
     */
    @FXML
    private AnchorPane paneCredit1;

    /**
     * 信用充值成功界面
     */
    @FXML
    private AnchorPane paneCredit2;

    /**
     * 信用充值成功界面的用户充值金额label
     */
    @FXML
    private Label labelSuccessMoney;

    /**
     * 信用充值成功界面的userId的Label
     */
    @FXML
    private Label labelSuccessUserId;

    /**
     * 信用充值成功界面的用户原信用值label
     */
    @FXML
    private Label labelSuccessCreditBefore;

    /**
     * 信用充值成功界面的用户现信用值label
     */
    @FXML
    private Label labelSuccessCreditPresent;

    /**
     * 初始化方法
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO
        labelSuccessMoney.setText("￥");
        labelSuccessUserId.setText("");
        labelSuccessCreditBefore.setText("");
        labelSuccessCreditPresent.setText("");
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

    public void onConfirmEntered(){
        buttonConfirm1.setVisible(false);
        buttonConfirm2.setVisible(true);
    }
    public void onConfirmExited(){
        buttonConfirm1.setVisible(true);
        buttonConfirm2.setVisible(false);
    }
    public void onReturnEntered(){
        buttonReturn1.setVisible(false);
        buttonReturn2.setVisible(true);
    }
    public void onReturnExited(){
        buttonReturn1.setVisible(true);
        buttonReturn2.setVisible(false);
    }

    /**
     * 确认充值按钮监听
     */
    public void confirmCredit(){
        String userId = textFieldUserId.getText();
        String confirmUserId = textFieldConfirmUserId.getText();

        if(userId.equals(confirmUserId)){
            String money = textFieldMoney.getText();

            paneCredit1.setVisible(false);
            paneCredit2.setVisible(true);

            // TODO
        }else{
            labelWarning.setVisible(true);
        }
    }

    /**
     * 返回充值界面按钮监听
     */
    public void returnPaneCredit1(){
        paneCredit1.setVisible(true);
        paneCredit2.setVisible(false);
        labelWarning.setVisible(false);
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
    }

}

package presentation.websalerui;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

/**
 * Created by hyx on 2016/11/25.
 */
public class uiWebSalerController {
    @FXML
    private ImageView imageSale1;
    @FXML
    private ImageView imageSale2;
    @FXML
    private ImageView imageOrder1;
    @FXML
    private ImageView imageOrder2;
    @FXML
    private ImageView imageCredit1;
    @FXML
    private ImageView imageCredit2;
    @FXML
    private ImageView imageSale111;
    @FXML
    private ImageView imageSale112;
    @FXML
    private ImageView imageVIP1;
    @FXML
    private ImageView imageVIP2;
    @FXML
    private ImageView imageMember1;
    @FXML
    private ImageView imageMember2;

    /**
     * 营销策略按钮监听
     */
    @FXML
    public void chooseWorkSale(){
        imageSale1.setVisible(false);
        imageSale2.setVisible(true);
        imageOrder1.setVisible(true);
        imageOrder2.setVisible(false);
        imageCredit1.setVisible(true);
        imageCredit2.setVisible(false);
    }

    /**
     * 异常订单按钮监听
     */
    @FXML
    public void chooseWorkOrder(){
        imageSale1.setVisible(true);
        imageSale2.setVisible(false);
        imageOrder1.setVisible(false);
        imageOrder2.setVisible(true);
        imageCredit1.setVisible(true);
        imageCredit2.setVisible(false);
    }

    /**
     * 信用充值监听
     */
    @FXML
    public void chooseWorkCredit(){
        imageSale1.setVisible(true);
        imageSale2.setVisible(false);
        imageOrder1.setVisible(true);
        imageOrder2.setVisible(false);
        imageCredit1.setVisible(false);
        imageCredit2.setVisible(true);
    }

    /**
     * 双十一优惠活动按钮监听
     */
    @FXML
    public void work11(){
        imageSale111.setVisible(false);
        imageSale112.setVisible(true);
        imageVIP1.setVisible(true);
        imageVIP2.setVisible(false);
        imageMember1.setVisible(true);
        imageMember2.setVisible(false);
    }

    /**
     * 特定地址商圈优惠活动按钮监听
     */
    @FXML
    public void workVIP(){
        imageSale111.setVisible(true);
        imageSale112.setVisible(false);
        imageVIP1.setVisible(false);
        imageVIP2.setVisible(true);
        imageMember1.setVisible(true);
        imageMember2.setVisible(false);
    }

    /**
     * 会员等级与折扣按钮监听
     */
    @FXML
    public void workMember(){
        imageSale111.setVisible(true);
        imageSale112.setVisible(false);
        imageVIP1.setVisible(true);
        imageVIP2.setVisible(false);
        imageMember1.setVisible(false);
        imageMember2.setVisible(true);
    }
}

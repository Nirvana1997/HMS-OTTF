package presentation.websalerui;

import businesslogic.logbl.Register;
import businesslogicservice.logblservice.LogBlService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

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
    @FXML
    private AnchorPane doubleOnePane1;
    @FXML
    private AnchorPane doubleOnePane2;

    @FXML
    private AnchorPane VIPPane1;
    @FXML
    private AnchorPane VIPPane2;

    @FXML
    private AnchorPane memberPane1;
    @FXML
    private AnchorPane memberPane2;

    @FXML
    private AnchorPane paneDoubleOne;
    @FXML
    private AnchorPane paneVIP;
    @FXML
    private AnchorPane paneMember;

    static int doubleOneCount = 0;
    static int VIPCount = 0;
    static int memberCount = 0;

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
        paneDoubleOne.setVisible(true);
        paneVIP.setVisible(false);
        paneMember.setVisible(false);

        doubleOnePane1.setVisible(true);
        doubleOnePane2.setVisible(false);

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
        paneDoubleOne.setVisible(false);
        paneVIP.setVisible(true);
        paneMember.setVisible(false);

        VIPPane1.setVisible(true);
        VIPPane2.setVisible(false);

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
        paneDoubleOne.setVisible(false);
        paneVIP.setVisible(false);
        paneMember.setVisible(true);

        memberPane1.setVisible(true);
        memberPane2.setVisible(false);

        imageSale111.setVisible(true);
        imageSale112.setVisible(false);
        imageVIP1.setVisible(true);
        imageVIP2.setVisible(false);
        imageMember1.setVisible(false);
        imageMember2.setVisible(true);
    }

    /**
     * 双11活动下一张
     */
    public void doubleOneNext(){
        doubleOneCount++;
        this.setDoubleOnePane();
    }

    /**
     * 双11活动上一张
     */
    public void doubleOneBefore(){
        doubleOneCount--;
        this.setDoubleOnePane();
    }

    /**
     * 选择双11活动介绍
     */
    private void setDoubleOnePane(){
        doubleOneCount = Math.abs(doubleOneCount);
        if(doubleOneCount % 2 == 0){
            doubleOnePane1.setVisible(true);
            doubleOnePane2.setVisible(false);
        }
        if(doubleOneCount % 2 == 1){
            doubleOnePane1.setVisible(false);
            doubleOnePane2.setVisible(true);
        }
    }

    /**
     * VIP活动下一张
     */
    public void VIPNext(){
        VIPCount++;
        this.setVIPPane();
    }

    /**
     * VIP活动上一张
     */
    public void VIPBefore(){
        VIPCount--;
        this.setVIPPane();
    }

    /**
     * 选择VIP活动介绍
     */
    private void setVIPPane(){
        VIPCount = Math.abs(VIPCount);
        if(VIPCount % 2 == 0){
            VIPPane1.setVisible(true);
            VIPPane2.setVisible(false);
        }
        if(VIPCount % 2 == 1){
            VIPPane1.setVisible(false);
            VIPPane2.setVisible(true);
        }
    }

    /**
     * member活动下一张
     */
    public void memberNext(){
        memberCount++;
        this.setmemberPane();
    }

    /**
     * member活动上一张
     */
    public void memberBefore(){
        memberCount--;
        this.setmemberPane();
    }

    /**
     * 选择VIP活动介绍
     */
    private void setmemberPane(){
        memberCount = Math.abs(memberCount);
        if(memberCount % 2 == 0){
            memberPane1.setVisible(true);
            memberPane2.setVisible(false);
        }
        if(memberCount % 2 == 1){
            memberPane1.setVisible(false);
            memberPane2.setVisible(true);
        }
    }
}

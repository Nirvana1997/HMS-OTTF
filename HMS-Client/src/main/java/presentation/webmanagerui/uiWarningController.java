package presentation.webmanagerui;

import com.sun.org.apache.xerces.internal.util.TeeXMLDocumentFilterImpl;
import com.sun.org.apache.xml.internal.security.Init;
import com.sun.org.glassfish.gmbal.DescriptorFields;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Administrator on 2016/12/9.
 */
public class uiWarningController implements Initializable{
    @FXML
    private Text warningChooseUser;
    @FXML
    private Text warningChooseHotel;
    @FXML
    private Text warningChooseWS;
    @FXML
    private Text warningValid;
    @FXML
    private Text warningFinish;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(uiManageUserController.getChoose()==false){
            warningChooseUser.setVisible(true);
        }
        if(uiManageHSController.getChoose()==false){
            warningChooseHotel.setVisible(true);
        }
        if(uiManageWSController.getChoose()==false){
            warningChooseWS.setVisible(true);
        }

    }
}

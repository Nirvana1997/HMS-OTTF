package presentation.userui;

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
    private Text warningChooseOrder;
    @FXML
    private Text warningChooseHotel;
    @FXML
    private Text warningValid;
    @FXML
    private Text warningFinish;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(uiMyOrderController.getChooseOrder()==false){
            warningChooseOrder.setVisible(true);
        }
        if(uiReadHotelController.getChooseHotel()==false){
            warningChooseHotel.setVisible(true);
        }
        if(uiSearchHotelController.isValid==false){
            warningValid.setVisible(true);
        }
        if(uiSearchHotelController.isFinish==false){
            warningFinish.setVisible(true);
        }
    }
}

package uiLog;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Created by thinkpad on 2016/11/16.
 */
public class uiLogController {

    @FXML
    private Label labelNextPic;
    @FXML
    private ImageView imgHotel01;
    @FXML
    private ImageView imgHotel02;

    @FXML
    public void setNextPic(){
        imgHotel01.setVisible(false);
        imgHotel02.setVisible(true);
    }
}

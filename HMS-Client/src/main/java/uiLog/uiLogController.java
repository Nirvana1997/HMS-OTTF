package uiLog;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Created by thinkpad on 2016/11/16.
 */
public class uiLogController {

    int count = 0;

    @FXML
    private ImageView imgHotel01;
    @FXML
    private ImageView imgHotel02;
    @FXML
    private ImageView imgHotel03;

    @FXML
    public void setNextPic(){
        count++;
        if(count % 3 == 0){
            imgHotel01.setVisible(true);
            imgHotel02.setVisible(false);
            imgHotel03.setVisible(false);
        }
        else if(count % 3 == 1){
            imgHotel01.setVisible(false);
            imgHotel02.setVisible(true);
            imgHotel03.setVisible(false);
        }
        else if(count % 3 == 2){
            imgHotel01.setVisible(false);
            imgHotel02.setVisible(false);
            imgHotel03.setVisible(true);
        }
    }


}

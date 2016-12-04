package presentation.hotelsalerui;

import com.sun.javafx.robot.impl.FXRobotHelper;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by thinkpad on 2016/11/25.
 */
public class SceneHotelSaler {

    public void initUI() throws IOException {
        ObservableList<Stage> stage = FXRobotHelper.getStages();
        Scene scene = new Scene((Parent) FXMLLoader.load(getClass().getResource("hotelSaler_hotelInfo.fxml")));
        stage.get(0).setScene(scene);
    }
}

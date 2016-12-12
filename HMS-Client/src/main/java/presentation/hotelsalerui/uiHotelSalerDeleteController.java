package presentation.hotelsalerui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import presentation.websalerui.*;

/**
 * Created by thinkpad on 2016/12/8.
 */
public class uiHotelSalerDeleteController {

    /**
     * 确认删除按钮
     */
    @FXML
    private Button buttonConfirm;

    /**
     * 取消删除按钮
     */
    @FXML
    private Button buttonCancel;

    /**
     * 确认删除promotion
     */
    public void confirmDelete() {
        presentation.websalerui.SceneJump.isDeletePromotion(true);
        buttonConfirm.getScene().getWindow().hide();
    }

    /**
     * 取消删除promotion
     */
    public void cancelDelete() {
        presentation.websalerui.SceneJump.isDeletePromotion(false);
        buttonCancel.getScene().getWindow().hide();
    }
}

package presentation.websalerui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * Created by thinkpad on 2016/12/7.
 */
public class uiWebSalerDeletePromotionController {

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
        SceneJump.isDeletePromotion(true);
        buttonConfirm.getScene().getWindow().hide();
    }

    /**
     * 取消删除promotion
     */
    public void cancelDelete() {
        SceneJump.isDeletePromotion(false);
        buttonCancel.getScene().getWindow().hide();
    }
}

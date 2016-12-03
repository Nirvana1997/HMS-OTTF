package presentation.hotelsalerui;

import java.io.IOException;

/**
 * Created by thinkpad on 2016/12/3.
 */
public class uiHotelSaleStrategyController {

    private SceneJump sceneJump = new SceneJump();

    /**
     * 酒店信息按钮点击监听
     */
    public void jumpToSceneHotelInfo() throws IOException {
        sceneJump.jumpToSceneHotelInfo();
    }

    /**
     * 酒店订单按钮点击监听
     */
    public void jumpToSceneHotelOrder() throws IOException {
        sceneJump.jumpToSceneHotelOrder();
    }

    /**
     * 酒店房间按钮点击监听
     */
    public void jumpToSceneHotelRoom() throws IOException {
        sceneJump.jumpToSceneHotelRoom();
    }
}

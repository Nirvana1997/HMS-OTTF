package presentation.userui;

import businesslogic.logbl.LogController;

import java.io.IOException;
import java.rmi.RemoteException;

/**
 * Created by Administrator on 2016/12/3.
 */
public class uiHomePageController {

    /**
     * 跳转界面的类
     */
    sceneJump jump = new sceneJump();

    public uiHomePageController() throws RemoteException {
    }

    /**
     * 跳转到首页
     *
     * @throws IOException
     */
    public void gotoHomePage() throws IOException {
        jump.gotoHomePage();
    }

    /**
     * 跳转到我的订单
     *
     * @throws IOException
     */
    public void gotoMyOrder() throws IOException {
        jump.gotoMyOrder();
    }

    /**
     * 跳转到浏览酒店
     *
     * @throws IOException
     */
    public void gotoReadHotel() throws IOException {
        jump.gotoReadHotel();
    }

    /**
     * 跳转到搜索酒店
     *
     * @throws IOException
     */
    public void gotoSearchHotel() throws IOException {
        jump.gotoSearchHotel();
    }

    /**
     * 跳转到个人信息
     *
     * @throws IOException
     */
    public void gotoUserInfo() throws IOException {
        jump.gotoUserInfo();
    }

    /**
     * 清空账号信息，并跳转回登录界面
     *
     * @throws IOException
     */
    public void LogOut() throws IOException {
        LogController logController = new LogController();
        logController.logOut();
        jump.gotoLogin();
    }

}

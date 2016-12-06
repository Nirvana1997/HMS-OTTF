package businesslogic.webmanagerbl;

import businesslogicservice.webmanagerlogicservice.HSmanagementBlService;
import businesslogicservice.webmanagerlogicservice.URmanagementBlService;
import businesslogicservice.webmanagerlogicservice.WSmanagementBlService;
import enumData.ResultMessage;
import vo.HotelsalerInfoVO;
import vo.UserInfoVO;
import vo.WebsalerInfoVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * 网站管理人员模块
 * @author qzh
 * Created by user on 2016/12/2.
 */
public class WebmanagerController implements HSmanagementBlService,URmanagementBlService,WSmanagementBlService{
    /**
     * 酒店工作人员管理模块
     */
    private HSmanagement hSmanagement;

    /**
     * 用户信息管理模块
     */
    private URmanagement uRmanagement;

    /**
     * 网站营销人员管理模块
     */
    private WSmanagement wSmanagement;

    @Override
    public WebsalerInfoVO getWebsaleInfo(String websalerID) {
        return null;
    }

    @Override
    public ResultMessage setWebsalerInfo(WebsalerInfoVO vo) {
        return null;
    }

    @Override
    public boolean addWebsalerInfo(WebsalerInfoVO vo, String password) {
        return false;
    }

    @Override
    public ResultMessage deleteWebsalerInfo(String websalerID) {
        return null;
    }

    @Override
    public UserInfoVO getUserInfo(String userID) throws RemoteException {
        return null;
    }

    @Override
    public void setUserInfo(UserInfoVO vo) {
    }

    @Override
    public ArrayList<UserInfoVO> getUserList() {
        return null;
    }

    @Override
    public HotelsalerInfoVO getHotelsalerInfo(String hotelsalerID) throws RemoteException {
        return null;
    }

    @Override
    public ResultMessage setHotelsalerInfo(HotelsalerInfoVO vo) throws RemoteException {
        return null;
    }

    @Override
    public boolean addHotelsalerInfo(HotelsalerInfoVO vo, String password) throws RemoteException {
        return false;
    }

    @Override
    public ResultMessage deleteHotelsalerVO(String hotelsalerID) throws RemoteException {
        return null;
    }
}

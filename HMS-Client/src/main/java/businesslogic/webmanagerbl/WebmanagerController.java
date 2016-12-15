package businesslogic.webmanagerbl;

import businesslogicservice.webmanagerlogicservice.AccountBlService;
import businesslogicservice.webmanagerlogicservice.HSmanagementBlService;
import businesslogicservice.webmanagerlogicservice.URmanagementBlService;
import businesslogicservice.webmanagerlogicservice.WSmanagementBlService;
import enumData.ResultMessage;
import vo.HotelinfoVO;
import vo.UserInfoVO;
import vo.WebsalerInfoVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * 网站管理人员模块
 * @author qzh
 * Created by user on 2016/12/2.
 */
public class WebmanagerController implements HSmanagementBlService,URmanagementBlService,WSmanagementBlService,AccountBlService{
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

    private AccountOperation accountOperation;

    public WebmanagerController() throws RemoteException {
        hSmanagement = new HSmanagement();
        uRmanagement = new URmanagement();
        wSmanagement = new WSmanagement();
        accountOperation = new AccountOperation();
    }

    /**
     * 获得网站营销人员信息
     *
     * @param websalerID 网站营销人员编号
     * @return 网站营销人员信息
     */
    @Override
    public WebsalerInfoVO getWebsalerInfo(String websalerID) throws RemoteException {
        return wSmanagement.getWebsaleInfo(websalerID);
    }

    /**
     * 设置网站营销人员信息
     *
     * @param vo 网站营销人员信息
     */
    @Override
    public ResultMessage setWebsalerInfo(WebsalerInfoVO vo) throws RemoteException {
        return wSmanagement.setWebsalerInfo(vo);
    }

    /**
     * 添加网站营销人员信息和帐号
     *
     * @param vo       网站营销人员信息
     * @param account  帐号
     * @param password 密码
     */
    @Override
    public boolean addWebsalerInfoAndAccount(WebsalerInfoVO vo,String account, String password) throws RemoteException {
        return wSmanagement.addWebsalerInfoAndAccount(vo,account,password);
    }

    /**
     * 删除网站营销人员信息
     *
     * @param websalerID 网站营销人员编号
     * @return 是否成功
     */
    @Override
    public ResultMessage deleteWebsalerInfoAndAccount(String websalerID) throws RemoteException {
        return wSmanagement.deleteWebsalerInfo(websalerID);
    }

    /**
     * 获得所有网站营销人员的信息
     *
     * @return 网站营销人员信息列表
     * @throws RemoteException
     */
    @Override
    public ArrayList<WebsalerInfoVO> getWebsalerInfoList() throws RemoteException {
        return wSmanagement.getWebsalerInfoList();
    }

    /**
     * 获取用户信息
     *
     * @param userID 用户ID
     * @return 对应用户信息
     * @throws RemoteException
     */
    @Override
    public UserInfoVO getUserInfo(String userID) throws RemoteException {
        return uRmanagement.getUserInfo(userID);
    }

    /**
     * 修改用户信息
     *
     * @param vo 用户个人信息vo
     */
    @Override
    public void setUserInfo(UserInfoVO vo) throws RemoteException {
        uRmanagement.setUserInfo(vo);
    }

    @Override
    public ArrayList<UserInfoVO> getUserList() throws RemoteException {
        return uRmanagement.getUserList();
    }

    @Override
    public ArrayList<HotelinfoVO> getHotellist() throws RemoteException {
        return hSmanagement.getHotellist();
    }

    @Override
    public HotelinfoVO getHotelinfo(String hotelsalerID) throws RemoteException {
        return hSmanagement.getHotelinfo(hotelsalerID);
    }

    @Override
    public ResultMessage setHotelinfo(HotelinfoVO vo) throws RemoteException {
        hSmanagement.setHotelinfo(vo);
        return ResultMessage.Correct;
    }

    @Override
    public boolean addHotelinfo(HotelinfoVO vo) throws RemoteException {
        hSmanagement.addHotelinfoAndRoom(vo);
        return true;
    }

    @Override
    public ResultMessage deleteHotelinfo(String hotelsalerID) throws RemoteException {
        hSmanagement.deleteHotel(hotelsalerID);
        return ResultMessage.Correct;
    }

    @Override
    public String getAccount(String id) throws RemoteException {
        return accountOperation.getAccount(id);
    }
}

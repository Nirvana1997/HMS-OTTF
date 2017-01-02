package businesslogic.webmanagerbl;

import businesslogic.logbl.impl.AccountInfoImpl;
import businesslogic.webmanagerbl.interfaces.AccountInfo;
import businesslogic.webmanagerbl.interfaces.WebsalerInfoForManagement;
import businesslogic.websalerbl.impl.WebsalerInfoImpl;
import enumData.AccountType;
import enumData.ResultMessage;
import vo.WebsalerInfoVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * 网站营销人员管理模块
 *
 * @author qzh
 */
public class WSmanagement {
    /**
     * 网站营销人员信息管理模块
     */
    WebsalerInfoForManagement websalerInfoForManagement;

    /**
     * 帐号信息管理模块
     */
    AccountInfo accountInfo;

    public WSmanagement() throws RemoteException {
        websalerInfoForManagement = new WebsalerInfoImpl();
        accountInfo = new AccountInfoImpl();
    }

    /**
     * 获得网站营销人员信息
     *
     * @param websalerID 网站营销人员编号
     * @return 网站营销人员信息
     */
    public WebsalerInfoVO getWebsaleInfo(String websalerID) throws RemoteException {
        return websalerInfoForManagement.getWebsalerInfo(websalerID);
    }

    /**
     * 设置网站营销人员信息
     *
     * @param vo 网站营销人员信息
     */
    public ResultMessage setWebsalerInfo(WebsalerInfoVO vo) throws RemoteException {
        websalerInfoForManagement.setWebsalerInfo(vo);
        return ResultMessage.Correct;
    }

    /**
     * 添加网站营销人员信息和帐号
     *
     * @param vo       网站营销人员信息
     * @param account  帐号
     * @param password 密码
     * @return 是否成功
     */
    public boolean addWebsalerInfoAndAccount(WebsalerInfoVO vo, String account, String password) throws RemoteException {
        accountInfo.addAccount(account, password, AccountType.websaler);
        vo.setWebsalerID(accountInfo.getID(account));
        websalerInfoForManagement.addWebsalerInfo(vo);
        return true;
    }

    /**
     * 删除网站营销人员信息
     *
     * @param websalerID 网站营销人员编号
     * @return 是否成功
     */
    public ResultMessage deleteWebsalerInfo(String websalerID) throws RemoteException {
        websalerInfoForManagement.deleteWebsalerInfo(websalerID);
        accountInfo.deleteAccount(websalerID);
        return ResultMessage.Correct;
    }

    /**
     * 获得所有网站营销人员的信息
     *
     * @return 网站营销人员信息列表
     * @throws RemoteException
     */
    public ArrayList<WebsalerInfoVO> getWebsalerInfoList() throws RemoteException {
        return websalerInfoForManagement.getWebsalerInfoList();
    }

}

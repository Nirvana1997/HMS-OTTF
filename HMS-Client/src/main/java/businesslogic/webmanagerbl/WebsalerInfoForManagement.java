package businesslogic.webmanagerbl;

import vo.WebsalerInfoVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * 网站营销人员数据接口
 *
 * @author qzh
 *         Created by user on 2016/12/9.
 */
public interface WebsalerInfoForManagement {
    /**
     * 获得所有网站营销人员信息
     *
     * @return 网站营销人员信息列表
     */
    ArrayList<WebsalerInfoVO> getWebsalerInfoList()throws RemoteException;

    /**
     * 获得网站营销人员信息
     *
     * @param websalerID 网站营销人员编号
     * @return 网站营销人员信息
     */
    WebsalerInfoVO getWebsalerInfo(String websalerID)throws RemoteException;

    /**
     * 设置网站营销人员信息
     *
     * @param websalerInfoVO 网站营销人员信息
     */
    void setWebsalerInfo(WebsalerInfoVO websalerInfoVO)throws RemoteException;

    /**
     * 添加网站营销人员信息
     *
     * @param websalerInfoVO 网站营销人员信息
     */
    void addWebsalerInfo(WebsalerInfoVO websalerInfoVO)throws RemoteException;

    /**
     * 删除网站营销人员信息
     *
     * @param websalerID 网站营销人员编号
     */
    void deleteWebsalerInfo(String websalerID)throws RemoteException;
}

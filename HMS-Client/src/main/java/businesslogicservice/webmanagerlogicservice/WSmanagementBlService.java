package businesslogicservice.webmanagerlogicservice;

import enumData.ResultMessage;
import vo.WebsalerInfoVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

public interface WSmanagementBlService {
	/**
	 * 获得网站营销人员信息
	 *
	 * @param websalerID 网站营销人员编号
	 * @return 网站营销人员信息
	 */
	WebsalerInfoVO getWebsalerInfo(String websalerID) throws RemoteException;

	/**
	 * 设置网站营销人员信息
	 *
	 * @param vo 网站营销人员信息
	 */
	ResultMessage setWebsalerInfo(WebsalerInfoVO vo) throws RemoteException;

	/**
	 * 添加网站营销人员信息和帐号
	 *
	 * @param vo       网站营销人员信息
	 * @param account  帐号
	 * @param password 密码
	 */
	public boolean addWebsalerInfoAndAccount(WebsalerInfoVO vo, String account,String password) throws RemoteException;

	/**
	 * 删除网站营销人员信息及其帐号
	 *
	 * @param websalerID 网站营销人员编号
	 */
	ResultMessage deleteWebsalerInfoAndAccount(String websalerID) throws RemoteException;

	/**
	 * 获得所有网站营销人员信息
	 *
	 * @return 网站营销人员信息列表
	 */
	ArrayList<WebsalerInfoVO> getWebsalerInfoList()throws RemoteException;
}

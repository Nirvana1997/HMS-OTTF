package dataservice.websalerdataservice;

import enumData.ResultMessage;
import po.VipUpPO;
import po.WebsalerInfoPO;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface WebsalerDataService extends Remote {
	/**
	 * 根据网站营销人员ID，获取网站营销人员信息
	 * @param websalerID 网站营销人员ID
	 * @return 网站营销人员信息的PO
     */
	public WebsalerInfoPO getWebsalerInfo(String websalerID) throws RemoteException;

	/**
	 * 修改网站营销人员信息
	 * @param po 网站营销人员信息PO
	 * @return 结果信息
     */
	public ResultMessage setWebsalerInfo(WebsalerInfoPO po)throws RemoteException;

	/**
	 * 添加网站营销人员信息
	 * @param po 网站营销人员信息PO
	 * @return 结果信息
     */
	public ResultMessage addWebsalerInfo(WebsalerInfoPO po)throws RemoteException;

	/**
	 * 删除网站营销人员信息
	 * @param websalerID 网站营销人员ID
	 * @return 结果信息
     */
	public ResultMessage deleteWebsalerInfo(String websalerID)throws RemoteException;

	/**
	 * 得到网站营销人员信息列表（所有营销人员）
	 * @return 网站营销人员信息列表
	 * @throws RemoteException
     */
	public ArrayList<WebsalerInfoPO> getWebsalerInfoList()throws RemoteException;

	/**
	 * 修改会员升级列表
	 * @param po 会员升级信息PO
	 * @return 结果信息
     */
	public ResultMessage setVipUpInfo(VipUpPO po)throws RemoteException;

	/**
	 * 查看会员升级列表
	 * @return 会员升级信息PO的列表
     */
	public ArrayList<VipUpPO> checkVipUpInfo()throws RemoteException;
}

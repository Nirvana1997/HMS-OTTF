package dataservice.websalerdataservice;

import enumData.ResultMessage;
import po.*;

import java.util.ArrayList;

public interface WebsalerDataService {
	/**
	 * 根据网站营销人员ID，获取网站营销人员信息
	 * @param websalerID
	 * @return
     */
	public WebsalerInfoPO getWebsalerInfo(String websalerID);

	/**
	 * 修改网站营销人员信息
	 * @param po
	 * @return
     */
	public ResultMessage setWebsalerInfo(WebsalerInfoPO po);

	/**
	 * 添加网站营销人员信息
	 * @param po
	 * @return
     */
	public ResultMessage addWebsalerInfo(WebsalerInfoPO po);

	/**
	 * 删除网站营销人员信息
	 * @param websalerID
	 * @return
     */
	public ResultMessage deleteWebsalerInfo(String websalerID);

	/**
	 * 修改会员升级列表
	 */
	public void setVipList(ArrayList<CreditRecordPO> vipLevels);

	/**
	 * 查看会员升级列表
	 */
	public ArrayList<CreditRecordPO> getVipList();
}

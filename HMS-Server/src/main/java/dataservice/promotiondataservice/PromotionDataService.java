package dataservice.promotiondataservice;

import enumData.PromotionType;
import enumData.ResultMessage;
import po.*;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface PromotionDataService extends Remote {
	/**
	 * 增加营销策略
	 * @param po 营销策略PO
	 * @return 结果信息
     */
	public ResultMessage addPromotion(PromotionPO po)throws RemoteException;

	/**
	 * 删除营销策略
	 * @param name 营销策略名字
	 * @return 结果信息
     */
	public ResultMessage deletePromotion(String name)throws RemoteException;

	/**
	 * 修改营销策略
	 * @param po 营销策略PO
	 * @return 结果信息
     */
	public ResultMessage changePromotion(PromotionPO po)throws RemoteException;

	/**
	 * 根据策略名字，获得对应营销策略的详细信息（po）
	 * @param promotionName 营销策略名字
	 * @return 营销策略PO
	 * @throws RemoteException
     */
	public PromotionPO getPromotionInfo(String promotionName)throws RemoteException;

	/**
	 * 根据策略类型，获取营销策略列表
	 * @param type 营销策略的类型
	 * @return 营销策略PO的列表
     */
	public ArrayList<PromotionPO> getPromotionList(PromotionType type)throws RemoteException;

	/**
	 * 根据营销策略类型和酒店ID，获取营销策略列表
	 * @param type 营销策略的类型
	 * @param hotelID 酒店ID
     * @return 营销策略PO的列表
     */
	public ArrayList<PromotionPO> getPromotionList(PromotionType type,String hotelID)throws RemoteException;
}

package businesslogicservice.promotionblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import enumData.PromotionType;
import enumData.ResultMessage;
import vo.PromotionVO;

public interface PromotionBlService {
	
	public ArrayList<PromotionVO> getPromotionList(PromotionType promotionType,String account) throws RemoteException;
	
	public PromotionVO getPromotion(String promotionID) throws RemoteException;
	
	public ResultMessage setPromotion(PromotionVO vo) throws RemoteException;
	
	public ResultMessage addPromotion(PromotionVO vo) throws RemoteException;
	
	public ResultMessage deletePromotion(String promotionID) throws RemoteException;
}

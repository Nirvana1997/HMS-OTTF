package businesslogic.hotelsalerbl.impl;

import businesslogic.userbl.interfaces.CommentInfo;
import dataservice.hotelsalerdataservice.HotelinfoDataService;
import po.CommentPO;
import rmi.RemoteHelper;
import utility.CommentPVChanger;
import vo.CommentVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * 评价信息实现
 * @author qzh
 * Created by user on 2016/12/7.
 */
public class CommentInfoImpl implements CommentInfo{
    HotelinfoDataService hotelinfoDataService;

    public CommentInfoImpl() {
        //TODO
//        hotelinfoDataService = new HotelinfoDataImpl_stub();
        hotelinfoDataService = RemoteHelper.getInstance().getHotelinfoDataService();
    }

    /**
     * 生成评价
     * @param vo 评价信息
     */
    @Override
    public void makeComment(CommentVO vo) throws RemoteException {
        hotelinfoDataService.addComments(CommentPVChanger.commentV2P(vo));
    }

    /**
     * 获得对应酒店评价信息
     * @param hotelID 酒店id
     * @return 酒店评价信息
     * @throws RemoteException
     */
    @Override
    public ArrayList<CommentVO> getComments(String hotelID) throws RemoteException {
        ArrayList<CommentVO> res = new ArrayList<>();
        for(CommentPO po:hotelinfoDataService.getComments(hotelID)){
            res.add(CommentPVChanger.commentP2V(po));
        }
        return res;
    }
}

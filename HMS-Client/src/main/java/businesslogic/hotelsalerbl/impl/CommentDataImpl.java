package businesslogic.hotelsalerbl.impl;

import businesslogic.userbl.interfaces.CommentInfo;
import data_stub.hotelsalerdata.HotelinfoDataImpl_stub;
import dataservice.hotelsalerdataservice.HotelinfoDataService;
import utility.CommentPVChanger;
import vo.CommentVO;

import java.rmi.RemoteException;

/**
 * 评价信息实现
 * @author qzh
 * Created by user on 2016/12/7.
 */
public class CommentDataImpl implements CommentInfo{
    HotelinfoDataService hotelinfoDataService;

    public CommentDataImpl() {
        hotelinfoDataService = new HotelinfoDataImpl_stub();
    }

    /**
     * 生成评价
     * @param vo 评价信息
     */
    @Override
    public void makeComment(CommentVO vo) throws RemoteException {
        hotelinfoDataService.addComments(CommentPVChanger.commentV2P(vo));
    }
}

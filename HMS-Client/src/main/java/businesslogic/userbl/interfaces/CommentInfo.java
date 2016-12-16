package businesslogic.userbl.interfaces;

import vo.CommentVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * 评价接口
 * @author qzh
 * Created by user on 2016/12/7.
 */
public interface CommentInfo {
    /**
     * 生成评价
     * @param vo 评价信息
     */
    public void makeComment(CommentVO vo) throws RemoteException;

    /**
     * 获得对应酒店评价信息
     * @param hotelID 酒店id
     * @return 评价信息
     * @throws RemoteException
     */
    public ArrayList<CommentVO> getComments(String hotelID)throws RemoteException;
}

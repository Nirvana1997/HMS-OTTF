package businesslogic.userbl.interfaces;

import vo.CommentVO;

import java.rmi.RemoteException;

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
}

package utility;

import po.CommentPO;
import vo.CommentVO;

/**
 * 负责评价PO、VO转换
 * @author qzh
 * Created by user on 2016/12/7.
 */
public class CommentPVChanger {
    /**
     * 评价信息PO转VO
     * @param po 评价PO
     * @return 评价VO
     */
    public static CommentVO commentP2V(CommentPO po){
        if(po==null){
            return null;
        }
        return new CommentVO(po.getHotelID(),po.getUserID(),po.getComment(),po.getGrade());
    }

    /**
     * 评价信息VO转PO
     * @param vo 评价VO
     * @return 评价
     */
    public static CommentPO commentV2P(CommentVO vo){
        if(vo==null){
            return null;
        }
        return new CommentPO(vo.getHotelID(),vo.getUserID(),vo.getComment(),vo.getGrade());
    }
}

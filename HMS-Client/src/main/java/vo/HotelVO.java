package vo;

import java.util.ArrayList;

/**
 * 酒店详细信息整合
 * 包含酒店基本信息、酒店房间数目、酒店促销策略
 * Created by user on 2016/11/29.
 */
public class HotelVO {
    private HotelinfoVO hotelinfoVO;
    private ArrayList<HotelroomVO> hotelroomList;
    private ArrayList<CommentVO> commentList;
    private ArrayList<HotelPromotionVO> hotelPromotionList;

    public HotelVO(HotelinfoVO hotelinfoVO, ArrayList<HotelroomVO> hotelroomList, ArrayList<CommentVO> commentList, ArrayList<HotelPromotionVO> hotelPromotionList) {
        this.hotelinfoVO = hotelinfoVO;
        this.hotelroomList = hotelroomList;
        this.commentList = commentList;
        this.hotelPromotionList = hotelPromotionList;
    }

    public HotelinfoVO getHotelinfoVO() {
        return hotelinfoVO;
    }

    public void setHotelinfoVO(HotelinfoVO hotelinfoVO) {
        this.hotelinfoVO = hotelinfoVO;
    }

    public ArrayList<HotelroomVO> getHotelroomList() {
        return hotelroomList;
    }

    public void setHotelroomList(ArrayList<HotelroomVO> hotelroomList) {
        this.hotelroomList = hotelroomList;
    }

    public ArrayList<CommentVO> getCommentList() {
        return commentList;
    }

    public void setCommentList(ArrayList<CommentVO> commentList) {
        this.commentList = commentList;
    }

    public ArrayList<HotelPromotionVO> getHotelPromotionList() {
        return hotelPromotionList;
    }

    public void setHotelPromotionList(ArrayList<HotelPromotionVO> hotelPromotionList) {
        this.hotelPromotionList = hotelPromotionList;
    }
}

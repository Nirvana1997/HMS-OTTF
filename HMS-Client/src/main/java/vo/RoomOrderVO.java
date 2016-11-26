package vo;

import enumData.RoomType;

import java.util.Date;

/**
 * 用于记录每一次订单导致的房间数量变化
 * @author qzh
 * Created by user on 2016/11/22.
 */
public class RoomOrderVO {
    Date startDate;
    Date endDate;
    RoomType roomType;
}

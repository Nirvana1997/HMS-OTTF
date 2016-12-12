package vo;

import enumData.LimitCriterion;
import enumData.RoomType;

import java.util.Date;

/**
 * 搜索限制条件
 *
 * @author qzh
 */
public class LimitVO {
    /**
     * 属性
     */
    private LimitCriterion limitCriterion;

    /**
     * 房间类型
     */
    private RoomType roomType;

    /**
     * 数目
     */
    private int num;

    /**
     * 上限
     */
    private double max;

    /**
     * 下限
     */
    private double min;

    /**
     * 关键字
     */
    private String keyword;

    /**
     * 入住日期
     */
    private Date startDate;

    /**
     * 退房日期
     */
    private Date endDate;

    /**
     * 针对使用区间来限制的条件
     *
     * @param limitCriterion 限制条件
     * @param max            上限
     * @param min            下限
     */
    public LimitVO(LimitCriterion limitCriterion, double min, double max) {
        this.limitCriterion = limitCriterion;
        this.max = max;
        this.min = min;
    }

    /**
     * 针对房间价格和数量区间来限制的条件
     *
     * @param limitCriterion 限制条件
     * @param roomType       房间类型
     * @param max            上限
     * @param min            下限
     * @param num            数量
     * @param startDate      入住日期
     * @param endDate        退房日期
     */
    public LimitVO(LimitCriterion limitCriterion, RoomType roomType, double min, double max, int num, Date startDate, Date endDate) {
        this.limitCriterion = limitCriterion;
        this.max = max;
        this.min = min;
        this.num = num;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    /**
     * 针对使用关键字来限制的条件
     *
     * @param limitCriterion 限制条件
     * @param keyword        关键字
     */
    public LimitVO(LimitCriterion limitCriterion, String keyword) {
        this.limitCriterion = limitCriterion;
        this.keyword = keyword;
    }

    public LimitCriterion getLimitCriterion() {
        return limitCriterion;
    }

    public void setLimitCriterion(LimitCriterion limitCriterion) {
        this.limitCriterion = limitCriterion;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
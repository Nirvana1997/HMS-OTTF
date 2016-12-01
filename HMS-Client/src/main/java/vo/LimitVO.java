package vo;

import enumData.LimitCriterion;

/**
 * 搜索限制条件
 * @author qzh
 */
public class LimitVO {
	/**
	 * 属性
	 */
	private LimitCriterion limitCriterion;

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
	 * 针对使用区间来限制的条件
	 * @param limitCriterion
	 * @param max
	 * @param min
	 */
	public LimitVO(LimitCriterion limitCriterion, double max, double min) {
		this.limitCriterion = limitCriterion;
		this.max = max;
		this.min = min;
	}

	/**
	 * 针对使用关键字来限制的条件
	 * @param limitCriterion
	 * @param keyword
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
}
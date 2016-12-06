package po;

/**
 * Created by mac on 2016/12/3.
 */
public class VipUpPO {
    int vipLevel;
    int credit;

    public VipUpPO(int vipLevel, int credit) {
        this.vipLevel = vipLevel;
        this.credit = credit;
    }

    public int getVipLevel() {
        return vipLevel;
    }

    public void setVipLevel(int vipLevel) {
        this.vipLevel = vipLevel;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }
}

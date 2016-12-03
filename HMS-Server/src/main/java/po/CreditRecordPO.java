package po;

/**
 * Created by mac on 2016/12/3.
 */
public class CreditRecordPO {
    String date;
    int change;
    int finalCredit;

    public CreditRecordPO(String date, int change, int finalCredit) {
        this.date = date;
        this.change = change;
        this.finalCredit = finalCredit;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getChange() {
        return change;
    }

    public void setChange(int change) {
        this.change = change;
    }

    public int getFinalCredit() {
        return finalCredit;
    }

    public void setFinalCredit(int finalCredit) {
        this.finalCredit = finalCredit;
    }
}

package vo;

import enumData.AccountType;

/**
 * Created by user on 2016/11/25.
 */
public class HotelsalerAccountVO extends AccountVO{
    HotelinfoVO hotelinfoVO;
    public HotelsalerAccountVO(String accountID, String password, AccountType type, HotelinfoVO vo) {
        super(accountID, password, type);
        this.hotelinfoVO = hotelinfoVO;
    }

    public HotelinfoVO getHotelinfoVO() {
        return hotelinfoVO;
    }

    public void setHotelinfoVO(HotelinfoVO hotelinfoVO) {
        this.hotelinfoVO = hotelinfoVO;
    }
}

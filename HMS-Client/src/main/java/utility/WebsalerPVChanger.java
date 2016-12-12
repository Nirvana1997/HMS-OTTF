package utility;

import po.WebsalerInfoPO;
import vo.WebsalerInfoVO;

/**
 * 网站营销人员PO、VO转化
 *
 * @author qzh
 *         Created by user on 2016/12/9.
 */
public class WebsalerPVChanger {
    /**
     * 网站营销人员PO转VO
     *
     * @param po 网站营销人员PO
     * @return 网站营销人员VO
     */
    public static WebsalerInfoVO websalerInfoP2V(WebsalerInfoPO po) {
        return new WebsalerInfoVO(po.getWebsalerID(), po.getContactNumber());
    }

    /**
     * 网站营销人员VO转PO
     *
     * @param vo 网站营销人员VO
     * @return 网站营销人员PO
     */
    public static WebsalerInfoPO websalerInfoV2P(WebsalerInfoVO vo) {
        return new WebsalerInfoPO(vo.getWebsalerID(), vo.getContactNumber());
    }
}

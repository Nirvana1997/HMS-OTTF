package test.businesslogic.websalerbl;

import businesslogic.promotionbl.Promotion;
import businesslogic.websalerbl.WebsalerController;
import dataservice.websalerdataservice.WebsalerDataService;
import enumData.PromotionType;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import po.PromotionPO;
import vo.PromotionVO;

/**
 * WebsalerController Tester.
 *
 * @author <Authors name> qzh
 * @version 1.0
 * @since <pre>十二月 11, 2016</pre>
 */
public class WebsalerControllerTest {

    WebsalerController websalerController;

    @Before
    public void before() throws Exception {
        websalerController = new WebsalerController();
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: makePromotion(PromotionVO vo)
     */
    @Test
    public void testMakePromotion() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: makeListPromotion(ArrayList<PromotionVO> promotions)
     */
    @Test
    public void testMakeListPromotion() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: getPromotionList(PromotionType promotionType)
     */
    @Test
    public void testGetPromotionList() throws Exception {
        for(PromotionType type:PromotionType.values()){
            if(type.toString().startsWith("Web")){
                for(PromotionVO vo:websalerController.getPromotionList(type)){
                    Assert.assertEquals(type,vo.getPromotionType());
                }
            }
        }
    }

    /**
     * Method: cancelPromotion(String promotionName)
     */
    @Test
    public void testCancelPromotion() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: addCredit(String userID, int value)
     */
    @Test
    public void testAddCredit() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: getCredit(String userID)
     */
    @Test
    public void testGetCredit() throws Exception {
//TODO: Test goes here... 
    }


} 

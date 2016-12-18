import businesslogic.websalerbl.WebsalerController;
import businesslogicservice.websalerblservice.WebsalerblService;
import enumData.PromotionType;
import enumData.TradeArea;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import po.PromotionPO;
import utility.DateOperation;
import vo.PromotionVO;

import java.util.ArrayList;
import java.util.Date;

/**
 * WebsalerController Tester.
 *
 * @author <Authors name> qzh
 * @version 1.0
 * @since <pre>十二月 11, 2016</pre>
 */
public class WebsalerBlTest {

    WebsalerblService websalerblService;

    @Before
    public void before() throws Exception {
        websalerblService = new WebsalerController();
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: makePromotion(PromotionVO vo)
     */
    @Test
    public void testMakePromotion() throws Exception {
        PromotionVO vo = new PromotionVO("haha","2333",PromotionType.Web_Period, DateOperation.stringToDate("2016_1_4"),DateOperation.stringToDate("2016_1_7"), TradeArea.Changjiang,0.5);
        websalerblService.makePromotion(vo);
        boolean exist = false;
        for(PromotionVO v:websalerblService.getPromotionList(PromotionType.Web_Period)){
            if(v.getPromotionName().equals("haha")){
                exist = true;
                break;
            }
        }
        Assert.assertEquals(true,exist);
    }

    /**
     * Method: makeListPromotion(ArrayList<PromotionVO> promotions)
     */
    @Test
    public void testMakeListPromotion() throws Exception {
        ArrayList<PromotionVO> vips = new ArrayList<PromotionVO>();
        vips.add(new PromotionVO("vip","discount if you are vip",PromotionType.Web_Vip,DateOperation.stringToDate("2016_11_11"),DateOperation.stringToDate("2016_12_12"),1,0.9));
        vips.add(new PromotionVO("vip","discount if you are vip",PromotionType.Web_Vip,DateOperation.stringToDate("2016_11_11"),DateOperation.stringToDate("2016_12_12"),2,0.8));
        vips.add(new PromotionVO("vip","discount if you are vip",PromotionType.Web_Vip,DateOperation.stringToDate("2016_11_11"),DateOperation.stringToDate("2016_12_12"),3,0.7));
        websalerblService.makeListPromotion(vips);
        for(PromotionVO v:websalerblService.getPromotionList(PromotionType.Web_Vip)){
            if(v.getPromotionName().equals("vip")||v.getVipLevel()==3){
                Assert.assertEquals(0.7,v.getDiscount(),0.01);
                break;
            }
        }
    }

    /**
     * Method: getPromotionList(PromotionType promotionType)
     */
    @Test
    public void testGetPromotionList() throws Exception {
        for(PromotionType type:PromotionType.values()){
            if(type.toString().startsWith("Web")){
                for(PromotionVO vo: websalerblService.getPromotionList(type)){
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
        boolean exist = false;
        for(PromotionVO v:websalerblService.getPromotionList(PromotionType.Web_Period)){
            if(v.getPromotionName().equals("Web Period")){
                exist = true;
                break;
            }
        }
        Assert.assertEquals(true,exist);

        websalerblService.cancelPromotion("Web Period");

        exist = false;
        for(PromotionVO v:websalerblService.getPromotionList(PromotionType.Web_Period)){
            if(v.getPromotionName().equals("Web Period")){
                exist = true;
                break;
            }
        }
        Assert.assertEquals(false,exist);
    }

    /**
     * Method: addCredit(String userID, int value)
     */
    @Test
    public void testAddCredit() throws Exception {
        websalerblService.addCredit("0100001",1);
        Assert.assertEquals(1300,websalerblService.getCredit("0100001"));
    }

    /**
     * Method: getCredit(String userID)
     */
    @Test
    public void testGetCredit() throws Exception {
        Assert.assertEquals(1200,websalerblService.getCredit("0100001"));
        Assert.assertEquals(2200,websalerblService.getCredit("0100002"));
        Assert.assertEquals(3200,websalerblService.getCredit("0100003"));
        Assert.assertEquals(2000,websalerblService.getCredit("0100004"));

    }


} 

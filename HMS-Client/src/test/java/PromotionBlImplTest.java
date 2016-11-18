import businesslogic.promotionbl.PromotionBlImpl;
import businesslogicservice.promotionblservice.PromotionBlService;
import enumData.PromotionType;
import enumData.ResultMessage;
import enumData.TradeArea;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import vo.PromotionVO;

import java.util.ArrayList;
import java.util.Date;

/** 
* PromotionBlImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>十一月 13, 2016</pre>
* @version 1.0 
*/ 
public class PromotionBlImplTest {
    PromotionBlService promotionBlService;
    ArrayList<Double> discount;
    TradeArea[] area;
    PromotionVO promotion1 = new PromotionVO("0004", PromotionType.fesPromotion, new Date(2016,11,13), new Date(2016,11,15),area ,discount, 9.0 ,"0001");
    PromotionVO promotion2 = new PromotionVO("0002", PromotionType.memPromotion, new Date(2016,11,13), new Date(2016,11,15),area ,discount, 9.0 ,"0001");
    PromotionVO promotion3 = new PromotionVO("0002", PromotionType.hotelPromotion, new Date(2016,11,13), new Date(2016,11,15),area ,discount, 9.0 , "0002");

    public PromotionBlImplTest() {

    discount =new ArrayList<Double>();
    discount.add(0,9.0);
    discount.add(1,9.1);
    area =new TradeArea[2];
    area[0]=TradeArea.XuanQuan;
    area[1]=TradeArea.Xianlin;
}

    @Before
public void before() throws Exception {
    promotionBlService = new PromotionBlImpl();

} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: getPromotionList(PromotionType type, String account) 
* 
*/ 
@Test
public void testGetPromotionList() throws Exception { 
//TODO: Test goes here...
    Assert.assertEquals("0001",promotionBlService.getPromotionList(PromotionType.fesPromotion,"0001").get(0).getHotelID());
    Assert.assertEquals("0002",promotionBlService.getPromotionList(PromotionType.memPromotion,"0001").get(0).getHotelID());
    Assert.assertEquals("0003",promotionBlService.getPromotionList(PromotionType.hotelPromotion,"0002").get(0).getHotelID());
} 

/** 
* 
* Method: getPromotion(String promotionID) 
* 
*/ 
@Test
public void testGetPromotion() throws Exception { 
//TODO: Test goes here...

} 

/** 
* 
* Method: setPromotion(PromotionVO vo) 
* 
*/ 
@Test
public void testSetPromotion() throws Exception { 
//TODO: Test goes here...
    Assert.assertEquals(ResultMessage.InCorrect,promotionBlService.setPromotion(promotion1));
    Assert.assertEquals(ResultMessage.Correct,promotionBlService.setPromotion(promotion2));
    Assert.assertEquals(ResultMessage.Correct,promotionBlService.setPromotion(promotion3));
} 

/** 
* 
* Method: addPromotion(PromotionVO vo) 
* 
*/ 
@Test
public void testAddPromotion() throws Exception { 
//TODO: Test goes here...
    Assert.assertEquals(ResultMessage.Correct,promotionBlService.addPromotion(promotion2));
    Assert.assertEquals(ResultMessage.Correct,promotionBlService.addPromotion(promotion3));
} 

/** 
* 
* Method: deletePromotion(String promotionID) 
* 
*/ 
@Test
public void testDeletePromotion() throws Exception { 
//TODO: Test goes here...
    Assert.assertEquals(ResultMessage.Correct,promotionBlService.deletePromotion("0001"));
    Assert.assertEquals(ResultMessage.Correct,promotionBlService.deletePromotion("0002"));
} 


} 

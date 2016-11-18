import businesslogic.websalerbl.WebsalerblImpl;
import businesslogicservice.websalerblservice.WebsalerblService;
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
* WebsalerblImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>十一月 13, 2016</pre>
* @version 1.0 
*/ 
public class WebsalerblImplTest {
    WebsalerblService websalerblService = new WebsalerblImpl();
    TradeArea[] area = new TradeArea[2];
    ArrayList<Double> discount =new ArrayList<Double>();


@Before
public void before() throws Exception {
    area[0]=TradeArea.XuanQuan;
    area[1]=TradeArea.Xianlin;
    discount.add(0,9.0);
    discount.add(1,9.1);
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: makeFestivalPromotion(PromotionVO vo) 
* 
*/ 
@Test
public void testMakeFestivalPromotion() throws Exception {
    PromotionVO vo = new PromotionVO("0001", PromotionType.fesPromotion, new Date(2016,11,13), new Date(2016,11,15),area ,discount, 9.0 ,"0001");
    Assert.assertEquals(ResultMessage.Correct,websalerblService.makeFestivalPromotion(vo));
} 

/** 
* 
* Method: makeMemberPromotion(PromotionVO vo) 
* 
*/ 
@Test
public void testMakeMemberPromotion() throws Exception {
    PromotionVO vo = new PromotionVO("0002", PromotionType.memPromotion, new Date(2016,11,13), new Date(2016,11,15),area ,discount, 9.0 ,"0001");
    Assert.assertEquals(ResultMessage.Correct,websalerblService.makeMemberPromotion(vo));
} 

/** 
* 
* Method: cancelFestivalPromotion(PromotionVO vo) 
* 
*/ 
@Test
public void testCancelFestivalPromotion() throws Exception {
    PromotionVO vo = new PromotionVO("0001", PromotionType.fesPromotion, new Date(2016,11,13), new Date(2016,11,15),area ,discount, 9.0 ,"0001");
    Assert.assertEquals(ResultMessage.Correct,websalerblService.cancelFestivalPromotion(vo));
} 

/** 
* 
* Method: addCredit(String userID, int value) 
* 
*/ 
@Test
public void testAddCredit() throws Exception { 
    Assert.assertEquals(ResultMessage.Correct,websalerblService.addCredit("0001",100));
} 


} 

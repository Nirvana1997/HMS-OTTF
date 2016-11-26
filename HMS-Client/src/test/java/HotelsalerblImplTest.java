import businesslogic.hotelsalerbl.HotelsalerblImpl;
import businesslogicservice.hotelsalerblservice.HotelsalerblService;
import enumData.Address;
import enumData.ResultMessage;
import enumData.RoomType;
import enumData.TradeArea;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import vo.HotelinfoVO;

import java.util.ArrayList;

/** 
* HotelsalerblImpl Tester.
* 
* @author <Authors xzh>
* @since <pre>十一月 9, 2016</pre> 
* @version 1.0 
*/ 
public class HotelsalerblImplTest {

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: modifyHotelInfo(HotelinfoVO vo) 
* 
*/ 
@Test
public void testModifyHotelInfo() throws Exception {
    HotelsalerblService hotelsalerblService = new HotelsalerblImpl();
    HotelinfoVO hotelinfoVO = new HotelinfoVO("0001","喋喋大酒店", TradeArea.Xianlin, Address.DieDie,"仙林大道",null,new ArrayList<RoomType>(),
            new ArrayList<Integer>(),"环境优美","服务周到",3,3,new ArrayList<String>(),new ArrayList<String>());
    Assert.assertEquals(ResultMessage.Correct,hotelsalerblService.modifyHotelInfo(hotelinfoVO));
} 

/** 
* 
* Method: readOrder(String HotelID) 
* 
*/ 
@Test
public void testReadOrder() throws Exception { 
//有点问题,暂时先NULL了
} 

/** 
* 
* Method: updateOrder(OrderVO orderVO) 
* 
*/ 
@Test
public void testUpdateOrder() throws Exception {
    HotelsalerblService hotelsalerblService = new HotelsalerblImpl();
    HotelinfoVO hotelinfoVO = new HotelinfoVO("0001","喋喋大酒店", TradeArea.Xianlin, Address.DieDie,"仙林大道",null,new ArrayList<RoomType>(),
            new ArrayList<Integer>(),"环境优美","服务周到",3,3,new ArrayList<String>(),new ArrayList<String>());
    Assert.assertEquals(ResultMessage.Correct,hotelsalerblService.modifyHotelInfo(hotelinfoVO));
} 


} 

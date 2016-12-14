package driver;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;
import data.hotelsalerdata.HotelroomDataImpl;
import dataservice.hotelsalerdataservice.HotelroomDataService;
import enumData.RoomType;
import po.HotelroomPO;
import po.OrderPO;
import po.RoomNumPO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by mac on 2016/12/5.
 */
public class HotelRoomTest {
    public static void main(String[] args) throws RemoteException {
        HotelroomDataService hotelroomDataService = new HotelroomDataImpl();
//        ArrayList<RoomNumPO> list = new ArrayList<RoomNumPO>();
//        list.add(new RoomNumPO("01","2016_11_11",20,10,RoomType.DoubleRoom));
//        list.add(new RoomNumPO("01","2016_11_11",20,10,RoomType.SingleRoom));
//        list.add(new RoomNumPO("01","2016_11_12",20,10,RoomType.DoubleRoom));
//        list.add(new RoomNumPO("01","2016_11_12",20,10,RoomType.SingleRoom));
//        System.out.println(hotelroomDataService.initializeRoomNum(list));
//        System.out.println(hotelroomDataService.initializeRoomInfo(new HotelroomPO("01",RoomType.DoubleRoom,200.0)));
//        System.out.println(hotelroomDataService.initializeRoomInfo(new HotelroomPO("01",RoomType.SingleRoom,150.0)));
//        System.out.println(hotelroomDataService.initializeRoomInfo(new HotelroomPO("01", RoomType.StandardRoom,300.0)));
//        System.out.println(hotelroomDataService.getRoomList("01").get(0).getPrice());
//        System.out.println(hotelroomDataService.getRoomList("01").get(1).getPrice());
//        System.out.println(hotelroomDataService.getRoomList("01").get(2).getPrice());
//        System.out.println(hotelroomDataService.getEmptyrooms("01","2016_11_11").get(0).getTotalNum());
        System.out.println(hotelroomDataService.setEmpty(new OrderPO(null,"01",null,null,0,0,null,"2016_11_12",null,
                RoomType.DoubleRoom,0,true,null,null,null,null,null)));
    }
}

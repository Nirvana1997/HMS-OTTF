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
//        ArrayList<HotelroomPO> hotelroomPOs = new ArrayList<HotelroomPO>();
//        hotelroomPOs.add(new HotelroomPO("0200001",RoomType.DoubleRoom,200,10));
//        hotelroomPOs.add(new HotelroomPO("0200001",RoomType.SingleRoom,300,10));
//        hotelroomPOs.add(new HotelroomPO("0200001",RoomType.DisabledRoom,400,10));
//        hotelroomPOs.add(new HotelroomPO("0200002",RoomType.DoubleRoom,200,20));
//        hotelroomPOs.add(new HotelroomPO("0200002",RoomType.SingleRoom,300,20));
//        hotelroomPOs.add(new HotelroomPO("0200002",RoomType.DisabledRoom,400,20));
//        System.out.println(hotelroomDataService.initializeRoomInfo(hotelroomPOs));
//        ArrayList<HotelroomPO> hotelroomPOss = new ArrayList<HotelroomPO>();
//        hotelroomPOss.add(new HotelroomPO("0200002",RoomType.DisabledRoom,999,10));
//        System.out.println(hotelroomDataService.setRoomInfo(hotelroomPOss));
        System.out.println(hotelroomDataService.getRoomList("0200002").get(2).getPrice());
//        ArrayList<RoomNumPO> roomNumPOs = new ArrayList<RoomNumPO>();
//        roomNumPOs.add(new RoomNumPO("0200001","2016_12_1",20,RoomType.SingleRoom));
//        roomNumPOs.add(new RoomNumPO("0200001","2016_12_1",20,RoomType.DoubleRoom));
//        roomNumPOs.add(new RoomNumPO("0200001","2016_12_1",20,RoomType.DisabledRoom));
//        roomNumPOs.add(new RoomNumPO("0200001","2016_12_2",20,RoomType.SingleRoom));
//        roomNumPOs.add(new RoomNumPO("0200001","2016_12_2",20,RoomType.DoubleRoom));
//        roomNumPOs.add(new RoomNumPO("0200001","2016_12_2",20,RoomType.DisabledRoom));
//        roomNumPOs.add(new RoomNumPO("0200001","2016_12_3",20,RoomType.SingleRoom));
//        roomNumPOs.add(new RoomNumPO("0200001","2016_12_3",20,RoomType.DoubleRoom));
//        roomNumPOs.add(new RoomNumPO("0200001","2016_12_3",20,RoomType.DisabledRoom));
//        roomNumPOs.add(new RoomNumPO("0200001","2016_12_4",20,RoomType.SingleRoom));
//        roomNumPOs.add(new RoomNumPO("0200001","2016_12_4",20,RoomType.DoubleRoom));
//        roomNumPOs.add(new RoomNumPO("0200001","2016_12_4",20,RoomType.DisabledRoom));
//        roomNumPOs.add(new RoomNumPO("0200001","2016_12_5",20,RoomType.SingleRoom));
//        roomNumPOs.add(new RoomNumPO("0200001","2016_12_5",20,RoomType.DoubleRoom));
//        roomNumPOs.add(new RoomNumPO("0200001","2016_12_5",20,RoomType.DisabledRoom));
//        System.out.println(hotelroomDataService.initializeRoomNum(roomNumPOs));
//        ArrayList<RoomNumPO> roomNumPOss = new ArrayList<RoomNumPO>();
//        roomNumPOss.add(new RoomNumPO("0200001","2016_12_5",999,RoomType.SingleRoom));
//        System.out.println(hotelroomDataService.setRoomNum(roomNumPOss));
    }
}

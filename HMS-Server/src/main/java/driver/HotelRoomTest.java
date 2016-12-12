package driver;

import data.hotelsalerdata.HotelroomDataImpl;
import dataservice.hotelsalerdataservice.HotelroomDataService;
import enumData.RoomType;
import po.HotelroomPO;
import po.RoomNumPO;

import java.rmi.RemoteException;

/**
 * Created by mac on 2016/12/5.
 */
public class HotelRoomTest {
    public static void main(String[] args) throws RemoteException {
        HotelroomDataService hotelroomDataService = new HotelroomDataImpl();
        System.out.println(hotelroomDataService.addHotelroom(new HotelroomPO("01",RoomType.DoubleRoom,200.0)));
        System.out.println(hotelroomDataService.addHotelroom(new HotelroomPO("01",RoomType.SingleRoom,150.0)));
        System.out.println(hotelroomDataService.addHotelroom(new HotelroomPO("01", RoomType.StandardRoom,300.0)));
        System.out.println(hotelroomDataService.getRoomList("01").get(0).getPrice());
        System.out.println(hotelroomDataService.getRoomList("01").get(1).getPrice());
        System.out.println(hotelroomDataService.getRoomList("01").get(2).getPrice());
        System.out.println(hotelroomDataService.getEmptyrooms("01","2016_11_11").get(0).getTotalNum());
    }
}

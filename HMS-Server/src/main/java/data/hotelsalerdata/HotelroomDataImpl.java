package data.hotelsalerdata;

import database.DataBaseHelper;
import dataservice.hotelsalerdataservice.HotelroomDataService;
import enumData.ResultMessage;
import enumData.RoomType;
import po.HotelroomPO;
import po.OrderPO;
import po.RoomNumPO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 * Created by mac on 2016/11/23.
 */
public class HotelroomDataImpl extends UnicastRemoteObject implements HotelroomDataService {

    public HotelroomDataImpl() throws RemoteException {
    }

    /**
     *根据订单信息将相应空房间数-1
     * @param po
     * @return
     */
    @Override
    public ResultMessage setOccupied(OrderPO po) {
        DataBaseHelper.in("update " + po.getHotelID() + "_" + po.getCheckInDate() + " set emptyNum = emptyNum - 1 where " +
                "type = '" + po.getRoomType().toString() + "'");
        return ResultMessage.Correct;
    }
    /**
     *根据订单信息将相应空房间数+1
     * @param po
     * @return
     */
    @Override
    public ResultMessage setEmpty(OrderPO po) {
        DataBaseHelper.in("update " + po.getHotelID() + "_" + po.getCheckInDate() + " set emptyNum = emptyNum + 1 where " +
                "type = '" + po.getRoomType().toString() + "'");
        return ResultMessage.Correct;
    }

    /**
     *根据酒店ID和日期，查询对应日期空房间状况
     * @param hotelID
     * @param date
     * @return
     */
    public ArrayList<RoomNumPO> getEmptyrooms(String hotelID,String date){
        ArrayList<RoomNumPO> roomNumPOs = new ArrayList<RoomNumPO>();
        ArrayList<String> typeList = DataBaseHelper.out("select type from " + hotelID + "_" + date,"type");
        ArrayList<String> totalNumList = DataBaseHelper.out("select totalNum from " + hotelID + "_" + date,"totalNum");
        ArrayList<String> emptyNumList = DataBaseHelper.out("select emptyNum from " + hotelID + "_" + date,"emptyNum");
        for(int i=0;i<typeList.size();i++){
            RoomType type = null;
            try {
                type = Enum.valueOf(RoomType.class,typeList.get(i));
            }catch (IllegalArgumentException ex){
                ex.printStackTrace();
            }
            roomNumPOs.add(new RoomNumPO(hotelID,date,Integer.parseInt(totalNumList.get(i)),
                    Integer.parseInt(emptyNumList.get(i)),type));
        }
        return roomNumPOs;
    }


    /**
     *添加酒店房间信息
     * @param po
     * @return
     */
    @Override
    public ResultMessage addHotelroom(HotelroomPO po) {
        if(!DataBaseHelper.in("show tables like '" + po.getHotelID() +"_roomInfo" + "'"))
            DataBaseHelper.in("create table " + po.getHotelID() + "_roomInfo" +
                    "(type varchar(50),price float)");
        boolean exist = false;
        ArrayList<String> judge = DataBaseHelper.out("select type from " + po.getHotelID() + "_roomInfo","type");
        for(int i=0;i<judge.size();i++)
            if(judge.get(i).equals(po.getRoomType().toString()))
                exist = true;
        if(!exist) {
            DataBaseHelper.in("insert into " + po.getHotelID() + "_roomInfo (type , price) values ('" +
                    po.getRoomType().toString() + "','" + po.getPrice() + "')");
            return  ResultMessage.Correct;
        }
        return ResultMessage.HasExist;
    }

    /**
     *得到房间列表（类型，价格）
     * @param hotelID
     * @return
     */
    @Override
    public ArrayList<HotelroomPO> getRoomList(String hotelID) {
        if(DataBaseHelper.in("show tables like '" + hotelID +"_roomInfo" + "'")){
            ArrayList<String> typeList = DataBaseHelper.out("select type from " + hotelID + "_roomInfo order by price","type");
            ArrayList<String> priceList = DataBaseHelper.out("select price from " + hotelID + "_roomInfo order by price","price");
            ArrayList<HotelroomPO> hotelroomPOs = new ArrayList<HotelroomPO>();
            for(int i=0;i<typeList.size();i++) {
                RoomType type = null;
                try {
                    type = Enum.valueOf(RoomType.class,typeList.get(i));
                }catch (IllegalArgumentException ex){
                    ex.printStackTrace();
                }
                hotelroomPOs.add(new HotelroomPO(hotelID, type, Double.parseDouble(priceList.get(i))));
            }
            return  hotelroomPOs;
        }
        return null;
    }

    /**
     * 酒店工作人员初始化房间信息（房间类型，对应的总房间数，空房间数）
     * @param po
     * @return
     */
    @Override
    public ResultMessage initializeRoomInfo(RoomNumPO po) {
        if(!DataBaseHelper.in("show tables like '" + po.getHotelID() + "_" + po.getDate() + "'"))
            DataBaseHelper.in("create table " + po.getHotelID() + "_" + po.getDate() +
                    " ( type varchar(50),totalNum int ,emptyNum int )");
        DataBaseHelper.in("insert into " + po.getHotelID() + "_" + po.getDate() + " (type,totalNum,emptyNum)"
        + " values " + "('" + po.getRoomType().toString() + "','" + po.getTotalNum() + "','" + po.getEmptyNum() + "')");
        return ResultMessage.Correct;
    }
}

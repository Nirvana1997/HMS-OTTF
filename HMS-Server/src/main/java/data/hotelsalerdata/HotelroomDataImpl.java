package data.hotelsalerdata;

import autoManage.ManageRoomNum;
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
     *根据酒店ID和日期，查询对应日期空房间状况
     * @param hotelID
     * @param date
     * @return
     */
    public ArrayList<RoomNumPO> getEmptyrooms(String hotelID,String date){
        ArrayList<RoomNumPO> roomNumPOs = new ArrayList<RoomNumPO>();
        if(!DataBaseHelper.in("show tables like '" + hotelID + "_" + date + "'"))
            return roomNumPOs;
        ArrayList<String> typeList = DataBaseHelper.out("select type from " + hotelID + "_" + date,"type");
        ArrayList<String> emptyNumList = DataBaseHelper.out("select emptyNum from " + hotelID + "_" + date,"emptyNum");
        for(int i=0;i<typeList.size();i++){
            RoomType type = null;
            try {
                type = Enum.valueOf(RoomType.class,typeList.get(i));
            }catch (IllegalArgumentException ex){
                ex.printStackTrace();
            }
            roomNumPOs.add(new RoomNumPO(hotelID,date,Integer.parseInt(emptyNumList.get(i)),type));
        }
        return roomNumPOs;
    }

    /**
     * 初始化酒店信息
     * @param list 酒店房间信息POList
     * @return
     * @throws RemoteException
     */
    @Override
    public ResultMessage initializeRoomInfo(ArrayList<HotelroomPO> list) throws RemoteException {
        for(int i=0;i<list.size();i++){
            initializeRoomInfo(list.get(i));
        }
        return ResultMessage.Correct;
    }

    /**
     * 修改酒店信息
     * @param list 酒店房间信息POList
     * @return
     * @throws RemoteException
     */
    @Override
    public ResultMessage setRoomInfo(ArrayList<HotelroomPO> list) throws RemoteException {
        for(int i=0;i<list.size();i++){
            HotelroomPO po = list.get(i);
            DataBaseHelper.in("update " + po.getHotelID() + "_roomInfo set price = '" + po.getPrice() + "' where type = '" + po.getRoomType() + "'" );
            DataBaseHelper.in("update " + po.getHotelID() + "_roomInfo set number = '" + po.getRoomNumber() + "' where type = '" + po.getRoomType() + "'" );
        }
        return ResultMessage.Correct;
    }


    /**
     *初始化酒店房间信息(单个PO)
     * @param po
     * @return
     */
    private ResultMessage initializeRoomInfo(HotelroomPO po) {
        if(!DataBaseHelper.in("show tables like '" + po.getHotelID() +"_roomInfo" + "'"))
            DataBaseHelper.in("create table " + po.getHotelID() + "_roomInfo" +
                    "(type varchar(50),price float,number varchar(20)");
        boolean exist = false;
        ArrayList<String> judge = DataBaseHelper.out("select type from " + po.getHotelID() + "_roomInfo","type");
        for(int i=0;i<judge.size();i++)
            if(judge.get(i).equals(po.getRoomType().toString()))
                exist = true;
        if(!exist) {
            DataBaseHelper.in("insert into " + po.getHotelID() + "_roomInfo (type , price , number) values ('" +
                    po.getRoomType().toString() + "','" + po.getPrice() + "','" + po.getRoomNumber() + "')");
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
            ArrayList<String> numberList = DataBaseHelper.out("select number from " + hotelID + "_roomInfo order by price","number");
            ArrayList<HotelroomPO> hotelroomPOs = new ArrayList<HotelroomPO>();
            for(int i=0;i<typeList.size();i++) {
                RoomType type = null;
                try {
                    type = Enum.valueOf(RoomType.class,typeList.get(i));
                }catch (IllegalArgumentException ex){
                    ex.printStackTrace();
                }
                hotelroomPOs.add(new HotelroomPO(hotelID, type, Double.parseDouble(priceList.get(i)),Integer.parseInt(numberList.get(i))));
            }
            return  hotelroomPOs;
        }
        return null;
    }

    /**
     * 酒店工作人员初始化房间数量信息（房间类型，对应的总房间数，空房间数）
     * @param list
     * @return
     */
    @Override
    public ResultMessage initializeRoomNum(ArrayList<RoomNumPO> list) {
        for(int i=0;i<list.size();i++) {
            RoomNumPO po = list.get(i);
            if (!DataBaseHelper.in("show tables like '" + po.getHotelID() + "_" + po.getDate() + "'"))
                DataBaseHelper.in("create table " + po.getHotelID() + "_" + po.getDate() +
                        " ( type varchar(50),emptyNum int )");
            DataBaseHelper.in("insert into " + po.getHotelID() + "_" + po.getDate() + " (type,emptyNum)"
                    + " values " + "('" + po.getRoomType().toString() + "','" + po.getEmptyNum() + "')");
        }
        //每次初始化酒店房间数量信息时，添加一个触发器去自动管理每日信息
        int[] roomTotalNum = new int[3];//存放该酒店每种房间对应总数，用于初始化触发器
        String hotelID = list.get(0).getHotelID();
        roomTotalNum[0] = Integer.parseInt(DataBaseHelper.outSingle(hotelID+"_roomInfo","number","type",RoomType.SingleRoom+""));
        roomTotalNum[1] = Integer.parseInt(DataBaseHelper.outSingle(hotelID+"_roomInfo","number","type",RoomType.DoubleRoom+""));
        roomTotalNum[2] = Integer.parseInt(DataBaseHelper.outSingle(hotelID+"_roomInfo","number","type",RoomType.DisabledRoom+""));
        ManageRoomNum.update(30,roomTotalNum,hotelID);
        return ResultMessage.Correct;
    }

    /**
     * 修改房间数量信息（房间类型，对应的总房间数，空房间数）
     * @param list 房间数量POlist
     * @return
     * @throws RemoteException
     */
    @Override
    public ResultMessage setRoomNum(ArrayList<RoomNumPO> list) throws RemoteException {
        for(int i=0;i<list.size();i++){
            RoomNumPO po = list.get(i);
            DataBaseHelper.in("update " + po.getHotelID() + "_" + po.getDate() + " set emptyNum = '" + po.getEmptyNum() + "' where type = '"
            + po.getRoomType() + "'");
        }
        return ResultMessage.Correct;
    }
}

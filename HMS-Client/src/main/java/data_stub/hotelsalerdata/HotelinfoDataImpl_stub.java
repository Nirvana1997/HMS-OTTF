package data_stub.hotelsalerdata;

import dataservice.hotelsalerdataservice.HotelinfoDataService;
import enumData.Address;
import enumData.ResultMessage;
import enumData.SortWay;
import enumData.TradeArea;
import po.CommentPO;
import po.HotelinfoPO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

public class HotelinfoDataImpl_stub implements HotelinfoDataService {
    ArrayList<HotelinfoPO> hotelList = new ArrayList<HotelinfoPO>();
    ArrayList<CommentPO> commentPOList = new ArrayList<CommentPO>();
    HotelinfoPO hotel1 = new HotelinfoPO("0201", "XianlinHotel", TradeArea.Xianlin, Address.NJU,  "", "", "VeryGood", "1233321", 3, 3,99);
    HotelinfoPO hotel2 = new HotelinfoPO("0202", "DiedieHotel", TradeArea.Xianlin, Address.NJU, "", "", "VeryGood", "111", 4, 5,80);
    HotelinfoPO hotel3 = new HotelinfoPO("0203", "XuanxuanHotel", TradeArea.XuanQuan, Address.XuanXuan, "", "", "VeryGood", "134123123", 5, 5,200);
    HotelinfoPO hotel4 = new HotelinfoPO("0204", "ZhihaoHotel",TradeArea.XuanQuan,Address.NJU,"Near the NJU","Excellent","VeryGood","1288888",5,9.9,300);

    public HotelinfoDataImpl_stub() {
        hotelList.add(hotel1);
        hotelList.add(hotel2);
        hotelList.add(hotel3);
        hotelList.add(hotel4);
    }

    @Override
    public HotelinfoPO getHotelinfo(String hotelID) {
        Iterator hotelItr = hotelList.iterator();
        while (hotelItr.hasNext()) {
            HotelinfoPO po = (HotelinfoPO) hotelItr.next();
            if (po.getHotelID().equals(hotelID)) {
                return po;
            }
        }
        return null;
    }

    @Override
    public ResultMessage setHotelinfo(HotelinfoPO po) {
        for(int i=0;i<hotelList.size();i++){
            if(hotelList.get(i).getHotelID().equals(po.getHotelID())) {
                hotelList.remove(i);
                hotelList.add(po);
                break;
            }
        }
        return ResultMessage.Correct;
    }

    @Override
    public ArrayList<HotelinfoPO> getHotelList(TradeArea tradeArea, Address address, SortWay sortWay){
        ArrayList<HotelinfoPO> HIList = new ArrayList<HotelinfoPO>();
        for(HotelinfoPO po:hotelList){
            if(po.getTradeArea().equals(tradeArea)&&po.getAddress().equals(address)){
                HIList.add(po);
            }
        }
        return HIList;
    }

    @Override
    public ArrayList<HotelinfoPO> getHotelList() throws RemoteException {
        return hotelList;
    }

    @Override
    public ResultMessage addComments(CommentPO po) {
        commentPOList.add(po);
        return ResultMessage.Correct;
    }

    @Override
    public ArrayList<CommentPO> getComments(String hotelID) throws RemoteException {
        ArrayList<CommentPO> list = new ArrayList<CommentPO>();
        for(int i=0;i<commentPOList.size();i++){
            if(commentPOList.get(i).getHotelID().equals(hotelID))
                list.add(commentPOList.get(i));
        }
        return list;
    }

    @Override
    public ResultMessage addHotelinfo(HotelinfoPO po) throws RemoteException {
        hotelList.add(po);
        return ResultMessage.Correct;
    }

    @Override
    public ResultMessage deleteHotelinfo(String hotelID) throws RemoteException {
        for(int i = 0;i<hotelList.size();i++){
            if(hotelList.get(i).getHotelID().equals(hotelID)) {
                hotelList.remove(i);
                return ResultMessage.Correct;
            }
        }
        return ResultMessage.NotExist;
    }

}

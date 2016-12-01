package data.hotelsalerdata;

import database.DataBaseHelper;
import dataservice.hotelsalerdataservice.HotelinfoDataService;
import enumData.Address;
import enumData.ResultMessage;
import enumData.TradeArea;
import po.CommentPO;
import po.ConditionPO;
import po.HotelinfoPO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by mac on 2016/11/23.
 */
public class HotelinfoDataImpl implements HotelinfoDataService {
    /**
     * 根据酒店ID获取酒店信息
     * @param hotelID
     * @return
     * @throws RemoteException
     */
    @Override
    public HotelinfoPO getHotelinfo(String hotelID) throws RemoteException {
        if(hasExisted(hotelID)) {
            ArrayList<String> hotelName = DataBaseHelper.out("select hotelName from HotelInfo where hotelID = '" + hotelID + "'", "hotelName");
            ArrayList<String> tradeArea = DataBaseHelper.out("select tradeArea from HotelInfo where hotelID = '" + hotelID + "'", "tradeArea");
            ArrayList<String> address = DataBaseHelper.out("select address from HotelInfo where hotelID = '" + hotelID + "'", "address");
            ArrayList<String> detailAddress = DataBaseHelper.out("select detailAddress from HotelInfo where hotelID = '" + hotelID + "'", "detailAddress");
            ArrayList<String> introduction = DataBaseHelper.out("select introduction from HotelInfo where hotelID = '" + hotelID + "'", "introduction");
            ArrayList<String> service = DataBaseHelper.out("select service from HotelInfo where hotelID = '" + hotelID + "'", "service");
            ArrayList<String> contactNumber = DataBaseHelper.out("select contactNumber from HotelInfo where hotelID = '" + hotelID + "'", "contactNumber");
            ArrayList<String> star = DataBaseHelper.out("select star from HotelInfo where hotelID = '" + hotelID + "'", "star");
            ArrayList<String> grade = DataBaseHelper.out("select grade from HotelInfo where hotelID = '" + hotelID + "'", "grade");
            TradeArea tradeArea_ = null;
            Address address_ = null;
            try {
                tradeArea_ = Enum.valueOf(TradeArea.class,tradeArea.get(0).trim());
                address_ = Enum.valueOf(Address.class,address.get(0).trim());
            }catch (IllegalArgumentException ex){
                ex.printStackTrace();
            }
            return  new HotelinfoPO(hotelID,hotelName.get(0),tradeArea_,address_,detailAddress.get(0),introduction.get(0),
                    service.get(0),contactNumber.get(0),Integer.parseInt(star.get(0)),Double.parseDouble(grade.get(0)));
        }
        return null;
    }

    @Override
    public ResultMessage setHotelinfo(HotelinfoPO po) throws RemoteException {
        if(hasExisted(po.getHotelID())){
            DataBaseHelper.in("update HotelInfo set hotelName = '" + po.getHotelname() + "' where hotelID = '" + po.getHotelID() +"'");
            DataBaseHelper.in("update HotelInfo set tradeArea = '" + po.getTradeArea().toString() + "' where hotelID = '" + po.getHotelID() +"'");
            DataBaseHelper.in("update HotelInfo set address = '" + po.getAddress().toString() + "' where hotelID = '" + po.getHotelID() +"'");
            DataBaseHelper.in("update HotelInfo set detailAddress = '" + po.getDetailAddress() + "' where hotelID = '" + po.getHotelID() +"'");
            DataBaseHelper.in("update HotelInfo set introduction = '" + po.getIntroduction() + "' where hotelID = '" + po.getHotelID() +"'");
            DataBaseHelper.in("update HotelInfo set service = '" + po.getService() + "' where hotelID = '" + po.getHotelID() +"'");
            DataBaseHelper.in("update HotelInfo set contactNumber = '" + po.getContactNumber() + "' where hotelID = '" + po.getHotelID() +"'");
            DataBaseHelper.in("update HotelInfo set star = '" + po.getStar() + "' where hotelID = '" + po.getHotelID() +"'");
            DataBaseHelper.in("update HotelInfo set grade = '" + po.getGrade() + "' where hotelID = '" + po.getHotelID() +"'");
            return ResultMessage.Correct;
        }
        return ResultMessage.NotExist;
    }

    @Override
    public ArrayList<HotelinfoPO> getHotelList(ConditionPO po) throws RemoteException {
        return null;
    }

    @Override
    public ResultMessage addComments(CommentPO po) throws RemoteException {
        if(hasExisted(po.getHotelID())){
            DataBaseHelper.in("insert into Comment (hotelID,userID,comment,grade) values (" +
                    "'" + po.getHotelID() + "','" + po.getUserID() + "','" + po.getComment() + "','" + po.getGrade()
                    + "','");
            return  ResultMessage.Correct;
        }
        return ResultMessage.NotExist;
    }

    @Override
    public ResultMessage addHotelinfo(HotelinfoPO po) throws RemoteException {
        if(hasExisted(po.getHotelID()))
            return ResultMessage.HasExist;
        DataBaseHelper.in("insert into HotelInfo (hotelID,hotelName,tradeArea,address,detailAddress,introduction,service,contactNumber,star,grade) values (" +
                "'" + po.getHotelID() + "','" + po.getHotelname() + "','" + po.getTradeArea().toString() + "','" + po.getAddress().toString()
                + "','" + po.getDetailAddress() + "','" + po.getIntroduction() + "','" + po.getService() +"','" + po.getContactNumber() +
                "','" + po.getStar() + "','" + po.getGrade() + "')");
        return ResultMessage.Correct;
    }

    /**
     * 判断存在
     * @param hotelID
     * @return
     * @throws RemoteException
     */
    private boolean hasExisted(String hotelID) throws RemoteException {
        ArrayList<String> hotelIDList =  DataBaseHelper.out("select hotelID from HotelInfo", "hotelID");
        for(int i=0;i<hotelIDList.size();i++)
            if(hotelIDList.get(i).equals(hotelID))
                return true;
        return  false;
    }
}

package data.hotelsalerdata;

import database.DataBaseHelper;
import dataservice.hotelsalerdataservice.HotelinfoDataService;
import encryption.DesUtils;
import enumData.Address;
import enumData.ResultMessage;
import enumData.SortWay;
import enumData.TradeArea;
import po.CommentPO;
import po.HotelinfoPO;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 * Created by mac on 2016/11/23.
 */
public class HotelinfoDataImpl extends UnicastRemoteObject implements HotelinfoDataService {

    private DesUtils desUtils;

    public HotelinfoDataImpl() throws Exception {
        desUtils = new DesUtils();
    }

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
            ArrayList<String> minPrice = DataBaseHelper.out("select minPrice from HotelInfo where hotelID = '" + hotelID + "'", "minPrice");
            TradeArea tradeArea_ = null;
            Address address_ = null;
            try {
                tradeArea_ = Enum.valueOf(TradeArea.class,tradeArea.get(0).trim());
                address_ = Enum.valueOf(Address.class,address.get(0).trim());
            }catch (IllegalArgumentException ex){
                ex.printStackTrace();
            }
            String contactNumber_ = desUtils.de(contactNumber.get(0));
            return  new HotelinfoPO(hotelID,hotelName.get(0),tradeArea_,address_,detailAddress.get(0),introduction.get(0),
                    service.get(0),contactNumber_,Integer.parseInt(star.get(0)),Double.parseDouble(grade.get(0)),Double.parseDouble(minPrice.get(0)));
        }
        return null;
    }

    /**
     * 修改酒店信息
     * @param po
     * @return
     * @throws RemoteException
     */
    @Override
    public ResultMessage setHotelinfo(HotelinfoPO po) throws RemoteException {
        if(hasExisted(po.getHotelID())){
            String contactNumber = desUtils.en(po.getContactNumber());
            DataBaseHelper.in("update HotelInfo set hotelName = '" + po.getHotelName() + "' where hotelID = '" + po.getHotelID() +"'");
            DataBaseHelper.in("update HotelInfo set tradeArea = '" + po.getTradeArea().toString() + "' where hotelID = '" + po.getHotelID() +"'");
            DataBaseHelper.in("update HotelInfo set address = '" + po.getAddress().toString() + "' where hotelID = '" + po.getHotelID() +"'");
            DataBaseHelper.in("update HotelInfo set detailAddress = '" + po.getDetailAddress() + "' where hotelID = '" + po.getHotelID() +"'");
            DataBaseHelper.in("update HotelInfo set introduction = '" + po.getIntroduction() + "' where hotelID = '" + po.getHotelID() +"'");
            DataBaseHelper.in("update HotelInfo set service = '" + po.getService() + "' where hotelID = '" + po.getHotelID() +"'");
            DataBaseHelper.in("update HotelInfo set contactNumber = '" + contactNumber + "' where hotelID = '" + po.getHotelID() +"'");
            DataBaseHelper.in("update HotelInfo set star = '" + po.getStar() + "' where hotelID = '" + po.getHotelID() +"'");
            DataBaseHelper.in("update HotelInfo set grade = '" + po.getGrade() + "' where hotelID = '" + po.getHotelID() +"'");
            DataBaseHelper.in("update HotelInfo set minPrice = '" + po.getMinPrice() + "' where hotelID = '" + po.getHotelID() +"'");

            return ResultMessage.Correct;
        }
        return ResultMessage.NotExist;
    }

    /**
     * 根据搜索条件，返回酒店列表
     * @param tradeArea
     * @param address
     * @param sortWay
     * @return
     * @throws RemoteException
     */
    @Override
    public ArrayList<HotelinfoPO> getHotelList(TradeArea tradeArea, Address address, SortWay sortWay) throws RemoteException {
        ArrayList<HotelinfoPO> hotelinfoPOList = new ArrayList<HotelinfoPO>();

        //解析排序方式
        String standard = null;
        String way = null;
        standard = sortWay.toString().split("_")[0].toLowerCase();
        way = sortWay.toString().split("_")[1];
        if(way.contains("A"))
            way = "ASC";
        else
            way = "DESC";

        ArrayList<String> hotelIDList = myOut("hotelID",standard,way,tradeArea,address);
        ArrayList<String> hotelNameList = myOut("hotelName",standard,way,tradeArea,address);
        ArrayList<String> tradeAreaList = myOut("tradeArea",standard,way,tradeArea,address);
        ArrayList<String> addressList = myOut("address",standard,way,tradeArea,address);
        ArrayList<String> detailAddressList = myOut("detailAddress",standard,way,tradeArea,address);
        ArrayList<String> introductionList = myOut("introduction",standard,way,tradeArea,address);
        ArrayList<String> serviceList = myOut("service",standard,way,tradeArea,address);
        ArrayList<String> contactNumList = myOut("contactNumber",standard,way,tradeArea,address);
        ArrayList<String> starList = myOut("star",standard,way,tradeArea,address);
        ArrayList<String> gradeList = myOut("grade",standard,way,tradeArea,address);
        ArrayList<String> priceList = myOut("minPrice" ,standard,way,tradeArea,address);

        for(int i=0;i<hotelIDList.size();i++){

            TradeArea tradeArea_ = null;
            Address address_ = null;
            try {
                tradeArea_ = Enum.valueOf(TradeArea.class,tradeAreaList.get(i).trim());
                address_ = Enum.valueOf(Address.class,addressList.get(i).trim());
            }catch (IllegalArgumentException ex){
                ex.printStackTrace();
            }
            String contactNumber = desUtils.de(contactNumList.get(i));

            hotelinfoPOList.add(new HotelinfoPO(hotelIDList.get(i),hotelNameList.get(i),tradeArea_,address_,detailAddressList.get(i),
                    introductionList.get(i),serviceList.get(i),contactNumber,Integer.parseInt(starList.get(i)),
                    Double.parseDouble(gradeList.get(i)),Double.parseDouble(priceList.get(i))));
        }

        return hotelinfoPOList;
    }

    @Override
    public ArrayList<HotelinfoPO> getHotelList() throws RemoteException {
        ArrayList<HotelinfoPO> hotelinfoPOs = new ArrayList<HotelinfoPO>();
        ArrayList<String> hotelIDList = DataBaseHelper.outSelect("HotelInfo","hotelID");
        ArrayList<String> hotelNameList = DataBaseHelper.outSelect("HotelInfo","hotelName");
        ArrayList<String> tradeAreaList = DataBaseHelper.outSelect("HotelInfo","tradeArea");
        ArrayList<String> addressList = DataBaseHelper.outSelect("HotelInfo","address");
        ArrayList<String> detailAddressList = DataBaseHelper.outSelect("HotelInfo","detailAddress");
        ArrayList<String> introductionList = DataBaseHelper.outSelect("HotelInfo","introduction");
        ArrayList<String> serviceList = DataBaseHelper.outSelect("HotelInfo","service");
        ArrayList<String> contactNumberList = DataBaseHelper.outSelect("HotelInfo","contactNumber");
        ArrayList<String> starList = DataBaseHelper.outSelect("HotelInfo","star");
        ArrayList<String> gradeList = DataBaseHelper.outSelect("HotelInfo","grade");
        ArrayList<String> minPriceList = DataBaseHelper.outSelect("HotelInfo","minPrice");

        for(int i=0;i<hotelNameList.size();i++){
            ArrayList<String> temp = null;
            TradeArea tradeArea_ = null;
            Address address_ = null;
            try {
                tradeArea_ = Enum.valueOf(TradeArea.class,tradeAreaList.get(i).trim());
                address_ = Enum.valueOf(Address.class,addressList.get(i).trim());
            }catch (IllegalArgumentException ex){
                ex.printStackTrace();
            }
            String contactNumber = desUtils.de(contactNumberList.get(i));

            hotelinfoPOs.add(new HotelinfoPO(hotelIDList.get(i),hotelNameList.get(i),tradeArea_,address_,detailAddressList.get(i),
                    introductionList.get(i),serviceList.get(i),contactNumber,Integer.parseInt(starList.get(i)),
                    Double.parseDouble(gradeList.get(i)),Double.parseDouble(minPriceList.get(i))));
        }
        return hotelinfoPOs;
    }

    private ArrayList<String> myOut(String content,String standard,String way,TradeArea tradeArea,Address address){
        if(standard.equals("price"))
            standard = "minPrice";
        ArrayList<String> temp = DataBaseHelper.out("select " + content + " from HotelInfo where tradeArea = '" + tradeArea.toString() + "'"
                + " and address = '" + address.toString() + "'" + " order by " + standard + " " + way, content);
        return  temp;
    }

    /**
     * 评价
     * @param po
     * @return
     * @throws RemoteException
     */
    @Override
    public ResultMessage addComments(CommentPO po) throws RemoteException {
        if(hasExisted(po.getHotelID())){
            DataBaseHelper.in("insert into Comment (hotelID,userID,comment,grade) values (" +
                    "'" + po.getHotelID() + "','" + po.getUserID() + "','" + po.getComment() + "','" + po.getGrade()
                    + "')");
            return  ResultMessage.Correct;
        }
        return ResultMessage.NotExist;
    }

    /**
     * 根据酒店ID获取相应评价信息
     * @param hotelID 酒店ID
     * @return
     * @throws RemoteException
     */
    @Override
    public ArrayList<CommentPO> getComments(String hotelID) throws RemoteException {
        ArrayList<CommentPO> commentPOs = new ArrayList<CommentPO>();
        ArrayList<String> userIDList = DataBaseHelper.out("select userID from Comment where hotelID = '" + hotelID + "'","userID");
        ArrayList<String> commentList = DataBaseHelper.out("select comment from Comment where hotelID = '" + hotelID + "'","comment");
        ArrayList<String> gradeList = DataBaseHelper.out("select grade from Comment where hotelID = '" + hotelID + "'","grade");
        for(int i=0;i<userIDList.size();i++){
            commentPOs.add(new CommentPO(hotelID,userIDList.get(i),commentList.get(i),Integer.parseInt(gradeList.get(i))));
        }
        return commentPOs;
    }

    /**
     * 增加酒店信息
     * @param po
     * @return
     * @throws RemoteException
     */
    @Override
    public ResultMessage addHotelinfo(HotelinfoPO po) throws RemoteException {
        String contactNumber = desUtils.en(po.getContactNumber());
        if(hasExisted(po.getHotelID()))
            return ResultMessage.HasExist;
        DataBaseHelper.in("insert into HotelInfo (hotelID,hotelName,tradeArea,address,detailAddress,introduction,service,contactNumber,star,grade,minPrice) values (" +
                "'" + po.getHotelID() + "','" + po.getHotelName() + "','" + po.getTradeArea().toString() + "','" + po.getAddress().toString()
                + "','" + po.getDetailAddress() + "','" + po.getIntroduction() + "','" + po.getService() +"','" + contactNumber +
                "','" + po.getStar() + "','" + po.getGrade() + "','"+ po.getMinPrice() + "')");
        return ResultMessage.Correct;
    }

    @Override
    public ResultMessage deleteHotelinfo(String hotelID) throws RemoteException {
        if(hasExisted(hotelID)){
            DataBaseHelper.in("delete from HotelInfo where hotelID = '" + hotelID + "'");
            return ResultMessage.Correct;
        }else
            return ResultMessage.NotExist;
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

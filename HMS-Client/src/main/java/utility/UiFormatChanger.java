package utility;

import enumData.Address;
import enumData.OrderState;
import enumData.RoomType;
import enumData.TradeArea;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2016/12/18.
 */
public class UiFormatChanger {
    /**
     * 日期转字符串
     * @param date 日期
     * @return yyyy_MM.dd格式的日期
     */
    public static String dateToString(Date date){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(date);
    }
    /**
     * 日期转字符串
     * @param date 日期
     * @return yyyy_MM.dd格式的日期
     */
    public static String dateToString2(Date date){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return df.format(date);
    }
    /**
     * 根据订单状态返回字符串
     * @param state 订单状态
     * @return 中文字符串格式的订单状态
     */
    public static String stateTOstring(OrderState state){
        if(state == OrderState.exception){ return "异常"; }
        if(state == OrderState.executed){ return "已执行";}
        if(state == OrderState.executing){ return "未执行";}
        if(state == OrderState.canceled){ return "已撤销";}
        else return null;
    }
    /**
     * 根据房间类型返回字符串
     * @param type 房间类型
     * @return 字符串格式的房间类型
     */
    public static String typeTOstring(RoomType type){
        if(type == RoomType.SingleRoom) { return "单人房";}
        if(type == RoomType.DoubleRoom) {return "双人房";}
        if(type == RoomType.DisabledRoom) {return "无障碍客房";}
        else return null;
    }
    /**
     * 根据选择框内容确定商圈
     * @param cb 选择框
     * @return
     */
    public static TradeArea getArea(ComboBox cb){
        if(cb.getSelectionModel().getSelectedItem()=="长江")
            return TradeArea.Changjiang;
        if(cb.getSelectionModel().getSelectedItem()=="黄河")
            return TradeArea.Huanghe;
        if(cb.getSelectionModel().getSelectedItem()=="南海")
            return TradeArea.Nanhai;
        return null;
    }
    /**
     * 根据选择框内容确定地址
     * @param cb 选择框
     * @return
     */
    public static Address getAddress(ComboBox cb){
        if(cb.getSelectionModel().getSelectedItem()=="南京")
            return Address.Nanjing;
        if(cb.getSelectionModel().getSelectedItem()=="上海")
            return Address.Shanghai;
        if(cb.getSelectionModel().getSelectedItem()=="北京")
            return Address.Beijing;
        if(cb.getSelectionModel().getSelectedItem()=="天津")
            return Address.Tianjing;
        if(cb.getSelectionModel().getSelectedItem()=="广东")
            return Address.Guangdong;
        if(cb.getSelectionModel().getSelectedItem()=="澳门")
            return Address.Aomen;
        return null;
    }
    /**
     * 获取日期
     * @param ld 日期选取器
     * @return Date格式的日期
     */
    public static Date getDate(DatePicker ld) throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        return sdf.parse(ld.getValue().toString());
    }

    /**
     * 商圈转换为中文字符串
     * @param tradeArea 商圈
     * @return 字符串格式的商圈
     */
    public static String tradeAreaTOString(TradeArea tradeArea){
        if(tradeArea==TradeArea.Changjiang)
            return "长江";
        else if(tradeArea==TradeArea.Huanghe)
            return  "黄河";
        else if(tradeArea==TradeArea.Nanhai)
            return  "南海";
        else return null;
    }

    /**
     * 地址转换为中文字符串
     * @param address 地址
     * @return 中文字符串格式的地址
     */
    public static String addressTOString(Address address){
        if(address==Address.Aomen)
            return "澳门";
        else if(address==Address.Beijing)
            return  "北京";
        else if(address==Address.Shanghai)
            return "上海";
        else if(address==Address.Guangdong)
            return "广东";
        else if(address==Address.Nanjing)
            return "南京";
        else if(address==Address.Tianjing)
            return "天津";
        else return null;
    }
}

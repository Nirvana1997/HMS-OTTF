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
        DateFormat df = new SimpleDateFormat("yyyy_MM_dd");
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

}

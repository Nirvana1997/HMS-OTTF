package autoManage;

import database.DataBaseHelper;

/**
 * Created by mac on 2016/12/12.
 */
public class ManageRoomNum {
    /**
     * 静态方法：后台（数据库）自动更新每个酒店未来空房间数量表，
     * 并删除以前的空房间数量表
     * @param day 时间间隔
     * @param hotelID 酒店ID
     */
    public static void update(int day ,String hotelID){
        DataBaseHelper.in(
                "create event if not exists " + hotelID + "_event" +
                        " on schedule every 1 day"+
                        " starts '2016-12-15 00:00:00'" +
                        " on completion preserve" +
                        " do" +
                        " begin" +
                        " set @y = year(date_sub(curdate(),interval -" + day + " day));" +
                        " set @m = month(date_sub(curdate(),interval -" + day + " day));" +
                        " set @d = day(date_sub(curdate(),interval -" + day + " day));" +
                        " set @num1 = (select number from " + hotelID + "_roomInfo where type = 'SingleRoom');" +
                        " set @num2 = (select number from " + hotelID + "_roomInfo where type = 'DoubleRoom');" +
                        " set @num3 = (select number from " + hotelID + "_roomInfo where type = 'DisabledRoom');" +
                        " set @sqlCreate = concat('create table " + hotelID + "_'" + ",@y,'_',@m,'_',@d,'( type varchar(50),emptyNum int )');" +
                        " set @sql1 = concat(\"insert into " + hotelID + "_\"" + ",@y,\"_\",@m,\"_\",@d,\" (type,emptyNum) values ('SingleRoom','\",@num1,\"')\");" +
                        " set @sql2 = concat(\"insert into " + hotelID + "_\"" + ",@y,\"_\",@m,\"_\",@d,\" (type,emptyNum) values ('DoubleRoom','\",@num2,\"')\");" +
                        " set @sql3 = concat(\"insert into " + hotelID + "_\"" + ",@y,\"_\",@m,\"_\",@d,\" (type,emptyNum) values ('DisabledRoom','\",@num3,\"')\");" +
                        " set @y = year(date_sub(curdate(),interval 1 day));" +
                        " set @m = month(date_sub(curdate(),interval 1 day));" +
                        " set @d = day(date_sub(curdate(),interval 1 day));" +
                        " set @sqlDrop = concat('drop table " + hotelID + "_'" + ",@y,'_',@m,'_',@d);" +
                        " prepare stmt0 from @sqlCreate;" +
                        " execute stmt0;" +
                        " prepare stmt1 from @sql1;" +
                        " execute stmt1;" +
                        " prepare stmt2 from @sql2;" +
                        " execute stmt2;" +
                        " prepare stmt3 from @sql3;" +
                        " execute stmt3;" +
                        " prepare stmt4 from @sqlDrop;" +
                        " execute stmt4;" +
                        " end "
        );
    }
}

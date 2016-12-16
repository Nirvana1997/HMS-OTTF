package autoManage;

import database.DataBaseHelper;

/**
 * Created by mac on 2016/12/15.
 */
public class ManageExceptionOrder {
    /**
     * 静态方法，服务器后台设置的触发器，每天20点触发，检测当天
     * 应该执行但未执行的订单，并将其状态置为异常
     */
    public static void init(){
        DataBaseHelper.in(
                "create event if not exists ExceptionListener_event" +
                        " on schedule every 1 day"+
                        " starts '2016-12-20 20:00:00'" +
                        " on completion preserve" +
                        " do" +
                        " begin" +
                        " set @y = year(curdate());" +
                        " set @m = month(curdate());" +
                        " set @d = day(curdate());" +
                        " set @sql = concat('update OrderInfo set orderState = 'exception' where orderState = 'executing' and where checkInDate = '',@y,'_',@m,'_',@d,''');" +
                        " prepare stmt from @sql;" +
                        " execute stmt;" +
                        " end "
        );
    }
}

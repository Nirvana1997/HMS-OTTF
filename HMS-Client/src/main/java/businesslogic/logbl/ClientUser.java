package businesslogic.logbl;

/**
 * 负责获取当前登录用户的信息
 * @author qzh
 * Created by user on 2016/12/2.
 */
public class ClientUser {
    private static ClientUser clientUser;

    /**
     * 当前用户
     */
    private static String nowUser;

    private ClientUser(){

    }

    public static ClientUser getInstance() {
        if(clientUser==null)
            clientUser = new ClientUser();
        return clientUser;
    }

    /**
     * 获取当前登录用户帐号
     * @return 当前登录用户帐号
     */
    public static String getNowUser(){
        return nowUser;
    }

    /**
     * 设置当前登录帐号
     * @param userID 用户ID
     */
    public static void setNowUser(String userID){
        nowUser = userID;
    }
}

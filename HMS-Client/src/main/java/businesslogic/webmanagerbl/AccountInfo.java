package businesslogic.webmanagerbl;

import businesslogic.userbl.UserInfo;
import com.sun.jmx.remote.internal.RMIExporter;
import enumData.AccountType;
import vo.AccountVO;
import vo.HotelinfoVO;
import vo.UserInfoVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * 帐号数据接口
 *
 * @author qzh
 *         Created by user on 2016/12/3.
 */
public interface AccountInfo {
    /**
     * 获取对应类型用户列表
     *
     * @return 对应类型用户帐号列表
     * @throws RemoteException
     */
    public ArrayList<String> getList(AccountType accountType) throws RemoteException;

    /**
     * 添加帐号
     *
     * @param account     帐号
     * @param password    密码
     * @param accountType 帐号类型
     * @throws RemoteException
     */
    public void addAccount(String account, String password, AccountType accountType) throws RemoteException;

    /**
     * 删除帐号
     *
     * @param id 编号
     * @throws RemoteException
     */
    public void deleteAccount(String id) throws RemoteException;

    /**
     * 获得对应id编号
     *
     * @param account 帐号
     * @return 对应id编号
     * @throws RemoteException
     */
    public String getID(String account) throws RemoteException;
}

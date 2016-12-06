package businesslogic.webmanagerbl;

import businesslogic.userbl.UserInfo;
import com.sun.jmx.remote.internal.RMIExporter;
import enumData.AccountType;
import vo.HotelinfoVO;
import vo.UserInfoVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * 获取对应类型的帐号列表
 * @author qzh
 * Created by user on 2016/12/3.
 */
public interface AccountList {
    /**
     * 获取对应类型用户列表
     * @return 对应类型用户帐号列表
     * @throws RemoteException
     */
    public ArrayList<String> getList(AccountType accountType)throws RemoteException;
}

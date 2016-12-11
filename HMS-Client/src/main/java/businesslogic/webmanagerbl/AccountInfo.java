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
 * @author qzh
 * Created by user on 2016/12/3.
 */
public interface AccountInfo {
    /**
     * 获取对应类型用户列表
     * @return 对应类型用户帐号列表
     * @throws RemoteException
     */
    public ArrayList<String> getList(AccountType accountType)throws RemoteException;

    /**
     * 添加帐号
     * @param vo 帐号vo
     * @throws RemoteException
     */
    public void addAccount(AccountVO vo)throws RemoteException;
}

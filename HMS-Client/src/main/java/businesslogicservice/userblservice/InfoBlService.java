package businesslogicservice.userblservice;

import businesslogic.userbl.UserInfo;
import enumData.ResultMessage;
import vo.CreditRecordVO;
import vo.UserInfoVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * 个人信息接口
 *
 * @author qzh
 */
public interface InfoBlService {
    /**
     * 修改个人信息
     *
     * @param vo 个人信息
     * @return
     * @throws RemoteException
     */
    public ResultMessage modifyUserInfo(UserInfoVO vo) throws RemoteException;

    /**
     * 显示个人信息
     *
     * @return 个人信息
     * @throws RemoteException
     */
    public UserInfoVO showUserInfo() throws RemoteException;

    /**
     * 显示用户信用记录
     *
     * @return 用户信用记录列表
     * @throws RemoteException
     */
    public ArrayList<CreditRecordVO> showCreditRecords() throws RemoteException;

    /**
     * 获得所有企业
     *
     * @return 所有企业名称
     * @throws RemoteException
     */
    public ArrayList<String> showAllCompanys() throws RemoteException;

    /**
     * 判断企业ID与企业名称是否对应
     *
     * @param companyID   企业ID
     * @param companyName 企业名称
     * @return 是否对应
     * @throws RemoteException
     */
    public boolean isCompanyIDCorrect(String companyID, String companyName) throws RemoteException;
}

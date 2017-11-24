package com.supermarket.yun.platform.slowloris.service.system;

import com.supermarket.yun.platform.slowloris.common.ICommonService;
import com.supermarket.yun.platform.slowloris.common.query.data.Page;
import com.supermarket.yun.platform.slowloris.domain.system.UserOnline;

import java.util.Date;
import java.util.List;

/**
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/22 0:15
 */
public interface IUserOnlineService extends ICommonService<UserOnline> {

    /**
     * 上线
     *
     * @param userOnline
     */
    public void online(UserOnline userOnline);

    /**
     * 下线
     *
     * @param sid
     */
    public void offline(String sid);

    /**
     * 批量下线
     *
     * @param needOfflineIdList
     */
    public void batchOffline(List<String> needOfflineIdList);

    /**
     * 无效的UserOnline
     *
     * @return
     */
    public Page<UserOnline> findExpiredUserOnlineList(Date expiredDate, int page, int rows);

}

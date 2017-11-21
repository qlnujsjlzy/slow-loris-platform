package com.supermarket.yun.platform.slowloris.service.system.impl;

import com.supermarket.yun.platform.slowloris.common.query.data.Page;
import com.supermarket.yun.platform.slowloris.common.query.data.PageImpl;
import com.supermarket.yun.platform.slowloris.common.query.data.PageRequest;
import com.supermarket.yun.platform.slowloris.common.query.data.Pageable;
import com.supermarket.yun.platform.slowloris.common.query.wrapper.EntityWrapper;
import com.supermarket.yun.platform.slowloris.common.utils.IpUtils;
import com.supermarket.yun.platform.slowloris.common.utils.ServletUtils;
import com.supermarket.yun.platform.slowloris.common.utils.StringUtils;
import com.supermarket.yun.platform.slowloris.domain.system.UserOnline;
import com.supermarket.yun.platform.slowloris.mapper.system.UserOnlineMapper;
import com.supermarket.yun.platform.slowloris.service.common.impl.CommonServiceImpl;
import com.supermarket.yun.platform.slowloris.service.security.realm.UserRealm.Principal;
import com.supermarket.yun.platform.slowloris.service.system.IUserOnlineService;
import com.supermarket.yun.platform.slowloris.service.utils.UserUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/22 0:11
 */
@Service("userOnlineService")
public class UserOnlineServiceImpl extends CommonServiceImpl<UserOnlineMapper, UserOnline>
        implements IUserOnlineService {

    /**
     * 上线
     *
     * @param userOnline
     */
    public void online(UserOnline userOnline) {
        if (StringUtils.isEmpty(userOnline.getHost())) {
            String hostIp = IpUtils.getIpAddr(ServletUtils.getRequest());
            userOnline.setHost(hostIp);
        }
        Principal principal = UserUtils.getPrincipal(); // 如果已经登录，则跳转到管理首页
        userOnline.setUsername(principal.getUsername());
        userOnline.setUserId(principal.getId());
        UserOnline oldOnline = selectById(userOnline.getId());
        if (oldOnline != null) {
            insertOrUpdate(userOnline);
        } else {
            insert(userOnline);
        }
    }

    /**
     * 下线
     *
     * @param sid
     */
    public void offline(String sid) {
        UserOnline userOnline = selectById(sid);
        if (userOnline != null) {
            deleteById(userOnline.getId());
        }
    }

    /**
     * 批量下线
     *
     * @param needOfflineIdList
     */
    public void batchOffline(List<String> needOfflineIdList) {
        deleteBatchIds(needOfflineIdList);
    }

    /**
     * 无效的UserOnline
     *
     * @return
     */
    public Page<UserOnline> findExpiredUserOnlineList(Date expiredDate, int page, int rows) {
        com.baomidou.mybatisplus.plugins.Page<UserOnline> userOnlinePage = new com.baomidou.mybatisplus.plugins.Page<UserOnline>(page, rows);
        EntityWrapper<UserOnline> wrapper = new EntityWrapper<UserOnline>(UserOnline.class);
        wrapper.lt("lastAccessTime", expiredDate);
        wrapper.orderBy("lastAccessTime");
        List<UserOnline> content = baseMapper.selectUserOnlinePage(userOnlinePage, wrapper);
        Integer total = baseMapper.selectCount(wrapper);
        Pageable pageable = new PageRequest(page, rows);
        return new PageImpl<UserOnline>(content, pageable, total);
    }

}

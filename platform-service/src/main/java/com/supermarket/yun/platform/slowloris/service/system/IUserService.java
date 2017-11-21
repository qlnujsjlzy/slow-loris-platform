package com.supermarket.yun.platform.slowloris.service.system;

import com.supermarket.yun.platform.slowloris.domain.system.User;
import com.supermarket.yun.platform.slowloris.service.common.ICommonService;

/**
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/22 0:17
 */
public interface IUserService extends ICommonService<User> {
    /**
     * 修改密码
     *
     * @param userId
     * @param newPassword
     */
    public void changePassword(String userId, String newPassword);

    /**
     * 根据用户名查找用户
     *
     * @param username
     * @return
     */
    public User findByUsername(String username);

    /**
     * 根据 email 查找用户
     *
     * @param email
     * @return
     */
    public User findByEmail(String email);

    /**
     * 根据 phone查找用户
     *
     * @param phone
     * @return
     */
    public User findByPhone(String phone);

}

package com.supermarket.yun.platform.slowloris.service.system.impl;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.supermarket.yun.platform.slowloris.common.impl.CommonServiceImpl;
import com.supermarket.yun.platform.slowloris.common.query.wrapper.EntityWrapper;
import com.supermarket.yun.platform.slowloris.common.utils.StringUtils;
import com.supermarket.yun.platform.slowloris.domain.system.User;
import com.supermarket.yun.platform.slowloris.domain.system.UserOrganization;
import com.supermarket.yun.platform.slowloris.domain.system.UserRole;
import com.supermarket.yun.platform.slowloris.mapper.system.UserMapper;
import com.supermarket.yun.platform.slowloris.service.system.IUserOrganizationService;
import com.supermarket.yun.platform.slowloris.service.system.IUserRoleService;
import com.supermarket.yun.platform.slowloris.service.system.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/22 0:12
 */
@Transactional
@Service("userService")
public class UserServiceImpl extends CommonServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    PasswordService passwordService;
    @Autowired
    private IUserOrganizationService userOrganizationService;
    @Autowired
    private IUserRoleService userRoleService;

    @Override
    public void changePassword(String userid, String newPassword) {
        User user = selectById(userid);
        if (user != null) {
            user.setPassword(newPassword);
            passwordService.encryptPassword(user);
        }
        insertOrUpdate(user);
    }

    @Override
    public User findByUsername(String username) {
        if (StringUtils.isEmpty(username)) {
            return null;
        }
        return selectOne(new EntityWrapper<User>(User.class).eq("username", username));
    }

    @Override
    public User findByEmail(String email) {
        if (StringUtils.isEmpty(email)) {
            return null;
        }
        return selectOne(new EntityWrapper<User>(User.class).eq("email", email));
    }

    @Override
    public User findByPhone(String phone) {
        if (StringUtils.isEmpty(phone)) {
            return null;
        }
        return selectOne(new EntityWrapper<User>(User.class).eq("phone", phone));
    }

    @Override
    public boolean insert(User user) {
        passwordService.encryptPassword(user);
        return super.insert(user);
    }

    @Override
    public boolean deleteById(Serializable id) {
        // 删除角色关联
        userRoleService.delete(new EntityWrapper<UserRole>(UserRole.class).eq("userId", id));
        // 删除部门关联
        userOrganizationService.delete(new EntityWrapper<UserOrganization>(UserOrganization.class).eq("userId", id));
        return super.deleteById(id);
    }

    @Override
    public boolean deleteBatchIds(List<? extends Serializable> idList) {
        for(Object id : idList) {
            this.deleteById((Serializable) id);
        }
        return true;
    }

    @Override
    public Page<User> selectPage(Page<User> page, Wrapper<User> wrapper) {
        wrapper.eq("1", "1");
        page.setRecords(baseMapper.selectUserList(page, wrapper));
        return page;
    }

}

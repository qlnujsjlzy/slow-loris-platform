package com.supermarket.yun.platform.slowloris.domain.system;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.supermarket.yun.platform.slowloris.common.domain.AbstractEntity;

/**
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/15 20:52
 */
@TableName("sys_user_organization")
public class UserOrganization extends AbstractEntity<String> {

    /**
     * 编号
     */
    @TableId(value = "id", type = IdType.UUID)
    private String id;
    /**
     * 用户编号
     */
    private String userId;
    private User user;
    /**
     * 部门编号
     */
    private String organizationId;
    private Organization organization;

    /**
     * 获取 id
     *
     * @return: String 编号
     */
    public String getId() {
        return this.id;
    }

    /**
     * 设置 id
     *
     * @param: id
     * 编号
     */
    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

}

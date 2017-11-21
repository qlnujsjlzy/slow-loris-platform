package com.supermarket.yun.platform.slowloris.domain.system;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.supermarket.yun.platform.slowloris.common.domain.BaseEntity;

/**
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/15 20:52
 */
@TableName("sys_role_menu")
public class RoleMenu extends BaseEntity {

    /**
     * 编号
     */
    @TableId(value = "id", type = IdType.UUID)
    private String id;
    /**
     * 菜单编号
     */
    private String menuId;
    /**
     * 角色编号
     */
    private String roleId;

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

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

}

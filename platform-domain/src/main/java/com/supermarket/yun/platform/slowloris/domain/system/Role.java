package com.supermarket.yun.platform.slowloris.domain.system;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.supermarket.yun.platform.slowloris.domain.common.DataEntity;

/**
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/15 20:52
 */
@TableName("sys_role")
public class Role extends DataEntity<String> {
    @TableId(value = "id", type = IdType.UUID)
    private String id;
    @TableField(value = "name")
    private String name;// 角色名称
    @TableField(value = "code")
    private String code;// 角色编码
    @TableField(value = "is_sys")
    private String isSys;// 是否系统数据
    @TableField(value = "usable")
    private String usable;// 是否可用

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getIsSys() {
        return isSys;
    }

    public void setIsSys(String isSys) {
        this.isSys = isSys;
    }

    public String getUsable() {
        return usable;
    }

    public void setUsable(String usable) {
        this.usable = usable;
    }

}

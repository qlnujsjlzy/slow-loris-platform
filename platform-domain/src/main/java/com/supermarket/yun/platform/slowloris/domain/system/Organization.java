package com.supermarket.yun.platform.slowloris.domain.system;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.supermarket.yun.platform.slowloris.domain.common.TreeEntity;

import java.util.Date;

/**
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/15 20:52
 */
@TableName("sys_organization")
public class Organization extends TreeEntity<Organization> {
    @TableField(value = "create_by", el = "createBy.id", fill = FieldFill.INSERT)
    private User createBy; // 创建者
    @TableField(value = "create_date", fill = FieldFill.INSERT)
    private Date createDate; // 创建日期
    @TableField(value = "update_by", el = "updateBy.id", fill = FieldFill.UPDATE)
    private User updateBy; // 更新者
    @TableField(value = "update_date", fill = FieldFill.UPDATE)
    private Date updateDate; // 更新日期
    @TableField(value = "del_flag", fill = FieldFill.INSERT)
    private String delFlag = "0"; // 删除标记（0：正常；1：删除 ）
    @TableField(value = "remarks")
    private String remarks; //备注

    public User getCreateBy() {
        return createBy;
    }

    public void setCreateBy(User createBy) {
        this.createBy = createBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public User getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(User updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

}

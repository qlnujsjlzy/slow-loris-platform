package com.supermarket.yun.platform.slowloris.domain.module;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;
import com.supermarket.yun.platform.slowloris.common.domain.AbstractEntity;

import java.util.Date;

/**
* @Title: address
* @Description: 收货地址
* @author licy13
* @date 2017-11-24 23:27:37
* @version V1.0
*
*/
@TableName("address")
public class Address extends AbstractEntity<Integer> {
    /**地址编码*/
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**收货人*/
    @TableField(value = "name")
    private String name;
    /**手机号*/
    @TableField(value = "phone")
    private String phone;
    /**省*/
    @TableField(value = "province")
    private String province;
    /**市*/
    @TableField(value = "city")
    private String city;
    /**区*/
    @TableField(value = "region")
    private String region;
    /**社区编码*/
    @TableField(value = "community_id")
    private Integer communityId;
    /**社区名称*/
    @TableField(value = "community_name")
    private String communityName;
    /**街道门牌号*/
    @TableField(value = "street")
    private String street;
    /**默认地址*/
    @TableField(value = "is_default")
    private Integer isDefault;
    /**创建人*/
    @TableField(value = "create_by",fill =FieldFill.INSERT)
    private String createBy;
    /**创建时间*/
    @TableField(value = "create_time")
    private Date createTime;
    /**更新人*/
    @TableField(value = "update_by",fill = FieldFill.UPDATE)
    private String updateBy;
    /**更新时间*/
    @TableField(value = "update_time")
    private Date updateTime;
    /**状态标记（1：正常；2：删除）*/
    @TableField(value = "flag")
    private Integer flag;



    public boolean isIdNull() {
        if (id == null) {
            return true;
        }
        return false;
    }
    /**
    * 获取  id
    *@return: Integer  地址编码
    */
    public Integer getId(){
      return this.id;
    }

    /**
    * 设置  id
    *@param: id  地址编码
    */
    public void setId(Integer id){
      this.id = id;
    }


    /**
    * 获取  name
    *@return: String  收货人
    */
    public String getName(){
      return this.name;
    }

    /**
    * 设置  name
    *@param: name  收货人
    */
    public void setName(String name){
      this.name = name;
    }


    /**
    * 获取  phone
    *@return: String  手机号
    */
    public String getPhone(){
      return this.phone;
    }

    /**
    * 设置  phone
    *@param: phone  手机号
    */
    public void setPhone(String phone){
      this.phone = phone;
    }


    /**
    * 获取  province
    *@return: String  省
    */
    public String getProvince(){
      return this.province;
    }

    /**
    * 设置  province
    *@param: province  省
    */
    public void setProvince(String province){
      this.province = province;
    }


    /**
    * 获取  city
    *@return: String  市
    */
    public String getCity(){
      return this.city;
    }

    /**
    * 设置  city
    *@param: city  市
    */
    public void setCity(String city){
      this.city = city;
    }


    /**
    * 获取  region
    *@return: String  区
    */
    public String getRegion(){
      return this.region;
    }

    /**
    * 设置  region
    *@param: region  区
    */
    public void setRegion(String region){
      this.region = region;
    }


    /**
    * 获取  communityId
    *@return: Integer  社区编码
    */
    public Integer getCommunityId(){
      return this.communityId;
    }

    /**
    * 设置  communityId
    *@param: communityId  社区编码
    */
    public void setCommunityId(Integer communityId){
      this.communityId = communityId;
    }


    /**
    * 获取  communityName
    *@return: String  社区名称
    */
    public String getCommunityName(){
      return this.communityName;
    }

    /**
    * 设置  communityName
    *@param: communityName  社区名称
    */
    public void setCommunityName(String communityName){
      this.communityName = communityName;
    }


    /**
    * 获取  street
    *@return: String  街道门牌号
    */
    public String getStreet(){
      return this.street;
    }

    /**
    * 设置  street
    *@param: street  街道门牌号
    */
    public void setStreet(String street){
      this.street = street;
    }


    /**
    * 获取  isDefault
    *@return: Integer  默认地址
    */
    public Integer getIsDefault(){
      return this.isDefault;
    }

    /**
    * 设置  isDefault
    *@param: isDefault  默认地址
    */
    public void setIsDefault(Integer isDefault){
      this.isDefault = isDefault;
    }


    /**
    * 获取  createBy
    *@return: String  创建人
    */
    public String getCreateBy(){
      return this.createBy;
    }

    /**
    * 设置  createBy
    *@param: createBy  创建人
    */
    public void setCreateBy(String createBy){
      this.createBy = createBy;
    }


    /**
    * 获取  createTime
    *@return: Date  创建时间
    */
    public Date getCreateTime(){
      return this.createTime;
    }

    /**
    * 设置  createTime
    *@param: createTime  创建时间
    */
    public void setCreateTime(Date createTime){
      this.createTime = createTime;
    }


    /**
    * 获取  updateBy
    *@return: String  更新人
    */
    public String getUpdateBy(){
      return this.updateBy;
    }

    /**
    * 设置  updateBy
    *@param: updateBy  更新人
    */
    public void setUpdateBy(String updateBy){
      this.updateBy = updateBy;
    }


    /**
    * 获取  updateTime
    *@return: Date  更新时间
    */
    public Date getUpdateTime(){
      return this.updateTime;
    }

    /**
    * 设置  updateTime
    *@param: updateTime  更新时间
    */
    public void setUpdateTime(Date updateTime){
      this.updateTime = updateTime;
    }


    /**
    * 获取  flag
    *@return: Integer  状态标记（1：正常；2：删除）
    */
    public Integer getFlag(){
      return this.flag;
    }

    /**
    * 设置  flag
    *@param: flag  状态标记（1：正常；2：删除）
    */
    public void setFlag(Integer flag){
      this.flag = flag;
    }

}

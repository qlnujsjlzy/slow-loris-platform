package com.supermarket.yun.platform.slowloris.domain.bill;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;
import com.supermarket.yun.platform.slowloris.common.domain.AbstractEntity;

import java.util.Date;

/**
* @Title: bill
* @Description: 账单
* @author licy13
* @date 2017-11-25 00:15:27
* @version V1.0
*
*/
@TableName("bill")
public class Bill extends AbstractEntity<Integer> {
    /**账单编码*/
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**商铺编码*/
    @TableField(value = "shop_id")
    private Integer shopId;
    /**商铺名称*/
    @TableField(value = "shop_name")
    private String shopName;
    /**账单类型（1：自营 2：代理 3：全部）*/
    @TableField(value = "bill_type")
    private Integer billType;
    /**订单总数*/
    @TableField(value = "order_num")
    private Integer orderNum;
    /**账单日期（2017-11-11）*/
    @TableField(value = "bill_date")
    private String billDate;
    /**总收入*/
    @TableField(value = "total_income")
    private Double totalIncome;
    /**创建人*/
    @TableField(value = "create_by",fill =FieldFill.INSERT)
    private String createBy;
    /**创建时间*/
    @TableField(value = "create_time")
    private Date createTime;



    public boolean isIdNull() {
        if (id == null) {
            return true;
        }
        return false;
    }
    /**
    * 获取  id
    *@return: Integer  账单编码
    */
    public Integer getId(){
      return this.id;
    }

    /**
    * 设置  id
    *@param: id  账单编码
    */
    public void setId(Integer id){
      this.id = id;
    }


    /**
    * 获取  shopId
    *@return: Integer  商铺编码
    */
    public Integer getShopId(){
      return this.shopId;
    }

    /**
    * 设置  shopId
    *@param: shopId  商铺编码
    */
    public void setShopId(Integer shopId){
      this.shopId = shopId;
    }


    /**
    * 获取  shopName
    *@return: String  商铺名称
    */
    public String getShopName(){
      return this.shopName;
    }

    /**
    * 设置  shopName
    *@param: shopName  商铺名称
    */
    public void setShopName(String shopName){
      this.shopName = shopName;
    }


    /**
    * 获取  billType
    *@return: Integer  账单类型（1：自营 2：代理 3：全部）
    */
    public Integer getBillType(){
      return this.billType;
    }

    /**
    * 设置  billType
    *@param: billType  账单类型（1：自营 2：代理 3：全部）
    */
    public void setBillType(Integer billType){
      this.billType = billType;
    }


    /**
    * 获取  orderNum
    *@return: Integer  订单总数
    */
    public Integer getOrderNum(){
      return this.orderNum;
    }

    /**
    * 设置  orderNum
    *@param: orderNum  订单总数
    */
    public void setOrderNum(Integer orderNum){
      this.orderNum = orderNum;
    }


    /**
    * 获取  billDate
    *@return: String  账单日期（2017-11-11）
    */
    public String getBillDate(){
      return this.billDate;
    }

    /**
    * 设置  billDate
    *@param: billDate  账单日期（2017-11-11）
    */
    public void setBillDate(String billDate){
      this.billDate = billDate;
    }


    /**
    * 获取  totalIncome
    *@return: Double  总收入
    */
    public Double getTotalIncome(){
      return this.totalIncome;
    }

    /**
    * 设置  totalIncome
    *@param: totalIncome  总收入
    */
    public void setTotalIncome(Double totalIncome){
      this.totalIncome = totalIncome;
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

}

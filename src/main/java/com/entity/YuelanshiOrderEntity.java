package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 阅览室座位预约
 *
 * @author 
 * @email
 */
@TableName("yuelanshi_order")
public class YuelanshiOrderEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public YuelanshiOrderEntity() {

	}

	public YuelanshiOrderEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 订单号
     */
    @ColumnInfo(comment="订单号",type="varchar(200)")
    @TableField(value = "yuelanshi_order_uuid_number")

    private String yuelanshiOrderUuidNumber;


    /**
     * 阅览室
     */
    @ColumnInfo(comment="阅览室",type="int(11)")
    @TableField(value = "yuelanshi_id")

    private Integer yuelanshiId;


    /**
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 实付价格
     */
    @ColumnInfo(comment="实付价格",type="decimal(10,2)")
    @TableField(value = "yuelanshi_order_true_price")

    private Double yuelanshiOrderTruePrice;


    /**
     * 订单类型
     */
    @ColumnInfo(comment="订单类型",type="int(11)")
    @TableField(value = "yuelanshi_order_types")

    private Integer yuelanshiOrderTypes;


    /**
     * 房间
     */
    @ColumnInfo(comment="房间",type="int(11)")
    @TableField(value = "buy_section_number")

    private Integer buySectionNumber;


    /**
     * 预约的座位
     */
    @ColumnInfo(comment="预约的座位",type="varchar(200)")
    @TableField(value = "buy_zuowei_number")

    private String buyZuoweiNumber;


    /**
     * 订购日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat
    @ColumnInfo(comment="订购日期",type="date")
    @TableField(value = "buy_yuelanshi_time")

    private Date buyYuelanshiTime;


    /**
     * 订单创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="订单创建时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 设置：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：订单号
	 */
    public String getYuelanshiOrderUuidNumber() {
        return yuelanshiOrderUuidNumber;
    }
    /**
	 * 设置：订单号
	 */

    public void setYuelanshiOrderUuidNumber(String yuelanshiOrderUuidNumber) {
        this.yuelanshiOrderUuidNumber = yuelanshiOrderUuidNumber;
    }
    /**
	 * 获取：阅览室
	 */
    public Integer getYuelanshiId() {
        return yuelanshiId;
    }
    /**
	 * 设置：阅览室
	 */

    public void setYuelanshiId(Integer yuelanshiId) {
        this.yuelanshiId = yuelanshiId;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }
    /**
	 * 设置：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：实付价格
	 */
    public Double getYuelanshiOrderTruePrice() {
        return yuelanshiOrderTruePrice;
    }
    /**
	 * 设置：实付价格
	 */

    public void setYuelanshiOrderTruePrice(Double yuelanshiOrderTruePrice) {
        this.yuelanshiOrderTruePrice = yuelanshiOrderTruePrice;
    }
    /**
	 * 获取：订单类型
	 */
    public Integer getYuelanshiOrderTypes() {
        return yuelanshiOrderTypes;
    }
    /**
	 * 设置：订单类型
	 */

    public void setYuelanshiOrderTypes(Integer yuelanshiOrderTypes) {
        this.yuelanshiOrderTypes = yuelanshiOrderTypes;
    }
    /**
	 * 获取：房间
	 */
    public Integer getBuySectionNumber() {
        return buySectionNumber;
    }
    /**
	 * 设置：房间
	 */

    public void setBuySectionNumber(Integer buySectionNumber) {
        this.buySectionNumber = buySectionNumber;
    }
    /**
	 * 获取：预约的座位
	 */
    public String getBuyZuoweiNumber() {
        return buyZuoweiNumber;
    }
    /**
	 * 设置：预约的座位
	 */

    public void setBuyZuoweiNumber(String buyZuoweiNumber) {
        this.buyZuoweiNumber = buyZuoweiNumber;
    }
    /**
	 * 获取：订购日期
	 */
    public Date getBuyYuelanshiTime() {
        return buyYuelanshiTime;
    }
    /**
	 * 设置：订购日期
	 */

    public void setBuyYuelanshiTime(Date buyYuelanshiTime) {
        this.buyYuelanshiTime = buyYuelanshiTime;
    }
    /**
	 * 获取：订单创建时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：订单创建时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "YuelanshiOrder{" +
            ", id=" + id +
            ", yuelanshiOrderUuidNumber=" + yuelanshiOrderUuidNumber +
            ", yuelanshiId=" + yuelanshiId +
            ", yonghuId=" + yonghuId +
            ", yuelanshiOrderTruePrice=" + yuelanshiOrderTruePrice +
            ", yuelanshiOrderTypes=" + yuelanshiOrderTypes +
            ", buySectionNumber=" + buySectionNumber +
            ", buyZuoweiNumber=" + buyZuoweiNumber +
            ", buyYuelanshiTime=" + DateUtil.convertString(buyYuelanshiTime,"yyyy-MM-dd") +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}

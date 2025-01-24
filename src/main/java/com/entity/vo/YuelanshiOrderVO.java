package com.entity.vo;

import com.entity.YuelanshiOrderEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 阅览室座位预约
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("yuelanshi_order")
public class YuelanshiOrderVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 订单号
     */

    @TableField(value = "yuelanshi_order_uuid_number")
    private String yuelanshiOrderUuidNumber;


    /**
     * 阅览室
     */

    @TableField(value = "yuelanshi_id")
    private Integer yuelanshiId;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 实付价格
     */

    @TableField(value = "yuelanshi_order_true_price")
    private Double yuelanshiOrderTruePrice;


    /**
     * 订单类型
     */

    @TableField(value = "yuelanshi_order_types")
    private Integer yuelanshiOrderTypes;


    /**
     * 房间
     */

    @TableField(value = "buy_section_number")
    private Integer buySectionNumber;


    /**
     * 预约的座位
     */

    @TableField(value = "buy_zuowei_number")
    private String buyZuoweiNumber;


    /**
     * 订购日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "buy_yuelanshi_time")
    private Date buyYuelanshiTime;


    /**
     * 订单创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间 show3
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：订单号
	 */
    public String getYuelanshiOrderUuidNumber() {
        return yuelanshiOrderUuidNumber;
    }


    /**
	 * 获取：订单号
	 */

    public void setYuelanshiOrderUuidNumber(String yuelanshiOrderUuidNumber) {
        this.yuelanshiOrderUuidNumber = yuelanshiOrderUuidNumber;
    }
    /**
	 * 设置：阅览室
	 */
    public Integer getYuelanshiId() {
        return yuelanshiId;
    }


    /**
	 * 获取：阅览室
	 */

    public void setYuelanshiId(Integer yuelanshiId) {
        this.yuelanshiId = yuelanshiId;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：实付价格
	 */
    public Double getYuelanshiOrderTruePrice() {
        return yuelanshiOrderTruePrice;
    }


    /**
	 * 获取：实付价格
	 */

    public void setYuelanshiOrderTruePrice(Double yuelanshiOrderTruePrice) {
        this.yuelanshiOrderTruePrice = yuelanshiOrderTruePrice;
    }
    /**
	 * 设置：订单类型
	 */
    public Integer getYuelanshiOrderTypes() {
        return yuelanshiOrderTypes;
    }


    /**
	 * 获取：订单类型
	 */

    public void setYuelanshiOrderTypes(Integer yuelanshiOrderTypes) {
        this.yuelanshiOrderTypes = yuelanshiOrderTypes;
    }
    /**
	 * 设置：房间
	 */
    public Integer getBuySectionNumber() {
        return buySectionNumber;
    }


    /**
	 * 获取：房间
	 */

    public void setBuySectionNumber(Integer buySectionNumber) {
        this.buySectionNumber = buySectionNumber;
    }
    /**
	 * 设置：预约的座位
	 */
    public String getBuyZuoweiNumber() {
        return buyZuoweiNumber;
    }


    /**
	 * 获取：预约的座位
	 */

    public void setBuyZuoweiNumber(String buyZuoweiNumber) {
        this.buyZuoweiNumber = buyZuoweiNumber;
    }
    /**
	 * 设置：订购日期
	 */
    public Date getBuyYuelanshiTime() {
        return buyYuelanshiTime;
    }


    /**
	 * 获取：订购日期
	 */

    public void setBuyYuelanshiTime(Date buyYuelanshiTime) {
        this.buyYuelanshiTime = buyYuelanshiTime;
    }
    /**
	 * 设置：订单创建时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：订单创建时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间 show3
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show3
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}

package com.entity.model;

import com.entity.YuelanshiOrderEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 阅览室座位预约
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class YuelanshiOrderModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 订单号
     */
    private String yuelanshiOrderUuidNumber;


    /**
     * 阅览室
     */
    private Integer yuelanshiId;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 实付价格
     */
    private Double yuelanshiOrderTruePrice;


    /**
     * 订单类型
     */
    private Integer yuelanshiOrderTypes;


    /**
     * 房间
     */
    private Integer buySectionNumber;


    /**
     * 预约的座位
     */
    private String buyZuoweiNumber;


    /**
     * 订购日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date buyYuelanshiTime;


    /**
     * 订单创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间 show3
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
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
	 * 获取：创建时间 show3
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show3
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }

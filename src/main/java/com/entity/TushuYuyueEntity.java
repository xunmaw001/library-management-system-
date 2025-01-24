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
 * 图书归还申请
 *
 * @author 
 * @email
 */
@TableName("tushu_yuyue")
public class TushuYuyueEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public TushuYuyueEntity() {

	}

	public TushuYuyueEntity(T t) {
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
     * 图书
     */
    @ColumnInfo(comment="图书",type="int(11)")
    @TableField(value = "tushu_id")

    private Integer tushuId;


    /**
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 理由
     */
    @ColumnInfo(comment="理由",type="text")
    @TableField(value = "tushu_yuyue_text")

    private String tushuYuyueText;


    /**
     * 报名状态
     */
    @ColumnInfo(comment="报名状态",type="int(11)")
    @TableField(value = "tushu_yuyue_yesno_types")

    private Integer tushuYuyueYesnoTypes;


    /**
     * 审核回复
     */
    @ColumnInfo(comment="审核回复",type="text")
    @TableField(value = "tushu_yuyue_yesno_text")

    private String tushuYuyueYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="审核时间",type="timestamp")
    @TableField(value = "tushu_yuyue_shenhe_time")

    private Date tushuYuyueShenheTime;


    /**
     * 活动报名时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="活动报名时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间  listShow
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
	 * 获取：图书
	 */
    public Integer getTushuId() {
        return tushuId;
    }
    /**
	 * 设置：图书
	 */

    public void setTushuId(Integer tushuId) {
        this.tushuId = tushuId;
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
	 * 获取：理由
	 */
    public String getTushuYuyueText() {
        return tushuYuyueText;
    }
    /**
	 * 设置：理由
	 */

    public void setTushuYuyueText(String tushuYuyueText) {
        this.tushuYuyueText = tushuYuyueText;
    }
    /**
	 * 获取：报名状态
	 */
    public Integer getTushuYuyueYesnoTypes() {
        return tushuYuyueYesnoTypes;
    }
    /**
	 * 设置：报名状态
	 */

    public void setTushuYuyueYesnoTypes(Integer tushuYuyueYesnoTypes) {
        this.tushuYuyueYesnoTypes = tushuYuyueYesnoTypes;
    }
    /**
	 * 获取：审核回复
	 */
    public String getTushuYuyueYesnoText() {
        return tushuYuyueYesnoText;
    }
    /**
	 * 设置：审核回复
	 */

    public void setTushuYuyueYesnoText(String tushuYuyueYesnoText) {
        this.tushuYuyueYesnoText = tushuYuyueYesnoText;
    }
    /**
	 * 获取：审核时间
	 */
    public Date getTushuYuyueShenheTime() {
        return tushuYuyueShenheTime;
    }
    /**
	 * 设置：审核时间
	 */

    public void setTushuYuyueShenheTime(Date tushuYuyueShenheTime) {
        this.tushuYuyueShenheTime = tushuYuyueShenheTime;
    }
    /**
	 * 获取：活动报名时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：活动报名时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间  listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间  listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "TushuYuyue{" +
            ", id=" + id +
            ", tushuId=" + tushuId +
            ", yonghuId=" + yonghuId +
            ", tushuYuyueText=" + tushuYuyueText +
            ", tushuYuyueYesnoTypes=" + tushuYuyueYesnoTypes +
            ", tushuYuyueYesnoText=" + tushuYuyueYesnoText +
            ", tushuYuyueShenheTime=" + DateUtil.convertString(tushuYuyueShenheTime,"yyyy-MM-dd") +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}

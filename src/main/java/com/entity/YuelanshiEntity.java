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
 * 阅览室
 *
 * @author 
 * @email
 */
@TableName("yuelanshi")
public class YuelanshiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public YuelanshiEntity() {

	}

	public YuelanshiEntity(T t) {
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
     * 阅览室名称
     */
    @ColumnInfo(comment="阅览室名称",type="varchar(200)")
    @TableField(value = "yuelanshi_name")

    private String yuelanshiName;


    /**
     * 阅览室照片
     */
    @ColumnInfo(comment="阅览室照片",type="varchar(200)")
    @TableField(value = "yuelanshi_photo")

    private String yuelanshiPhoto;


    /**
     * 阅览室类型
     */
    @ColumnInfo(comment="阅览室类型",type="int(11)")
    @TableField(value = "yuelanshi_types")

    private Integer yuelanshiTypes;


    /**
     * 房间
     */
    @ColumnInfo(comment="房间",type="int(11)")
    @TableField(value = "section_number")

    private Integer sectionNumber;


    /**
     * 座位
     */
    @ColumnInfo(comment="座位",type="int(11)")
    @TableField(value = "zuowei_number")

    private Integer zuoweiNumber;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "yuelanshi_delete")

    private Integer yuelanshiDelete;


    /**
     * 阅览室简介
     */
    @ColumnInfo(comment="阅览室简介",type="text")
    @TableField(value = "yuelanshi_content")

    private String yuelanshiContent;


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
	 * 获取：阅览室名称
	 */
    public String getYuelanshiName() {
        return yuelanshiName;
    }
    /**
	 * 设置：阅览室名称
	 */

    public void setYuelanshiName(String yuelanshiName) {
        this.yuelanshiName = yuelanshiName;
    }
    /**
	 * 获取：阅览室照片
	 */
    public String getYuelanshiPhoto() {
        return yuelanshiPhoto;
    }
    /**
	 * 设置：阅览室照片
	 */

    public void setYuelanshiPhoto(String yuelanshiPhoto) {
        this.yuelanshiPhoto = yuelanshiPhoto;
    }
    /**
	 * 获取：阅览室类型
	 */
    public Integer getYuelanshiTypes() {
        return yuelanshiTypes;
    }
    /**
	 * 设置：阅览室类型
	 */

    public void setYuelanshiTypes(Integer yuelanshiTypes) {
        this.yuelanshiTypes = yuelanshiTypes;
    }
    /**
	 * 获取：房间
	 */
    public Integer getSectionNumber() {
        return sectionNumber;
    }
    /**
	 * 设置：房间
	 */

    public void setSectionNumber(Integer sectionNumber) {
        this.sectionNumber = sectionNumber;
    }
    /**
	 * 获取：座位
	 */
    public Integer getZuoweiNumber() {
        return zuoweiNumber;
    }
    /**
	 * 设置：座位
	 */

    public void setZuoweiNumber(Integer zuoweiNumber) {
        this.zuoweiNumber = zuoweiNumber;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getYuelanshiDelete() {
        return yuelanshiDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setYuelanshiDelete(Integer yuelanshiDelete) {
        this.yuelanshiDelete = yuelanshiDelete;
    }
    /**
	 * 获取：阅览室简介
	 */
    public String getYuelanshiContent() {
        return yuelanshiContent;
    }
    /**
	 * 设置：阅览室简介
	 */

    public void setYuelanshiContent(String yuelanshiContent) {
        this.yuelanshiContent = yuelanshiContent;
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
        return "Yuelanshi{" +
            ", id=" + id +
            ", yuelanshiName=" + yuelanshiName +
            ", yuelanshiPhoto=" + yuelanshiPhoto +
            ", yuelanshiTypes=" + yuelanshiTypes +
            ", sectionNumber=" + sectionNumber +
            ", zuoweiNumber=" + zuoweiNumber +
            ", yuelanshiDelete=" + yuelanshiDelete +
            ", yuelanshiContent=" + yuelanshiContent +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}

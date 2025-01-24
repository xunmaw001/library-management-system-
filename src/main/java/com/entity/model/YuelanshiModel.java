package com.entity.model;

import com.entity.YuelanshiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 阅览室
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class YuelanshiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 阅览室名称
     */
    private String yuelanshiName;


    /**
     * 阅览室照片
     */
    private String yuelanshiPhoto;


    /**
     * 阅览室类型
     */
    private Integer yuelanshiTypes;


    /**
     * 房间
     */
    private Integer sectionNumber;


    /**
     * 座位
     */
    private Integer zuoweiNumber;


    /**
     * 逻辑删除
     */
    private Integer yuelanshiDelete;


    /**
     * 阅览室简介
     */
    private String yuelanshiContent;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }

package com.entity.vo;

import com.entity.YuelanshiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 阅览室
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("yuelanshi")
public class YuelanshiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 阅览室名称
     */

    @TableField(value = "yuelanshi_name")
    private String yuelanshiName;


    /**
     * 阅览室照片
     */

    @TableField(value = "yuelanshi_photo")
    private String yuelanshiPhoto;


    /**
     * 阅览室类型
     */

    @TableField(value = "yuelanshi_types")
    private Integer yuelanshiTypes;


    /**
     * 房间
     */

    @TableField(value = "section_number")
    private Integer sectionNumber;


    /**
     * 座位
     */

    @TableField(value = "zuowei_number")
    private Integer zuoweiNumber;


    /**
     * 逻辑删除
     */

    @TableField(value = "yuelanshi_delete")
    private Integer yuelanshiDelete;


    /**
     * 阅览室简介
     */

    @TableField(value = "yuelanshi_content")
    private String yuelanshiContent;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 设置：阅览室名称
	 */
    public String getYuelanshiName() {
        return yuelanshiName;
    }


    /**
	 * 获取：阅览室名称
	 */

    public void setYuelanshiName(String yuelanshiName) {
        this.yuelanshiName = yuelanshiName;
    }
    /**
	 * 设置：阅览室照片
	 */
    public String getYuelanshiPhoto() {
        return yuelanshiPhoto;
    }


    /**
	 * 获取：阅览室照片
	 */

    public void setYuelanshiPhoto(String yuelanshiPhoto) {
        this.yuelanshiPhoto = yuelanshiPhoto;
    }
    /**
	 * 设置：阅览室类型
	 */
    public Integer getYuelanshiTypes() {
        return yuelanshiTypes;
    }


    /**
	 * 获取：阅览室类型
	 */

    public void setYuelanshiTypes(Integer yuelanshiTypes) {
        this.yuelanshiTypes = yuelanshiTypes;
    }
    /**
	 * 设置：房间
	 */
    public Integer getSectionNumber() {
        return sectionNumber;
    }


    /**
	 * 获取：房间
	 */

    public void setSectionNumber(Integer sectionNumber) {
        this.sectionNumber = sectionNumber;
    }
    /**
	 * 设置：座位
	 */
    public Integer getZuoweiNumber() {
        return zuoweiNumber;
    }


    /**
	 * 获取：座位
	 */

    public void setZuoweiNumber(Integer zuoweiNumber) {
        this.zuoweiNumber = zuoweiNumber;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getYuelanshiDelete() {
        return yuelanshiDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setYuelanshiDelete(Integer yuelanshiDelete) {
        this.yuelanshiDelete = yuelanshiDelete;
    }
    /**
	 * 设置：阅览室简介
	 */
    public String getYuelanshiContent() {
        return yuelanshiContent;
    }


    /**
	 * 获取：阅览室简介
	 */

    public void setYuelanshiContent(String yuelanshiContent) {
        this.yuelanshiContent = yuelanshiContent;
    }
    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}

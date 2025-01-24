package com.entity.vo;

import com.entity.TushuYuyueEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 图书归还申请
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("tushu_yuyue")
public class TushuYuyueVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 图书
     */

    @TableField(value = "tushu_id")
    private Integer tushuId;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 理由
     */

    @TableField(value = "tushu_yuyue_text")
    private String tushuYuyueText;


    /**
     * 报名状态
     */

    @TableField(value = "tushu_yuyue_yesno_types")
    private Integer tushuYuyueYesnoTypes;


    /**
     * 审核回复
     */

    @TableField(value = "tushu_yuyue_yesno_text")
    private String tushuYuyueYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "tushu_yuyue_shenhe_time")
    private Date tushuYuyueShenheTime;


    /**
     * 活动报名时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间 show3 listShow
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
	 * 设置：图书
	 */
    public Integer getTushuId() {
        return tushuId;
    }


    /**
	 * 获取：图书
	 */

    public void setTushuId(Integer tushuId) {
        this.tushuId = tushuId;
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
	 * 设置：理由
	 */
    public String getTushuYuyueText() {
        return tushuYuyueText;
    }


    /**
	 * 获取：理由
	 */

    public void setTushuYuyueText(String tushuYuyueText) {
        this.tushuYuyueText = tushuYuyueText;
    }
    /**
	 * 设置：报名状态
	 */
    public Integer getTushuYuyueYesnoTypes() {
        return tushuYuyueYesnoTypes;
    }


    /**
	 * 获取：报名状态
	 */

    public void setTushuYuyueYesnoTypes(Integer tushuYuyueYesnoTypes) {
        this.tushuYuyueYesnoTypes = tushuYuyueYesnoTypes;
    }
    /**
	 * 设置：审核回复
	 */
    public String getTushuYuyueYesnoText() {
        return tushuYuyueYesnoText;
    }


    /**
	 * 获取：审核回复
	 */

    public void setTushuYuyueYesnoText(String tushuYuyueYesnoText) {
        this.tushuYuyueYesnoText = tushuYuyueYesnoText;
    }
    /**
	 * 设置：审核时间
	 */
    public Date getTushuYuyueShenheTime() {
        return tushuYuyueShenheTime;
    }


    /**
	 * 获取：审核时间
	 */

    public void setTushuYuyueShenheTime(Date tushuYuyueShenheTime) {
        this.tushuYuyueShenheTime = tushuYuyueShenheTime;
    }
    /**
	 * 设置：活动报名时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：活动报名时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show3 listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
